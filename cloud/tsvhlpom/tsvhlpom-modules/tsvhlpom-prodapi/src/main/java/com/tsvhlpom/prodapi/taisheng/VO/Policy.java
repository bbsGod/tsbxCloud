package com.tsvhlpom.prodapi.taisheng.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Policy {


    private String applicationNo;//投保单号
    private String policyNo;//保单号*
    private String insurerCode;//保险公司编码*
    private String insurerName;//保险公司名称*
    private String insuranceChannels;//投保渠道*
    private Boolean internet;//互联网标识*
    private String insuranceType;//监管报备类型*
    private String type;//险种类别*
    private String agentName = "";//业务员名称  置空
    private String agencyCode;//保单出单机构编码
    private String agencyName;//保单出单机构名称
    private String superviseOrgCode;//报备机构编码
    private String superviseOrgName;//报备机构名称
    private Double grossPremium;//总保费*
    private Double netPremium;//总净保费*
    private Double taxAmount;//总税额*
    private String signDate;//签单日期*
    private String insurerStartTime;//起始日期*
    private String insurerEndTime;//终止日期*
    private String status;//保单状态*
    private String riskCode;//险种编码
    private String plateNo;//车牌号*
    private String vehicleIdentificationNo;//车架号*
    private String engineNo;//发动机号*
    private String agricultureFlag;//涉农标识*
    //private Date insurerEndTime;//结束日期
    private String vehicleAndVesselTax;//车船税*
    private String insuredPeriod;//保险期间*
    private String brandNo;//车辆种类、、、车辆型号///厂牌型号*
    private Subject applicant;//*
    private Subject insured;//*
    private List<PolicyRisk> risks;
    private List<CostRatio> costRatio;//*
}
