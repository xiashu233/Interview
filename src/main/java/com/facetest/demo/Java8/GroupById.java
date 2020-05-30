package com.facetest.demo.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupById {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1,"红色",12));
        apples.add(new Apple(2,"绿色",12));
        apples.add(new Apple(3,"蓝色",12));
        apples.add(new Apple(4,"红色",12));

        Map<Integer, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(collect);
    }
}
