package com.facetest.demo.设计模式.装饰模式;

/**
 * 此处存储了一个 component
 * 在我认为更像是使这个结构变成链表式的结构了 并不是单单的一个实体类 而是一堆实体类串联起来
 */
public class Finery extends Person{
    protected Person component;

    public void Decorate(Person component){
        this.component = component;
    }

    @Override
    public void Show() {
        if (component != null){
            component.Show();
        }
    }
}
