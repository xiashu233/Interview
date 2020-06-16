package com.facetest.demo.Spring.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginCheck {
    // 定义注解内属性 是否为必须 校验正确 也就是 必须为用户登录
    boolean loginSuccess() default true;
}
