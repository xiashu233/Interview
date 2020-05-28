package com.facetest.demo.POI;

import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

            System.out.println(students);

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
            response.reset();

            // 设置文件头
            response.setHeader("Content-Disposition",
                    "attchement;filename=" + new String("学生信息.xls".getBytes("gb2312"), "ISO8859-1"));
            response.setContentType("application/msexcel");

            wb.write(output);
            output.flush();
            output.close();
            wb.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 根据属性名获取属性值
     * @param fieldName 字段名
     * @param o 传入获取值的对象
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object o) {
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