package com.facetest.demo.设计模式.单例模式;

/**
 * 饿汉式 类加载的时候就将内部变量初始化 往后调用的时候就不会再初始化或者判断了
 * @author XiaShu
 */
public class Singleton1 {
    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getSingleton(){
        return singleton1;
    }
}
