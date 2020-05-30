package com.facetest.demo.Java基础;

/**
 * 单例模式实现方式 2
 */
public class Singleton2 {

    private Singleton2(){

    }
    private static Singleton2 singleton = null;

    public static Singleton2 getSingleton(){
        if (singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }

}
