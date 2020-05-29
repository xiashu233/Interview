package com.facetest.demo.Java基础;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 实现 Serializable 接口标注该类为可序列化的类
 * 序列化的作用 以及好处
 * 当一个类需要保存在本地或者需要在网络中传输的时候 则需要序列化了 否则可能会造成数据丢失等
 */
@Data
public class SerializableDemo implements Serializable {

    private String name;

    // 在序列化的类字段前加入该注解 可以使字段不被序列化
    @Transient
    @NotNull
    private Integer age;

    // transient 关键字同等作用
    private transient Double weight;
}
