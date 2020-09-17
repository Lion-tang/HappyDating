package com.dating.DAO;

import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    public User findByUserName(String username);

    public boolean insertUser(User user);

    public UserInfo getInfoByUserName(String username);

}
