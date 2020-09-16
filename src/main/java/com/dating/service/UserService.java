package com.dating.service;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;

import java.util.List;

public interface UserService {

    public List<String> leaveMessage(MsgInfo msgInfo);

    public User findByUserName(String username);

    public List<String> getDaters(DaterRequestDTO daterRequestDTO);

    public boolean updateUserInfo(UserInfo userInfo);

    public boolean deleteUserInfo(UserInfo userInfo);

    public boolean insertUserAndUserInfo(User user, UserInfo userInfo);

    public List<String> getTips();


}

