package com.facetest.demo.exception;

import com.facetest.demo.response.ResultVoStatus;

public class HdException extends RuntimeException {

    ResultVoStatus resultVoStatus;
    Exception e;

    public HdException(ResultVoStatus resultVoStatus) {
        // 对父类初始化
        super(resultVoStatus.getMsg());
        this.resultVoStatus = resultVoStatus;
    }

    public HdException(ResultVoStatus resultVoStatus, Exception e) {
        // 对父类初始化
        super(resultVoStatus.getMsg());
        this.resultVoStatus = resultVoStatus;
        this.e = e;
    }

    public ResultVoStatus getResultVoStatus() {
        return resultVoStatus;
    }

    public void setResultVoStatus(ResultVoStatus resultVoStatus) {
        this.resultVoStatus = resultVoStatus;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
}
