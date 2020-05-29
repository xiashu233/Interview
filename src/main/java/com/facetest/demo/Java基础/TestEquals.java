package com.facetest.demo.Java基础;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

public class TestEquals {

    /**
     * 当类中不存在属性的时候 则重写 equals 方法的时候不需要重写 hashcode 方法
     * @param obj
     * @return
     */
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *  当类中有属性的时候 重写 equals 的时候必须重写 hashcode 方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEquals that = (TestEquals) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    /**
     * 添加散列条件 Objects.hash(objs..) 这样就可以使相同的属性值得到相同的结果
     * @return 返回散列值
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
