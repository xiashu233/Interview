package com.facetest.demo.Spring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

// @Order(1) 指定多个Aspect时执行顺序 > 从小到大执行
@Aspect
@Component
@Slf4j
public class testAOP {

    //切入点描述 这个是testControl类的切入点
    @Pointcut("execution(public * com.facetest.demo.SpringMVC.testControl.*(..))")
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称
    //切入点描述，这个是testMail类的切入点
    @Pointcut("execution(public * com.facetest.demo.SpringMVC.testMail.*(..))")
    public void uiControllerLog(){}
    // 切入点描述，这是SpringBoot包及其子包下所有方法的切入点
    @Pointcut("execution(public * com.facetest.demo.SpringBoot..*.*(..))")
    public void SpringBootLog(){}

    @Before("controllerLog() || uiControllerLog() || SpringBootLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {

        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        log.info("################URL : " + request.getRequestURL().toString());
        log.info("################HTTP_METHOD : " + request.getMethod());
        log.info("################IP : " + request.getRemoteAddr());
        log.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        log.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }

    @After("controllerLog()")
    public void logAfter(){
        log.info("操作保存到数据库");
    }

}
