package com.dating.common;

import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.MsgInfo;
import com.dating.pojo.UserInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

public class ParameterCheckUtils {
    public static void checkMsgInfo(MsgInfo msgInfo) {
        try {
            Preconditions.checkNotNull(msgInfo);
            Preconditions.checkArgument(msgInfo.getUserName() != null, "用户名不存在");
            Preconditions.checkArgument(msgInfo.getFromUserName() != null, "通知用户名不存在");
            Preconditions.checkArgument(msgInfo.getInfo() != null, "不能发送空消息");
        } catch (Exception e) {
            throw new CheckBasicException(e.getMessage());
        }
        try{
            Preconditions.checkArgument(!msgInfo.getUserName().equals(msgInfo.getFromUserName()), "不能发送空消息");
        }catch (Exception e){

        }
    }

    public static void getCheckMsgInfo(MsgInfo msgInfo) {
        try {
            Preconditions.checkNotNull(msgInfo);
            Preconditions.checkArgument(msgInfo.getUserName() != null, "用户名不存在");
            Preconditions.checkArgument(msgInfo.getFromUserName() != null, "通知用户名不存在");
        } catch (Exception e) {
            throw new CheckBasicException(e.getMessage());
        }
    }

    public static void checkUserName(UserInfo userInfo) {
        try {
            Preconditions.checkNotNull(userInfo);
            Preconditions.checkArgument(!Strings.isNullOrEmpty(userInfo.getUserName()), "该用户不存在");
        } catch (Exception e) {
            throw new CheckBasicException(e.getMessage());
        }
    }

    public static void checkDaterRequestDTO(DaterRequestDTO daterRequestDTO) {

        if ("".equals(daterRequestDTO.getId())) {
            daterRequestDTO.setId(null);
        }
        if ("".equals(daterRequestDTO.getUserName())) {
            daterRequestDTO.setUserName(null);
        }
        if ("".equals(daterRequestDTO.getNickName())) {
            daterRequestDTO.setNickName(null);
        }
        if ("".equals(daterRequestDTO.getMaxHeight())) {
            daterRequestDTO.setMaxHeight(null);
        }
        if ("".equals(daterRequestDTO.getMinHeight())) {
            daterRequestDTO.setMinHeight(null);
        }
        if ("".equals(daterRequestDTO.getSex())) {
            daterRequestDTO.setSex(null);
        }
        if ("".equals(daterRequestDTO.getCity())) {
            daterRequestDTO.setCity(null);
        }
        if ("".equals(daterRequestDTO.getProvince())) {
            daterRequestDTO.setProvince(null);
        }
        if ("".equals(daterRequestDTO.getEdu())) {
            daterRequestDTO.setEdu(null);
        }
        if ("".equals(daterRequestDTO.getMaxAge())) {
            daterRequestDTO.setMaxAge(null);
        }
        if ("".equals(daterRequestDTO.getMinAge())) {
            daterRequestDTO.setMinAge(null);
        }
        if ("".equals(daterRequestDTO.getMaxWeight())) {
            daterRequestDTO.setMaxWeight(null);
        }
        if ("".equals(daterRequestDTO.getMinWeight())) {
            daterRequestDTO.setMinWeight(null);
        }
        if ("".equals(daterRequestDTO.getMaxSalary())) {
            daterRequestDTO.setMaxSalary(null);
        }
        if ("".equals(daterRequestDTO.getMinSalary())) {
            daterRequestDTO.setMinSalary(null);
        }
    }

    public static void checkNotNull(Object o) {
        Preconditions.checkArgument(o != null, "参数不能为空");
    }
}
