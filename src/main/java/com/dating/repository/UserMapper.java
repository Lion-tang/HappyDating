package com.dating.repository;

import com.dating.pojo.User;


public interface UserMapper {
    public User findByUsername(String username);

}
