package com.tsvhlpom.dailywork;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomDailyWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomDailyWorkApplication.class,args);
        System.out.println("每日工作日志管理系统 启动成功");
    }
}
