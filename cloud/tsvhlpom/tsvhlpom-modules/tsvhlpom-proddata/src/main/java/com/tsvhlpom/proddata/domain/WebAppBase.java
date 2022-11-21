package com.tsvhlpom.proddata.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class WebAppBase {
    @Excel(name = "保单号")
    private String c_ply_no;
    @Excel(name = "中介机构销售人员姓名")
    private String c_salesman_name;
    @Excel(name = "中介机构销售人员职业证书编号")
    private String c_cert_salesman_num;
    @Excel(name = "销售中介机构名称")
    private String c_certificate_name;
    @Excel(name = "销售中介机构联系电话")
    private String c_certificate_phone;
    private String c_app_no;
    private String c_opr_cde;//操作工号
}
