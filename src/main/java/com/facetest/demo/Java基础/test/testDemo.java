package com.facetest.demo.Java基础.test;

import com.facetest.demo.Java基础.StaticDemoTest;
import org.junit.Test;
import static com.facetest.demo.Java基础.StaticDemoTest.*;

import java.beans.Transient;
import java.util.Set;
import java.util.TreeSet;

public class testDemo {

    @Test
    public void test(){
        // StaticDemoTest demoTest = new StaticDemoTest();
        test1();
        System.out.println("Test方法开始");
        // 调用类的时候就会调用类的静态方法 静态代码无论执行多少次类或者类的方法只会被执行一次
        StaticDemoTest.test1();
    }

    @Test
    public void test1(){
        
        String s = "asdlkjalskdjlaskjdlkasjdlkasdlkjasldjskjdlasjd";
        int[] sArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c - 'a']++;
        }

        for (int i : sArr) {
            System.out.print(i + "、");
        }

    }
}
