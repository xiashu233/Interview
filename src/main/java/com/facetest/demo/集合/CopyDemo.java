package com.facetest.demo.集合;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyDemo {
    public static void main(String[] args) {
        int[] int1 = new int[11];
        for (int i = 0; i < 10; i++) {
            int1[i] = (25 + i);
        }
        int[] int2 = new int[15];
        new ArrayList<>();

        // src 源数组（从这个数组取值） srcPos 从这个数组哪里开始取值
        // dest 对象数组（值放到这个数组里） destPos对象数组接收值的位置
        // length 复制多长
        System.arraycopy(int1,0,int2,3,5);

        System.out.println(int2);


    }
}
