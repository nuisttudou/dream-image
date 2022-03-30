package com.dreamImage.controller;

import com.dreamImage.database.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    SqlSession sqlSession;
    @PostMapping("/yourselfmessages")
    public String postyourselfmessages(String username, String password, String roles, String userpics, String messages, Map<String,Object> map) {
        User user = new User();
        if (username.length()<=0){
            map.put("ismessage","");
            return "yourselfmessages";
        }
        if (password.length()<=0){
            map.put("ismessage","");
            return "yourselfmessages";
        }
        if (roles.length()<=0){
            map.put("ismessage","");
            return "yourselfmessages";
        }
        if (userpics.length()<=0){
            map.put("ismessage","");
            return "yourselfmessages";
        }
        if(messages.length()<=0){
            map.put("ismessage","");
            return "yourselfmessages";
        }

        Subject currentUserId = SecurityUtils.getSubject();
        User getuser = (User) currentUserId.getPrincipal();
        User getuser2 = sqlSession.selectOne("mainmapper.getuser",getuser.getUsername());
        user.setId(getuser2.getId());
        user.setMessages(messages);
        user.setUserpics(userpics);
        user.setPassword(password);//MD5
        user.setUsername(username);
        user.setUserroles(roles);
        sqlSession.update("mainmapper.changesuser",user);
        return "redirect:/isok";
    }

}
