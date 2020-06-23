package com.facetest.demo.Java基础;

import com.facetest.demo.反射.Foo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Foo(value={"sherman", "decompiler"}, bar=true)
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

    private void say(){
        System.out.println("这是一个private修饰的方法");
    }
}
