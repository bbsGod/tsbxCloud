package com.tsbx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/7 0:11
 */
@MapperScan("com.tsbx.*.*.dao")
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
public class payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(payment8001Application.class, args);
    }
    
}
