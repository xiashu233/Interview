package com.facetest.demo.Mybatis.bean;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class Orders implements Serializable {

    private Integer orderId;

    private Student student;
}
