package com.starry_sky.yang.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String username;
    private String realname;
    private String password;
    private Integer gender;
}
