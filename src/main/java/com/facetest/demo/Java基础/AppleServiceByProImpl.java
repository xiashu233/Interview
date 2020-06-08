package com.facetest.demo.Java基础;

import com.facetest.demo.Java8.Apple;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 具体的实现类
 */
@Service
public class AppleServiceByProImpl implements AppleServiceByPro {
    @Override
    public Apple select(int id) {
        return null;
    }

    @Override
    public List<Apple> selectAll() {
        return null;
    }

    @Override
    public Apple change(Apple data) {
        return null;
    }
}
