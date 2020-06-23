package com.facetest.demo.设计模式.单例模式;

import com.facetest.demo.Response.ErrorCode;

public class testMain {

    public static void main(String[] args) {

        SingletonEnum.Singleton.sayHello();

        System.out.println(ErrorCode.OK.toString());
    }
}
