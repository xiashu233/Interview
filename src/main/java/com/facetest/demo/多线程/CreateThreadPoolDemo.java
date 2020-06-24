package com.facetest.demo.多线程;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateThreadPoolDemo {

    public static void main(String[] args) {
        /**
         * SynchronousQueue 超出核心队列时扩充核心线程 扩容超出最大线程数时报错
         * LinkedBlockingQueue 链表堵塞队列 : 不受最大线程数影响，超出核心线程时加入等待队列 核心线程复用。可以初始化等待队列大小（默认 Integer.MaxValue），超出大小则抛出异常 java.util.concurrent.RejectedExecutionException:
         *
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
                                                            10,
                                                            10, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "is Running!!!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.execute(runnable1);
            executor.execute(runnable1);
            executor.execute(runnable1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("核心线程数：" + executor.getCorePoolSize());
            System.out.println("总线程数量：" + executor.getPoolSize());
            System.out.println("任务队列总数：" + executor.getQueue().size());
        }
        // int -2^31 ~ 2^32
        System.out.println( Integer.MIN_VALUE + "--" + Integer.MAX_VALUE + "--" + (long)(Math.pow(2,31) - 1));
        long l = -1;
        System.out.println( Double.MIN_VALUE);
        executor.shutdown();




    }
}
