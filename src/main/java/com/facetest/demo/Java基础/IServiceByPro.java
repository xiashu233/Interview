package com.facetest.demo.Java基础;

import com.facetest.demo.Java8.Apple;

import java.util.List;

/**
 * 通用化接口
 * @param <T>
 */
public interface IServiceByPro<T> {

    T select(int id);

    List<T> selectAll();

    T change(T data);
}
