package com.dating.service;

import com.dating.pojo.Tips;
import com.dating.pojo.UserInfo;

import java.util.List;

public interface AdminService {
    public List<UserInfo> getAllUserInfo();

    public boolean createTip(Tips tips);
}
