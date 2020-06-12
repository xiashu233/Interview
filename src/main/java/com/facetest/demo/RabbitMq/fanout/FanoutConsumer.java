package com.facetest.demo.RabbitMq.fanout;

import com.facetest.demo.Mybatis.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * fanout共享模式，多个消费者消费同一条消息
 * 相对于简单（一对一）模式和工作模式，多了一步绑定交换机的步骤
 */
@Component
@Slf4j
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "fanout",type = "fanout")// 绑定交换机
            )
    })    public void fanoutListener1(Student msg){
        log.info("fanout 模式 由方法1 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "fanout",type = "fanout")// 绑定交换机
            )
    })    public void fanoutListener2(Student msg){
        log.info("fanout 模式 由方法2 中的Listener监听到的消息" + msg);
    }
}
