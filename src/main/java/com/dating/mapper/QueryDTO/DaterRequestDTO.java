package com.dating.mapper.QueryDTO;

import lombok.Data;

@Data
public class DaterRequestDTO {
    private Long id;
    private String userName;
    private String nick_name;
    private Integer age;
    private String sex;
    private Integer height;
    private Integer weight;
    private String edu;
    private Integer salary;
    private Long telephone;
    private String name;
    private Integer min_age;
    private Integer max_age;
    private Integer min_height;
    private Integer max_height;
    private Integer max_weight;
    private Integer min_weight;
    private Integer min_salary;
    private Integer max_salary;
}
