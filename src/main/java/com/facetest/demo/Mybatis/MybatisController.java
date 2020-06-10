package com.facetest.demo.Mybatis;

import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.bean.Teacher;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.mapper.TeacherMapper;
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
    TeacherMapper teacherMapper;

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

}
