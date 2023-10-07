package com.uts.controller;

import com.alibaba.fastjson2.JSON;
import com.uts.config.Result;
import com.uts.entity.User;
import com.uts.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("login")
    public String login(String username, String password) {
        // 用户名密码校验
        User user = userService.check(username, password);
        if (user != null) {
            // 验证通过，跳转至首页
            return JSON.toJSONString(Result.success(user));
        }
        // 验证未通过，返回登录页并提示
        return JSON.toJSONString(Result.error("username or password incorrect"));
    }


    @RequestMapping("signup")
    public String signup(String username, String password) {

        // todo 注册逻辑
        System.out.println(username);
        System.out.println(password);

        // todo 页面跳转
        return "home";
    }
}
