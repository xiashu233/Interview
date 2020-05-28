package com.facetest.demo.设计模式.代理模式;

public class Pursuit implements GiveGift{
    SchoolGril mm;
    public Pursuit(SchoolGril mm){
        this.mm = mm;
    }
    @Override
    public void giveDolls() {
        System.out.println(mm.getName() + "给你巧克力");
    }

    @Override
    public void giveFlower() {
        System.out.println(mm.getName() +"给你花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(mm.getName() +"给你泰迪熊");
    }
}
