package com.facetest.demo.response;

public enum ResultVoStatus {
    OK(200,"请求成功"),
    Error(500,"服务器异常"),
    PageSizeException(500,"页面大小小于0");


    private Integer status;
    private String msg;

    ResultVoStatus() {
    }

    ResultVoStatus(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
