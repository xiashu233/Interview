package com.facetest.demo.SpringBoot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 映射配置文件 动态获取配置项 此处引入了 前缀为 my.xx 的配置项
 */

@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
