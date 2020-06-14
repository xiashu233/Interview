package com.facetest.demo.exceptionhandler;


import com.facetest.demo.Response.ErrorCode;

public class HdException extends RuntimeException {

    com.facetest.demo.Response.ErrorCode ErrorCode;
    Exception e;


    public HdException(ErrorCode ErrorCode) {
        super(ErrorCode.getMsg());
        this.ErrorCode = ErrorCode;
    }

    public HdException(ErrorCode ErrorCode, Exception e) {
        super(ErrorCode.getMsg());
        this.ErrorCode = ErrorCode;
        this.e = e;


    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }

    public ErrorCode getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(ErrorCode ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

}
