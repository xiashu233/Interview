package com.facetest.demo.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FilterApple {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple().setColor("green").setWeight(120));
        inventory.add(new Apple().setColor("red").setWeight(160));
        inventory.add(new Apple().setColor("green").setWeight(151));
        // 以 Apple::isGreenApple 作为参数传递给 filterApples 方法
        List<Apple> apples = filterApples(inventory, Apple::isGreenApple);
        // Lambda 表达式构造匿名方法
        List<Apple> apples2 = filterApples(inventory, (Apple a)-> a.getWeight() > 150);
        System.out.println(apples);
        System.out.println(apples2);

        Map<String, List<Apple>> collect = inventory.stream().collect(Collectors.groupingBy(Apple::getColor));
        // Java 流
        List<Apple> collect1 = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println(collect1);

        //System.out.println(collect);
    }

    public static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


    public interface Predicate<T>{
        boolean test(T t);
    }
}
