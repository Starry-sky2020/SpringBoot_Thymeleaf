package com.starry_sky.yang.service;

import com.starry_sky.yang.pojo.User;

public interface UserService {

    /**
     * 注册
     * 添加数据
     */
    void register(User user);

    /**
     * 登录
     * 用户登录进行信息验证
     */
    User login(String username, String password);
}
