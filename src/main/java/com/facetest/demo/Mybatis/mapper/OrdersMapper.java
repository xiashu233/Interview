package com.facetest.demo.Mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.facetest.demo.Mybatis.bean.Orders;

import java.util.List;

public interface OrdersMapper extends BaseMapper<Orders> {

    List<Orders> selectOrderAndStudent(Integer studentId);

    List<Orders> selects();

    List<Orders> selects(Integer orderId);

}
