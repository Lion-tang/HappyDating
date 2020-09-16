package com.dating.Controller;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/getDaters", method = RequestMethod.GET)
    public List<String> getDaters(DaterRequestDTO daterRequestDTO) {
        //check
        //service(daterRequestDTO)
        List<String> response = userService.getDaters(daterRequestDTO);
        return response;
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
}
