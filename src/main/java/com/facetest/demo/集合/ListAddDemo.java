package com.facetest.demo.集合;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ListAddDemo {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        // 复制一个元素的时候可以使用 add
        for (int i = 0; i < 300000; i++) {
            ints.add(i);
        }

        // Collections.sort();

        // 添加一个集合的时候 应该使用 addAll 因为频繁使用add会发生ArrayList内部扩容 导致效率急剧下降
        // 观看addAll的源码可以发现 使用 ensureCapacityInternal(size + numNew); 来检测是否扩容 直接扩容到
        // size 是集合内部元素数 numNew 是添加参数集合的元素数
        long start2 = System.currentTimeMillis();
        System.out.println(start2 - start1);
        List<Integer> int2 = new ArrayList<>();
        int2.addAll(ints);
        long start3 = System.currentTimeMillis();
        System.out.println(start3 - start2);

        // 任何泛型集合使用 toArray 方法生成的数组都是 Object类型
        Object[] objects = int2.toArray();
        // 使用泛型集合的toArray方法入参 指定类型的数组即可实现 toArray返回指定类型
        // 当数组长度不够泛型元素个数时 数组内所有值为null
        // 当数组长度比泛型集合个数多的时候 多出来的数组值为null 而对应的元素为泛型集合元素
        // 所以我们在使用 toArray方法的时候一定要声明一个大于等于泛型集合size 的数组
        Integer[] intArr = new Integer[200];
        int2.toArray(intArr);

        // Java8中所有的集合都加入了一个 foreach 方法 是一个函数声明方法
        // default void forEach(Consumer<? super T> action)
        // 谈谈我对 default 关键字的理解（重构小技巧），首先该关键字的作用作用于接口中的方法上
        // 意思就是该方法接口可内部实现 不需要实现接口的类强行实现 只能说这个关键字好像是
        // 不想修改原本基础的情况下新增功能了 并且规范好了划分区域（因为接口就是一种规范），而类则像是能力的一种继承
        int2.forEach(intValue -> System.out.println(intValue));


    }
}
