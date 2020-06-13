package com.facetest.demo.Java基础;

public class testPlus {
    public static void main(String[] args) {
        int a = 3;

        double d = 1.5;
        double v = a + d;
        // System.out.println();
        int b = (a++) * 3;
        int c = (++a) * 3;
        System.out.println(a + "--" + b + "--" + c);
    }
}
