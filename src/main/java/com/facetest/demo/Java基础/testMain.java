package com.facetest.demo.Java基础;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public  class testMain {
    public synchronized static void main(String[] args) throws Exception {
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

        List list = new ArrayList();
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");list.add("1");
        int pageSize = 0;
        if (pageSize <= 0) {
            throw new Exception("每页存放的数据了太小了");
        }

        int pageCount = list.size();
        List subList = new ArrayList();
        List subTo;
        for (int i = 0; i < pageCount; i+= pageSize) {
            if (i + pageSize > pageCount){
                subTo = list.subList(i,i + (pageCount%pageSize));

            }else{
                subTo = list.subList(i,i+pageSize);
            }
            subList.add(subTo);
        }
        System.out.println(subList);


    }
}
