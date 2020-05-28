package com.facetest.demo.Java基础;

public class FinalFunction {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println(sayHello(stringBuffer));
        System.out.println(stringBuffer);
    }

    static String sayHello(final StringBuffer sb){
        sb.append("abc");
        // Cannot assign a value to final variable 'sb'
        // sb = new StringBuffer("aaa");
        return sb.toString();
    }
}
