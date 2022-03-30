package com.dreamImage.controller;

import com.dreamImage.database.Boardcontext;
import com.dreamImage.database.Boardcontextwith;
import com.dreamImage.database.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class Maincontroller {

    @Autowired
    SqlSession sqlSession;

    @GetMapping("aboutme")
    public String aboutme(Map<String,Object> map){
        Subject currentUserId = SecurityUtils.getSubject();
        User user = (User) currentUserId.getPrincipal();
        User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
        map.put("justside", user2);

        return "aboutme";
    }

    @GetMapping("/isok")
    public String isok() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "isok";
    }


    @GetMapping("/test")
    public String test(Map<String,Object>map) {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            System.out.print("  ");
        }
//        System.out.println("my_img");
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return "upload/index";
//        return "my_img_start";
    }


    @GetMapping("/yourselfmessages")
    public String yourselfmessages(Map<String,Object>map) {
        Subject currentUserId = SecurityUtils.getSubject();
        User user = (User) currentUserId.getPrincipal();
        User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
        map.put("justside", user2);

        return "yourselfmessages";
    }






    @PostMapping("/errorcode")
    public String errorcode(Map<String, Object> map) {
        map.put("ismessage", "");
        return "login";
    }





    @PostMapping("/wirtedatahtml")
    public String postwirtedatahtml(String title, String con, String selectinput,String justforurl) {
        User user = null;
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            user = (User) currentUserId.getPrincipal();
            user.getUsername();
        } catch (Exception e) {
            System.out.print("er");
            return "/login";
        }
        Boardcontext c = new Boardcontext();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        c.setCreatedtime(sdf.format(d));
        c.setTitle(title);
        c.setContext(con);
        c.setUser(user.getUsername());
        sqlSession.insert(selectinput, c);
        return "redirect:/"+justforurl;
    }

    @PostMapping("/wirtedatahtmlwith")
    public String postwirtedatahtmlwith(String con, int withc, String justforurl,String intodbwith) {
        User user = null;
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            user = (User) currentUserId.getPrincipal();
            user.getUsername();
        } catch (Exception e) {
            System.out.print("e");
            return "/login";
        }

        Boardcontextwith c = new Boardcontextwith();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        c.setCreatedtime(sdf.format(d));
        c.setContext(con);
        c.setWithc(withc);
        c.setUser(user.getUsername());
        sqlSession.insert(intodbwith, c);
        return "redirect:" + justforurl;
    }


    @GetMapping("/wirtedatahtml")
    public String wirtedatahtml(Map<String, Object> map) {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            return "/login";
        }

        return "wirtedatahtml";
    }

    @RequestMapping({"/", "/index"})
    public String index(Map<String, Object> map) {
        try {
            Subject currentUserId = SecurityUtils.getSubject();
            User user = (User) currentUserId.getPrincipal();
            User user2 = sqlSession.selectOne("mainmapper.getuser", user.getUsername());
            map.put("justside", user2);
        } catch (Exception e) {
            System.out.print("  ");
        }

        return "index";
    }

}
