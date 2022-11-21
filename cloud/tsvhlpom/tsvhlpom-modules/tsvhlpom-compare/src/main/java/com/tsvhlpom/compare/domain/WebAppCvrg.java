package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 web_app_cvrg
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppCvrg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String cPkId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    //@AnjiDescription("cAppNo")
    private String cAppNo;

    /** 投保时为投保单的PKID，批改申请时如非新增记录则为原投保单的PKID，
如为新增记录则为批改申请单的PKID */
    @Excel(name = "投保时为投保单的PKID，批改申请时如非新增记录则为原投保单的PKID， 如为新增记录则为批改申请单的PKID")
    @AnjiDescription("cRowId")
    private String cRowId;

    /** 序号 Sequence No */
    @Excel(name = "序号 Sequence No")
    @AnjiDescription("nSeqNo")
    private Long nSeqNo;

    /** 险别（扩展条款）编号 Coverage Code */
    @Excel(name = "险别", readConverterExp = "扩=展条款")
    @AnjiDescription("cCvrgNo")
    private String cCvrgNo;

    /** 自定义险别名称 Customized Coverage Name */
    @Excel(name = "自定义险别名称 Customized Coverage Name")
    @AnjiDescription("cCustCvrgNme")
    private String cCustCvrgNme;

    /** 保额 Amount Insured */
    @Excel(name = "保额 Amount Insured")
    @AnjiDescription("nAmt")
    private Long nAmt;

    /** 费率 Premium Rate */
    @Excel(name = "费率 Premium Rate")
    @AnjiDescription("nRate")
    private Long nRate;

    /** 基本保费 Base Premium */
    @Excel(name = "基本保费 Base Premium")
    @AnjiDescription("nBasePrm")
    private Long nBasePrm;

    /** 折前保费 Premium without Discount */
    @Excel(name = "折前保费 Premium without Discount")
    @AnjiDescription("nBefPrm")
    private Long nBefPrm;

    /** 优惠系数 Discount Coefficient */
    @Excel(name = "优惠系数 Discount Coefficient")
    @AnjiDescription("nDisCoef")
    private Long nDisCoef;

    /** 计算保费 Calculated Premium */
    @Excel(name = "计算保费 Calculated Premium")
    @AnjiDescription("nCalcPrm")
    private Long nCalcPrm;

    /** 保费 Premium */
    @Excel(name = "保费 Premium")
    @AnjiDescription("nPrm")
    private Long nPrm;

    /** 年折前保费 Annual Premium without Discount */
    @Excel(name = "年折前保费 Annual Premium without Discount")
    @AnjiDescription("nBefAnnPrm")
    private Long nBefAnnPrm;

    /** 年计算保费 Calculated Annual Premium */
    @Excel(name = "年计算保费 Calculated Annual Premium")
    @AnjiDescription("nCalcAnnPrm")
    private Long nCalcAnnPrm;

    /** 保费变化时间，缺省为保单起保日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保费变化时间，缺省为保单起保日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tPrmChgTm")
    private Date tPrmChgTm;

    /** 已了责任保费，缺省为0 */
    @Excel(name = "已了责任保费，缺省为0")
    @AnjiDescription("nDutPrm")
    private Long nDutPrm;

    /** 备注 Remark */
    @Excel(name = "备注 Remark")
    @AnjiDescription("cRemark")
    private String cRemark;

    /** 标的类型代码 Subject-matter Type */
    @Excel(name = "标的类型代码 Subject-matter Type")
    @AnjiDescription("cTgtTyp")
    private String cTgtTyp;

    /** 标的名称 Subject-matter Name */
    @Excel(name = "标的名称 Subject-matter Name")
    @AnjiDescription("cTgtNme")
    private String cTgtNme;

    /** 标的数量 Quantity of Subject-matters */
    @Excel(name = "标的数量 Quantity of Subject-matters")
    @AnjiDescription("nTgtQty")
    private Long nTgtQty;

    /** 赔偿限额 Indemnity Limit */
    @Excel(name = "赔偿限额 Indemnity Limit")
    @AnjiDescription("nIndemLmt")
    private Long nIndemLmt;

    /** '0' 否,'1' 是 */
    @Excel(name = "'0' 否,'1' 是")
    @AnjiDescription("cDductMrk")
    private String cDductMrk;

    /** 免赔率 Deductable Rate */
    @Excel(name = "免赔率 Deductable Rate")
    @AnjiDescription("nDductRate")
    private Long nDductRate;

    /** 免赔说明 Deductable Description */
    @Excel(name = "免赔说明 Deductable Description")
    @AnjiDescription("cDductDesc")
    private String cDductDesc;

    /** 绝对免赔额 Straight Deductible Amount */
    @Excel(name = "绝对免赔额 Straight Deductible Amount")
    @AnjiDescription("nDductAmt")
    private Long nDductAmt;

    /** 退保标志 Cancel Flag，缺省为'1'，当批改退保时为‘0’ */
    @Excel(name = "退保标志 Cancel Flag，缺省为'1'，当批改退保时为‘0’")
    @AnjiDescription("cCancelMrk")
    private String cCancelMrk;

    /** 赔偿限额档次(车险) Level of Indemnity Limit */
    @Excel(name = "赔偿限额档次(车险) Level of Indemnity Limit")
    @AnjiDescription("cIndemLmtLvl")
    private String cIndemLmtLvl;

    /** 责任时限(车险) Days Limit of Liability */
    @Excel(name = "责任时限(车险) Days Limit of Liability")
    @AnjiDescription("nLiabDaysLmt")
    private Long nLiabDaysLmt;

    /** 每标的保额  Amount for Each Subject-matter */
    @Excel(name = "每标的保额  Amount for Each Subject-matter")
    @AnjiDescription("nPerAmt")
    private Long nPerAmt;

    /** 每标的赔偿限额 Indemnity Limit for Each Subject-matter */
    @Excel(name = "每标的赔偿限额 Indemnity Limit for Each Subject-matter")
    @AnjiDescription("nPerIndemLmt")
    private Long nPerIndemLmt;

    /** 每标的保费 Premium for Each Subject-matter */
    @Excel(name = "每标的保费 Premium for Each Subject-matter")
    @AnjiDescription("nPerPrm")
    private Long nPerPrm;

    /** 单次赔偿限额 Indemnity Limit for Any One Claim */
    @Excel(name = "单次赔偿限额 Indemnity Limit for Any One Claim")
    @AnjiDescription("nOnceIndemLmt")
    private Long nOnceIndemLmt;

    /** 储金 Amount of Saving Fund */
    @Excel(name = "储金 Amount of Saving Fund")
    @AnjiDescription("nSavingAmt")
    private Long nSavingAmt;

    /** 险别的有效起期，保单为保单的保险起期，批单为批单的生效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "险别的有效起期，保单为保单的保险起期，批单为批单的生效起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tBgnTm")
    private Date tBgnTm;

    /** 险别的有效起期，保单为保单的保险止期，批单为批单的生效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "险别的有效起期，保单为保单的保险止期，批单为批单的生效止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEndTm")
    private Date tEndTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nAmtVar")
    private Long nAmtVar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nPrmVar")
    private Long nPrmVar;

    /** 计算保费 Calculated Premium */
    @Excel(name = "计算保费 Calculated Premium")
    @AnjiDescription("nCalcPrmVar")
    private Long nCalcPrmVar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nIndemVar")
    private Long nIndemVar;

    /** 创建人员 */
    @Excel(name = "创建人员")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 修改人员 */
    @Excel(name = "修改人员")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** 预留 [产地、保险项目、雇员职别、保险金额确定方式、户名] */
    @Excel(name = "预留 [产地、保险项目、雇员职别、保险金额确定方式、户名]")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** 预留 [延伸区域、保险费交费方式、开户银行] */
    @Excel(name = "预留 [延伸区域、保险费交费方式、开户银行]")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** 预留 [保险计划、赔偿期、授权账户账号或银行账号] */
    @Excel(name = "预留 [保险计划、赔偿期、授权账户账号或银行账号]")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** 预留 [免赔额档次] */
    @Excel(name = "预留 [免赔额档次]")
    @AnjiDescription("cResvTxt4")
    private String cResvTxt4;

    /** 预留 [承保险别及条件] */
    @Excel(name = "预留 [承保险别及条件]")
    @AnjiDescription("cResvTxt5")
    private String cResvTxt5;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt6")
    private String cResvTxt6;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt7")
    private String cResvTxt7;

    /** 预留 [职业类别、职业等级] */
    @Excel(name = "预留 [职业类别、职业等级]")
    @AnjiDescription("cResvTxt8")
    private String cResvTxt8;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt9")
    private String cResvTxt9;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt10")
    private String cResvTxt10;

    /** 次数 */
    @Excel(name = "次数")
    @AnjiDescription("cResvTxt11")
    private String cResvTxt11;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt12")
    private String cResvTxt12;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt13")
    private String cResvTxt13;

    /** 次数 */
    @Excel(name = "次数")
    @AnjiDescription("cResvTxt14")
    private String cResvTxt14;

    /** 预留(险别附加条款隐藏,承保时未修改的附加条款，用于判断该字段是否可编辑) */
    @Excel(name = "预留(险别附加条款隐藏,承保时未修改的附加条款，用于判断该字段是否可编辑)")
    @AnjiDescription("cResvTxt15")
    private String cResvTxt15;

    /** [预留]建筑类别 */
    @Excel(name = "[预留]建筑类别")
    @AnjiDescription("cResvTxt16")
    private String cResvTxt16;

    /** [预留]标的项目类别 */
    @Excel(name = "[预留]标的项目类别")
    @AnjiDescription("cResvTxt17")
    private String cResvTxt17;

    /** 财产险险别标的序号，其它勿用 */
    @Excel(name = "财产险险别标的序号，其它勿用")
    @AnjiDescription("cResvTxt18")
    private String cResvTxt18;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt19")
    private String cResvTxt19;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt20")
    private String cResvTxt20;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt21")
    private String cResvTxt21;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt22")
    private String cResvTxt22;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt23")
    private String cResvTxt23;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt24")
    private String cResvTxt24;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt25")
    private String cResvTxt25;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt26")
    private String cResvTxt26;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt27")
    private String cResvTxt27;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt28")
    private String cResvTxt28;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt29")
    private String cResvTxt29;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt30")
    private String cResvTxt30;

    /** 预留 [每次事故绝对免赔额、雇员人数、共保比例(%)、每份保障金] */
    @Excel(name = "预留 [每次事故绝对免赔额、雇员人数、共保比例(%)、每份保障金]")
    @AnjiDescription("nResvNum1")
    private Long nResvNum1;

    /** 预留 [每次事故人身伤亡、每人死亡伤残赔偿限额、农险保险金额] */
    @Excel(name = "预留 [每次事故人身伤亡、每人死亡伤残赔偿限额、农险保险金额]")
    @AnjiDescription("nResvNum2")
    private Long nResvNum2;

    /** 预留 [人数] */
    @Excel(name = "预留 [人数]")
    @AnjiDescription("nResvNum3")
    private Long nResvNum3;

    /** 预留 [每次事故财产损失、 [每万元保险金额趸交保费]] */
    @Excel(name = "预留 [每次事故财产损失、 [每万元保险金额趸交保费]]")
    @AnjiDescription("nResvNum4")
    private Long nResvNum4;

    /** 预留 [每次事故每人赔偿限额、折扣率] */
    @Excel(name = "预留 [每次事故每人赔偿限额、折扣率]")
    @AnjiDescription("nResvNum5")
    private Long nResvNum5;

    /** 自主定价系数 */
    @Excel(name = "自主定价系数")
    @AnjiDescription("nResvNum6")
    private Long nResvNum6;

    /** 预留 [地区费率调整系数] */
    @Excel(name = "预留 [地区费率调整系数]")
    @AnjiDescription("nResvNum7")
    private Long nResvNum7;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum8")
    private Long nResvNum8;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum9")
    private Long nResvNum9;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum10")
    private Long nResvNum10;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum11")
    private Long nResvNum11;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum12")
    private Long nResvNum12;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum13")
    private Long nResvNum13;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum14")
    private Long nResvNum14;

    /** 获得融资金额 */
    @Excel(name = "获得融资金额")
    @AnjiDescription("nResvNum15")
    private Long nResvNum15;

    /** 获得融资金额人民币金额 */
    @Excel(name = "获得融资金额人民币金额")
    @AnjiDescription("nResvNum16")
    private Long nResvNum16;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum17")
    private Long nResvNum17;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum18")
    private Long nResvNum18;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum19")
    private Long nResvNum19;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum20")
    private Long nResvNum20;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum21")
    private Long nResvNum21;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum22")
    private Long nResvNum22;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum23")
    private Long nResvNum23;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum24")
    private Long nResvNum24;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum25")
    private Long nResvNum25;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum26")
    private Long nResvNum26;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum27")
    private Long nResvNum27;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum28")
    private Long nResvNum28;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum29")
    private Long nResvNum29;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum30")
    private Long nResvNum30;

    /** 预留 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预留", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm1")
    private Date tResvTm1;

    /** 预留 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预留", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm2")
    private Date tResvTm2;

    /** 预留 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预留", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm3")
    private Date tResvTm3;

    /** 预留 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预留", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm4")
    private Date tResvTm4;

    /** 预留 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预留", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm5")
    private Date tResvTm5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 高风险车型系数 */
    @Excel(name = "高风险车型系数")
    @AnjiDescription("nVhlMod")
    private Long nVhlMod;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCustClCtnt")
    private String cCustClCtnt;

    /** 纯风险保费 */
    @Excel(name = "纯风险保费")
    @AnjiDescription("nPureriskPremium")
    private Long nPureriskPremium;

    /** 自主核保系数 */
    @Excel(name = "自主核保系数")
    @AnjiDescription("nAutonomyCoef")
    private Long nAutonomyCoef;

    /** 新增设备保额 */
    @Excel(name = "新增设备保额")
    @AnjiDescription("nTgtAmt")
    private Long nTgtAmt;

    /** 新增设备纯风险基准保费 */
    @Excel(name = "新增设备纯风险基准保费")
    @AnjiDescription("nTgtBasePrm")
    private Long nTgtBasePrm;

    /** 新增设备保费 */
    @Excel(name = "新增设备保费")
    @AnjiDescription("nTgtPrm")
    private Long nTgtPrm;

    /** 新增设备保费变化 */
    @Excel(name = "新增设备保费变化")
    @AnjiDescription("nTgtPrmVar")
    private Long nTgtPrmVar;

    /** 新增设备折前保费 */
    @Excel(name = "新增设备折前保费")
    @AnjiDescription("nTgtBefPrm")
    private Long nTgtBefPrm;

    /** 新增设备计算保费 */
    @Excel(name = "新增设备计算保费")
    @AnjiDescription("nTgtCalcPrm")
    private Long nTgtCalcPrm;

    /** 是否共享保额 */
    @Excel(name = "是否共享保额")
    @AnjiDescription("cIsShare")
    private String cIsShare;

    /** 共享保额责任 */
    @Excel(name = "共享保额责任")
    @AnjiDescription("cShareRisk")
    private String cShareRisk;

    /** 条款类型 */
    @Excel(name = "条款类型")
    @AnjiDescription("cClauseType")
    private String cClauseType;

    /** 附加条款费率说明 */
    @Excel(name = "附加条款费率说明")
    @AnjiDescription("cRateExplan")
    private String cRateExplan;

    public void setcPkId(String cPkId)
    {
        this.cPkId = cPkId;
    }

    public String getcPkId()
    {
        return cPkId;
    }
    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcRowId(String cRowId)
    {
        this.cRowId = cRowId;
    }

    public String getcRowId()
    {
        return cRowId;
    }
    public void setnSeqNo(Long nSeqNo)
    {
        this.nSeqNo = nSeqNo;
    }

    public Long getnSeqNo()
    {
        return nSeqNo;
    }
    public void setcCvrgNo(String cCvrgNo)
    {
        this.cCvrgNo = cCvrgNo;
    }

    public String getcCvrgNo()
    {
        return cCvrgNo;
    }
    public void setcCustCvrgNme(String cCustCvrgNme)
    {
        this.cCustCvrgNme = cCustCvrgNme;
    }

    public String getcCustCvrgNme()
    {
        return cCustCvrgNme;
    }
    public void setnAmt(Long nAmt)
    {
        this.nAmt = nAmt;
    }

    public Long getnAmt()
    {
        return nAmt;
    }
    public void setnRate(Long nRate)
    {
        this.nRate = nRate;
    }

    public Long getnRate()
    {
        return nRate;
    }
    public void setnBasePrm(Long nBasePrm)
    {
        this.nBasePrm = nBasePrm;
    }

    public Long getnBasePrm()
    {
        return nBasePrm;
    }
    public void setnBefPrm(Long nBefPrm)
    {
        this.nBefPrm = nBefPrm;
    }

    public Long getnBefPrm()
    {
        return nBefPrm;
    }
    public void setnDisCoef(Long nDisCoef)
    {
        this.nDisCoef = nDisCoef;
    }

    public Long getnDisCoef()
    {
        return nDisCoef;
    }
    public void setnCalcPrm(Long nCalcPrm)
    {
        this.nCalcPrm = nCalcPrm;
    }

    public Long getnCalcPrm()
    {
        return nCalcPrm;
    }
    public void setnPrm(Long nPrm)
    {
        this.nPrm = nPrm;
    }

    public Long getnPrm()
    {
        return nPrm;
    }
    public void setnBefAnnPrm(Long nBefAnnPrm)
    {
        this.nBefAnnPrm = nBefAnnPrm;
    }

    public Long getnBefAnnPrm()
    {
        return nBefAnnPrm;
    }
    public void setnCalcAnnPrm(Long nCalcAnnPrm)
    {
        this.nCalcAnnPrm = nCalcAnnPrm;
    }

    public Long getnCalcAnnPrm()
    {
        return nCalcAnnPrm;
    }
    public void settPrmChgTm(Date tPrmChgTm)
    {
        this.tPrmChgTm = tPrmChgTm;
    }

    public Date gettPrmChgTm()
    {
        return tPrmChgTm;
    }
    public void setnDutPrm(Long nDutPrm)
    {
        this.nDutPrm = nDutPrm;
    }

    public Long getnDutPrm()
    {
        return nDutPrm;
    }
    public void setcRemark(String cRemark)
    {
        this.cRemark = cRemark;
    }

    public String getcRemark()
    {
        return cRemark;
    }
    public void setcTgtTyp(String cTgtTyp)
    {
        this.cTgtTyp = cTgtTyp;
    }

    public String getcTgtTyp()
    {
        return cTgtTyp;
    }
    public void setcTgtNme(String cTgtNme)
    {
        this.cTgtNme = cTgtNme;
    }

    public String getcTgtNme()
    {
        return cTgtNme;
    }
    public void setnTgtQty(Long nTgtQty)
    {
        this.nTgtQty = nTgtQty;
    }

    public Long getnTgtQty()
    {
        return nTgtQty;
    }
    public void setnIndemLmt(Long nIndemLmt)
    {
        this.nIndemLmt = nIndemLmt;
    }

    public Long getnIndemLmt()
    {
        return nIndemLmt;
    }
    public void setcDductMrk(String cDductMrk)
    {
        this.cDductMrk = cDductMrk;
    }

    public String getcDductMrk()
    {
        return cDductMrk;
    }
    public void setnDductRate(Long nDductRate)
    {
        this.nDductRate = nDductRate;
    }

    public Long getnDductRate()
    {
        return nDductRate;
    }
    public void setcDductDesc(String cDductDesc)
    {
        this.cDductDesc = cDductDesc;
    }

    public String getcDductDesc()
    {
        return cDductDesc;
    }
    public void setnDductAmt(Long nDductAmt)
    {
        this.nDductAmt = nDductAmt;
    }

    public Long getnDductAmt()
    {
        return nDductAmt;
    }
    public void setcCancelMrk(String cCancelMrk)
    {
        this.cCancelMrk = cCancelMrk;
    }

    public String getcCancelMrk()
    {
        return cCancelMrk;
    }
    public void setcIndemLmtLvl(String cIndemLmtLvl)
    {
        this.cIndemLmtLvl = cIndemLmtLvl;
    }

    public String getcIndemLmtLvl()
    {
        return cIndemLmtLvl;
    }
    public void setnLiabDaysLmt(Long nLiabDaysLmt)
    {
        this.nLiabDaysLmt = nLiabDaysLmt;
    }

    public Long getnLiabDaysLmt()
    {
        return nLiabDaysLmt;
    }
    public void setnPerAmt(Long nPerAmt)
    {
        this.nPerAmt = nPerAmt;
    }

    public Long getnPerAmt()
    {
        return nPerAmt;
    }
    public void setnPerIndemLmt(Long nPerIndemLmt)
    {
        this.nPerIndemLmt = nPerIndemLmt;
    }

    public Long getnPerIndemLmt()
    {
        return nPerIndemLmt;
    }
    public void setnPerPrm(Long nPerPrm)
    {
        this.nPerPrm = nPerPrm;
    }

    public Long getnPerPrm()
    {
        return nPerPrm;
    }
    public void setnOnceIndemLmt(Long nOnceIndemLmt)
    {
        this.nOnceIndemLmt = nOnceIndemLmt;
    }

    public Long getnOnceIndemLmt()
    {
        return nOnceIndemLmt;
    }
    public void setnSavingAmt(Long nSavingAmt)
    {
        this.nSavingAmt = nSavingAmt;
    }

    public Long getnSavingAmt()
    {
        return nSavingAmt;
    }
    public void settBgnTm(Date tBgnTm)
    {
        this.tBgnTm = tBgnTm;
    }

    public Date gettBgnTm()
    {
        return tBgnTm;
    }
    public void settEndTm(Date tEndTm)
    {
        this.tEndTm = tEndTm;
    }

    public Date gettEndTm()
    {
        return tEndTm;
    }
    public void setnAmtVar(Long nAmtVar)
    {
        this.nAmtVar = nAmtVar;
    }

    public Long getnAmtVar()
    {
        return nAmtVar;
    }
    public void setnPrmVar(Long nPrmVar)
    {
        this.nPrmVar = nPrmVar;
    }

    public Long getnPrmVar()
    {
        return nPrmVar;
    }
    public void setnCalcPrmVar(Long nCalcPrmVar)
    {
        this.nCalcPrmVar = nCalcPrmVar;
    }

    public Long getnCalcPrmVar()
    {
        return nCalcPrmVar;
    }
    public void setnIndemVar(Long nIndemVar)
    {
        this.nIndemVar = nIndemVar;
    }

    public Long getnIndemVar()
    {
        return nIndemVar;
    }
    public void setcCrtCde(String cCrtCde)
    {
        this.cCrtCde = cCrtCde;
    }

    public String getcCrtCde()
    {
        return cCrtCde;
    }
    public void settCrtTm(Date tCrtTm)
    {
        this.tCrtTm = tCrtTm;
    }

    public Date gettCrtTm()
    {
        return tCrtTm;
    }
    public void setcUpdCde(String cUpdCde)
    {
        this.cUpdCde = cUpdCde;
    }

    public String getcUpdCde()
    {
        return cUpdCde;
    }
    public void settUpdTm(Date tUpdTm)
    {
        this.tUpdTm = tUpdTm;
    }

    public Date gettUpdTm()
    {
        return tUpdTm;
    }
    public void setcResvTxt1(String cResvTxt1)
    {
        this.cResvTxt1 = cResvTxt1;
    }

    public String getcResvTxt1()
    {
        return cResvTxt1;
    }
    public void setcResvTxt2(String cResvTxt2)
    {
        this.cResvTxt2 = cResvTxt2;
    }

    public String getcResvTxt2()
    {
        return cResvTxt2;
    }
    public void setcResvTxt3(String cResvTxt3)
    {
        this.cResvTxt3 = cResvTxt3;
    }

    public String getcResvTxt3()
    {
        return cResvTxt3;
    }
    public void setcResvTxt4(String cResvTxt4)
    {
        this.cResvTxt4 = cResvTxt4;
    }

    public String getcResvTxt4()
    {
        return cResvTxt4;
    }
    public void setcResvTxt5(String cResvTxt5)
    {
        this.cResvTxt5 = cResvTxt5;
    }

    public String getcResvTxt5()
    {
        return cResvTxt5;
    }
    public void setcResvTxt6(String cResvTxt6)
    {
        this.cResvTxt6 = cResvTxt6;
    }

    public String getcResvTxt6()
    {
        return cResvTxt6;
    }
    public void setcResvTxt7(String cResvTxt7)
    {
        this.cResvTxt7 = cResvTxt7;
    }

    public String getcResvTxt7()
    {
        return cResvTxt7;
    }
    public void setcResvTxt8(String cResvTxt8)
    {
        this.cResvTxt8 = cResvTxt8;
    }

    public String getcResvTxt8()
    {
        return cResvTxt8;
    }
    public void setcResvTxt9(String cResvTxt9)
    {
        this.cResvTxt9 = cResvTxt9;
    }

    public String getcResvTxt9()
    {
        return cResvTxt9;
    }
    public void setcResvTxt10(String cResvTxt10)
    {
        this.cResvTxt10 = cResvTxt10;
    }

    public String getcResvTxt10()
    {
        return cResvTxt10;
    }
    public void setcResvTxt11(String cResvTxt11)
    {
        this.cResvTxt11 = cResvTxt11;
    }

    public String getcResvTxt11()
    {
        return cResvTxt11;
    }
    public void setcResvTxt12(String cResvTxt12)
    {
        this.cResvTxt12 = cResvTxt12;
    }

    public String getcResvTxt12()
    {
        return cResvTxt12;
    }
    public void setcResvTxt13(String cResvTxt13)
    {
        this.cResvTxt13 = cResvTxt13;
    }

    public String getcResvTxt13()
    {
        return cResvTxt13;
    }
    public void setcResvTxt14(String cResvTxt14)
    {
        this.cResvTxt14 = cResvTxt14;
    }

    public String getcResvTxt14()
    {
        return cResvTxt14;
    }
    public void setcResvTxt15(String cResvTxt15)
    {
        this.cResvTxt15 = cResvTxt15;
    }

    public String getcResvTxt15()
    {
        return cResvTxt15;
    }
    public void setcResvTxt16(String cResvTxt16)
    {
        this.cResvTxt16 = cResvTxt16;
    }

    public String getcResvTxt16()
    {
        return cResvTxt16;
    }
    public void setcResvTxt17(String cResvTxt17)
    {
        this.cResvTxt17 = cResvTxt17;
    }

    public String getcResvTxt17()
    {
        return cResvTxt17;
    }
    public void setcResvTxt18(String cResvTxt18)
    {
        this.cResvTxt18 = cResvTxt18;
    }

    public String getcResvTxt18()
    {
        return cResvTxt18;
    }
    public void setcResvTxt19(String cResvTxt19)
    {
        this.cResvTxt19 = cResvTxt19;
    }

    public String getcResvTxt19()
    {
        return cResvTxt19;
    }
    public void setcResvTxt20(String cResvTxt20)
    {
        this.cResvTxt20 = cResvTxt20;
    }

    public String getcResvTxt20()
    {
        return cResvTxt20;
    }
    public void setcResvTxt21(String cResvTxt21)
    {
        this.cResvTxt21 = cResvTxt21;
    }

    public String getcResvTxt21()
    {
        return cResvTxt21;
    }
    public void setcResvTxt22(String cResvTxt22)
    {
        this.cResvTxt22 = cResvTxt22;
    }

    public String getcResvTxt22()
    {
        return cResvTxt22;
    }
    public void setcResvTxt23(String cResvTxt23)
    {
        this.cResvTxt23 = cResvTxt23;
    }

    public String getcResvTxt23()
    {
        return cResvTxt23;
    }
    public void setcResvTxt24(String cResvTxt24)
    {
        this.cResvTxt24 = cResvTxt24;
    }

    public String getcResvTxt24()
    {
        return cResvTxt24;
    }
    public void setcResvTxt25(String cResvTxt25)
    {
        this.cResvTxt25 = cResvTxt25;
    }

    public String getcResvTxt25()
    {
        return cResvTxt25;
    }
    public void setcResvTxt26(String cResvTxt26)
    {
        this.cResvTxt26 = cResvTxt26;
    }

    public String getcResvTxt26()
    {
        return cResvTxt26;
    }
    public void setcResvTxt27(String cResvTxt27)
    {
        this.cResvTxt27 = cResvTxt27;
    }

    public String getcResvTxt27()
    {
        return cResvTxt27;
    }
    public void setcResvTxt28(String cResvTxt28)
    {
        this.cResvTxt28 = cResvTxt28;
    }

    public String getcResvTxt28()
    {
        return cResvTxt28;
    }
    public void setcResvTxt29(String cResvTxt29)
    {
        this.cResvTxt29 = cResvTxt29;
    }

    public String getcResvTxt29()
    {
        return cResvTxt29;
    }
    public void setcResvTxt30(String cResvTxt30)
    {
        this.cResvTxt30 = cResvTxt30;
    }

    public String getcResvTxt30()
    {
        return cResvTxt30;
    }
    public void setnResvNum1(Long nResvNum1)
    {
        this.nResvNum1 = nResvNum1;
    }

    public Long getnResvNum1()
    {
        return nResvNum1;
    }
    public void setnResvNum2(Long nResvNum2)
    {
        this.nResvNum2 = nResvNum2;
    }

    public Long getnResvNum2()
    {
        return nResvNum2;
    }
    public void setnResvNum3(Long nResvNum3)
    {
        this.nResvNum3 = nResvNum3;
    }

    public Long getnResvNum3()
    {
        return nResvNum3;
    }
    public void setnResvNum4(Long nResvNum4)
    {
        this.nResvNum4 = nResvNum4;
    }

    public Long getnResvNum4()
    {
        return nResvNum4;
    }
    public void setnResvNum5(Long nResvNum5)
    {
        this.nResvNum5 = nResvNum5;
    }

    public Long getnResvNum5()
    {
        return nResvNum5;
    }
    public void setnResvNum6(Long nResvNum6)
    {
        this.nResvNum6 = nResvNum6;
    }

    public Long getnResvNum6()
    {
        return nResvNum6;
    }
    public void setnResvNum7(Long nResvNum7)
    {
        this.nResvNum7 = nResvNum7;
    }

    public Long getnResvNum7()
    {
        return nResvNum7;
    }
    public void setnResvNum8(Long nResvNum8)
    {
        this.nResvNum8 = nResvNum8;
    }

    public Long getnResvNum8()
    {
        return nResvNum8;
    }
    public void setnResvNum9(Long nResvNum9)
    {
        this.nResvNum9 = nResvNum9;
    }

    public Long getnResvNum9()
    {
        return nResvNum9;
    }
    public void setnResvNum10(Long nResvNum10)
    {
        this.nResvNum10 = nResvNum10;
    }

    public Long getnResvNum10()
    {
        return nResvNum10;
    }
    public void setnResvNum11(Long nResvNum11)
    {
        this.nResvNum11 = nResvNum11;
    }

    public Long getnResvNum11()
    {
        return nResvNum11;
    }
    public void setnResvNum12(Long nResvNum12)
    {
        this.nResvNum12 = nResvNum12;
    }

    public Long getnResvNum12()
    {
        return nResvNum12;
    }
    public void setnResvNum13(Long nResvNum13)
    {
        this.nResvNum13 = nResvNum13;
    }

    public Long getnResvNum13()
    {
        return nResvNum13;
    }
    public void setnResvNum14(Long nResvNum14)
    {
        this.nResvNum14 = nResvNum14;
    }

    public Long getnResvNum14()
    {
        return nResvNum14;
    }
    public void setnResvNum15(Long nResvNum15)
    {
        this.nResvNum15 = nResvNum15;
    }

    public Long getnResvNum15()
    {
        return nResvNum15;
    }
    public void setnResvNum16(Long nResvNum16)
    {
        this.nResvNum16 = nResvNum16;
    }

    public Long getnResvNum16()
    {
        return nResvNum16;
    }
    public void setnResvNum17(Long nResvNum17)
    {
        this.nResvNum17 = nResvNum17;
    }

    public Long getnResvNum17()
    {
        return nResvNum17;
    }
    public void setnResvNum18(Long nResvNum18)
    {
        this.nResvNum18 = nResvNum18;
    }

    public Long getnResvNum18()
    {
        return nResvNum18;
    }
    public void setnResvNum19(Long nResvNum19)
    {
        this.nResvNum19 = nResvNum19;
    }

    public Long getnResvNum19()
    {
        return nResvNum19;
    }
    public void setnResvNum20(Long nResvNum20)
    {
        this.nResvNum20 = nResvNum20;
    }

    public Long getnResvNum20()
    {
        return nResvNum20;
    }
    public void setnResvNum21(Long nResvNum21)
    {
        this.nResvNum21 = nResvNum21;
    }

    public Long getnResvNum21()
    {
        return nResvNum21;
    }
    public void setnResvNum22(Long nResvNum22)
    {
        this.nResvNum22 = nResvNum22;
    }

    public Long getnResvNum22()
    {
        return nResvNum22;
    }
    public void setnResvNum23(Long nResvNum23)
    {
        this.nResvNum23 = nResvNum23;
    }

    public Long getnResvNum23()
    {
        return nResvNum23;
    }
    public void setnResvNum24(Long nResvNum24)
    {
        this.nResvNum24 = nResvNum24;
    }

    public Long getnResvNum24()
    {
        return nResvNum24;
    }
    public void setnResvNum25(Long nResvNum25)
    {
        this.nResvNum25 = nResvNum25;
    }

    public Long getnResvNum25()
    {
        return nResvNum25;
    }
    public void setnResvNum26(Long nResvNum26)
    {
        this.nResvNum26 = nResvNum26;
    }

    public Long getnResvNum26()
    {
        return nResvNum26;
    }
    public void setnResvNum27(Long nResvNum27)
    {
        this.nResvNum27 = nResvNum27;
    }

    public Long getnResvNum27()
    {
        return nResvNum27;
    }
    public void setnResvNum28(Long nResvNum28)
    {
        this.nResvNum28 = nResvNum28;
    }

    public Long getnResvNum28()
    {
        return nResvNum28;
    }
    public void setnResvNum29(Long nResvNum29)
    {
        this.nResvNum29 = nResvNum29;
    }

    public Long getnResvNum29()
    {
        return nResvNum29;
    }
    public void setnResvNum30(Long nResvNum30)
    {
        this.nResvNum30 = nResvNum30;
    }

    public Long getnResvNum30()
    {
        return nResvNum30;
    }
    public void settResvTm1(Date tResvTm1)
    {
        this.tResvTm1 = tResvTm1;
    }

    public Date gettResvTm1()
    {
        return tResvTm1;
    }
    public void settResvTm2(Date tResvTm2)
    {
        this.tResvTm2 = tResvTm2;
    }

    public Date gettResvTm2()
    {
        return tResvTm2;
    }
    public void settResvTm3(Date tResvTm3)
    {
        this.tResvTm3 = tResvTm3;
    }

    public Date gettResvTm3()
    {
        return tResvTm3;
    }
    public void settResvTm4(Date tResvTm4)
    {
        this.tResvTm4 = tResvTm4;
    }

    public Date gettResvTm4()
    {
        return tResvTm4;
    }
    public void settResvTm5(Date tResvTm5)
    {
        this.tResvTm5 = tResvTm5;
    }

    public Date gettResvTm5()
    {
        return tResvTm5;
    }
    public void setcTransMrk(String cTransMrk)
    {
        this.cTransMrk = cTransMrk;
    }

    public String getcTransMrk()
    {
        return cTransMrk;
    }
    public void settTransTm(Date tTransTm)
    {
        this.tTransTm = tTransTm;
    }

    public Date gettTransTm()
    {
        return tTransTm;
    }
    public void setnVhlMod(Long nVhlMod)
    {
        this.nVhlMod = nVhlMod;
    }

    public Long getnVhlMod()
    {
        return nVhlMod;
    }
    public void setcCustClCtnt(String cCustClCtnt)
    {
        this.cCustClCtnt = cCustClCtnt;
    }

    public String getcCustClCtnt()
    {
        return cCustClCtnt;
    }
    public void setnPureriskPremium(Long nPureriskPremium)
    {
        this.nPureriskPremium = nPureriskPremium;
    }

    public Long getnPureriskPremium()
    {
        return nPureriskPremium;
    }
    public void setnAutonomyCoef(Long nAutonomyCoef)
    {
        this.nAutonomyCoef = nAutonomyCoef;
    }

    public Long getnAutonomyCoef()
    {
        return nAutonomyCoef;
    }
    public void setnTgtAmt(Long nTgtAmt)
    {
        this.nTgtAmt = nTgtAmt;
    }

    public Long getnTgtAmt()
    {
        return nTgtAmt;
    }
    public void setnTgtBasePrm(Long nTgtBasePrm)
    {
        this.nTgtBasePrm = nTgtBasePrm;
    }

    public Long getnTgtBasePrm()
    {
        return nTgtBasePrm;
    }
    public void setnTgtPrm(Long nTgtPrm)
    {
        this.nTgtPrm = nTgtPrm;
    }

    public Long getnTgtPrm()
    {
        return nTgtPrm;
    }
    public void setnTgtPrmVar(Long nTgtPrmVar)
    {
        this.nTgtPrmVar = nTgtPrmVar;
    }

    public Long getnTgtPrmVar()
    {
        return nTgtPrmVar;
    }
    public void setnTgtBefPrm(Long nTgtBefPrm)
    {
        this.nTgtBefPrm = nTgtBefPrm;
    }

    public Long getnTgtBefPrm()
    {
        return nTgtBefPrm;
    }
    public void setnTgtCalcPrm(Long nTgtCalcPrm)
    {
        this.nTgtCalcPrm = nTgtCalcPrm;
    }

    public Long getnTgtCalcPrm()
    {
        return nTgtCalcPrm;
    }
    public void setcIsShare(String cIsShare)
    {
        this.cIsShare = cIsShare;
    }

    public String getcIsShare()
    {
        return cIsShare;
    }
    public void setcShareRisk(String cShareRisk)
    {
        this.cShareRisk = cShareRisk;
    }

    public String getcShareRisk()
    {
        return cShareRisk;
    }
    public void setcClauseType(String cClauseType)
    {
        this.cClauseType = cClauseType;
    }

    public String getcClauseType()
    {
        return cClauseType;
    }
    public void setcRateExplan(String cRateExplan)
    {
        this.cRateExplan = cRateExplan;
    }

    public String getcRateExplan()
    {
        return cRateExplan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cPkId", getcPkId())
            .append("cAppNo", getcAppNo())
            .append("cRowId", getcRowId())
            .append("nSeqNo", getnSeqNo())
            .append("cCvrgNo", getcCvrgNo())
            .append("cCustCvrgNme", getcCustCvrgNme())
            .append("nAmt", getnAmt())
            .append("nRate", getnRate())
            .append("nBasePrm", getnBasePrm())
            .append("nBefPrm", getnBefPrm())
            .append("nDisCoef", getnDisCoef())
            .append("nCalcPrm", getnCalcPrm())
            .append("nPrm", getnPrm())
            .append("nBefAnnPrm", getnBefAnnPrm())
            .append("nCalcAnnPrm", getnCalcAnnPrm())
            .append("tPrmChgTm", gettPrmChgTm())
            .append("nDutPrm", getnDutPrm())
            .append("cRemark", getcRemark())
            .append("cTgtTyp", getcTgtTyp())
            .append("cTgtNme", getcTgtNme())
            .append("nTgtQty", getnTgtQty())
            .append("nIndemLmt", getnIndemLmt())
            .append("cDductMrk", getcDductMrk())
            .append("nDductRate", getnDductRate())
            .append("cDductDesc", getcDductDesc())
            .append("nDductAmt", getnDductAmt())
            .append("cCancelMrk", getcCancelMrk())
            .append("cIndemLmtLvl", getcIndemLmtLvl())
            .append("nLiabDaysLmt", getnLiabDaysLmt())
            .append("nPerAmt", getnPerAmt())
            .append("nPerIndemLmt", getnPerIndemLmt())
            .append("nPerPrm", getnPerPrm())
            .append("nOnceIndemLmt", getnOnceIndemLmt())
            .append("nSavingAmt", getnSavingAmt())
            .append("tBgnTm", gettBgnTm())
            .append("tEndTm", gettEndTm())
            .append("nAmtVar", getnAmtVar())
            .append("nPrmVar", getnPrmVar())
            .append("nCalcPrmVar", getnCalcPrmVar())
            .append("nIndemVar", getnIndemVar())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("cResvTxt3", getcResvTxt3())
            .append("cResvTxt4", getcResvTxt4())
            .append("cResvTxt5", getcResvTxt5())
            .append("cResvTxt6", getcResvTxt6())
            .append("cResvTxt7", getcResvTxt7())
            .append("cResvTxt8", getcResvTxt8())
            .append("cResvTxt9", getcResvTxt9())
            .append("cResvTxt10", getcResvTxt10())
            .append("cResvTxt11", getcResvTxt11())
            .append("cResvTxt12", getcResvTxt12())
            .append("cResvTxt13", getcResvTxt13())
            .append("cResvTxt14", getcResvTxt14())
            .append("cResvTxt15", getcResvTxt15())
            .append("cResvTxt16", getcResvTxt16())
            .append("cResvTxt17", getcResvTxt17())
            .append("cResvTxt18", getcResvTxt18())
            .append("cResvTxt19", getcResvTxt19())
            .append("cResvTxt20", getcResvTxt20())
            .append("cResvTxt21", getcResvTxt21())
            .append("cResvTxt22", getcResvTxt22())
            .append("cResvTxt23", getcResvTxt23())
            .append("cResvTxt24", getcResvTxt24())
            .append("cResvTxt25", getcResvTxt25())
            .append("cResvTxt26", getcResvTxt26())
            .append("cResvTxt27", getcResvTxt27())
            .append("cResvTxt28", getcResvTxt28())
            .append("cResvTxt29", getcResvTxt29())
            .append("cResvTxt30", getcResvTxt30())
            .append("nResvNum1", getnResvNum1())
            .append("nResvNum2", getnResvNum2())
            .append("nResvNum3", getnResvNum3())
            .append("nResvNum4", getnResvNum4())
            .append("nResvNum5", getnResvNum5())
            .append("nResvNum6", getnResvNum6())
            .append("nResvNum7", getnResvNum7())
            .append("nResvNum8", getnResvNum8())
            .append("nResvNum9", getnResvNum9())
            .append("nResvNum10", getnResvNum10())
            .append("nResvNum11", getnResvNum11())
            .append("nResvNum12", getnResvNum12())
            .append("nResvNum13", getnResvNum13())
            .append("nResvNum14", getnResvNum14())
            .append("nResvNum15", getnResvNum15())
            .append("nResvNum16", getnResvNum16())
            .append("nResvNum17", getnResvNum17())
            .append("nResvNum18", getnResvNum18())
            .append("nResvNum19", getnResvNum19())
            .append("nResvNum20", getnResvNum20())
            .append("nResvNum21", getnResvNum21())
            .append("nResvNum22", getnResvNum22())
            .append("nResvNum23", getnResvNum23())
            .append("nResvNum24", getnResvNum24())
            .append("nResvNum25", getnResvNum25())
            .append("nResvNum26", getnResvNum26())
            .append("nResvNum27", getnResvNum27())
            .append("nResvNum28", getnResvNum28())
            .append("nResvNum29", getnResvNum29())
            .append("nResvNum30", getnResvNum30())
            .append("tResvTm1", gettResvTm1())
            .append("tResvTm2", gettResvTm2())
            .append("tResvTm3", gettResvTm3())
            .append("tResvTm4", gettResvTm4())
            .append("tResvTm5", gettResvTm5())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("nVhlMod", getnVhlMod())
            .append("cCustClCtnt", getcCustClCtnt())
            .append("nPureriskPremium", getnPureriskPremium())
            .append("nAutonomyCoef", getnAutonomyCoef())
            .append("nTgtAmt", getnTgtAmt())
            .append("nTgtBasePrm", getnTgtBasePrm())
            .append("nTgtPrm", getnTgtPrm())
            .append("nTgtPrmVar", getnTgtPrmVar())
            .append("nTgtBefPrm", getnTgtBefPrm())
            .append("nTgtCalcPrm", getnTgtCalcPrm())
            .append("cIsShare", getcIsShare())
            .append("cShareRisk", getcShareRisk())
            .append("cClauseType", getcClauseType())
            .append("cRateExplan", getcRateExplan())
            .toString();
    }
}
