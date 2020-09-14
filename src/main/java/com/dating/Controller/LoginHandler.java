package com.dating.Controller;

import com.dating.pojo.User;
import com.dating.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;

@Controller

public class LoginHandler {
    @Autowired
    private UserService userServiceImpl;


    @PostMapping("/login")
    public void userLoginHandler(String username,String password) {

    }

}
