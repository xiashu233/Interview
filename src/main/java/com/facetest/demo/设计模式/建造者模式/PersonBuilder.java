package com.facetest.demo.设计模式.建造者模式;

/**
 * 将一系列操作封装到一个方法里，
 * 这种模式很常见，就好像是用户只知道自己点击了一次按钮，并不需要去想点击按钮之后的所有步骤
 */
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
