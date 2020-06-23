package com.facetest.demo.设计模式.策略模式;

/**
 * 使用枚举实现的策略模式，枚举项重写枚举类型的抽象方法（枚举类默认是抽象类，所以不能被直接实例化）
 * 另外枚举类中的枚举项也是单例模式
 */
public enum CeLEnum {
    // 中文
    Chinese{
        @Override
        public void sayGood() {
            System.out.println("真好");
        }
    },
    // 英文
    English{
        @Override
        public void sayGood() {
            System.out.println("Good");
        }
    };

    public abstract void sayGood();
}
