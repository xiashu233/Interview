package com.facetest.demo.exceptionhandler;


import com.facetest.demo.Response.ErrorCode;
import com.facetest.demo.Response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
@RestControllerAdvice(basePackages={"com.springboot.demo.controller"})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(HdException.class)
    public R handleException(HttpServletRequest request, HttpServletResponse response, HdException e) {
        Exception f=e;
        if (e.getE()!=null){
             f=e.getE();
        }
        //f为产生的具体异常
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        List<String> err = Arrays.asList("文件名：" + stackTraceElement.getFileName()
                , "类名：" + stackTraceElement.getClassName()
                , "方法名：" + stackTraceElement.getMethodName()
                , "抛出异常行号：" + stackTraceElement.getLineNumber()
                , "具体的异常信息：" + f.getMessage()
        );
        log.error("产生了错误:{}",err);
        return R.failed("500",e.getMessage())
                .addExtra("errorMsg",f.getStackTrace())
                .addExtra("exceptionMessage", err);

    }

    @ExceptionHandler({Exception.class})
    public R handleServiceException(HttpServletRequest request, Exception e) {
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        List<String> err = Arrays.asList("文件名：" + stackTraceElement.getFileName()
                , "类名：" + stackTraceElement.getClassName()
                , "方法名：" + stackTraceElement.getMethodName()
                , "抛出异常行号：" + stackTraceElement.getLineNumber()
                , "产生的异常为：" + e.getMessage()
        );
        log.error("产生了错误:{}",err);
        return R.failed(ErrorCode.Error_Exception)
                .addExtra("errorMsg", e.getStackTrace())
                .addExtra("exceptionMessage", err);


    }

//
//    private void savelog(HttpServletRequest request,
//                         HdException e) {
//        SysLogError sysLogError = new SysLogError();
//        //获取IP
//        String IP = IpUtil.getIpAddrByRequest(request);
//        //获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //获取请求参数
//        Map<String, String[]> maps = request.getParameterMap();
//        String cs = null;
//        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
//            cs = entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ";";
//        }
//        Exception f = null;
//        if (e.getE() != null) {
//            f = e.getE();
//        } else {
//            f = e;
//        }
//        StackTraceElement stackTraceElement = f.getStackTrace()[0];
//        String errorMsg = "文件名：" + stackTraceElement.getFileName() +
//                "\r\n类名：" + stackTraceElement.getClassName() +
//                "\r\n方法名：" + stackTraceElement.getMethodName() +
//                "\r\n抛出异常行号：" + stackTraceElement.getLineNumber() +
//                "\r\n产生的异常为：" + f;
//
//        //获取请求类型
//        String type = request.getMethod();
//        //头信息
//        String header = request.getHeader(HttpHeaders.USER_AGENT);
//        sysLogError.setCreateDate(new Date());
//        sysLogError.setIp(IP);
//        sysLogError.setRequestMethod(type);
//        sysLogError.setRequestParams(cs);
//        sysLogError.setRequestUri(requestURI);
//        sysLogError.setUserAgent(header);
//        sysLogError.setErrorInfo(errorMsg);
//        sysLogErrorMapper.insertSelective(sysLogError);
//
//    }
//
//    private void savelog(HttpServletRequest request,
//                         Exception e) {
//        SysLogError sysLogError = new SysLogError();
//        //获取IP
//        String IP = IpUtil.getIpAddrByRequest(request);
//        //获取请求路径
//        String requestURI = request.getRequestURI();
//
//        //获取请求参数
//        Map<String, String[]> maps = request.getParameterMap();
//        String cs = null;
//        for (Map.Entry<String, String[]> entry : maps.entrySet()) {
//            cs = entry.getKey() + ":" + Arrays.toString(entry.getValue()) + ";";
//        }
//
//        StackTraceElement stackTraceElement = e.getStackTrace()[0];
//        String errorMsg = "文件名：" + stackTraceElement.getFileName() +
//                "\r\n类名：" + stackTraceElement.getClassName() +
//                "\r\n方法名：" + stackTraceElement.getMethodName() +
//                "\r\n抛出异常行号：" + stackTraceElement.getLineNumber() +
//                "\r\n产生的异常为：" + e;
//
//        //获取请求类型
//        String type = request.getMethod();
//        //头信息
//        String header = request.getHeader(HttpHeaders.USER_AGENT);
//        sysLogError.setCreateDate(new Date());
//        sysLogError.setIp(IP);
//        sysLogError.setRequestMethod(type);
//        sysLogError.setRequestParams(cs);
//        sysLogError.setRequestUri(requestURI);
//        sysLogError.setUserAgent(header);
//        sysLogError.setErrorInfo(errorMsg);
//        for (int i = 30; i < 200000000; i++) {
//            sysLogError.setId(i);
//            sysLogErrorMapper.insertSelective(sysLogError);
//        }


//    }


}
