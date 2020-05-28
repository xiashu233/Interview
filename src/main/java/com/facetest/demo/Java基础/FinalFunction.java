package com.facetest.demo.Java基础;

/**
 * 测试方法参数修饰 final 时的作用
 */
public class FinalFunction {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("123");
        System.out.println(sayHello(stringBuffer));
        System.out.println(stringBuffer);
    }

    static String sayHello(final StringBuffer sb){
        // 与变量修饰 final 相同，值类型不可改变值，引用类型不可改变其引用（可改变值）
        sb.append("abc");
        // Cannot assign a value to final variable 'sb'
        // sb = new StringBuffer("aaa");
        return sb.toString();
    }
}
