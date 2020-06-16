package com.facetest.demo.设计模式.原型模式;

import java.io.Serializable;

/**
 * 也叫复制模式 主要是使用到了深层 clone
 * 深层 clone：不光本类实现了 Serializable,Cloneable 接口，本类中的引用类型的属性也需要实现这两个接口，
 */
public class WorkExeperience implements Serializable,Cloneable {
    private String workDate;
    private String company;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "WorkExeperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
