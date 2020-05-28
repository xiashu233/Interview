package com.facetest.demo.Mybatis.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Student implements Serializable,Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String stuDesc;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
