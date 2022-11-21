package com.tsvhlpom.batchdata;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomBatchdataApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomBatchdataApplication.class,args);
        System.out.println("跑批数据系统启动成功");
    }
}
