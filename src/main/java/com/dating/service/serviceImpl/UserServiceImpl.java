package com.dating.service.serviceImpl;

import com.dating.pojo.User;
import com.dating.mapper.UserMapper;
import com.dating.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByusername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
