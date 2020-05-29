package com.facetest.demo.Java基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 获取键盘输入的值
 */
public class KeyboardInput {
    public static void main(String[] args) throws IOException {
        // Scanner
        Scanner sc = new Scanner(System.in);
        // BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = sc.nextLine();
        String s1 = bf.readLine();

        System.out.println(s + "--" + s1);
    }
}
