package com.tsvhlpom.vip.domain;


import lombok.Data;

import java.util.Date;

@Data
public class SendMsg {
    //保单号
    private String plyNo;
    //手机号
    private String phoneNo;
    //到期时间
    private Date insuredEndDate;
    //是否投保车俩安全检测增值服务条款
    private String status;
}
