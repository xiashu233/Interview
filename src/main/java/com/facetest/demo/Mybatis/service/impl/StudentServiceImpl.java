package com.facetest.demo.Mybatis.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentServiceImpl extends ServiceImpl<BaseMapper<Student>,Student> implements StudentService {

}
