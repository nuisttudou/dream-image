package com.dreamImage.controller;

import com.dreamImage.database.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    //登录，同名, 参数不同
    @GetMapping("/login")
    public String login() {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            user.getUsername();
            return "redirect:/index";
        } catch (Exception e) {
            return "login";
        }
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        String exception = (String) request.getAttribute("shiroLoginFailure");
        if (exception != null) {
            map.put("ismessage", "");
            return "login";
        }
        return "/index";
    }
}
