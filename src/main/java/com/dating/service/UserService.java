package com.dating.service;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.Dater;
import com.dating.pojo.User;

import java.util.List;

public interface UserService {
    public User findByUserName(String username);

    public String getDaters(DaterRequestDTO daterRequestDTO);
//    public User findByPassword(String username);
}

