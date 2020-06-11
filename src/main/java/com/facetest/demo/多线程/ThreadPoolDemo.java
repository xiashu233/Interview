package com.facetest.demo.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static ScheduledExecutorService scheduledExecutorServiceStatic = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        // 可缓存线程池 可缓存线程池，先查看池中有没有以前建立的线程，如果有，就直接使用。如果没有，就新建一个新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // 可重复使用固定线程个数线程池
        // ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // 单线程池 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定的顺序（FIFO,LIFO,优先级）执行。
        // ExecutorService executorService = Executors.newSingleThreadExecutor();

//        for (int i = 0; i < 10; i++) {
//            executorService.execute(()->{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() );
//            });
//        }

        // 延迟执行
        scheduledExecutorService.schedule(()->{
            System.out.println("延迟三秒后执行的任务");
        },3, TimeUnit.SECONDS);
        
        // 结束线程池
        //executorService.shutdown();
    }
}
