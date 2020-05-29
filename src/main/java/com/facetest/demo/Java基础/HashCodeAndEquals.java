package com.facetest.demo.Java基础;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        // hashcode相同 equals 不一定相同
        String s = "通话";
        String s1 = "重地";
        System.out.println(s.hashCode() + "--" + s1.hashCode() + "--" + "HashCode：" + (s.hashCode() == s1.hashCode()) + "--" + "Equals：" + (s.equals(s1)));
        // 但是 equals 相同 hashcode 必须相同
        String s2 = "测试";
        String s3 = "测试";
        System.out.println(s2.hashCode() + "--" + s3.hashCode() + "--" + "HashCode：" + (s2.hashCode() == s3.hashCode()) + "--"  + "Equals：" + (s2.equals(s3)));
    }
}
