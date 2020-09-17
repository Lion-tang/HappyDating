package com.dating.common;

import com.dating.pojo.MsgInfo;
import com.dating.pojo.UserInfo;
import com.google.common.base.Preconditions;

public class ParameterCheckUtils {
    public static void checkMsgInfo(MsgInfo msgInfo) {
        try {
            Preconditions.checkNotNull(msgInfo);
            Preconditions.checkArgument(msgInfo.getUserName() == null, "用户名不存在");
            Preconditions.checkArgument(msgInfo.getFromUserName() == null, "通知用户名不存在");
            Preconditions.checkArgument(msgInfo.getInfo() == null, "不能发送空消息");
        } catch (Exception e) {
            throw new CheckBasicException(e.getMessage());
        }
    }

    public static void checkUserName(UserInfo userInfo){
        try {
            Preconditions.checkNotNull(userInfo);
            Preconditions.checkArgument(userInfo.getUserName() == null, "该用户不存在");
        } catch (Exception e) {
            throw new CheckBasicException(e.getMessage());
        }
    }
}
