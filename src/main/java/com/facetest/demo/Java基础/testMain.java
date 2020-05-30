package com.facetest.demo.Java基础;

import java.math.BigDecimal;

public  class testMain {
    public synchronized static void main(String[] args) {
        //StringBuffer
        //  Thread;
//        System.out.println("Hello World");
//        // int[] a = new int[2147483646];
//
//        for (int i = 2871322; i < Integer.MAX_VALUE; i+=100) {
//            int[] a = new int[i];
//            System.out.println(i);
//        }

        BigDecimal bigDecimal = new BigDecimal(23.456);
        BigDecimal bigDecimal1 = new BigDecimal("23.456");
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println( bigDecimal.compareTo(bigDecimal1));

    }
}
