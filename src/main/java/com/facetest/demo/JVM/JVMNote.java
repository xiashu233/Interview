package com.facetest.demo.JVM;

// JVM Java虚拟机
// Java编写的程序为 .java 的扩展名的文件，由JDK（JRE里没有）的JavaC编译成 JVM 可以解读的 .class 字节码文件
// 再由JVM解析成计算机可以执行的机器码文件
// 这种方法被称为半编译，JVM推崇一次编译处处执行的理论，也就是所谓的跨平台执行。
// 也就是相同的 .class字节码文件在任何系统下的JVM执行，执行结果都是一样的。

// 本地方法栈
// 本地方法执行的时候，在本地方法栈也会创建一个栈帧，用于存放本地方法的局部变量表、操作数栈、动态链接、出口信息。
// 方法执行之后对应的栈帧也会出栈而释放内存空间。

// 堆
// Java虚拟机里管理内存中最大的一块，Java堆是所有线程共享的一块存储空间，在虚拟机启动时创建。
// 此内存区域的作用就是用来存放对象实例，几乎所有的对象实例以及数组都在这里分配内存空间。
// Java堆是垃圾收集器的主要管理区域，因此堆也被称为GC堆（Garbage CollectedHeap）。
// 从垃圾回收的角度，由于现在的垃圾回收器都采用分代收集算法，所以Java堆还可以细分为：新生代和老生代，
// 进一步划分的目的是更好地回收垃圾，或者更快的分配内存。
// 在经历一次新生代垃圾回收后之后，如果对象还存活那么对象的年龄+1，达到一定的阈值（默认15）

// 方法区
// 方法区和Java堆一样，都是线程间共享的一块内存，主要存放已被虚拟机加载的类信息、常量、静态变量、即时编译器编译的代码等数据。
// 虽然Java虚拟机将方法区描述为堆的一个逻辑部分，但是他却又一个别名叫做Non-Heap（非堆），目的是与内存堆区分开。
public class JVMNote {
    public static void main(String[] args) {
        JVMNote jvmNote = new JVMNote();
        jvmNote.func1();
    }

    public void func1(){
        int func1a = 1;
        int func2a = 2;

        int fun3a = func1a + func2a;

        System.out.println("func1");

        func2();
    }

    public void func2(){
        System.out.println("func2");
    }
}
