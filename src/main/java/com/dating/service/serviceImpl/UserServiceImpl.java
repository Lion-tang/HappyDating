package com.dating.service.serviceImpl;

import com.dating.mapper.DatersMapper;
import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.mapper.UserMapper;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import com.dating.service.UserService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private DatersMapper datersMapper;


    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    public List<String> getDaters(DaterRequestDTO daterRequestDTO) {
        List<UserInfo> daters = datersMapper.getDaters(daterRequestDTO);
        List<String> result = new ArrayList<String>();
        while (!daters.isEmpty()) {
            UserInfo dater = daters.remove(0);
            result.add(new Gson().toJson(dater));
        }
        return result;
    }

    @Override
    public boolean alterUserInfo(UserInfo userInfo) {
        try {
            datersMapper.updateByUserName(userInfo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
