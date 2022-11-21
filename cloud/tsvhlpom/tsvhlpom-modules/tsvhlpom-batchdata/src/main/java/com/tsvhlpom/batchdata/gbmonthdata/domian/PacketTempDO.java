package com.tsvhlpom.batchdata.gbmonthdata.domian;

import lombok.Data;

import java.util.Date;

@Data
public class PacketTempDO {
    //保单号
    private String plyNo;
    //保单类型 交强 商业
    private  String type;
    // 出险次数
    private Integer claim;
    //出险总金额
    private Double claimAmountSum;
    //无赔优系数
    private Double claimAdjustValue;
    //无赔优浮动原因
    private String claimAdjustReason;
    //无赔优不浮动原因
    private String noClaimAdjustReason;
    //开始日期
    private Date bgnTm;
    //结束时间
    private Date endTm;
    //存续年
    private Integer origYears;
    //创建日期
    private Date crtTm;
    //导入标志
    private String lastMrk;
}
