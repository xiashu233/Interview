package com.facetest.demo.设计模式.代理模式;

public class Proxy implements GiveGift {
    Pursuit ps;

    public Proxy(SchoolGril mm){
        ps = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        ps.giveDolls();
    }

    @Override
    public void giveFlower() {
        ps.giveFlower();
    }

    @Override
    public void giveChocolate() {
        ps.giveChocolate();
    }
}
