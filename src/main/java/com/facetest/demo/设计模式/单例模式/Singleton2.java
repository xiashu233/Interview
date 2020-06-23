package com.facetest.demo.设计模式.单例模式;

/**
 * 懒汉式 防止饿汉式单例模式太多了的时候造成的消耗 只在获取的时候判断一下是否被初始化 如果没有则初始化
 * @author XiaShu
 */
public class Singleton2 {
    private static Singleton2 singleton2;

    public static Singleton2 getSingleton(){
        if (singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
