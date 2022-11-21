package com.tsvhlpom.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.tsvhlpom.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 *
 * @author taishanpic
 */
@EnableRyFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TsVhlPomAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TsVhlPomAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
