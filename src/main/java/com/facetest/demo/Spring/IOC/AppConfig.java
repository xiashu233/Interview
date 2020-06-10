package com.facetest.demo.Spring.IOC;

import com.facetest.demo.Mybatis.bean.Person;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.bean.Teacher;
import com.facetest.demo.Mybatis.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public class AppConfig {
    @Bean
    public Student transferService() {
        return new Student();
    }

    @Bean
    public Person getService(int status) {
        switch (status){
            case 1:
                return new Teacher();
            case 2:
                return new Student();
            default:
                return new User();
        }
    }
}
