package com.facetest.demo.Java8;

import lombok.Data;

@Data
public class Apple {
    private Integer id;
    private String color;
    private int weight;

    public Apple setColor(String color) {
        this.color = color;
        return this;
    }

    public Apple setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Apple() {
    }

    public Apple(Integer id, String color, int weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    // 构造静态方法以供当做参数传递
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>150;
    }


}
