package com.tsvhlpom.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.tsvhlpom.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 *
 * @author taishanpic
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TsVhlPomFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TsVhlPomFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文件服务模块启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }
}
