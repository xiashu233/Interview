package com.facetest.demo.Java基础;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str  ="nihao 你好 喬亂";
        // 字符串转化成 byte 数组
        byte[] bytes = str.getBytes("UTF-8");
        // byte 数组转化成字符串
        String ss1 = new String(bytes);
        System.out.println(ss1);

        LinkedList<Object> objects = new LinkedList<>();


        TreeMap<Integer, Object> tm = new TreeMap<Integer, Object>(){
            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        System.out.println(tm.hashCode());

        System.out.println(32&tm.hashCode());

        // TreeMap 根据key来排序
        tm.put(5,"a");
        tm.put(1,"c");
        tm.put(6,"b");
        System.out.println();
        System.out.println(tm);


        String s = new String("爱丽舍空间的".getBytes(), Charset.forName("UTF-8"));

        // TODO Auto-generated method stub
        Student s1 = new Student("小张",12);
        Student s2 = new Student("小李",24);
        Student s3 = new Student("小李",8);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // Collections.sort(students, Comparator.comparing((s,s2) -> s1.getAge()-s2.get));

        System.out.println(students);

        Collections.sort(students);

        System.out.println(students);

//        Test.swap(s1, s2);
//        System.out.println("s1:" + s1.getName());
//        System.out.println("s2:" + s2.getName());

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
