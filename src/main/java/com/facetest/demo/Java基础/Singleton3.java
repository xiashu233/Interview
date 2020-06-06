package com.facetest.demo.Java基础;

/**
 * 单例模式实现方式 3
 * 双重校验锁
 */
public class Singleton3 {

    // volatile 修饰符修饰变量可见性，告诉线程每次操作这个变量时都会从主存读取
    private volatile static Singleton3 singleton ;

    private Singleton3(){

    }

    public static Singleton3 getSingleton(){
        if (singleton == null){
            synchronized (Singleton3.class){
                if (singleton == null)
                    singleton = new Singleton3();
            }
        }
        return singleton;
    }
}
    