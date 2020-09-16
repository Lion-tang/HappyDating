package com.dating.Controller;

import com.dating.pojo.Tips;
import com.dating.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller(value = "/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/tips")
    public boolean createTips(Tips tips){

        return adminService.createTip(tips);

    }
}
