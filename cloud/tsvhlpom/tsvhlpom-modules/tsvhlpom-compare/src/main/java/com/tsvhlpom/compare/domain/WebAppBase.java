package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 web_app_base
 *
 * @author ruoyi
 * @date 2022-06-06
 */
public class WebAppBase extends BaseEntity
{

    private static final long serialVersionUID = 1L;

    /** 申请单号 */
    private String cAppNo;

    /** 'A' 投保单,'E'批改申请单,'Q'报价单,'O'开口保单 */
    @Excel(name = "'A' 投保单,'E'批改申请单,'Q'报价单,'O'开口保单")
    @AnjiDescription("cAppTyp")
    private String cAppTyp;

    /** 保单号 Policy No */
    @Excel(name = "保单号 Policy No")
    @AnjiDescription("cPlyNo")
    private String cPlyNo;

    /** 批改次数 Times of Endorsement */
    @Excel(name = "批改次数 Times of Endorsement")
    @AnjiDescription("nEdrPrjNo")
    private Long nEdrPrjNo;

    /** 依赖关联保单号 ，如财产险与利损险，车险商业与交强险 */
    @Excel(name = "依赖关联保单号 ，如财产险与利损险，车险商业与交强险")
    @AnjiDescription("cRelPlyNo")
    private String cRelPlyNo;

    /** 产品代码 Product Code */
    @Excel(name = "产品代码 Product Code")
    @AnjiDescription("cProdNo")
    private String cProdNo;

    /** 机构代码 Department No */
    @Excel(name = "机构代码 Department No")
    @AnjiDescription("cDptCde")
    private String cDptCde;

    /** 业务员 */
    @Excel(name = "业务员")
    @AnjiDescription("cSlsCde")
    private String cSlsCde;

    /** 业务来源 Source Type of Business */
    @Excel(name = "业务来源 Source Type of Business")
    @AnjiDescription("cBsnsTyp")
    private String cBsnsTyp;

    /** 业务来源细分 Source Subtype of Business */
    @Excel(name = "业务来源细分 Source Subtype of Business")
    @AnjiDescription("cBsnsSubtyp")
    private String cBsnsSubtyp;

    /** 代理人/经纪人 Agent/Broker No */
    @Excel(name = "代理人/经纪人 Agent/Broker No")
    @AnjiDescription("cBrkrCde")
    private String cBrkrCde;

    /** 代理协议或合作协议号 Agency Agreement No */
    @Excel(name = "代理协议或合作协议号 Agency Agreement No")
    @AnjiDescription("cAgtAgrNo")
    private String cAgtAgrNo;

    /** 补充协议号 Supplemental Agreement No */
    @Excel(name = "补充协议号 Supplemental Agreement No")
    @AnjiDescription("nSubCoNo")
    private String nSubCoNo;

    /** 开口保单业务的预约保单号 */
    @Excel(name = "开口保单业务的预约保单号")
    @AnjiDescription("cOcPlyNo")
    private String cOcPlyNo;

    /** 整张单的折扣率 */
    @Excel(name = "整张单的折扣率")
    @AnjiDescription("nDiscRate")
    private Long nDiscRate;

    /** 整张保单的费率 */
    @Excel(name = "整张保单的费率")
    @AnjiDescription("nRate")
    private Long nRate;

    /** 手续费比例 Proportion of Commission to Premium */
    @Excel(name = "手续费比例 Proportion of Commission to Premium")
    @AnjiDescription("nCommRate")
    private Long nCommRate;

    /** 续保标志:'0'新保;'1'续保 Renewal Flag  */
    @Excel(name = "续保标志:'0'新保;'1'续保 Renewal Flag ")
    @AnjiDescription("cRenewMrk")
    private String cRenewMrk;

    /** 续保单上年保单号 Original Policy No of Renewal */
    @Excel(name = "续保单上年保单号 Original Policy No of Renewal")
    @AnjiDescription("cOrigPlyNo")
    private String cOrigPlyNo;

    /** 上年保险公司 Former Insurer */
    @Excel(name = "上年保险公司 Former Insurer")
    @AnjiDescription("cOrigInsurer")
    private String cOrigInsurer;

    /** 保额币种 Currency of Amount {Code} */
    @Excel(name = "保额币种 Currency of Amount {Code}")
    @AnjiDescription("cAmtCur")
    private String cAmtCur;

    /** 保额合计 Amount Insured */
    @Excel(name = "保额合计 Amount Insured")
    @AnjiDescription("nAmt")
    private Long nAmt;

    /** 保额币种汇率 */
    @Excel(name = "保额币种汇率")
    @AnjiDescription("nAmtRmbExch")
    private Long nAmtRmbExch;

    /** 保费币种 Currency of Premium */
    @Excel(name = "保费币种 Currency of Premium")
    @AnjiDescription("cPrmCur")
    private String cPrmCur;

    /** 计算保费合计,系统自动计算的保费金额 */
    @Excel(name = "计算保费合计,系统自动计算的保费金额")
    @AnjiDescription("nCalcPrm")
    private Long nCalcPrm;

    /** 保费合计 Premium */
    @Excel(name = "保费合计 Premium")
    @AnjiDescription("nPrm")
    private Long nPrm;

    /** 保费人民币汇率 */
    @Excel(name = "保费人民币汇率")
    @AnjiDescription("nPrmRmbExch")
    private Long nPrmRmbExch;

    /** 赔偿限额合计 Limits of Idemnity */
    @Excel(name = "赔偿限额合计 Limits of Idemnity")
    @AnjiDescription("nIndemLmt")
    private Long nIndemLmt;

    /** 短期费率方式 Part-term Rate Type */
    @Excel(name = "短期费率方式 Part-term Rate Type")
    @AnjiDescription("cRatioTyp")
    private String cRatioTyp;

    /** 短期系数 Part-term Coefficient */
    @Excel(name = "短期系数 Part-term Coefficient")
    @AnjiDescription("nRatioCoef")
    private Long nRatioCoef;

    /** 储金  Amount of Saving Fund */
    @Excel(name = "储金  Amount of Saving Fund")
    @AnjiDescription("nSavingAmt")
    private Long nSavingAmt;

    /** 保单状态 Policy Status，标识为正常还是注退 */
    @Excel(name = "保单状态 Policy Status，标识为正常还是注退")
    @AnjiDescription("cPlySts")
    private String cPlySts;

    /** 保单终止时间 Time of Policy Termination，初始为保险止期，注退后填上注退时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保单终止时间 Time of Policy Termination，初始为保险止期，注退后填上注退时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTermnTm")
    private Date tTermnTm;

    /** 分入业务标志('0'非分入;'1'分入) Reinsurance Inward Flag */
    @Excel(name = "分入业务标志('0'非分入;'1'分入) Reinsurance Inward Flag")
    @AnjiDescription("cInwdMrk")
    private String cInwdMrk;

    /** 共保标志('0'非共保'1'共保) Coinsurance Flag */
    @Excel(name = "共保标志('0'非共保'1'共保) Coinsurance Flag")
    @AnjiDescription("cCiMrk")
    private String cCiMrk;

    /** 共保方式代码 Coinsurance Type {Code} */
    @Excel(name = "共保方式代码 Coinsurance Type {Code}")
    @AnjiDescription("cCiTyp")
    private String cCiTyp;

    /** 共保总保额 Joint Amount of Coinsurance */
    @Excel(name = "共保总保额 Joint Amount of Coinsurance")
    @AnjiDescription("nCiJntAmt")
    private Long nCiJntAmt;

    /** 共保总保费 Joint Premium of Coinsurance */
    @Excel(name = "共保总保费 Joint Premium of Coinsurance")
    @AnjiDescription("nCiJntPrm")
    private Long nCiJntPrm;

    /** 多年期标志('0'短期;'1'多年期) Long Term Flag */
    @Excel(name = "多年期标志('0'短期;'1'多年期) Long Term Flag")
    @AnjiDescription("cLongTermMrk")
    private String cLongTermMrk;

    /** 投保日期 Applying Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "投保日期 Applying Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tAppTm")
    private Date tAppTm;

    /** 保单号生成方式,'0' 自动,'1' 手动 */
    @Excel(name = "保单号生成方式,'0' 自动,'1' 手动")
    @AnjiDescription("cOprTyp")
    private String cOprTyp;

    /** 印刷号 Print No */
    @Excel(name = "印刷号 Print No")
    @AnjiDescription("cPrnNo")
    private String cPrnNo;

    /** 保险起期 Policy Effective Date */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保险起期 Policy Effective Date", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tInsrncBgnTm")
    private Date tInsrncBgnTm;

    /** 保险止期 Policy Expire Date */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保险止期 Policy Expire Date", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tInsrncEndTm")
    private Date tInsrncEndTm;

    /** 时制(0-24时/12-12时) Time System Code (0-24hr/12-12hr) */
    @Excel(name = "时制(0-24时/12-12时) Time System Code (0-24hr/12-12hr)")
    @AnjiDescription("cTmSysCde")
    private String cTmSysCde;

    /** 非固定特别约定 Unfixed Special Provision */
    @Excel(name = "非固定特别约定 Unfixed Special Provision")
    @AnjiDescription("cUnfixSpc")
    private String cUnfixSpc;

    /** '0'否  ,'1'是 */
    @Excel(name = "'0'否  ,'1'是")
    @AnjiDescription("cMultInsrntMrk")
    private String cMultInsrntMrk;

    /** 团单标志('0'个单;'1'团单) Group Insurance Flag */
    @Excel(name = "团单标志('0'个单;'1'团单) Group Insurance Flag")
    @AnjiDescription("cGrpMrk")
    private String cGrpMrk;

    /** 清单/汇总标志('0'输入清单,'1'输入汇总  ; )，人身险需要 */
    @Excel(name = "清单/汇总标志('0'输入清单,'1'输入汇总  ; )，人身险需要")
    @AnjiDescription("cListorcolMrk")
    private String cListorcolMrk;

    /** 统括保单标志 Master Policy Flag */
    @Excel(name = "统括保单标志 Master Policy Flag")
    @AnjiDescription("cMasterMrk")
    private String cMasterMrk;

    /** 投标业务标志 */
    @Excel(name = "投标业务标志")
    @AnjiDescription("cBidMrk")
    private String cBidMrk;

    /** '0'否,'1'是 */
    @Excel(name = "'0'否,'1'是")
    @AnjiDescription("cPkgMrk")
    private String cPkgMrk;

    /** 一揽子编号 Package Business Flag */
    @Excel(name = "一揽子编号 Package Business Flag")
    @AnjiDescription("cPkgNo")
    private String cPkgNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nPrmDisc")
    private Long nPrmDisc;

    /** 记名标志:'0'不记名;'1'记名 Registered Flag */
    @Excel(name = "记名标志:'0'不记名;'1'记名 Registered Flag")
    @AnjiDescription("cRegMrk")
    private String cRegMrk;

    /** 法定申报标志(0非申报;1申报) Legal Declaration Flag */
    @Excel(name = "法定申报标志(0非申报;1申报) Legal Declaration Flag")
    @AnjiDescription("cDecMrk")
    private String cDecMrk;

    /** 司法管辖代码 Jurisdition Code */
    @Excel(name = "司法管辖代码 Jurisdition Code")
    @AnjiDescription("cJuriCde")
    private String cJuriCde;

    /** 涉农标志  Agriculture Related Flag */
    @Excel(name = "涉农标志  Agriculture Related Flag")
    @AnjiDescription("cAgriMrk")
    private String cAgriMrk;

    /** 境内外标志(0:境内;1:境外) Domestic/Foreign Flag */
    @Excel(name = "境内外标志(0:境内;1:境外) Domestic/Foreign Flag")
    @AnjiDescription("cForeignMrk")
    private String cForeignMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cImporexpMrk")
    private String cImporexpMrk;

    /** 手工出单标志(0非手工1手工) */
    @Excel(name = "手工出单标志(0非手工1手工)")
    @AnjiDescription("cManualMrk")
    private String cManualMrk;

    /** 分期付款标志 Installment Flag */
    @Excel(name = "分期付款标志 Installment Flag")
    @AnjiDescription("cInstMrk")
    private String cInstMrk;

    /** VIP标志 VIP Flag */
    @Excel(name = "VIP标志 VIP Flag")
    @AnjiDescription("cVipMrk")
    private String cVipMrk;

    /** 预约协议 Open Cover No */
    @Excel(name = "预约协议 Open Cover No")
    @AnjiDescription("cOpenCoverNo")
    private String cOpenCoverNo;

    /** 诉讼方式 Dispute settle method {Code} */
    @Excel(name = "诉讼方式 Dispute settle method {Code}")
    @AnjiDescription("cDisptSttlCde")
    private String cDisptSttlCde;

    /** 仲裁机构  Dispute settle Organ */
    @Excel(name = "仲裁机构  Dispute settle Organ")
    @AnjiDescription("cDisptSttlOrg")
    private String cDisptSttlOrg;

    /** 操作员代码 Operator's No */
    @Excel(name = "操作员代码 Operator's No")
    @AnjiDescription("cOprCde")
    private String cOprCde;

    /** 操作日期 Operate Time录单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作日期 Operate Time录单日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tOprTm")
    private Date tOprTm;

    /** 复核人代码 Checker's No */
    @Excel(name = "复核人代码 Checker's No")
    @AnjiDescription("cChkCde")
    private String cChkCde;

    /** 签单日期 Issue Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签单日期 Issue Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tIssueTm")
    private Date tIssueTm;

    /** 核保日期 Underwrite Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核保日期 Underwrite Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUdrTm")
    private Date tUdrTm;

    /** 核保机构 Underwriting Department No */
    @Excel(name = "核保机构 Underwriting Department No")
    @AnjiDescription("cUdrDptCde")
    private String cUdrDptCde;

    /** 核保人代码 Underwriter's No */
    @Excel(name = "核保人代码 Underwriter's No")
    @AnjiDescription("cUdrCde")
    private String cUdrCde;

    /** 核保标志 */
    @Excel(name = "核保标志")
    @AnjiDescription("cUdrMrk")
    private String cUdrMrk;

    /** 临分标志 Facultative Reinsurance Flag */
    @Excel(name = "临分标志 Facultative Reinsurance Flag")
    @AnjiDescription("cRiFacMrk")
    private String cRiFacMrk;

    /** 再保审核人代码 Reinsurance Approver's No */
    @Excel(name = "再保审核人代码 Reinsurance Approver's No")
    @AnjiDescription("cRiChkCde")
    private String cRiChkCde;

    /** 再保确认标志 Reinsurance Approved Flag */
    @Excel(name = "再保确认标志 Reinsurance Approved Flag")
    @AnjiDescription("cRiMrk")
    private String cRiMrk;

    /** 批改生效起期 Beginning of Successive Edorsement  Effective Time  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批改生效起期 Beginning of Successive Edorsement  Effective Time ", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tNextEdrBgnTm")
    private Date tNextEdrBgnTm;

    /** 批改生效止期 End of Successive Edorsement Effective Time  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批改生效止期 End of Successive Edorsement Effective Time ", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tNextEdrEndTm")
    private Date tNextEdrEndTm;

    /** 下次批改核保日期 Underwriting Time of Endorsement in Succession */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次批改核保日期 Underwriting Time of Endorsement in Succession", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tNextEdrUdrTm")
    private Date tNextEdrUdrTm;

    /** 备注 Remark */
    @Excel(name = "备注 Remark")
    @AnjiDescription("cRemark")
    private String cRemark;

    /** 申请单状态
     "1";//暂存(录入，未提核)
     "2";//已提核
     "3";//核保退回
     "4";//已核保
     "5";//已签发保单
     "9"; //已拒保 */
     @AnjiDescription("cAppStatus")
     private String cAppStatus;

            /** 批改申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批改申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEdrAppTm")
    private Date tEdrAppTm;

    /** 批改生效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批改生效起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEdrBgnTm")
    private Date tEdrBgnTm;

    /** 批改生效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批改生效止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEdrEndTm")
    private Date tEdrEndTm;

    /** 申请类型,0 客户申请 1 内部批单， */
    @Excel(name = "申请类型,0 客户申请 1 内部批单，")
    @AnjiDescription("cEdrMrk")
    private String cEdrMrk;

    /** 批改类型,1 一般批改，2 注销，3退保 0 批单注销 */
    @Excel(name = "批改类型,1 一般批改，2 注销，3退保 0 批单注销")
    @AnjiDescription("cEdrType")
    private String cEdrType;

    /** 批改原因或组合代码 */
    @Excel(name = "批改原因或组合代码")
    @AnjiDescription("cEdrRsnBundleCde")
    private String cEdrRsnBundleCde;

    /** 批改业务原保单记录序批改号 Predecessor Endorsement Prj No */
    @Excel(name = "批改业务原保单记录序批改号 Predecessor Endorsement Prj No")
    @AnjiDescription("nBefEdrPrjNo")
    private Long nBefEdrPrjNo;

    /** 批改前保额 */
    @Excel(name = "批改前保额")
    @AnjiDescription("nBefEdrAmt")
    private Long nBefEdrAmt;

    /** 批改前保费 */
    @Excel(name = "批改前保费")
    @AnjiDescription("nBefEdrPrm")
    private Long nBefEdrPrm;

    /** 保额变化，批单保额-上一批单（保单）保额 */
    @Excel(name = "保额变化，批单保额-上一批单", readConverterExp = "保=单")
    @AnjiDescription("nAmtVar")
    private Long nAmtVar;

    /** 计算保费变化 */
    @Excel(name = "计算保费变化")
    @AnjiDescription("nCalcPrmVar")
    private Long nCalcPrmVar;

    /** 保费变化，批单保费上一批单（保单）保费 */
    @Excel(name = "保费变化，批单保费上一批单", readConverterExp = "保=单")
    @AnjiDescription("nPrmVar")
    private Long nPrmVar;

    /** 赔偿限额变化 */
    @Excel(name = "赔偿限额变化")
    @AnjiDescription("nIndemLmtVar")
    private Long nIndemLmtVar;

    /** 申请人代码 */
    @Excel(name = "申请人代码")
    @AnjiDescription("cAppPrsnCde")
    private String cAppPrsnCde;

    /** 申请人名称 */
    @Excel(name = "申请人名称")
    @AnjiDescription("cAppPrsnNme")
    private String cAppPrsnNme;

    /** 批文内容 */
    @Excel(name = "批文内容")
    @AnjiDescription("cEdrCtnt")
    private String cEdrCtnt;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt4")
    private String cResvTxt4;

    /** 创建人员 Creator No */
    @Excel(name = "创建人员 Creator No")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** 创建时间 Create Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间 Create Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 修改人员 Updater No */
    @Excel(name = "修改人员 Updater No")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 修改时间 Update Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间 Update Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nOrigTimes")
    private Long nOrigTimes;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cFinTyp")
    private String cFinTyp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nMaxFeeProp")
    private Long nMaxFeeProp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cVipCus")
    private String cVipCus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cGrantDptCde")
    private String cGrantDptCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cDptAttr")
    private String cDptAttr;

    /** 业务渠道01股东业务渠道02直销渠道99无 */
    @Excel(name = "业务渠道01股东业务渠道02直销渠道99无")
    @AnjiDescription("cSalegrpCde")
    private String cSalegrpCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSlsId")
    private String cSlsId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSlsTel")
    private String cSlsTel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSlsNme")
    private String cSlsNme;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cMinUndrDpt")
    private String cMinUndrDpt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cMinUndrCls")
    private String cMinUndrCls;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cFeeCalTyp")
    private String cFeeCalTyp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cRateNo")
    private String cRateNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSaveMrk")
    private String cSaveMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nBefEdrSaving")
    private Long nBefEdrSaving;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nSavingVar")
    private Long nSavingVar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCommonFlag")
    private String cCommonFlag;

    /** 即时生效标志 */
    @Excel(name = "即时生效标志")
    @AnjiDescription("cImmeffMrk")
    private String cImmeffMrk;

    /** 数据来源，本系统为空或0、网销接口为1、其它待定 */
    @Excel(name = "数据来源，本系统为空或0、网销接口为1、其它待定")
    @AnjiDescription("cDataSrc")
    private String cDataSrc;

    /** 国民经济行业分类与代码 */
    @Excel(name = "国民经济行业分类与代码")
    @AnjiDescription("cTrdCde")
    private String cTrdCde;

    /** 联合投保号,为null是为非联合投保 */
    @Excel(name = "联合投保号,为null是为非联合投保")
    @AnjiDescription("cJointNo")
    private String cJointNo;

    /** 占用性质 */
    @Excel(name = "占用性质")
    @AnjiDescription("cResvTxt5")
    private String cResvTxt5;

    /** 免赔说明(new) */
    @Excel(name = "免赔说明(new)")
    @AnjiDescription("cDductDesc")
    private String cDductDesc;

    /** 免赔率(new) */
    @Excel(name = "免赔率(new)")
    @AnjiDescription("nDductRate")
    private Long nDductRate;

    /** 绝对免赔额(new) */
    @Excel(name = "绝对免赔额(new)")
    @AnjiDescription("nDductAmt")
    private Long nDductAmt;

    /** 交强险保单号 */
    @Excel(name = "交强险保单号")
    @AnjiDescription("cJqxPlyNo")
    private String cJqxPlyNo;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt6")
    private String cResvTxt6;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt7")
    private String cResvTxt7;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt8")
    private String cResvTxt8;

    /** 停驶止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "停驶止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tResvTm1")
    private Date tResvTm1;

    /** 临分意见 */
    @Excel(name = "临分意见")
    @AnjiDescription("cRiFacOpn")
    private String cRiFacOpn;

    /** 共保我司净保额 */
    @Excel(name = "共保我司净保额")
    @AnjiDescription("nCiOwnAmt")
    private Long nCiOwnAmt;

    /** 共保我司净保费 */
    @Excel(name = "共保我司净保费")
    @AnjiDescription("nCiOwnPrm")
    private Long nCiOwnPrm;

    /** 挂帐币种 */
    @Excel(name = "挂帐币种")
    @AnjiDescription("cDueCur")
    private String cDueCur;

    /** 出单省份 */
    @Excel(name = "出单省份")
    @AnjiDescription("cProvince")
    private String cProvince;

    /** 出单地市 */
    @Excel(name = "出单地市")
    @AnjiDescription("cCity")
    private String cCity;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cZjZfhzMark")
    private String cZjZfhzMark;

    /** 手续费支付比例上限 */
    @Excel(name = "手续费支付比例上限")
    @AnjiDescription("comRateUpper")
    private Long comRateUpper;

    /** 公司总体手续费支付比例上限 */
    @Excel(name = "公司总体手续费支付比例上限")
    @AnjiDescription("cCompanyRateUpper")
    private Long cCompanyRateUpper;

    /** 上年承保保险公司 */
    @Excel(name = "上年承保保险公司")
    @AnjiDescription("cLastYearCorp")
    private String cLastYearCorp;

    /** 上年保单保险起期 */
    @Excel(name = "上年保单保险起期")
    @AnjiDescription("tLastInsbgnTm")
    private String tLastInsbgnTm;

    /** 自动核保标记1:自核 */
    @Excel(name = "自动核保标记1:自核")
    @AnjiDescription("cAutouwMrk")
    private String cAutouwMrk;

    /** 保险方案编码 */
    @Excel(name = "保险方案编码")
    @AnjiDescription("cPrdInsplan")
    private String cPrdInsplan;

    /** 批量个单的批量号 */
    @Excel(name = "批量个单的批量号")
    @AnjiDescription("cBatchNo")
    private String cBatchNo;

    /** 中介信息平台返回查询码 */
    @Excel(name = "中介信息平台返回查询码")
    @AnjiDescription("cQuerySequenceNo")
    private String cQuerySequenceNo;

    /** 查询码过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "查询码过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tQueryPastDate")
    private Date tQueryPastDate;

    /** 平台返回确认码 */
    @Excel(name = "平台返回确认码")
    @AnjiDescription("cConfirmSequenceNo")
    private String cConfirmSequenceNo;

    /** 投保份数 */
    @Excel(name = "投保份数")
    @AnjiDescription("nPlyCount")
    private Long nPlyCount;

    /** 保卡卡号 */
    @Excel(name = "保卡卡号")
    @AnjiDescription("cCardNo")
    private String cCardNo;

    /** 直销类型 */
    @Excel(name = "直销类型")
    @AnjiDescription("cZxType")
    private String cZxType;

    /** 道路救援标志 */
    @Excel(name = "道路救援标志")
    @AnjiDescription("cRescueFlg")
    private String cRescueFlg;

    /** 合约分保标志 */
    @Excel(name = "合约分保标志")
    @AnjiDescription("cContFlg")
    private String cContFlg;

    /** 询价单号 */
    @Excel(name = "询价单号")
    @AnjiDescription("cYwzdNo")
    private String cYwzdNo;

    /** 快速出单标志 */
    @Excel(name = "快速出单标志")
    @AnjiDescription("cQuickFlag")
    private String cQuickFlag;

    /** 交强商业保险起止期是否一致标志 */
    @Excel(name = "交强商业保险起止期是否一致标志")
    @AnjiDescription("cInsrnctmsyncFlag")
    private String cInsrnctmsyncFlag;

    /** 车辆停驶起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆停驶起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tVehicleLayoffBgnTm")
    private Date tVehicleLayoffBgnTm;

    /** 车辆停驶止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆停驶止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tVehicleLayoffEndTm")
    private Date tVehicleLayoffEndTm;

    /** 车辆顺延起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆顺延起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tExtendedBgnTm")
    private Date tExtendedBgnTm;

    /** 车辆顺延起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆顺延起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tExtendedEndTm")
    private Date tExtendedEndTm;

    /** 车辆复驶日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车辆复驶日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tVehicleResumptionTm")
    private Date tVehicleResumptionTm;

    /** 车辆停驶天数 */
    @Excel(name = "车辆停驶天数")
    @AnjiDescription("nLayoffDays")
    private Long nLayoffDays;

    /** 非固定特别约定备份 Unfixed Special ProvisionBackUp */
    @Excel(name = "非固定特别约定备份 Unfixed Special ProvisionBackUp")
    @AnjiDescription("cUnfixSpcBackUp")
    private String cUnfixSpcBackUp;

    /** 车险定价id/中农再投保id */
    @Excel(name = "车险定价id/中农再投保id")
    @AnjiDescription("cApId")
    private String cApId;

    /** 团车业务标志 */
    @Excel(name = "团车业务标志")
    @AnjiDescription("cPkgBusFlg")
    private String cPkgBusFlg;

    /** 自动定价使用标志 */
    @Excel(name = "自动定价使用标志")
    @AnjiDescription("cApUseFlg")
    private String cApUseFlg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cRiCont")
    private String cRiCont;

    /** 2是泛华代理出单、3网销、4电销、5移动展业 */
    @Excel(name = "2是泛华代理出单、3网销、4电销、5移动展业")
    @AnjiDescription("cIssueSrc")
    private String cIssueSrc;

    /** 承保验证码 */
    @Excel(name = "承保验证码")
    @AnjiDescription("cIssueCode")
    private String cIssueCode;

    /** 身份证采集器编码 */
    @Excel(name = "身份证采集器编码")
    @AnjiDescription("cMachineCode")
    private String cMachineCode;

    /** 出单计算机IP地址（北京） */
    @Excel(name = "出单计算机IP地址", readConverterExp = "北=京")
    @AnjiDescription("cComputerIp")
    private String cComputerIp;

    /** 县区 */
    @Excel(name = "县区")
    @AnjiDescription("cCounty")
    private String cCounty;

    /** 查询地区代码 */
    @Excel(name = "查询地区代码")
    @AnjiDescription("cAppointAreaCode")
    private String cAppointAreaCode;

    /** 是否全程批改 */
    @Excel(name = "是否全程批改")
    @AnjiDescription("cIsFullEndor")
    private String cIsFullEndor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cItemSystem")
    private String cItemSystem;

    /** 退保原因对应日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退保原因对应日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEdrCancelReasonTm")
    private Date tEdrCancelReasonTm;

    /** 电商业务来源 */
    @Excel(name = "电商业务来源")
    @AnjiDescription("cBusinessSrc")
    private String cBusinessSrc;

    /** 电商出单方式 */
    @Excel(name = "电商出单方式")
    @AnjiDescription("cIssueMode")
    private String cIssueMode;

    /** 是否电子保单标识（0否1是） */
    @Excel(name = "是否电子保单标识", readConverterExp = "0=否1是")
    @AnjiDescription("cIsElecPlyFlag")
    private String cIsElecPlyFlag;

    /** 我方主共时，手续费计算原则：0是按总保费计算，1是按我方净保费计算 */
    @Excel(name = "我方主共时，手续费计算原则：0是按总保费计算，1是按我方净保费计算")
    @AnjiDescription("cCiProFeePrinc")
    private String cCiProFeePrinc;

    /** 业务渠道（与团车协议号相关） */
    @Excel(name = "业务渠道", readConverterExp = "与=团车协议号相关")
    @AnjiDescription("cBusiChannel")
    private String cBusiChannel;

    /** 业务类型（与团车协议号相关） */
    @Excel(name = "业务类型", readConverterExp = "与=团车协议号相关")
    @AnjiDescription("cBusiType")
    private String cBusiType;

    /** 服务归属省份 */
    @Excel(name = "服务归属省份")
    @AnjiDescription("cServeProvince")
    private String cServeProvince;

    /** 服务归属地市 */
    @Excel(name = "服务归属地市")
    @AnjiDescription("cServeCity")
    private String cServeCity;

    /** 联合投保标志：0非联合，1同步联合，2异步联合 */
    @Excel(name = "联合投保标志：0非联合，1同步联合，2异步联合")
    @AnjiDescription("cJointMrk")
    private String cJointMrk;

    /** 超赔临分标志 */
    @Excel(name = "超赔临分标志")
    @AnjiDescription("cCpriFacMrk")
    private String cCpriFacMrk;

    /** 协议简称 */
    @Excel(name = "协议简称")
    @AnjiDescription("cAgrNme")
    private String cAgrNme;

    /** 预约协议号码 */
    @Excel(name = "预约协议号码")
    @AnjiDescription("cOcAgrNo")
    private String cOcAgrNo;

    /** 中介机构销售人员姓名 */
    @Excel(name = "中介机构销售人员姓名")
    @AnjiDescription("cSalesmanName")
    private String cSalesmanName;

    /** 中介机构销售人员执业证书编号 */
    @Excel(name = "中介机构销售人员执业证书编号")
    @AnjiDescription("cCertSalesmanNum")
    private String cCertSalesmanNum;

    /** 销售中介机构名称 */
    @Excel(name = "销售中介机构名称")
    @AnjiDescription("cCertificateName")
    private String cCertificateName;

    /** 销售中介机构联系电话 */
    @Excel(name = "销售中介机构联系电话")
    @AnjiDescription("cCertificatePhone")
    private String cCertificatePhone;

    /** 业务资源来源 */
    @Excel(name = "业务资源来源")
    @AnjiDescription("cSourceOfBusinessResources")
    private String cSourceOfBusinessResources;

    /** 资金用途 */
    @Excel(name = "资金用途")
    @AnjiDescription("cUseOfProceeds")
    private String cUseOfProceeds;

    /** 追偿状态 */
    @Excel(name = "追偿状态")
    @AnjiDescription("cRecoverStatus")
    private String cRecoverStatus;

    /** 追偿金额 */
    @Excel(name = "追偿金额")
    @AnjiDescription("nRecoverAmt")
    private Long nRecoverAmt;

    /** 缴费方式(判断缴费方式是否是微信用) */
    @Excel(name = "缴费方式(判断缴费方式是否是微信用)")
    @AnjiDescription("cFinPhoneTyp")
    private String cFinPhoneTyp;

    /** 归属机构 */
    @Excel(name = "归属机构")
    @AnjiDescription("cBelongCdptcde")
    private String cBelongCdptcde;

    /** 期望折扣 */
    @Excel(name = "期望折扣")
    @AnjiDescription("nExpectDisc")
    private Long nExpectDisc;

    /** 编码 */
    @Excel(name = "编码")
    @AnjiDescription("cCoding")
    private String cCoding;

    /** 增值服务编码 */
    @Excel(name = "增值服务编码")
    @AnjiDescription("cSpecialCde")
    private String cSpecialCde;

    /** 实际业务渠道 */
    @Excel(name = "实际业务渠道")
    @AnjiDescription("cActBusiChannel")
    private String cActBusiChannel;

    /** 组合险种投保订单号 */
    @Excel(name = "组合险种投保订单号")
    @AnjiDescription("cConsRiskCde")
    private String cConsRiskCde;

    /** 核保部门 */
    @Excel(name = "核保部门")
    @AnjiDescription("cUwDptCde")
    private String cUwDptCde;

    /** 投保人身份校验结果 */
    @Excel(name = "投保人身份校验结果")
    @AnjiDescription("cAppauthCde")
    private String cAppauthCde;

    /** 特约编码 */
    @Excel(name = "特约编码")
    @AnjiDescription("cUnfixSpcNo")
    private String cUnfixSpcNo;

    /** 渠道名称 中台出单用 */
    @Excel(name = "渠道名称 中台出单用")
    @AnjiDescription("cChannelName")
    private String cChannelName;

    /** 推荐人 中台出单用 */
    @Excel(name = "推荐人 中台出单用")
    @AnjiDescription("cReferrerName")
    private String cReferrerName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cRealNameConfirm")
    private String cRealNameConfirm;

    /** 投保验证码 */
    @Excel(name = "投保验证码")
    @AnjiDescription("cApplicantNo")
    private String cApplicantNo;

    /** 投保告知业务号 */
    @Excel(name = "投保告知业务号")
    @AnjiDescription("cInformNo")
    private String cInformNo;

    /** 公示编号 */
    @Excel(name = "公示编号")
    @AnjiDescription("cPublicityNo")
    private String cPublicityNo;

    /** 智农险单号 */
    @Excel(name = "智农险单号")
    @AnjiDescription("cBillNo")
    private String cBillNo;

    /** 新旧网销的标识 空：旧  1：新 */
    @Excel(name = "新旧网销的标识 空：旧  1：新")
    @AnjiDescription("cIssueSrcWx")
    private String cIssueSrcWx;

    /** 电子保单下载地址 */
    @Excel(name = "电子保单下载地址")
    @AnjiDescription("cEtDownlink")
    private String cEtDownlink;

    /** 电子保单发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "电子保单发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEtSendTm")
    private Date tEtSendTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSpCust")
    private String cSpCust;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSpCustClass")
    private String cSpCustClass;

    /** 业务归属人员 */
    @Excel(name = "业务归属人员")
    @AnjiDescription("cBusinessOwner")
    private String cBusinessOwner;

    /** 产品名称（电商） */
    @Excel(name = "产品名称", readConverterExp = "电=商")
    @AnjiDescription("cEcProdName")
    private String cEcProdName;

    /** 产品方案（电商） */
    @Excel(name = "产品方案", readConverterExp = "电=商")
    @AnjiDescription("cEcProdPlan")
    private String cEcProdPlan;

    /** 产品方案版本号（电商） */
    @Excel(name = "产品方案版本号", readConverterExp = "电=商")
    @AnjiDescription("cEcProdplanVersion")
    private String cEcProdplanVersion;

    /** 团单不记名投保标志 */
    @Excel(name = "团单不记名投保标志")
    @AnjiDescription("cAnonymousMark")
    private String cAnonymousMark;

    /** 融资类标志 */
    @Excel(name = "融资类标志")
    @AnjiDescription("cFinancingMark")
    private String cFinancingMark;

    /** 是否属于政府政策性业务 */
    @Excel(name = "是否属于政府政策性业务")
    @AnjiDescription("cIsGovernment")
    private String cIsGovernment;

    /** 强制非见费出单，仅限天津 */
    @Excel(name = "强制非见费出单，仅限天津")
    @AnjiDescription("cNoSeemoneyMrk")
    private String cNoSeemoneyMrk;

    /** 验标标志 */
    @Excel(name = "验标标志")
    @AnjiDescription("cAgroStandardSign")
    private String cAgroStandardSign;

    /** 承保公示标志 */
    @Excel(name = "承保公示标志")
    @AnjiDescription("cAgroPublicitySign")
    private String cAgroPublicitySign;

    /** 实报实收标志 */
    @Excel(name = "实报实收标志")
    @AnjiDescription("cPaidFlag")
    private String cPaidFlag;

    /** 报告起始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告起始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("cReStartDate")
    private Date cReStartDate;

    /** 报告终止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告终止日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("cReEndDate")
    private Date cReEndDate;

    /** 预留 Reserved Field */
    @Excel(name = "预留 Reserved Field")
    @AnjiDescription("cResvTxt9")
    private String cResvTxt9;

    /** 报告起止期天数 */
    @Excel(name = "报告起止期天数")
    @AnjiDescription("cResvTxt12")
    private String cResvTxt12;

    /** 连带营业中断险 */
    @Excel(name = "连带营业中断险")
    @AnjiDescription("cBusinessInterruption")
    private String cBusinessInterruption;

    /** 中国海外利益业务标识 */
    @Excel(name = "中国海外利益业务标识")
    @AnjiDescription("cOverseasBusiness")
    private String cOverseasBusiness;

    /** 慢病类型 */
    @Excel(name = "慢病类型")
    @AnjiDescription("cDiseaseType")
    private String cDiseaseType;

    /** 泰山自主定价平台定价ID */
    @Excel(name = "泰山自主定价平台定价ID")
    @AnjiDescription("cTsApId")
    private String cTsApId;

    /** 是否政府合作类项目 */
    @Excel(name = "是否政府合作类项目")
    @AnjiDescription("cIsGovCooperation")
    private String cIsGovCooperation;

    /** ★ */
    @Excel(name = "★")
    @AnjiDescription("nSpecialExpectDisc")
    private Long nSpecialExpectDisc;

    /** 保险缴费日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "保险缴费日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("cInsPayDate")
    private Date cInsPayDate;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcAppTyp(String cAppTyp)
    {
        this.cAppTyp = cAppTyp;
    }

    public String getcAppTyp()
    {
        return cAppTyp;
    }
    public void setcPlyNo(String cPlyNo)
    {
        this.cPlyNo = cPlyNo;
    }

    public String getcPlyNo()
    {
        return cPlyNo;
    }
    public void setnEdrPrjNo(Long nEdrPrjNo)
    {
        this.nEdrPrjNo = nEdrPrjNo;
    }

    public Long getnEdrPrjNo()
    {
        return nEdrPrjNo;
    }
    public void setcRelPlyNo(String cRelPlyNo)
    {
        this.cRelPlyNo = cRelPlyNo;
    }

    public String getcRelPlyNo()
    {
        return cRelPlyNo;
    }
    public void setcProdNo(String cProdNo)
    {
        this.cProdNo = cProdNo;
    }

    public String getcProdNo()
    {
        return cProdNo;
    }
    public void setcDptCde(String cDptCde)
    {
        this.cDptCde = cDptCde;
    }

    public String getcDptCde()
    {
        return cDptCde;
    }
    public void setcSlsCde(String cSlsCde)
    {
        this.cSlsCde = cSlsCde;
    }

    public String getcSlsCde()
    {
        return cSlsCde;
    }
    public void setcBsnsTyp(String cBsnsTyp)
    {
        this.cBsnsTyp = cBsnsTyp;
    }

    public String getcBsnsTyp()
    {
        return cBsnsTyp;
    }
    public void setcBsnsSubtyp(String cBsnsSubtyp)
    {
        this.cBsnsSubtyp = cBsnsSubtyp;
    }

    public String getcBsnsSubtyp()
    {
        return cBsnsSubtyp;
    }
    public void setcBrkrCde(String cBrkrCde)
    {
        this.cBrkrCde = cBrkrCde;
    }

    public String getcBrkrCde()
    {
        return cBrkrCde;
    }
    public void setcAgtAgrNo(String cAgtAgrNo)
    {
        this.cAgtAgrNo = cAgtAgrNo;
    }

    public String getcAgtAgrNo()
    {
        return cAgtAgrNo;
    }
    public void setnSubCoNo(String nSubCoNo)
    {
        this.nSubCoNo = nSubCoNo;
    }

    public String getnSubCoNo()
    {
        return nSubCoNo;
    }
    public void setcOcPlyNo(String cOcPlyNo)
    {
        this.cOcPlyNo = cOcPlyNo;
    }

    public String getcOcPlyNo()
    {
        return cOcPlyNo;
    }
    public void setnDiscRate(Long nDiscRate)
    {
        this.nDiscRate = nDiscRate;
    }

    public Long getnDiscRate()
    {
        return nDiscRate;
    }
    public void setnRate(Long nRate)
    {
        this.nRate = nRate;
    }

    public Long getnRate()
    {
        return nRate;
    }
    public void setnCommRate(Long nCommRate)
    {
        this.nCommRate = nCommRate;
    }

    public Long getnCommRate()
    {
        return nCommRate;
    }
    public void setcRenewMrk(String cRenewMrk)
    {
        this.cRenewMrk = cRenewMrk;
    }

    public String getcRenewMrk()
    {
        return cRenewMrk;
    }
    public void setcOrigPlyNo(String cOrigPlyNo)
    {
        this.cOrigPlyNo = cOrigPlyNo;
    }

    public String getcOrigPlyNo()
    {
        return cOrigPlyNo;
    }
    public void setcOrigInsurer(String cOrigInsurer)
    {
        this.cOrigInsurer = cOrigInsurer;
    }

    public String getcOrigInsurer()
    {
        return cOrigInsurer;
    }
    public void setcAmtCur(String cAmtCur)
    {
        this.cAmtCur = cAmtCur;
    }

    public String getcAmtCur()
    {
        return cAmtCur;
    }
    public void setnAmt(Long nAmt)
    {
        this.nAmt = nAmt;
    }

    public Long getnAmt()
    {
        return nAmt;
    }
    public void setnAmtRmbExch(Long nAmtRmbExch)
    {
        this.nAmtRmbExch = nAmtRmbExch;
    }

    public Long getnAmtRmbExch()
    {
        return nAmtRmbExch;
    }
    public void setcPrmCur(String cPrmCur)
    {
        this.cPrmCur = cPrmCur;
    }

    public String getcPrmCur()
    {
        return cPrmCur;
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
    public void setnPrmRmbExch(Long nPrmRmbExch)
    {
        this.nPrmRmbExch = nPrmRmbExch;
    }

    public Long getnPrmRmbExch()
    {
        return nPrmRmbExch;
    }
    public void setnIndemLmt(Long nIndemLmt)
    {
        this.nIndemLmt = nIndemLmt;
    }

    public Long getnIndemLmt()
    {
        return nIndemLmt;
    }
    public void setcRatioTyp(String cRatioTyp)
    {
        this.cRatioTyp = cRatioTyp;
    }

    public String getcRatioTyp()
    {
        return cRatioTyp;
    }
    public void setnRatioCoef(Long nRatioCoef)
    {
        this.nRatioCoef = nRatioCoef;
    }

    public Long getnRatioCoef()
    {
        return nRatioCoef;
    }
    public void setnSavingAmt(Long nSavingAmt)
    {
        this.nSavingAmt = nSavingAmt;
    }

    public Long getnSavingAmt()
    {
        return nSavingAmt;
    }
    public void setcPlySts(String cPlySts)
    {
        this.cPlySts = cPlySts;
    }

    public String getcPlySts()
    {
        return cPlySts;
    }
    public void settTermnTm(Date tTermnTm)
    {
        this.tTermnTm = tTermnTm;
    }

    public Date gettTermnTm()
    {
        return tTermnTm;
    }
    public void setcInwdMrk(String cInwdMrk)
    {
        this.cInwdMrk = cInwdMrk;
    }

    public String getcInwdMrk()
    {
        return cInwdMrk;
    }
    public void setcCiMrk(String cCiMrk)
    {
        this.cCiMrk = cCiMrk;
    }

    public String getcCiMrk()
    {
        return cCiMrk;
    }
    public void setcCiTyp(String cCiTyp)
    {
        this.cCiTyp = cCiTyp;
    }

    public String getcCiTyp()
    {
        return cCiTyp;
    }
    public void setnCiJntAmt(Long nCiJntAmt)
    {
        this.nCiJntAmt = nCiJntAmt;
    }

    public Long getnCiJntAmt()
    {
        return nCiJntAmt;
    }
    public void setnCiJntPrm(Long nCiJntPrm)
    {
        this.nCiJntPrm = nCiJntPrm;
    }

    public Long getnCiJntPrm()
    {
        return nCiJntPrm;
    }
    public void setcLongTermMrk(String cLongTermMrk)
    {
        this.cLongTermMrk = cLongTermMrk;
    }

    public String getcLongTermMrk()
    {
        return cLongTermMrk;
    }
    public void settAppTm(Date tAppTm)
    {
        this.tAppTm = tAppTm;
    }

    public Date gettAppTm()
    {
        return tAppTm;
    }
    public void setcOprTyp(String cOprTyp)
    {
        this.cOprTyp = cOprTyp;
    }

    public String getcOprTyp()
    {
        return cOprTyp;
    }
    public void setcPrnNo(String cPrnNo)
    {
        this.cPrnNo = cPrnNo;
    }

    public String getcPrnNo()
    {
        return cPrnNo;
    }
    public void settInsrncBgnTm(Date tInsrncBgnTm)
    {
        this.tInsrncBgnTm = tInsrncBgnTm;
    }

    public Date gettInsrncBgnTm()
    {
        return tInsrncBgnTm;
    }
    public void settInsrncEndTm(Date tInsrncEndTm)
    {
        this.tInsrncEndTm = tInsrncEndTm;
    }

    public Date gettInsrncEndTm()
    {
        return tInsrncEndTm;
    }
    public void setcTmSysCde(String cTmSysCde)
    {
        this.cTmSysCde = cTmSysCde;
    }

    public String getcTmSysCde()
    {
        return cTmSysCde;
    }
    public void setcUnfixSpc(String cUnfixSpc)
    {
        this.cUnfixSpc = cUnfixSpc;
    }

    public String getcUnfixSpc()
    {
        return cUnfixSpc;
    }
    public void setcMultInsrntMrk(String cMultInsrntMrk)
    {
        this.cMultInsrntMrk = cMultInsrntMrk;
    }

    public String getcMultInsrntMrk()
    {
        return cMultInsrntMrk;
    }
    public void setcGrpMrk(String cGrpMrk)
    {
        this.cGrpMrk = cGrpMrk;
    }

    public String getcGrpMrk()
    {
        return cGrpMrk;
    }
    public void setcListorcolMrk(String cListorcolMrk)
    {
        this.cListorcolMrk = cListorcolMrk;
    }

    public String getcListorcolMrk()
    {
        return cListorcolMrk;
    }
    public void setcMasterMrk(String cMasterMrk)
    {
        this.cMasterMrk = cMasterMrk;
    }

    public String getcMasterMrk()
    {
        return cMasterMrk;
    }
    public void setcBidMrk(String cBidMrk)
    {
        this.cBidMrk = cBidMrk;
    }

    public String getcBidMrk()
    {
        return cBidMrk;
    }
    public void setcPkgMrk(String cPkgMrk)
    {
        this.cPkgMrk = cPkgMrk;
    }

    public String getcPkgMrk()
    {
        return cPkgMrk;
    }
    public void setcPkgNo(String cPkgNo)
    {
        this.cPkgNo = cPkgNo;
    }

    public String getcPkgNo()
    {
        return cPkgNo;
    }
    public void setnPrmDisc(Long nPrmDisc)
    {
        this.nPrmDisc = nPrmDisc;
    }

    public Long getnPrmDisc()
    {
        return nPrmDisc;
    }
    public void setcRegMrk(String cRegMrk)
    {
        this.cRegMrk = cRegMrk;
    }

    public String getcRegMrk()
    {
        return cRegMrk;
    }
    public void setcDecMrk(String cDecMrk)
    {
        this.cDecMrk = cDecMrk;
    }

    public String getcDecMrk()
    {
        return cDecMrk;
    }
    public void setcJuriCde(String cJuriCde)
    {
        this.cJuriCde = cJuriCde;
    }

    public String getcJuriCde()
    {
        return cJuriCde;
    }
    public void setcAgriMrk(String cAgriMrk)
    {
        this.cAgriMrk = cAgriMrk;
    }

    public String getcAgriMrk()
    {
        return cAgriMrk;
    }
    public void setcForeignMrk(String cForeignMrk)
    {
        this.cForeignMrk = cForeignMrk;
    }

    public String getcForeignMrk()
    {
        return cForeignMrk;
    }
    public void setcImporexpMrk(String cImporexpMrk)
    {
        this.cImporexpMrk = cImporexpMrk;
    }

    public String getcImporexpMrk()
    {
        return cImporexpMrk;
    }
    public void setcManualMrk(String cManualMrk)
    {
        this.cManualMrk = cManualMrk;
    }

    public String getcManualMrk()
    {
        return cManualMrk;
    }
    public void setcInstMrk(String cInstMrk)
    {
        this.cInstMrk = cInstMrk;
    }

    public String getcInstMrk()
    {
        return cInstMrk;
    }
    public void setcVipMrk(String cVipMrk)
    {
        this.cVipMrk = cVipMrk;
    }

    public String getcVipMrk()
    {
        return cVipMrk;
    }
    public void setcOpenCoverNo(String cOpenCoverNo)
    {
        this.cOpenCoverNo = cOpenCoverNo;
    }

    public String getcOpenCoverNo()
    {
        return cOpenCoverNo;
    }
    public void setcDisptSttlCde(String cDisptSttlCde)
    {
        this.cDisptSttlCde = cDisptSttlCde;
    }

    public String getcDisptSttlCde()
    {
        return cDisptSttlCde;
    }
    public void setcDisptSttlOrg(String cDisptSttlOrg)
    {
        this.cDisptSttlOrg = cDisptSttlOrg;
    }

    public String getcDisptSttlOrg()
    {
        return cDisptSttlOrg;
    }
    public void setcOprCde(String cOprCde)
    {
        this.cOprCde = cOprCde;
    }

    public String getcOprCde()
    {
        return cOprCde;
    }
    public void settOprTm(Date tOprTm)
    {
        this.tOprTm = tOprTm;
    }

    public Date gettOprTm()
    {
        return tOprTm;
    }
    public void setcChkCde(String cChkCde)
    {
        this.cChkCde = cChkCde;
    }

    public String getcChkCde()
    {
        return cChkCde;
    }
    public void settIssueTm(Date tIssueTm)
    {
        this.tIssueTm = tIssueTm;
    }

    public Date gettIssueTm()
    {
        return tIssueTm;
    }
    public void settUdrTm(Date tUdrTm)
    {
        this.tUdrTm = tUdrTm;
    }

    public Date gettUdrTm()
    {
        return tUdrTm;
    }
    public void setcUdrDptCde(String cUdrDptCde)
    {
        this.cUdrDptCde = cUdrDptCde;
    }

    public String getcUdrDptCde()
    {
        return cUdrDptCde;
    }
    public void setcUdrCde(String cUdrCde)
    {
        this.cUdrCde = cUdrCde;
    }

    public String getcUdrCde()
    {
        return cUdrCde;
    }
    public void setcUdrMrk(String cUdrMrk)
    {
        this.cUdrMrk = cUdrMrk;
    }

    public String getcUdrMrk()
    {
        return cUdrMrk;
    }
    public void setcRiFacMrk(String cRiFacMrk)
    {
        this.cRiFacMrk = cRiFacMrk;
    }

    public String getcRiFacMrk()
    {
        return cRiFacMrk;
    }
    public void setcRiChkCde(String cRiChkCde)
    {
        this.cRiChkCde = cRiChkCde;
    }

    public String getcRiChkCde()
    {
        return cRiChkCde;
    }
    public void setcRiMrk(String cRiMrk)
    {
        this.cRiMrk = cRiMrk;
    }

    public String getcRiMrk()
    {
        return cRiMrk;
    }
    public void settNextEdrBgnTm(Date tNextEdrBgnTm)
    {
        this.tNextEdrBgnTm = tNextEdrBgnTm;
    }

    public Date gettNextEdrBgnTm()
    {
        return tNextEdrBgnTm;
    }
    public void settNextEdrEndTm(Date tNextEdrEndTm)
    {
        this.tNextEdrEndTm = tNextEdrEndTm;
    }

    public Date gettNextEdrEndTm()
    {
        return tNextEdrEndTm;
    }
    public void settNextEdrUdrTm(Date tNextEdrUdrTm)
    {
        this.tNextEdrUdrTm = tNextEdrUdrTm;
    }

    public Date gettNextEdrUdrTm()
    {
        return tNextEdrUdrTm;
    }
    public void setcRemark(String cRemark)
    {
        this.cRemark = cRemark;
    }

    public String getcRemark()
    {
        return cRemark;
    }
    public void setcAppStatus(String cAppStatus)
    {
        this.cAppStatus = cAppStatus;
    }

    public String getcAppStatus()
    {
        return cAppStatus;
    }
    public void settEdrAppTm(Date tEdrAppTm)
    {
        this.tEdrAppTm = tEdrAppTm;
    }

    public Date gettEdrAppTm()
    {
        return tEdrAppTm;
    }
    public void settEdrBgnTm(Date tEdrBgnTm)
    {
        this.tEdrBgnTm = tEdrBgnTm;
    }

    public Date gettEdrBgnTm()
    {
        return tEdrBgnTm;
    }
    public void settEdrEndTm(Date tEdrEndTm)
    {
        this.tEdrEndTm = tEdrEndTm;
    }

    public Date gettEdrEndTm()
    {
        return tEdrEndTm;
    }
    public void setcEdrMrk(String cEdrMrk)
    {
        this.cEdrMrk = cEdrMrk;
    }

    public String getcEdrMrk()
    {
        return cEdrMrk;
    }
    public void setcEdrType(String cEdrType)
    {
        this.cEdrType = cEdrType;
    }

    public String getcEdrType()
    {
        return cEdrType;
    }
    public void setcEdrRsnBundleCde(String cEdrRsnBundleCde)
    {
        this.cEdrRsnBundleCde = cEdrRsnBundleCde;
    }

    public String getcEdrRsnBundleCde()
    {
        return cEdrRsnBundleCde;
    }
    public void setnBefEdrPrjNo(Long nBefEdrPrjNo)
    {
        this.nBefEdrPrjNo = nBefEdrPrjNo;
    }

    public Long getnBefEdrPrjNo()
    {
        return nBefEdrPrjNo;
    }
    public void setnBefEdrAmt(Long nBefEdrAmt)
    {
        this.nBefEdrAmt = nBefEdrAmt;
    }

    public Long getnBefEdrAmt()
    {
        return nBefEdrAmt;
    }
    public void setnBefEdrPrm(Long nBefEdrPrm)
    {
        this.nBefEdrPrm = nBefEdrPrm;
    }

    public Long getnBefEdrPrm()
    {
        return nBefEdrPrm;
    }
    public void setnAmtVar(Long nAmtVar)
    {
        this.nAmtVar = nAmtVar;
    }

    public Long getnAmtVar()
    {
        return nAmtVar;
    }
    public void setnCalcPrmVar(Long nCalcPrmVar)
    {
        this.nCalcPrmVar = nCalcPrmVar;
    }

    public Long getnCalcPrmVar()
    {
        return nCalcPrmVar;
    }
    public void setnPrmVar(Long nPrmVar)
    {
        this.nPrmVar = nPrmVar;
    }

    public Long getnPrmVar()
    {
        return nPrmVar;
    }
    public void setnIndemLmtVar(Long nIndemLmtVar)
    {
        this.nIndemLmtVar = nIndemLmtVar;
    }

    public Long getnIndemLmtVar()
    {
        return nIndemLmtVar;
    }
    public void setcAppPrsnCde(String cAppPrsnCde)
    {
        this.cAppPrsnCde = cAppPrsnCde;
    }

    public String getcAppPrsnCde()
    {
        return cAppPrsnCde;
    }
    public void setcAppPrsnNme(String cAppPrsnNme)
    {
        this.cAppPrsnNme = cAppPrsnNme;
    }

    public String getcAppPrsnNme()
    {
        return cAppPrsnNme;
    }
    public void setcEdrCtnt(String cEdrCtnt)
    {
        this.cEdrCtnt = cEdrCtnt;
    }

    public String getcEdrCtnt()
    {
        return cEdrCtnt;
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
    public void setnOrigTimes(Long nOrigTimes)
    {
        this.nOrigTimes = nOrigTimes;
    }

    public Long getnOrigTimes()
    {
        return nOrigTimes;
    }
    public void setcFinTyp(String cFinTyp)
    {
        this.cFinTyp = cFinTyp;
    }

    public String getcFinTyp()
    {
        return cFinTyp;
    }
    public void setnMaxFeeProp(Long nMaxFeeProp)
    {
        this.nMaxFeeProp = nMaxFeeProp;
    }

    public Long getnMaxFeeProp()
    {
        return nMaxFeeProp;
    }
    public void setcVipCus(String cVipCus)
    {
        this.cVipCus = cVipCus;
    }

    public String getcVipCus()
    {
        return cVipCus;
    }
    public void setcGrantDptCde(String cGrantDptCde)
    {
        this.cGrantDptCde = cGrantDptCde;
    }

    public String getcGrantDptCde()
    {
        return cGrantDptCde;
    }
    public void setcDptAttr(String cDptAttr)
    {
        this.cDptAttr = cDptAttr;
    }

    public String getcDptAttr()
    {
        return cDptAttr;
    }
    public void setcSalegrpCde(String cSalegrpCde)
    {
        this.cSalegrpCde = cSalegrpCde;
    }

    public String getcSalegrpCde()
    {
        return cSalegrpCde;
    }
    public void setcSlsId(String cSlsId)
    {
        this.cSlsId = cSlsId;
    }

    public String getcSlsId()
    {
        return cSlsId;
    }
    public void setcSlsTel(String cSlsTel)
    {
        this.cSlsTel = cSlsTel;
    }

    public String getcSlsTel()
    {
        return cSlsTel;
    }
    public void setcSlsNme(String cSlsNme)
    {
        this.cSlsNme = cSlsNme;
    }

    public String getcSlsNme()
    {
        return cSlsNme;
    }
    public void setcMinUndrDpt(String cMinUndrDpt)
    {
        this.cMinUndrDpt = cMinUndrDpt;
    }

    public String getcMinUndrDpt()
    {
        return cMinUndrDpt;
    }
    public void setcMinUndrCls(String cMinUndrCls)
    {
        this.cMinUndrCls = cMinUndrCls;
    }

    public String getcMinUndrCls()
    {
        return cMinUndrCls;
    }
    public void setcFeeCalTyp(String cFeeCalTyp)
    {
        this.cFeeCalTyp = cFeeCalTyp;
    }

    public String getcFeeCalTyp()
    {
        return cFeeCalTyp;
    }
    public void setcRateNo(String cRateNo)
    {
        this.cRateNo = cRateNo;
    }

    public String getcRateNo()
    {
        return cRateNo;
    }
    public void setcSaveMrk(String cSaveMrk)
    {
        this.cSaveMrk = cSaveMrk;
    }

    public String getcSaveMrk()
    {
        return cSaveMrk;
    }
    public void setnBefEdrSaving(Long nBefEdrSaving)
    {
        this.nBefEdrSaving = nBefEdrSaving;
    }

    public Long getnBefEdrSaving()
    {
        return nBefEdrSaving;
    }
    public void setnSavingVar(Long nSavingVar)
    {
        this.nSavingVar = nSavingVar;
    }

    public Long getnSavingVar()
    {
        return nSavingVar;
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
    public void setcCommonFlag(String cCommonFlag)
    {
        this.cCommonFlag = cCommonFlag;
    }

    public String getcCommonFlag()
    {
        return cCommonFlag;
    }
    public void setcImmeffMrk(String cImmeffMrk)
    {
        this.cImmeffMrk = cImmeffMrk;
    }

    public String getcImmeffMrk()
    {
        return cImmeffMrk;
    }
    public void setcDataSrc(String cDataSrc)
    {
        this.cDataSrc = cDataSrc;
    }

    public String getcDataSrc()
    {
        return cDataSrc;
    }
    public void setcTrdCde(String cTrdCde)
    {
        this.cTrdCde = cTrdCde;
    }

    public String getcTrdCde()
    {
        return cTrdCde;
    }
    public void setcJointNo(String cJointNo)
    {
        this.cJointNo = cJointNo;
    }

    public String getcJointNo()
    {
        return cJointNo;
    }
    public void setcResvTxt5(String cResvTxt5)
    {
        this.cResvTxt5 = cResvTxt5;
    }

    public String getcResvTxt5()
    {
        return cResvTxt5;
    }
    public void setcDductDesc(String cDductDesc)
    {
        this.cDductDesc = cDductDesc;
    }

    public String getcDductDesc()
    {
        return cDductDesc;
    }
    public void setnDductRate(Long nDductRate)
    {
        this.nDductRate = nDductRate;
    }

    public Long getnDductRate()
    {
        return nDductRate;
    }
    public void setnDductAmt(Long nDductAmt)
    {
        this.nDductAmt = nDductAmt;
    }

    public Long getnDductAmt()
    {
        return nDductAmt;
    }
    public void setcJqxPlyNo(String cJqxPlyNo)
    {
        this.cJqxPlyNo = cJqxPlyNo;
    }

    public String getcJqxPlyNo()
    {
        return cJqxPlyNo;
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
    public void settResvTm1(Date tResvTm1)
    {
        this.tResvTm1 = tResvTm1;
    }

    public Date gettResvTm1()
    {
        return tResvTm1;
    }
    public void setcRiFacOpn(String cRiFacOpn)
    {
        this.cRiFacOpn = cRiFacOpn;
    }

    public String getcRiFacOpn()
    {
        return cRiFacOpn;
    }
    public void setnCiOwnAmt(Long nCiOwnAmt)
    {
        this.nCiOwnAmt = nCiOwnAmt;
    }

    public Long getnCiOwnAmt()
    {
        return nCiOwnAmt;
    }
    public void setnCiOwnPrm(Long nCiOwnPrm)
    {
        this.nCiOwnPrm = nCiOwnPrm;
    }

    public Long getnCiOwnPrm()
    {
        return nCiOwnPrm;
    }
    public void setcDueCur(String cDueCur)
    {
        this.cDueCur = cDueCur;
    }

    public String getcDueCur()
    {
        return cDueCur;
    }
    public void setcProvince(String cProvince)
    {
        this.cProvince = cProvince;
    }

    public String getcProvince()
    {
        return cProvince;
    }
    public void setcCity(String cCity)
    {
        this.cCity = cCity;
    }

    public String getcCity()
    {
        return cCity;
    }
    public void setcZjZfhzMark(String cZjZfhzMark)
    {
        this.cZjZfhzMark = cZjZfhzMark;
    }

    public String getcZjZfhzMark()
    {
        return cZjZfhzMark;
    }
    public void setComRateUpper(Long comRateUpper)
    {
        this.comRateUpper = comRateUpper;
    }

    public Long getComRateUpper()
    {
        return comRateUpper;
    }
    public void setcCompanyRateUpper(Long cCompanyRateUpper)
    {
        this.cCompanyRateUpper = cCompanyRateUpper;
    }

    public Long getcCompanyRateUpper()
    {
        return cCompanyRateUpper;
    }
    public void setcLastYearCorp(String cLastYearCorp)
    {
        this.cLastYearCorp = cLastYearCorp;
    }

    public String getcLastYearCorp()
    {
        return cLastYearCorp;
    }
    public void settLastInsbgnTm(String tLastInsbgnTm)
    {
        this.tLastInsbgnTm = tLastInsbgnTm;
    }

    public String gettLastInsbgnTm()
    {
        return tLastInsbgnTm;
    }
    public void setcAutouwMrk(String cAutouwMrk)
    {
        this.cAutouwMrk = cAutouwMrk;
    }

    public String getcAutouwMrk()
    {
        return cAutouwMrk;
    }
    public void setcPrdInsplan(String cPrdInsplan)
    {
        this.cPrdInsplan = cPrdInsplan;
    }

    public String getcPrdInsplan()
    {
        return cPrdInsplan;
    }
    public void setcBatchNo(String cBatchNo)
    {
        this.cBatchNo = cBatchNo;
    }

    public String getcBatchNo()
    {
        return cBatchNo;
    }
    public void setcQuerySequenceNo(String cQuerySequenceNo)
    {
        this.cQuerySequenceNo = cQuerySequenceNo;
    }

    public String getcQuerySequenceNo()
    {
        return cQuerySequenceNo;
    }
    public void settQueryPastDate(Date tQueryPastDate)
    {
        this.tQueryPastDate = tQueryPastDate;
    }

    public Date gettQueryPastDate()
    {
        return tQueryPastDate;
    }
    public void setcConfirmSequenceNo(String cConfirmSequenceNo)
    {
        this.cConfirmSequenceNo = cConfirmSequenceNo;
    }

    public String getcConfirmSequenceNo()
    {
        return cConfirmSequenceNo;
    }
    public void setnPlyCount(Long nPlyCount)
    {
        this.nPlyCount = nPlyCount;
    }

    public Long getnPlyCount()
    {
        return nPlyCount;
    }
    public void setcCardNo(String cCardNo)
    {
        this.cCardNo = cCardNo;
    }

    public String getcCardNo()
    {
        return cCardNo;
    }
    public void setcZxType(String cZxType)
    {
        this.cZxType = cZxType;
    }

    public String getcZxType()
    {
        return cZxType;
    }
    public void setcRescueFlg(String cRescueFlg)
    {
        this.cRescueFlg = cRescueFlg;
    }

    public String getcRescueFlg()
    {
        return cRescueFlg;
    }
    public void setcContFlg(String cContFlg)
    {
        this.cContFlg = cContFlg;
    }

    public String getcContFlg()
    {
        return cContFlg;
    }
    public void setcYwzdNo(String cYwzdNo)
    {
        this.cYwzdNo = cYwzdNo;
    }

    public String getcYwzdNo()
    {
        return cYwzdNo;
    }
    public void setcQuickFlag(String cQuickFlag)
    {
        this.cQuickFlag = cQuickFlag;
    }

    public String getcQuickFlag()
    {
        return cQuickFlag;
    }
    public void setcInsrnctmsyncFlag(String cInsrnctmsyncFlag)
    {
        this.cInsrnctmsyncFlag = cInsrnctmsyncFlag;
    }

    public String getcInsrnctmsyncFlag()
    {
        return cInsrnctmsyncFlag;
    }
    public void settVehicleLayoffBgnTm(Date tVehicleLayoffBgnTm)
    {
        this.tVehicleLayoffBgnTm = tVehicleLayoffBgnTm;
    }

    public Date gettVehicleLayoffBgnTm()
    {
        return tVehicleLayoffBgnTm;
    }
    public void settVehicleLayoffEndTm(Date tVehicleLayoffEndTm)
    {
        this.tVehicleLayoffEndTm = tVehicleLayoffEndTm;
    }

    public Date gettVehicleLayoffEndTm()
    {
        return tVehicleLayoffEndTm;
    }
    public void settExtendedBgnTm(Date tExtendedBgnTm)
    {
        this.tExtendedBgnTm = tExtendedBgnTm;
    }

    public Date gettExtendedBgnTm()
    {
        return tExtendedBgnTm;
    }
    public void settExtendedEndTm(Date tExtendedEndTm)
    {
        this.tExtendedEndTm = tExtendedEndTm;
    }

    public Date gettExtendedEndTm()
    {
        return tExtendedEndTm;
    }
    public void settVehicleResumptionTm(Date tVehicleResumptionTm)
    {
        this.tVehicleResumptionTm = tVehicleResumptionTm;
    }

    public Date gettVehicleResumptionTm()
    {
        return tVehicleResumptionTm;
    }
    public void setnLayoffDays(Long nLayoffDays)
    {
        this.nLayoffDays = nLayoffDays;
    }

    public Long getnLayoffDays()
    {
        return nLayoffDays;
    }
    public void setcUnfixSpcBackUp(String cUnfixSpcBackUp)
    {
        this.cUnfixSpcBackUp = cUnfixSpcBackUp;
    }

    public String getcUnfixSpcBackUp()
    {
        return cUnfixSpcBackUp;
    }
    public void setcApId(String cApId)
    {
        this.cApId = cApId;
    }

    public String getcApId()
    {
        return cApId;
    }
    public void setcPkgBusFlg(String cPkgBusFlg)
    {
        this.cPkgBusFlg = cPkgBusFlg;
    }

    public String getcPkgBusFlg()
    {
        return cPkgBusFlg;
    }
    public void setcApUseFlg(String cApUseFlg)
    {
        this.cApUseFlg = cApUseFlg;
    }

    public String getcApUseFlg()
    {
        return cApUseFlg;
    }
    public void setcRiCont(String cRiCont)
    {
        this.cRiCont = cRiCont;
    }

    public String getcRiCont()
    {
        return cRiCont;
    }
    public void setcIssueSrc(String cIssueSrc)
    {
        this.cIssueSrc = cIssueSrc;
    }

    public String getcIssueSrc()
    {
        return cIssueSrc;
    }
    public void setcIssueCode(String cIssueCode)
    {
        this.cIssueCode = cIssueCode;
    }

    public String getcIssueCode()
    {
        return cIssueCode;
    }
    public void setcMachineCode(String cMachineCode)
    {
        this.cMachineCode = cMachineCode;
    }

    public String getcMachineCode()
    {
        return cMachineCode;
    }
    public void setcComputerIp(String cComputerIp)
    {
        this.cComputerIp = cComputerIp;
    }

    public String getcComputerIp()
    {
        return cComputerIp;
    }
    public void setcCounty(String cCounty)
    {
        this.cCounty = cCounty;
    }

    public String getcCounty()
    {
        return cCounty;
    }
    public void setcAppointAreaCode(String cAppointAreaCode)
    {
        this.cAppointAreaCode = cAppointAreaCode;
    }

    public String getcAppointAreaCode()
    {
        return cAppointAreaCode;
    }
    public void setcIsFullEndor(String cIsFullEndor)
    {
        this.cIsFullEndor = cIsFullEndor;
    }

    public String getcIsFullEndor()
    {
        return cIsFullEndor;
    }
    public void setcItemSystem(String cItemSystem)
    {
        this.cItemSystem = cItemSystem;
    }

    public String getcItemSystem()
    {
        return cItemSystem;
    }
    public void settEdrCancelReasonTm(Date tEdrCancelReasonTm)
    {
        this.tEdrCancelReasonTm = tEdrCancelReasonTm;
    }

    public Date gettEdrCancelReasonTm()
    {
        return tEdrCancelReasonTm;
    }
    public void setcBusinessSrc(String cBusinessSrc)
    {
        this.cBusinessSrc = cBusinessSrc;
    }

    public String getcBusinessSrc()
    {
        return cBusinessSrc;
    }
    public void setcIssueMode(String cIssueMode)
    {
        this.cIssueMode = cIssueMode;
    }

    public String getcIssueMode()
    {
        return cIssueMode;
    }
    public void setcIsElecPlyFlag(String cIsElecPlyFlag)
    {
        this.cIsElecPlyFlag = cIsElecPlyFlag;
    }

    public String getcIsElecPlyFlag()
    {
        return cIsElecPlyFlag;
    }
    public void setcCiProFeePrinc(String cCiProFeePrinc)
    {
        this.cCiProFeePrinc = cCiProFeePrinc;
    }

    public String getcCiProFeePrinc()
    {
        return cCiProFeePrinc;
    }
    public void setcBusiChannel(String cBusiChannel)
    {
        this.cBusiChannel = cBusiChannel;
    }

    public String getcBusiChannel()
    {
        return cBusiChannel;
    }
    public void setcBusiType(String cBusiType)
    {
        this.cBusiType = cBusiType;
    }

    public String getcBusiType()
    {
        return cBusiType;
    }
    public void setcServeProvince(String cServeProvince)
    {
        this.cServeProvince = cServeProvince;
    }

    public String getcServeProvince()
    {
        return cServeProvince;
    }
    public void setcServeCity(String cServeCity)
    {
        this.cServeCity = cServeCity;
    }

    public String getcServeCity()
    {
        return cServeCity;
    }
    public void setcJointMrk(String cJointMrk)
    {
        this.cJointMrk = cJointMrk;
    }

    public String getcJointMrk()
    {
        return cJointMrk;
    }
    public void setcCpriFacMrk(String cCpriFacMrk)
    {
        this.cCpriFacMrk = cCpriFacMrk;
    }

    public String getcCpriFacMrk()
    {
        return cCpriFacMrk;
    }
    public void setcAgrNme(String cAgrNme)
    {
        this.cAgrNme = cAgrNme;
    }

    public String getcAgrNme()
    {
        return cAgrNme;
    }
    public void setcOcAgrNo(String cOcAgrNo)
    {
        this.cOcAgrNo = cOcAgrNo;
    }

    public String getcOcAgrNo()
    {
        return cOcAgrNo;
    }
    public void setcSalesmanName(String cSalesmanName)
    {
        this.cSalesmanName = cSalesmanName;
    }

    public String getcSalesmanName()
    {
        return cSalesmanName;
    }
    public void setcCertSalesmanNum(String cCertSalesmanNum)
    {
        this.cCertSalesmanNum = cCertSalesmanNum;
    }

    public String getcCertSalesmanNum()
    {
        return cCertSalesmanNum;
    }
    public void setcCertificateName(String cCertificateName)
    {
        this.cCertificateName = cCertificateName;
    }

    public String getcCertificateName()
    {
        return cCertificateName;
    }
    public void setcCertificatePhone(String cCertificatePhone)
    {
        this.cCertificatePhone = cCertificatePhone;
    }

    public String getcCertificatePhone()
    {
        return cCertificatePhone;
    }
    public void setcSourceOfBusinessResources(String cSourceOfBusinessResources)
    {
        this.cSourceOfBusinessResources = cSourceOfBusinessResources;
    }

    public String getcSourceOfBusinessResources()
    {
        return cSourceOfBusinessResources;
    }
    public void setcUseOfProceeds(String cUseOfProceeds)
    {
        this.cUseOfProceeds = cUseOfProceeds;
    }

    public String getcUseOfProceeds()
    {
        return cUseOfProceeds;
    }
    public void setcRecoverStatus(String cRecoverStatus)
    {
        this.cRecoverStatus = cRecoverStatus;
    }

    public String getcRecoverStatus()
    {
        return cRecoverStatus;
    }
    public void setnRecoverAmt(Long nRecoverAmt)
    {
        this.nRecoverAmt = nRecoverAmt;
    }

    public Long getnRecoverAmt()
    {
        return nRecoverAmt;
    }
    public void setcFinPhoneTyp(String cFinPhoneTyp)
    {
        this.cFinPhoneTyp = cFinPhoneTyp;
    }

    public String getcFinPhoneTyp()
    {
        return cFinPhoneTyp;
    }
    public void setcBelongCdptcde(String cBelongCdptcde)
    {
        this.cBelongCdptcde = cBelongCdptcde;
    }

    public String getcBelongCdptcde()
    {
        return cBelongCdptcde;
    }
    public void setnExpectDisc(Long nExpectDisc)
    {
        this.nExpectDisc = nExpectDisc;
    }

    public Long getnExpectDisc()
    {
        return nExpectDisc;
    }
    public void setcCoding(String cCoding)
    {
        this.cCoding = cCoding;
    }

    public String getcCoding()
    {
        return cCoding;
    }
    public void setcSpecialCde(String cSpecialCde)
    {
        this.cSpecialCde = cSpecialCde;
    }

    public String getcSpecialCde()
    {
        return cSpecialCde;
    }
    public void setcActBusiChannel(String cActBusiChannel)
    {
        this.cActBusiChannel = cActBusiChannel;
    }

    public String getcActBusiChannel()
    {
        return cActBusiChannel;
    }
    public void setcConsRiskCde(String cConsRiskCde)
    {
        this.cConsRiskCde = cConsRiskCde;
    }

    public String getcConsRiskCde()
    {
        return cConsRiskCde;
    }
    public void setcUwDptCde(String cUwDptCde)
    {
        this.cUwDptCde = cUwDptCde;
    }

    public String getcUwDptCde()
    {
        return cUwDptCde;
    }
    public void setcAppauthCde(String cAppauthCde)
    {
        this.cAppauthCde = cAppauthCde;
    }

    public String getcAppauthCde()
    {
        return cAppauthCde;
    }
    public void setcUnfixSpcNo(String cUnfixSpcNo)
    {
        this.cUnfixSpcNo = cUnfixSpcNo;
    }

    public String getcUnfixSpcNo()
    {
        return cUnfixSpcNo;
    }
    public void setcChannelName(String cChannelName)
    {
        this.cChannelName = cChannelName;
    }

    public String getcChannelName()
    {
        return cChannelName;
    }
    public void setcReferrerName(String cReferrerName)
    {
        this.cReferrerName = cReferrerName;
    }

    public String getcReferrerName()
    {
        return cReferrerName;
    }
    public void setcRealNameConfirm(String cRealNameConfirm)
    {
        this.cRealNameConfirm = cRealNameConfirm;
    }

    public String getcRealNameConfirm()
    {
        return cRealNameConfirm;
    }
    public void setcApplicantNo(String cApplicantNo)
    {
        this.cApplicantNo = cApplicantNo;
    }

    public String getcApplicantNo()
    {
        return cApplicantNo;
    }
    public void setcInformNo(String cInformNo)
    {
        this.cInformNo = cInformNo;
    }

    public String getcInformNo()
    {
        return cInformNo;
    }
    public void setcPublicityNo(String cPublicityNo)
    {
        this.cPublicityNo = cPublicityNo;
    }

    public String getcPublicityNo()
    {
        return cPublicityNo;
    }
    public void setcBillNo(String cBillNo)
    {
        this.cBillNo = cBillNo;
    }

    public String getcBillNo()
    {
        return cBillNo;
    }
    public void setcIssueSrcWx(String cIssueSrcWx)
    {
        this.cIssueSrcWx = cIssueSrcWx;
    }

    public String getcIssueSrcWx()
    {
        return cIssueSrcWx;
    }
    public void setcEtDownlink(String cEtDownlink)
    {
        this.cEtDownlink = cEtDownlink;
    }

    public String getcEtDownlink()
    {
        return cEtDownlink;
    }
    public void settEtSendTm(Date tEtSendTm)
    {
        this.tEtSendTm = tEtSendTm;
    }

    public Date gettEtSendTm()
    {
        return tEtSendTm;
    }
    public void setcSpCust(String cSpCust)
    {
        this.cSpCust = cSpCust;
    }

    public String getcSpCust()
    {
        return cSpCust;
    }
    public void setcSpCustClass(String cSpCustClass)
    {
        this.cSpCustClass = cSpCustClass;
    }

    public String getcSpCustClass()
    {
        return cSpCustClass;
    }
    public void setcBusinessOwner(String cBusinessOwner)
    {
        this.cBusinessOwner = cBusinessOwner;
    }

    public String getcBusinessOwner()
    {
        return cBusinessOwner;
    }
    public void setcEcProdName(String cEcProdName)
    {
        this.cEcProdName = cEcProdName;
    }

    public String getcEcProdName()
    {
        return cEcProdName;
    }
    public void setcEcProdPlan(String cEcProdPlan)
    {
        this.cEcProdPlan = cEcProdPlan;
    }

    public String getcEcProdPlan()
    {
        return cEcProdPlan;
    }
    public void setcEcProdplanVersion(String cEcProdplanVersion)
    {
        this.cEcProdplanVersion = cEcProdplanVersion;
    }

    public String getcEcProdplanVersion()
    {
        return cEcProdplanVersion;
    }
    public void setcAnonymousMark(String cAnonymousMark)
    {
        this.cAnonymousMark = cAnonymousMark;
    }

    public String getcAnonymousMark()
    {
        return cAnonymousMark;
    }
    public void setcFinancingMark(String cFinancingMark)
    {
        this.cFinancingMark = cFinancingMark;
    }

    public String getcFinancingMark()
    {
        return cFinancingMark;
    }
    public void setcIsGovernment(String cIsGovernment)
    {
        this.cIsGovernment = cIsGovernment;
    }

    public String getcIsGovernment()
    {
        return cIsGovernment;
    }
    public void setcNoSeemoneyMrk(String cNoSeemoneyMrk)
    {
        this.cNoSeemoneyMrk = cNoSeemoneyMrk;
    }

    public String getcNoSeemoneyMrk()
    {
        return cNoSeemoneyMrk;
    }
    public void setcAgroStandardSign(String cAgroStandardSign)
    {
        this.cAgroStandardSign = cAgroStandardSign;
    }

    public String getcAgroStandardSign()
    {
        return cAgroStandardSign;
    }
    public void setcAgroPublicitySign(String cAgroPublicitySign)
    {
        this.cAgroPublicitySign = cAgroPublicitySign;
    }

    public String getcAgroPublicitySign()
    {
        return cAgroPublicitySign;
    }
    public void setcPaidFlag(String cPaidFlag)
    {
        this.cPaidFlag = cPaidFlag;
    }

    public String getcPaidFlag()
    {
        return cPaidFlag;
    }
    public void setcReStartDate(Date cReStartDate)
    {
        this.cReStartDate = cReStartDate;
    }

    public Date getcReStartDate()
    {
        return cReStartDate;
    }
    public void setcReEndDate(Date cReEndDate)
    {
        this.cReEndDate = cReEndDate;
    }

    public Date getcReEndDate()
    {
        return cReEndDate;
    }
    public void setcResvTxt9(String cResvTxt9)
    {
        this.cResvTxt9 = cResvTxt9;
    }

    public String getcResvTxt9()
    {
        return cResvTxt9;
    }
    public void setcResvTxt12(String cResvTxt12)
    {
        this.cResvTxt12 = cResvTxt12;
    }

    public String getcResvTxt12()
    {
        return cResvTxt12;
    }
    public void setcBusinessInterruption(String cBusinessInterruption)
    {
        this.cBusinessInterruption = cBusinessInterruption;
    }

    public String getcBusinessInterruption()
    {
        return cBusinessInterruption;
    }
    public void setcOverseasBusiness(String cOverseasBusiness)
    {
        this.cOverseasBusiness = cOverseasBusiness;
    }

    public String getcOverseasBusiness()
    {
        return cOverseasBusiness;
    }
    public void setcDiseaseType(String cDiseaseType)
    {
        this.cDiseaseType = cDiseaseType;
    }

    public String getcDiseaseType()
    {
        return cDiseaseType;
    }
    public void setcTsApId(String cTsApId)
    {
        this.cTsApId = cTsApId;
    }

    public String getcTsApId()
    {
        return cTsApId;
    }
    public void setcIsGovCooperation(String cIsGovCooperation)
    {
        this.cIsGovCooperation = cIsGovCooperation;
    }

    public String getcIsGovCooperation()
    {
        return cIsGovCooperation;
    }
    public void setnSpecialExpectDisc(Long nSpecialExpectDisc)
    {
        this.nSpecialExpectDisc = nSpecialExpectDisc;
    }

    public Long getnSpecialExpectDisc()
    {
        return nSpecialExpectDisc;
    }
    public void setcInsPayDate(Date cInsPayDate)
    {
        this.cInsPayDate = cInsPayDate;
    }

    public Date getcInsPayDate()
    {
        return cInsPayDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("cAppNo", getcAppNo())
                .append("cAppTyp", getcAppTyp())
                .append("cPlyNo", getcPlyNo())
                .append("nEdrPrjNo", getnEdrPrjNo())
                .append("cRelPlyNo", getcRelPlyNo())
                .append("cProdNo", getcProdNo())
                .append("cDptCde", getcDptCde())
                .append("cSlsCde", getcSlsCde())
                .append("cBsnsTyp", getcBsnsTyp())
                .append("cBsnsSubtyp", getcBsnsSubtyp())
                .append("cBrkrCde", getcBrkrCde())
                .append("cAgtAgrNo", getcAgtAgrNo())
                .append("nSubCoNo", getnSubCoNo())
                .append("cOcPlyNo", getcOcPlyNo())
                .append("nDiscRate", getnDiscRate())
                .append("nRate", getnRate())
                .append("nCommRate", getnCommRate())
                .append("cRenewMrk", getcRenewMrk())
                .append("cOrigPlyNo", getcOrigPlyNo())
                .append("cOrigInsurer", getcOrigInsurer())
                .append("cAmtCur", getcAmtCur())
                .append("nAmt", getnAmt())
                .append("nAmtRmbExch", getnAmtRmbExch())
                .append("cPrmCur", getcPrmCur())
                .append("nCalcPrm", getnCalcPrm())
                .append("nPrm", getnPrm())
                .append("nPrmRmbExch", getnPrmRmbExch())
                .append("nIndemLmt", getnIndemLmt())
                .append("cRatioTyp", getcRatioTyp())
                .append("nRatioCoef", getnRatioCoef())
                .append("nSavingAmt", getnSavingAmt())
                .append("cPlySts", getcPlySts())
                .append("tTermnTm", gettTermnTm())
                .append("cInwdMrk", getcInwdMrk())
                .append("cCiMrk", getcCiMrk())
                .append("cCiTyp", getcCiTyp())
                .append("nCiJntAmt", getnCiJntAmt())
                .append("nCiJntPrm", getnCiJntPrm())
                .append("cLongTermMrk", getcLongTermMrk())
                .append("tAppTm", gettAppTm())
                .append("cOprTyp", getcOprTyp())
                .append("cPrnNo", getcPrnNo())
                .append("tInsrncBgnTm", gettInsrncBgnTm())
                .append("tInsrncEndTm", gettInsrncEndTm())
                .append("cTmSysCde", getcTmSysCde())
                .append("cUnfixSpc", getcUnfixSpc())
                .append("cMultInsrntMrk", getcMultInsrntMrk())
                .append("cGrpMrk", getcGrpMrk())
                .append("cListorcolMrk", getcListorcolMrk())
                .append("cMasterMrk", getcMasterMrk())
                .append("cBidMrk", getcBidMrk())
                .append("cPkgMrk", getcPkgMrk())
                .append("cPkgNo", getcPkgNo())
                .append("nPrmDisc", getnPrmDisc())
                .append("cRegMrk", getcRegMrk())
                .append("cDecMrk", getcDecMrk())
                .append("cJuriCde", getcJuriCde())
                .append("cAgriMrk", getcAgriMrk())
                .append("cForeignMrk", getcForeignMrk())
                .append("cImporexpMrk", getcImporexpMrk())
                .append("cManualMrk", getcManualMrk())
                .append("cInstMrk", getcInstMrk())
                .append("cVipMrk", getcVipMrk())
                .append("cOpenCoverNo", getcOpenCoverNo())
                .append("cDisptSttlCde", getcDisptSttlCde())
                .append("cDisptSttlOrg", getcDisptSttlOrg())
                .append("cOprCde", getcOprCde())
                .append("tOprTm", gettOprTm())
                .append("cChkCde", getcChkCde())
                .append("tIssueTm", gettIssueTm())
                .append("tUdrTm", gettUdrTm())
                .append("cUdrDptCde", getcUdrDptCde())
                .append("cUdrCde", getcUdrCde())
                .append("cUdrMrk", getcUdrMrk())
                .append("cRiFacMrk", getcRiFacMrk())
                .append("cRiChkCde", getcRiChkCde())
                .append("cRiMrk", getcRiMrk())
                .append("tNextEdrBgnTm", gettNextEdrBgnTm())
                .append("tNextEdrEndTm", gettNextEdrEndTm())
                .append("tNextEdrUdrTm", gettNextEdrUdrTm())
                .append("cRemark", getcRemark())
                .append("cAppStatus", getcAppStatus())
                .append("tEdrAppTm", gettEdrAppTm())
                .append("tEdrBgnTm", gettEdrBgnTm())
                .append("tEdrEndTm", gettEdrEndTm())
                .append("cEdrMrk", getcEdrMrk())
                .append("cEdrType", getcEdrType())
                .append("cEdrRsnBundleCde", getcEdrRsnBundleCde())
                .append("nBefEdrPrjNo", getnBefEdrPrjNo())
                .append("nBefEdrAmt", getnBefEdrAmt())
                .append("nBefEdrPrm", getnBefEdrPrm())
                .append("nAmtVar", getnAmtVar())
                .append("nCalcPrmVar", getnCalcPrmVar())
                .append("nPrmVar", getnPrmVar())
                .append("nIndemLmtVar", getnIndemLmtVar())
                .append("cAppPrsnCde", getcAppPrsnCde())
                .append("cAppPrsnNme", getcAppPrsnNme())
                .append("cEdrCtnt", getcEdrCtnt())
                .append("cResvTxt1", getcResvTxt1())
                .append("cResvTxt2", getcResvTxt2())
                .append("cResvTxt3", getcResvTxt3())
                .append("cResvTxt4", getcResvTxt4())
                .append("cCrtCde", getcCrtCde())
                .append("tCrtTm", gettCrtTm())
                .append("cUpdCde", getcUpdCde())
                .append("tUpdTm", gettUpdTm())
                .append("nOrigTimes", getnOrigTimes())
                .append("cFinTyp", getcFinTyp())
                .append("nMaxFeeProp", getnMaxFeeProp())
                .append("cVipCus", getcVipCus())
                .append("cGrantDptCde", getcGrantDptCde())
                .append("cDptAttr", getcDptAttr())
                .append("cSalegrpCde", getcSalegrpCde())
                .append("cSlsId", getcSlsId())
                .append("cSlsTel", getcSlsTel())
                .append("cSlsNme", getcSlsNme())
                .append("cMinUndrDpt", getcMinUndrDpt())
                .append("cMinUndrCls", getcMinUndrCls())
                .append("cFeeCalTyp", getcFeeCalTyp())
                .append("cRateNo", getcRateNo())
                .append("cSaveMrk", getcSaveMrk())
                .append("nBefEdrSaving", getnBefEdrSaving())
                .append("nSavingVar", getnSavingVar())
                .append("cTransMrk", getcTransMrk())
                .append("tTransTm", gettTransTm())
                .append("cCommonFlag", getcCommonFlag())
                .append("cImmeffMrk", getcImmeffMrk())
                .append("cDataSrc", getcDataSrc())
                .append("cTrdCde", getcTrdCde())
                .append("cJointNo", getcJointNo())
                .append("cResvTxt5", getcResvTxt5())
                .append("cDductDesc", getcDductDesc())
                .append("nDductRate", getnDductRate())
                .append("nDductAmt", getnDductAmt())
                .append("cJqxPlyNo", getcJqxPlyNo())
                .append("cResvTxt6", getcResvTxt6())
                .append("cResvTxt7", getcResvTxt7())
                .append("cResvTxt8", getcResvTxt8())
                .append("tResvTm1", gettResvTm1())
                .append("cRiFacOpn", getcRiFacOpn())
                .append("nCiOwnAmt", getnCiOwnAmt())
                .append("nCiOwnPrm", getnCiOwnPrm())
                .append("cDueCur", getcDueCur())
                .append("cProvince", getcProvince())
                .append("cCity", getcCity())
                .append("cZjZfhzMark", getcZjZfhzMark())
                .append("comRateUpper", getComRateUpper())
                .append("cCompanyRateUpper", getcCompanyRateUpper())
                .append("cLastYearCorp", getcLastYearCorp())
                .append("tLastInsbgnTm", gettLastInsbgnTm())
                .append("cAutouwMrk", getcAutouwMrk())
                .append("cPrdInsplan", getcPrdInsplan())
                .append("cBatchNo", getcBatchNo())
                .append("cQuerySequenceNo", getcQuerySequenceNo())
                .append("tQueryPastDate", gettQueryPastDate())
                .append("cConfirmSequenceNo", getcConfirmSequenceNo())
                .append("nPlyCount", getnPlyCount())
                .append("cCardNo", getcCardNo())
                .append("cZxType", getcZxType())
                .append("cRescueFlg", getcRescueFlg())
                .append("cContFlg", getcContFlg())
                .append("cYwzdNo", getcYwzdNo())
                .append("cQuickFlag", getcQuickFlag())
                .append("cInsrnctmsyncFlag", getcInsrnctmsyncFlag())
                .append("tVehicleLayoffBgnTm", gettVehicleLayoffBgnTm())
                .append("tVehicleLayoffEndTm", gettVehicleLayoffEndTm())
                .append("tExtendedBgnTm", gettExtendedBgnTm())
                .append("tExtendedEndTm", gettExtendedEndTm())
                .append("tVehicleResumptionTm", gettVehicleResumptionTm())
                .append("nLayoffDays", getnLayoffDays())
                .append("cUnfixSpcBackUp", getcUnfixSpcBackUp())
                .append("cApId", getcApId())
                .append("cPkgBusFlg", getcPkgBusFlg())
                .append("cApUseFlg", getcApUseFlg())
                .append("cRiCont", getcRiCont())
                .append("cIssueSrc", getcIssueSrc())
                .append("cIssueCode", getcIssueCode())
                .append("cMachineCode", getcMachineCode())
                .append("cComputerIp", getcComputerIp())
                .append("cCounty", getcCounty())
                .append("cAppointAreaCode", getcAppointAreaCode())
                .append("cIsFullEndor", getcIsFullEndor())
                .append("cItemSystem", getcItemSystem())
                .append("tEdrCancelReasonTm", gettEdrCancelReasonTm())
                .append("cBusinessSrc", getcBusinessSrc())
                .append("cIssueMode", getcIssueMode())
                .append("cIsElecPlyFlag", getcIsElecPlyFlag())
                .append("cCiProFeePrinc", getcCiProFeePrinc())
                .append("cBusiChannel", getcBusiChannel())
                .append("cBusiType", getcBusiType())
                .append("cServeProvince", getcServeProvince())
                .append("cServeCity", getcServeCity())
                .append("cJointMrk", getcJointMrk())
                .append("cCpriFacMrk", getcCpriFacMrk())
                .append("cAgrNme", getcAgrNme())
                .append("cOcAgrNo", getcOcAgrNo())
                .append("cSalesmanName", getcSalesmanName())
                .append("cCertSalesmanNum", getcCertSalesmanNum())
                .append("cCertificateName", getcCertificateName())
                .append("cCertificatePhone", getcCertificatePhone())
                .append("cSourceOfBusinessResources", getcSourceOfBusinessResources())
                .append("cUseOfProceeds", getcUseOfProceeds())
                .append("cRecoverStatus", getcRecoverStatus())
                .append("nRecoverAmt", getnRecoverAmt())
                .append("cFinPhoneTyp", getcFinPhoneTyp())
                .append("cBelongCdptcde", getcBelongCdptcde())
                .append("nExpectDisc", getnExpectDisc())
                .append("cCoding", getcCoding())
                .append("cSpecialCde", getcSpecialCde())
                .append("cActBusiChannel", getcActBusiChannel())
                .append("cConsRiskCde", getcConsRiskCde())
                .append("cUwDptCde", getcUwDptCde())
                .append("cAppauthCde", getcAppauthCde())
                .append("cUnfixSpcNo", getcUnfixSpcNo())
                .append("cChannelName", getcChannelName())
                .append("cReferrerName", getcReferrerName())
                .append("cRealNameConfirm", getcRealNameConfirm())
                .append("cApplicantNo", getcApplicantNo())
                .append("cInformNo", getcInformNo())
                .append("cPublicityNo", getcPublicityNo())
                .append("cBillNo", getcBillNo())
                .append("cIssueSrcWx", getcIssueSrcWx())
                .append("cEtDownlink", getcEtDownlink())
                .append("tEtSendTm", gettEtSendTm())
                .append("cSpCust", getcSpCust())
                .append("cSpCustClass", getcSpCustClass())
                .append("cBusinessOwner", getcBusinessOwner())
                .append("cEcProdName", getcEcProdName())
                .append("cEcProdPlan", getcEcProdPlan())
                .append("cEcProdplanVersion", getcEcProdplanVersion())
                .append("cAnonymousMark", getcAnonymousMark())
                .append("cFinancingMark", getcFinancingMark())
                .append("cIsGovernment", getcIsGovernment())
                .append("cNoSeemoneyMrk", getcNoSeemoneyMrk())
                .append("cAgroStandardSign", getcAgroStandardSign())
                .append("cAgroPublicitySign", getcAgroPublicitySign())
                .append("cPaidFlag", getcPaidFlag())
                .append("cReStartDate", getcReStartDate())
                .append("cReEndDate", getcReEndDate())
                .append("cResvTxt9", getcResvTxt9())
                .append("cResvTxt12", getcResvTxt12())
                .append("cBusinessInterruption", getcBusinessInterruption())
                .append("cOverseasBusiness", getcOverseasBusiness())
                .append("cDiseaseType", getcDiseaseType())
                .append("cTsApId", getcTsApId())
                .append("cIsGovCooperation", getcIsGovCooperation())
                .append("nSpecialExpectDisc", getnSpecialExpectDisc())
                .append("cInsPayDate", getcInsPayDate())
                .toString();
    }
}
