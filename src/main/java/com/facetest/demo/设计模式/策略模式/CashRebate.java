package com.facetest.demo.设计模式.策略模式;

/**
 * 打折收费类
 */
public class CashRebate extends CashSuper {
    private Double rebate;

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    @Override
    public Double acceptCash(Double money) {
        return money * rebate;
    }
}
