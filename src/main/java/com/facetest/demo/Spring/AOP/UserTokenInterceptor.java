package com.facetest.demo.Spring.AOP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AOP 1
 * 实现 HandlerInterceptor 重写 preHandle 接口实现拦截器功能
 */
@Slf4j
@Service
public class UserTokenInterceptor implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 前置拦截器
     * @param request 请求
     * @param response 响应
     * @param handler
     * @return 是否放行
     * @throws Exception
     */
    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("--- 开始拦截校验用户是否有Token ---");

        HandlerMethod hd = (HandlerMethod)handler;
        LoginCheck methodAnnotation = hd.getMethodAnnotation(LoginCheck.class);
        if (methodAnnotation == null){
            log.info("不需要登录，放行");
            return true;
        }

        log.info("检测到带检测需要检测登录的注解");
        boolean success = methodAnnotation.loginSuccess();

        if (success){
            log.info("注解表示必须要校验登录信息，信息不符合则打会重新登录页面");


        }

//        String tokenCode = request.getHeader("Token");
        
//        if (tokenCode != null && !"".equals(tokenCode)){
//
//            return true;
//        }
//        for (Cookie cookie : request.getCookies()) {
//            if ("user_Token".equals(cookie.getName()) && StringUtils.isNotBlank(cookie.getValue())){
//                String token = cookie.getValue();
//                String tokenValue = redisTemplate.opsForValue().get(token).toString();
//                if (StringUtils.isNotBlank(tokenValue)){
//                    // 假设 Apple 是用户类
//                    Apple apple = JSON.parseObject(tokenValue, Apple.class);
//                    // 将用户信息放入 request域
//                    request.setAttribute("memberId",apple.getId());
//                }
//            }
//        }

        return true;
    }
}
