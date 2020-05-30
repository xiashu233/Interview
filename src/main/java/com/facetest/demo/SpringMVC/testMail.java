package com.facetest.demo.SpringMVC;

import com.facetest.demo.dto.MailDto;
import com.facetest.demo.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testMail {

    @Autowired
    MailUtil mailUtil;

    @RequestMapping("/testMail")
    public void testMail(){
        MailDto dto = new MailDto();
        dto.setSubject("这个是测试标题");
        dto.setContent("<h1>简单的测试邮件H1，一级标题</h1><p>携带一个p标签的内容</p>");
        // dto.setContent("简单的测试邮件");
        dto.setTos(new String[]{"2984125878@qq.com","1973404448@qq.com"});

        // 发送简单文本邮件
        // mailUtil.sendSimpleEmail(dto);
        // 发送携带HTML样式的邮件
        mailUtil.sendHTMLMail(dto);

    }
}
