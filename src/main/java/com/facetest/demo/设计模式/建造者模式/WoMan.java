package com.facetest.demo.设计模式.建造者模式;

public class WoMan extends Person{

    @Override
    void createHead() {
        System.out.println("乌黑靓丽的长发");
    }

    @Override
    void createBody() {
        System.out.println("身材姣好的身体");
    }

    @Override
    void createFooter() {
        System.out.println("凉鞋");
    }

}
