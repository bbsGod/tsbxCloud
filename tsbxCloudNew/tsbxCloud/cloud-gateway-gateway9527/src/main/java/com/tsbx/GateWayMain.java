package com.tsbx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/8/17 9:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayMain {
    public static void main(String[] args) {
        SpringApplication.run( GateWayMain.class,args);
    }
}
