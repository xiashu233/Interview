package com.facetest.demo.设计模式.装饰模式;

/**
 * 先打印自己的 再打印出父级的
 */
public class BigTrouser extends Finery {
    @Override
    public void Show() {
        System.out.println("垮裤");
        super.Show();
    }
}
