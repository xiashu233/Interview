package com.facetest.demo.Java基础;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class testPlus {
    public static void main(String[] args) {
//        int a = 3;
//
//        double d = 1.5;
//        double v = a + d;
//        // System.out.println();
//        int b = (a++) * 3;
//        int c = (++a) * 3;
//        System.out.println(a + "--" + b + "--" + c);


        List lis1 = new ArrayList();
        List lis2 = new LinkedList();

        for (int i = 0; i < 10000000; i++) {
            lis1.add(i);
            lis2.add(i);
        }
        Date dateStart1 = new Date();
        for (int i = 0; i < lis1.size(); i++) {
            
        }
        Date dateEnd1 = new Date();

        Date dateStart2 = new Date();
        for (int i = 0; i < lis2.size(); i++) {

        }
        Date dateEnd2 = new Date();

        System.out.println(dateEnd1.getTime() - dateStart1.getTime());
        System.out.println(dateEnd2.getTime() - dateStart2.getTime());
    }
}
