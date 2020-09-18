package com.dating.Controller;

import com.dating.pojo.Tips;
import com.dating.pojo.UserInfo;
import com.dating.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller(value = "/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/manage")
    public String adminHandler() {
        List<UserInfo> userInfos = adminService.getAllUserInfo();
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("userInfos",userInfos);
        return "admin";
    }

    @RequestMapping(value = "/tips")
    public boolean createTips(Tips tips){

        return adminService.createTip(tips);

    }
}
