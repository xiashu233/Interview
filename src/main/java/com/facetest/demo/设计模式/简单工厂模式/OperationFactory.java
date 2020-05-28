package com.facetest.demo.设计模式.简单工厂模式;

/**
 * 抽象工厂 根据传入的运算符返回相应的子类 各个运算类之间互不干预 低耦合
 * 如果需要加入新功能只需要在工厂中加入对应的分支即可
 */
public class OperationFactory  {
    public static OperationBean createOperate(String operate){
        OperationBean ope = null;
        switch (operate){
            case "+":
                ope = new OperationAdd();
                break;
            case "-":
                ope = new OperationSub();
                break;
            case "*":
                ope = new OperationMul();
                break;
            case "/":
                ope = new OperationDiv();
                break;
            default:
                ope = new OperationBean();
        }
        return ope;
    }
}
