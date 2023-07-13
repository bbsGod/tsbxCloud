package com.tsbx.business.channel.controller;

import com.alibaba.fastjson.JSON;
import com.tsbx.business.channel.pojo.MesChannel;
import com.tsbx.business.channel.service.ChannelService;
import com.tsbx.entities.ApiResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试数据查询接口
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/7 0:53
 */
@RestController
@Slf4j
public class ChannelController {

    @Autowired
    ChannelService channelService;

    
    @GetMapping("/getChannel")
    public ApiResponse<List<MesChannel>> getChannel(){
        ApiResponse<List<MesChannel>> apiResponse = new ApiResponse<>();

        List<MesChannel> mesChannels = channelService.getChannel();
        log.info("mesChannels:"+JSON.toJSONString(mesChannels));
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
