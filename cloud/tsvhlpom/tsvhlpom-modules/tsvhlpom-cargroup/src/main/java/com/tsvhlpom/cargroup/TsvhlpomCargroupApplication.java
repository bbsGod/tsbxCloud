package com.tsvhlpom.cargroup;


import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
@EnableScheduling
public class TsvhlpomCargroupApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomCargroupApplication.class,args);
        System.out.println("私车团做系统启动成功");
    }
}
