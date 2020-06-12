package com.facetest.demo.RabbitMq.hello;

import com.facetest.demo.Mybatis.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试使用RabbitMq消息队列，简单监听某个消息队列，接收到对应的消息
 * 简单模式下强调一对一，生产者发送一条消息，由一个消费者消费
 */
@Component
@Slf4j
public class HelloConsumer2 {
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void test(Student msg){
        log.info("由方法中的Listener监听到的消息" + msg);
    }
}
