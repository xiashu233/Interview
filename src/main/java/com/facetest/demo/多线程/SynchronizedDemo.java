package com.facetest.demo.多线程;

/**
 * synchronized 线程同步自动锁 悲观锁
 * 可以保证被该关键字修饰的方法或者代码块同一时刻只有一个线程执行。
 * 在 Java早期版本，synchronized属于重量锁，效率低下
 *
 * 乐观锁：
 * 方法或者代码块同一时刻可以被多个线程执行，但是在执行结束的时候判断一下数据是否发生了改变。比如数据库中用一个version字段判断
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

    }
}
