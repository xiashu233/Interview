package com.facetest.demo.Mybatis;

import com.facetest.demo.Mybatis.bean.Orders;
import com.facetest.demo.Mybatis.bean.Person;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.bean.Teacher;
import com.facetest.demo.Mybatis.mapper.OrdersMapper;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.mapper.TeacherMapper;
import com.facetest.demo.Mybatis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
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
        List<Orders> selects1 = ordersMapper.selects(1);

        List<Student> list = studentService.list();
        log.info(selects.toString());
        log.info(selects1.toString());
    }

}
