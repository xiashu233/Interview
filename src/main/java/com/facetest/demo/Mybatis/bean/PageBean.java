package com.facetest.demo.Mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装的页面类型
 * @param <T> 泛型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean<T> {
    private long pages;
    private T pageData;
    private int pageNum;
    private int pageSize;
    private long total;
    private Boolean hasPrev;
    private Boolean hasNext;
}
