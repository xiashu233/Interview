package com.facetest.demo.设计模式.简单工厂模式;

/**
 * 运算类 子类通过重写 getResult 方法来实现多态
 */
public class OperationBean {
    private Double numA;
    private Double numB;

    public Double getNumA() {
        return numA;
    }

    public void setNumA(Double numA) {
        this.numA = numA;
    }

    public Double getNumB() {
        return numB;
    }

    public void setNumB(Double numB) {
        this.numB = numB;
    }

    public Double getResult(){
        double result = 0.0;
        return result;
    }
}
