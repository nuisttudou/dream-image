package com.dreamImage.controller;

import com.dreamImage.database.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ImgController {

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/img1")
    public String img1(Map<String,Object>map) {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            System.out.print("  ");
        }
////        System.out.println("my_img");
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return "photo/myphoto";
    }

    @GetMapping("/imgpro")
    public String imgpro(Map<String,Object>map) {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            System.out.print("  ");
        }
////        System.out.println("my_img");
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return "photo/myphotopro";
    }




    @GetMapping("/uploadimg")
    public String uploadimg(Map<String,Object> map) {
//        System.out.println("my_img");
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            System.out.print("  ");
        }
        return "upload/upload_img";
//        return "my_img_start";
    }

}
