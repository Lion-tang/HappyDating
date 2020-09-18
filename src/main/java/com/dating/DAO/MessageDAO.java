package com.dating.DAO;

import com.dating.pojo.MsgInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDAO {
    public boolean createMessage(MsgInfo msgInfo);

    public boolean updateMessageByUserName(MsgInfo msgInfo);

    public List<MsgInfo> getMessage(String userName);

    public boolean deleteMessage(MsgInfo msgInfo);
}
