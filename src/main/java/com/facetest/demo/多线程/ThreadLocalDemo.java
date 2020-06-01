package com.facetest.demo.多线程;

/**
 * 线程变量副本
 * 每个线程持有一份 ThreadLocal 变量的副本，初始值为 null
 * 可以在本线程中随意修改。不会影响到原本主线程或其他线程的值
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal();
        String cl = "NewData";
        // System.out.println(new ThreadLocalDemo().getClass().toString());
        tl.set("HelloWorld!");

        new Thread(()->{
            System.out.println("当前访问到的线程本地变量：" + tl.get());
            tl.set(Thread.currentThread().getName());
            // Variable used in lambda expression should be final or effectively final
            // System.out.println(cl);
            System.out.println("修改后的本地变量：" + tl.get());
            // this.getClass()
            // 释放资源 每个线程中存放一个 ThreadLocalMap 保存本线程中 TheadLocal的值
            // ThreadLocal.ThreadLocalMap threadLocals = null;
            // ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue)
            // ThreadLocalMap 是一个key弱引用但是值强引用的例子，不及时释放资源有可能导致内存泄漏
            tl.remove();
        },"线程1").start();

        new Thread(()->{
            System.out.println("当前访问到的线程本地变量：" + tl.get());
            tl.set(Thread.currentThread().getName());
            System.out.println("修改后的本地变量：" + tl.get());

            // 释放资源
            tl.remove();
        },"线程2").start();

        System.out.println("线程执行结束后的本地变量：" + tl.get());
    }
}
