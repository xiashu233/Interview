package com.facetest.demo.Mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.facetest.demo.Mybatis.bean.*;
import com.facetest.demo.Mybatis.mapper.OrdersMapper;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.mapper.TeacherMapper;
import com.facetest.demo.Mybatis.service.StudentService;
//import com.github.pagehelper.PageHelper;
import com.facetest.demo.Response.ResponseResultVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/Mybatis")
public class MybatisController {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    OrdersMapper ordersMapper;

//    @Autowired
//    Person person;

    @RequestMapping("testZWF")
    public void testZWF(){
        // 自动映射类型 String 类型自动添加 'xx' 所以不会报错
        Student student1 = studentMapper.selectStudentByNameAndAgeJ("储彬", 18);
        log.info(student1.toString());
        // 因为参数原样插入指定位置 指定的 SQL 如果没有 '${xx}' 则会报错
        Student student2 = studentMapper.selectStudentByNameAndAgeD("储彬", 18);
        log.info(student2.toString());
    }

    @RequestMapping("testOneOfMore")
    public void testOneOfMore(){
        List<Teacher> teachers = teacherMapper.selectAllTeacherAndTheStudent();
        log.info(teachers.toString());

    }

    @RequestMapping("testOneOfOne")
    public void testOneOfOne(){
        List<Orders> orders = ordersMapper.selectOrderAndStudent(1);
        System.out.println(orders.get(0).getOrderId());
        System.out.println(orders.get(0).getStudent().getStuId());
        // log.info(orders.toString());

    }

    @RequestMapping("testInterFaceOverride")
    public void testInterFaceOverride(){
        List<Orders> selects = ordersMapper.selects();
        List<Orders> selects1 = ordersMapper.selects(500);

//        List<Student> list = studentService.list();
        log.info(selects.toString());
        log.info(selects1.toString());
    }

    // 批量操作 具有原子性
    @RequestMapping("testBatchExecutor")
    public void testBatchExecutor(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(6,"ls",10,"hap"));
        students.add(new Student(7,"ls",10,"hap"));
        students.add(new Student(7,"ls",10,"hap"));
        studentService.saveBatch(students);
    }

    /**
     * 不得不说在这里遇到了一个问题，引入MybatisPlus后再使用PageHelp就会发现报错
     * 而不使用PageHelp的时候，会发现分页命令并没有执行，所以我在这里注释掉了PageHelp的Maven依赖
     * MybatisPlus分页也挺好用的 所以没必要使用PageHelp了
     * @param pageNum 页码
     * @param pageSize 页内数量
     * @return 统一返回类型
     * @PageBean 封装的页类型
     */
    @RequestMapping("testPage")
    @ApiOperation(value = "post请求调用示例", notes = "invokePost说明", httpMethod = "POST")
    public ResponseResultVo testPage(int pageNum, int pageSize){
        IPage<Student> studentQueryPage = new Page<>(pageNum,pageSize);
        studentMapper.selectPage(studentQueryPage, null);
        List<Student> students = studentQueryPage.getRecords();
        log.info(students.toString());
        long pages = studentQueryPage.getPages();
        PageBean<List<Student>> pageBean = new PageBean<>(pages,students,pageNum,pageSize,studentQueryPage.getTotal(),pageNum>1,pageNum<pages);

        return ResponseResultVo.success(pageBean);

    }

}
