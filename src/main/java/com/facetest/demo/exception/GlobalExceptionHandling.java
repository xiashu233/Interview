package com.facetest.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandling {




    // Exception 是所有异常的父类 所以能捕捉到所有的异常
    @ExceptionHandler({Exception.class})
    public String handleAllException(HttpServletRequest request,Exception e){
        e.printStackTrace();
        // 请求方式
        log.info("请求方式：" + request.getMethod());
        // 请求路径
        log.info("请求路径：" + request.getRequestURI());
        log.info("请求路径：" + request.getAuthType());
        log.info("请求路径：" + request.getContextPath());
        log.info("请求路径：" + request.getPathInfo());
        // 获取请求参数
        Map<String, String[]> maps = request.getParameterMap();
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
            sb.append(entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ";") ;
        }
        log.info("请求路径：" + sb.toString());

        return "Error";
    }
}
