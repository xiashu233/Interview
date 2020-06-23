package com.facetest.demo.集合;

import com.facetest.demo.Java基础.Student;

import java.util.*;

/**
 * 这里解决了一个小疑惑 也就是
 * private static final Object[] EMPTY_ELEMENTDATA = {};
 * private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
 * 两者之间的关系 -- 因为在判断是否可以扩容的时候 有一个if判断
 * 使用带参初始化的时候可能会出现 将elementData赋值为 EMPTY_ELEMENTDATA 的情况
 * if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
 * 在这里 DEFAULTCAPACITY_EMPTY_ELEMENTDATA == EMPTY_ELEMENTDATA
 */
public class ArrayListGrowDemo {
    public static void main(String[] args) {

        List list = new ArrayList<Integer>(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        Object[] objects = list.toArray();
        System.out.println(objects.length);

        ListIterator listIterator = list.listIterator();

        while (listIterator.hasPrevious()){
            Object previous = listIterator.previous();
            System.out.println(previous.toString());
        }
        ListIterator listIterator2 = list.listIterator();
        while (listIterator2.hasNext()){
            Object next = listIterator2.next();
            System.out.println(next.toString());
        }

        System.out.println("排序列表");
        List<Student> students = new ArrayList<>();
        students.add(new Student("zs",22));
        students.add(new Student("zs",10));
        students.add(new Student("zs",50));
        Collections.sort(students);
        Collections.reverse(students);
        System.out.println(students);



    }
}
