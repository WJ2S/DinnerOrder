package com.uts.controller;

import com.alibaba.fastjson2.JSON;
import com.uts.config.Result;
import com.uts.entity.User;
import com.uts.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("login")
    public String login(String username, String password) {
        // 用户名密码校验
        Result<User> result = userService.login(username, password);
        // 结果返回
        return JSON.toJSONString(result);
    }


    @RequestMapping("signup")
    public String signup(String username, String email, String password) {
        // 用户注册
        Result<User> result = userService.signup(username, email, password);
        // 结果返回
        return JSON.toJSONString(result);
    }

    @RequestMapping("find_my_password")
    public String findMyPassword(String username, String email) {
        System.out.println(username);
        System.out.println(email);
        // 查找用户
        Result<User> result = userService.find_my_password(username, email);
        // 结果返回
        return JSON.toJSONString(result);
    }
}
