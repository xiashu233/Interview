package com.facetest.demo.RabbitMq.work;

import com.facetest.demo.Mybatis.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 工作模式有点负载均衡的意思，多个消费者去抢占消费一条记录
 */
@Component
@Slf4j
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void work1(Student msg){
        log.info("Work模式 由方法1 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void work2(Student msg){
        log.info("Work模式 由方法2 中的Listener监听到的消息" + msg);
    }

}

