package com.facetest.demo.Java基础;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {
    private String name;
    private Integer age;


    @Override
    public int compareTo(Student o) {
        return this.age - o.getAge();
    }
}
