package com.dating;


import com.dating.DAO.QueryDTO.DaterRequestDTO;

import com.dating.pojo.MsgInfo;
import com.dating.pojo.Tips;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import com.dating.service.AdminService;
import com.dating.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BlinddateApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private AdminService adminService;

    @Test
    void contextLoads() {
    }

    @Test
    void getDatersTest() {
        DaterRequestDTO daterRequestDTO = new DaterRequestDTO();
        daterRequestDTO.setEdu("中南大学");
        List<UserInfo> result = userService.getDaters(daterRequestDTO);
        System.out.println(result);
    }

    @Test
    void updateUserTest() {
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
    void deleteUserTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("yangyonzghi");
        System.out.println(userService.deleteUserInfo(userInfo));
    }

    @Test
    void insertUserInfoTest() {
        UserInfo userInfo = new UserInfo();
        User user = new User();
        String username = "yangyongzhi";
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
        System.out.println(userService.insertUserAndUserInfo(user, userInfo));
    }

    @Test
    void getMsg() {
        String userName = "";
    }

    @Test
    void leaveMsg(){
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setUserName("yangyongzhi");
        msgInfo.setFromUserName("wangwu");
        msgInfo.setInfo("你是傻子");
        System.out.println(userService.leaveMessage(msgInfo));
    }

    @Test
    void getTips(){
        System.out.println(userService.getTips());
    }

    @Test
    void createTips(){
        Tips tips = new Tips();
        tips.setInfo("这又是一条通知");
        tips.setUserName("yangyongzhi");
        System.out.println(adminService.createTip(tips));
    }
}
