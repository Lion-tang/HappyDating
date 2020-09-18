package com.dating.service;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;

import java.util.List;

public interface UserService {

    public List<MsgInfo> leaveMessage(MsgInfo msgInfo);

    public List<MsgInfo> getMessage(MsgInfo msgInfo);

    public User findByUserName(String username);

    public UserInfo getInfoByUserName(String username);

    public List<UserInfo> getDaters(DaterRequestDTO daterRequestDTO);

    public boolean updateUserInfo(UserInfo userInfo);

    public boolean deleteUserInfo(UserInfo userInfo);

    public boolean insertUserAndUserInfo(User user, UserInfo userInfo);

    public List<String> getTips();


}

