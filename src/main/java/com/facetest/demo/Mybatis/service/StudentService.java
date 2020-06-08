package com.facetest.demo.Mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.stereotype.Component;

/**
 * 继承 MybatisPlus 的通用IService接口
 */
public interface StudentService extends IService<Student> {
}
