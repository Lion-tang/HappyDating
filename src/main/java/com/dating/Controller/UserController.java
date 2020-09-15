package com.dating.Controller;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.Dater;
import com.dating.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getDaters")
    public String getDaters(DaterRequestDTO daterRequestDTO){
        //check
        //service(daterRequestDTO)
        String response = userService.getDaters(daterRequestDTO);
        return response;
    }
}
