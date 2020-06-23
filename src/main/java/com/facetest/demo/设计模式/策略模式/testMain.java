package com.facetest.demo.设计模式.策略模式;

public class testMain {
    public static void main(String[] args) {
        // System.out.println(Math.floor(1.9));
        CashContext context = new CashContext("打8折");
        System.out.println(context.getResult(1000.0));

        CeLEnum.Chinese.sayGood();
        CeLEnum.English.sayGood();

        // CeLEnum ceLEnum = new CeLEnum();
    }
}
