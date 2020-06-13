package com.facetest.demo.RabbitMq;

import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  发送消息Controller层，发现使用IDEA插件 RestService 有时无法触发，所以建议使用 PostMan
 */
@RestController
@RequestMapping("/RabbitMq")
public class RabbitMqController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("sendMsgByEasyModel")
    public void sendMsgByEasyModel(String queues, Student msg){
        rabbitTemplate.convertAndSend(queues,msg);
    }

    @RequestMapping("sendMsgByWorkModel")
    public void sendMsgByWorkModel(String queues, Student msg){
        for (int i = 0; i < 10; i++) {
            msg.setStuAge(msg.getStuAge() + 1);
            rabbitTemplate.convertAndSend(queues,msg);
        }
    }

    @RequestMapping("sendMsgByFanoutModel")
    public void sendMsgByFanoutModel(String queues, Student msg){
        rabbitTemplate.convertAndSend(queues,"",msg);
    }

    @RequestMapping("sendMsgByDirectModel")
    public void sendMsgByFanoutModel(String queues,String routKey, Student msg){
        rabbitTemplate.convertAndSend(queues,routKey,msg);
    }

    @RequestMapping("sendMsgByTopicModel")
    public void sendMsgByTopicModel(String queues,String routKey, Student msg){
        rabbitTemplate.convertAndSend(queues,routKey,msg);
    }


}
