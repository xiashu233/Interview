package com.facetest.demo.多线程.JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        // 字面意思 setAndGet
        int i = ai.addAndGet(1);

        int oldData = ai.getAndAdd(2);



    }
}
