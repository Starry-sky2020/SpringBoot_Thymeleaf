package com.starry_sky.yang.dao;

import com.starry_sky.yang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    /**
     * 查询用户信息
     * 用于判断所注册用户名是否已经存在
     *
     * @param username
     * @return
     */
    User findByUserName(@Param("username") String username);

    /**
     * 保存用户信息
     * 用户注册，将用户信息保存
     *
     * @param user
     */
    void save(User user);
}
