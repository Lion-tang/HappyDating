package com.dating.pojo;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String userName;
    private String nickName;
    private Integer age;
    private String sex;
    private String city;
    private String province;
    private Integer height;
    private Integer weight;
    private String edu;
    private Integer salary;
    private Long telephone;
}
