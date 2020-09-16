package com.dating;

import org.apache.shiro.io.ResourceUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@MapperScan("com.dating.DAO")
public class BlinddateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlinddateApplication.class, args);
    }


}
