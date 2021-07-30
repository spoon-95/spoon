package com.wsp.spoon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.wsp.**.mapper")
@EnableCaching
public class SpoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpoonApplication.class, args);
    }

}
