package com.dating.service.serviceImpl;

import com.dating.DAO.DatersDAO;
import com.dating.DAO.MessageDAO;
import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.DAO.TipsDAO;
import com.dating.DAO.UserDAO;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.Tips;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private DatersDAO datersDAO;

    @Resource
    private MessageDAO messageDAO;

    @Resource
    private TipsDAO tipsDAO;

    @Override
    public List<String> leaveMessage(MsgInfo msgInfo) {

        List<MsgInfo> msgList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (messageDAO.createMessage(msgInfo)) {
            String userName = msgInfo.getUserName();
            msgList = messageDAO.getMessage(userName);
        }
        while (!msgList.isEmpty()) {
            MsgInfo tmp = msgList.remove(0);
            result.add(new Gson().toJson(tmp));
        }
        return result;
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    @Override
    public UserInfo getInfoByUserName(String username) {
        return userDAO.getInfoByUserName(username);
    }

    @Override
    public List<UserInfo> getDaters(DaterRequestDTO daterRequestDTO) {
        List<UserInfo> daters = datersDAO.getDaters(daterRequestDTO);
        return daters;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        try {

            if (datersDAO.isExist(userInfo) != null)
                datersDAO.updateByUserName(userInfo);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUserInfo(UserInfo userInfo) {
        try {
            return datersDAO.deleteUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean insertUserAndUserInfo(User user, UserInfo userInfo) {

        try {
            datersDAO.insertUserInfo(userInfo);
            userDAO.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<String> getTips() {
        List<Tips> tipsList = tipsDAO.getTips();
        List<String> result = new ArrayList<>();

        while(!tipsList.isEmpty()){
            Tips tips = tipsList.remove(0);
            result.add(new Gson().toJson(tips));
        }
        return result;
    }

}
