package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.dao.UserDao;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.io.DataInput;
import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        //查询用户名是否已经存在
        User userDB = userDao.findByUserName(user.getUsername());
        //判断用户是否已经存在
        if (!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("当前用户名已被注册");
        //注册用户 并将明文密码加密
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(md5DigestAsHex);

        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        //获取查询到的用户密码
        User byUserName = userDao.findByUserName(username);
        //将获取到的用户密码加密  利用md5加密特性，对统一密码加密后的字符串相同
        String digestAsHex = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        //输入的用户名为空
        System.out.println("hell: "+byUserName.getUsername());
        if (ObjectUtils.isEmpty(byUserName)) throw new RuntimeException("用户不存在");
        //比较密码
        System.out.println("hell: "+byUserName.getPassword());
        System.out.println("hell: "+digestAsHex);
        if (!byUserName.getPassword().equals(digestAsHex)) throw new RuntimeException("密码错误");
        //程序走到这，说明验证成功，用户可以登录
        return byUserName;
    }
}
