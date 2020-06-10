package com.facetest.demo.Mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facetest.demo.Mybatis.bean.Teacher;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> selectAllTeacherAndTheStudent();

    

}
