package com.tsbx.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/8 14:29
 */
@Configuration
public class RestTemplateConfig {
    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
