package com.facetest.demo.多线程;

public class SleepAndWaitDemo {
    public static void main(String[] args) {
        Object o = new Object();

        new Thread(()->{
            synchronized (o){
                System.out.println("线程1进行第一步操作");
                System.out.println("线程1进行Wait");
                // 线程休眠之后 线程复苏的时候还是从该位置开始
                try {
                    // wait 是属于 Object类中的一个非静态方法 使用时可以使线程休眠 让出锁 进入等待队列

                    o.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1执行完毕");
            }
        },"线程1").start();


        new Thread(()->{
            synchronized (o){
                System.out.println("线程2进行第一步操作");
                System.out.println("线程2进行第二步操作");

                System.out.println("线程2执行完毕");
            }
        },"线程1").start();
    }
}
