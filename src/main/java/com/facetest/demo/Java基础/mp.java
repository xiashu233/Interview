package com.facetest.demo.Java基础;

public class mp {
    public static void main(String[] args) {
        int[] arr = {9,5,7,3,6,2,2};
        int t = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            showItems(arr);
        }
    }

    private static void showItems(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "、");
        }
        System.out.println();
    }
}
