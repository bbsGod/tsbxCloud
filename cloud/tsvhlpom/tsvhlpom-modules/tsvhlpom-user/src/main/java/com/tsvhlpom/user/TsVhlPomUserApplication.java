package com.tsvhlpom.user;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsVhlPomUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsVhlPomUserApplication.class, args);
		System.out.println("user管理系统，启动成功");
	}

}
