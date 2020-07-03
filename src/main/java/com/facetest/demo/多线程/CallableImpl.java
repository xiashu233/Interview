package com.facetest.demo.多线程;

import com.facetest.demo.Mybatis.bean.Student;

import java.util.concurrent.Callable;

public class CallableImpl<T> implements Callable<Object> {
    @Override
    public T call() throws Exception {
        System.out.println("执行了实现Callable接口的call方法");
        Student student = new Student();
        student.setStuId(1);
        return (T) student;
    }
}
