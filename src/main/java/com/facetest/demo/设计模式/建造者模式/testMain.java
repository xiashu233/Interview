package com.facetest.demo.设计模式.建造者模式;

public class testMain {
    public static void main(String[] args) {
        PersonBuilder pr1 = new PersonBuilder(new Man());
        PersonBuilder pr2 = new PersonBuilder(new WoMan());

        pr1.PersonBuilder();
        pr2.PersonBuilder();
        int a = 12;
        
    }
}
