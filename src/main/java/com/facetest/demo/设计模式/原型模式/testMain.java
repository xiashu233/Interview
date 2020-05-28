package com.facetest.demo.设计模式.原型模式;

public class testMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(12);
        person.setWork("2020-5-20","腾讯");

        Person clone = (Person)person.clone();
        clone.setWork("2020-5-20","阿里");
        // person.setName("李四");
        System.out.println(person.toString());
        System.out.println(clone.toString());

    }
}
