package com.facetest.demo.response;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class ResponseResultVo<T> {
    private boolean success;
    private Integer code;
    private T data;
    private String msg;
    private Map<String,Object> extra;

    public static ResponseResultVo OK(){
        ResponseResultVo responseResultVo = new ResponseResultVo();
        responseResultVo.setSuccess(true);
        responseResultVo.setCode(200);
        responseResultVo.setMsg("请求成功");
        return responseResultVo ;
    }


    public static <T> ResponseResultVo<T> success(T data) {
        ResponseResultVo responseResultVo = new ResponseResultVo();
        responseResultVo.setSuccess(true);
        responseResultVo.setCode(200);
        responseResultVo.setMsg("请求成功");
        responseResultVo.setData(data);
        return responseResultVo ;
    }

    public static ResponseResultVo faild( ResultVoStatus resultVoStatus){
        ResponseResultVo responseResultVo = new ResponseResultVo();
        responseResultVo.setSuccess(false);
        responseResultVo.setCode(resultVoStatus.getStatus());
        responseResultVo.setMsg(resultVoStatus.getMsg());
        return responseResultVo ;
    }
}
