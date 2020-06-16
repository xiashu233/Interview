package com.facetest.demo.Java基础;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@Slf4j
public  class testMain {
    public static void main(String[] args) throws Exception {
        //StringBuffer
        //  Thread;
//        System.out.println("Hello World");
//        // int[] a = new int[2147483646];
//
//        for (int i = 2871322; i < Integer.MAX_VALUE; i+=100) {
//            int[] a = new int[i];
//            System.out.println(i);
//        }

//        BigDecimal bigDecimal = new BigDecimal(23.456);
//        BigDecimal bigDecimal1 = new BigDecimal("23.456");
//        System.out.println(bigDecimal);
//        System.out.println(bigDecimal1);
//        System.out.println( bigDecimal.compareTo(bigDecimal1));

        // 减少实例化对象的开销
//        Date startDate = new Date();
//        for (int i = 0; i < 10000000; i++) {
//            Date date = new Date();
//        }
//        Date endDate = new Date();
//        System.out.println(endDate.getTime() - startDate.getTime());
//
//        Date startDate1 = new Date();
//        Date date1;
//        for (int i = 0; i < 10000000; i++) {
//            date1 = new Date();
//        }
//        Date endDate1 = new Date();
//        System.out.println(endDate1.getTime() - startDate1.getTime());

        // Math.round 大于0.5向上取整
//        System.out.println(Math.round(-24.6));
//        System.out.println(Math.round(-32.2));

        System.out.println(new String("通话").hashCode() + "--" + new String("重地").hashCode());

//        List<String> list = new ArrayList();
//        for (int i = 0; i < 651; i++) {
//            list.add("1");
//        }
//        int pageSize = 0;
//        if (pageSize <= 0) {
//            log.error("发生错误 分页页数小于0");
//            // throw new HdException(ErrorCode.PageSizeException);
//        }
//
//        System.out.println(subList(list,pageSize));



    }

    private static List subList(List list,int pageSize){
        // 方法中定义的常量可以两段式赋值
        final String a;
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
        concurrentLinkedDeque.add("the");
        Object poll = concurrentLinkedDeque.poll();


        Map m;
        Stack stack;
        LinkedList lk = new LinkedList();
        lk.add("add");
        lk.add("this");
        lk.add("proper");
        lk.add(1,"insert");


        int pageCount = list.size();
        List subList = new ArrayList();
        List subTo;
        for (int i = 0; i < pageCount; i+= pageSize) {
            subTo = i + pageSize > pageCount? list.subList(i,i + (pageCount%pageSize)): list.subList(i,i+pageSize);
            subList.add(subTo);
        }
        return subList;
    }
}
