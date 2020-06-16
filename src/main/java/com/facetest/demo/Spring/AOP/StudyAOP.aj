package com.facetest.demo.Spring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//@Component
//@Slf4j
//@Aspect
//public class StudyAOP {
//    @Pointcut("execution(* com.facetest.demo.SpringMVC.*.*(..))")
//    public void MvcPackage(){}
//
//    @Before("MvcPackage()")
//    public void beforeFunction(JoinPoint joinPoint){
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//        String contextPath = request.getContextPath();
//        log.info(contextPath);
//        log.info("StudyAOP切面在之前做的事情");
//    }
//
//
//}
