package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 申请单账户信息对象 web_app_acctinfo
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppAcctinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请单号 */
    private String cAppNo;

    /** 特别约定代码 */
    @Excel(name = "特别约定代码")
    @AnjiDescription("cAcctNme")
    private String cAcctNme;

    /** 中文名 */
    @Excel(name = "中文名")
    @AnjiDescription("cAcctNo")
    private String cAcctNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cBankRelCde")
    private String cBankRelCde;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cBankPro")
    private String cBankPro;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cBankArea")
    private String cBankArea;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cBankCde")
    private String cBankCde;

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
    @AnjiDescription("cTransMrk")
    private String cTransMrk;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTransTm")
    private Date tTransTm;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcAcctNme(String cAcctNme)
    {
        this.cAcctNme = cAcctNme;
    }

    public String getcAcctNme()
    {
        return cAcctNme;
    }
    public void setcAcctNo(String cAcctNo)
    {
        this.cAcctNo = cAcctNo;
    }

    public String getcAcctNo()
    {
        return cAcctNo;
    }
    public void setcBankRelCde(String cBankRelCde)
    {
        this.cBankRelCde = cBankRelCde;
    }

    public String getcBankRelCde()
    {
        return cBankRelCde;
    }
    public void setcBankPro(String cBankPro)
    {
        this.cBankPro = cBankPro;
    }

    public String getcBankPro()
    {
        return cBankPro;
    }
    public void setcBankArea(String cBankArea)
    {
        this.cBankArea = cBankArea;
    }

    public String getcBankArea()
    {
        return cBankArea;
    }
    public void setcBankCde(String cBankCde)
    {
        this.cBankCde = cBankCde;
    }

    public String getcBankCde()
    {
        return cBankCde;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cAcctNme", getcAcctNme())
            .append("cAcctNo", getcAcctNo())
            .append("cBankRelCde", getcBankRelCde())
            .append("cBankPro", getcBankPro())
            .append("cBankArea", getcBankArea())
            .append("cBankCde", getcBankCde())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .toString();
    }
}
