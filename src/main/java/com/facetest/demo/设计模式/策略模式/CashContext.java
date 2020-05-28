package com.facetest.demo.设计模式.策略模式;

/**
 * 策略模式的执行类 并结合简单工厂实现动态生成子类
 */
public class CashContext {
    private CashSuper cs;

    public CashContext(String type){
        switch (type){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300减100":
                cs = new CashResult(300.0,100.0);
                break;
            case "打8折":
                cs = new CashRebate(0.8);
                break;
        }
    }

    public Double getResult(Double money){
        return cs.acceptCash(money);
    }
}
