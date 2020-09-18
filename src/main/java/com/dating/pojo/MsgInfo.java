package com.dating.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MsgInfo {
    private Long id;
    private String userName;
    private String fromUserName;
    private String info;
    private Long parentId;
    private String parentInfo;
    private Timestamp createTime;
    private String nickName;
    private String fromNickName;
}
