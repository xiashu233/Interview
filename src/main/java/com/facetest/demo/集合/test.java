package com.facetest.demo.集合;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        // list.toArray 返回的是Object的数组
        // Object[] objects = list.toArray();

        Integer[] ints = new Integer[2];
        list.toArray(ints);
        // 执行 toArray 方法的时候 数组长度不够的时候 其中所有的元素值变为null
        System.out.println(list);
        System.out.println(ints);


    }
}
