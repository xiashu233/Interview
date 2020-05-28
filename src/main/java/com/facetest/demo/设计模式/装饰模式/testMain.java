package com.facetest.demo.设计模式.装饰模式;

public class testMain {
    public static void main(String[] args) {
        Person person = new Person("储木杉");
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        tShirts.Decorate(person);
        bigTrouser.Decorate(tShirts);

        bigTrouser.Show();
    }
}
