package com.facetest.demo.反射;

import com.facetest.demo.Java基础.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author XiaShu
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        Class<?> aClass = Class.forName("com.facetest.demo.Java基础.Student");
        // 获取指定类的注解
        for (Annotation annotation : aClass.getDeclaredAnnotations()) {
            System.out.println(annotation.annotationType().toString());
        }


        Student studentCP = (Student) aClass.newInstance();
        Field[] declaredFields = aClass.getDeclaredFields();
        Method[] methods = aClass.getMethods();

        Method say = aClass.getDeclaredMethod("say");
        // 设置安全验证 设置这个可以反射执行private修饰的方法
        say.setAccessible(true);
        say.invoke(studentCP,null);
        // 获取注解列表
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
        System.out.println(declaredAnnotations[0]);


        System.out.println("注解的个数：" + declaredAnnotations.length);
        Foo annotation = aClass.getAnnotation(Foo.class);
        System.out.println(annotation.getClass().toString() + "对应的值：" + annotation.value());
        // 通过反射执行对应类的方法
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(studentCP,"储彬");

        System.out.println("通过反射获取到的对象信息");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        System.out.println("通过反射获取到的对象方法");
        for (Method method : methods) {
            System.out.println(method.getName());
            if ("setAge".equals(method.getName())){
                // 通过反射执行对象方法
                method.invoke(studentCP,12);
            }
        }
        System.out.println(studentCP.toString());

    }
}
