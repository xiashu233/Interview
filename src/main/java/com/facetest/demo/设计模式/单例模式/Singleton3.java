package com.facetest.demo.设计模式.单例模式;

/**
 * 为了防止高并发情况下多次初始化或者未被初始化
 * 双重校验锁懒汉式
 * @author XiaShu
 */
public class Singleton3 {
    /**
     * volatile 修改变量可见性 变量值发生修改的时候从内存中重新读取
     */
    private static volatile Singleton3 singleton3;

    public static Singleton3 getSingleton(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
