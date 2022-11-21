package com.tsvhlpom.proddata;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomProdDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomProdDataApplication.class, args);
        System.out.println("车险运维系统启动成功");
    }

}
