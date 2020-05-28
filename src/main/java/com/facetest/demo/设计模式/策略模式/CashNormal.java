package com.facetest.demo.设计模式.策略模式;

/**
 * 正常收费类
 */
public class CashNormal extends CashSuper {

    @Override
    public Double acceptCash(Double money) {
        return money;
    }
}
