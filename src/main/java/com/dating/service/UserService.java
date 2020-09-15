package com.dating.service;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;

public interface UserService {

    public User findByUserName(String username);

    public String getDaters(DaterRequestDTO daterRequestDTO);

    public boolean alterUserInfo(UserInfo userInfo);

}

