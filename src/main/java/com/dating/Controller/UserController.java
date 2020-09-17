package com.dating.Controller;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.common.ParameterCheckUtils;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getDaters", method = RequestMethod.GET)
    public String getDaters(DaterRequestDTO daterRequestDTO) {
        //check
        //service(daterRequestDTO)
        List<String> response = userService.getDaters(daterRequestDTO);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("daters", response);
        return "park-xunren";
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public String updateUserInfo(UserInfo userInfo) {
        if (userService.updateUserInfo(userInfo)) {
            return "成功";
        }
        return "失败";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String delete(UserInfo userInfo) {
        if (userService.deleteUserInfo(userInfo)) {
            return "成功";
        }
        return "失败";
    }

    @RequestMapping(value = "/leaveMsg", method = RequestMethod.POST)
    public List<String> leaveMessage(MsgInfo msgInfo) {
        ParameterCheckUtils.checkMsgInfo(msgInfo);
        return userService.leaveMessage(msgInfo);
    }

    @RequestMapping(value = "/gettips", method = RequestMethod.GET)
    public List<String> getTips() {
        return userService.getTips();
    }

}
