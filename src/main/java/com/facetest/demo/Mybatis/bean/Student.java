package com.facetest.demo.Mybatis.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.io.Serializable;

/**
 * 实体类 Student 对应数据库Student表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable,Cloneable {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.INPUT)
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String stuDesc;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
