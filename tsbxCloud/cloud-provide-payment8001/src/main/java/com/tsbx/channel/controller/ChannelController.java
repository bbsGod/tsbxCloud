package com.tsbx.channel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsbx.channel.pojo.MesChannel;
import com.tsbx.channel.service.ChannelService;
import com.tsbx.channel.service.impl.ChannelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/7 0:53
 */
@RestController
public class ChannelController {
    @Autowired
    ChannelService channelService;
    
    @GetMapping("/getChannel")
    public String getChannel(){ 
        List<MesChannel> mesChannels = channelService.getChannel();
         
        return JSON.toJSONString(mesChannels);   
    }
}
