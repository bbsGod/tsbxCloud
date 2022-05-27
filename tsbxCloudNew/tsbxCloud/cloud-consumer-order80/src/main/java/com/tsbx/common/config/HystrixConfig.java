package com.tsbx.common.config;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class HystrixConfig {
    @PostConstruct
    public void init(){
        HystrixPlugins.getInstance().registerConcurrencyStrategy(
                new MyHystrixConcurrencyStrategy()
        );
    }
}
