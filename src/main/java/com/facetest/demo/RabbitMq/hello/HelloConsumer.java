package com.facetest.demo.RabbitMq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 绑定在类上也可实现简单点对点消息
 */
@Component
// 持久化 非独占 不是自动删除的队列
//@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "false"))
public class HelloConsumer {
//    @RabbitHandler
//    public void receivel(String message){
//        System.out.println("message:" + message);
//    }
}
