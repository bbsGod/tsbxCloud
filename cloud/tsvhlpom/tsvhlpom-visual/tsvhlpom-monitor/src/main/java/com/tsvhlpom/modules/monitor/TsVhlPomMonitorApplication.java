package com.tsvhlpom.modules.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 监控中心
 *
 * @author taishanpic
 */
@EnableAdminServer
@SpringBootApplication
public class TsVhlPomMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TsVhlPomMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ ");
    }
}
