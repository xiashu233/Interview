package com.facetest.demo.POI;

import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.utils.ListUtil;
import com.facetest.demo.utils.ZipUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用Apache POI 生成Excel
 */
@RestController
public class POIDemo {


    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("testExcel")
    public void testExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Student> students = studentMapper.selectAll();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("班级所有学生信息");
            HSSFRow row = sheet.createRow(0);
            Field[] declaredFields = Student.class.getDeclaredFields();
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                row.createCell(i).setCellValue(declaredFields[i].getName());
            }
            // 排序 按照 StuAge 升序  reversed 降序
            students.sort(Comparator.comparing(Student::getStuAge).reversed());

            // System.out.println(students);

            int size = students.size();
            HSSFRow commRow = null;
            for (int i = 0; i < size; i++) {
                Student student = students.get(i);
                commRow = sheet.createRow(i + 1);
                for (int j = 0; j < length; j++) {
                    commRow.createCell(j).setCellValue(getFieldValueByName(declaredFields[j].getName(),student).toString());
                }
            }

            OutputStream output = null;
            // 输出Excel文件供网页下载
            output = response.getOutputStream();
            // 输出到本地
            // output = new FileOutputStream("D://test.xls");
            // 清空缓冲区 以便填充数据
            response.reset();

            // 设置文件头
            response.setHeader("Content-Disposition",
                    "attchement;filename=" + new String("学生信息.xls".getBytes("gb2312"), "ISO8859-1"));
            response.setContentType("application/msexcel");

            wb.write(output);
            // 刷新此输出流，强制写出所有缓冲的输出字节
            output.flush();
            output.close();
            wb.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 将查询记录进行分页导出Excel最后压缩成Zip
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("batchExcel")
    public String batchExcel(HttpServletRequest request,HttpServletResponse response){
        String path = System.getProperty("user.dir")+ "\\src\\main\\resources\\excels\\";
        long time = new Date().getTime();
        List<String> fileList = new ArrayList<>();
        // 防止并发量过高导致文件名相同 前缀加上 memberId
        int memberId = (int) (Math.random() * 100 );
        try {
            List<Student> students = new ArrayList<>();
            // 模拟数据库数据
            for (int i = 0; i < 192658; i++) {
                students.add(new Student(1,"张三",23,"随机人物"));
            }

            List<List<Student>> studentPages = ListUtil.subList(students, 1000);
            for (int index = 0; index < studentPages.size(); index++) {

                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("班级所有学生信息");
                HSSFRow row = sheet.createRow(0);
                Field[] declaredFields = Student.class.getDeclaredFields();
                int length = declaredFields.length;
                for (int i = 0; i < length; i++) {
                    row.createCell(i).setCellValue(declaredFields[i].getName());
                }

                int size = studentPages.get(index).size();
                HSSFRow commRow = null;
                for (int i = 0; i < size; i++) {
                    Student student = studentPages.get(index).get(i);
                    commRow = sheet.createRow(i + 1);
                    for (int j = 0; j < length; j++) {
                        commRow.createCell(j).setCellValue(getFieldValueByName(declaredFields[j].getName(),student).toString());
                    }
                }

                OutputStream output = null;

                // 输出到本地
                String filePath =  path + memberId + (time + index) + ".xls";
                output = new FileOutputStream(filePath);
                fileList.add(filePath);
                // 清空缓冲区 以便填充数据
                response.reset();

                wb.write(output);
                // 刷新此输出流，强制写出所有缓冲的输出字节
                output.flush();
                output.close();
                wb.close();
            }

            ZipUtil.downloadZipFiles(response,fileList,"StudentInfoZip");

            // 删除文件
            for (String thisFile : fileList) {
                File file = new File(thisFile);
                file.delete();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return path;
    }

    /**
     * 根据属性名获取属性值
     * @param fieldName 字段名
     * @param o 传入获取值的对象
     * @return
     */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {

            return null;
        }
    }


}
