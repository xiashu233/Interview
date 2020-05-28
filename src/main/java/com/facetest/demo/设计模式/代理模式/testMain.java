package com.facetest.demo.设计模式.代理模式;

public class testMain {
    public static void main(String[] args) {
        SchoolGril mm = new SchoolGril();
        mm.setName("娇娇");
        Proxy proxy = new Proxy(mm);
        proxy.giveChocolate();

        // HashSet
    }
}
