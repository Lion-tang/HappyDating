package com.dating.mapper;

import com.dating.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User findByUsername(String username);

//    public User findByPassword(String username);
}
