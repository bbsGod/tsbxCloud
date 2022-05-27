package com.tsbx.business.channel.controller;

import com.alibaba.fastjson.JSON;
import com.tsbx.business.channel.pojo.MesChannel;
import com.tsbx.business.channel.service.ChannelService;
import com.tsbx.entities.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope   //通过SpringCould原生注解@RefreshScope实现配置自动更新
@Slf4j
public class ConfigClientController{

    @Autowired
    ChannelService channelService;

    @Value("${config.info}") //对应nacos配置:nacos-config-client-dev.yaml
    private String configInfo;

    @Value("${share.info}") //对应nacos配置:nacos-config-client-dev.yaml
    private String shareInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo + "、" + shareInfo;
    }

    @GetMapping("/getChannel")
    public ApiResponse<List<MesChannel>> getChannel(){
        ApiResponse<List<MesChannel>> apiResponse = new ApiResponse<>();

        List<MesChannel> mesChannels = channelService.getChannel();
        log.info("mesChannels:"+ JSON.toJSONString(mesChannels));
        if(mesChannels != null && !mesChannels.isEmpty()){
            apiResponse.setData(mesChannels);
        }else {
            apiResponse.setStatus(-1);
            apiResponse.setStatusText("error");
            apiResponse.setData(null);
        }

        return apiResponse;
    }
}