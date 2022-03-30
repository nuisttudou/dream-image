package com.dreamImage.controller;

import com.dreamImage.database.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ReguserController {
    @Autowired
    SqlSession sqlSession;
    // 注册部分
    @PostMapping("/reguser")
    public String postreguser(String username, String password, String roles, String userpics, String messages, HttpSession session, HttpServletRequest request, Map<String,Object> map) {
        HttpSession getsession = request.getSession();
        String captruecode = (String) getsession.getAttribute("captruecode");
        String verification = request.getParameter("captruecode");
        if (!verification.contentEquals(captruecode)) {
            return "redirect:/error";
        }



        User user = new User();
        user.setUsername(username);
        user.setPassword(password);//TODO MD5

        user.setUserroles(roles);
        user.setUserpics(userpics);
        user.setMessages(messages);
        sqlSession.insert("mainmapper.reguser",user);
//        map.put("ismessage","");

//        return "reguser";
        map.put("finish_register","");
        return "login";
    }

    @GetMapping("/reguser")
    public String reguser() {
        return "reguser";
    }
}
