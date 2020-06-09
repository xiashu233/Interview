package com.facetest.demo.Spring.IOC;

import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将一个实例化的Student 注入到IOC容器中，在其他IOC容器中需要注入Student的时候，
 * 可将该Student注入到那个类中
 * 表示一个类声明了一个或多个{@link Bean @Bean}方法，并且*可以由Spring容器处理以在运行时为这些bean生成bean定义和*服务请求，
 */
@Configuration
public class StudentBean {

    /**
     * 提供一个实例化后的Student类
     * @return
     */
    @Bean
    public Student getStudent(){
        return new Student(1,"zs",22,"hanp");
    }
}
