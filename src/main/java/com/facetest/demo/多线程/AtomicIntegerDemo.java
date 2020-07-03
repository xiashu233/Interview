package com.facetest.demo.多线程;

import java.sql.Connection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    /**
     * 线程安全的Integer类型，保证原子性操作
     */
    private static int countInt = 0;
    private static AtomicInteger count = new AtomicInteger(0);
    /**
     * 每个线程之间的副本 比如对于数据库之间的连接 其实是每个线程之间不共享独立的
     * 否则 线程A关闭了数据库连接 线程B就没法正常操作数据库了
     * private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal();
     */
    private static ThreadLocal<String> countLocal = new ThreadLocal();
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                countInt ++;
                count.getAndIncrement();
                countLocal.set("1");
            }).start();
        }

        Thread.sleep(500);





        System.out.println("线程安全的int类型：" + count + "---非线程安全的int类型：" + countInt);
        System.out.println(countLocal.get());
    }
}
