package com.tsvhlpom.meetingpreset.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.utils.http.HttpUtils;
import com.tsvhlpom.common.redis.service.RedisService;
import com.tsvhlpom.meetingpreset.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RedisService redisService;
    @Override
    public void autoSendMessage(String sendMsg) throws Exception {
        //获取token
        String token = this.getToken();
        //推送信息
        /*JSONObject msg = new JSONObject();
        msg.put("msgtype","text");
        msg.put("agentid",1000043);
        JSONObject content = new JSONObject();
        content.put("content","党群工作部温馨提示\n每月请召开支部委员会会议\n文本测试\n");
        msg.put("text",content);
        msg.put("touser","zkr0022");
        System.out.println(sendMsg);*/
        HttpUtils.doMeetingPost("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+token,sendMsg);



    }

    /**
     * 获取token
     * @return
     */
    public String getToken(){

        //获取消息推送token，如果过期，重新获取
        if(redisService.getCacheObject("messageToken") ==null || "".equals(redisService.getCacheObject("messageToken"))){

            String token =   HttpUtils.sendGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken","corpid=ww116a78dcfe60153f&corpsecret=tgu8fA9kql7BEoJhSXKVe_PObnLnUn9BU2U_53LBF1I");
            JSONObject messageTokenJson = JSONObject.parseObject(token);
            if("0".equals(messageTokenJson.getString("errcode"))){
                redisService.setCacheObject("messageToken",messageTokenJson.getString("access_token"),messageTokenJson.getLong("expires_in"), TimeUnit.SECONDS);
            }
        };
        return redisService.getCacheObject("messageToken");
    }
}
