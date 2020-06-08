package com.facetest.demo.Mybatis.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Sku {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Double price;
    private String skuName;
    private String skuDesc;
    private Double weight;
    private Integer tmId;
    private Integer catalog3Id;
    private String skuDefaultImg;
}
