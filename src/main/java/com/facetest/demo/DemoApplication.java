package com.facetest.demo;

import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import tk.mybatis.spring.annotation.MapperScan;

@Api
@SpringBootApplication
// 启用Swagger2
@EnableSwagger2
@MapperScan("com.facetest.demo.Mybatis.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
