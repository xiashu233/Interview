package com.facetest.demo.RabbitMq.topic;

import com.facetest.demo.Mybatis.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 动态路由
 * 通配符： * 代表任意一个
 *          # 代表任意个任意字符
 *
 */
@Component
@Slf4j
public class TopicConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topics",type = "topic"),
            key = {"user.*"}
    ))
    public void topicListener1(Student msg){
        log.info("diTopic模式 由方法1 {'user.*'} 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topics",type = "topic"),
            key = {"user.#"}
    ))
    public void topicListener2(Student msg){
        log.info("diTopic模式 由方法1 {'user.#'} 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "topics",type = "topic"),
            key = {"user.*.ack"}
    ))
    public void topicListener3(Student msg){
        log.info("diTopic模式 由方法1 {'user.*.ack'} 中的Listener监听到的消息" + msg);
    }
}
