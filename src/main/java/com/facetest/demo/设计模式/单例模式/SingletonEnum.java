package com.facetest.demo.设计模式.单例模式;

public enum SingletonEnum {
    // 枚举实现的单例模式
    Singleton;

    public void sayHello(){
        System.out.println("枚举项实现的单例模式");
    }
}
