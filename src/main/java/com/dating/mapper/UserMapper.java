package com.dating.mapper;

import com.dating.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public User findByUserName(String username);

    public boolean insertUser(User user);

}
