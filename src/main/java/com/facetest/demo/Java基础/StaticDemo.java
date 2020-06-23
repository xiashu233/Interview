package com.facetest.demo.Java基础;


/**
 * 静态代码块可以有多个 根据出现的先后顺序执行 在静态代码块中调用的静态变量不能在该代码块下面
 * @author XiaShu
 */
public class StaticDemo {

    private static int i;

    static {
        i = 10;
        System.out.println(i);
    }

    public static void main(String[] args) {

        System.out.println(i);
    }

}
