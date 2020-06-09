package com.facetest.demo.Spring.IOC;

import com.facetest.demo.Mybatis.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Component 将TeacherBean类交由IOC管理 且自动注入一个Student对象
 * 由于IOC容器中使用 @Configuration 以及 @Bean 放入了一个Student类实例
 * 在本类中将注入Student实例，且可以使用 @Autowired注解获取到本类实例
 */
@Component
public class TeacherBean {

    @Autowired
    Student student;

    public void sayStudent(){
        System.out.println(student);
    }
}
