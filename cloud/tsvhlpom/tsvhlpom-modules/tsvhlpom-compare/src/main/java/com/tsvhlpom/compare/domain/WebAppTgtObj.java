package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 web_app_tgt_obj
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppTgtObj extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    //@AnjiDescription("cPkId")
    private String cPkId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    //@AnjiDescription("cAppNo")
    private String cAppNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cRowId")
    private String cRowId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nSeqNo")
    private Long nSeqNo;

    /** 组别 */
    @Excel(name = "组别")
    @AnjiDescription("cTgtObjTxtFld1")
    private String cTgtObjTxtFld1;

    /** 分户编号 */
    @Excel(name = "分户编号")
    @AnjiDescription("cTgtObjTxtFld2")
    private String cTgtObjTxtFld2;

    /** 农户姓名 */
    @Excel(name = "农户姓名")
    @AnjiDescription("cTgtObjTxtFld3")
    private String cTgtObjTxtFld3;

    /** 证件号码 */
    @Excel(name = "证件号码")
    @AnjiDescription("cTgtObjTxtFld4")
    private String cTgtObjTxtFld4;

    /** 银行账号/一卡通号码 */
    @Excel(name = "银行账号/一卡通号码")
    @AnjiDescription("cTgtObjTxtFld5")
    private String cTgtObjTxtFld5;

    /** 联系方式(电话号码) */
    @Excel(name = "联系方式(电话号码)")
    @AnjiDescription("cTgtObjTxtFld6")
    private String cTgtObjTxtFld6;

    /** 地块编号 */
    @Excel(name = "地块编号")
    @AnjiDescription("cTgtObjTxtFld7")
    private String cTgtObjTxtFld7;

    /** 地块名称 */
    @Excel(name = "地块名称")
    @AnjiDescription("cTgtObjTxtFld8")
    private String cTgtObjTxtFld8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld9")
    private String cTgtObjTxtFld9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld10")
    private String cTgtObjTxtFld10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld11")
    private String cTgtObjTxtFld11;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld12")
    private String cTgtObjTxtFld12;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld13")
    private String cTgtObjTxtFld13;

    /** 银行名称 */
    @Excel(name = "银行名称")
    @AnjiDescription("cTgtObjTxtFld14")
    private String cTgtObjTxtFld14;

    /** 开户行 */
    @Excel(name = "开户行")
    @AnjiDescription("cTgtObjTxtFld15")
    private String cTgtObjTxtFld15;

    /** 身份证有效期 */
    @Excel(name = "身份证有效期")
    @AnjiDescription("cTgtObjTxtFld16")
    private String cTgtObjTxtFld16;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld17")
    private String cTgtObjTxtFld17;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld18")
    private String cTgtObjTxtFld18;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld19")
    private String cTgtObjTxtFld19;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld20")
    private String cTgtObjTxtFld20;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTgtObjTmFld1")
    private Date tTgtObjTmFld1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTgtObjTmFld2")
    private Date tTgtObjTmFld2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTgtObjTmFld3")
    private Date tTgtObjTmFld3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTgtObjTmFld4")
    private Date tTgtObjTmFld4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("tTgtObjTmFld5")
    private Date tTgtObjTmFld5;

    /** 地块投保面积 */
    @Excel(name = "地块投保面积")
    @AnjiDescription("nTgtObjNumFld1")
    private Long nTgtObjNumFld1;

    /** 总投保面积 */
    @Excel(name = "总投保面积")
    @AnjiDescription("nTgtObjNumFld2")
    private Long nTgtObjNumFld2;

    /** 农民自交保费 */
    @Excel(name = "农民自交保费")
    @AnjiDescription("nTgtObjNumFld3")
    private Long nTgtObjNumFld3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld4")
    private Long nTgtObjNumFld4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld5")
    private Long nTgtObjNumFld5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld6")
    private Long nTgtObjNumFld6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld7")
    private Long nTgtObjNumFld7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld8")
    private Long nTgtObjNumFld8;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld9")
    private Long nTgtObjNumFld9;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nTgtObjNumFld10")
    private Long nTgtObjNumFld10;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("lTgtObjLtxtFld1")
    private String lTgtObjLtxtFld1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("lTgtObjLtxtFld2")
    private String lTgtObjLtxtFld2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("lTgtObjLtxtFld3")
    private String lTgtObjLtxtFld3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("lTgtObjLtxtFld4")
    private String lTgtObjLtxtFld4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("lTgtObjLtxtFld5")
    private String lTgtObjLtxtFld5;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cCancelMark")
    private String cCancelMark;

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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld21")
    private String cTgtObjTxtFld21;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld22")
    private String cTgtObjTxtFld22;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld23")
    private String cTgtObjTxtFld23;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld24")
    private String cTgtObjTxtFld24;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld25")
    private String cTgtObjTxtFld25;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld26")
    private String cTgtObjTxtFld26;

    /** 性别 */
    @Excel(name = "性别")
    @AnjiDescription("cTgtObjTxtFld27")
    private String cTgtObjTxtFld27;

    /** 农户反馈验证码 */
    @Excel(name = "农户反馈验证码")
    @AnjiDescription("cTgtObjTxtFld28")
    private String cTgtObjTxtFld28;

    /** 平台返回验证码 */
    @Excel(name = "平台返回验证码")
    @AnjiDescription("cTgtObjTxtFld29")
    private String cTgtObjTxtFld29;

    /** 公示编码 */
    @Excel(name = "公示编码")
    @AnjiDescription("cTgtObjTxtFld30")
    private String cTgtObjTxtFld30;

    /** 证件类型 */
    @Excel(name = "证件类型")
    @AnjiDescription("cCertfCls")
    private String cCertfCls;

    /** 机构农户标志，1-是 */
    @Excel(name = "机构农户标志，1-是")
    @AnjiDescription("cFarmerIsOrg")
    private String cFarmerIsOrg;

    /** 农业用地分类 */
    @Excel(name = "农业用地分类")
    @AnjiDescription("cLandParcelType")
    private String cLandParcelType;

    /** 经度起始值 */
    @Excel(name = "经度起始值")
    @AnjiDescription("cStartLongitude")
    private String cStartLongitude;

    /** 经度终止值 */
    @Excel(name = "经度终止值")
    @AnjiDescription("cEndLongitude")
    private String cEndLongitude;

    /** 纬度起始值 */
    @Excel(name = "纬度起始值")
    @AnjiDescription("cStartLatitude")
    private String cStartLatitude;

    /** 纬度终止值 */
    @Excel(name = "纬度终止值")
    @AnjiDescription("cEndLatitude")
    private String cEndLatitude;

    /** 林班号 */
    @Excel(name = "林班号")
    @AnjiDescription("cCompartmentNo")
    private String cCompartmentNo;

    /** 小班号 */
    @Excel(name = "小班号")
    @AnjiDescription("cSmallCompartmentNo")
    private String cSmallCompartmentNo;

    /** 证件有效起期 */
    @Excel(name = "证件有效起期")
    @AnjiDescription("cCertfBgnTm")
    private String cCertfBgnTm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld31")
    private String cTgtObjTxtFld31;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld32")
    private String cTgtObjTxtFld32;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("cTgtObjTxtFld33")
    private String cTgtObjTxtFld33;

    /** 证件有效期限是否为长期，0 否，1 是 */
    @Excel(name = "证件有效期限是否为长期，0 否，1 是")
    @AnjiDescription("cPerpetual")
    private String cPerpetual;

    /** 申报产品单价 */
    @Excel(name = "申报产品单价")
    @AnjiDescription("nTgtObjNumFld11")
    private Long nTgtObjNumFld11;

    /** 东至 */
    @Excel(name = "东至")
    @AnjiDescription("cEastLocation")
    private String cEastLocation;

    /** 西至 */
    @Excel(name = "西至")
    @AnjiDescription("cWestLocation")
    private String cWestLocation;

    /** 南至 */
    @Excel(name = "南至")
    @AnjiDescription("cSouthLocation")
    private String cSouthLocation;

    /** 北至 */
    @Excel(name = "北至")
    @AnjiDescription("cNorthLocation")
    private String cNorthLocation;

    /** 直系亲属姓名 */
    @Excel(name = "直系亲属姓名")
    @AnjiDescription("cRelateName")
    private String cRelateName;

    /** 直系亲属证件类型 */
    @Excel(name = "直系亲属证件类型")
    @AnjiDescription("cRelateCls")
    private String cRelateCls;

    /** 直系亲属证件号码 */
    @Excel(name = "直系亲属证件号码")
    @AnjiDescription("cRelateCert")
    private String cRelateCert;

    /** 直系亲属联系方式 */
    @Excel(name = "直系亲属联系方式")
    @AnjiDescription("cRelateContact")
    private String cRelateContact;

    /** 直系亲属关系 */
    @Excel(name = "直系亲属关系")
    @AnjiDescription("cRelation")
    private String cRelation;

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
    public void setcTgtObjTxtFld1(String cTgtObjTxtFld1)
    {
        this.cTgtObjTxtFld1 = cTgtObjTxtFld1;
    }

    public String getcTgtObjTxtFld1()
    {
        return cTgtObjTxtFld1;
    }
    public void setcTgtObjTxtFld2(String cTgtObjTxtFld2)
    {
        this.cTgtObjTxtFld2 = cTgtObjTxtFld2;
    }

    public String getcTgtObjTxtFld2()
    {
        return cTgtObjTxtFld2;
    }
    public void setcTgtObjTxtFld3(String cTgtObjTxtFld3)
    {
        this.cTgtObjTxtFld3 = cTgtObjTxtFld3;
    }

    public String getcTgtObjTxtFld3()
    {
        return cTgtObjTxtFld3;
    }
    public void setcTgtObjTxtFld4(String cTgtObjTxtFld4)
    {
        this.cTgtObjTxtFld4 = cTgtObjTxtFld4;
    }

    public String getcTgtObjTxtFld4()
    {
        return cTgtObjTxtFld4;
    }
    public void setcTgtObjTxtFld5(String cTgtObjTxtFld5)
    {
        this.cTgtObjTxtFld5 = cTgtObjTxtFld5;
    }

    public String getcTgtObjTxtFld5()
    {
        return cTgtObjTxtFld5;
    }
    public void setcTgtObjTxtFld6(String cTgtObjTxtFld6)
    {
        this.cTgtObjTxtFld6 = cTgtObjTxtFld6;
    }

    public String getcTgtObjTxtFld6()
    {
        return cTgtObjTxtFld6;
    }
    public void setcTgtObjTxtFld7(String cTgtObjTxtFld7)
    {
        this.cTgtObjTxtFld7 = cTgtObjTxtFld7;
    }

    public String getcTgtObjTxtFld7()
    {
        return cTgtObjTxtFld7;
    }
    public void setcTgtObjTxtFld8(String cTgtObjTxtFld8)
    {
        this.cTgtObjTxtFld8 = cTgtObjTxtFld8;
    }

    public String getcTgtObjTxtFld8()
    {
        return cTgtObjTxtFld8;
    }
    public void setcTgtObjTxtFld9(String cTgtObjTxtFld9)
    {
        this.cTgtObjTxtFld9 = cTgtObjTxtFld9;
    }

    public String getcTgtObjTxtFld9()
    {
        return cTgtObjTxtFld9;
    }
    public void setcTgtObjTxtFld10(String cTgtObjTxtFld10)
    {
        this.cTgtObjTxtFld10 = cTgtObjTxtFld10;
    }

    public String getcTgtObjTxtFld10()
    {
        return cTgtObjTxtFld10;
    }
    public void setcTgtObjTxtFld11(String cTgtObjTxtFld11)
    {
        this.cTgtObjTxtFld11 = cTgtObjTxtFld11;
    }

    public String getcTgtObjTxtFld11()
    {
        return cTgtObjTxtFld11;
    }
    public void setcTgtObjTxtFld12(String cTgtObjTxtFld12)
    {
        this.cTgtObjTxtFld12 = cTgtObjTxtFld12;
    }

    public String getcTgtObjTxtFld12()
    {
        return cTgtObjTxtFld12;
    }
    public void setcTgtObjTxtFld13(String cTgtObjTxtFld13)
    {
        this.cTgtObjTxtFld13 = cTgtObjTxtFld13;
    }

    public String getcTgtObjTxtFld13()
    {
        return cTgtObjTxtFld13;
    }
    public void setcTgtObjTxtFld14(String cTgtObjTxtFld14)
    {
        this.cTgtObjTxtFld14 = cTgtObjTxtFld14;
    }

    public String getcTgtObjTxtFld14()
    {
        return cTgtObjTxtFld14;
    }
    public void setcTgtObjTxtFld15(String cTgtObjTxtFld15)
    {
        this.cTgtObjTxtFld15 = cTgtObjTxtFld15;
    }

    public String getcTgtObjTxtFld15()
    {
        return cTgtObjTxtFld15;
    }
    public void setcTgtObjTxtFld16(String cTgtObjTxtFld16)
    {
        this.cTgtObjTxtFld16 = cTgtObjTxtFld16;
    }

    public String getcTgtObjTxtFld16()
    {
        return cTgtObjTxtFld16;
    }
    public void setcTgtObjTxtFld17(String cTgtObjTxtFld17)
    {
        this.cTgtObjTxtFld17 = cTgtObjTxtFld17;
    }

    public String getcTgtObjTxtFld17()
    {
        return cTgtObjTxtFld17;
    }
    public void setcTgtObjTxtFld18(String cTgtObjTxtFld18)
    {
        this.cTgtObjTxtFld18 = cTgtObjTxtFld18;
    }

    public String getcTgtObjTxtFld18()
    {
        return cTgtObjTxtFld18;
    }
    public void setcTgtObjTxtFld19(String cTgtObjTxtFld19)
    {
        this.cTgtObjTxtFld19 = cTgtObjTxtFld19;
    }

    public String getcTgtObjTxtFld19()
    {
        return cTgtObjTxtFld19;
    }
    public void setcTgtObjTxtFld20(String cTgtObjTxtFld20)
    {
        this.cTgtObjTxtFld20 = cTgtObjTxtFld20;
    }

    public String getcTgtObjTxtFld20()
    {
        return cTgtObjTxtFld20;
    }
    public void settTgtObjTmFld1(Date tTgtObjTmFld1)
    {
        this.tTgtObjTmFld1 = tTgtObjTmFld1;
    }

    public Date gettTgtObjTmFld1()
    {
        return tTgtObjTmFld1;
    }
    public void settTgtObjTmFld2(Date tTgtObjTmFld2)
    {
        this.tTgtObjTmFld2 = tTgtObjTmFld2;
    }

    public Date gettTgtObjTmFld2()
    {
        return tTgtObjTmFld2;
    }
    public void settTgtObjTmFld3(Date tTgtObjTmFld3)
    {
        this.tTgtObjTmFld3 = tTgtObjTmFld3;
    }

    public Date gettTgtObjTmFld3()
    {
        return tTgtObjTmFld3;
    }
    public void settTgtObjTmFld4(Date tTgtObjTmFld4)
    {
        this.tTgtObjTmFld4 = tTgtObjTmFld4;
    }

    public Date gettTgtObjTmFld4()
    {
        return tTgtObjTmFld4;
    }
    public void settTgtObjTmFld5(Date tTgtObjTmFld5)
    {
        this.tTgtObjTmFld5 = tTgtObjTmFld5;
    }

    public Date gettTgtObjTmFld5()
    {
        return tTgtObjTmFld5;
    }
    public void setnTgtObjNumFld1(Long nTgtObjNumFld1)
    {
        this.nTgtObjNumFld1 = nTgtObjNumFld1;
    }

    public Long getnTgtObjNumFld1()
    {
        return nTgtObjNumFld1;
    }
    public void setnTgtObjNumFld2(Long nTgtObjNumFld2)
    {
        this.nTgtObjNumFld2 = nTgtObjNumFld2;
    }

    public Long getnTgtObjNumFld2()
    {
        return nTgtObjNumFld2;
    }
    public void setnTgtObjNumFld3(Long nTgtObjNumFld3)
    {
        this.nTgtObjNumFld3 = nTgtObjNumFld3;
    }

    public Long getnTgtObjNumFld3()
    {
        return nTgtObjNumFld3;
    }
    public void setnTgtObjNumFld4(Long nTgtObjNumFld4)
    {
        this.nTgtObjNumFld4 = nTgtObjNumFld4;
    }

    public Long getnTgtObjNumFld4()
    {
        return nTgtObjNumFld4;
    }
    public void setnTgtObjNumFld5(Long nTgtObjNumFld5)
    {
        this.nTgtObjNumFld5 = nTgtObjNumFld5;
    }

    public Long getnTgtObjNumFld5()
    {
        return nTgtObjNumFld5;
    }
    public void setnTgtObjNumFld6(Long nTgtObjNumFld6)
    {
        this.nTgtObjNumFld6 = nTgtObjNumFld6;
    }

    public Long getnTgtObjNumFld6()
    {
        return nTgtObjNumFld6;
    }
    public void setnTgtObjNumFld7(Long nTgtObjNumFld7)
    {
        this.nTgtObjNumFld7 = nTgtObjNumFld7;
    }

    public Long getnTgtObjNumFld7()
    {
        return nTgtObjNumFld7;
    }
    public void setnTgtObjNumFld8(Long nTgtObjNumFld8)
    {
        this.nTgtObjNumFld8 = nTgtObjNumFld8;
    }

    public Long getnTgtObjNumFld8()
    {
        return nTgtObjNumFld8;
    }
    public void setnTgtObjNumFld9(Long nTgtObjNumFld9)
    {
        this.nTgtObjNumFld9 = nTgtObjNumFld9;
    }

    public Long getnTgtObjNumFld9()
    {
        return nTgtObjNumFld9;
    }
    public void setnTgtObjNumFld10(Long nTgtObjNumFld10)
    {
        this.nTgtObjNumFld10 = nTgtObjNumFld10;
    }

    public Long getnTgtObjNumFld10()
    {
        return nTgtObjNumFld10;
    }
    public void setlTgtObjLtxtFld1(String lTgtObjLtxtFld1)
    {
        this.lTgtObjLtxtFld1 = lTgtObjLtxtFld1;
    }

    public String getlTgtObjLtxtFld1()
    {
        return lTgtObjLtxtFld1;
    }
    public void setlTgtObjLtxtFld2(String lTgtObjLtxtFld2)
    {
        this.lTgtObjLtxtFld2 = lTgtObjLtxtFld2;
    }

    public String getlTgtObjLtxtFld2()
    {
        return lTgtObjLtxtFld2;
    }
    public void setlTgtObjLtxtFld3(String lTgtObjLtxtFld3)
    {
        this.lTgtObjLtxtFld3 = lTgtObjLtxtFld3;
    }

    public String getlTgtObjLtxtFld3()
    {
        return lTgtObjLtxtFld3;
    }
    public void setlTgtObjLtxtFld4(String lTgtObjLtxtFld4)
    {
        this.lTgtObjLtxtFld4 = lTgtObjLtxtFld4;
    }

    public String getlTgtObjLtxtFld4()
    {
        return lTgtObjLtxtFld4;
    }
    public void setlTgtObjLtxtFld5(String lTgtObjLtxtFld5)
    {
        this.lTgtObjLtxtFld5 = lTgtObjLtxtFld5;
    }

    public String getlTgtObjLtxtFld5()
    {
        return lTgtObjLtxtFld5;
    }
    public void setcCancelMark(String cCancelMark)
    {
        this.cCancelMark = cCancelMark;
    }

    public String getcCancelMark()
    {
        return cCancelMark;
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
    public void setcTgtObjTxtFld21(String cTgtObjTxtFld21)
    {
        this.cTgtObjTxtFld21 = cTgtObjTxtFld21;
    }

    public String getcTgtObjTxtFld21()
    {
        return cTgtObjTxtFld21;
    }
    public void setcTgtObjTxtFld22(String cTgtObjTxtFld22)
    {
        this.cTgtObjTxtFld22 = cTgtObjTxtFld22;
    }

    public String getcTgtObjTxtFld22()
    {
        return cTgtObjTxtFld22;
    }
    public void setcTgtObjTxtFld23(String cTgtObjTxtFld23)
    {
        this.cTgtObjTxtFld23 = cTgtObjTxtFld23;
    }

    public String getcTgtObjTxtFld23()
    {
        return cTgtObjTxtFld23;
    }
    public void setcTgtObjTxtFld24(String cTgtObjTxtFld24)
    {
        this.cTgtObjTxtFld24 = cTgtObjTxtFld24;
    }

    public String getcTgtObjTxtFld24()
    {
        return cTgtObjTxtFld24;
    }
    public void setcTgtObjTxtFld25(String cTgtObjTxtFld25)
    {
        this.cTgtObjTxtFld25 = cTgtObjTxtFld25;
    }

    public String getcTgtObjTxtFld25()
    {
        return cTgtObjTxtFld25;
    }
    public void setcTgtObjTxtFld26(String cTgtObjTxtFld26)
    {
        this.cTgtObjTxtFld26 = cTgtObjTxtFld26;
    }

    public String getcTgtObjTxtFld26()
    {
        return cTgtObjTxtFld26;
    }
    public void setcTgtObjTxtFld27(String cTgtObjTxtFld27)
    {
        this.cTgtObjTxtFld27 = cTgtObjTxtFld27;
    }

    public String getcTgtObjTxtFld27()
    {
        return cTgtObjTxtFld27;
    }
    public void setcTgtObjTxtFld28(String cTgtObjTxtFld28)
    {
        this.cTgtObjTxtFld28 = cTgtObjTxtFld28;
    }

    public String getcTgtObjTxtFld28()
    {
        return cTgtObjTxtFld28;
    }
    public void setcTgtObjTxtFld29(String cTgtObjTxtFld29)
    {
        this.cTgtObjTxtFld29 = cTgtObjTxtFld29;
    }

    public String getcTgtObjTxtFld29()
    {
        return cTgtObjTxtFld29;
    }
    public void setcTgtObjTxtFld30(String cTgtObjTxtFld30)
    {
        this.cTgtObjTxtFld30 = cTgtObjTxtFld30;
    }

    public String getcTgtObjTxtFld30()
    {
        return cTgtObjTxtFld30;
    }
    public void setcCertfCls(String cCertfCls)
    {
        this.cCertfCls = cCertfCls;
    }

    public String getcCertfCls()
    {
        return cCertfCls;
    }
    public void setcFarmerIsOrg(String cFarmerIsOrg)
    {
        this.cFarmerIsOrg = cFarmerIsOrg;
    }

    public String getcFarmerIsOrg()
    {
        return cFarmerIsOrg;
    }
    public void setcLandParcelType(String cLandParcelType)
    {
        this.cLandParcelType = cLandParcelType;
    }

    public String getcLandParcelType()
    {
        return cLandParcelType;
    }
    public void setcStartLongitude(String cStartLongitude)
    {
        this.cStartLongitude = cStartLongitude;
    }

    public String getcStartLongitude()
    {
        return cStartLongitude;
    }
    public void setcEndLongitude(String cEndLongitude)
    {
        this.cEndLongitude = cEndLongitude;
    }

    public String getcEndLongitude()
    {
        return cEndLongitude;
    }
    public void setcStartLatitude(String cStartLatitude)
    {
        this.cStartLatitude = cStartLatitude;
    }

    public String getcStartLatitude()
    {
        return cStartLatitude;
    }
    public void setcEndLatitude(String cEndLatitude)
    {
        this.cEndLatitude = cEndLatitude;
    }

    public String getcEndLatitude()
    {
        return cEndLatitude;
    }
    public void setcCompartmentNo(String cCompartmentNo)
    {
        this.cCompartmentNo = cCompartmentNo;
    }

    public String getcCompartmentNo()
    {
        return cCompartmentNo;
    }
    public void setcSmallCompartmentNo(String cSmallCompartmentNo)
    {
        this.cSmallCompartmentNo = cSmallCompartmentNo;
    }

    public String getcSmallCompartmentNo()
    {
        return cSmallCompartmentNo;
    }
    public void setcCertfBgnTm(String cCertfBgnTm)
    {
        this.cCertfBgnTm = cCertfBgnTm;
    }

    public String getcCertfBgnTm()
    {
        return cCertfBgnTm;
    }
    public void setcTgtObjTxtFld31(String cTgtObjTxtFld31)
    {
        this.cTgtObjTxtFld31 = cTgtObjTxtFld31;
    }

    public String getcTgtObjTxtFld31()
    {
        return cTgtObjTxtFld31;
    }
    public void setcTgtObjTxtFld32(String cTgtObjTxtFld32)
    {
        this.cTgtObjTxtFld32 = cTgtObjTxtFld32;
    }

    public String getcTgtObjTxtFld32()
    {
        return cTgtObjTxtFld32;
    }
    public void setcTgtObjTxtFld33(String cTgtObjTxtFld33)
    {
        this.cTgtObjTxtFld33 = cTgtObjTxtFld33;
    }

    public String getcTgtObjTxtFld33()
    {
        return cTgtObjTxtFld33;
    }
    public void setcPerpetual(String cPerpetual)
    {
        this.cPerpetual = cPerpetual;
    }

    public String getcPerpetual()
    {
        return cPerpetual;
    }
    public void setnTgtObjNumFld11(Long nTgtObjNumFld11)
    {
        this.nTgtObjNumFld11 = nTgtObjNumFld11;
    }

    public Long getnTgtObjNumFld11()
    {
        return nTgtObjNumFld11;
    }
    public void setcEastLocation(String cEastLocation)
    {
        this.cEastLocation = cEastLocation;
    }

    public String getcEastLocation()
    {
        return cEastLocation;
    }
    public void setcWestLocation(String cWestLocation)
    {
        this.cWestLocation = cWestLocation;
    }

    public String getcWestLocation()
    {
        return cWestLocation;
    }
    public void setcSouthLocation(String cSouthLocation)
    {
        this.cSouthLocation = cSouthLocation;
    }

    public String getcSouthLocation()
    {
        return cSouthLocation;
    }
    public void setcNorthLocation(String cNorthLocation)
    {
        this.cNorthLocation = cNorthLocation;
    }

    public String getcNorthLocation()
    {
        return cNorthLocation;
    }
    public void setcRelateName(String cRelateName)
    {
        this.cRelateName = cRelateName;
    }

    public String getcRelateName()
    {
        return cRelateName;
    }
    public void setcRelateCls(String cRelateCls)
    {
        this.cRelateCls = cRelateCls;
    }

    public String getcRelateCls()
    {
        return cRelateCls;
    }
    public void setcRelateCert(String cRelateCert)
    {
        this.cRelateCert = cRelateCert;
    }

    public String getcRelateCert()
    {
        return cRelateCert;
    }
    public void setcRelateContact(String cRelateContact)
    {
        this.cRelateContact = cRelateContact;
    }

    public String getcRelateContact()
    {
        return cRelateContact;
    }
    public void setcRelation(String cRelation)
    {
        this.cRelation = cRelation;
    }

    public String getcRelation()
    {
        return cRelation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cPkId", getcPkId())
            .append("cAppNo", getcAppNo())
            .append("cRowId", getcRowId())
            .append("nSeqNo", getnSeqNo())
            .append("cTgtObjTxtFld1", getcTgtObjTxtFld1())
            .append("cTgtObjTxtFld2", getcTgtObjTxtFld2())
            .append("cTgtObjTxtFld3", getcTgtObjTxtFld3())
            .append("cTgtObjTxtFld4", getcTgtObjTxtFld4())
            .append("cTgtObjTxtFld5", getcTgtObjTxtFld5())
            .append("cTgtObjTxtFld6", getcTgtObjTxtFld6())
            .append("cTgtObjTxtFld7", getcTgtObjTxtFld7())
            .append("cTgtObjTxtFld8", getcTgtObjTxtFld8())
            .append("cTgtObjTxtFld9", getcTgtObjTxtFld9())
            .append("cTgtObjTxtFld10", getcTgtObjTxtFld10())
            .append("cTgtObjTxtFld11", getcTgtObjTxtFld11())
            .append("cTgtObjTxtFld12", getcTgtObjTxtFld12())
            .append("cTgtObjTxtFld13", getcTgtObjTxtFld13())
            .append("cTgtObjTxtFld14", getcTgtObjTxtFld14())
            .append("cTgtObjTxtFld15", getcTgtObjTxtFld15())
            .append("cTgtObjTxtFld16", getcTgtObjTxtFld16())
            .append("cTgtObjTxtFld17", getcTgtObjTxtFld17())
            .append("cTgtObjTxtFld18", getcTgtObjTxtFld18())
            .append("cTgtObjTxtFld19", getcTgtObjTxtFld19())
            .append("cTgtObjTxtFld20", getcTgtObjTxtFld20())
            .append("tTgtObjTmFld1", gettTgtObjTmFld1())
            .append("tTgtObjTmFld2", gettTgtObjTmFld2())
            .append("tTgtObjTmFld3", gettTgtObjTmFld3())
            .append("tTgtObjTmFld4", gettTgtObjTmFld4())
            .append("tTgtObjTmFld5", gettTgtObjTmFld5())
            .append("nTgtObjNumFld1", getnTgtObjNumFld1())
            .append("nTgtObjNumFld2", getnTgtObjNumFld2())
            .append("nTgtObjNumFld3", getnTgtObjNumFld3())
            .append("nTgtObjNumFld4", getnTgtObjNumFld4())
            .append("nTgtObjNumFld5", getnTgtObjNumFld5())
            .append("nTgtObjNumFld6", getnTgtObjNumFld6())
            .append("nTgtObjNumFld7", getnTgtObjNumFld7())
            .append("nTgtObjNumFld8", getnTgtObjNumFld8())
            .append("nTgtObjNumFld9", getnTgtObjNumFld9())
            .append("nTgtObjNumFld10", getnTgtObjNumFld10())
            .append("lTgtObjLtxtFld1", getlTgtObjLtxtFld1())
            .append("lTgtObjLtxtFld2", getlTgtObjLtxtFld2())
            .append("lTgtObjLtxtFld3", getlTgtObjLtxtFld3())
            .append("lTgtObjLtxtFld4", getlTgtObjLtxtFld4())
            .append("lTgtObjLtxtFld5", getlTgtObjLtxtFld5())
            .append("cCancelMark", getcCancelMark())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("cCrtCde", getcCrtCde())
            .append("tUpdTm", gettUpdTm())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cTgtObjTxtFld21", getcTgtObjTxtFld21())
            .append("cTgtObjTxtFld22", getcTgtObjTxtFld22())
            .append("cTgtObjTxtFld23", getcTgtObjTxtFld23())
            .append("cTgtObjTxtFld24", getcTgtObjTxtFld24())
            .append("cTgtObjTxtFld25", getcTgtObjTxtFld25())
            .append("cTgtObjTxtFld26", getcTgtObjTxtFld26())
            .append("cTgtObjTxtFld27", getcTgtObjTxtFld27())
            .append("cTgtObjTxtFld28", getcTgtObjTxtFld28())
            .append("cTgtObjTxtFld29", getcTgtObjTxtFld29())
            .append("cTgtObjTxtFld30", getcTgtObjTxtFld30())
            .append("cCertfCls", getcCertfCls())
            .append("cFarmerIsOrg", getcFarmerIsOrg())
            .append("cLandParcelType", getcLandParcelType())
            .append("cStartLongitude", getcStartLongitude())
            .append("cEndLongitude", getcEndLongitude())
            .append("cStartLatitude", getcStartLatitude())
            .append("cEndLatitude", getcEndLatitude())
            .append("cCompartmentNo", getcCompartmentNo())
            .append("cSmallCompartmentNo", getcSmallCompartmentNo())
            .append("cCertfBgnTm", getcCertfBgnTm())
            .append("cTgtObjTxtFld31", getcTgtObjTxtFld31())
            .append("cTgtObjTxtFld32", getcTgtObjTxtFld32())
            .append("cTgtObjTxtFld33", getcTgtObjTxtFld33())
            .append("cPerpetual", getcPerpetual())
            .append("nTgtObjNumFld11", getnTgtObjNumFld11())
            .append("cEastLocation", getcEastLocation())
            .append("cWestLocation", getcWestLocation())
            .append("cSouthLocation", getcSouthLocation())
            .append("cNorthLocation", getcNorthLocation())
            .append("cRelateName", getcRelateName())
            .append("cRelateCls", getcRelateCls())
            .append("cRelateCert", getcRelateCert())
            .append("cRelateContact", getcRelateContact())
            .append("cRelation", getcRelation())
            .toString();
    }
}
