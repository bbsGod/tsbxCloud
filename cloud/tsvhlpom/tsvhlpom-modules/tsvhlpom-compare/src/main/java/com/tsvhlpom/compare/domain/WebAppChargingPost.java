package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 web_app_charging_post
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppChargingPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    @AnjiDescription("cPkId")
    private String cPkId;

    /** 投保单号 */
    @Excel(name = "投保单号")
    @AnjiDescription("cAppNo")
    private String cAppNo;

    /** 保单号 */
    @Excel(name = "保单号")
    @AnjiDescription("cPlyNo")
    private String cPlyNo;

    /** 序号 */
    @Excel(name = "序号")
    @AnjiDescription("nSeqNo")
    private Long nSeqNo;

    /** 充电桩型号 */
    @Excel(name = "充电桩型号")
    @AnjiDescription("cChargingPostModel")
    private String cChargingPostModel;

    /** 充电桩编码 */
    @Excel(name = "充电桩编码")
    @AnjiDescription("cChargingPostCod")
    private String cChargingPostCod;

    /** 充电桩种类 */
    @Excel(name = "充电桩种类")
    @AnjiDescription("cChargingPostKind")
    private String cChargingPostKind;

    /** 安装地点 */
    @Excel(name = "安装地点")
    @AnjiDescription("cChargingPostPlace")
    private String cChargingPostPlace;

    /** 安装时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("cChargingPostTime")
    private Date cChargingPostTime;

    /** 省 */
    @Excel(name = "省")
    @AnjiDescription("cProvince")
    private String cProvince;

    /** 市 */
    @Excel(name = "市")
    @AnjiDescription("cCity")
    private String cCity;

    /** 乡 */
    @Excel(name = "乡")
    @AnjiDescription("cCounty")
    private String cCounty;

    /** 详细地址 */
    @Excel(name = "详细地址")
    @AnjiDescription("cDetailedAddr")
    private String cDetailedAddr;

    /** 责任险保额 */
    @Excel(name = "责任险保额")
    @AnjiDescription("nLiabAmt")
    private Long nLiabAmt;

    /** 责任险保费 */
    @Excel(name = "责任险保费")
    @AnjiDescription("nLiabPrm")
    private Long nLiabPrm;

    /** 充电桩使用年限 */
    @Excel(name = "充电桩使用年限")
    @AnjiDescription("cChargingPostYearLimit")
    private String cChargingPostYearLimit;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tUpdTm")
    private Date tUpdTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    /** 责任险 */
    @Excel(name = "责任险")
    @AnjiDescription("cChargingPostLiabInsur")
    private String cChargingPostLiabInsur;

    /** 损失险 */
    @Excel(name = "损失险")
    @AnjiDescription("cChargingPostLossInsur")
    private String cChargingPostLossInsur;

    /** 责任险费率 */
    @Excel(name = "责任险费率")
    @AnjiDescription("nLiabRate")
    private Long nLiabRate;

    /** 责任险基本保费 */
    @Excel(name = "责任险基本保费")
    @AnjiDescription("nLiabBasePrm")
    private Long nLiabBasePrm;

    /** 责任险折前保费 */
    @Excel(name = "责任险折前保费")
    @AnjiDescription("nLiabBefPrm")
    private Long nLiabBefPrm;

    /** 责任险优惠系数 */
    @Excel(name = "责任险优惠系数")
    @AnjiDescription("nLiabDisCoef")
    private Long nLiabDisCoef;

    /** 责任险计算保费 */
    @Excel(name = "责任险计算保费")
    @AnjiDescription("nLiabCalcPrm")
    private Long nLiabCalcPrm;

    /** 责任险年折前保费 */
    @Excel(name = "责任险年折前保费")
    @AnjiDescription("nLiabBefAnnPrm")
    private Long nLiabBefAnnPrm;

    /** 责任险年计算保费 */
    @Excel(name = "责任险年计算保费")
    @AnjiDescription("nLiabCalcAnnPrm")
    private Long nLiabCalcAnnPrm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nLiabAmtVar")
    private Long nLiabAmtVar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nLiabPrmVar")
    private Long nLiabPrmVar;

    /** 责任险计算保费 */
    @Excel(name = "责任险计算保费")
    @AnjiDescription("nLiabCalcPrmVar")
    private Long nLiabCalcPrmVar;

    /** 自主定价系数 */
    @Excel(name = "自主定价系数")
    @AnjiDescription("nResvNum6")
    private Long nResvNum6;

    /** 损失险保额 */
    @Excel(name = "损失险保额")
    @AnjiDescription("nLossAmt")
    private Long nLossAmt;

    /** 损失险保费 */
    @Excel(name = "损失险保费")
    @AnjiDescription("nLossPrm")
    private Long nLossPrm;

    /** 损失险费率 */
    @Excel(name = "损失险费率")
    @AnjiDescription("nLossRate")
    private Long nLossRate;

    /** 损失险基本保费 */
    @Excel(name = "损失险基本保费")
    @AnjiDescription("nLossBasePrm")
    private Long nLossBasePrm;

    /** 损失险折前保费 */
    @Excel(name = "损失险折前保费")
    @AnjiDescription("nLossBefPrm")
    private Long nLossBefPrm;

    /** 损失险优惠系数 */
    @Excel(name = "损失险优惠系数")
    @AnjiDescription("nLossDisCoef")
    private Long nLossDisCoef;

    /** 损失险计算保费 */
    @Excel(name = "损失险计算保费")
    @AnjiDescription("nLossCalcPrm")
    private Long nLossCalcPrm;

    /** 损失险年折前保费 */
    @Excel(name = "损失险年折前保费")
    @AnjiDescription("nLossBefAnnPrm")
    private Long nLossBefAnnPrm;

    /** 损失险年计算保费 */
    @Excel(name = "损失险年计算保费")
    @AnjiDescription("nLossCalcAnnPrm")
    private Long nLossCalcAnnPrm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nLossAmtVar")
    private Long nLossAmtVar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nLossPrmVar")
    private Long nLossPrmVar;

    /** 损失险计算保费 */
    @Excel(name = "损失险计算保费")
    @AnjiDescription("nLossCalcPrmVar")
    private Long nLossCalcPrmVar;

    /** 损失险退保标识 */
    @Excel(name = "损失险退保标识")
    @AnjiDescription("cLossCancelMrk")
    private String cLossCancelMrk;

    /** 责任险退保标识 */
    @Excel(name = "责任险退保标识")
    @AnjiDescription("cLiabCancelMrk")
    private String cLiabCancelMrk;

    /** 损失险保险起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "损失险保险起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLossBgnTm")
    private Date tLossBgnTm;

    /** 损失险保险止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "损失险保险止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLossEndTm")
    private Date tLossEndTm;

    /** 责任险保险起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "责任险保险起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLiabBgnTm")
    private Date tLiabBgnTm;

    /** 责任险保险止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "责任险保险止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tLiabEndTm")
    private Date tLiabEndTm;

    /** 责任险限额档次 */
    @Excel(name = "责任险限额档次")
    @AnjiDescription("cLiabIndemLmtLvl")
    private String cLiabIndemLmtLvl;

    /** 损失险限额档次 */
    @Excel(name = "损失险限额档次")
    @AnjiDescription("cLossIndemLmtLvl")
    private String cLossIndemLmtLvl;

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
    public void setcPlyNo(String cPlyNo)
    {
        this.cPlyNo = cPlyNo;
    }

    public String getcPlyNo()
    {
        return cPlyNo;
    }
    public void setnSeqNo(Long nSeqNo)
    {
        this.nSeqNo = nSeqNo;
    }

    public Long getnSeqNo()
    {
        return nSeqNo;
    }
    public void setcChargingPostModel(String cChargingPostModel)
    {
        this.cChargingPostModel = cChargingPostModel;
    }

    public String getcChargingPostModel()
    {
        return cChargingPostModel;
    }
    public void setcChargingPostCod(String cChargingPostCod)
    {
        this.cChargingPostCod = cChargingPostCod;
    }

    public String getcChargingPostCod()
    {
        return cChargingPostCod;
    }
    public void setcChargingPostKind(String cChargingPostKind)
    {
        this.cChargingPostKind = cChargingPostKind;
    }

    public String getcChargingPostKind()
    {
        return cChargingPostKind;
    }
    public void setcChargingPostPlace(String cChargingPostPlace)
    {
        this.cChargingPostPlace = cChargingPostPlace;
    }

    public String getcChargingPostPlace()
    {
        return cChargingPostPlace;
    }
    public void setcChargingPostTime(Date cChargingPostTime)
    {
        this.cChargingPostTime = cChargingPostTime;
    }

    public Date getcChargingPostTime()
    {
        return cChargingPostTime;
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
    public void setcDetailedAddr(String cDetailedAddr)
    {
        this.cDetailedAddr = cDetailedAddr;
    }

    public String getcDetailedAddr()
    {
        return cDetailedAddr;
    }
    public void setnLiabAmt(Long nLiabAmt)
    {
        this.nLiabAmt = nLiabAmt;
    }

    public Long getnLiabAmt()
    {
        return nLiabAmt;
    }
    public void setnLiabPrm(Long nLiabPrm)
    {
        this.nLiabPrm = nLiabPrm;
    }

    public Long getnLiabPrm()
    {
        return nLiabPrm;
    }
    public void setcChargingPostYearLimit(String cChargingPostYearLimit)
    {
        this.cChargingPostYearLimit = cChargingPostYearLimit;
    }

    public String getcChargingPostYearLimit()
    {
        return cChargingPostYearLimit;
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
    public void setcCrtCde(String cCrtCde)
    {
        this.cCrtCde = cCrtCde;
    }

    public String getcCrtCde()
    {
        return cCrtCde;
    }
    public void settUpdTm(Date tUpdTm)
    {
        this.tUpdTm = tUpdTm;
    }

    public Date gettUpdTm()
    {
        return tUpdTm;
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
    public void setcChargingPostLiabInsur(String cChargingPostLiabInsur)
    {
        this.cChargingPostLiabInsur = cChargingPostLiabInsur;
    }

    public String getcChargingPostLiabInsur()
    {
        return cChargingPostLiabInsur;
    }
    public void setcChargingPostLossInsur(String cChargingPostLossInsur)
    {
        this.cChargingPostLossInsur = cChargingPostLossInsur;
    }

    public String getcChargingPostLossInsur()
    {
        return cChargingPostLossInsur;
    }
    public void setnLiabRate(Long nLiabRate)
    {
        this.nLiabRate = nLiabRate;
    }

    public Long getnLiabRate()
    {
        return nLiabRate;
    }
    public void setnLiabBasePrm(Long nLiabBasePrm)
    {
        this.nLiabBasePrm = nLiabBasePrm;
    }

    public Long getnLiabBasePrm()
    {
        return nLiabBasePrm;
    }
    public void setnLiabBefPrm(Long nLiabBefPrm)
    {
        this.nLiabBefPrm = nLiabBefPrm;
    }

    public Long getnLiabBefPrm()
    {
        return nLiabBefPrm;
    }
    public void setnLiabDisCoef(Long nLiabDisCoef)
    {
        this.nLiabDisCoef = nLiabDisCoef;
    }

    public Long getnLiabDisCoef()
    {
        return nLiabDisCoef;
    }
    public void setnLiabCalcPrm(Long nLiabCalcPrm)
    {
        this.nLiabCalcPrm = nLiabCalcPrm;
    }

    public Long getnLiabCalcPrm()
    {
        return nLiabCalcPrm;
    }
    public void setnLiabBefAnnPrm(Long nLiabBefAnnPrm)
    {
        this.nLiabBefAnnPrm = nLiabBefAnnPrm;
    }

    public Long getnLiabBefAnnPrm()
    {
        return nLiabBefAnnPrm;
    }
    public void setnLiabCalcAnnPrm(Long nLiabCalcAnnPrm)
    {
        this.nLiabCalcAnnPrm = nLiabCalcAnnPrm;
    }

    public Long getnLiabCalcAnnPrm()
    {
        return nLiabCalcAnnPrm;
    }
    public void setnLiabAmtVar(Long nLiabAmtVar)
    {
        this.nLiabAmtVar = nLiabAmtVar;
    }

    public Long getnLiabAmtVar()
    {
        return nLiabAmtVar;
    }
    public void setnLiabPrmVar(Long nLiabPrmVar)
    {
        this.nLiabPrmVar = nLiabPrmVar;
    }

    public Long getnLiabPrmVar()
    {
        return nLiabPrmVar;
    }
    public void setnLiabCalcPrmVar(Long nLiabCalcPrmVar)
    {
        this.nLiabCalcPrmVar = nLiabCalcPrmVar;
    }

    public Long getnLiabCalcPrmVar()
    {
        return nLiabCalcPrmVar;
    }
    public void setnResvNum6(Long nResvNum6)
    {
        this.nResvNum6 = nResvNum6;
    }

    public Long getnResvNum6()
    {
        return nResvNum6;
    }
    public void setnLossAmt(Long nLossAmt)
    {
        this.nLossAmt = nLossAmt;
    }

    public Long getnLossAmt()
    {
        return nLossAmt;
    }
    public void setnLossPrm(Long nLossPrm)
    {
        this.nLossPrm = nLossPrm;
    }

    public Long getnLossPrm()
    {
        return nLossPrm;
    }
    public void setnLossRate(Long nLossRate)
    {
        this.nLossRate = nLossRate;
    }

    public Long getnLossRate()
    {
        return nLossRate;
    }
    public void setnLossBasePrm(Long nLossBasePrm)
    {
        this.nLossBasePrm = nLossBasePrm;
    }

    public Long getnLossBasePrm()
    {
        return nLossBasePrm;
    }
    public void setnLossBefPrm(Long nLossBefPrm)
    {
        this.nLossBefPrm = nLossBefPrm;
    }

    public Long getnLossBefPrm()
    {
        return nLossBefPrm;
    }
    public void setnLossDisCoef(Long nLossDisCoef)
    {
        this.nLossDisCoef = nLossDisCoef;
    }

    public Long getnLossDisCoef()
    {
        return nLossDisCoef;
    }
    public void setnLossCalcPrm(Long nLossCalcPrm)
    {
        this.nLossCalcPrm = nLossCalcPrm;
    }

    public Long getnLossCalcPrm()
    {
        return nLossCalcPrm;
    }
    public void setnLossBefAnnPrm(Long nLossBefAnnPrm)
    {
        this.nLossBefAnnPrm = nLossBefAnnPrm;
    }

    public Long getnLossBefAnnPrm()
    {
        return nLossBefAnnPrm;
    }
    public void setnLossCalcAnnPrm(Long nLossCalcAnnPrm)
    {
        this.nLossCalcAnnPrm = nLossCalcAnnPrm;
    }

    public Long getnLossCalcAnnPrm()
    {
        return nLossCalcAnnPrm;
    }
    public void setnLossAmtVar(Long nLossAmtVar)
    {
        this.nLossAmtVar = nLossAmtVar;
    }

    public Long getnLossAmtVar()
    {
        return nLossAmtVar;
    }
    public void setnLossPrmVar(Long nLossPrmVar)
    {
        this.nLossPrmVar = nLossPrmVar;
    }

    public Long getnLossPrmVar()
    {
        return nLossPrmVar;
    }
    public void setnLossCalcPrmVar(Long nLossCalcPrmVar)
    {
        this.nLossCalcPrmVar = nLossCalcPrmVar;
    }

    public Long getnLossCalcPrmVar()
    {
        return nLossCalcPrmVar;
    }
    public void setcLossCancelMrk(String cLossCancelMrk)
    {
        this.cLossCancelMrk = cLossCancelMrk;
    }

    public String getcLossCancelMrk()
    {
        return cLossCancelMrk;
    }
    public void setcLiabCancelMrk(String cLiabCancelMrk)
    {
        this.cLiabCancelMrk = cLiabCancelMrk;
    }

    public String getcLiabCancelMrk()
    {
        return cLiabCancelMrk;
    }
    public void settLossBgnTm(Date tLossBgnTm)
    {
        this.tLossBgnTm = tLossBgnTm;
    }

    public Date gettLossBgnTm()
    {
        return tLossBgnTm;
    }
    public void settLossEndTm(Date tLossEndTm)
    {
        this.tLossEndTm = tLossEndTm;
    }

    public Date gettLossEndTm()
    {
        return tLossEndTm;
    }
    public void settLiabBgnTm(Date tLiabBgnTm)
    {
        this.tLiabBgnTm = tLiabBgnTm;
    }

    public Date gettLiabBgnTm()
    {
        return tLiabBgnTm;
    }
    public void settLiabEndTm(Date tLiabEndTm)
    {
        this.tLiabEndTm = tLiabEndTm;
    }

    public Date gettLiabEndTm()
    {
        return tLiabEndTm;
    }
    public void setcLiabIndemLmtLvl(String cLiabIndemLmtLvl)
    {
        this.cLiabIndemLmtLvl = cLiabIndemLmtLvl;
    }

    public String getcLiabIndemLmtLvl()
    {
        return cLiabIndemLmtLvl;
    }
    public void setcLossIndemLmtLvl(String cLossIndemLmtLvl)
    {
        this.cLossIndemLmtLvl = cLossIndemLmtLvl;
    }

    public String getcLossIndemLmtLvl()
    {
        return cLossIndemLmtLvl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cPkId", getcPkId())
            .append("cAppNo", getcAppNo())
            .append("cPlyNo", getcPlyNo())
            .append("nSeqNo", getnSeqNo())
            .append("cChargingPostModel", getcChargingPostModel())
            .append("cChargingPostCod", getcChargingPostCod())
            .append("cChargingPostKind", getcChargingPostKind())
            .append("cChargingPostPlace", getcChargingPostPlace())
            .append("cChargingPostTime", getcChargingPostTime())
            .append("cProvince", getcProvince())
            .append("cCity", getcCity())
            .append("cCounty", getcCounty())
            .append("cDetailedAddr", getcDetailedAddr())
            .append("nLiabAmt", getnLiabAmt())
            .append("nLiabPrm", getnLiabPrm())
            .append("cChargingPostYearLimit", getcChargingPostYearLimit())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("cCrtCde", getcCrtCde())
            .append("tUpdTm", gettUpdTm())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cChargingPostLiabInsur", getcChargingPostLiabInsur())
            .append("cChargingPostLossInsur", getcChargingPostLossInsur())
            .append("nLiabRate", getnLiabRate())
            .append("nLiabBasePrm", getnLiabBasePrm())
            .append("nLiabBefPrm", getnLiabBefPrm())
            .append("nLiabDisCoef", getnLiabDisCoef())
            .append("nLiabCalcPrm", getnLiabCalcPrm())
            .append("nLiabBefAnnPrm", getnLiabBefAnnPrm())
            .append("nLiabCalcAnnPrm", getnLiabCalcAnnPrm())
            .append("nLiabAmtVar", getnLiabAmtVar())
            .append("nLiabPrmVar", getnLiabPrmVar())
            .append("nLiabCalcPrmVar", getnLiabCalcPrmVar())
            .append("nResvNum6", getnResvNum6())
            .append("nLossAmt", getnLossAmt())
            .append("nLossPrm", getnLossPrm())
            .append("nLossRate", getnLossRate())
            .append("nLossBasePrm", getnLossBasePrm())
            .append("nLossBefPrm", getnLossBefPrm())
            .append("nLossDisCoef", getnLossDisCoef())
            .append("nLossCalcPrm", getnLossCalcPrm())
            .append("nLossBefAnnPrm", getnLossBefAnnPrm())
            .append("nLossCalcAnnPrm", getnLossCalcAnnPrm())
            .append("nLossAmtVar", getnLossAmtVar())
            .append("nLossPrmVar", getnLossPrmVar())
            .append("nLossCalcPrmVar", getnLossCalcPrmVar())
            .append("cLossCancelMrk", getcLossCancelMrk())
            .append("cLiabCancelMrk", getcLiabCancelMrk())
            .append("tLossBgnTm", gettLossBgnTm())
            .append("tLossEndTm", gettLossEndTm())
            .append("tLiabBgnTm", gettLiabBgnTm())
            .append("tLiabEndTm", gettLiabEndTm())
            .append("cLiabIndemLmtLvl", getcLiabIndemLmtLvl())
            .append("cLossIndemLmtLvl", getcLossIndemLmtLvl())
            .toString();
    }
}
