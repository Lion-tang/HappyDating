package com.dating.DAO.QueryDTO;

import lombok.Data;

@Data
public class DaterRequestDTO {
    private Long id;
    private String userName;
    private String nickName;
    private Integer age;
    private String sex;
    private Integer height;
    private Integer weight;
    private String edu;
    private Integer salary;
    private Long telephone;
    private String name;
    private Integer minAge;
    private Integer maxAge;
    private Integer minHeight;
    private Integer maxHeight;
    private Integer maxWeight;
    private Integer minWeight;
    private Integer minSalary;
    private Integer maxSalary;
}
