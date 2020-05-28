package com.facetest.demo.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 启用引入映射配置文件的配置类
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
public class TesController {
    @Autowired
    ConfigBean configBean;
    @Autowired
    TestConfigBean testConfigBean;

    @RequestMapping("/my")
    public String getMyInfo(){
        return "configBean:" + configBean.getName() + ":" + configBean.getAge()
                + "testConfigBean:" + testConfigBean.getName() + ":" + testConfigBean.getAge();
    }
}
