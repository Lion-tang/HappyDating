package com.dating;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dating.DAO")
public class BlinddateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlinddateApplication.class, args);
    }

}
