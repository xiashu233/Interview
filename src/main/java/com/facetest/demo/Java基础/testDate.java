package com.facetest.demo.Java基础;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testDate {
    public static void main(String[] args) {
        // 测试字符串操作类之间的添加数据时长
        Date startDate = new Date();
        String s = "a";
        for (int i = 0; i < 100000; i++) {
            s += i;
        }
        Date endDate = new Date();

        System.out.println(endDate.getTime() - startDate.getTime());

        Date startDate2 = new Date();
        StringBuilder sb = new StringBuilder("a");
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        Date endDate2 = new Date();

        System.out.println(endDate2.getTime() - startDate2.getTime());

        Date startDate3 = new Date();
        StringBuffer sb2 = new StringBuffer("a");
        for (int i = 0; i < 100000; i++) {
            sb2.append(i);
        }
        Date endDate3 = new Date();

        System.out.println(endDate3.getTime() - startDate3.getTime());

//        Date startDate4 = new Date();
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 10000000; i++) {
//            list.add("a");
//        }
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//
//        }
//        Date endDate4 = new Date();
//        System.out.println(endDate4.getTime() - startDate4.getTime());


    }
}
