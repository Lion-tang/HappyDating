package com.dating.service;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;

import java.util.List;

public interface UserService {

    public User findByUserName(String username);

    public List<String> getDaters(DaterRequestDTO daterRequestDTO);

    public boolean updateUserInfo(UserInfo userInfo);

    public boolean deleteUser(UserInfo userInfo);

}

