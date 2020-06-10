package com.facetest.demo.Mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facetest.demo.Mybatis.bean.Student;
//import tk.mybatis.mapper.common.Mapper;

/**
 * 继承通用Mapper，实现了简单的增删改单表操作 ×
 * 继承MybatisPlus √
 */
public interface StudentMapper extends BaseMapper<Student> {

    Student selectStudentByNameAndAgeJ(String name,Integer age);

    Student selectStudentByNameAndAgeD(String name,Integer age);



}
