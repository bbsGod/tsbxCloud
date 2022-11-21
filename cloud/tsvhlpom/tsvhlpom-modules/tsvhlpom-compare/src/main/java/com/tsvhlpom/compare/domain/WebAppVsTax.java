package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 申请单车船税信息对象 web_app_vs_tax
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppVsTax extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批改申请单号 */
    private String cAppNo;

    /** 车船税标志 */
    @Excel(name = "车船税标志")
    @AnjiDescription("cVsTaxMrk")
    private String cVsTaxMrk;

    /** 减税标志 */
    @Excel(name = "减税标志")
    @AnjiDescription("cAbateMrk")
    private String cAbateMrk;

    /** 减税比例 */
    @Excel(name = "减税比例")
    @AnjiDescription("cAbateProp")
    private Long cAbateProp;

    /** 减税金额 */
    @Excel(name = "减税金额")
    @AnjiDescription("cAbateAmt")
    private Long cAbateAmt;

    /** 整备质量 */
    @Excel(name = "整备质量")
    @AnjiDescription("nCurbWt")
    private Long nCurbWt;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    @AnjiDescription("cTaxpayerId")
    private String cTaxpayerId;

    /** 税目 */
    @Excel(name = "税目")
    @AnjiDescription("cTaxItemCde")
    private String cTaxItemCde;

    /** 年单位税额 */
    @Excel(name = "年单位税额")
    @AnjiDescription("nAnnUnitTaxAmt")
    private Long nAnnUnitTaxAmt;

    /** 前次交强险截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "前次交强险截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLastSaliEndDate")
    private Date tLastSaliEndDate;

    /** 前次交强险承保公司 */
    @Excel(name = "前次交强险承保公司")
    @AnjiDescription("cLastSaliInsurerCde")
    private String cLastSaliInsurerCde;

    /** 前次交强险保单号 */
    @Excel(name = "前次交强险保单号")
    @AnjiDescription("cLastSaliPlyNo")
    private String cLastSaliPlyNo;

    /** 前次交强险保单号 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "前次交强险保单号", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tSaliAppDate")
    private Date tSaliAppDate;

    /** 当年应缴应纳税月份数 */
    @Excel(name = "当年应缴应纳税月份数")
    @AnjiDescription("nTaxableMonths")
    private Long nTaxableMonths;

    /** 当年应交金额 */
    @Excel(name = "当年应交金额")
    @AnjiDescription("nTaxableAmt")
    private Long nTaxableAmt;

    /** 本次纳税年度 */
    @Excel(name = "本次纳税年度")
    @AnjiDescription("cTaxYear")
    private String cTaxYear;

    /** 前次纳税年度 */
    @Excel(name = "前次纳税年度")
    @AnjiDescription("cLastTaxYear")
    private String cLastTaxYear;

    /** 往年应缴月份数 */
    @Excel(name = "往年应缴月份数")
    @AnjiDescription("nLastYearTaxableMonths")
    private Long nLastYearTaxableMonths;

    /** 往年补缴金额 */
    @Excel(name = "往年补缴金额")
    @AnjiDescription("nLastYear")
    private Long nLastYear;

    /** 滞纳天数 */
    @Excel(name = "滞纳天数")
    @AnjiDescription("nOverdueDays")
    private Long nOverdueDays;

    /** 滞纳金比例 */
    @Excel(name = "滞纳金比例")
    @AnjiDescription("nOverdueFineProp")
    private Long nOverdueFineProp;

    /** 合计税款 */
    @Excel(name = "合计税款")
    @AnjiDescription("nAggTax")
    private Long nAggTax;

    /** 手续费比例 */
    @Excel(name = "手续费比例")
    @AnjiDescription("nChargeProp")
    private Long nChargeProp;

    /** 手续费 */
    @Excel(name = "手续费")
    @AnjiDescription("nChargeAmt")
    private Long nChargeAmt;

    /** 完税凭证号 */
    @Excel(name = "完税凭证号")
    @AnjiDescription("cTaxPaymentRecptNo")
    private String cTaxPaymentRecptNo;

    /** 开具税务机关 */
    @Excel(name = "开具税务机关")
    @AnjiDescription("cTaxAuthorities")
    private String cTaxAuthorities;

    /** 减免税证明号 */
    @Excel(name = "减免税证明号")
    @AnjiDescription("cTaxReliefCertNo")
    private String cTaxReliefCertNo;

    /** 纳税人证件类型 */
    @Excel(name = "纳税人证件类型")
    @AnjiDescription("cTaxpayerCertTyp")
    private String cTaxpayerCertTyp;

    /** 纳税人证件号码 */
    @Excel(name = "纳税人证件号码")
    @AnjiDescription("cTaxpayerCertNo")
    private String cTaxpayerCertNo;

    /** 纳税人名称 */
    @Excel(name = "纳税人名称")
    @AnjiDescription("cTaxpayerNme")
    private String cTaxpayerNme;

    /** 纳税人地址 */
    @Excel(name = "纳税人地址")
    @AnjiDescription("cTaxpayerAddr")
    private String cTaxpayerAddr;

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

    /** 纳税类型 */
    @Excel(name = "纳税类型")
    @AnjiDescription("cPaytaxTyp")
    private String cPaytaxTyp;

    /** 减免税原因 */
    @Excel(name = "减免税原因")
    @AnjiDescription("cAbateRsn")
    private String cAbateRsn;

    /** 未税单号 */
    @Excel(name = "未税单号")
    @AnjiDescription("cNotpayNo")
    private String cNotpayNo;

    /** 子税目 */
    @Excel(name = "子税目")
    @AnjiDescription("cSubTaxItemCde")
    private String cSubTaxItemCde;

    /** 计税单位 */
    @Excel(name = "计税单位")
    @AnjiDescription("cTaxUnit")
    private String cTaxUnit;

    /** 当年应缴类型 */
    @Excel(name = "当年应缴类型")
    @AnjiDescription("cTaxableTyp")
    private String cTaxableTyp;

    /** 新车投保月份数 */
    @Excel(name = "新车投保月份数")
    @AnjiDescription("nNewcarMon")
    private Long nNewcarMon;

    /** 短期投保类型 */
    @Excel(name = "短期投保类型")
    @AnjiDescription("cShortTyp")
    private String cShortTyp;

    /** 短期投保月份数 */
    @Excel(name = "短期投保月份数")
    @AnjiDescription("nShortMon")
    private Long nShortMon;

    /** 前次交强险开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "前次交强险开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLastSaliBgnDate")
    private Date tLastSaliBgnDate;

    /** 滞纳金 */
    @Excel(name = "滞纳金")
    @AnjiDescription("nOverdueAmt")
    private Long nOverdueAmt;

    /** 车船税有效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车船税有效起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTaxEffBgnTm")
    private Date tTaxEffBgnTm;

    /** 车船税有效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车船税有效止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTaxEffEndTm")
    private Date tTaxEffEndTm;

    /** 税务机关车辆类型 */
    @Excel(name = "税务机关车辆类型")
    @AnjiDescription("cTaxdptVhltyp")
    private String cTaxdptVhltyp;

    /** 税款所属期 */
    @Excel(name = "税款所属期")
    @AnjiDescription("cTaxBelongTm")
    private String cTaxBelongTm;

    /** 税票号 */
    @Excel(name = "税票号")
    @AnjiDescription("cTaxVchNo")
    private String cTaxVchNo;

    /** 税票号码类型 */
    @Excel(name = "税票号码类型")
    @AnjiDescription("cTaxVchTyp")
    private String cTaxVchTyp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTaxAuthCde")
    private String cTaxAuthCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cIsCommissionTax")
    private String cIsCommissionTax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTaxfreeVhltyp")
    private String cTaxfreeVhltyp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTaxFreeCertNo")
    private String cTaxFreeCertNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cFreeTaxOrg")
    private String cFreeTaxOrg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cComTaxOrg")
    private String cComTaxOrg;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nBalanceTax")
    private Long nBalanceTax;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTaxpayerComId")
    private String cTaxpayerComId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cVehicleNumber")
    private String cVehicleNumber;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tCertificateDate")
    private Date tCertificateDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 税款变化值 */
    @Excel(name = "税款变化值")
    @AnjiDescription("nAggTaxVar")
    private Long nAggTaxVar;

    /** 批改前税款 */
    @Excel(name = "批改前税款")
    @AnjiDescription("nBefEdrTax")
    private Long nBefEdrTax;

    /** 车船税补缴起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车船税补缴起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTaxArrBgnTm")
    private Date tTaxArrBgnTm;

    /** 车船税补缴止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "车船税补缴止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tTaxArrEndTm")
    private Date tTaxArrEndTm;

    /** 完税车辆类型 */
    @Excel(name = "完税车辆类型")
    @AnjiDescription("cTaxPaymentVhltyp")
    private String cTaxPaymentVhltyp;

    /** 完税金额 */
    @Excel(name = "完税金额")
    @AnjiDescription("cTaxPaymentAmt")
    private Long cTaxPaymentAmt;

    /** 免税金额 */
    @Excel(name = "免税金额")
    @AnjiDescription("nTaxFreeAmt")
    private Long nTaxFreeAmt;

    /** 能源种类 */
    @Excel(name = "能源种类")
    @AnjiDescription("cFuelTyp")
    private String cFuelTyp;

    /** 减免税方案类型 */
    @Excel(name = "减免税方案类型")
    @AnjiDescription("cAbateTyp")
    private String cAbateTyp;

    /** 开具税务机关代码 */
    @Excel(name = "开具税务机关代码")
    @AnjiDescription("cTaxAuthoritiesCde")
    private String cTaxAuthoritiesCde;

    /** 开具税务机关代码(免税) */
    @Excel(name = "开具税务机关代码(免税)")
    @AnjiDescription("cFreeTaxOrgCde")
    private String cFreeTaxOrgCde;

    /** 开具税务机关代码(完税) */
    @Excel(name = "开具税务机关代码(完税)")
    @AnjiDescription("cComTaxOrgCde")
    private String cComTaxOrgCde;

    /** 车船税打印码 */
    @Excel(name = "车船税打印码")
    @AnjiDescription("cTaxPrintNo")
    private String cTaxPrintNo;

    /** 税计算标志 */
    @Excel(name = "税计算标志")
    @AnjiDescription("cCalcTaxFlag")
    private String cCalcTaxFlag;

    /** 当期年单位税额 */
    @Excel(name = "当期年单位税额")
    @AnjiDescription("nAnnualTaxAmt")
    private Long nAnnualTaxAmt;

    /** 逾期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "逾期时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tExceedDate")
    private Date tExceedDate;

    /** 逾期天数 */
    @Excel(name = "逾期天数")
    @AnjiDescription("nExceedDaysCount")
    private Long nExceedDaysCount;

    /** 纳税地区代码 */
    @Excel(name = "纳税地区代码")
    @AnjiDescription("cTaxLocationCode")
    private String cTaxLocationCode;

    /** 计税单位 */
    @Excel(name = "计税单位")
    @AnjiDescription("cTaxUnitTypeCode")
    private String cTaxUnitTypeCode;

    /** 当期滞纳金合计 */
    @Excel(name = "当期滞纳金合计")
    @AnjiDescription("nSumOverDue")
    private Long nSumOverDue;

    /** 当期应交合计 */
    @Excel(name = "当期应交合计")
    @AnjiDescription("nSumTax")
    private Long nSumTax;

    /** 当期应缴金额 */
    @Excel(name = "当期应缴金额")
    @AnjiDescription("nAnnualTaxDue")
    private Long nAnnualTaxDue;

    /** 当期合计欠税金额 */
    @Excel(name = "当期合计欠税金额")
    @AnjiDescription("nSumTaxDefault")
    private Long nSumTaxDefault;

    /** 申报状态 */
    @Excel(name = "申报状态")
    @AnjiDescription("cDeclareStatuIa")
    private String cDeclareStatuIa;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTaxItem")
    private String cTaxItem;

    /** 退税公式 */
    @Excel(name = "退税公式")
    @AnjiDescription("cBacktaxFormula")
    private String cBacktaxFormula;

    /** 外地车开具税务机关(北京) */
    @Excel(name = "外地车开具税务机关(北京)")
    @AnjiDescription("cDepartmentNonlocal")
    private String cDepartmentNonlocal;

    /** 完税标识(北京) */
    @Excel(name = "完税标识(北京)")
    @AnjiDescription("cPayId")
    private String cPayId;

    /** 河南完税专用开具税务机关字段 */
    @Excel(name = "河南完税专用开具税务机关字段")
    @AnjiDescription("cComTaxOrgNme")
    private String cComTaxOrgNme;

    /** 完税凭证地区代码 */
    @Excel(name = "完税凭证地区代码")
    @AnjiDescription("cVoucherCode")
    private String cVoucherCode;

    /** 扣缴纳税人 */
    @Excel(name = "扣缴纳税人")
    @AnjiDescription("cTaxDeductorNme")
    private String cTaxDeductorNme;

    /** 扣缴纳税人识别号 */
    @Excel(name = "扣缴纳税人识别号")
    @AnjiDescription("cTaxDeductorId")
    private String cTaxDeductorId;

    /** 上张保单是否本地承保标志 */
    @Excel(name = "上张保单是否本地承保标志")
    @AnjiDescription("cIsLastLocality")
    private String cIsLastLocality;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcVsTaxMrk(String cVsTaxMrk)
    {
        this.cVsTaxMrk = cVsTaxMrk;
    }

    public String getcVsTaxMrk()
    {
        return cVsTaxMrk;
    }
    public void setcAbateMrk(String cAbateMrk)
    {
        this.cAbateMrk = cAbateMrk;
    }

    public String getcAbateMrk()
    {
        return cAbateMrk;
    }
    public void setcAbateProp(Long cAbateProp)
    {
        this.cAbateProp = cAbateProp;
    }

    public Long getcAbateProp()
    {
        return cAbateProp;
    }
    public void setcAbateAmt(Long cAbateAmt)
    {
        this.cAbateAmt = cAbateAmt;
    }

    public Long getcAbateAmt()
    {
        return cAbateAmt;
    }
    public void setnCurbWt(Long nCurbWt)
    {
        this.nCurbWt = nCurbWt;
    }

    public Long getnCurbWt()
    {
        return nCurbWt;
    }
    public void setcTaxpayerId(String cTaxpayerId)
    {
        this.cTaxpayerId = cTaxpayerId;
    }

    public String getcTaxpayerId()
    {
        return cTaxpayerId;
    }
    public void setcTaxItemCde(String cTaxItemCde)
    {
        this.cTaxItemCde = cTaxItemCde;
    }

    public String getcTaxItemCde()
    {
        return cTaxItemCde;
    }
    public void setnAnnUnitTaxAmt(Long nAnnUnitTaxAmt)
    {
        this.nAnnUnitTaxAmt = nAnnUnitTaxAmt;
    }

    public Long getnAnnUnitTaxAmt()
    {
        return nAnnUnitTaxAmt;
    }
    public void settLastSaliEndDate(Date tLastSaliEndDate)
    {
        this.tLastSaliEndDate = tLastSaliEndDate;
    }

    public Date gettLastSaliEndDate()
    {
        return tLastSaliEndDate;
    }
    public void setcLastSaliInsurerCde(String cLastSaliInsurerCde)
    {
        this.cLastSaliInsurerCde = cLastSaliInsurerCde;
    }

    public String getcLastSaliInsurerCde()
    {
        return cLastSaliInsurerCde;
    }
    public void setcLastSaliPlyNo(String cLastSaliPlyNo)
    {
        this.cLastSaliPlyNo = cLastSaliPlyNo;
    }

    public String getcLastSaliPlyNo()
    {
        return cLastSaliPlyNo;
    }
    public void settSaliAppDate(Date tSaliAppDate)
    {
        this.tSaliAppDate = tSaliAppDate;
    }

    public Date gettSaliAppDate()
    {
        return tSaliAppDate;
    }
    public void setnTaxableMonths(Long nTaxableMonths)
    {
        this.nTaxableMonths = nTaxableMonths;
    }

    public Long getnTaxableMonths()
    {
        return nTaxableMonths;
    }
    public void setnTaxableAmt(Long nTaxableAmt)
    {
        this.nTaxableAmt = nTaxableAmt;
    }

    public Long getnTaxableAmt()
    {
        return nTaxableAmt;
    }
    public void setcTaxYear(String cTaxYear)
    {
        this.cTaxYear = cTaxYear;
    }

    public String getcTaxYear()
    {
        return cTaxYear;
    }
    public void setcLastTaxYear(String cLastTaxYear)
    {
        this.cLastTaxYear = cLastTaxYear;
    }

    public String getcLastTaxYear()
    {
        return cLastTaxYear;
    }
    public void setnLastYearTaxableMonths(Long nLastYearTaxableMonths)
    {
        this.nLastYearTaxableMonths = nLastYearTaxableMonths;
    }

    public Long getnLastYearTaxableMonths()
    {
        return nLastYearTaxableMonths;
    }
    public void setnLastYear(Long nLastYear)
    {
        this.nLastYear = nLastYear;
    }

    public Long getnLastYear()
    {
        return nLastYear;
    }
    public void setnOverdueDays(Long nOverdueDays)
    {
        this.nOverdueDays = nOverdueDays;
    }

    public Long getnOverdueDays()
    {
        return nOverdueDays;
    }
    public void setnOverdueFineProp(Long nOverdueFineProp)
    {
        this.nOverdueFineProp = nOverdueFineProp;
    }

    public Long getnOverdueFineProp()
    {
        return nOverdueFineProp;
    }
    public void setnAggTax(Long nAggTax)
    {
        this.nAggTax = nAggTax;
    }

    public Long getnAggTax()
    {
        return nAggTax;
    }
    public void setnChargeProp(Long nChargeProp)
    {
        this.nChargeProp = nChargeProp;
    }

    public Long getnChargeProp()
    {
        return nChargeProp;
    }
    public void setnChargeAmt(Long nChargeAmt)
    {
        this.nChargeAmt = nChargeAmt;
    }

    public Long getnChargeAmt()
    {
        return nChargeAmt;
    }
    public void setcTaxPaymentRecptNo(String cTaxPaymentRecptNo)
    {
        this.cTaxPaymentRecptNo = cTaxPaymentRecptNo;
    }

    public String getcTaxPaymentRecptNo()
    {
        return cTaxPaymentRecptNo;
    }
    public void setcTaxAuthorities(String cTaxAuthorities)
    {
        this.cTaxAuthorities = cTaxAuthorities;
    }

    public String getcTaxAuthorities()
    {
        return cTaxAuthorities;
    }
    public void setcTaxReliefCertNo(String cTaxReliefCertNo)
    {
        this.cTaxReliefCertNo = cTaxReliefCertNo;
    }

    public String getcTaxReliefCertNo()
    {
        return cTaxReliefCertNo;
    }
    public void setcTaxpayerCertTyp(String cTaxpayerCertTyp)
    {
        this.cTaxpayerCertTyp = cTaxpayerCertTyp;
    }

    public String getcTaxpayerCertTyp()
    {
        return cTaxpayerCertTyp;
    }
    public void setcTaxpayerCertNo(String cTaxpayerCertNo)
    {
        this.cTaxpayerCertNo = cTaxpayerCertNo;
    }

    public String getcTaxpayerCertNo()
    {
        return cTaxpayerCertNo;
    }
    public void setcTaxpayerNme(String cTaxpayerNme)
    {
        this.cTaxpayerNme = cTaxpayerNme;
    }

    public String getcTaxpayerNme()
    {
        return cTaxpayerNme;
    }
    public void setcTaxpayerAddr(String cTaxpayerAddr)
    {
        this.cTaxpayerAddr = cTaxpayerAddr;
    }

    public String getcTaxpayerAddr()
    {
        return cTaxpayerAddr;
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
    public void setcPaytaxTyp(String cPaytaxTyp)
    {
        this.cPaytaxTyp = cPaytaxTyp;
    }

    public String getcPaytaxTyp()
    {
        return cPaytaxTyp;
    }
    public void setcAbateRsn(String cAbateRsn)
    {
        this.cAbateRsn = cAbateRsn;
    }

    public String getcAbateRsn()
    {
        return cAbateRsn;
    }
    public void setcNotpayNo(String cNotpayNo)
    {
        this.cNotpayNo = cNotpayNo;
    }

    public String getcNotpayNo()
    {
        return cNotpayNo;
    }
    public void setcSubTaxItemCde(String cSubTaxItemCde)
    {
        this.cSubTaxItemCde = cSubTaxItemCde;
    }

    public String getcSubTaxItemCde()
    {
        return cSubTaxItemCde;
    }
    public void setcTaxUnit(String cTaxUnit)
    {
        this.cTaxUnit = cTaxUnit;
    }

    public String getcTaxUnit()
    {
        return cTaxUnit;
    }
    public void setcTaxableTyp(String cTaxableTyp)
    {
        this.cTaxableTyp = cTaxableTyp;
    }

    public String getcTaxableTyp()
    {
        return cTaxableTyp;
    }
    public void setnNewcarMon(Long nNewcarMon)
    {
        this.nNewcarMon = nNewcarMon;
    }

    public Long getnNewcarMon()
    {
        return nNewcarMon;
    }
    public void setcShortTyp(String cShortTyp)
    {
        this.cShortTyp = cShortTyp;
    }

    public String getcShortTyp()
    {
        return cShortTyp;
    }
    public void setnShortMon(Long nShortMon)
    {
        this.nShortMon = nShortMon;
    }

    public Long getnShortMon()
    {
        return nShortMon;
    }
    public void settLastSaliBgnDate(Date tLastSaliBgnDate)
    {
        this.tLastSaliBgnDate = tLastSaliBgnDate;
    }

    public Date gettLastSaliBgnDate()
    {
        return tLastSaliBgnDate;
    }
    public void setnOverdueAmt(Long nOverdueAmt)
    {
        this.nOverdueAmt = nOverdueAmt;
    }

    public Long getnOverdueAmt()
    {
        return nOverdueAmt;
    }
    public void settTaxEffBgnTm(Date tTaxEffBgnTm)
    {
        this.tTaxEffBgnTm = tTaxEffBgnTm;
    }

    public Date gettTaxEffBgnTm()
    {
        return tTaxEffBgnTm;
    }
    public void settTaxEffEndTm(Date tTaxEffEndTm)
    {
        this.tTaxEffEndTm = tTaxEffEndTm;
    }

    public Date gettTaxEffEndTm()
    {
        return tTaxEffEndTm;
    }
    public void setcTaxdptVhltyp(String cTaxdptVhltyp)
    {
        this.cTaxdptVhltyp = cTaxdptVhltyp;
    }

    public String getcTaxdptVhltyp()
    {
        return cTaxdptVhltyp;
    }
    public void setcTaxBelongTm(String cTaxBelongTm)
    {
        this.cTaxBelongTm = cTaxBelongTm;
    }

    public String getcTaxBelongTm()
    {
        return cTaxBelongTm;
    }
    public void setcTaxVchNo(String cTaxVchNo)
    {
        this.cTaxVchNo = cTaxVchNo;
    }

    public String getcTaxVchNo()
    {
        return cTaxVchNo;
    }
    public void setcTaxVchTyp(String cTaxVchTyp)
    {
        this.cTaxVchTyp = cTaxVchTyp;
    }

    public String getcTaxVchTyp()
    {
        return cTaxVchTyp;
    }
    public void setcTaxAuthCde(String cTaxAuthCde)
    {
        this.cTaxAuthCde = cTaxAuthCde;
    }

    public String getcTaxAuthCde()
    {
        return cTaxAuthCde;
    }
    public void setcIsCommissionTax(String cIsCommissionTax)
    {
        this.cIsCommissionTax = cIsCommissionTax;
    }

    public String getcIsCommissionTax()
    {
        return cIsCommissionTax;
    }
    public void setcTaxfreeVhltyp(String cTaxfreeVhltyp)
    {
        this.cTaxfreeVhltyp = cTaxfreeVhltyp;
    }

    public String getcTaxfreeVhltyp()
    {
        return cTaxfreeVhltyp;
    }
    public void setcTaxFreeCertNo(String cTaxFreeCertNo)
    {
        this.cTaxFreeCertNo = cTaxFreeCertNo;
    }

    public String getcTaxFreeCertNo()
    {
        return cTaxFreeCertNo;
    }
    public void setcFreeTaxOrg(String cFreeTaxOrg)
    {
        this.cFreeTaxOrg = cFreeTaxOrg;
    }

    public String getcFreeTaxOrg()
    {
        return cFreeTaxOrg;
    }
    public void setcComTaxOrg(String cComTaxOrg)
    {
        this.cComTaxOrg = cComTaxOrg;
    }

    public String getcComTaxOrg()
    {
        return cComTaxOrg;
    }
    public void setnBalanceTax(Long nBalanceTax)
    {
        this.nBalanceTax = nBalanceTax;
    }

    public Long getnBalanceTax()
    {
        return nBalanceTax;
    }
    public void setcTaxpayerComId(String cTaxpayerComId)
    {
        this.cTaxpayerComId = cTaxpayerComId;
    }

    public String getcTaxpayerComId()
    {
        return cTaxpayerComId;
    }
    public void setcVehicleNumber(String cVehicleNumber)
    {
        this.cVehicleNumber = cVehicleNumber;
    }

    public String getcVehicleNumber()
    {
        return cVehicleNumber;
    }
    public void settCertificateDate(Date tCertificateDate)
    {
        this.tCertificateDate = tCertificateDate;
    }

    public Date gettCertificateDate()
    {
        return tCertificateDate;
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
    public void setnAggTaxVar(Long nAggTaxVar)
    {
        this.nAggTaxVar = nAggTaxVar;
    }

    public Long getnAggTaxVar()
    {
        return nAggTaxVar;
    }
    public void setnBefEdrTax(Long nBefEdrTax)
    {
        this.nBefEdrTax = nBefEdrTax;
    }

    public Long getnBefEdrTax()
    {
        return nBefEdrTax;
    }
    public void settTaxArrBgnTm(Date tTaxArrBgnTm)
    {
        this.tTaxArrBgnTm = tTaxArrBgnTm;
    }

    public Date gettTaxArrBgnTm()
    {
        return tTaxArrBgnTm;
    }
    public void settTaxArrEndTm(Date tTaxArrEndTm)
    {
        this.tTaxArrEndTm = tTaxArrEndTm;
    }

    public Date gettTaxArrEndTm()
    {
        return tTaxArrEndTm;
    }
    public void setcTaxPaymentVhltyp(String cTaxPaymentVhltyp)
    {
        this.cTaxPaymentVhltyp = cTaxPaymentVhltyp;
    }

    public String getcTaxPaymentVhltyp()
    {
        return cTaxPaymentVhltyp;
    }
    public void setcTaxPaymentAmt(Long cTaxPaymentAmt)
    {
        this.cTaxPaymentAmt = cTaxPaymentAmt;
    }

    public Long getcTaxPaymentAmt()
    {
        return cTaxPaymentAmt;
    }
    public void setnTaxFreeAmt(Long nTaxFreeAmt)
    {
        this.nTaxFreeAmt = nTaxFreeAmt;
    }

    public Long getnTaxFreeAmt()
    {
        return nTaxFreeAmt;
    }
    public void setcFuelTyp(String cFuelTyp)
    {
        this.cFuelTyp = cFuelTyp;
    }

    public String getcFuelTyp()
    {
        return cFuelTyp;
    }
    public void setcAbateTyp(String cAbateTyp)
    {
        this.cAbateTyp = cAbateTyp;
    }

    public String getcAbateTyp()
    {
        return cAbateTyp;
    }
    public void setcTaxAuthoritiesCde(String cTaxAuthoritiesCde)
    {
        this.cTaxAuthoritiesCde = cTaxAuthoritiesCde;
    }

    public String getcTaxAuthoritiesCde()
    {
        return cTaxAuthoritiesCde;
    }
    public void setcFreeTaxOrgCde(String cFreeTaxOrgCde)
    {
        this.cFreeTaxOrgCde = cFreeTaxOrgCde;
    }

    public String getcFreeTaxOrgCde()
    {
        return cFreeTaxOrgCde;
    }
    public void setcComTaxOrgCde(String cComTaxOrgCde)
    {
        this.cComTaxOrgCde = cComTaxOrgCde;
    }

    public String getcComTaxOrgCde()
    {
        return cComTaxOrgCde;
    }
    public void setcTaxPrintNo(String cTaxPrintNo)
    {
        this.cTaxPrintNo = cTaxPrintNo;
    }

    public String getcTaxPrintNo()
    {
        return cTaxPrintNo;
    }
    public void setcCalcTaxFlag(String cCalcTaxFlag)
    {
        this.cCalcTaxFlag = cCalcTaxFlag;
    }

    public String getcCalcTaxFlag()
    {
        return cCalcTaxFlag;
    }
    public void setnAnnualTaxAmt(Long nAnnualTaxAmt)
    {
        this.nAnnualTaxAmt = nAnnualTaxAmt;
    }

    public Long getnAnnualTaxAmt()
    {
        return nAnnualTaxAmt;
    }
    public void settExceedDate(Date tExceedDate)
    {
        this.tExceedDate = tExceedDate;
    }

    public Date gettExceedDate()
    {
        return tExceedDate;
    }
    public void setnExceedDaysCount(Long nExceedDaysCount)
    {
        this.nExceedDaysCount = nExceedDaysCount;
    }

    public Long getnExceedDaysCount()
    {
        return nExceedDaysCount;
    }
    public void setcTaxLocationCode(String cTaxLocationCode)
    {
        this.cTaxLocationCode = cTaxLocationCode;
    }

    public String getcTaxLocationCode()
    {
        return cTaxLocationCode;
    }
    public void setcTaxUnitTypeCode(String cTaxUnitTypeCode)
    {
        this.cTaxUnitTypeCode = cTaxUnitTypeCode;
    }

    public String getcTaxUnitTypeCode()
    {
        return cTaxUnitTypeCode;
    }
    public void setnSumOverDue(Long nSumOverDue)
    {
        this.nSumOverDue = nSumOverDue;
    }

    public Long getnSumOverDue()
    {
        return nSumOverDue;
    }
    public void setnSumTax(Long nSumTax)
    {
        this.nSumTax = nSumTax;
    }

    public Long getnSumTax()
    {
        return nSumTax;
    }
    public void setnAnnualTaxDue(Long nAnnualTaxDue)
    {
        this.nAnnualTaxDue = nAnnualTaxDue;
    }

    public Long getnAnnualTaxDue()
    {
        return nAnnualTaxDue;
    }
    public void setnSumTaxDefault(Long nSumTaxDefault)
    {
        this.nSumTaxDefault = nSumTaxDefault;
    }

    public Long getnSumTaxDefault()
    {
        return nSumTaxDefault;
    }
    public void setcDeclareStatuIa(String cDeclareStatuIa)
    {
        this.cDeclareStatuIa = cDeclareStatuIa;
    }

    public String getcDeclareStatuIa()
    {
        return cDeclareStatuIa;
    }
    public void setcTaxItem(String cTaxItem)
    {
        this.cTaxItem = cTaxItem;
    }

    public String getcTaxItem()
    {
        return cTaxItem;
    }
    public void setcBacktaxFormula(String cBacktaxFormula)
    {
        this.cBacktaxFormula = cBacktaxFormula;
    }

    public String getcBacktaxFormula()
    {
        return cBacktaxFormula;
    }
    public void setcDepartmentNonlocal(String cDepartmentNonlocal)
    {
        this.cDepartmentNonlocal = cDepartmentNonlocal;
    }

    public String getcDepartmentNonlocal()
    {
        return cDepartmentNonlocal;
    }
    public void setcPayId(String cPayId)
    {
        this.cPayId = cPayId;
    }

    public String getcPayId()
    {
        return cPayId;
    }
    public void setcComTaxOrgNme(String cComTaxOrgNme)
    {
        this.cComTaxOrgNme = cComTaxOrgNme;
    }

    public String getcComTaxOrgNme()
    {
        return cComTaxOrgNme;
    }
    public void setcVoucherCode(String cVoucherCode)
    {
        this.cVoucherCode = cVoucherCode;
    }

    public String getcVoucherCode()
    {
        return cVoucherCode;
    }
    public void setcTaxDeductorNme(String cTaxDeductorNme)
    {
        this.cTaxDeductorNme = cTaxDeductorNme;
    }

    public String getcTaxDeductorNme()
    {
        return cTaxDeductorNme;
    }
    public void setcTaxDeductorId(String cTaxDeductorId)
    {
        this.cTaxDeductorId = cTaxDeductorId;
    }

    public String getcTaxDeductorId()
    {
        return cTaxDeductorId;
    }
    public void setcIsLastLocality(String cIsLastLocality)
    {
        this.cIsLastLocality = cIsLastLocality;
    }

    public String getcIsLastLocality()
    {
        return cIsLastLocality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cVsTaxMrk", getcVsTaxMrk())
            .append("cAbateMrk", getcAbateMrk())
            .append("cAbateProp", getcAbateProp())
            .append("cAbateAmt", getcAbateAmt())
            .append("nCurbWt", getnCurbWt())
            .append("cTaxpayerId", getcTaxpayerId())
            .append("cTaxItemCde", getcTaxItemCde())
            .append("nAnnUnitTaxAmt", getnAnnUnitTaxAmt())
            .append("tLastSaliEndDate", gettLastSaliEndDate())
            .append("cLastSaliInsurerCde", getcLastSaliInsurerCde())
            .append("cLastSaliPlyNo", getcLastSaliPlyNo())
            .append("tSaliAppDate", gettSaliAppDate())
            .append("nTaxableMonths", getnTaxableMonths())
            .append("nTaxableAmt", getnTaxableAmt())
            .append("cTaxYear", getcTaxYear())
            .append("cLastTaxYear", getcLastTaxYear())
            .append("nLastYearTaxableMonths", getnLastYearTaxableMonths())
            .append("nLastYear", getnLastYear())
            .append("nOverdueDays", getnOverdueDays())
            .append("nOverdueFineProp", getnOverdueFineProp())
            .append("nAggTax", getnAggTax())
            .append("nChargeProp", getnChargeProp())
            .append("nChargeAmt", getnChargeAmt())
            .append("cTaxPaymentRecptNo", getcTaxPaymentRecptNo())
            .append("cTaxAuthorities", getcTaxAuthorities())
            .append("cTaxReliefCertNo", getcTaxReliefCertNo())
            .append("cTaxpayerCertTyp", getcTaxpayerCertTyp())
            .append("cTaxpayerCertNo", getcTaxpayerCertNo())
            .append("cTaxpayerNme", getcTaxpayerNme())
            .append("cTaxpayerAddr", getcTaxpayerAddr())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cPaytaxTyp", getcPaytaxTyp())
            .append("cAbateRsn", getcAbateRsn())
            .append("cNotpayNo", getcNotpayNo())
            .append("cSubTaxItemCde", getcSubTaxItemCde())
            .append("cTaxUnit", getcTaxUnit())
            .append("cTaxableTyp", getcTaxableTyp())
            .append("nNewcarMon", getnNewcarMon())
            .append("cShortTyp", getcShortTyp())
            .append("nShortMon", getnShortMon())
            .append("tLastSaliBgnDate", gettLastSaliBgnDate())
            .append("nOverdueAmt", getnOverdueAmt())
            .append("tTaxEffBgnTm", gettTaxEffBgnTm())
            .append("tTaxEffEndTm", gettTaxEffEndTm())
            .append("cTaxdptVhltyp", getcTaxdptVhltyp())
            .append("cTaxBelongTm", getcTaxBelongTm())
            .append("cTaxVchNo", getcTaxVchNo())
            .append("cTaxVchTyp", getcTaxVchTyp())
            .append("cTaxAuthCde", getcTaxAuthCde())
            .append("cIsCommissionTax", getcIsCommissionTax())
            .append("cTaxfreeVhltyp", getcTaxfreeVhltyp())
            .append("cTaxFreeCertNo", getcTaxFreeCertNo())
            .append("cFreeTaxOrg", getcFreeTaxOrg())
            .append("cComTaxOrg", getcComTaxOrg())
            .append("nBalanceTax", getnBalanceTax())
            .append("cTaxpayerComId", getcTaxpayerComId())
            .append("cVehicleNumber", getcVehicleNumber())
            .append("tCertificateDate", gettCertificateDate())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("nAggTaxVar", getnAggTaxVar())
            .append("nBefEdrTax", getnBefEdrTax())
            .append("tTaxArrBgnTm", gettTaxArrBgnTm())
            .append("tTaxArrEndTm", gettTaxArrEndTm())
            .append("cTaxPaymentVhltyp", getcTaxPaymentVhltyp())
            .append("cTaxPaymentAmt", getcTaxPaymentAmt())
            .append("nTaxFreeAmt", getnTaxFreeAmt())
            .append("cFuelTyp", getcFuelTyp())
            .append("cAbateTyp", getcAbateTyp())
            .append("cTaxAuthoritiesCde", getcTaxAuthoritiesCde())
            .append("cFreeTaxOrgCde", getcFreeTaxOrgCde())
            .append("cComTaxOrgCde", getcComTaxOrgCde())
            .append("cTaxPrintNo", getcTaxPrintNo())
            .append("cCalcTaxFlag", getcCalcTaxFlag())
            .append("nAnnualTaxAmt", getnAnnualTaxAmt())
            .append("tExceedDate", gettExceedDate())
            .append("nExceedDaysCount", getnExceedDaysCount())
            .append("cTaxLocationCode", getcTaxLocationCode())
            .append("cTaxUnitTypeCode", getcTaxUnitTypeCode())
            .append("nSumOverDue", getnSumOverDue())
            .append("nSumTax", getnSumTax())
            .append("nAnnualTaxDue", getnAnnualTaxDue())
            .append("nSumTaxDefault", getnSumTaxDefault())
            .append("cDeclareStatuIa", getcDeclareStatuIa())
            .append("cTaxItem", getcTaxItem())
            .append("cBacktaxFormula", getcBacktaxFormula())
            .append("cDepartmentNonlocal", getcDepartmentNonlocal())
            .append("cPayId", getcPayId())
            .append("cComTaxOrgNme", getcComTaxOrgNme())
            .append("cVoucherCode", getcVoucherCode())
            .append("cTaxDeductorNme", getcTaxDeductorNme())
            .append("cTaxDeductorId", getcTaxDeductorId())
            .append("cIsLastLocality", getcIsLastLocality())
            .toString();
    }
}
