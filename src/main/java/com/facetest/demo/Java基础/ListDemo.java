package com.facetest.demo.Java基础;

import java.util.*;

/**
 * 主要是记录List中ArrayList、LinkedList、Vector的区别
 */
public class ListDemo {

    public static void main(String[] args) {
        // Array 和 List 之间互相转化
        int[] intArray = new int[10];
        // 由于 List 不可以存放基本类型 所以int[] 无法转换成 List<int>
        List<int[]> ints = Arrays.asList(intArray);
        // List 转换为 Array
        Object[] objects = ints.toArray();


        // 可以使用基本类型的包装类 实现正确转换
        Integer[] integerArray = new Integer[10];
        List<Integer> integers = Arrays.asList(integerArray);




        // ArrayList 实现了 RandomAccess 接口 所以支持高效的随机访问
        List arrayList = new ArrayList();
        // linkedList 没有实现 所以不支持
        List linkedList = new LinkedList();
        // Vector 是一个类似于 ArrayList 的一个线程安全的类 但是在线程同步上需要消耗性能 所以不建议使用
        // 也实现了 RandomAccess 接口
        List vector = new Vector();

        // list 的遍历方式
        // 实现了 RandomAccess 接口的优先选择 fori 循环，其次 foreach
        for (int i = 0; i < arrayList.size(); i++) {
            
        }
        // 没有实现 RandomAccess 接口的 优先选择 iterator 循环，size较大的不建议使用 for 循环
        Iterator iterator = linkedList.iterator();


        // 扩容方式
        // ArrayList 默认扩容50% 而 vector 扩容 100%

    }
}
