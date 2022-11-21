package com.tsvhlpom.prodapi.inter.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class InterResVO {

    @JsonProperty(value = "CAppTyp")
    private String CAppTyp;//业务类型
    @JsonProperty(value = "CPlyNo")
    private String CPlyNo;//
    @JsonProperty(value = "CPlateNo")
    private String CPlateNo;//车牌号
    @JsonProperty(value = "CFrmNo")
    private String CFrmNo;
    @JsonProperty(value = "CEngNo")
    private String CEngNo;
    @JsonProperty(value = "TInsrncBgnTm")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date TInsrncBgnTm;
    @JsonProperty(value = "TInsrncEndTm")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date TInsrncEndTm;
    @JsonProperty(value = "TIssueTm")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date TIssueTm;//签单日期
    @JsonProperty(value = "CProdNo")
    private String CProdNo;
    @JsonProperty(value = "CProdNme")
    private String CProdNme;
    @JsonProperty(value = "NRate")
    private BigDecimal NRate;//佣金比例%
    @JsonProperty(value = "CAgentCode")
    private String CAgentCode;//代理机构组织机构代码证号
    @JsonProperty(value = "CAgentName")
    private String CAgentName;//代理机构名称名称
    @JsonProperty(value = "CSalesmanCode")
    private String CSalesmanCode;//销售人员
    @JsonProperty(value = "CSalesmanName")
    private String CSalesmanName;//销售人员
    @JsonProperty(value = "CEdrNo")
    private String CEdrNo;
    @JsonProperty(value = "CPlySts")
    private String CPlySts;
    @JsonProperty(value = "CAppNme")
    private String CAppNme;
    @JsonProperty(value = "CInsuredNme")
    private String CInsuredNme;
    @JsonProperty(value = "NPrm")
    private BigDecimal NPrm;
    @JsonProperty(value = "NPrmNotax")
    private BigDecimal NPrmNotax;//不含税
    @JsonProperty(value = "NAmt")
    private BigDecimal NAmt;
    @JsonProperty(value = "NAggTax")
    private BigDecimal NAggTax;//车船税金额
    @JsonProperty(value = "CUsageCde")
    private String CUsageCde;
    @JsonProperty(value = "CVhlTyp")
    private String CVhlTyp;//车辆种类
    @JsonProperty(value = "CVhlcategoryCde")
    private String CVhlcategoryCde;//
    @JsonProperty(value = "CDptCde")
    private String CDptCde;

    //20220701需求菏泽中介增加
    @JsonProperty(value = "CAppCertfCde")
    private String CAppCertfCde;//投保人证件号码
    @JsonProperty(value = "CInsCertfCde")
    private String CInsCertfCde;//被保险人证件号码
    @JsonProperty(value = "NFee")
    private Double NFee;//手续费金额
    @JsonProperty(value = "NDiscRate")
    private Double NDiscRate;//折扣系数
    @JsonProperty(value = "CModelNme")
    private String CModelNme;//车辆型号 名称
    @JsonProperty(value = "CvrgList")
    private List<InterCvrgVO> cvrgList;//险别类型
    @JsonProperty(value = "CAppNo")
    private String CAppNo;//投保单号
}
