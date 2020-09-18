package com.dating.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Tips {
    private Long id;
    private String userName;
    private String info;
    private Timestamp createTime;
    private Timestamp updateTime;
}
