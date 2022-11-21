package com.tsvhlpom.vip.domain;


import lombok.Data;

import java.util.Date;

@Data
public class SendMsgLog {
    private String pkid;//主键
    private String phoneNo;//手机号
    private String vip_date;//节日日期
    private String vip_day;//节日
    private Date sendDate;//发送日期
    private String sendMsg;//短信内容
    private String status;//异常标志
    private String errMsg;//异常描述
}
