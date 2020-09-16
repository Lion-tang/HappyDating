package com.dating.Controller;

import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import com.mysql.cj.xdevapi.Session;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class LoginHandler {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
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

    @PostMapping("/register1")
    public String register1Handler(User user, Model model,HttpSession httpSession) {

        if (userService.findByUserName(user.getUserName())==null) {
            httpSession.setAttribute("user",user);
            return "register2";
        } else {
            model.addAttribute("msg", "您的用户名已被注册，请重新输入");
            return "register1";
        }
    }

    @PostMapping("register2")
    public String register2Handler(HttpSession httpSession,Model model,String nickName, Integer age, String sex, String city, String province, Integer height, Integer weight, String edu, Integer salary, Long telephone,String check) {
        if (check!=null) {
            if (nickName!=null && telephone!=null) {
                User user= (User) httpSession.getAttribute("user");
                UserInfo userInfo = new UserInfo(null,user.getUserName(),nickName,age,sex,city,province,height,weight,edu,salary,telephone);
                userService.insertUserAndUserInfo(user, userInfo);
                model.addAttribute("msg", "账户注册成功");
                return "index";
            } else if (nickName == null) {
                model.addAttribute("msg", "昵称为空，请重新输入");
                return "register2";
            } else {
                model.addAttribute("msg", "电话号码为空，请重新输入");
                return "register2";
            }
        } else {
            model.addAttribute("msg", "需要同意协议才能注册用户");
            return "register2";
        }

    }

    @GetMapping("register")
    public String reisgerStarter() {
        return "register1";
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
