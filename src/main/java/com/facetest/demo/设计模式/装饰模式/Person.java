package com.facetest.demo.设计模式.装饰模式;

public class Person {
    private String name;

    public Person(){

    }
    public Person(String name){
        this.name = name;
    }

    public void Show(){
        System.out.println("装扮的" + name);
    }
}
