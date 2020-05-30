package com.facetest.demo.Java基础;

/**
 * Cannot inherit from final 'com.facetest.demo.Java基础.FinalDemo'
 * 当继承一个 final 修饰的父类的时候 会提示不可继承 因为 final 修饰的类型作为最终类
 */

public class FinalSubclass extends FinalDemo{

    // 重写父类 方法
    @Override
    void sayHello() {
        super.sayHello();
    }

    // 'sayHelloFinal()' cannot override 'sayHelloFinal()' in 'com.facetest.demo.Java基础.FinalDemo'; overridden method is final
    // 被 final 修饰的方法无法被子类重写
//    void sayHelloFinal(){
//
//    }
}
