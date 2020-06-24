package com.facetest.demo.JVM;

import java.util.ArrayList;
import java.util.List;

public class AddClassDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> strings = new ArrayList<>();
        while (true){
            String s = new String("s");
            strings.add(s);
            Thread.sleep(1);
        }

    }
}
