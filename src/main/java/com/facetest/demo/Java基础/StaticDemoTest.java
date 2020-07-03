package com.facetest.demo.Java基础;

public class StaticDemoTest {
    static {
        System.out.println("静态代码块开始");

    }

    public StaticDemoTest() {
        System.out.println("构造方法开始");
       float a = 1.1F;
       String s = "";


    }

    public static void test1(){
        System.out.println("静态方法");
    }


}
