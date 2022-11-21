package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;
import com.tsvhlpom.compare.utils.AnjiDescription;

/**
 * 申请单车险标的信息对象 web_app_vhl
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppVhl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批改申请单号 */
    private String cAppNo;

    /** 行驶证车主 Vehicle Registration Owner */
    @Excel(name = "行驶证车主 Vehicle Registration Owner")
    @AnjiDescription("cRegOwner")
    private String cRegOwner;

    /** 是否按揭车 Mortgate Flag */
    @Excel(name = "是否按揭车 Mortgate Flag")
    @AnjiDescription("cMortgageMrk")
    private String cMortgageMrk;

    /** 产地 Producing Place */
    @Excel(name = "产地 Producing Place")
    @AnjiDescription("cProdPlace")
    private String cProdPlace;

    /** 车牌号码 Plate Number */
    @Excel(name = "车牌号码 Plate Number")
    @AnjiDescription("cPlateNo")
    private String cPlateNo;

    /** 车牌颜色 Plate Color */
    @Excel(name = "车牌颜色 Plate Color")
    @AnjiDescription("cPlateColor")
    private String cPlateColor;

    /** 车辆颜色 Body Color */
    @Excel(name = "车辆颜色 Body Color")
    @AnjiDescription("cBodyColor")
    private String cBodyColor;

    /** 发动机号码 Engine No */
    @Excel(name = "发动机号码 Engine No")
    @AnjiDescription("cEngNo")
    private String cEngNo;

    /** 车架号 Frame No */
    @Excel(name = "车架号 Frame No")
    @AnjiDescription("cFrmNo")
    private String cFrmNo;

    /** VIN码 VIN */
    @Excel(name = "VIN码 VIN")
    @AnjiDescription("cVin")
    private String cVin;

    /** 厂牌车型码 Brand and Model Code */
    @Excel(name = "厂牌车型码 Brand and Model Code")
    @AnjiDescription("cModelCde")
    private String cModelCde;

    /** 厂牌车型名称 Brand and Model Name */
    @Excel(name = "厂牌车型名称 Brand and Model Name")
    @AnjiDescription("cModelNme")
    private String cModelNme;

    /** 营业性质(O非营业1营业) Business Flag */
    @Excel(name = "营业性质(O非营业1营业) Business Flag")
    @AnjiDescription("cBizMrk")
    private String cBizMrk;

    /** 使用性质 Usage Code */
    @Excel(name = "使用性质 Usage Code")
    @AnjiDescription("cUsageCde")
    private String cUsageCde;

    /** 车辆类型 Vehicle Type */
    @Excel(name = "车辆类型 Vehicle Type")
    @AnjiDescription("cVhlTyp")
    private String cVhlTyp;

    /** 新车购置价 Purchase Value of New Vehicle */
    @Excel(name = "新车购置价 Purchase Value of New Vehicle")
    @AnjiDescription("nNewPurchaseValue")
    private Long nNewPurchaseValue;

    /** 制造年份 Manufactoring Year */
    @Excel(name = "制造年份 Manufactoring Year")
    @AnjiDescription("cMfgYear")
    private String cMfgYear;

    /** 初登年月 Year-Month of First Registration  */
    @Excel(name = "初登年月 Year-Month of First Registration ")
    @AnjiDescription("cFstRegYm")
    private String cFstRegYm;

    /** 座位数 Number of Seats */
    @Excel(name = "座位数 Number of Seats")
    @AnjiDescription("nSeatNum")
    private Long nSeatNum;

    /** 吨位数 Tonage */
    @Excel(name = "吨位数 Tonage")
    @AnjiDescription("nTonage")
    private Long nTonage;

    /** 排气量级别 Displacement Level */
    @Excel(name = "排气量级别 Displacement Level")
    @AnjiDescription("cDisplacementLvl")
    private String cDisplacementLvl;

    /** 排汽量 Displacement Volume */
    @Excel(name = "排汽量 Displacement Volume")
    @AnjiDescription("nDisplacement")
    private Long nDisplacement;

    /** 月折旧率 Monthly depreciation  */
    @Excel(name = "月折旧率 Monthly depreciation ")
    @AnjiDescription("nMonDespRate")
    private Long nMonDespRate;

    /** 车辆实际价值 Actual Value */
    @Excel(name = "车辆实际价值 Actual Value")
    @AnjiDescription("nActualValue")
    private Long nActualValue;

    /** 自负优待 Deductible Preferences Code */
    @Excel(name = "自负优待 Deductible Preferences Code")
    @AnjiDescription("cDductPrefCde")
    private String cDductPrefCde;

    /** 固定停放地点 Fixed Park Code */
    @Excel(name = "固定停放地点 Fixed Park Code")
    @AnjiDescription("cFixedParkCde")
    private String cFixedParkCde;

    /** 行驶区域 Driving Area */
    @Excel(name = "行驶区域 Driving Area")
    @AnjiDescription("cTravelAreaCde")
    private String cTravelAreaCde;

    /** 玻璃类型 Glass Type */
    @Excel(name = "玻璃类型 Glass Type")
    @AnjiDescription("cGlassTyp")
    private String cGlassTyp;

    /** 安全/防盗装置 Safety/Anti-theft Device 1 Flag */
    @Excel(name = "安全/防盗装置 Safety/Anti-theft Device 1 Flag")
    @AnjiDescription("cDevice1Mrk")
    private String cDevice1Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice2Mrk")
    private String cDevice2Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice3Mrk")
    private String cDevice3Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice4Mrk")
    private String cDevice4Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice5Mrk")
    private String cDevice5Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice6Mrk")
    private String cDevice6Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice7Mrk")
    private String cDevice7Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice8Mrk")
    private String cDevice8Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice9Mrk")
    private String cDevice9Mrk;

    /** 装置 */
    @Excel(name = "装置")
    @AnjiDescription("cDevice10Mrk")
    private String cDevice10Mrk;

    /** 验车情况 Inspection Code */
    @Excel(name = "验车情况 Inspection Code")
    @AnjiDescription("cInspectionCde")
    private String cInspectionCde;

    /** 验车时间 Inspect Time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "验车时间 Inspect Time", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("cInspectTm")
    private Date cInspectTm;

    /** 验车人 Inspector's Name */
    @Excel(name = "验车人 Inspector's Name")
    @AnjiDescription("cInspectorNme")
    private String cInspectorNme;

    /** 验车记录 Inspect Record */
    @Excel(name = "验车记录 Inspect Record")
    @AnjiDescription("cInspectRec")
    private String cInspectRec;

    /** 号牌种类 Plate Type */
    @Excel(name = "号牌种类 Plate Type")
    @AnjiDescription("cPlateTyp")
    private String cPlateTyp;

    /** 行业平台查询码 Query Code */
    @Excel(name = "行业平台查询码 Query Code")
    @AnjiDescription("cQryCde")
    private String cQryCde;

    /** 行业平台确认码 Affirm Code */
    @Excel(name = "行业平台确认码 Affirm Code")
    @AnjiDescription("cAffirmCde")
    private String cAffirmCde;

    /** 上年赔款次数 */
    @Excel(name = "上年赔款次数")
    @AnjiDescription("nLastYearClmTms")
    private Long nLastYearClmTms;

    /** 上年无赔优待 */
    @Excel(name = "上年无赔优待")
    @AnjiDescription("nLastYearNcd")
    private Long nLastYearNcd;

    /** 无赔款折扣比例 No claim discount (NCD) Rate */
    @Excel(name = "无赔款折扣比例 No claim discount (NCD) Rate")
    @AnjiDescription("nNcdRate")
    private Long nNcdRate;

    /** 行驶证车辆类型 Registered Vehicle Type */
    @Excel(name = "行驶证车辆类型 Registered Vehicle Type")
    @AnjiDescription("cRegVhlTyp")
    private String cRegVhlTyp;

    /** 外地车标志 Ecdemic Flag */
    @Excel(name = "外地车标志 Ecdemic Flag")
    @AnjiDescription("cEcdemicMrk")
    private String cEcdemicMrk;

    /** 团购合同号 Group-buy Contract No */
    @Excel(name = "团购合同号 Group-buy Contract No")
    @AnjiDescription("cGrpBuyContractNo")
    private String cGrpBuyContractNo;

    /** 特殊申明原因 Special Declaration */
    @Excel(name = "特殊申明原因 Special Declaration")
    @AnjiDescription("cSpecDeclCauseCde")
    private String cSpecDeclCauseCde;

    /** 调查表ID号 Questionaire No */
    @Excel(name = "调查表ID号 Questionaire No")
    @AnjiDescription("cQuestNo")
    private String cQuestNo;

    /** 备注 */
    @Excel(name = "备注")
    @AnjiDescription("cRemark")
    private String cRemark;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** 组织机构验真序号 */
    @Excel(name = "组织机构验真序号")
    @AnjiDescription("cResvTxt4")
    private String cResvTxt4;

    /** 组织机构验真查询码 */
    @Excel(name = "组织机构验真查询码")
    @AnjiDescription("cResvTxt5")
    private String cResvTxt5;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum1")
    private Long nResvNum1;

    /** 预留 */
    @Excel(name = "预留")
    @AnjiDescription("nResvNum2")
    private Long nResvNum2;

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

    /** 创建人员 */
    @Excel(name = "创建人员")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 修改人员 */
    @Excel(name = "修改人员")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 修改日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** 当前车型名称 */
    @Excel(name = "当前车型名称")
    @AnjiDescription("cCurModelNme")
    private String cCurModelNme;

    /** 车龄 */
    @Excel(name = "车龄")
    @AnjiDescription("cUseYear")
    private String cUseYear;

    /** 交强险特殊车标志 */
    @Excel(name = "交强险特殊车标志")
    @AnjiDescription("cTfiSpecialMrk")
    private String cTfiSpecialMrk;

    /** 交强险重复投保标志 */
    @Excel(name = "交强险重复投保标志")
    @AnjiDescription("cTfiReinsureMrk")
    private String cTfiReinsureMrk;

    /** 短期因素 */
    @Excel(name = "短期因素")
    @AnjiDescription("cShortRsn")
    private String cShortRsn;

    /** 牌照类型 */
    @Excel(name = "牌照类型")
    @AnjiDescription("cLicenseTyp")
    private String cLicenseTyp;

    /** 证照类型 */
    @Excel(name = "证照类型")
    @AnjiDescription("cIdcardTyp")
    private String cIdcardTyp;

    /** 转籍时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转籍时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTransferTm")
    private Date tTransferTm;

    /** 原号牌号码 */
    @Excel(name = "原号牌号码")
    @AnjiDescription("cOldLcnNo")
    private String cOldLcnNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cProconfirmNo")
    private String cProconfirmNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSearchCode")
    private String cSearchCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cBrandId")
    private String cBrandId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cNameChoice")
    private String cNameChoice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cAliasId")
    private String cAliasId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cNewMrk")
    private String cNewMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt6")
    private String cResvTxt6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt7")
    private String cResvTxt7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt8")
    private String cResvTxt8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt9")
    private String cResvTxt9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt10")
    private String cResvTxt10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 车型风险标志 */
    @Excel(name = "车型风险标志")
    @AnjiDescription("cRiskFlag")
    private String cRiskFlag;

    /** 使用性质来源 */
    @Excel(name = "使用性质来源")
    @AnjiDescription("cUseTypSrc")
    private String cUseTypSrc;

    /** 过户车辆标志 */
    @Excel(name = "过户车辆标志")
    @AnjiDescription("cChgOwnerFlag")
    private String cChgOwnerFlag;

    /** 是否车贷投保多年标志 */
    @Excel(name = "是否车贷投保多年标志")
    @AnjiDescription("cLoanVehicleFlag")
    private String cLoanVehicleFlag;

    /** 转移登记日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转移登记日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTransferDate")
    private Date tTransferDate;

    /** 机动车状态 */
    @Excel(name = "机动车状态")
    @AnjiDescription("cStatus")
    private String cStatus;

    /** 无赔款优待及上年赔款记录 */
    @Excel(name = "无赔款优待及上年赔款记录")
    @AnjiDescription("cResvTxt11")
    private String cResvTxt11;

    /** 承保数量(不适用家庭自用) */
    @Excel(name = "承保数量(不适用家庭自用)")
    @AnjiDescription("cResvTxt12")
    private String cResvTxt12;

    /** 安全驾驶 */
    @Excel(name = "安全驾驶")
    @AnjiDescription("cResvTxt13")
    private String cResvTxt13;

    /** 经验及预期赔付率 */
    @Excel(name = "经验及预期赔付率")
    @AnjiDescription("cResvTxt14")
    private String cResvTxt14;

    /** 车龄的整数显示 */
    @Excel(name = "车龄的整数显示")
    @AnjiDescription("cResvTxt15")
    private String cResvTxt15;

    /** 被保险人与车辆关系 */
    @Excel(name = "被保险人与车辆关系")
    @AnjiDescription("cVhlRelCde")
    private String cVhlRelCde;

    /** 车价更改浮动比例 */
    @Excel(name = "车价更改浮动比例")
    @AnjiDescription("nResvNum3")
    private Long nResvNum3;

    /** 数值预留4 */
    @Excel(name = "数值预留4")
    @AnjiDescription("nResvNum4")
    private Long nResvNum4;

    /** 组织机构验真序号 */
    @Excel(name = "组织机构验真序号")
    @AnjiDescription("nResvNum5")
    private Long nResvNum5;

    /** 车辆种类 */
    @Excel(name = "车辆种类")
    @AnjiDescription("cVhlcategoryCde")
    private String cVhlcategoryCde;

    /** 原始车辆种类 */
    @Excel(name = "原始车辆种类")
    @AnjiDescription("cOrigVhlcategoryCde")
    private String cOrigVhlcategoryCde;

    /** 原始进口/国产 */
    @Excel(name = "原始进口/国产")
    @AnjiDescription("cOrigProdPlace")
    private String cOrigProdPlace;

    /** 原始厂牌车型 */
    @Excel(name = "原始厂牌车型")
    @AnjiDescription("cOrigModelNme")
    private String cOrigModelNme;

    /** 原始车型代码 */
    @Excel(name = "原始车型代码")
    @AnjiDescription("cOrigModelCde")
    private String cOrigModelCde;

    /** 原始最小座位 */
    @Excel(name = "原始最小座位")
    @AnjiDescription("nOrigSeatMin")
    private Long nOrigSeatMin;

    /** 原始最大座位 */
    @Excel(name = "原始最大座位")
    @AnjiDescription("nOrigSeatMax")
    private Long nOrigSeatMax;

    /** 原始吨位 */
    @Excel(name = "原始吨位")
    @AnjiDescription("nOrigTonage")
    private Long nOrigTonage;

    /** 原始排量/功率 */
    @Excel(name = "原始排量/功率")
    @AnjiDescription("nOrigDisplacement")
    private Long nOrigDisplacement;

    /** 原始新车购置价（统一） */
    @Excel(name = "原始新车购置价", readConverterExp = "统=一")
    @AnjiDescription("nOrigNewPurchaseUnity")
    private Long nOrigNewPurchaseUnity;

    /** 原始新车购置价（本地） */
    @Excel(name = "原始新车购置价", readConverterExp = "本=地")
    @AnjiDescription("nOrigNewPurchaseLocal")
    private Long nOrigNewPurchaseLocal;

    /** 原始最小整备质量 */
    @Excel(name = "原始最小整备质量")
    @AnjiDescription("nOrigQualityMin")
    private Long nOrigQualityMin;

    /** 原始最大整备质量  */
    @Excel(name = "原始最大整备质量 ")
    @AnjiDescription("nOrigQualityMax")
    private Long nOrigQualityMax;

    /** 未验原因--10.26wyq加 */
    @Excel(name = "未验原因--10.26wyq加")
    @AnjiDescription("cResvTxt16")
    private String cResvTxt16;

    /** 经验管理--10.26wyq加 */
    @Excel(name = "经验管理--10.26wyq加")
    @AnjiDescription("cResvTxt17")
    private String cResvTxt17;

    /** 跨省首年投保未出险证明的年数--11.4.1wyq加 */
    @Excel(name = "跨省首年投保未出险证明的年数--11.4.1wyq加")
    @AnjiDescription("cResvTxt18")
    private String cResvTxt18;

    /** 预留--11.4.1wyq加 */
    @Excel(name = "预留--11.4.1wyq加")
    @AnjiDescription("cResvTxt19")
    private String cResvTxt19;

    /** 预留--11.4.1wyq加 */
    @Excel(name = "预留--11.4.1wyq加")
    @AnjiDescription("cResvTxt20")
    private String cResvTxt20;

    /** 转保标志---11.6.27 wyq 加 */
    @Excel(name = "转保标志---11.6.27 wyq 加")
    @AnjiDescription("cRenewalFlag")
    private String cRenewalFlag;

    /** 车辆价格类型 */
    @Excel(name = "车辆价格类型")
    @AnjiDescription("cVhlPriceType")
    private String cVhlPriceType;

    /** 车型名称(搜索用) */
    @Excel(name = "车型名称(搜索用)")
    @AnjiDescription("cModelNmeSearch")
    private String cModelNmeSearch;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cNewVehicleFlag")
    private String cNewVehicleFlag;

    /** 是否打印排量 */
    @Excel(name = "是否打印排量")
    @AnjiDescription("cPrintDisplacement")
    private String cPrintDisplacement;

    /** 高风险车型提示 */
    @Excel(name = "高风险车型提示")
    @AnjiDescription("cHighriskShow")
    private String cHighriskShow;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cReducCarShow")
    private String cReducCarShow;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("familyName")
    private String familyName;

    /** 燃料种类 */
    @Excel(name = "燃料种类")
    @AnjiDescription("cFuelType")
    private String cFuelType;

    /** 车辆来历凭证种类 */
    @Excel(name = "车辆来历凭证种类")
    @AnjiDescription("cCertificateType")
    private String cCertificateType;

    /** 车辆来历凭证编号 */
    @Excel(name = "车辆来历凭证编号")
    @AnjiDescription("cCertificateNo")
    private String cCertificateNo;

    /** 开具车辆来历凭证所载日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开具车辆来历凭证所载日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCertificateDate")
    private Date tCertificateDate;

    /** 单双号标识 */
    @Excel(name = "单双号标识")
    @AnjiDescription("cSOrDFlag")
    private String cSOrDFlag;

    /** 减免保费 */
    @Excel(name = "减免保费")
    @AnjiDescription("nReducePrm")
    private Long nReducePrm;

    /** 减免保费计算公式 */
    @Excel(name = "减免保费计算公式")
    @AnjiDescription("cReduceFormula")
    private String cReduceFormula;

    /** 减免总天数 */
    @Excel(name = "减免总天数")
    @AnjiDescription("nReduceDay")
    private Long nReduceDay;

    /** 新条款 业务分类（风险标识） */
    @Excel(name = "新条款 业务分类", readConverterExp = "风=险标识")
    @AnjiDescription("cBusiClass")
    private String cBusiClass;

    /** 行业车型编码 */
    @Excel(name = "行业车型编码")
    @AnjiDescription("cModelCode")
    private String cModelCode;

    /** 车型识别编码 */
    @Excel(name = "车型识别编码")
    @AnjiDescription("cModelIdCode")
    private String cModelIdCode;

    /** 厂商名称 */
    @Excel(name = "厂商名称")
    @AnjiDescription("cTradeName")
    private String cTradeName;

    /** 厂商编码 */
    @Excel(name = "厂商编码")
    @AnjiDescription("cTradeCode")
    private String cTradeCode;

    /** 品牌名称 */
    @Excel(name = "品牌名称")
    @AnjiDescription("cBrand")
    private String cBrand;

    /** 品牌编码 */
    @Excel(name = "品牌编码")
    @AnjiDescription("cBrandCode")
    private String cBrandCode;

    /** 车系名称 */
    @Excel(name = "车系名称")
    @AnjiDescription("cSeries")
    private String cSeries;

    /** 车系编码 */
    @Excel(name = "车系编码")
    @AnjiDescription("cSeriesCode")
    private String cSeriesCode;

    /** 车款名称 */
    @Excel(name = "车款名称")
    @AnjiDescription("cCarName")
    private String cCarName;

    /** 公告型号 */
    @Excel(name = "公告型号")
    @AnjiDescription("cNoticeType")
    private String cNoticeType;

    /** 配置款型编码 */
    @Excel(name = "配置款型编码")
    @AnjiDescription("cConfigType")
    private String cConfigType;

    /** 类别名称 */
    @Excel(name = "类别名称")
    @AnjiDescription("cCategoryName")
    private String cCategoryName;

    /** 类别编码 */
    @Excel(name = "类别编码")
    @AnjiDescription("cCategoryCode")
    private String cCategoryCode;

    /** 系别名称 */
    @Excel(name = "系别名称")
    @AnjiDescription("cDeptName")
    private String cDeptName;

    /** 系别名称编码 */
    @Excel(name = "系别名称编码")
    @AnjiDescription("cDeptCode")
    private String cDeptCode;

    /** 新条款无培系数 */
    @Excel(name = "新条款无培系数")
    @AnjiDescription("cNcd")
    private String cNcd;

    /** 无赔忧浮动原因 */
    @Excel(name = "无赔忧浮动原因")
    @AnjiDescription("cNcdReason")
    private String cNcdReason;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTrafIrr")
    private Long nTrafIrr;

    /** 连续承保年数 */
    @Excel(name = "连续承保年数")
    @AnjiDescription("nInsureYears")
    private Long nInsureYears;

    /** 连续承保期间出险次数 */
    @Excel(name = "连续承保期间出险次数")
    @AnjiDescription("nClaimTimes")
    private Long nClaimTimes;

    /** 无赔优系数级别 */
    @Excel(name = "无赔优系数级别")
    @AnjiDescription("cClaimAdjustLevel")
    private String cClaimAdjustLevel;

    /** OCR信息采集主键 */
    @Excel(name = "OCR信息采集主键")
    @AnjiDescription("cOcrUuId")
    private String cOcrUuId;

    /** 燃料（能源）种类 */
    @Excel(name = "燃料", readConverterExp = "能=源")
    @AnjiDescription("cModelEneryType")
    private String cModelEneryType;

    /** 纯电续航里程 */
    @Excel(name = "纯电续航里程")
    @AnjiDescription("cPureRange")
    private String cPureRange;

    /** 其他燃料（能源）种类描述 */
    @Excel(name = "其他燃料", readConverterExp = "能=源")
    @AnjiDescription("cOtherEneryTypeDesc")
    private String cOtherEneryTypeDesc;

    /** 打印使用性质 */
    @Excel(name = "打印使用性质")
    @AnjiDescription("cPrintUsagecde")
    private String cPrintUsagecde;

    /** 打印使用性质选中标志 */
    @Excel(name = "打印使用性质选中标志")
    @AnjiDescription("cPrintUsagecdeFlag")
    private String cPrintUsagecdeFlag;

    /** 摩托车功率 */
    @Excel(name = "摩托车功率")
    @AnjiDescription("nEmotoPower")
    private Long nEmotoPower;

    /** 最高设计车速 */
    @Excel(name = "最高设计车速")
    @AnjiDescription("nMaxSpeed")
    private Long nMaxSpeed;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcRegOwner(String cRegOwner)
    {
        this.cRegOwner = cRegOwner;
    }

    public String getcRegOwner()
    {
        return cRegOwner;
    }
    public void setcMortgageMrk(String cMortgageMrk)
    {
        this.cMortgageMrk = cMortgageMrk;
    }

    public String getcMortgageMrk()
    {
        return cMortgageMrk;
    }
    public void setcProdPlace(String cProdPlace)
    {
        this.cProdPlace = cProdPlace;
    }

    public String getcProdPlace()
    {
        return cProdPlace;
    }
    public void setcPlateNo(String cPlateNo)
    {
        this.cPlateNo = cPlateNo;
    }

    public String getcPlateNo()
    {
        return cPlateNo;
    }
    public void setcPlateColor(String cPlateColor)
    {
        this.cPlateColor = cPlateColor;
    }

    public String getcPlateColor()
    {
        return cPlateColor;
    }
    public void setcBodyColor(String cBodyColor)
    {
        this.cBodyColor = cBodyColor;
    }

    public String getcBodyColor()
    {
        return cBodyColor;
    }
    public void setcEngNo(String cEngNo)
    {
        this.cEngNo = cEngNo;
    }

    public String getcEngNo()
    {
        return cEngNo;
    }
    public void setcFrmNo(String cFrmNo)
    {
        this.cFrmNo = cFrmNo;
    }

    public String getcFrmNo()
    {
        return cFrmNo;
    }
    public void setcVin(String cVin)
    {
        this.cVin = cVin;
    }

    public String getcVin()
    {
        return cVin;
    }
    public void setcModelCde(String cModelCde)
    {
        this.cModelCde = cModelCde;
    }

    public String getcModelCde()
    {
        return cModelCde;
    }
    public void setcModelNme(String cModelNme)
    {
        this.cModelNme = cModelNme;
    }

    public String getcModelNme()
    {
        return cModelNme;
    }
    public void setcBizMrk(String cBizMrk)
    {
        this.cBizMrk = cBizMrk;
    }

    public String getcBizMrk()
    {
        return cBizMrk;
    }
    public void setcUsageCde(String cUsageCde)
    {
        this.cUsageCde = cUsageCde;
    }

    public String getcUsageCde()
    {
        return cUsageCde;
    }
    public void setcVhlTyp(String cVhlTyp)
    {
        this.cVhlTyp = cVhlTyp;
    }

    public String getcVhlTyp()
    {
        return cVhlTyp;
    }
    public void setnNewPurchaseValue(Long nNewPurchaseValue)
    {
        this.nNewPurchaseValue = nNewPurchaseValue;
    }

    public Long getnNewPurchaseValue()
    {
        return nNewPurchaseValue;
    }
    public void setcMfgYear(String cMfgYear)
    {
        this.cMfgYear = cMfgYear;
    }

    public String getcMfgYear()
    {
        return cMfgYear;
    }
    public void setcFstRegYm(String cFstRegYm)
    {
        this.cFstRegYm = cFstRegYm;
    }

    public String getcFstRegYm()
    {
        return cFstRegYm;
    }
    public void setnSeatNum(Long nSeatNum)
    {
        this.nSeatNum = nSeatNum;
    }

    public Long getnSeatNum()
    {
        return nSeatNum;
    }
    public void setnTonage(Long nTonage)
    {
        this.nTonage = nTonage;
    }

    public Long getnTonage()
    {
        return nTonage;
    }
    public void setcDisplacementLvl(String cDisplacementLvl)
    {
        this.cDisplacementLvl = cDisplacementLvl;
    }

    public String getcDisplacementLvl()
    {
        return cDisplacementLvl;
    }
    public void setnDisplacement(Long nDisplacement)
    {
        this.nDisplacement = nDisplacement;
    }

    public Long getnDisplacement()
    {
        return nDisplacement;
    }
    public void setnMonDespRate(Long nMonDespRate)
    {
        this.nMonDespRate = nMonDespRate;
    }

    public Long getnMonDespRate()
    {
        return nMonDespRate;
    }
    public void setnActualValue(Long nActualValue)
    {
        this.nActualValue = nActualValue;
    }

    public Long getnActualValue()
    {
        return nActualValue;
    }
    public void setcDductPrefCde(String cDductPrefCde)
    {
        this.cDductPrefCde = cDductPrefCde;
    }

    public String getcDductPrefCde()
    {
        return cDductPrefCde;
    }
    public void setcFixedParkCde(String cFixedParkCde)
    {
        this.cFixedParkCde = cFixedParkCde;
    }

    public String getcFixedParkCde()
    {
        return cFixedParkCde;
    }
    public void setcTravelAreaCde(String cTravelAreaCde)
    {
        this.cTravelAreaCde = cTravelAreaCde;
    }

    public String getcTravelAreaCde()
    {
        return cTravelAreaCde;
    }
    public void setcGlassTyp(String cGlassTyp)
    {
        this.cGlassTyp = cGlassTyp;
    }

    public String getcGlassTyp()
    {
        return cGlassTyp;
    }
    public void setcDevice1Mrk(String cDevice1Mrk)
    {
        this.cDevice1Mrk = cDevice1Mrk;
    }

    public String getcDevice1Mrk()
    {
        return cDevice1Mrk;
    }
    public void setcDevice2Mrk(String cDevice2Mrk)
    {
        this.cDevice2Mrk = cDevice2Mrk;
    }

    public String getcDevice2Mrk()
    {
        return cDevice2Mrk;
    }
    public void setcDevice3Mrk(String cDevice3Mrk)
    {
        this.cDevice3Mrk = cDevice3Mrk;
    }

    public String getcDevice3Mrk()
    {
        return cDevice3Mrk;
    }
    public void setcDevice4Mrk(String cDevice4Mrk)
    {
        this.cDevice4Mrk = cDevice4Mrk;
    }

    public String getcDevice4Mrk()
    {
        return cDevice4Mrk;
    }
    public void setcDevice5Mrk(String cDevice5Mrk)
    {
        this.cDevice5Mrk = cDevice5Mrk;
    }

    public String getcDevice5Mrk()
    {
        return cDevice5Mrk;
    }
    public void setcDevice6Mrk(String cDevice6Mrk)
    {
        this.cDevice6Mrk = cDevice6Mrk;
    }

    public String getcDevice6Mrk()
    {
        return cDevice6Mrk;
    }
    public void setcDevice7Mrk(String cDevice7Mrk)
    {
        this.cDevice7Mrk = cDevice7Mrk;
    }

    public String getcDevice7Mrk()
    {
        return cDevice7Mrk;
    }
    public void setcDevice8Mrk(String cDevice8Mrk)
    {
        this.cDevice8Mrk = cDevice8Mrk;
    }

    public String getcDevice8Mrk()
    {
        return cDevice8Mrk;
    }
    public void setcDevice9Mrk(String cDevice9Mrk)
    {
        this.cDevice9Mrk = cDevice9Mrk;
    }

    public String getcDevice9Mrk()
    {
        return cDevice9Mrk;
    }
    public void setcDevice10Mrk(String cDevice10Mrk)
    {
        this.cDevice10Mrk = cDevice10Mrk;
    }

    public String getcDevice10Mrk()
    {
        return cDevice10Mrk;
    }
    public void setcInspectionCde(String cInspectionCde)
    {
        this.cInspectionCde = cInspectionCde;
    }

    public String getcInspectionCde()
    {
        return cInspectionCde;
    }
    public void setcInspectTm(Date cInspectTm)
    {
        this.cInspectTm = cInspectTm;
    }

    public Date getcInspectTm()
    {
        return cInspectTm;
    }
    public void setcInspectorNme(String cInspectorNme)
    {
        this.cInspectorNme = cInspectorNme;
    }

    public String getcInspectorNme()
    {
        return cInspectorNme;
    }
    public void setcInspectRec(String cInspectRec)
    {
        this.cInspectRec = cInspectRec;
    }

    public String getcInspectRec()
    {
        return cInspectRec;
    }
    public void setcPlateTyp(String cPlateTyp)
    {
        this.cPlateTyp = cPlateTyp;
    }

    public String getcPlateTyp()
    {
        return cPlateTyp;
    }
    public void setcQryCde(String cQryCde)
    {
        this.cQryCde = cQryCde;
    }

    public String getcQryCde()
    {
        return cQryCde;
    }
    public void setcAffirmCde(String cAffirmCde)
    {
        this.cAffirmCde = cAffirmCde;
    }

    public String getcAffirmCde()
    {
        return cAffirmCde;
    }
    public void setnLastYearClmTms(Long nLastYearClmTms)
    {
        this.nLastYearClmTms = nLastYearClmTms;
    }

    public Long getnLastYearClmTms()
    {
        return nLastYearClmTms;
    }
    public void setnLastYearNcd(Long nLastYearNcd)
    {
        this.nLastYearNcd = nLastYearNcd;
    }

    public Long getnLastYearNcd()
    {
        return nLastYearNcd;
    }
    public void setnNcdRate(Long nNcdRate)
    {
        this.nNcdRate = nNcdRate;
    }

    public Long getnNcdRate()
    {
        return nNcdRate;
    }
    public void setcRegVhlTyp(String cRegVhlTyp)
    {
        this.cRegVhlTyp = cRegVhlTyp;
    }

    public String getcRegVhlTyp()
    {
        return cRegVhlTyp;
    }
    public void setcEcdemicMrk(String cEcdemicMrk)
    {
        this.cEcdemicMrk = cEcdemicMrk;
    }

    public String getcEcdemicMrk()
    {
        return cEcdemicMrk;
    }
    public void setcGrpBuyContractNo(String cGrpBuyContractNo)
    {
        this.cGrpBuyContractNo = cGrpBuyContractNo;
    }

    public String getcGrpBuyContractNo()
    {
        return cGrpBuyContractNo;
    }
    public void setcSpecDeclCauseCde(String cSpecDeclCauseCde)
    {
        this.cSpecDeclCauseCde = cSpecDeclCauseCde;
    }

    public String getcSpecDeclCauseCde()
    {
        return cSpecDeclCauseCde;
    }
    public void setcQuestNo(String cQuestNo)
    {
        this.cQuestNo = cQuestNo;
    }

    public String getcQuestNo()
    {
        return cQuestNo;
    }
    public void setcRemark(String cRemark)
    {
        this.cRemark = cRemark;
    }

    public String getcRemark()
    {
        return cRemark;
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
    public void setcCurModelNme(String cCurModelNme)
    {
        this.cCurModelNme = cCurModelNme;
    }

    public String getcCurModelNme()
    {
        return cCurModelNme;
    }
    public void setcUseYear(String cUseYear)
    {
        this.cUseYear = cUseYear;
    }

    public String getcUseYear()
    {
        return cUseYear;
    }
    public void setcTfiSpecialMrk(String cTfiSpecialMrk)
    {
        this.cTfiSpecialMrk = cTfiSpecialMrk;
    }

    public String getcTfiSpecialMrk()
    {
        return cTfiSpecialMrk;
    }
    public void setcTfiReinsureMrk(String cTfiReinsureMrk)
    {
        this.cTfiReinsureMrk = cTfiReinsureMrk;
    }

    public String getcTfiReinsureMrk()
    {
        return cTfiReinsureMrk;
    }
    public void setcShortRsn(String cShortRsn)
    {
        this.cShortRsn = cShortRsn;
    }

    public String getcShortRsn()
    {
        return cShortRsn;
    }
    public void setcLicenseTyp(String cLicenseTyp)
    {
        this.cLicenseTyp = cLicenseTyp;
    }

    public String getcLicenseTyp()
    {
        return cLicenseTyp;
    }
    public void setcIdcardTyp(String cIdcardTyp)
    {
        this.cIdcardTyp = cIdcardTyp;
    }

    public String getcIdcardTyp()
    {
        return cIdcardTyp;
    }
    public void settTransferTm(Date tTransferTm)
    {
        this.tTransferTm = tTransferTm;
    }

    public Date gettTransferTm()
    {
        return tTransferTm;
    }
    public void setcOldLcnNo(String cOldLcnNo)
    {
        this.cOldLcnNo = cOldLcnNo;
    }

    public String getcOldLcnNo()
    {
        return cOldLcnNo;
    }
    public void setcProconfirmNo(String cProconfirmNo)
    {
        this.cProconfirmNo = cProconfirmNo;
    }

    public String getcProconfirmNo()
    {
        return cProconfirmNo;
    }
    public void setcSearchCode(String cSearchCode)
    {
        this.cSearchCode = cSearchCode;
    }

    public String getcSearchCode()
    {
        return cSearchCode;
    }
    public void setcBrandId(String cBrandId)
    {
        this.cBrandId = cBrandId;
    }

    public String getcBrandId()
    {
        return cBrandId;
    }
    public void setcNameChoice(String cNameChoice)
    {
        this.cNameChoice = cNameChoice;
    }

    public String getcNameChoice()
    {
        return cNameChoice;
    }
    public void setcAliasId(String cAliasId)
    {
        this.cAliasId = cAliasId;
    }

    public String getcAliasId()
    {
        return cAliasId;
    }
    public void setcNewMrk(String cNewMrk)
    {
        this.cNewMrk = cNewMrk;
    }

    public String getcNewMrk()
    {
        return cNewMrk;
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
    public void setcRiskFlag(String cRiskFlag)
    {
        this.cRiskFlag = cRiskFlag;
    }

    public String getcRiskFlag()
    {
        return cRiskFlag;
    }
    public void setcUseTypSrc(String cUseTypSrc)
    {
        this.cUseTypSrc = cUseTypSrc;
    }

    public String getcUseTypSrc()
    {
        return cUseTypSrc;
    }
    public void setcChgOwnerFlag(String cChgOwnerFlag)
    {
        this.cChgOwnerFlag = cChgOwnerFlag;
    }

    public String getcChgOwnerFlag()
    {
        return cChgOwnerFlag;
    }
    public void setcLoanVehicleFlag(String cLoanVehicleFlag)
    {
        this.cLoanVehicleFlag = cLoanVehicleFlag;
    }

    public String getcLoanVehicleFlag()
    {
        return cLoanVehicleFlag;
    }
    public void settTransferDate(Date tTransferDate)
    {
        this.tTransferDate = tTransferDate;
    }

    public Date gettTransferDate()
    {
        return tTransferDate;
    }
    public void setcStatus(String cStatus)
    {
        this.cStatus = cStatus;
    }

    public String getcStatus()
    {
        return cStatus;
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
    public void setcVhlRelCde(String cVhlRelCde)
    {
        this.cVhlRelCde = cVhlRelCde;
    }

    public String getcVhlRelCde()
    {
        return cVhlRelCde;
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
    public void setcVhlcategoryCde(String cVhlcategoryCde)
    {
        this.cVhlcategoryCde = cVhlcategoryCde;
    }

    public String getcVhlcategoryCde()
    {
        return cVhlcategoryCde;
    }
    public void setcOrigVhlcategoryCde(String cOrigVhlcategoryCde)
    {
        this.cOrigVhlcategoryCde = cOrigVhlcategoryCde;
    }

    public String getcOrigVhlcategoryCde()
    {
        return cOrigVhlcategoryCde;
    }
    public void setcOrigProdPlace(String cOrigProdPlace)
    {
        this.cOrigProdPlace = cOrigProdPlace;
    }

    public String getcOrigProdPlace()
    {
        return cOrigProdPlace;
    }
    public void setcOrigModelNme(String cOrigModelNme)
    {
        this.cOrigModelNme = cOrigModelNme;
    }

    public String getcOrigModelNme()
    {
        return cOrigModelNme;
    }
    public void setcOrigModelCde(String cOrigModelCde)
    {
        this.cOrigModelCde = cOrigModelCde;
    }

    public String getcOrigModelCde()
    {
        return cOrigModelCde;
    }
    public void setnOrigSeatMin(Long nOrigSeatMin)
    {
        this.nOrigSeatMin = nOrigSeatMin;
    }

    public Long getnOrigSeatMin()
    {
        return nOrigSeatMin;
    }
    public void setnOrigSeatMax(Long nOrigSeatMax)
    {
        this.nOrigSeatMax = nOrigSeatMax;
    }

    public Long getnOrigSeatMax()
    {
        return nOrigSeatMax;
    }
    public void setnOrigTonage(Long nOrigTonage)
    {
        this.nOrigTonage = nOrigTonage;
    }

    public Long getnOrigTonage()
    {
        return nOrigTonage;
    }
    public void setnOrigDisplacement(Long nOrigDisplacement)
    {
        this.nOrigDisplacement = nOrigDisplacement;
    }

    public Long getnOrigDisplacement()
    {
        return nOrigDisplacement;
    }
    public void setnOrigNewPurchaseUnity(Long nOrigNewPurchaseUnity)
    {
        this.nOrigNewPurchaseUnity = nOrigNewPurchaseUnity;
    }

    public Long getnOrigNewPurchaseUnity()
    {
        return nOrigNewPurchaseUnity;
    }
    public void setnOrigNewPurchaseLocal(Long nOrigNewPurchaseLocal)
    {
        this.nOrigNewPurchaseLocal = nOrigNewPurchaseLocal;
    }

    public Long getnOrigNewPurchaseLocal()
    {
        return nOrigNewPurchaseLocal;
    }
    public void setnOrigQualityMin(Long nOrigQualityMin)
    {
        this.nOrigQualityMin = nOrigQualityMin;
    }

    public Long getnOrigQualityMin()
    {
        return nOrigQualityMin;
    }
    public void setnOrigQualityMax(Long nOrigQualityMax)
    {
        this.nOrigQualityMax = nOrigQualityMax;
    }

    public Long getnOrigQualityMax()
    {
        return nOrigQualityMax;
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
    public void setcRenewalFlag(String cRenewalFlag)
    {
        this.cRenewalFlag = cRenewalFlag;
    }

    public String getcRenewalFlag()
    {
        return cRenewalFlag;
    }
    public void setcVhlPriceType(String cVhlPriceType)
    {
        this.cVhlPriceType = cVhlPriceType;
    }

    public String getcVhlPriceType()
    {
        return cVhlPriceType;
    }
    public void setcModelNmeSearch(String cModelNmeSearch)
    {
        this.cModelNmeSearch = cModelNmeSearch;
    }

    public String getcModelNmeSearch()
    {
        return cModelNmeSearch;
    }
    public void setcNewVehicleFlag(String cNewVehicleFlag)
    {
        this.cNewVehicleFlag = cNewVehicleFlag;
    }

    public String getcNewVehicleFlag()
    {
        return cNewVehicleFlag;
    }
    public void setcPrintDisplacement(String cPrintDisplacement)
    {
        this.cPrintDisplacement = cPrintDisplacement;
    }

    public String getcPrintDisplacement()
    {
        return cPrintDisplacement;
    }
    public void setcHighriskShow(String cHighriskShow)
    {
        this.cHighriskShow = cHighriskShow;
    }

    public String getcHighriskShow()
    {
        return cHighriskShow;
    }
    public void setcReducCarShow(String cReducCarShow)
    {
        this.cReducCarShow = cReducCarShow;
    }

    public String getcReducCarShow()
    {
        return cReducCarShow;
    }
    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getFamilyName()
    {
        return familyName;
    }
    public void setcFuelType(String cFuelType)
    {
        this.cFuelType = cFuelType;
    }

    public String getcFuelType()
    {
        return cFuelType;
    }
    public void setcCertificateType(String cCertificateType)
    {
        this.cCertificateType = cCertificateType;
    }

    public String getcCertificateType()
    {
        return cCertificateType;
    }
    public void setcCertificateNo(String cCertificateNo)
    {
        this.cCertificateNo = cCertificateNo;
    }

    public String getcCertificateNo()
    {
        return cCertificateNo;
    }
    public void settCertificateDate(Date tCertificateDate)
    {
        this.tCertificateDate = tCertificateDate;
    }

    public Date gettCertificateDate()
    {
        return tCertificateDate;
    }
    public void setcSOrDFlag(String cSOrDFlag)
    {
        this.cSOrDFlag = cSOrDFlag;
    }

    public String getcSOrDFlag()
    {
        return cSOrDFlag;
    }
    public void setnReducePrm(Long nReducePrm)
    {
        this.nReducePrm = nReducePrm;
    }

    public Long getnReducePrm()
    {
        return nReducePrm;
    }
    public void setcReduceFormula(String cReduceFormula)
    {
        this.cReduceFormula = cReduceFormula;
    }

    public String getcReduceFormula()
    {
        return cReduceFormula;
    }
    public void setnReduceDay(Long nReduceDay)
    {
        this.nReduceDay = nReduceDay;
    }

    public Long getnReduceDay()
    {
        return nReduceDay;
    }
    public void setcBusiClass(String cBusiClass)
    {
        this.cBusiClass = cBusiClass;
    }

    public String getcBusiClass()
    {
        return cBusiClass;
    }
    public void setcModelCode(String cModelCode)
    {
        this.cModelCode = cModelCode;
    }

    public String getcModelCode()
    {
        return cModelCode;
    }
    public void setcModelIdCode(String cModelIdCode)
    {
        this.cModelIdCode = cModelIdCode;
    }

    public String getcModelIdCode()
    {
        return cModelIdCode;
    }
    public void setcTradeName(String cTradeName)
    {
        this.cTradeName = cTradeName;
    }

    public String getcTradeName()
    {
        return cTradeName;
    }
    public void setcTradeCode(String cTradeCode)
    {
        this.cTradeCode = cTradeCode;
    }

    public String getcTradeCode()
    {
        return cTradeCode;
    }
    public void setcBrand(String cBrand)
    {
        this.cBrand = cBrand;
    }

    public String getcBrand()
    {
        return cBrand;
    }
    public void setcBrandCode(String cBrandCode)
    {
        this.cBrandCode = cBrandCode;
    }

    public String getcBrandCode()
    {
        return cBrandCode;
    }
    public void setcSeries(String cSeries)
    {
        this.cSeries = cSeries;
    }

    public String getcSeries()
    {
        return cSeries;
    }
    public void setcSeriesCode(String cSeriesCode)
    {
        this.cSeriesCode = cSeriesCode;
    }

    public String getcSeriesCode()
    {
        return cSeriesCode;
    }
    public void setcCarName(String cCarName)
    {
        this.cCarName = cCarName;
    }

    public String getcCarName()
    {
        return cCarName;
    }
    public void setcNoticeType(String cNoticeType)
    {
        this.cNoticeType = cNoticeType;
    }

    public String getcNoticeType()
    {
        return cNoticeType;
    }
    public void setcConfigType(String cConfigType)
    {
        this.cConfigType = cConfigType;
    }

    public String getcConfigType()
    {
        return cConfigType;
    }
    public void setcCategoryName(String cCategoryName)
    {
        this.cCategoryName = cCategoryName;
    }

    public String getcCategoryName()
    {
        return cCategoryName;
    }
    public void setcCategoryCode(String cCategoryCode)
    {
        this.cCategoryCode = cCategoryCode;
    }

    public String getcCategoryCode()
    {
        return cCategoryCode;
    }
    public void setcDeptName(String cDeptName)
    {
        this.cDeptName = cDeptName;
    }

    public String getcDeptName()
    {
        return cDeptName;
    }
    public void setcDeptCode(String cDeptCode)
    {
        this.cDeptCode = cDeptCode;
    }

    public String getcDeptCode()
    {
        return cDeptCode;
    }
    public void setcNcd(String cNcd)
    {
        this.cNcd = cNcd;
    }

    public String getcNcd()
    {
        return cNcd;
    }
    public void setcNcdReason(String cNcdReason)
    {
        this.cNcdReason = cNcdReason;
    }

    public String getcNcdReason()
    {
        return cNcdReason;
    }
    public void setnTrafIrr(Long nTrafIrr)
    {
        this.nTrafIrr = nTrafIrr;
    }

    public Long getnTrafIrr()
    {
        return nTrafIrr;
    }
    public void setnInsureYears(Long nInsureYears)
    {
        this.nInsureYears = nInsureYears;
    }

    public Long getnInsureYears()
    {
        return nInsureYears;
    }
    public void setnClaimTimes(Long nClaimTimes)
    {
        this.nClaimTimes = nClaimTimes;
    }

    public Long getnClaimTimes()
    {
        return nClaimTimes;
    }
    public void setcClaimAdjustLevel(String cClaimAdjustLevel)
    {
        this.cClaimAdjustLevel = cClaimAdjustLevel;
    }

    public String getcClaimAdjustLevel()
    {
        return cClaimAdjustLevel;
    }
    public void setcOcrUuId(String cOcrUuId)
    {
        this.cOcrUuId = cOcrUuId;
    }

    public String getcOcrUuId()
    {
        return cOcrUuId;
    }
    public void setcModelEneryType(String cModelEneryType)
    {
        this.cModelEneryType = cModelEneryType;
    }

    public String getcModelEneryType()
    {
        return cModelEneryType;
    }
    public void setcPureRange(String cPureRange)
    {
        this.cPureRange = cPureRange;
    }

    public String getcPureRange()
    {
        return cPureRange;
    }
    public void setcOtherEneryTypeDesc(String cOtherEneryTypeDesc)
    {
        this.cOtherEneryTypeDesc = cOtherEneryTypeDesc;
    }

    public String getcOtherEneryTypeDesc()
    {
        return cOtherEneryTypeDesc;
    }
    public void setcPrintUsagecde(String cPrintUsagecde)
    {
        this.cPrintUsagecde = cPrintUsagecde;
    }

    public String getcPrintUsagecde()
    {
        return cPrintUsagecde;
    }
    public void setcPrintUsagecdeFlag(String cPrintUsagecdeFlag)
    {
        this.cPrintUsagecdeFlag = cPrintUsagecdeFlag;
    }

    public String getcPrintUsagecdeFlag()
    {
        return cPrintUsagecdeFlag;
    }
    public void setnEmotoPower(Long nEmotoPower)
    {
        this.nEmotoPower = nEmotoPower;
    }

    public Long getnEmotoPower()
    {
        return nEmotoPower;
    }
    public void setnMaxSpeed(Long nMaxSpeed)
    {
        this.nMaxSpeed = nMaxSpeed;
    }

    public Long getnMaxSpeed()
    {
        return nMaxSpeed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cRegOwner", getcRegOwner())
            .append("cMortgageMrk", getcMortgageMrk())
            .append("cProdPlace", getcProdPlace())
            .append("cPlateNo", getcPlateNo())
            .append("cPlateColor", getcPlateColor())
            .append("cBodyColor", getcBodyColor())
            .append("cEngNo", getcEngNo())
            .append("cFrmNo", getcFrmNo())
            .append("cVin", getcVin())
            .append("cModelCde", getcModelCde())
            .append("cModelNme", getcModelNme())
            .append("cBizMrk", getcBizMrk())
            .append("cUsageCde", getcUsageCde())
            .append("cVhlTyp", getcVhlTyp())
            .append("nNewPurchaseValue", getnNewPurchaseValue())
            .append("cMfgYear", getcMfgYear())
            .append("cFstRegYm", getcFstRegYm())
            .append("nSeatNum", getnSeatNum())
            .append("nTonage", getnTonage())
            .append("cDisplacementLvl", getcDisplacementLvl())
            .append("nDisplacement", getnDisplacement())
            .append("nMonDespRate", getnMonDespRate())
            .append("nActualValue", getnActualValue())
            .append("cDductPrefCde", getcDductPrefCde())
            .append("cFixedParkCde", getcFixedParkCde())
            .append("cTravelAreaCde", getcTravelAreaCde())
            .append("cGlassTyp", getcGlassTyp())
            .append("cDevice1Mrk", getcDevice1Mrk())
            .append("cDevice2Mrk", getcDevice2Mrk())
            .append("cDevice3Mrk", getcDevice3Mrk())
            .append("cDevice4Mrk", getcDevice4Mrk())
            .append("cDevice5Mrk", getcDevice5Mrk())
            .append("cDevice6Mrk", getcDevice6Mrk())
            .append("cDevice7Mrk", getcDevice7Mrk())
            .append("cDevice8Mrk", getcDevice8Mrk())
            .append("cDevice9Mrk", getcDevice9Mrk())
            .append("cDevice10Mrk", getcDevice10Mrk())
            .append("cInspectionCde", getcInspectionCde())
            .append("cInspectTm", getcInspectTm())
            .append("cInspectorNme", getcInspectorNme())
            .append("cInspectRec", getcInspectRec())
            .append("cPlateTyp", getcPlateTyp())
            .append("cQryCde", getcQryCde())
            .append("cAffirmCde", getcAffirmCde())
            .append("nLastYearClmTms", getnLastYearClmTms())
            .append("nLastYearNcd", getnLastYearNcd())
            .append("nNcdRate", getnNcdRate())
            .append("cRegVhlTyp", getcRegVhlTyp())
            .append("cEcdemicMrk", getcEcdemicMrk())
            .append("cGrpBuyContractNo", getcGrpBuyContractNo())
            .append("cSpecDeclCauseCde", getcSpecDeclCauseCde())
            .append("cQuestNo", getcQuestNo())
            .append("cRemark", getcRemark())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("cResvTxt3", getcResvTxt3())
            .append("cResvTxt4", getcResvTxt4())
            .append("cResvTxt5", getcResvTxt5())
            .append("nResvNum1", getnResvNum1())
            .append("nResvNum2", getnResvNum2())
            .append("tResvTm1", gettResvTm1())
            .append("tResvTm2", gettResvTm2())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cCurModelNme", getcCurModelNme())
            .append("cUseYear", getcUseYear())
            .append("cTfiSpecialMrk", getcTfiSpecialMrk())
            .append("cTfiReinsureMrk", getcTfiReinsureMrk())
            .append("cShortRsn", getcShortRsn())
            .append("cLicenseTyp", getcLicenseTyp())
            .append("cIdcardTyp", getcIdcardTyp())
            .append("tTransferTm", gettTransferTm())
            .append("cOldLcnNo", getcOldLcnNo())
            .append("cProconfirmNo", getcProconfirmNo())
            .append("cSearchCode", getcSearchCode())
            .append("cBrandId", getcBrandId())
            .append("cNameChoice", getcNameChoice())
            .append("cAliasId", getcAliasId())
            .append("cNewMrk", getcNewMrk())
            .append("cResvTxt6", getcResvTxt6())
            .append("cResvTxt7", getcResvTxt7())
            .append("cResvTxt8", getcResvTxt8())
            .append("cResvTxt9", getcResvTxt9())
            .append("cResvTxt10", getcResvTxt10())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cRiskFlag", getcRiskFlag())
            .append("cUseTypSrc", getcUseTypSrc())
            .append("cChgOwnerFlag", getcChgOwnerFlag())
            .append("cLoanVehicleFlag", getcLoanVehicleFlag())
            .append("tTransferDate", gettTransferDate())
            .append("cStatus", getcStatus())
            .append("cResvTxt11", getcResvTxt11())
            .append("cResvTxt12", getcResvTxt12())
            .append("cResvTxt13", getcResvTxt13())
            .append("cResvTxt14", getcResvTxt14())
            .append("cResvTxt15", getcResvTxt15())
            .append("cVhlRelCde", getcVhlRelCde())
            .append("nResvNum3", getnResvNum3())
            .append("nResvNum4", getnResvNum4())
            .append("nResvNum5", getnResvNum5())
            .append("cVhlcategoryCde", getcVhlcategoryCde())
            .append("cOrigVhlcategoryCde", getcOrigVhlcategoryCde())
            .append("cOrigProdPlace", getcOrigProdPlace())
            .append("cOrigModelNme", getcOrigModelNme())
            .append("cOrigModelCde", getcOrigModelCde())
            .append("nOrigSeatMin", getnOrigSeatMin())
            .append("nOrigSeatMax", getnOrigSeatMax())
            .append("nOrigTonage", getnOrigTonage())
            .append("nOrigDisplacement", getnOrigDisplacement())
            .append("nOrigNewPurchaseUnity", getnOrigNewPurchaseUnity())
            .append("nOrigNewPurchaseLocal", getnOrigNewPurchaseLocal())
            .append("nOrigQualityMin", getnOrigQualityMin())
            .append("nOrigQualityMax", getnOrigQualityMax())
            .append("cResvTxt16", getcResvTxt16())
            .append("cResvTxt17", getcResvTxt17())
            .append("cResvTxt18", getcResvTxt18())
            .append("cResvTxt19", getcResvTxt19())
            .append("cResvTxt20", getcResvTxt20())
            .append("cRenewalFlag", getcRenewalFlag())
            .append("cVhlPriceType", getcVhlPriceType())
            .append("cModelNmeSearch", getcModelNmeSearch())
            .append("cNewVehicleFlag", getcNewVehicleFlag())
            .append("cPrintDisplacement", getcPrintDisplacement())
            .append("cHighriskShow", getcHighriskShow())
            .append("cReducCarShow", getcReducCarShow())
            .append("familyName", getFamilyName())
            .append("cFuelType", getcFuelType())
            .append("cCertificateType", getcCertificateType())
            .append("cCertificateNo", getcCertificateNo())
            .append("tCertificateDate", gettCertificateDate())
            .append("cSOrDFlag", getcSOrDFlag())
            .append("nReducePrm", getnReducePrm())
            .append("cReduceFormula", getcReduceFormula())
            .append("nReduceDay", getnReduceDay())
            .append("cBusiClass", getcBusiClass())
            .append("cModelCode", getcModelCode())
            .append("cModelIdCode", getcModelIdCode())
            .append("cTradeName", getcTradeName())
            .append("cTradeCode", getcTradeCode())
            .append("cBrand", getcBrand())
            .append("cBrandCode", getcBrandCode())
            .append("cSeries", getcSeries())
            .append("cSeriesCode", getcSeriesCode())
            .append("cCarName", getcCarName())
            .append("cNoticeType", getcNoticeType())
            .append("cConfigType", getcConfigType())
            .append("cCategoryName", getcCategoryName())
            .append("cCategoryCode", getcCategoryCode())
            .append("cDeptName", getcDeptName())
            .append("cDeptCode", getcDeptCode())
            .append("cNcd", getcNcd())
            .append("cNcdReason", getcNcdReason())
            .append("nTrafIrr", getnTrafIrr())
            .append("nInsureYears", getnInsureYears())
            .append("nClaimTimes", getnClaimTimes())
            .append("cClaimAdjustLevel", getcClaimAdjustLevel())
            .append("cOcrUuId", getcOcrUuId())
            .append("cModelEneryType", getcModelEneryType())
            .append("cPureRange", getcPureRange())
            .append("cOtherEneryTypeDesc", getcOtherEneryTypeDesc())
            .append("cPrintUsagecde", getcPrintUsagecde())
            .append("cPrintUsagecdeFlag", getcPrintUsagecdeFlag())
            .append("nEmotoPower", getnEmotoPower())
            .append("nMaxSpeed", getnMaxSpeed())
            .toString();
    }
}
