package com.tsvhlpom.prod26;


import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomProd26Application {

    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomProd26Application.class,args);
        System.out.println("prod26 启动成功");
    }
}
