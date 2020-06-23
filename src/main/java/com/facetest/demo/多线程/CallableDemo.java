package com.facetest.demo.多线程;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("执行Callable接口方法");
        return null;
    }
}
