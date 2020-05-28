package com.facetest.demo.设计模式.策略模式;

/**
 * 返利收费类
 */
public class CashResult extends CashSuper {
    private Double moneyCondition = 0.0;
    private Double moneyReturn = 0.0;


    public CashResult(Double moneyCondition, Double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public Double acceptCash(Double money) {
        return  money - Math.floor(money / moneyCondition) * moneyReturn;
    }
}
