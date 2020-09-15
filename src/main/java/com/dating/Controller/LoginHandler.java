package com.dating.Controller;

import com.dating.pojo.User;
import com.dating.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginHandler {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLoginHandler(String username, String password) {
        //非安全认证模式
//        User user = userService.findByUserName(username);
//        if (user != null) {
//            if (password.equals(user.getPassword())) {
//                return "login";
//            } else
//                return "";
//        } else return "";
        //安全认真模式
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            User user = (User) subject.getPrincipal();
            return "main";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            mo
        }

    }

    @GetMapping("/{url}")
    public String urlHandler(@PathVariable("url") String url)
    {
        return url;
    }

}
