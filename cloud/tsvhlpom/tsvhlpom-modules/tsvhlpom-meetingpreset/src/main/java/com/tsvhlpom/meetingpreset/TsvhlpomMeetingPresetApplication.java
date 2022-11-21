package com.tsvhlpom.meetingpreset;

import com.tsvhlpom.common.security.annotation.EnableCustomConfig;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class TsvhlpomMeetingPresetApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsvhlpomMeetingPresetApplication.class,args);
        System.out.println("会议预定系统启动成功！");
    }
}
