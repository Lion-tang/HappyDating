package com.dating.mapper.QueryDTO;

import lombok.Data;

@Data
public class DaterRequestDTO {
    private String name;
    private Integer min_age;
    private Integer max_age;
    private String sex;
    private Integer min_height;
    private Integer max_height;
    private Integer max_weight;
    private Integer min_weight;
    private String edu;
    private Integer min_salary;
    private Integer max_salary;
    private Integer telephone;
}
