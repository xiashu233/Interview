package com.facetest.demo.Java基础;

import java.nio.charset.Charset;

public class Test {

    public static void main(String[] args) {

        String s = new String("爱丽舍空间的".getBytes(), Charset.forName("UTF-8"));

        // TODO Auto-generated method stub
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        Test.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

        // 成员变量会自动赋值，局部变量不会自动赋值，在使用前必须要给定一个值 否者使用的时候就会报 可能尚未初始化变量
//        int a;
//        System.out.println(a);
    }

    /**
     * 方法并不能使传入的引用类型重新引用其他值 但是可以改变其内在值
     * @param x Student
     * @param y Student
     */
    public static void swap(Student x, Student y) {
        // 与预想情况不一样 对象引用并没有被改变
        // Student temp = x;
        // x = y;
        // y = temp;
        x.setName("小李");
        y.setName("小张");
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }
}
