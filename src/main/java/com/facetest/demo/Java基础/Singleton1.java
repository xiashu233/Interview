package com.facetest.demo.Java基础;

/**
 * 单例模式实现方式 1
 */
public class Singleton1 {

    private Singleton1(){

    }
    private final static Singleton1 singleton = new Singleton1();

    public static Singleton1 getSingleton(){
        return singleton;
    }


}
    