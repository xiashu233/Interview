package com.facetest.demo.Java基础;

public class IntAndInteger {
    public static void main(String[] args) {
        Integer integer1 = new Integer(115);
        Integer integer2 = new Integer(115);
        // valueOf 会使用 Integer 的缓存，-128 ~ 127 如果值在缓存里直接命中返回 不在就new一个对象
        Integer integer3 = Integer.valueOf(-128);
        Integer integer4 = Integer.valueOf(-128);
        System.out.println(integer1 == integer2 );
        // Integer 重写了equals方法
        //      if (obj instanceof Integer) {
        //            return value == ((Integer)obj).intValue();
        //        }
        //        return false;
        System.out.println(integer1.equals(integer2));

        System.out.println(integer3 == integer4 );
        System.out.println(integer3.equals(integer4));
    }
}
