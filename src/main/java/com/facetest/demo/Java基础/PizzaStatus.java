package com.facetest.demo.Java基础;

import java.util.EnumSet;

/**
 * 枚举类天然支持单例模式 且完美兼容序列化 也可以避免被反射破坏
 * @author XiaShu
 */
public enum PizzaStatus {

    ORDERED("ORDERED姓名"){
        @Override
        void showStatus() {
            System.out.println("订单开始");
        }
    },
    READY("READY姓名") {
        @Override
        void showStatus() {
            System.out.println("订单准备就绪");
        }
    },
    DELIVERED("DELIVERED姓名") {
        /**
         * 重写抽象方法
         */
        @Override
        void showStatus() {
            System.out.println("订单结束");
        }
    };

    public String name;
    public Integer age;

    public static EnumSet<PizzaStatus> under = EnumSet.of(ORDERED,ORDERED);

    PizzaStatus() {
    }

    PizzaStatus(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        PizzaStatus p = PizzaStatus.DELIVERED;
        System.out.println(p.name);
        p.showStatus();

        PizzaStatus read = PizzaStatus.READY;


        under.add(p);
        under.add(read);

        System.out.println(under);
    }

    abstract void showStatus();
}