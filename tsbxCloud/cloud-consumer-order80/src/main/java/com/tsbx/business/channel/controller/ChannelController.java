package com.tsbx.business.channel.controller;

import com.tsbx.business.channel.pojo.MesChannel;
import com.tsbx.common.entities.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 通过restTemplate 调用provide服务提供的接口
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/8 14:31
 */
@RestController
@Slf4j
public class ChannelController {
    public static final String CHANNEL_URL = "http://localhost:8001";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/getChannel")
    public ApiResponse<MesChannel> getChannle(){
        return  restTemplate.getForObject(CHANNEL_URL+"/getChannel",ApiResponse.class);
        
    }
    
}
