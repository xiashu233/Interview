package com.facetest.demo.多线程;

/**
 * 线程死锁 A占有a资源 B占有b资源 A占有资源不释放的情况下去请求没有被释放的b资源，两者都相持不下故造成死锁
 */
public class ThreadDie {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        // 为什么我们调用 start 方法启动线程，而不是直接调用线程的 run 方法来执行线程方法。
        // 这个问题其实你知道为什么要用多线程的时候就能解释了，多线程并不是为了让我们实现某功能的工具类或者需要其方法（这个功能我们用任何类都可以完成，完全没必要使用多线程）
        // 多线程实际上就是为了提高 CPU 利用率，启动一个线程相当于 让系统加载了一个任务，通过分配CPU时间片来执行
        // 如果直接调用 线程.run 方法，那还是原本的串行执行，使用 Thread 就没有任何意义了
        new Thread(()->{
            synchronized (resource1){
                System.out.println("获取到resource1的资源" + Thread.currentThread());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待到resource2的资源" + Thread.currentThread());
                synchronized (resource2){
                    System.out.println("获取到resource2的资源" + Thread.currentThread());
                }
            }
        },"线程1").start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println("获取到resource2的资源" + Thread.currentThread());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("获取到resource1的资源" + Thread.currentThread());
                }
                System.out.println("等待到resource1的资源" + Thread.currentThread());

                System.out.println("释放resource2的资源" + Thread.currentThread());
            }
        },"线程2").start();
    }
}
