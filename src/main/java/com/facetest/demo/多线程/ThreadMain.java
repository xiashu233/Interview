package com.facetest.demo.多线程;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadMain {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("调用Runnable");
            }
        }).start();

        // int newCapacity = oldCapacity + (oldCapacity >> 1);
        // ArrayList 默认扩容0.5倍 也就是1.5N

        // Vector 默认扩充一倍 也就是 2N
        // int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
        //                                         capacityIncrement : oldCapacity);

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10);

    }
}
