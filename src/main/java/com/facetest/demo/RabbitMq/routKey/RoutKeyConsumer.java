package com.facetest.demo.RabbitMq.routKey;


import com.facetest.demo.Mybatis.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RoutKeyConsumer {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "direct",
                    type = "direct"
            ),
            key = {"info","error"}
    ))
    public void RoutKeyListener1(Student msg){
        log.info("direct模式 由方法1 {'info','error'} 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "direct",
                    type = "direct"
            ),
            key = {"info"}
    ))
    public void RoutKeyListener2(Student msg){
        log.info("direct模式 由方法1 {'info'} 中的Listener监听到的消息" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(
                    value = "direct",
                    type = "direct"
            ),
            key = {"info","error","warring"}
    ))
    public void RoutKeyListener3(Student msg){
        log.info("direct模式 由方法1 {'info','error','warring'} 中的Listener监听到的消息" + msg);
    }
}
