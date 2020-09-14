package com.dating.service.serviceImpl;

import com.dating.pojo.User;
import com.dating.repository.UserMapper;
import com.dating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByusername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
