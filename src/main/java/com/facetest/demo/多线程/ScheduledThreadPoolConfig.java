package com.facetest.demo.多线程;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class ScheduledThreadPoolConfig {

    @Bean
    public ScheduledExecutorService getScheduledThreadPool(){
        return Executors.newScheduledThreadPool(10);
    }
}
