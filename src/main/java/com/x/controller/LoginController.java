package com.x.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("login")
    public String hello(String username, String password) {

        // todo 登录逻辑校验
        System.out.println(username);
        System.out.println(password);

        // todo 页面跳转
        return "main";
    }
}
