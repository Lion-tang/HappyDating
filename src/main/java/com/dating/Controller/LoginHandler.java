package com.dating.Controller;

import com.dating.pojo.User;
import com.dating.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginHandler {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLoginHandler(String username, String password,Model model) {
        //非安全认证模式
//        User user = userService.findByUserName(username);
//        if (user != null) {
//            if (password.equals(user.getPassword())) {
//                return "login";
//            } else
//                return "";
//        } else return "";

        //安全认证模式
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            User user = (User) subject.getPrincipal();
            subject.getSession().setAttribute("user",user);
            return "myaccount";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg", "用户名错误");
            return "index";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            e.printStackTrace();
            return "index";
        }
        }




    @GetMapping("/{url}")
    public String urlHandler(@PathVariable("url") String url)
    {
        return url;
    }

    @GetMapping("/logout")
    public String logoutHandler() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }

    @GetMapping("/unauthc")
    @ResponseBody
    public String unauthcHandler() {
        return "未验证用户，请登录";
    }
}
