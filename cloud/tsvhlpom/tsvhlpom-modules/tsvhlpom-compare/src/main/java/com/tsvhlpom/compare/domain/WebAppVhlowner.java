package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 申请单车主对象 web_app_vhlowner
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppVhlowner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批改申请单号 */
    private String cAppNo;

    /** 车主编码 */
    @Excel(name = "车主编码")
    @AnjiDescription("cOwnerCde")
    private String cOwnerCde;

    /** 车主名称 */
    @Excel(name = "车主名称")
    @AnjiDescription("cOwnerNme")
    private String cOwnerNme;

    /** 包括：'1'个人,'2'机关,'3'企业 */
    @Excel(name = "包括：'1'个人,'2'机关,'3'企业")
    @AnjiDescription("cOwnerCls")
    private String cOwnerCls;

    /** 证件类型 */
    @Excel(name = "证件类型")
    @AnjiDescription("cCertfCls")
    private String cCertfCls;

    /** 证件号码 */
    @Excel(name = "证件号码")
    @AnjiDescription("cCertfCde")
    private String cCertfCde;

    /** 居住地址 */
    @Excel(name = "居住地址")
    @AnjiDescription("cResidAddr")
    private String cResidAddr;

    /** 地址 */
    @Excel(name = "地址")
    @AnjiDescription("cClntAddr")
    private String cClntAddr;

    /** 邮编 */
    @Excel(name = "邮编")
    @AnjiDescription("cZipCde")
    private String cZipCde;

    /** 单位性质 */
    @Excel(name = "单位性质")
    @AnjiDescription("cWorkdptKind")
    private String cWorkdptKind;

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
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 车主出生年份 */
    @Excel(name = "车主出生年份")
    @AnjiDescription("cYearOfBirth")
    private String cYearOfBirth;

    /** 车主性别 */
    @Excel(name = "车主性别")
    @AnjiDescription("cGendorCde")
    private String cGendorCde;

    /** 驾驶证首发日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "驾驶证首发日期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLicenseDate")
    private Date tLicenseDate;

    /** 车主年龄 */
    @Excel(name = "车主年龄")
    @AnjiDescription("nAge")
    private Long nAge;

    /** 车主驾龄 */
    @Excel(name = "车主驾龄")
    @AnjiDescription("nDrvYears")
    private Long nDrvYears;

    /** 港澳台居民通行证 */
    @Excel(name = "港澳台居民通行证")
    @AnjiDescription("cHmtResidentsPassCde")
    private String cHmtResidentsPassCde;

    /** 行驶证省份 */
    @Excel(name = "行驶证省份")
    @AnjiDescription("cOwnerProvince")
    private String cOwnerProvince;

    /** 行驶证市 */
    @Excel(name = "行驶证市")
    @AnjiDescription("cOwnerCity")
    private String cOwnerCity;

    /** 行驶证县区 */
    @Excel(name = "行驶证县区")
    @AnjiDescription("cOwnerCounty")
    private String cOwnerCounty;

    /** 行驶证详细地址 */
    @Excel(name = "行驶证详细地址")
    @AnjiDescription("cOwnerAddress")
    private String cOwnerAddress;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcOwnerCde(String cOwnerCde)
    {
        this.cOwnerCde = cOwnerCde;
    }

    public String getcOwnerCde()
    {
        return cOwnerCde;
    }
    public void setcOwnerNme(String cOwnerNme)
    {
        this.cOwnerNme = cOwnerNme;
    }

    public String getcOwnerNme()
    {
        return cOwnerNme;
    }
    public void setcOwnerCls(String cOwnerCls)
    {
        this.cOwnerCls = cOwnerCls;
    }

    public String getcOwnerCls()
    {
        return cOwnerCls;
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
    public void setcResidAddr(String cResidAddr)
    {
        this.cResidAddr = cResidAddr;
    }

    public String getcResidAddr()
    {
        return cResidAddr;
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
    public void setcWorkdptKind(String cWorkdptKind)
    {
        this.cWorkdptKind = cWorkdptKind;
    }

    public String getcWorkdptKind()
    {
        return cWorkdptKind;
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
    public void setcYearOfBirth(String cYearOfBirth)
    {
        this.cYearOfBirth = cYearOfBirth;
    }

    public String getcYearOfBirth()
    {
        return cYearOfBirth;
    }
    public void setcGendorCde(String cGendorCde)
    {
        this.cGendorCde = cGendorCde;
    }

    public String getcGendorCde()
    {
        return cGendorCde;
    }
    public void settLicenseDate(Date tLicenseDate)
    {
        this.tLicenseDate = tLicenseDate;
    }

    public Date gettLicenseDate()
    {
        return tLicenseDate;
    }
    public void setnAge(Long nAge)
    {
        this.nAge = nAge;
    }

    public Long getnAge()
    {
        return nAge;
    }
    public void setnDrvYears(Long nDrvYears)
    {
        this.nDrvYears = nDrvYears;
    }

    public Long getnDrvYears()
    {
        return nDrvYears;
    }
    public void setcHmtResidentsPassCde(String cHmtResidentsPassCde)
    {
        this.cHmtResidentsPassCde = cHmtResidentsPassCde;
    }

    public String getcHmtResidentsPassCde()
    {
        return cHmtResidentsPassCde;
    }
    public void setcOwnerProvince(String cOwnerProvince)
    {
        this.cOwnerProvince = cOwnerProvince;
    }

    public String getcOwnerProvince()
    {
        return cOwnerProvince;
    }
    public void setcOwnerCity(String cOwnerCity)
    {
        this.cOwnerCity = cOwnerCity;
    }

    public String getcOwnerCity()
    {
        return cOwnerCity;
    }
    public void setcOwnerCounty(String cOwnerCounty)
    {
        this.cOwnerCounty = cOwnerCounty;
    }

    public String getcOwnerCounty()
    {
        return cOwnerCounty;
    }
    public void setcOwnerAddress(String cOwnerAddress)
    {
        this.cOwnerAddress = cOwnerAddress;
    }

    public String getcOwnerAddress()
    {
        return cOwnerAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cOwnerCde", getcOwnerCde())
            .append("cOwnerNme", getcOwnerNme())
            .append("cOwnerCls", getcOwnerCls())
            .append("cCertfCls", getcCertfCls())
            .append("cCertfCde", getcCertfCde())
            .append("cResidAddr", getcResidAddr())
            .append("cClntAddr", getcClntAddr())
            .append("cZipCde", getcZipCde())
            .append("cWorkdptKind", getcWorkdptKind())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("cResvTxt3", getcResvTxt3())
            .append("tUpdTm", gettUpdTm())
            .append("cUpdCde", getcUpdCde())
            .append("tCrtTm", gettCrtTm())
            .append("cCrtCde", getcCrtCde())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cYearOfBirth", getcYearOfBirth())
            .append("cGendorCde", getcGendorCde())
            .append("tLicenseDate", gettLicenseDate())
            .append("nAge", getnAge())
            .append("nDrvYears", getnDrvYears())
            .append("cHmtResidentsPassCde", getcHmtResidentsPassCde())
            .append("cOwnerProvince", getcOwnerProvince())
            .append("cOwnerCity", getcOwnerCity())
            .append("cOwnerCounty", getcOwnerCounty())
            .append("cOwnerAddress", getcOwnerAddress())
            .toString();
    }
}
