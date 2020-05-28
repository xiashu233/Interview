package com.facetest.demo.Mybatis.mapper;

import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * 继承通用Mapper，实现了简单的增删改单表操作
 */
public interface StudentMapper extends Mapper<Student> {

}
