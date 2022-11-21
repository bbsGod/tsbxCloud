package com.tsvhlpom.compare.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.compare.utils.AnjiDescription;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;

/**
 * 申请单保费系数对象 web_app_prm_coef
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class WebAppPrmCoef extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请单号 */
    private String cAppNo;

    /** 车龄 */
    @Excel(name = "车龄")
    @AnjiDescription("cVhlAge")
    private String cVhlAge;

    /** 驾驶员性别 */
    @Excel(name = "驾驶员性别")
    @AnjiDescription("cDrvSex")
    private String cDrvSex;

    /** 驾驶员驾龄 */
    @Excel(name = "驾驶员驾龄")
    @AnjiDescription("cDrvDrvage")
    private String cDrvDrvage;

    /** 指定驾驶员 */
    @Excel(name = "指定驾驶员")
    @AnjiDescription("cAppDrv")
    private String cAppDrv;

    /** 驾驶员年龄 */
    @Excel(name = "驾驶员年龄")
    @AnjiDescription("cDrvAge")
    private String cDrvAge;

    /** 客户忠诚度(投保年度,续保客户) */
    @Excel(name = "客户忠诚度(投保年度,续保客户)")
    @AnjiDescription("cCusLoy")
    private String cCusLoy;

    /** 所属性质,个人
机关、企业 */
    @Excel(name = "所属性质,个人 机关、企业")
    @AnjiDescription("cOwnAttr")
    private String cOwnAttr;

    /** 交通违法 */
    @Excel(name = "交通违法")
    @AnjiDescription("cTrafIrr")
    private String cTrafIrr;

    /** 交通事故 */
    @Excel(name = "交通事故")
    @AnjiDescription("cTrafAccdt")
    private String cTrafAccdt;

    /** 行驶区域 */
    @Excel(name = "行驶区域")
    @AnjiDescription("cRunArea")
    private String cRunArea;

    /** 行驶里程 */
    @Excel(name = "行驶里程")
    @AnjiDescription("cRunMil")
    private String cRunMil;

    /** 以往索赔记录 */
    @Excel(name = "以往索赔记录")
    @AnjiDescription("cAgoClmRec")
    private String cAgoClmRec;

    /** 车型 */
    @Excel(name = "车型")
    @AnjiDescription("cVhlMod")
    private String cVhlMod;

    /** 承保数量 */
    @Excel(name = "承保数量")
    @AnjiDescription("cPlyQty")
    private String cPlyQty;

    /** 多险别投保 */
    @Excel(name = "多险别投保")
    @AnjiDescription("nMulRdr")
    private Long nMulRdr;

    /** 车队管理 */
    @Excel(name = "车队管理")
    @AnjiDescription("cMtcMng")
    private String cMtcMng;

    /** 安全装置 */
    @Excel(name = "安全装置")
    @AnjiDescription("cSafeDev")
    private String cSafeDev;

    /** 渠道系数 */
    @Excel(name = "渠道系数")
    @AnjiDescription("nChaCoef")
    private Long nChaCoef;

    /** 资料完整真实 */
    @Excel(name = "资料完整真实")
    @AnjiDescription("cInfoTrue")
    private String cInfoTrue;

    /** 预期赔付率 */
    @Excel(name = "预期赔付率")
    @AnjiDescription("cLossRatio")
    private String cLossRatio;

    /** 政府采购或招投标业务 */
    @Excel(name = "政府采购或招投标业务")
    @AnjiDescription("nBidCoef")
    private Long nBidCoef;

    /** 无赔款折扣 */
    @Excel(name = "无赔款折扣")
    @AnjiDescription("nNclmDisc")
    private Long nNclmDisc;

    /** 计算起期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计算起期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCalStrtTm")
    private Date tCalStrtTm;

    /** 计算止期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计算止期", width = 30, dateFormat = "yyyy-MM-dd")
    @AnjiDescription("tCalEndTm")
    private Date tCalEndTm;

    /** 不浮动原因 */
    @Excel(name = "不浮动原因")
    @AnjiDescription("cNdiscRsn")
    private String cNdiscRsn;

    /** 总折扣 */
    @Excel(name = "总折扣")
    @AnjiDescription("nTotDisc")
    private Long nTotDisc;

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

    /** 平均年行驶里程 */
    @Excel(name = "平均年行驶里程")
    @AnjiDescription("cYearRunMil")
    private String cYearRunMil;

    /** 是否投保交强险 */
    @Excel(name = "是否投保交强险")
    @AnjiDescription("cTfiMrk")
    private String cTfiMrk;

    /** 交强险承保公司 */
    @Excel(name = "交强险承保公司")
    @AnjiDescription("cTfiCompany")
    private String cTfiCompany;

    /** 交强险保单号 */
    @Excel(name = "交强险保单号")
    @AnjiDescription("cTfiPlyNo")
    private String cTfiPlyNo;

    /** 饮酒一次费率浮动 */
    @Excel(name = "饮酒一次费率浮动")
    @AnjiDescription("cResvTxt1")
    private String cResvTxt1;

    /** 醉酒一次费率浮动 */
    @Excel(name = "醉酒一次费率浮动")
    @AnjiDescription("cResvTxt2")
    private String cResvTxt2;

    /** 预留字符串字段3 */
    @Excel(name = "预留字符串字段3")
    @AnjiDescription("cResvTxt3")
    private String cResvTxt3;

    /** 预留字符串字段4 */
    @Excel(name = "预留字符串字段4")
    @AnjiDescription("cResvTxt4")
    private String cResvTxt4;

    /** 预留字符串字段5 */
    @Excel(name = "预留字符串字段5")
    @AnjiDescription("cResvTxt5")
    private String cResvTxt5;

    /** 饮酒后驾驶违法行为次数; 地区因子系数 */
    @Excel(name = "饮酒后驾驶违法行为次数; 地区因子系数")
    @AnjiDescription("nResvNum1")
    private Long nResvNum1;

    /** 醉酒后驾驶违法行为次数 */
    @Excel(name = "醉酒后驾驶违法行为次数")
    @AnjiDescription("nResvNum2")
    private Long nResvNum2;

    /** 与道路交通安全相联系的”浮动“比例(注意正负值) */
    @Excel(name = "与道路交通安全相联系的”浮动“比例(注意正负值)")
    @AnjiDescription("nResvNum3")
    private Long nResvNum3;

    /** 与道路交通安全违法行为相联系的浮动V */
    @Excel(name = "与道路交通安全违法行为相联系的浮动V")
    @AnjiDescription("nResvNum4")
    private Long nResvNum4;

    /** 酒后驾驶违法总系数 */
    @Excel(name = "酒后驾驶违法总系数")
    @AnjiDescription("nResvNum5")
    private Long nResvNum5;

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

    /** 自主定价系数 */
    @Excel(name = "自主定价系数")
    @AnjiDescription("nResvNum6")
    private Long nResvNum6;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nResvNum7")
    private Long nResvNum7;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @AnjiDescription("nResvNum8")
    private Long nResvNum8;

    /** 驾驶人性别系数值 */
    @Excel(name = "驾驶人性别系数值")
    @AnjiDescription("nDrvSex")
    private Long nDrvSex;

    /** 驾驶人驾龄系数值 */
    @Excel(name = "驾驶人驾龄系数值")
    @AnjiDescription("nDrvDrvage")
    private Long nDrvDrvage;

    /** 指定驾驶员系数值 */
    @Excel(name = "指定驾驶员系数值")
    @AnjiDescription("nAppDrv")
    private Long nAppDrv;

    /** 驾驶人年龄系数值 */
    @Excel(name = "驾驶人年龄系数值")
    @AnjiDescription("nDrvAge")
    private Long nDrvAge;

    /** 客户忠诚度系数值 */
    @Excel(name = "客户忠诚度系数值")
    @AnjiDescription("nCusLoy")
    private Long nCusLoy;

    /** 安全驾驶系数值 */
    @Excel(name = "安全驾驶系数值")
    @AnjiDescription("nTrafIrr")
    private Long nTrafIrr;

    /** 行驶区域系数值 */
    @Excel(name = "行驶区域系数值")
    @AnjiDescription("nRunArea")
    private Long nRunArea;

    /** 以往索赔记录系数值 */
    @Excel(name = "以往索赔记录系数值")
    @AnjiDescription("nAgoClmRec")
    private Long nAgoClmRec;

    /** 车型系数值 */
    @Excel(name = "车型系数值")
    @AnjiDescription("nVhlMod")
    private Long nVhlMod;

    /** 承保数量系数值 */
    @Excel(name = "承保数量系数值")
    @AnjiDescription("nPlyQty")
    private Long nPlyQty;

    /** 车队管理系数值 */
    @Excel(name = "车队管理系数值")
    @AnjiDescription("nMtcMng")
    private Long nMtcMng;

    /** 预期赔付率系数值 */
    @Excel(name = "预期赔付率系数值")
    @AnjiDescription("nLossRatio")
    private Long nLossRatio;

    /** 平均年行驶里程系数值 */
    @Excel(name = "平均年行驶里程系数值")
    @AnjiDescription("nYearRunMil")
    private Long nYearRunMil;

    /** 自主核保系数 */
    @Excel(name = "自主核保系数")
    @AnjiDescription("nAutonomyCoef")
    private Long nAutonomyCoef;

    /** 车主性别 */
    @Excel(name = "车主性别")
    @AnjiDescription("cVhlownerSex")
    private String cVhlownerSex;

    /** 车主性别数值 */
    @Excel(name = "车主性别数值")
    @AnjiDescription("nVhlownerSex")
    private Long nVhlownerSex;

    /** 车主年龄 */
    @Excel(name = "车主年龄")
    @AnjiDescription("cVhlownerAge")
    private String cVhlownerAge;

    /** 车主年龄数值 */
    @Excel(name = "车主年龄数值")
    @AnjiDescription("nVhlownerAge")
    private Long nVhlownerAge;

    /** 车主驾龄 */
    @Excel(name = "车主驾龄")
    @AnjiDescription("cVhlownerDrvage")
    private String cVhlownerDrvage;

    /** 车主驾龄数值 */
    @Excel(name = "车主驾龄数值")
    @AnjiDescription("nVhlownerDrvage")
    private Long nVhlownerDrvage;

    public void setcAppNo(String cAppNo)
    {
        this.cAppNo = cAppNo;
    }

    public String getcAppNo()
    {
        return cAppNo;
    }
    public void setcVhlAge(String cVhlAge)
    {
        this.cVhlAge = cVhlAge;
    }

    public String getcVhlAge()
    {
        return cVhlAge;
    }
    public void setcDrvSex(String cDrvSex)
    {
        this.cDrvSex = cDrvSex;
    }

    public String getcDrvSex()
    {
        return cDrvSex;
    }
    public void setcDrvDrvage(String cDrvDrvage)
    {
        this.cDrvDrvage = cDrvDrvage;
    }

    public String getcDrvDrvage()
    {
        return cDrvDrvage;
    }
    public void setcAppDrv(String cAppDrv)
    {
        this.cAppDrv = cAppDrv;
    }

    public String getcAppDrv()
    {
        return cAppDrv;
    }
    public void setcDrvAge(String cDrvAge)
    {
        this.cDrvAge = cDrvAge;
    }

    public String getcDrvAge()
    {
        return cDrvAge;
    }
    public void setcCusLoy(String cCusLoy)
    {
        this.cCusLoy = cCusLoy;
    }

    public String getcCusLoy()
    {
        return cCusLoy;
    }
    public void setcOwnAttr(String cOwnAttr)
    {
        this.cOwnAttr = cOwnAttr;
    }

    public String getcOwnAttr()
    {
        return cOwnAttr;
    }
    public void setcTrafIrr(String cTrafIrr)
    {
        this.cTrafIrr = cTrafIrr;
    }

    public String getcTrafIrr()
    {
        return cTrafIrr;
    }
    public void setcTrafAccdt(String cTrafAccdt)
    {
        this.cTrafAccdt = cTrafAccdt;
    }

    public String getcTrafAccdt()
    {
        return cTrafAccdt;
    }
    public void setcRunArea(String cRunArea)
    {
        this.cRunArea = cRunArea;
    }

    public String getcRunArea()
    {
        return cRunArea;
    }
    public void setcRunMil(String cRunMil)
    {
        this.cRunMil = cRunMil;
    }

    public String getcRunMil()
    {
        return cRunMil;
    }
    public void setcAgoClmRec(String cAgoClmRec)
    {
        this.cAgoClmRec = cAgoClmRec;
    }

    public String getcAgoClmRec()
    {
        return cAgoClmRec;
    }
    public void setcVhlMod(String cVhlMod)
    {
        this.cVhlMod = cVhlMod;
    }

    public String getcVhlMod()
    {
        return cVhlMod;
    }
    public void setcPlyQty(String cPlyQty)
    {
        this.cPlyQty = cPlyQty;
    }

    public String getcPlyQty()
    {
        return cPlyQty;
    }
    public void setnMulRdr(Long nMulRdr)
    {
        this.nMulRdr = nMulRdr;
    }

    public Long getnMulRdr()
    {
        return nMulRdr;
    }
    public void setcMtcMng(String cMtcMng)
    {
        this.cMtcMng = cMtcMng;
    }

    public String getcMtcMng()
    {
        return cMtcMng;
    }
    public void setcSafeDev(String cSafeDev)
    {
        this.cSafeDev = cSafeDev;
    }

    public String getcSafeDev()
    {
        return cSafeDev;
    }
    public void setnChaCoef(Long nChaCoef)
    {
        this.nChaCoef = nChaCoef;
    }

    public Long getnChaCoef()
    {
        return nChaCoef;
    }
    public void setcInfoTrue(String cInfoTrue)
    {
        this.cInfoTrue = cInfoTrue;
    }

    public String getcInfoTrue()
    {
        return cInfoTrue;
    }
    public void setcLossRatio(String cLossRatio)
    {
        this.cLossRatio = cLossRatio;
    }

    public String getcLossRatio()
    {
        return cLossRatio;
    }
    public void setnBidCoef(Long nBidCoef)
    {
        this.nBidCoef = nBidCoef;
    }

    public Long getnBidCoef()
    {
        return nBidCoef;
    }
    public void setnNclmDisc(Long nNclmDisc)
    {
        this.nNclmDisc = nNclmDisc;
    }

    public Long getnNclmDisc()
    {
        return nNclmDisc;
    }
    public void settCalStrtTm(Date tCalStrtTm)
    {
        this.tCalStrtTm = tCalStrtTm;
    }

    public Date gettCalStrtTm()
    {
        return tCalStrtTm;
    }
    public void settCalEndTm(Date tCalEndTm)
    {
        this.tCalEndTm = tCalEndTm;
    }

    public Date gettCalEndTm()
    {
        return tCalEndTm;
    }
    public void setcNdiscRsn(String cNdiscRsn)
    {
        this.cNdiscRsn = cNdiscRsn;
    }

    public String getcNdiscRsn()
    {
        return cNdiscRsn;
    }
    public void setnTotDisc(Long nTotDisc)
    {
        this.nTotDisc = nTotDisc;
    }

    public Long getnTotDisc()
    {
        return nTotDisc;
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
    public void setcYearRunMil(String cYearRunMil)
    {
        this.cYearRunMil = cYearRunMil;
    }

    public String getcYearRunMil()
    {
        return cYearRunMil;
    }
    public void setcTfiMrk(String cTfiMrk)
    {
        this.cTfiMrk = cTfiMrk;
    }

    public String getcTfiMrk()
    {
        return cTfiMrk;
    }
    public void setcTfiCompany(String cTfiCompany)
    {
        this.cTfiCompany = cTfiCompany;
    }

    public String getcTfiCompany()
    {
        return cTfiCompany;
    }
    public void setcTfiPlyNo(String cTfiPlyNo)
    {
        this.cTfiPlyNo = cTfiPlyNo;
    }

    public String getcTfiPlyNo()
    {
        return cTfiPlyNo;
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
    public void setnResvNum6(Long nResvNum6)
    {
        this.nResvNum6 = nResvNum6;
    }

    public Long getnResvNum6()
    {
        return nResvNum6;
    }
    public void setnResvNum7(Long nResvNum7)
    {
        this.nResvNum7 = nResvNum7;
    }

    public Long getnResvNum7()
    {
        return nResvNum7;
    }
    public void setnResvNum8(Long nResvNum8)
    {
        this.nResvNum8 = nResvNum8;
    }

    public Long getnResvNum8()
    {
        return nResvNum8;
    }
    public void setnDrvSex(Long nDrvSex)
    {
        this.nDrvSex = nDrvSex;
    }

    public Long getnDrvSex()
    {
        return nDrvSex;
    }
    public void setnDrvDrvage(Long nDrvDrvage)
    {
        this.nDrvDrvage = nDrvDrvage;
    }

    public Long getnDrvDrvage()
    {
        return nDrvDrvage;
    }
    public void setnAppDrv(Long nAppDrv)
    {
        this.nAppDrv = nAppDrv;
    }

    public Long getnAppDrv()
    {
        return nAppDrv;
    }
    public void setnDrvAge(Long nDrvAge)
    {
        this.nDrvAge = nDrvAge;
    }

    public Long getnDrvAge()
    {
        return nDrvAge;
    }
    public void setnCusLoy(Long nCusLoy)
    {
        this.nCusLoy = nCusLoy;
    }

    public Long getnCusLoy()
    {
        return nCusLoy;
    }
    public void setnTrafIrr(Long nTrafIrr)
    {
        this.nTrafIrr = nTrafIrr;
    }

    public Long getnTrafIrr()
    {
        return nTrafIrr;
    }
    public void setnRunArea(Long nRunArea)
    {
        this.nRunArea = nRunArea;
    }

    public Long getnRunArea()
    {
        return nRunArea;
    }
    public void setnAgoClmRec(Long nAgoClmRec)
    {
        this.nAgoClmRec = nAgoClmRec;
    }

    public Long getnAgoClmRec()
    {
        return nAgoClmRec;
    }
    public void setnVhlMod(Long nVhlMod)
    {
        this.nVhlMod = nVhlMod;
    }

    public Long getnVhlMod()
    {
        return nVhlMod;
    }
    public void setnPlyQty(Long nPlyQty)
    {
        this.nPlyQty = nPlyQty;
    }

    public Long getnPlyQty()
    {
        return nPlyQty;
    }
    public void setnMtcMng(Long nMtcMng)
    {
        this.nMtcMng = nMtcMng;
    }

    public Long getnMtcMng()
    {
        return nMtcMng;
    }
    public void setnLossRatio(Long nLossRatio)
    {
        this.nLossRatio = nLossRatio;
    }

    public Long getnLossRatio()
    {
        return nLossRatio;
    }
    public void setnYearRunMil(Long nYearRunMil)
    {
        this.nYearRunMil = nYearRunMil;
    }

    public Long getnYearRunMil()
    {
        return nYearRunMil;
    }
    public void setnAutonomyCoef(Long nAutonomyCoef)
    {
        this.nAutonomyCoef = nAutonomyCoef;
    }

    public Long getnAutonomyCoef()
    {
        return nAutonomyCoef;
    }
    public void setcVhlownerSex(String cVhlownerSex)
    {
        this.cVhlownerSex = cVhlownerSex;
    }

    public String getcVhlownerSex()
    {
        return cVhlownerSex;
    }
    public void setnVhlownerSex(Long nVhlownerSex)
    {
        this.nVhlownerSex = nVhlownerSex;
    }

    public Long getnVhlownerSex()
    {
        return nVhlownerSex;
    }
    public void setcVhlownerAge(String cVhlownerAge)
    {
        this.cVhlownerAge = cVhlownerAge;
    }

    public String getcVhlownerAge()
    {
        return cVhlownerAge;
    }
    public void setnVhlownerAge(Long nVhlownerAge)
    {
        this.nVhlownerAge = nVhlownerAge;
    }

    public Long getnVhlownerAge()
    {
        return nVhlownerAge;
    }
    public void setcVhlownerDrvage(String cVhlownerDrvage)
    {
        this.cVhlownerDrvage = cVhlownerDrvage;
    }

    public String getcVhlownerDrvage()
    {
        return cVhlownerDrvage;
    }
    public void setnVhlownerDrvage(Long nVhlownerDrvage)
    {
        this.nVhlownerDrvage = nVhlownerDrvage;
    }

    public Long getnVhlownerDrvage()
    {
        return nVhlownerDrvage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cAppNo", getcAppNo())
            .append("cVhlAge", getcVhlAge())
            .append("cDrvSex", getcDrvSex())
            .append("cDrvDrvage", getcDrvDrvage())
            .append("cAppDrv", getcAppDrv())
            .append("cDrvAge", getcDrvAge())
            .append("cCusLoy", getcCusLoy())
            .append("cOwnAttr", getcOwnAttr())
            .append("cTrafIrr", getcTrafIrr())
            .append("cTrafAccdt", getcTrafAccdt())
            .append("cRunArea", getcRunArea())
            .append("cRunMil", getcRunMil())
            .append("cAgoClmRec", getcAgoClmRec())
            .append("cVhlMod", getcVhlMod())
            .append("cPlyQty", getcPlyQty())
            .append("nMulRdr", getnMulRdr())
            .append("cMtcMng", getcMtcMng())
            .append("cSafeDev", getcSafeDev())
            .append("nChaCoef", getnChaCoef())
            .append("cInfoTrue", getcInfoTrue())
            .append("cLossRatio", getcLossRatio())
            .append("nBidCoef", getnBidCoef())
            .append("nNclmDisc", getnNclmDisc())
            .append("tCalStrtTm", gettCalStrtTm())
            .append("tCalEndTm", gettCalEndTm())
            .append("cNdiscRsn", getcNdiscRsn())
            .append("nTotDisc", getnTotDisc())
            .append("cCrtCde", getcCrtCde())
            .append("tCrtTm", gettCrtTm())
            .append("cUpdCde", getcUpdCde())
            .append("tUpdTm", gettUpdTm())
            .append("cYearRunMil", getcYearRunMil())
            .append("cTfiMrk", getcTfiMrk())
            .append("cTfiCompany", getcTfiCompany())
            .append("cTfiPlyNo", getcTfiPlyNo())
            .append("cResvTxt1", getcResvTxt1())
            .append("cResvTxt2", getcResvTxt2())
            .append("cResvTxt3", getcResvTxt3())
            .append("cResvTxt4", getcResvTxt4())
            .append("cResvTxt5", getcResvTxt5())
            .append("nResvNum1", getnResvNum1())
            .append("nResvNum2", getnResvNum2())
            .append("nResvNum3", getnResvNum3())
            .append("nResvNum4", getnResvNum4())
            .append("nResvNum5", getnResvNum5())
            .append("cTransMrk", getcTransMrk())
            .append("tTransTm", gettTransTm())
            .append("cResvTxt6", getcResvTxt6())
            .append("cResvTxt7", getcResvTxt7())
            .append("cResvTxt8", getcResvTxt8())
            .append("nResvNum6", getnResvNum6())
            .append("nResvNum7", getnResvNum7())
            .append("nResvNum8", getnResvNum8())
            .append("nDrvSex", getnDrvSex())
            .append("nDrvDrvage", getnDrvDrvage())
            .append("nAppDrv", getnAppDrv())
            .append("nDrvAge", getnDrvAge())
            .append("nCusLoy", getnCusLoy())
            .append("nTrafIrr", getnTrafIrr())
            .append("nRunArea", getnRunArea())
            .append("nAgoClmRec", getnAgoClmRec())
            .append("nVhlMod", getnVhlMod())
            .append("nPlyQty", getnPlyQty())
            .append("nMtcMng", getnMtcMng())
            .append("nLossRatio", getnLossRatio())
            .append("nYearRunMil", getnYearRunMil())
            .append("nAutonomyCoef", getnAutonomyCoef())
            .append("cVhlownerSex", getcVhlownerSex())
            .append("nVhlownerSex", getnVhlownerSex())
            .append("cVhlownerAge", getcVhlownerAge())
            .append("nVhlownerAge", getnVhlownerAge())
            .append("cVhlownerDrvage", getcVhlownerDrvage())
            .append("nVhlownerDrvage", getnVhlownerDrvage())
            .toString();
    }
}
