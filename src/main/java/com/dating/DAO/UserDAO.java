package com.dating.DAO;

import com.dating.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

    public User findByUserName(String username);

}
