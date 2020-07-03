package com.facetest.demo.Java基础;

public class TwoStringAd {

    public static void main(String[] args) {


        String s1 = "984515461";
        String s2 = "1513515451314351352";
//        int minLength;
//        String maxV;
//        if (s1.length()<s2.length()){
//            minLength = s1.length();
//            maxV = s2;
//        }else{
//            minLength = s2.length();
//            maxV = s1;
//        }
//        int t = 0;
//        StringBuilder sb = new StringBuilder("");
//        for (int i = minLength - 1; i >= 0; i--) {
//            int byteV = (s1.charAt(i) - '0') + (s2.charAt(i)-'0') + t;
//            if (byteV >= 10){
//                t = 1;
//            }else{
//                t = 0;
//            }
//
//            System.out.println(s1.charAt(i) + "--" +s2.charAt(i) + "--" + t);
//            sb.append(byteV%10);
//        }
//
//        String substring = maxV.substring(0,  (maxV.length() - minLength));
//
//        System.out.println(substring);
//        if (t!=0){
//            sb.append(t);
//        }
//        System.out.println(984515461 + 151351545);
//        System.out.println(sb.reverse().toString());

        ArraySum(s1,s2);
        System.out.println(984515461 + 1513515451314351352L);
        ArrayMul("98451","15152");
        System.out.println(98451 * 15152);
    }

    public static void ArraySum(String s1,String s2){
        char[] large = null;
        char[] small = null;
        int[] sums = null;

        if (s1.length() > s2.length()){
            large = s1.toCharArray();
            small = s2.toCharArray();
        }else{
            large = s2.toCharArray();
            small = s1.toCharArray();
        }

        sums = new int[large.length + 1];

        for (int i = 0; i < large.length; i++) {
            sums[i] = large[large.length - i - 1] - '0';
        }

        for (int i = 0; i < small.length; i++) {
            sums[i] += small[small.length - i - 1]-'0';
        }

        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i] > 9){
                sums[i + 1] += sums[i]/10;
                sums[i] = sums[i]%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = sums.length-1; i >= 0; i--) {
            if (i==sums.length-1 && sums[i]==0) {
                continue;
            }
            sb.append(sums[i]);
        }

        System.out.println(sb);
    }

    public static void ArrayMul(String s1,String s2) {
        char[] large = null;
        char[] small = null;
        if (s1.length() > s2.length()){
            large = s1.toCharArray();
            small = s2.toCharArray();
        }else{
            large = s2.toCharArray();
            small = s1.toCharArray();
        }

        int[] multi = new int[large.length + small.length];

        for (int j = small.length - 1; j >= 0 ; j--) {
            for (int i = large.length-1; i >= 0 ; i--) {
                int num1 = small[j] - '0';
                int num2 = large[i] - '0';
                multi[large.length - 1 - i + small.length - 1 - j] += num1 * num2;
            }
        }

        for (int i = 0; i < multi.length-1; i++) {
            if (multi[i] > 9){
                multi[i + 1] += multi[i]/10;
                multi[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = multi.length - 1; i >= 0 ; i--) {
            if (i == multi.length - 1 && multi[i]==0){
                continue;
            }
            sb.append(multi[i]);
        }

        System.out.println(sb.toString());

    }
}
