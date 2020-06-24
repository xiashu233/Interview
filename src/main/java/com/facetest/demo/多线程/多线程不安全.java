package com.facetest.demo.多线程;

public class 多线程不安全 {
    // 多线程情况下无法保证变量的实时更新
    // private static boolean flag = false;
    /**
     * 使用 volatile 关键字修饰变量时当变量内容发生修改将会通知线程更新内容
     */
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("线程1启动，判断资源是否准备完毕");
            while (!flag){}
            System.out.println("资源准备完毕，线程1开始调用资源");
        },"线程1").start();

        Thread.sleep(1000);

        new Thread(()->{
            System.out.println("准备资源");
            readProperties();
            System.out.println("调用方法准备资源完毕");
        },"线程2").start();
    }

    private static void readProperties(){
        System.out.println("方法中开始准备资源");
        flag = true;
        System.out.println("资源准备完毕");
    }
}
