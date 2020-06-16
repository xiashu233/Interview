package com.facetest.demo.设计模式.策略模式;

/**
 * 策略模式 主要是使用了多态（抽象模式子类实现 acceptCash 方法）
 * 收费类的抽象 提供了一个子类必须实现的获取处理后（打折措施）的返回值
 */
public abstract class CashSuper {

    public abstract Double acceptCash(Double money) ;
}
