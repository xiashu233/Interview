package com.facetest.demo.设计模式.建造者模式;

public class PersonBuilder {
    Person person;

    public PersonBuilder(Person person){
        this.person = person;
    }

    public void PersonBuilder(){
        person.createHead();
        person.createBody();
        person.createFooter();
    }


}
