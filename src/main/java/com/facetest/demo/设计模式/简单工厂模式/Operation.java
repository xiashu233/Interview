package com.facetest.demo.设计模式.简单工厂模式;

public class Operation {
    /**
     * 简单工厂模式
     * @param numA      数值A
     * @param numB      数值B
     * @param operate   运算符 + - * /
     * @return          返回结果
     */
    public static Double getResult(double numA,double numB,String operate){
        double result = 0.0;
        switch (operate){
            case "+":
                result = numA + numB;
                break;
            case "-":
                result = Math.abs(numA - numB);
                break;
            case "*":
                result = numA * numB;
                break;
            case "/":
                if (numB != 0)
                    result = numA / numB;
                break;
        }
        return result;
    }
}
