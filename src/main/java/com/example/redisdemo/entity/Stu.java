package com.example.redisdemo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Stu {

    private Integer id;
    private String name;
    private Integer age;
    private String dept;

    public Stu(Integer id, String name, Integer age, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

}
