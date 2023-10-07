package com.uts.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uts.config.Result;
import com.uts.dao.UserMapper;
import com.uts.entity.User;
import com.uts.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Author: Shaobo
 * Date: 2023/10/6
 * Describe:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public Result<User> login(String username, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);

        User user = this.getOne(wrapper);

        // 用户名不存在
        if (user == null) {
            return Result.error("user not exists");
        }

        // 用户名密码不匹配
        if (!user.getPassword().equals(password)) {
            System.out.println("incorrect password");
            return Result.error("incorrect password");
        }

        // 登录成功
        return Result.success(user);
    }


    public Result<User> signup(String username, String email, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        User user;

        // 通过用户名查找
        wrapper.eq(User::getUsername, username);
        user = this.getOne(wrapper);
        // 若该用户名已存在，则注册失败
        if (user != null) {
            return Result.error("username exists");
        }

        // 通过邮箱查找
        wrapper.eq(User::getEmail, email);
        user = this.getOne(wrapper);
        // 若该邮箱已存在，则注册失败
        if (user != null) {
            return Result.error("email exists");
        }

        // 注册成功，插入新数据
        user = new User(username, email, password);
        this.save(user);
        return Result.success(user);
    }
}
