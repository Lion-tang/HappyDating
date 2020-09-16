package com.dating.service.serviceImpl;

import com.dating.DAO.TipsDAO;
import com.dating.pojo.Tips;
import com.dating.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceIMpl implements AdminService {

    @Resource
    private TipsDAO tipsDAO;

    @Override
    public boolean createTip(Tips tips) {
        return tipsDAO.createTip(tips);
    }
}
