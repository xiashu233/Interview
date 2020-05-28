package com.facetest.demo.设计模式.建造者模式;

public class Man extends Person {

    @Override
    void createHead() {
        System.out.println("平板短发");
    }

    @Override
    void createBody() {
        System.out.println("健壮身体");
    }

    @Override
    void createFooter() {
        System.out.println("商务皮鞋");
    }
}
