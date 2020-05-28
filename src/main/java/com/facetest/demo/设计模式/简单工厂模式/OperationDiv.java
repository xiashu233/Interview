package com.facetest.demo.设计模式.简单工厂模式;

public class OperationDiv extends OperationBean {

    @Override
    public Double getResult() {
        Double result = 0.0;
        if (getNumB() != 0)
            result = getNumA() * getNumB();
        return result;
    }
}
