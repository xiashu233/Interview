package com.facetest.demo.Spring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.builders.RequestHandlerSelectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * IDEA提供了一种类的类型为 Aspect 作用大致就是 public class testAOP 加上 @Aspect 注解
 */
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

    // 使用自定义规则切面
    @Around(value = "controllerLog()")
    public void logAround(ProceedingJoinPoint point) throws Throwable {
        log.info("使用 @Around 注解在方法之前做什么事情");
        log.info("使用 @Around 注解 优先级在 @Before 之前");
        // point.proceed(); 为执行切面的方法 可以携带返回值 而进行对应操作 void类型对应的是null
        Object proceed = point.proceed();
        log.info("使用 @Around 注解在方法之后做什么事情");
        log.info("使用 @Around 注解 优先级在 @After 之前");
    }

    // 以指定注解为切面 进行之前之后周围操作
    @Around(value = "@annotation(login)")
    public void loginCheckAround(ProceedingJoinPoint point, LoginCheck login) throws Throwable {
        log.info("指定注解之前");
        point.proceed();
        log.info("指定注解之后");
    }

    //定义增强，pointcut连接点使用@annotation（xxx）进行定义
//    @Around(value = "@annotation(around)") //around 与 下面参数名around对应
//    public void processAuthority(ProceedingJoinPoint point,LognCheck around) throws Throwable{
//        System.out.println("ANNOTATION welcome");
//        System.out.println("ANNOTATION 调用方法："+ around.loginSuccess());
//        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
//        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());
//        point.proceed(); //调用目标方法
//        System.out.println("ANNOTATION login success");
//    }

}
