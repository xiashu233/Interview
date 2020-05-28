package com.facetest.demo.设计模式.外观模式;

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
