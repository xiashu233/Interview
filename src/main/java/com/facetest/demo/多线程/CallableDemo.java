package com.facetest.demo.多线程;

import com.facetest.demo.Mybatis.bean.Student;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Object> callableImpl = new CallableImpl<Object>();

        FutureTask<Object> futureTask = new FutureTask<Object>(callableImpl);
        Thread thread = new Thread(futureTask);
        // 不执行线程无法获取到返回值
        // Thread.sleep(2000);
        thread.start();
        Object o = futureTask.get();
        System.out.println("获取到Callable的返回值" + o);



    }
}
