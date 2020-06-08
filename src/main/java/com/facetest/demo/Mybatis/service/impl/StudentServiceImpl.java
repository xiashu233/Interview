package com.facetest.demo.Mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * Service的实现类
 */
@Component
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {
}
