package com.facetest.demo.多线程;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/Thread")
public class ThreadController {

    @Autowired
    ScheduledExecutorService globalScheduledExecutorService;

    // scheduledExecutorService 实现的延迟队列
    @RequestMapping("addThreadFunc")
    public void addThreadFunc(){
        globalScheduledExecutorService.schedule(()->{
            System.out.println("通过Controller实现的延迟队列 --- " + Thread.currentThread().getName());
        },10, TimeUnit.SECONDS);


    }
}
