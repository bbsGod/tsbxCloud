package com.tsbx.business.channel.controller;

import com.alibaba.fastjson.JSON;
import com.tsbx.business.channel.pojo.MesChannel;
import com.tsbx.business.nacos.controller.service.PaymentFeignService;
import com.tsbx.entities.ApiResponse;

import com.tsbx.common.annotation.Log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @Autowired
    private PaymentFeignService paymentFeignService;
    
   
    @GetMapping("/getChannel")
    public ApiResponse<MesChannel> getChannle(){
        return  restTemplate.getForObject(CHANNEL_URL+"/getChannel",ApiResponse.class);
        
    }
    @Log
    @GetMapping("/logTest")
    public ApiResponse<MesChannel> logTest(){
        ApiResponse<MesChannel> mesChannel = new ApiResponse<>();
        log.info("调用方法成功，返回结果");
        return  mesChannel;
    }

    @GetMapping("/getPayment")
    public ApiResponse<List<MesChannel>> getPayment(){

        ApiResponse<List<MesChannel>> apiResponse = paymentFeignService.getChannel();


        return apiResponse;
    }
}
