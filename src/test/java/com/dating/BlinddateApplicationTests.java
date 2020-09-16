package com.dating;


import com.dating.DAO.QueryDTO.DaterRequestDTO;

import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BlinddateApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void getDatersTest(){
        DaterRequestDTO daterRequestDTO = new DaterRequestDTO();
        daterRequestDTO.setEdu("中南大学");
        List<String> result = userService.getDaters(daterRequestDTO);
        System.out.println(result);
    }

    @Test
    void updateUserTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yangyongzhi");
        userInfo.setNickName("真爱已死");
        userInfo.setAge(22);
        userInfo.setEdu("中南大学");
        userInfo.setCity("长沙");
        userInfo.setProvince("湖南");
        userInfo.setHeight(173);
        userInfo.setWeight(69);
        userInfo.setTelephone(13978884549L);
        userInfo.setSalary(15);
        System.out.println(userService.updateUserInfo(userInfo));
    }

    @Test
    void deleteUserTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yangyonzghi");
        System.out.println(userService.deleteUserInfo(userInfo));
    }

    @Test
    void insertUserInfoTest() {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        String username = "wangwu";
        user.setUserName(username);
        user.setPassWord("123456");
        userInfo.setUserName(username);
        userInfo.setNickName("真爱已死");
        userInfo.setAge(22);
        userInfo.setEdu("中南大学");
        userInfo.setHeight(173);
        userInfo.setWeight(69);
        userInfo.setTelephone(13978884549L);
        userInfo.setSalary(20);
        userInfo.setCity("长沙");
        userInfo.setProvince("湖南");
        System.out.println(userService.insertUserAndUserInfo(user,userInfo));
    }
}
