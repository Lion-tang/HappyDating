package com.dating.Controller;

import com.dating.pojo.User;
import com.dating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginHandler {
    @Autowired
    private UserService userServiceImpl;


    @PostMapping("/user")
    public void userLoginHandler(User user) {
    }

}
