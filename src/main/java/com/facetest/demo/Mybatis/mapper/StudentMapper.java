package com.facetest.demo.Mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.facetest.demo.Java基础.IService;
import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.stereotype.Component;
//import tk.mybatis.mapper.common.Mapper;

/**
 * 继承通用Mapper，实现了简单的增删改单表操作 ×
 * 继承MybatisPlus √
 */
public interface StudentMapper extends BaseMapper<Student> {


}
