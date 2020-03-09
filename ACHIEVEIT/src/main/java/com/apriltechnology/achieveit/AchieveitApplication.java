package com.apriltechnology.achieveit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.apriltechnology.achieveit.mapper")
public class AchieveitApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchieveitApplication.class, args);
    }

}
