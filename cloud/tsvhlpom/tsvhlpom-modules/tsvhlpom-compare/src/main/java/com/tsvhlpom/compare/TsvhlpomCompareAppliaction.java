package com.tsvhlpom.compare;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomCompareAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomCompareAppliaction.class,args);
        System.out.println("启动成功");
    }
}

