package com.dating.service.serviceImpl;

import com.dating.DAO.DatersDAO;
import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.DAO.UserDAO;
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
    private UserDAO userDAO;

    @Resource
    private DatersDAO datersDAO;


    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    public List<String> getDaters(DaterRequestDTO daterRequestDTO) {
        List<UserInfo> daters = datersDAO.getDaters(daterRequestDTO);
        List<String> result = new ArrayList<String>();
        while (!daters.isEmpty()) {
            UserInfo dater = daters.remove(0);
            result.add(new Gson().toJson(dater));
        }
        return result;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        try {
            datersDAO.isExist(userInfo);
            datersDAO.updateByUserName(userInfo);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(UserInfo userInfo) {
        try{
            return datersDAO.deleteUser(userInfo);
        }catch (Exception e){
            return false;
        }
    }

}
