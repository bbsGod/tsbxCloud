package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 申请单被保人对象 web_app_insured
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppInsured extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String cPkId;

    /** 批改申请单号 */
    @Excel(name = "批改申请单号")
    //@AnjiDescription("cAppNo")
    private String cAppNo;

    /** 投保时为投保单的PKID，批改申请时如非新增记录则为原投保单的PKID，
如为新增记录则为批改申请单的PKID */
    @Excel(name = "投保时为投保单的PKID，批改申请时如非新增记录则为原投保单的PKID， 如为新增记录则为批改申请单的PKID")
    @AnjiDescription("cRowId")
    private String cRowId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nSeqNo")
    private Long nSeqNo;

    /** 被保人编码 */
    @Excel(name = "被保人编码")
    @AnjiDescription("cInsuredCde")
    private String cInsuredCde;

    /** 被保人名称 */
    @Excel(name = "被保人名称")
    @AnjiDescription("cInsuredNme")
    private String cInsuredNme;

    /** 包括：'0'主被保人,'1'副被保人,'2'连带被保人 */
    @Excel(name = "包括：'0'主被保人,'1'副被保人,'2'连带被保人")
    @AnjiDescription("cInsuredCls")
    private String cInsuredCls;

    /** 副被保人对应主被保人代码 */
    @Excel(name = "副被保人对应主被保人代码")
    @AnjiDescription("cRelInsuredCde")
    private String cRelInsuredCde;

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

    /** 投保人联系人 */
    @Excel(name = "投保人联系人")
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

    /** 居住地址 */
    @Excel(name = "居住地址")
    @AnjiDescription("cResidAddr")
    private String cResidAddr;

    /** 居住地址邮编 */
    @Excel(name = "居住地址邮编")
    @AnjiDescription("cResidZip")
    private String cResidZip;

    /** 工作单位 */
    @Excel(name = "工作单位")
    @AnjiDescription("cWorkDpt")
    private String cWorkDpt;

    /** 工作单位地址 */
    @Excel(name = "工作单位地址")
    @AnjiDescription("cWorkDptAddr")
    private String cWorkDptAddr;

    /** 工作单位邮编 */
    @Excel(name = "工作单位邮编")
    @AnjiDescription("cWorkDptZip")
    private String cWorkDptZip;

    /** 性别 */
    @Excel(name = "性别")
    @AnjiDescription("cSex")
    private String cSex;

    /** 出生年月 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生年月", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tBirthday")
    private Date tBirthday;

    /** 健康状况代码 */
    @Excel(name = "健康状况代码")
    @AnjiDescription("cHealthCde")
    private String cHealthCde;

    /** 健康状况说明 */
    @Excel(name = "健康状况说明")
    @AnjiDescription("cHealthDesc")
    private String cHealthDesc;

    /** 职业代码 */
    @Excel(name = "职业代码")
    @AnjiDescription("cOccupCde")
    private String cOccupCde;

    /** 副业标志 */
    @Excel(name = "副业标志")
    @AnjiDescription("cSidelineMrk")
    private String cSidelineMrk;

    /** 职位 */
    @Excel(name = "职位")
    @AnjiDescription("cPosition")
    private String cPosition;

    /** 职务内容 */
    @Excel(name = "职务内容")
    @AnjiDescription("cDuty")
    private String cDuty;

    /** 年薪 */
    @Excel(name = "年薪")
    @AnjiDescription("nIncome")
    private Long nIncome;

    /** 文化程度 */
    @Excel(name = "文化程度")
    @AnjiDescription("cEduLvlCde")
    private String cEduLvlCde;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    @AnjiDescription("cMrgCde")
    private String cMrgCde;

    /** 子女状况 */
    @Excel(name = "子女状况")
    @AnjiDescription("cChldStsCde")
    private String cChldStsCde;

    /** 驾龄 */
    @Excel(name = "驾龄")
    @AnjiDescription("nDrvAge")
    private Long nDrvAge;

    /** 日常主要代步工具 */
    @Excel(name = "日常主要代步工具")
    @AnjiDescription("cConveyanceCde")
    private String cConveyanceCde;

    /** 以住三年保险记录 */
    @Excel(name = "以住三年保险记录")
    @AnjiDescription("cInsHistory")
    private String cInsHistory;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** 修改人代码 */
    @Excel(name = "修改人代码")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 创建人代码 */
    @Excel(name = "创建人代码")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 客户风险等级 */
    @Excel(name = "客户风险等级")
    @AnjiDescription("cCusRiskLvl")
    private String cCusRiskLvl;

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

    /** subjectNumber农业主体代码，农险二期 */
    @Excel(name = "subjectNumber农业主体代码，农险二期")
    @AnjiDescription("cSubjectNumber")
    private String cSubjectNumber;

    /** 客户信息真实性  1：真实  2：待核查 */
    @Excel(name = "客户信息真实性  1：真实  2：待核查")
    @AnjiDescription("cCustomerInfo")
    private String cCustomerInfo;

    /** 港澳台居民通行证 */
    @Excel(name = "港澳台居民通行证")
    @AnjiDescription("cHmtResidentsPassCde")
    private String cHmtResidentsPassCde;

    /** 长期(勾选时：1，其余为0) */
    @Excel(name = "长期(勾选时：1，其余为0)")
    @AnjiDescription("cLongTimeFlag")
    private String cLongTimeFlag;

    /** 反担保协议编号 */
    @Excel(name = "反担保协议编号")
    @AnjiDescription("cCounterGuaranteeNo")
    private String cCounterGuaranteeNo;

    /** 反担保期限起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "反担保期限起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCounterGuaranteeBgnTm")
    private Date tCounterGuaranteeBgnTm;

    /** 反担保期限止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "反担保期限止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCounterGuaranteeEndTm")
    private Date tCounterGuaranteeEndTm;

    /** 被保人性别 (16001代表男性， 16002代表女性) */
    @Excel(name = "被保人性别 (16001代表男性， 16002代表女性)")
    @AnjiDescription("cCustomerGender")
    private String cCustomerGender;

    /** 经营范围 */
    @Excel(name = "经营范围")
    @AnjiDescription("cBusinessScope")
    private String cBusinessScope;

    /** 有无社保标记 */
    @Excel(name = "有无社保标记")
    @AnjiDescription("cSocialInsurance")
    private String cSocialInsurance;

    /** 与投保人关系 */
    @Excel(name = "与投保人关系")
    @AnjiDescription("cRelCde")
    private String cRelCde;

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

    /** 证件有效期限是否为长期，0 否，1 是 */
    @Excel(name = "证件有效期限是否为长期，0 否，1 是")
    @AnjiDescription("cPerpetual")
    private String cPerpetual;

    /** 被保险人联系人电话 */
    @Excel(name = "被保险人联系人电话")
    @AnjiDescription("cCntrNmeTel")
    private String cCntrNmeTel;

    /** 被保人联系人2 */
    @Excel(name = "被保人联系人2")
    @AnjiDescription("cCntrNme2")
    private String cCntrNme2;

    /** 被保人联系人2电话 */
    @Excel(name = "被保人联系人2电话")
    @AnjiDescription("cCntrNme2Tel")
    private String cCntrNme2Tel;

    /** 贷款机构金融许可证编号 */
    @Excel(name = "贷款机构金融许可证编号")
    @AnjiDescription("cFinancialLicense")
    private String cFinancialLicense;

    /** 个人健康告知书 */
    @Excel(name = "个人健康告知书")
    @AnjiDescription("cPerHealthNotice")
    private String cPerHealthNotice;

    /** 健康告知书（恶性肿瘤保险责任） */
    @Excel(name = "健康告知书", readConverterExp = "恶=性肿瘤保险责任")
    @AnjiDescription("cMalignantTumor")
    private String cMalignantTumor;

    /** 健康告知书（一般医疗保险责任） */
    @Excel(name = "健康告知书", readConverterExp = "一=般医疗保险责任")
    @AnjiDescription("cGeneralMedical")
    private String cGeneralMedical;

    /** 证件有效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "证件有效止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCertfFinalTm")
    private Date tCertfFinalTm;

    /** 长期(勾选时：1，其余为0) */
    @Excel(name = "长期(勾选时：1，其余为0)")
    @AnjiDescription("cLongTimeSign")
    private String cLongTimeSign;

    /** 换证次数 */
    @Excel(name = "换证次数")
    @AnjiDescription("nChangeTime")
    private Long nChangeTime;

    /** 社保身份 */
    @Excel(name = "社保身份")
    @AnjiDescription("cSocialSecurity")
    private String cSocialSecurity;

    /** 银行机构标识 1：是 0：否 */
    @Excel(name = "银行机构标识 1：是 0：否")
    @AnjiDescription("cBankIdentification")
    private String cBankIdentification;

    /** 年龄 */
    @Excel(name = "年龄")
    @AnjiDescription("nAge")
    private Long nAge;

    /** 健康状况 */
    @Excel(name = "健康状况")
    @AnjiDescription("cHealthCondition")
    private String cHealthCondition;

    /** 新市民 */
    @Excel(name = "新市民")
    @AnjiDescription("cNewCitizen")
    private String cNewCitizen;

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
    public void setcInsuredCde(String cInsuredCde)
    {
        this.cInsuredCde = cInsuredCde;
    }

    public String getcInsuredCde()
    {
        return cInsuredCde;
    }
    public void setcInsuredNme(String cInsuredNme)
    {
        this.cInsuredNme = cInsuredNme;
    }

    public String getcInsuredNme()
    {
        return cInsuredNme;
    }
    public void setcInsuredCls(String cInsuredCls)
    {
        this.cInsuredCls = cInsuredCls;
    }

    public String getcInsuredCls()
    {
        return cInsuredCls;
    }
    public void setcRelInsuredCde(String cRelInsuredCde)
    {
        this.cRelInsuredCde = cRelInsuredCde;
    }

    public String getcRelInsuredCde()
    {
        return cRelInsuredCde;
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
    public void setcResidAddr(String cResidAddr)
    {
        this.cResidAddr = cResidAddr;
    }

    public String getcResidAddr()
    {
        return cResidAddr;
    }
    public void setcResidZip(String cResidZip)
    {
        this.cResidZip = cResidZip;
    }

    public String getcResidZip()
    {
        return cResidZip;
    }
    public void setcWorkDpt(String cWorkDpt)
    {
        this.cWorkDpt = cWorkDpt;
    }

    public String getcWorkDpt()
    {
        return cWorkDpt;
    }
    public void setcWorkDptAddr(String cWorkDptAddr)
    {
        this.cWorkDptAddr = cWorkDptAddr;
    }

    public String getcWorkDptAddr()
    {
        return cWorkDptAddr;
    }
    public void setcWorkDptZip(String cWorkDptZip)
    {
        this.cWorkDptZip = cWorkDptZip;
    }

    public String getcWorkDptZip()
    {
        return cWorkDptZip;
    }
    public void setcSex(String cSex)
    {
        this.cSex = cSex;
    }

    public String getcSex()
    {
        return cSex;
    }
    public void settBirthday(Date tBirthday)
    {
        this.tBirthday = tBirthday;
    }

    public Date gettBirthday()
    {
        return tBirthday;
    }
    public void setcHealthCde(String cHealthCde)
    {
        this.cHealthCde = cHealthCde;
    }

    public String getcHealthCde()
    {
        return cHealthCde;
    }
    public void setcHealthDesc(String cHealthDesc)
    {
        this.cHealthDesc = cHealthDesc;
    }

    public String getcHealthDesc()
    {
        return cHealthDesc;
    }
    public void setcOccupCde(String cOccupCde)
    {
        this.cOccupCde = cOccupCde;
    }

    public String getcOccupCde()
    {
        return cOccupCde;
    }
    public void setcSidelineMrk(String cSidelineMrk)
    {
        this.cSidelineMrk = cSidelineMrk;
    }

    public String getcSidelineMrk()
    {
        return cSidelineMrk;
    }
    public void setcPosition(String cPosition)
    {
        this.cPosition = cPosition;
    }

    public String getcPosition()
    {
        return cPosition;
    }
    public void setcDuty(String cDuty)
    {
        this.cDuty = cDuty;
    }

    public String getcDuty()
    {
        return cDuty;
    }
    public void setnIncome(Long nIncome)
    {
        this.nIncome = nIncome;
    }

    public Long getnIncome()
    {
        return nIncome;
    }
    public void setcEduLvlCde(String cEduLvlCde)
    {
        this.cEduLvlCde = cEduLvlCde;
    }

    public String getcEduLvlCde()
    {
        return cEduLvlCde;
    }
    public void setcMrgCde(String cMrgCde)
    {
        this.cMrgCde = cMrgCde;
    }

    public String getcMrgCde()
    {
        return cMrgCde;
    }
    public void setcChldStsCde(String cChldStsCde)
    {
        this.cChldStsCde = cChldStsCde;
    }

    public String getcChldStsCde()
    {
        return cChldStsCde;
    }
    public void setnDrvAge(Long nDrvAge)
    {
        this.nDrvAge = nDrvAge;
    }

    public Long getnDrvAge()
    {
        return nDrvAge;
    }
    public void setcConveyanceCde(String cConveyanceCde)
    {
        this.cConveyanceCde = cConveyanceCde;
    }

    public String getcConveyanceCde()
    {
        return cConveyanceCde;
    }
    public void setcInsHistory(String cInsHistory)
    {
        this.cInsHistory = cInsHistory;
    }

    public String getcInsHistory()
    {
        return cInsHistory;
    }
    public void settUpdTm(Date tUpdTm)
    {
        this.tUpdTm = tUpdTm;
    }

    public Date gettUpdTm()
    {
        return tUpdTm;
    }
    public void setcUpdCde(String cUpdCde)
    {
        this.cUpdCde = cUpdCde;
    }

    public String getcUpdCde()
    {
        return cUpdCde;
    }
    public void settCrtTm(Date tCrtTm)
    {
        this.tCrtTm = tCrtTm;
    }

    public Date gettCrtTm()
    {
        return tCrtTm;
    }
    public void setcCrtCde(String cCrtCde)
    {
        this.cCrtCde = cCrtCde;
    }

    public String getcCrtCde()
    {
        return cCrtCde;
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
    public void setcCusRiskLvl(String cCusRiskLvl)
    {
        this.cCusRiskLvl = cCusRiskLvl;
    }

    public String getcCusRiskLvl()
    {
        return cCusRiskLvl;
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
    public void setcSubjectNumber(String cSubjectNumber)
    {
        this.cSubjectNumber = cSubjectNumber;
    }

    public String getcSubjectNumber()
    {
        return cSubjectNumber;
    }
    public void setcCustomerInfo(String cCustomerInfo)
    {
        this.cCustomerInfo = cCustomerInfo;
    }

    public String getcCustomerInfo()
    {
        return cCustomerInfo;
    }
    public void setcHmtResidentsPassCde(String cHmtResidentsPassCde)
    {
        this.cHmtResidentsPassCde = cHmtResidentsPassCde;
    }

    public String getcHmtResidentsPassCde()
    {
        return cHmtResidentsPassCde;
    }
    public void setcLongTimeFlag(String cLongTimeFlag)
    {
        this.cLongTimeFlag = cLongTimeFlag;
    }

    public String getcLongTimeFlag()
    {
        return cLongTimeFlag;
    }
    public void setcCounterGuaranteeNo(String cCounterGuaranteeNo)
    {
        this.cCounterGuaranteeNo = cCounterGuaranteeNo;
    }

    public String getcCounterGuaranteeNo()
    {
        return cCounterGuaranteeNo;
    }
    public void settCounterGuaranteeBgnTm(Date tCounterGuaranteeBgnTm)
    {
        this.tCounterGuaranteeBgnTm = tCounterGuaranteeBgnTm;
    }

    public Date gettCounterGuaranteeBgnTm()
    {
        return tCounterGuaranteeBgnTm;
    }
    public void settCounterGuaranteeEndTm(Date tCounterGuaranteeEndTm)
    {
        this.tCounterGuaranteeEndTm = tCounterGuaranteeEndTm;
    }

    public Date gettCounterGuaranteeEndTm()
    {
        return tCounterGuaranteeEndTm;
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
    public void setcSocialInsurance(String cSocialInsurance)
    {
        this.cSocialInsurance = cSocialInsurance;
    }

    public String getcSocialInsurance()
    {
        return cSocialInsurance;
    }
    public void setcRelCde(String cRelCde)
    {
        this.cRelCde = cRelCde;
    }

    public String getcRelCde()
    {
        return cRelCde;
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
    public void setcPerpetual(String cPerpetual)
    {
        this.cPerpetual = cPerpetual;
    }

    public String getcPerpetual()
    {
        return cPerpetual;
    }
    public void setcCntrNmeTel(String cCntrNmeTel)
    {
        this.cCntrNmeTel = cCntrNmeTel;
    }

    public String getcCntrNmeTel()
    {
        return cCntrNmeTel;
    }
    public void setcCntrNme2(String cCntrNme2)
    {
        this.cCntrNme2 = cCntrNme2;
    }

    public String getcCntrNme2()
    {
        return cCntrNme2;
    }
    public void setcCntrNme2Tel(String cCntrNme2Tel)
    {
        this.cCntrNme2Tel = cCntrNme2Tel;
    }

    public String getcCntrNme2Tel()
    {
        return cCntrNme2Tel;
    }
    public void setcFinancialLicense(String cFinancialLicense)
    {
        this.cFinancialLicense = cFinancialLicense;
    }

    public String getcFinancialLicense()
    {
        return cFinancialLicense;
    }
    public void setcPerHealthNotice(String cPerHealthNotice)
    {
        this.cPerHealthNotice = cPerHealthNotice;
    }

    public String getcPerHealthNotice()
    {
        return cPerHealthNotice;
    }
    public void setcMalignantTumor(String cMalignantTumor)
    {
        this.cMalignantTumor = cMalignantTumor;
    }

    public String getcMalignantTumor()
    {
        return cMalignantTumor;
    }
    public void setcGeneralMedical(String cGeneralMedical)
    {
        this.cGeneralMedical = cGeneralMedical;
    }

    public String getcGeneralMedical()
    {
        return cGeneralMedical;
    }
    public void settCertfFinalTm(Date tCertfFinalTm)
    {
        this.tCertfFinalTm = tCertfFinalTm;
    }

    public Date gettCertfFinalTm()
    {
        return tCertfFinalTm;
    }
    public void setcLongTimeSign(String cLongTimeSign)
    {
        this.cLongTimeSign = cLongTimeSign;
    }

    public String getcLongTimeSign()
    {
        return cLongTimeSign;
    }
    public void setnChangeTime(Long nChangeTime)
    {
        this.nChangeTime = nChangeTime;
    }

    public Long getnChangeTime()
    {
        return nChangeTime;
    }
    public void setcSocialSecurity(String cSocialSecurity)
    {
        this.cSocialSecurity = cSocialSecurity;
    }

    public String getcSocialSecurity()
    {
        return cSocialSecurity;
    }
    public void setcBankIdentification(String cBankIdentification)
    {
        this.cBankIdentification = cBankIdentification;
    }

    public String getcBankIdentification()
    {
        return cBankIdentification;
    }
    public void setnAge(Long nAge)
    {
        this.nAge = nAge;
    }

    public Long getnAge()
    {
        return nAge;
    }
    public void setcHealthCondition(String cHealthCondition)
    {
        this.cHealthCondition = cHealthCondition;
    }

    public String getcHealthCondition()
    {
        return cHealthCondition;
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
            .append("cPkId", getcPkId())
            .append("cAppNo", getcAppNo())
            .append("cRowId", getcRowId())
            .append("nSeqNo", getnSeqNo())
            .append("cInsuredCde", getcInsuredCde())
            .append("cInsuredNme", getcInsuredNme())
            .append("cInsuredCls", getcInsuredCls())
            .append("cRelInsuredCde", getcRelInsuredCde())
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
            .append("cResidAddr", getcResidAddr())
            .append("cResidZip", getcResidZip())
            .append("cWorkDpt", getcWorkDpt())
            .append("cWorkDptAddr", getcWorkDptAddr())
            .append("cWorkDptZip", getcWorkDptZip())
            .append("cSex", getcSex())
            .append("tBirthday", gettBirthday())
            .append("cHealthCde", getcHealthCde())
            .append("cHealthDesc", getcHealthDesc())
            .append("cOccupCde", getcOccupCde())
            .append("cSidelineMrk", getcSidelineMrk())
            .append("cPosition", getcPosition())
            .append("cDuty", getcDuty())
            .append("nIncome", getnIncome())
            .append("cEduLvlCde", getcEduLvlCde())
            .append("cMrgCde", getcMrgCde())
            .append("cChldStsCde", getcChldStsCde())
            .append("nDrvAge", getnDrvAge())
            .append("cConveyanceCde", getcConveyanceCde())
            .append("cInsHistory", getcInsHistory())
            .append("tUpdTm", gettUpdTm())
            .append("cUpdCde", getcUpdCde())
            .append("tCrtTm", gettCrtTm())
            .append("cCrtCde", getcCrtCde())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("cResvTxt3", getcResvTxt3())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cCusRiskLvl", getcCusRiskLvl())
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
            .append("tCertfBgnTm", gettCertfBgnTm())
            .append("cNation", getcNation())
            .append("cSignGov", getcSignGov())
            .append("cSubjectNumber", getcSubjectNumber())
            .append("cCustomerInfo", getcCustomerInfo())
            .append("cHmtResidentsPassCde", getcHmtResidentsPassCde())
            .append("cLongTimeFlag", getcLongTimeFlag())
            .append("cCounterGuaranteeNo", getcCounterGuaranteeNo())
            .append("tCounterGuaranteeBgnTm", gettCounterGuaranteeBgnTm())
            .append("tCounterGuaranteeEndTm", gettCounterGuaranteeEndTm())
            .append("cCustomerGender", getcCustomerGender())
            .append("cBusinessScope", getcBusinessScope())
            .append("cSocialInsurance", getcSocialInsurance())
            .append("cRelCde", getcRelCde())
            .append("cHoldingNme", getcHoldingNme())
            .append("cHoldingCertfCls", getcHoldingCertfCls())
            .append("cHoldingCertfCde", getcHoldingCertfCde())
            .append("tHoldingCertfEndTm", gettHoldingCertfEndTm())
            .append("cChargeNme", getcChargeNme())
            .append("cChargeCertfCls", getcChargeCertfCls())
            .append("cChargeCertfCde", getcChargeCertfCde())
            .append("tChargeCertfEndTm", gettChargeCertfEndTm())
            .append("cOccupationalGrade", getcOccupationalGrade())
            .append("cPerpetual", getcPerpetual())
            .append("cCntrNmeTel", getcCntrNmeTel())
            .append("cCntrNme2", getcCntrNme2())
            .append("cCntrNme2Tel", getcCntrNme2Tel())
            .append("cFinancialLicense", getcFinancialLicense())
            .append("cPerHealthNotice", getcPerHealthNotice())
            .append("cMalignantTumor", getcMalignantTumor())
            .append("cGeneralMedical", getcGeneralMedical())
            .append("tCertfFinalTm", gettCertfFinalTm())
            .append("cLongTimeSign", getcLongTimeSign())
            .append("nChangeTime", getnChangeTime())
            .append("cSocialSecurity", getcSocialSecurity())
            .append("cBankIdentification", getcBankIdentification())
            .append("nAge", getnAge())
            .append("cHealthCondition", getcHealthCondition())
            .append("cNewCitizen", getcNewCitizen())
            .toString();
    }
}
