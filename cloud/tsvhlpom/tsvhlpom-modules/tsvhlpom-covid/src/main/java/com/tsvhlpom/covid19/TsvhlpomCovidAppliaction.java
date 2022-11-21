package com.tsvhlpom.covid19;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomCovidAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomCovidAppliaction.class,args);
        System.out.println("双码管理系统启动成功");
    }
}

