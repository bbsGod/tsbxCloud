package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 投保人APP对象 web_app_applicant
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppApplicant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批改申请单号 */
    private String cAppNo;

    /** 投保人唯一客户代码 */
    @Excel(name = "投保人唯一客户代码")
    @AnjiDescription("cAppCde")
    private String cAppCde;

    /** 投保人名称 */
    @Excel(name = "投保人名称")
    @AnjiDescription("cAppNme")
    private String cAppNme;

    /** 证件类型 */
    @Excel(name = "证件类型")
    @AnjiDescription("cCertfCls")
    private String cCertfCls;

    /** 证件号码 */
    @Excel(name = "证件号码")
    @AnjiDescription("cCertfCde")
    private String cCertfCde;

    /** 客户分类,0 法人，1 个人 */
    @Excel(name = "客户分类,0 法人，1 个人")
    @AnjiDescription("cClntMrk")
    private String cClntMrk;

    /** 客户等级 */
    @Excel(name = "客户等级")
    @AnjiDescription("cCusLvl")
    private String cCusLvl;

    /** 股东客户标志 */
    @Excel(name = "股东客户标志")
    @AnjiDescription("cStkMrk")
    private String cStkMrk;

    /** 行业代码 */
    @Excel(name = "行业代码")
    @AnjiDescription("cTrdCde")
    private String cTrdCde;

    /** 行业细分代码 */
    @Excel(name = "行业细分代码")
    @AnjiDescription("cSubTrdCde")
    private String cSubTrdCde;

    /** 投保人联系人电话 */
    @Excel(name = "投保人联系人电话")
    @AnjiDescription("cCntrNme")
    private String cCntrNme;

    /** 电话 */
    @Excel(name = "电话")
    @AnjiDescription("cTel")
    private String cTel;

    /** 移动电话 */
    @Excel(name = "移动电话")
    @AnjiDescription("cMobile")
    private String cMobile;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCountry")
    private String cCountry;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cProvince")
    private String cProvince;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCity")
    private String cCity;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCounty")
    private String cCounty;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cSuffixAddr")
    private String cSuffixAddr;

    /** 地址 */
    @Excel(name = "地址")
    @AnjiDescription("cClntAddr")
    private String cClntAddr;

    /** 邮编 */
    @Excel(name = "邮编")
    @AnjiDescription("cZipCde")
    private String cZipCde;

    /** EMAIL */
    @Excel(name = "EMAIL")
    @AnjiDescription("cEmail")
    private String cEmail;

    /** 工作单位 */
    @Excel(name = "工作单位")
    @AnjiDescription("cWorkDpt")
    private String cWorkDpt;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    @AnjiDescription("cMrgCde")
    private String cMrgCde;

    /** 创建人代码 */
    @Excel(name = "创建人代码")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 修改人代码 */
    @Excel(name = "修改人代码")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** 联系传真 */
    @Excel(name = "联系传真")
    @AnjiDescription("cFax")
    private String cFax;

    /** 投保人数 */
    @Excel(name = "投保人数")
    @AnjiDescription("nAppSum")
    private Long nAppSum;

    /** 投保方式 */
    @Excel(name = "投保方式")
    @AnjiDescription("cAppWay")
    private String cAppWay;

    /** 在职员工数 */
    @Excel(name = "在职员工数")
    @AnjiDescription("nJobSum")
    private Long nJobSum;

    /** 退休员工数 */
    @Excel(name = "退休员工数")
    @AnjiDescription("nRetSum")
    private Long nRetSum;

    /** 经营内容 */
    @Excel(name = "经营内容")
    @AnjiDescription("cWorkCtt")
    private String cWorkCtt;

    /** 投保部门 */
    @Excel(name = "投保部门")
    @AnjiDescription("cAppDptNme")
    private String cAppDptNme;

    /** 经营区域 */
    @Excel(name = "经营区域")
    @AnjiDescription("cWorkArea")
    private String cWorkArea;

    /** 单位网址 */
    @Excel(name = "单位网址")
    @AnjiDescription("cWebAddr")
    private String cWebAddr;

    /** 字符预留1 */
    @Excel(name = "字符预留1")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** 字符预留2 */
    @Excel(name = "字符预留2")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** 数字预留1 */
    @Excel(name = "数字预留1")
    @AnjiDescription("nResvNum1")
    private Long nResvNum1;

    /** 数字预留2 */
    @Excel(name = "数字预留2")
    @AnjiDescription("nResvNum2")
    private Long nResvNum2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 与被保人关系 */
    @Excel(name = "与被保人关系")
    @AnjiDescription("cRelCde")
    private String cRelCde;

    /** 客户风险等级 */
    @Excel(name = "客户风险等级")
    @AnjiDescription("cCusRiskLvl")
    private String cCusRiskLvl;

    /** 性别 */
    @Excel(name = "性别")
    @AnjiDescription("cSex")
    private String cSex;

    /** 职业代码 */
    @Excel(name = "职业代码")
    @AnjiDescription("cOccupCde")
    private String cOccupCde;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tBirthday")
    private Date tBirthday;

    /** 工商登记号 */
    @Excel(name = "工商登记号")
    @AnjiDescription("cBusNo")
    private String cBusNo;

    /** 税务登记号 */
    @Excel(name = "税务登记号")
    @AnjiDescription("cTaxNo")
    private String cTaxNo;

    /** 证件有效期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "证件有效期限", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCertfEndTm")
    private Date tCertfEndTm;

    /** 法定代表人姓名 */
    @Excel(name = "法定代表人姓名")
    @AnjiDescription("cLegalNme")
    private String cLegalNme;

    /** 法定代表人证件类型 */
    @Excel(name = "法定代表人证件类型")
    @AnjiDescription("cLegalCertfCls")
    private String cLegalCertfCls;

    /** 法定代表人证件号码 */
    @Excel(name = "法定代表人证件号码")
    @AnjiDescription("cLegalCertfCde")
    private String cLegalCertfCde;

    /** 法定代表人证件有效期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "法定代表人证件有效期限", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLegalCertfEndTm")
    private Date tLegalCertfEndTm;

    /** VIP客户标识 */
    @Excel(name = "VIP客户标识")
    @AnjiDescription("cVipMrk")
    private String cVipMrk;

    /** 乡镇街 */
    @Excel(name = "乡镇街")
    @AnjiDescription("cTowns")
    private String cTowns;

    /** 村街道 */
    @Excel(name = "村街道")
    @AnjiDescription("cVillage")
    private String cVillage;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cOwnAreaCde")
    private String cOwnAreaCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cOwnDpt")
    private String cOwnDpt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cRelationDpt")
    private String cRelationDpt;

    /** 身份证有效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "身份证有效起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCertfBgnTm")
    private Date tCertfBgnTm;

    /** 民族 */
    @Excel(name = "民族")
    @AnjiDescription("cNation")
    private String cNation;

    /** 签证机关 */
    @Excel(name = "签证机关")
    @AnjiDescription("cSignGov")
    private String cSignGov;

    /** 小微企业 */
    @Excel(name = "小微企业")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** 政银保 */
    @Excel(name = "政银保")
    @AnjiDescription("cResvTxt4")
    private String cResvTxt4;

    /** 融资租赁信用保险标识 */
    @Excel(name = "融资租赁信用保险标识")
    @AnjiDescription("cResvTxt5")
    private String cResvTxt5;

    /** 知识产权抵押保证保险 */
    @Excel(name = "知识产权抵押保证保险")
    @AnjiDescription("cResvTxt6")
    private String cResvTxt6;

    /** 融资租赁保证保险 */
    @Excel(name = "融资租赁保证保险")
    @AnjiDescription("cResvTxt7")
    private String cResvTxt7;

    /** 小额贷款保证保险 */
    @Excel(name = "小额贷款保证保险")
    @AnjiDescription("cResvTxt8")
    private String cResvTxt8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt12")
    private String cResvTxt12;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt11")
    private String cResvTxt11;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt10")
    private String cResvTxt10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt9")
    private String cResvTxt9;

    /** 其他企业贷款保证保险 */
    @Excel(name = "其他企业贷款保证保险")
    @AnjiDescription("cResvTxt13")
    private String cResvTxt13;

    /** 汽车抵押类贷款保证保险 */
    @Excel(name = "汽车抵押类贷款保证保险")
    @AnjiDescription("cResvTxt14")
    private String cResvTxt14;

    /** 房屋抵押类贷款保证保险 */
    @Excel(name = "房屋抵押类贷款保证保险")
    @AnjiDescription("cResvTxt15")
    private String cResvTxt15;

    /** 个人消费类贷款保证保险 */
    @Excel(name = "个人消费类贷款保证保险")
    @AnjiDescription("cResvTxt16")
    private String cResvTxt16;

    /** 网贷平台保证保险 */
    @Excel(name = "网贷平台保证保险")
    @AnjiDescription("cResvTxt17")
    private String cResvTxt17;

    /** 单用途商业预付卡履约保证保险 */
    @Excel(name = "单用途商业预付卡履约保证保险")
    @AnjiDescription("cResvTxt18")
    private String cResvTxt18;

    /** 港澳台居民通行证 */
    @Excel(name = "港澳台居民通行证")
    @AnjiDescription("cHmtResidentsPassCde")
    private String cHmtResidentsPassCde;

    /** 证件有效期限是否为长期，0 否，1 是 */
    @Excel(name = "证件有效期限是否为长期，0 否，1 是")
    @AnjiDescription("cPerpetual")
    private String cPerpetual;

    /** 长期(勾选时：1，其余为0) */
    @Excel(name = "长期(勾选时：1，其余为0)")
    @AnjiDescription("cLongTimeFlag")
    private String cLongTimeFlag;

    /** 企业经营开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "企业经营开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tOperatingBgnTm")
    private Date tOperatingBgnTm;

    /** 企业经营结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "企业经营结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tOperatingEndTm")
    private Date tOperatingEndTm;

    /** 上年销售额 */
    @Excel(name = "上年销售额")
    @AnjiDescription("cResvTxt19")
    private String cResvTxt19;

    /** 投保前财务状况是否良好 */
    @Excel(name = "投保前财务状况是否良好")
    @AnjiDescription("cResvTxt20")
    private String cResvTxt20;

    /** 投保人性别  106001代表男, 106002 代表女 */
    @Excel(name = "投保人性别  106001代表男, 106002 代表女")
    @AnjiDescription("cCustomerGender")
    private String cCustomerGender;

    /** 经营范围 */
    @Excel(name = "经营范围")
    @AnjiDescription("cBusinessScope")
    private String cBusinessScope;

    /** 居民标记 */
    @Excel(name = "居民标记")
    @AnjiDescription("cResident")
    private String cResident;

    /** 控制人姓名 */
    @Excel(name = "控制人姓名")
    @AnjiDescription("cHoldingNme")
    private String cHoldingNme;

    /** 控制人证件类型 */
    @Excel(name = "控制人证件类型")
    @AnjiDescription("cHoldingCertfCls")
    private String cHoldingCertfCls;

    /** 控制人证件号码 */
    @Excel(name = "控制人证件号码")
    @AnjiDescription("cHoldingCertfCde")
    private String cHoldingCertfCde;

    /** 控制人证件有效期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "控制人证件有效期限", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tHoldingCertfEndTm")
    private Date tHoldingCertfEndTm;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    @AnjiDescription("cChargeNme")
    private String cChargeNme;

    /** 负责人证件类型 */
    @Excel(name = "负责人证件类型")
    @AnjiDescription("cChargeCertfCls")
    private String cChargeCertfCls;

    /** 负责人证件号码 */
    @Excel(name = "负责人证件号码")
    @AnjiDescription("cChargeCertfCde")
    private String cChargeCertfCde;

    /** 负责人证件有效期限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "负责人证件有效期限", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tChargeCertfEndTm")
    private Date tChargeCertfEndTm;

    /** 职业等级 */
    @Excel(name = "职业等级")
    @AnjiDescription("cOccupationalGrade")
    private String cOccupationalGrade;

    /** 农标识 */
    @Excel(name = "农标识")
    @AnjiDescription("cAgriMrk")
    private String cAgriMrk;

    /** 国别代码 */
    @Excel(name = "国别代码")
    @AnjiDescription("cCountryCde")
    private String cCountryCde;

    /** 登记地址 */
    @Excel(name = "登记地址")
    @AnjiDescription("cRegisterAddr")
    private String cRegisterAddr;

    /** 登记地行政区划代码 */
    @Excel(name = "登记地行政区划代码")
    @AnjiDescription("cRegisterAd")
    private String cRegisterAd;

    /** 成立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tEstablishDate")
    private Date tEstablishDate;

    /** 营业许可证到期日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "营业许可证到期日", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLicenseDate")
    private Date tLicenseDate;

    /** 企业规模 */
    @Excel(name = "企业规模")
    @AnjiDescription("cScale")
    private String cScale;

    /** 注册资本币种 */
    @Excel(name = "注册资本币种")
    @AnjiDescription("cRegisterCur")
    private String cRegisterCur;

    /** 注册资本 */
    @Excel(name = "注册资本")
    @AnjiDescription("nRegisterCap")
    private Long nRegisterCap;

    /** 主要出资人个数 */
    @Excel(name = "主要出资人个数")
    @AnjiDescription("nPromoterNum")
    private Long nPromoterNum;

    /** 出资人类型 */
    @Excel(name = "出资人类型")
    @AnjiDescription("cPromoterType")
    private String cPromoterType;

    /** 出资热身份类别 */
    @Excel(name = "出资热身份类别")
    @AnjiDescription("cPromoterIdType")
    private String cPromoterIdType;

    /** 出资人名称 */
    @Excel(name = "出资人名称")
    @AnjiDescription("cPromoterName")
    private String cPromoterName;

    /** 出资人身份标志类型 */
    @Excel(name = "出资人身份标志类型")
    @AnjiDescription("cPromoterIdMark")
    private String cPromoterIdMark;

    /** 出资人身份标志号码 */
    @Excel(name = "出资人身份标志号码")
    @AnjiDescription("cPromoterIdCard")
    private String cPromoterIdCard;

    /** 出资比例 */
    @Excel(name = "出资比例")
    @AnjiDescription("nRegisterCapProp")
    private Long nRegisterCapProp;

    /** 财务部门联系电话 */
    @Excel(name = "财务部门联系电话")
    @AnjiDescription("cFinanceTel")
    private String cFinanceTel;

    /** 业务范围 */
    @Excel(name = "业务范围")
    @AnjiDescription("cServiceScope")
    private String cServiceScope;

    /** 户籍地址-国家 */
    @Excel(name = "户籍地址-国家")
    @AnjiDescription("cHouseCountry")
    private String cHouseCountry;

    /** 户籍地址-省 */
    @Excel(name = "户籍地址-省")
    @AnjiDescription("cHouseProvince")
    private String cHouseProvince;

    /** 户籍地址-市 */
    @Excel(name = "户籍地址-市")
    @AnjiDescription("cHouseCity")
    private String cHouseCity;

    /** 户籍地址-县区 */
    @Excel(name = "户籍地址-县区")
    @AnjiDescription("cHouseCounty")
    private String cHouseCounty;

    /** 户籍地址-街 */
    @Excel(name = "户籍地址-街")
    @AnjiDescription("cHouseSuffixAddr")
    private String cHouseSuffixAddr;

    /** 户籍地址-地址 */
    @Excel(name = "户籍地址-地址")
    @AnjiDescription("cHouseClntAddr")
    private String cHouseClntAddr;

    /** 经纪类型代码 */
    @Excel(name = "经纪类型代码")
    @AnjiDescription("cEconomicType")
    private String cEconomicType;

    /** 经营许可证是否为长期0否1是 */
    @Excel(name = "经营许可证是否为长期0否1是")
    @AnjiDescription("cPerpetualLicense")
    private String cPerpetualLicense;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox1")
    private String cResvCheckbox1;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox2")
    private String cResvCheckbox2;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox3")
    private String cResvCheckbox3;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox4")
    private String cResvCheckbox4;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox5")
    private String cResvCheckbox5;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox6")
    private String cResvCheckbox6;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox7")
    private String cResvCheckbox7;

    /** 复选框预留 */
    @Excel(name = "复选框预留")
    @AnjiDescription("cResvCheckbox8")
    private String cResvCheckbox8;

    /** 农商行 */
    @Excel(name = "农商行")
    @AnjiDescription("cResvCheckbox9")
    private String cResvCheckbox9;

    /** 大型企业 */
    @Excel(name = "大型企业")
    @AnjiDescription("cLargeEnterprise")
    private String cLargeEnterprise;

    /** 中型企业 */
    @Excel(name = "中型企业")
    @AnjiDescription("cMediumEnterprise")
    private String cMediumEnterprise;

    /** 小型企业 */
    @Excel(name = "小型企业")
    @AnjiDescription("cSmallEnterprise")
    private String cSmallEnterprise;

    /** 集团企业 */
    @Excel(name = "集团企业")
    @AnjiDescription("cGroupEnterprise")
    private String cGroupEnterprise;

    /** 品牌企业 */
    @Excel(name = "品牌企业")
    @AnjiDescription("cBrandEnterprise")
    private String cBrandEnterprise;

    /** 联系人名称 */
    @Excel(name = "联系人名称")
    @AnjiDescription("cCntrNmeAgro")
    private String cCntrNmeAgro;

    /** 换证次数 */
    @Excel(name = "换证次数")
    @AnjiDescription("nChangeTime")
    private Long nChangeTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cNewCitizen")
    private String cNewCitizen;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcAppCde(String cAppCde)
    {
        this.cAppCde = cAppCde;
    }

    public String getcAppCde()
    {
        return cAppCde;
    }
    public void setcAppNme(String cAppNme)
    {
        this.cAppNme = cAppNme;
    }

    public String getcAppNme()
    {
        return cAppNme;
    }
    public void setcCertfCls(String cCertfCls)
    {
        this.cCertfCls = cCertfCls;
    }

    public String getcCertfCls()
    {
        return cCertfCls;
    }
    public void setcCertfCde(String cCertfCde)
    {
        this.cCertfCde = cCertfCde;
    }

    public String getcCertfCde()
    {
        return cCertfCde;
    }
    public void setcClntMrk(String cClntMrk)
    {
        this.cClntMrk = cClntMrk;
    }

    public String getcClntMrk()
    {
        return cClntMrk;
    }
    public void setcCusLvl(String cCusLvl)
    {
        this.cCusLvl = cCusLvl;
    }

    public String getcCusLvl()
    {
        return cCusLvl;
    }
    public void setcStkMrk(String cStkMrk)
    {
        this.cStkMrk = cStkMrk;
    }

    public String getcStkMrk()
    {
        return cStkMrk;
    }
    public void setcTrdCde(String cTrdCde)
    {
        this.cTrdCde = cTrdCde;
    }

    public String getcTrdCde()
    {
        return cTrdCde;
    }
    public void setcSubTrdCde(String cSubTrdCde)
    {
        this.cSubTrdCde = cSubTrdCde;
    }

    public String getcSubTrdCde()
    {
        return cSubTrdCde;
    }
    public void setcCntrNme(String cCntrNme)
    {
        this.cCntrNme = cCntrNme;
    }

    public String getcCntrNme()
    {
        return cCntrNme;
    }
    public void setcTel(String cTel)
    {
        this.cTel = cTel;
    }

    public String getcTel()
    {
        return cTel;
    }
    public void setcMobile(String cMobile)
    {
        this.cMobile = cMobile;
    }

    public String getcMobile()
    {
        return cMobile;
    }
    public void setcCountry(String cCountry)
    {
        this.cCountry = cCountry;
    }

    public String getcCountry()
    {
        return cCountry;
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
    public void setcCounty(String cCounty)
    {
        this.cCounty = cCounty;
    }

    public String getcCounty()
    {
        return cCounty;
    }
    public void setcSuffixAddr(String cSuffixAddr)
    {
        this.cSuffixAddr = cSuffixAddr;
    }

    public String getcSuffixAddr()
    {
        return cSuffixAddr;
    }
    public void setcClntAddr(String cClntAddr)
    {
        this.cClntAddr = cClntAddr;
    }

    public String getcClntAddr()
    {
        return cClntAddr;
    }
    public void setcZipCde(String cZipCde)
    {
        this.cZipCde = cZipCde;
    }

    public String getcZipCde()
    {
        return cZipCde;
    }
    public void setcEmail(String cEmail)
    {
        this.cEmail = cEmail;
    }

    public String getcEmail()
    {
        return cEmail;
    }
    public void setcWorkDpt(String cWorkDpt)
    {
        this.cWorkDpt = cWorkDpt;
    }

    public String getcWorkDpt()
    {
        return cWorkDpt;
    }
    public void setcMrgCde(String cMrgCde)
    {
        this.cMrgCde = cMrgCde;
    }

    public String getcMrgCde()
    {
        return cMrgCde;
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
    public void setcFax(String cFax)
    {
        this.cFax = cFax;
    }

    public String getcFax()
    {
        return cFax;
    }
    public void setnAppSum(Long nAppSum)
    {
        this.nAppSum = nAppSum;
    }

    public Long getnAppSum()
    {
        return nAppSum;
    }
    public void setcAppWay(String cAppWay)
    {
        this.cAppWay = cAppWay;
    }

    public String getcAppWay()
    {
        return cAppWay;
    }
    public void setnJobSum(Long nJobSum)
    {
        this.nJobSum = nJobSum;
    }

    public Long getnJobSum()
    {
        return nJobSum;
    }
    public void setnRetSum(Long nRetSum)
    {
        this.nRetSum = nRetSum;
    }

    public Long getnRetSum()
    {
        return nRetSum;
    }
    public void setcWorkCtt(String cWorkCtt)
    {
        this.cWorkCtt = cWorkCtt;
    }

    public String getcWorkCtt()
    {
        return cWorkCtt;
    }
    public void setcAppDptNme(String cAppDptNme)
    {
        this.cAppDptNme = cAppDptNme;
    }

    public String getcAppDptNme()
    {
        return cAppDptNme;
    }
    public void setcWorkArea(String cWorkArea)
    {
        this.cWorkArea = cWorkArea;
    }

    public String getcWorkArea()
    {
        return cWorkArea;
    }
    public void setcWebAddr(String cWebAddr)
    {
        this.cWebAddr = cWebAddr;
    }

    public String getcWebAddr()
    {
        return cWebAddr;
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
    public void setcRelCde(String cRelCde)
    {
        this.cRelCde = cRelCde;
    }

    public String getcRelCde()
    {
        return cRelCde;
    }
    public void setcCusRiskLvl(String cCusRiskLvl)
    {
        this.cCusRiskLvl = cCusRiskLvl;
    }

    public String getcCusRiskLvl()
    {
        return cCusRiskLvl;
    }
    public void setcSex(String cSex)
    {
        this.cSex = cSex;
    }

    public String getcSex()
    {
        return cSex;
    }
    public void setcOccupCde(String cOccupCde)
    {
        this.cOccupCde = cOccupCde;
    }

    public String getcOccupCde()
    {
        return cOccupCde;
    }
    public void settBirthday(Date tBirthday)
    {
        this.tBirthday = tBirthday;
    }

    public Date gettBirthday()
    {
        return tBirthday;
    }
    public void setcBusNo(String cBusNo)
    {
        this.cBusNo = cBusNo;
    }

    public String getcBusNo()
    {
        return cBusNo;
    }
    public void setcTaxNo(String cTaxNo)
    {
        this.cTaxNo = cTaxNo;
    }

    public String getcTaxNo()
    {
        return cTaxNo;
    }
    public void settCertfEndTm(Date tCertfEndTm)
    {
        this.tCertfEndTm = tCertfEndTm;
    }

    public Date gettCertfEndTm()
    {
        return tCertfEndTm;
    }
    public void setcLegalNme(String cLegalNme)
    {
        this.cLegalNme = cLegalNme;
    }

    public String getcLegalNme()
    {
        return cLegalNme;
    }
    public void setcLegalCertfCls(String cLegalCertfCls)
    {
        this.cLegalCertfCls = cLegalCertfCls;
    }

    public String getcLegalCertfCls()
    {
        return cLegalCertfCls;
    }
    public void setcLegalCertfCde(String cLegalCertfCde)
    {
        this.cLegalCertfCde = cLegalCertfCde;
    }

    public String getcLegalCertfCde()
    {
        return cLegalCertfCde;
    }
    public void settLegalCertfEndTm(Date tLegalCertfEndTm)
    {
        this.tLegalCertfEndTm = tLegalCertfEndTm;
    }

    public Date gettLegalCertfEndTm()
    {
        return tLegalCertfEndTm;
    }
    public void setcVipMrk(String cVipMrk)
    {
        this.cVipMrk = cVipMrk;
    }

    public String getcVipMrk()
    {
        return cVipMrk;
    }
    public void setcTowns(String cTowns)
    {
        this.cTowns = cTowns;
    }

    public String getcTowns()
    {
        return cTowns;
    }
    public void setcVillage(String cVillage)
    {
        this.cVillage = cVillage;
    }

    public String getcVillage()
    {
        return cVillage;
    }
    public void setcOwnAreaCde(String cOwnAreaCde)
    {
        this.cOwnAreaCde = cOwnAreaCde;
    }

    public String getcOwnAreaCde()
    {
        return cOwnAreaCde;
    }
    public void setcOwnDpt(String cOwnDpt)
    {
        this.cOwnDpt = cOwnDpt;
    }

    public String getcOwnDpt()
    {
        return cOwnDpt;
    }
    public void setcRelationDpt(String cRelationDpt)
    {
        this.cRelationDpt = cRelationDpt;
    }

    public String getcRelationDpt()
    {
        return cRelationDpt;
    }
    public void settCertfBgnTm(Date tCertfBgnTm)
    {
        this.tCertfBgnTm = tCertfBgnTm;
    }

    public Date gettCertfBgnTm()
    {
        return tCertfBgnTm;
    }
    public void setcNation(String cNation)
    {
        this.cNation = cNation;
    }

    public String getcNation()
    {
        return cNation;
    }
    public void setcSignGov(String cSignGov)
    {
        this.cSignGov = cSignGov;
    }

    public String getcSignGov()
    {
        return cSignGov;
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
    public void setcResvTxt12(String cResvTxt12)
    {
        this.cResvTxt12 = cResvTxt12;
    }

    public String getcResvTxt12()
    {
        return cResvTxt12;
    }
    public void setcResvTxt11(String cResvTxt11)
    {
        this.cResvTxt11 = cResvTxt11;
    }

    public String getcResvTxt11()
    {
        return cResvTxt11;
    }
    public void setcResvTxt10(String cResvTxt10)
    {
        this.cResvTxt10 = cResvTxt10;
    }

    public String getcResvTxt10()
    {
        return cResvTxt10;
    }
    public void setcResvTxt9(String cResvTxt9)
    {
        this.cResvTxt9 = cResvTxt9;
    }

    public String getcResvTxt9()
    {
        return cResvTxt9;
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
    public void setcHmtResidentsPassCde(String cHmtResidentsPassCde)
    {
        this.cHmtResidentsPassCde = cHmtResidentsPassCde;
    }

    public String getcHmtResidentsPassCde()
    {
        return cHmtResidentsPassCde;
    }
    public void setcPerpetual(String cPerpetual)
    {
        this.cPerpetual = cPerpetual;
    }

    public String getcPerpetual()
    {
        return cPerpetual;
    }
    public void setcLongTimeFlag(String cLongTimeFlag)
    {
        this.cLongTimeFlag = cLongTimeFlag;
    }

    public String getcLongTimeFlag()
    {
        return cLongTimeFlag;
    }
    public void settOperatingBgnTm(Date tOperatingBgnTm)
    {
        this.tOperatingBgnTm = tOperatingBgnTm;
    }

    public Date gettOperatingBgnTm()
    {
        return tOperatingBgnTm;
    }
    public void settOperatingEndTm(Date tOperatingEndTm)
    {
        this.tOperatingEndTm = tOperatingEndTm;
    }

    public Date gettOperatingEndTm()
    {
        return tOperatingEndTm;
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
    public void setcCustomerGender(String cCustomerGender)
    {
        this.cCustomerGender = cCustomerGender;
    }

    public String getcCustomerGender()
    {
        return cCustomerGender;
    }
    public void setcBusinessScope(String cBusinessScope)
    {
        this.cBusinessScope = cBusinessScope;
    }

    public String getcBusinessScope()
    {
        return cBusinessScope;
    }
    public void setcResident(String cResident)
    {
        this.cResident = cResident;
    }

    public String getcResident()
    {
        return cResident;
    }
    public void setcHoldingNme(String cHoldingNme)
    {
        this.cHoldingNme = cHoldingNme;
    }

    public String getcHoldingNme()
    {
        return cHoldingNme;
    }
    public void setcHoldingCertfCls(String cHoldingCertfCls)
    {
        this.cHoldingCertfCls = cHoldingCertfCls;
    }

    public String getcHoldingCertfCls()
    {
        return cHoldingCertfCls;
    }
    public void setcHoldingCertfCde(String cHoldingCertfCde)
    {
        this.cHoldingCertfCde = cHoldingCertfCde;
    }

    public String getcHoldingCertfCde()
    {
        return cHoldingCertfCde;
    }
    public void settHoldingCertfEndTm(Date tHoldingCertfEndTm)
    {
        this.tHoldingCertfEndTm = tHoldingCertfEndTm;
    }

    public Date gettHoldingCertfEndTm()
    {
        return tHoldingCertfEndTm;
    }
    public void setcChargeNme(String cChargeNme)
    {
        this.cChargeNme = cChargeNme;
    }

    public String getcChargeNme()
    {
        return cChargeNme;
    }
    public void setcChargeCertfCls(String cChargeCertfCls)
    {
        this.cChargeCertfCls = cChargeCertfCls;
    }

    public String getcChargeCertfCls()
    {
        return cChargeCertfCls;
    }
    public void setcChargeCertfCde(String cChargeCertfCde)
    {
        this.cChargeCertfCde = cChargeCertfCde;
    }

    public String getcChargeCertfCde()
    {
        return cChargeCertfCde;
    }
    public void settChargeCertfEndTm(Date tChargeCertfEndTm)
    {
        this.tChargeCertfEndTm = tChargeCertfEndTm;
    }

    public Date gettChargeCertfEndTm()
    {
        return tChargeCertfEndTm;
    }
    public void setcOccupationalGrade(String cOccupationalGrade)
    {
        this.cOccupationalGrade = cOccupationalGrade;
    }

    public String getcOccupationalGrade()
    {
        return cOccupationalGrade;
    }
    public void setcAgriMrk(String cAgriMrk)
    {
        this.cAgriMrk = cAgriMrk;
    }

    public String getcAgriMrk()
    {
        return cAgriMrk;
    }
    public void setcCountryCde(String cCountryCde)
    {
        this.cCountryCde = cCountryCde;
    }

    public String getcCountryCde()
    {
        return cCountryCde;
    }
    public void setcRegisterAddr(String cRegisterAddr)
    {
        this.cRegisterAddr = cRegisterAddr;
    }

    public String getcRegisterAddr()
    {
        return cRegisterAddr;
    }
    public void setcRegisterAd(String cRegisterAd)
    {
        this.cRegisterAd = cRegisterAd;
    }

    public String getcRegisterAd()
    {
        return cRegisterAd;
    }
    public void settEstablishDate(Date tEstablishDate)
    {
        this.tEstablishDate = tEstablishDate;
    }

    public Date gettEstablishDate()
    {
        return tEstablishDate;
    }
    public void settLicenseDate(Date tLicenseDate)
    {
        this.tLicenseDate = tLicenseDate;
    }

    public Date gettLicenseDate()
    {
        return tLicenseDate;
    }
    public void setcScale(String cScale)
    {
        this.cScale = cScale;
    }

    public String getcScale()
    {
        return cScale;
    }
    public void setcRegisterCur(String cRegisterCur)
    {
        this.cRegisterCur = cRegisterCur;
    }

    public String getcRegisterCur()
    {
        return cRegisterCur;
    }
    public void setnRegisterCap(Long nRegisterCap)
    {
        this.nRegisterCap = nRegisterCap;
    }

    public Long getnRegisterCap()
    {
        return nRegisterCap;
    }
    public void setnPromoterNum(Long nPromoterNum)
    {
        this.nPromoterNum = nPromoterNum;
    }

    public Long getnPromoterNum()
    {
        return nPromoterNum;
    }
    public void setcPromoterType(String cPromoterType)
    {
        this.cPromoterType = cPromoterType;
    }

    public String getcPromoterType()
    {
        return cPromoterType;
    }
    public void setcPromoterIdType(String cPromoterIdType)
    {
        this.cPromoterIdType = cPromoterIdType;
    }

    public String getcPromoterIdType()
    {
        return cPromoterIdType;
    }
    public void setcPromoterName(String cPromoterName)
    {
        this.cPromoterName = cPromoterName;
    }

    public String getcPromoterName()
    {
        return cPromoterName;
    }
    public void setcPromoterIdMark(String cPromoterIdMark)
    {
        this.cPromoterIdMark = cPromoterIdMark;
    }

    public String getcPromoterIdMark()
    {
        return cPromoterIdMark;
    }
    public void setcPromoterIdCard(String cPromoterIdCard)
    {
        this.cPromoterIdCard = cPromoterIdCard;
    }

    public String getcPromoterIdCard()
    {
        return cPromoterIdCard;
    }
    public void setnRegisterCapProp(Long nRegisterCapProp)
    {
        this.nRegisterCapProp = nRegisterCapProp;
    }

    public Long getnRegisterCapProp()
    {
        return nRegisterCapProp;
    }
    public void setcFinanceTel(String cFinanceTel)
    {
        this.cFinanceTel = cFinanceTel;
    }

    public String getcFinanceTel()
    {
        return cFinanceTel;
    }
    public void setcServiceScope(String cServiceScope)
    {
        this.cServiceScope = cServiceScope;
    }

    public String getcServiceScope()
    {
        return cServiceScope;
    }
    public void setcHouseCountry(String cHouseCountry)
    {
        this.cHouseCountry = cHouseCountry;
    }

    public String getcHouseCountry()
    {
        return cHouseCountry;
    }
    public void setcHouseProvince(String cHouseProvince)
    {
        this.cHouseProvince = cHouseProvince;
    }

    public String getcHouseProvince()
    {
        return cHouseProvince;
    }
    public void setcHouseCity(String cHouseCity)
    {
        this.cHouseCity = cHouseCity;
    }

    public String getcHouseCity()
    {
        return cHouseCity;
    }
    public void setcHouseCounty(String cHouseCounty)
    {
        this.cHouseCounty = cHouseCounty;
    }

    public String getcHouseCounty()
    {
        return cHouseCounty;
    }
    public void setcHouseSuffixAddr(String cHouseSuffixAddr)
    {
        this.cHouseSuffixAddr = cHouseSuffixAddr;
    }

    public String getcHouseSuffixAddr()
    {
        return cHouseSuffixAddr;
    }
    public void setcHouseClntAddr(String cHouseClntAddr)
    {
        this.cHouseClntAddr = cHouseClntAddr;
    }

    public String getcHouseClntAddr()
    {
        return cHouseClntAddr;
    }
    public void setcEconomicType(String cEconomicType)
    {
        this.cEconomicType = cEconomicType;
    }

    public String getcEconomicType()
    {
        return cEconomicType;
    }
    public void setcPerpetualLicense(String cPerpetualLicense)
    {
        this.cPerpetualLicense = cPerpetualLicense;
    }

    public String getcPerpetualLicense()
    {
        return cPerpetualLicense;
    }
    public void setcResvCheckbox1(String cResvCheckbox1)
    {
        this.cResvCheckbox1 = cResvCheckbox1;
    }

    public String getcResvCheckbox1()
    {
        return cResvCheckbox1;
    }
    public void setcResvCheckbox2(String cResvCheckbox2)
    {
        this.cResvCheckbox2 = cResvCheckbox2;
    }

    public String getcResvCheckbox2()
    {
        return cResvCheckbox2;
    }
    public void setcResvCheckbox3(String cResvCheckbox3)
    {
        this.cResvCheckbox3 = cResvCheckbox3;
    }

    public String getcResvCheckbox3()
    {
        return cResvCheckbox3;
    }
    public void setcResvCheckbox4(String cResvCheckbox4)
    {
        this.cResvCheckbox4 = cResvCheckbox4;
    }

    public String getcResvCheckbox4()
    {
        return cResvCheckbox4;
    }
    public void setcResvCheckbox5(String cResvCheckbox5)
    {
        this.cResvCheckbox5 = cResvCheckbox5;
    }

    public String getcResvCheckbox5()
    {
        return cResvCheckbox5;
    }
    public void setcResvCheckbox6(String cResvCheckbox6)
    {
        this.cResvCheckbox6 = cResvCheckbox6;
    }

    public String getcResvCheckbox6()
    {
        return cResvCheckbox6;
    }
    public void setcResvCheckbox7(String cResvCheckbox7)
    {
        this.cResvCheckbox7 = cResvCheckbox7;
    }

    public String getcResvCheckbox7()
    {
        return cResvCheckbox7;
    }
    public void setcResvCheckbox8(String cResvCheckbox8)
    {
        this.cResvCheckbox8 = cResvCheckbox8;
    }

    public String getcResvCheckbox8()
    {
        return cResvCheckbox8;
    }
    public void setcResvCheckbox9(String cResvCheckbox9)
    {
        this.cResvCheckbox9 = cResvCheckbox9;
    }

    public String getcResvCheckbox9()
    {
        return cResvCheckbox9;
    }
    public void setcLargeEnterprise(String cLargeEnterprise)
    {
        this.cLargeEnterprise = cLargeEnterprise;
    }

    public String getcLargeEnterprise()
    {
        return cLargeEnterprise;
    }
    public void setcMediumEnterprise(String cMediumEnterprise)
    {
        this.cMediumEnterprise = cMediumEnterprise;
    }

    public String getcMediumEnterprise()
    {
        return cMediumEnterprise;
    }
    public void setcSmallEnterprise(String cSmallEnterprise)
    {
        this.cSmallEnterprise = cSmallEnterprise;
    }

    public String getcSmallEnterprise()
    {
        return cSmallEnterprise;
    }
    public void setcGroupEnterprise(String cGroupEnterprise)
    {
        this.cGroupEnterprise = cGroupEnterprise;
    }

    public String getcGroupEnterprise()
    {
        return cGroupEnterprise;
    }
    public void setcBrandEnterprise(String cBrandEnterprise)
    {
        this.cBrandEnterprise = cBrandEnterprise;
    }

    public String getcBrandEnterprise()
    {
        return cBrandEnterprise;
    }
    public void setcCntrNmeAgro(String cCntrNmeAgro)
    {
        this.cCntrNmeAgro = cCntrNmeAgro;
    }

    public String getcCntrNmeAgro()
    {
        return cCntrNmeAgro;
    }
    public void setnChangeTime(Long nChangeTime)
    {
        this.nChangeTime = nChangeTime;
    }

    public Long getnChangeTime()
    {
        return nChangeTime;
    }
    public void setcNewCitizen(String cNewCitizen)
    {
        this.cNewCitizen = cNewCitizen;
    }

    public String getcNewCitizen()
    {
        return cNewCitizen;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cAppCde", getcAppCde())
            .append("cAppNme", getcAppNme())
            .append("cCertfCls", getcCertfCls())
            .append("cCertfCde", getcCertfCde())
            .append("cClntMrk", getcClntMrk())
            .append("cCusLvl", getcCusLvl())
            .append("cStkMrk", getcStkMrk())
            .append("cTrdCde", getcTrdCde())
            .append("cSubTrdCde", getcSubTrdCde())
            .append("cCntrNme", getcCntrNme())
            .append("cTel", getcTel())
            .append("cMobile", getcMobile())
            .append("cCountry", getcCountry())
            .append("cProvince", getcProvince())
            .append("cCity", getcCity())
            .append("cCounty", getcCounty())
            .append("cSuffixAddr", getcSuffixAddr())
            .append("cClntAddr", getcClntAddr())
            .append("cZipCde", getcZipCde())
            .append("cEmail", getcEmail())
            .append("cWorkDpt", getcWorkDpt())
            .append("cMrgCde", getcMrgCde())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cFax", getcFax())
            .append("nAppSum", getnAppSum())
            .append("cAppWay", getcAppWay())
            .append("nJobSum", getnJobSum())
            .append("nRetSum", getnRetSum())
            .append("cWorkCtt", getcWorkCtt())
            .append("cAppDptNme", getcAppDptNme())
            .append("cWorkArea", getcWorkArea())
            .append("cWebAddr", getcWebAddr())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("nResvNum1", getnResvNum1())
            .append("nResvNum2", getnResvNum2())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cRelCde", getcRelCde())
            .append("cCusRiskLvl", getcCusRiskLvl())
            .append("cSex", getcSex())
            .append("cOccupCde", getcOccupCde())
            .append("tBirthday", gettBirthday())
            .append("cBusNo", getcBusNo())
            .append("cTaxNo", getcTaxNo())
            .append("tCertfEndTm", gettCertfEndTm())
            .append("cLegalNme", getcLegalNme())
            .append("cLegalCertfCls", getcLegalCertfCls())
            .append("cLegalCertfCde", getcLegalCertfCde())
            .append("tLegalCertfEndTm", gettLegalCertfEndTm())
            .append("cVipMrk", getcVipMrk())
            .append("cTowns", getcTowns())
            .append("cVillage", getcVillage())
            .append("cOwnAreaCde", getcOwnAreaCde())
            .append("cOwnDpt", getcOwnDpt())
            .append("cRelationDpt", getcRelationDpt())
            .append("tCertfBgnTm", gettCertfBgnTm())
            .append("cNation", getcNation())
            .append("cSignGov", getcSignGov())
            .append("cResvTxt3", getcResvTxt3())
            .append("cResvTxt4", getcResvTxt4())
            .append("cResvTxt5", getcResvTxt5())
            .append("cResvTxt6", getcResvTxt6())
            .append("cResvTxt7", getcResvTxt7())
            .append("cResvTxt8", getcResvTxt8())
            .append("cResvTxt12", getcResvTxt12())
            .append("cResvTxt11", getcResvTxt11())
            .append("cResvTxt10", getcResvTxt10())
            .append("cResvTxt9", getcResvTxt9())
            .append("cResvTxt13", getcResvTxt13())
            .append("cResvTxt14", getcResvTxt14())
            .append("cResvTxt15", getcResvTxt15())
            .append("cResvTxt16", getcResvTxt16())
            .append("cResvTxt17", getcResvTxt17())
            .append("cResvTxt18", getcResvTxt18())
            .append("cHmtResidentsPassCde", getcHmtResidentsPassCde())
            .append("cPerpetual", getcPerpetual())
            .append("cLongTimeFlag", getcLongTimeFlag())
            .append("tOperatingBgnTm", gettOperatingBgnTm())
            .append("tOperatingEndTm", gettOperatingEndTm())
            .append("cResvTxt19", getcResvTxt19())
            .append("cResvTxt20", getcResvTxt20())
            .append("cCustomerGender", getcCustomerGender())
            .append("cBusinessScope", getcBusinessScope())
            .append("cResident", getcResident())
            .append("cHoldingNme", getcHoldingNme())
            .append("cHoldingCertfCls", getcHoldingCertfCls())
            .append("cHoldingCertfCde", getcHoldingCertfCde())
            .append("tHoldingCertfEndTm", gettHoldingCertfEndTm())
            .append("cChargeNme", getcChargeNme())
            .append("cChargeCertfCls", getcChargeCertfCls())
            .append("cChargeCertfCde", getcChargeCertfCde())
            .append("tChargeCertfEndTm", gettChargeCertfEndTm())
            .append("cOccupationalGrade", getcOccupationalGrade())
            .append("cAgriMrk", getcAgriMrk())
            .append("cCountryCde", getcCountryCde())
            .append("cRegisterAddr", getcRegisterAddr())
            .append("cRegisterAd", getcRegisterAd())
            .append("tEstablishDate", gettEstablishDate())
            .append("tLicenseDate", gettLicenseDate())
            .append("cScale", getcScale())
            .append("cRegisterCur", getcRegisterCur())
            .append("nRegisterCap", getnRegisterCap())
            .append("nPromoterNum", getnPromoterNum())
            .append("cPromoterType", getcPromoterType())
            .append("cPromoterIdType", getcPromoterIdType())
            .append("cPromoterName", getcPromoterName())
            .append("cPromoterIdMark", getcPromoterIdMark())
            .append("cPromoterIdCard", getcPromoterIdCard())
            .append("nRegisterCapProp", getnRegisterCapProp())
            .append("cFinanceTel", getcFinanceTel())
            .append("cServiceScope", getcServiceScope())
            .append("cHouseCountry", getcHouseCountry())
            .append("cHouseProvince", getcHouseProvince())
            .append("cHouseCity", getcHouseCity())
            .append("cHouseCounty", getcHouseCounty())
            .append("cHouseSuffixAddr", getcHouseSuffixAddr())
            .append("cHouseClntAddr", getcHouseClntAddr())
            .append("cEconomicType", getcEconomicType())
            .append("cPerpetualLicense", getcPerpetualLicense())
            .append("cResvCheckbox1", getcResvCheckbox1())
            .append("cResvCheckbox2", getcResvCheckbox2())
            .append("cResvCheckbox3", getcResvCheckbox3())
            .append("cResvCheckbox4", getcResvCheckbox4())
            .append("cResvCheckbox5", getcResvCheckbox5())
            .append("cResvCheckbox6", getcResvCheckbox6())
            .append("cResvCheckbox7", getcResvCheckbox7())
            .append("cResvCheckbox8", getcResvCheckbox8())
            .append("cResvCheckbox9", getcResvCheckbox9())
            .append("cLargeEnterprise", getcLargeEnterprise())
            .append("cMediumEnterprise", getcMediumEnterprise())
            .append("cSmallEnterprise", getcSmallEnterprise())
            .append("cGroupEnterprise", getcGroupEnterprise())
            .append("cBrandEnterprise", getcBrandEnterprise())
            .append("cCntrNmeAgro", getcCntrNmeAgro())
            .append("nChangeTime", getnChangeTime())
            .append("cNewCitizen", getcNewCitizen())
            .toString();
    }
}
