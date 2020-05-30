package com.facetest.demo.Java基础;

/**
 * final 修饰的类叫做最终类 该类不可以被继承
 */
// final
public class FinalDemo {
    static final int a = 0;
    static final StringBuffer sb = new StringBuffer();
    static final String str = "";

    public static void main(String[] args) {
        // Cannot assign a value to final variable 'a'
        // 修饰在值类型前变量必须初始化且不能再改变值
        // a++;
        sb.append("abc");
        // Cannot assign a value to final variable 'sb'
        // 修饰在引用类型前可以改变其值，但是不可以改变其引用
        // sb = new StringBuffer();

        // Cannot assign a value to final variable 'str'
        // String 作为一个特殊的引用类型 重新赋值之后会改变其引用 所以不可以改变值
        // str = "123";
    }

    /**
     * 方法中使用 final 修饰变量时跟在类中定义的一样 不再赘述
     * @param i final 修饰的值类型
     * @param sbStr final 修饰的引用类型
     */
    static final void finalFunction(final int i,final StringBuffer sbStr){
        // Cannot assign a value to final variable 'i'
        // i = 0;
        sbStr.append("qwe");
        // Cannot assign a value to final variable 'sbStr'
        // sbStr = new StringBuffer();

    }

    void sayHello(){
        System.out.println("Hello World!");
    }

    /**
     * 被 final 修饰的方法不可被重写
     */
    final void sayHelloFinal(){
        System.out.println("Hello World By Final Function!");
    }

}
