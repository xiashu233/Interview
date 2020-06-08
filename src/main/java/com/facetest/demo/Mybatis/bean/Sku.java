package com.facetest.demo.Mybatis.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sku implements Serializable {
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
