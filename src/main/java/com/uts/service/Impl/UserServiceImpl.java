package com.uts.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    public User check(String username, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);

        User user = this.getOne(wrapper);

        // user not exist
        if (user == null) {
            System.out.println("User Not Exist");
            return null;
        }

        // Incorrect Password
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect Password");
            return null;
        }
        return user;
    }
}
