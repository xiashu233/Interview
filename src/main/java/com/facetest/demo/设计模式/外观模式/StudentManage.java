package com.facetest.demo.设计模式.外观模式;

/**
 * 股票和基金的区别，生成一个管理类其中一个类涉及多个方法。好像是平时开发中的Service层
 */
public class StudentManage {
    Student student;
    Teacher teacher;

    public StudentManage(){
        student = new Student();
        teacher = new Teacher();
    }

    public void onClass(){
        student.onClass();
        teacher.onClass();
    }

    public void unClass(){
        student.unClass();
        teacher.unClass();
    }
}
