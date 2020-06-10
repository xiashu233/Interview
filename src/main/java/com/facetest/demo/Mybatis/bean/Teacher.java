package com.facetest.demo.Mybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher  extends Person implements Serializable {
    private Integer teacherId;

  // private Integer studentId;

    @Transient
    private List<Student> students;
}
