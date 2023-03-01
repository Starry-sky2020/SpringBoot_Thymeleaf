package com.starry_sky.yang.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Employee {

    private Integer id;
    private String  name;
    private Double  salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //图像路径
    private String  photo;
}
