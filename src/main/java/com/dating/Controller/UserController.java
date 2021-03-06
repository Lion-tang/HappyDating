package com.dating.Controller;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.common.CheckBasicException;
import com.dating.common.ParameterCheckUtils;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getDaters", method = RequestMethod.GET)
    public String getDaters(DaterRequestDTO daterRequestDTO) {
        //check
        //service(daterRequestDTO)
        ParameterCheckUtils.checkDaterRequestDTO(daterRequestDTO);
        List<UserInfo> response = userService.getDaters(daterRequestDTO);
        Subject subject = SecurityUtils.getSubject();
        if (response.size() > 0) {
            daterRequestDTO.setSex(response.get(0).getSex());
        }
        subject.getSession().setAttribute("daters", response);
        if (daterRequestDTO.getSex().equals("女")) {
            return "park-xunren";
        } else {
            return "park-xunren-man";

        }
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public String updateUserInfo(UserInfo userInfo) {
        if (userService.updateUserInfo(userInfo)) {
            Subject subject = SecurityUtils.getSubject();
            userInfo = userService.getInfoByUserName(userInfo.getUserName());
            subject.getSession().setAttribute("userInfo",userInfo);
            System.out.println("更新成功");
            return "myaccount";
        }
        return "myaccount";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String delete(UserInfo userInfo) {
        if (userService.deleteUserInfo(userInfo)) {
            return "成功";
        }
        return "失败";
    }

    @RequestMapping(value = "/leaveMsg", method = RequestMethod.POST)
    public String leaveMessage(MsgInfo msgInfo) {
        ParameterCheckUtils.checkMsgInfo(msgInfo);
        List result = userService.leaveMessage(msgInfo);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("msgInfoList", result);
        return "getMsg";
    }

    @RequestMapping(value = "/leaveMsg1", method = RequestMethod.POST)
    public String leaveMessage1(MsgInfo msgInfo) {
        ParameterCheckUtils.checkMsgInfo(msgInfo);
        List result = userService.leaveMessage(msgInfo);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("msgInfoList", result);
        return "myMsg";
    }

    @RequestMapping(value = "/getMsg", method = RequestMethod.GET)
    public String getMessage(MsgInfo msgInfo) {
        ParameterCheckUtils.getCheckMsgInfo(msgInfo);
        List result = userService.getMessage(msgInfo);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("msgInfoList", result);
        return "getMsg";
    }

    @RequestMapping(value = "/myMsg", method = RequestMethod.GET)
    public String myMsg(MsgInfo msgInfo) {
        ParameterCheckUtils.checkNotNull(msgInfo);
        if (Strings.isNullOrEmpty(msgInfo.getUserName())){
         throw new CheckBasicException("用户名不能为空");
        }
        List<MsgInfo> result = userService.getMessage(msgInfo);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("msgInfoList", result);
        return "myMsg";
    }

    @RequestMapping(value = "/gettips", method = RequestMethod.GET)
    public List<String> getTips() {
        return userService.getTips();
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(UserInfo userInfo) {
        ParameterCheckUtils.checkUserName(userInfo);
        UserInfo user = userService.getInfoByUserName(userInfo.getUserName());
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("visitUser", user);
        return "details";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter(UserInfo userInfo) {
        return "filter";
    }

}
