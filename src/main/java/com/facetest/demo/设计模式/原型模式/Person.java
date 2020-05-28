package com.facetest.demo.设计模式.原型模式;

import java.io.Serializable;

public class Person implements Serializable,Cloneable {
    private String name;
    private Integer age;
    private WorkExeperience work = new WorkExeperience();
    public Person( ){

    }
    public Person(WorkExeperience work) throws CloneNotSupportedException {
        this.work = (WorkExeperience) work.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setWork(String workDate,String company){
        work.setWorkDate(workDate);
        work.setCompany(company);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person obj = new Person(this.work);
        obj.setName(this.name);
        obj.setAge(this.age);
        return obj;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work=" + work.toString() +
                '}';
    }
}
