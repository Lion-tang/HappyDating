package com.dating.DAO;

import com.dating.pojo.MsgInfo;
import com.dating.pojo.Tips;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipsDAO {
    public List<Tips> getTips();

    public boolean createTip(Tips tips);
}
