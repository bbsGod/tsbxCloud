package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 申请单费用信息对象 web_app_fee
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppFee extends BaseEntity
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

    /** S：手续费比例
Y1：销售费用
Y4：车险联动
Y6：清零奖励 */
    @Excel(name = "S：手续费比例 Y1：销售费用 Y4：车险联动 Y6：清零奖励")
    @AnjiDescription("cFeetypCde")
    private String cFeetypCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nFeeProp")
    private Long nFeeProp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nFee")
    private Long nFee;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nGotPrm")
    private Long nGotPrm;

    /** 创建人员 */
    @Excel(name = "创建人员")
    @AnjiDescription("cCrtCde")
    private String cCrtCde;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCrtTm")
    private Date tCrtTm;

    /** 修改人员 */
    @Excel(name = "修改人员")
    @AnjiDescription("cUpdCde")
    private String cUpdCde;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
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

    /** 挂帐币种 */
    @Excel(name = "挂帐币种")
    @AnjiDescription("cDueCur")
    private String cDueCur;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nFeeDue")
    private Long nFeeDue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nFeePrmExch")
    private Long nFeePrmExch;

    /** 增值税净价部分 */
    @Excel(name = "增值税净价部分")
    @AnjiDescription("nPrice")
    private Long nPrice;

    /** 增值税费率 */
    @Excel(name = "增值税费率")
    @AnjiDescription("nRate")
    private Long nRate;

    /** 增值税税额 */
    @Excel(name = "增值税税额")
    @AnjiDescription("nTaxAmt")
    private Long nTaxAmt;

    /** 净费费用比例 */
    @Excel(name = "净费费用比例")
    @AnjiDescription("nPrFeeProp")
    private Long nPrFeeProp;

    /** 净费费用金额 */
    @Excel(name = "净费费用金额")
    @AnjiDescription("nPrFee")
    private Long nPrFee;

    /** 净费费用增值税净价 */
    @Excel(name = "净费费用增值税净价")
    @AnjiDescription("nPrPrice")
    private Long nPrPrice;

    /** 净费费用增值税税额 */
    @Excel(name = "净费费用增值税税额")
    @AnjiDescription("nPrTaxAmt")
    private Long nPrTaxAmt;

    /** 不含税金额(结算币种) */
    @Excel(name = "不含税金额(结算币种)")
    @AnjiDescription("nPrFeeDue")
    private Long nPrFeeDue;

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
    public void setcFeetypCde(String cFeetypCde)
    {
        this.cFeetypCde = cFeetypCde;
    }

    public String getcFeetypCde()
    {
        return cFeetypCde;
    }
    public void setnFeeProp(Long nFeeProp)
    {
        this.nFeeProp = nFeeProp;
    }

    public Long getnFeeProp()
    {
        return nFeeProp;
    }
    public void setnFee(Long nFee)
    {
        this.nFee = nFee;
    }

    public Long getnFee()
    {
        return nFee;
    }
    public void setnGotPrm(Long nGotPrm)
    {
        this.nGotPrm = nGotPrm;
    }

    public Long getnGotPrm()
    {
        return nGotPrm;
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
    public void setcDueCur(String cDueCur)
    {
        this.cDueCur = cDueCur;
    }

    public String getcDueCur()
    {
        return cDueCur;
    }
    public void setnFeeDue(Long nFeeDue)
    {
        this.nFeeDue = nFeeDue;
    }

    public Long getnFeeDue()
    {
        return nFeeDue;
    }
    public void setnFeePrmExch(Long nFeePrmExch)
    {
        this.nFeePrmExch = nFeePrmExch;
    }

    public Long getnFeePrmExch()
    {
        return nFeePrmExch;
    }
    public void setnPrice(Long nPrice)
    {
        this.nPrice = nPrice;
    }

    public Long getnPrice()
    {
        return nPrice;
    }
    public void setnRate(Long nRate)
    {
        this.nRate = nRate;
    }

    public Long getnRate()
    {
        return nRate;
    }
    public void setnTaxAmt(Long nTaxAmt)
    {
        this.nTaxAmt = nTaxAmt;
    }

    public Long getnTaxAmt()
    {
        return nTaxAmt;
    }
    public void setnPrFeeProp(Long nPrFeeProp)
    {
        this.nPrFeeProp = nPrFeeProp;
    }

    public Long getnPrFeeProp()
    {
        return nPrFeeProp;
    }
    public void setnPrFee(Long nPrFee)
    {
        this.nPrFee = nPrFee;
    }

    public Long getnPrFee()
    {
        return nPrFee;
    }
    public void setnPrPrice(Long nPrPrice)
    {
        this.nPrPrice = nPrPrice;
    }

    public Long getnPrPrice()
    {
        return nPrPrice;
    }
    public void setnPrTaxAmt(Long nPrTaxAmt)
    {
        this.nPrTaxAmt = nPrTaxAmt;
    }

    public Long getnPrTaxAmt()
    {
        return nPrTaxAmt;
    }
    public void setnPrFeeDue(Long nPrFeeDue)
    {
        this.nPrFeeDue = nPrFeeDue;
    }

    public Long getnPrFeeDue()
    {
        return nPrFeeDue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cPkId", getcPkId())
            .append("cAppNo", getcAppNo())
            .append("cRowId", getcRowId())
            .append("cFeetypCde", getcFeetypCde())
            .append("nFeeProp", getnFeeProp())
            .append("nFee", getnFee())
            .append("nGotPrm", getnGotPrm())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cDueCur", getcDueCur())
            .append("nFeeDue", getnFeeDue())
            .append("nFeePrmExch", getnFeePrmExch())
            .append("nPrice", getnPrice())
            .append("nRate", getnRate())
            .append("nTaxAmt", getnTaxAmt())
            .append("nPrFeeProp", getnPrFeeProp())
            .append("nPrFee", getnPrFee())
            .append("nPrPrice", getnPrPrice())
            .append("nPrTaxAmt", getnPrTaxAmt())
            .append("nPrFeeDue", getnPrFeeDue())
            .toString();
    }
}
