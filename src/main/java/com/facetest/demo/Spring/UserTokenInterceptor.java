package com.facetest.demo.Spring;

import com.alibaba.fastjson.JSON;
import com.facetest.demo.Java8.Apple;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
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
        log.info("--- 开始拦截校验用户是否有Token ---");
        String tokenCode = request.getHeader("Token");
        if (tokenCode != null && !"".equals(tokenCode)){
            return true;
        }
        for (Cookie cookie : request.getCookies()) {
            if ("user_Token".equals(cookie.getName()) && StringUtils.isNotBlank(cookie.getValue())){
                String token = cookie.getValue();
                String tokenValue = redisTemplate.opsForValue().get(token).toString();
                if (StringUtils.isNotBlank(tokenValue)){
                    // 假设 Apple 是用户类
                    Apple apple = JSON.parseObject(tokenValue, Apple.class);
                    // 将用户信息放入 request域
                    request.setAttribute("memberId",apple.getId());
                }
            }
        }

        return true;
    }
}
