package com.facetest.demo.Mybatis.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.facetest.demo.Mybatis.bean.Sku;
import com.facetest.demo.Mybatis.mapper.SkuMapper;

import com.facetest.demo.Mybatis.service.SkuService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SkuServiceByProImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    // Class 'SkuServiceImpl' must either be declared abstract or implement abstract method 'select(int)' in 'IService

}
