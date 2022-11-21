package com.tsvhlpom.vip.domain;


import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class VIP_Main {
    private String pkId;//主键

    @Excel(name = "是否已承保",type = Excel.Type.EXPORT)
    private String status;//是否已承保
    @Excel(name = "被保险人")
    private String insuredName;//被保险人
    @Excel(name = "证件号码")
    private String certifCode;//证件号码
    @Excel(name = "手机号")
    private String phoneNo;//手机号
    @Excel(name = "车牌号")
    private String plateNo;//车牌号
    @Excel(name = "车架号")
    private String frmNo;//车架号
    @Excel(name = "发动机号")
    private String engNo;//发动机号
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;
}
