package com.facetest.demo.Java基础;

import com.facetest.demo.Java8.Apple;

/**
 * 继承通用 IService 接口
 */
public interface AppleServiceByPro extends IServiceByPro<Apple> {

    // 接口中的方法默认需要被子类强制重写
    void test();

    // default 声明此方法可以被本类实现 无需让子类强制重写
    default void testDefault(){

    }
}
