package com.facetest.demo.设计模式.简单工厂模式;

import java.util.Scanner;

public class testMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数值A：");
        double numA = sc.nextDouble();
        System.out.println("请输入数值B：");
        double numB = sc.nextDouble();
        System.out.println("请输入运算符：");
        String operate = sc.next();
        // 简单工厂实现 + 封装
        // Double result = Operation.getResult(numA, numB, operate);
        // 简单工厂 + 面向对象特征 封装继承多态
        OperationBean operateBean = OperationFactory.createOperate(operate);
        operateBean.setNumA(numA);
        operateBean.setNumB(numB);
        Double result = operateBean.getResult();
        System.out.println("结果是：" + result);
    }
}
