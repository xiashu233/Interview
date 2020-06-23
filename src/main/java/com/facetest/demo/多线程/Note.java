package com.facetest.demo.多线程;

/**
 * @author XiaShu
 */
public class Note {

    public static void main(String[] args) {
        final Object o = new Object();
        char[] aT = "ABCDEFG".toCharArray();
        char[] aC = "123456".toCharArray();

        boolean t1Start = false;

        new Thread(()->{
            synchronized (o){
                for (char c : aT) {
                    System.out.println(c);

                    try {
                        // 提醒等待队列中随机一条线程醒
                        o.notify();
                        // 线程等待 加入等待队列 让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 如果不加人此条语句 两个线程则总会有一个线程在等待队列 程序无法停止
                    o.notify();
                }
            }
        },"t1").start();


        new Thread(()->{
            synchronized (o){
                for (char c : aC) {
                    System.out.println(c);

                    try {
                        // 提醒等待队列中随机一条线程醒
                        o.notify();
                        // 线程等待 加入等待队列 让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 如果不加人此条语句 两个线程则总会有一个线程在等待队列 程序无法停止
                    o.notify();
                }
                o.notify();
            }
        },"t2").start();


    }
}
