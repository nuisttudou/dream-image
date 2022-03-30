package com.dreamImage.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LogoutController {

    //登出
    @RequestMapping("/logout")
    @ResponseBody
    public String logout() {
        String str;

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        if (subject.isAuthenticated()) {
            str = "已登出";
        } else {
            str = "错误";
        }
        return str;
    }
}
