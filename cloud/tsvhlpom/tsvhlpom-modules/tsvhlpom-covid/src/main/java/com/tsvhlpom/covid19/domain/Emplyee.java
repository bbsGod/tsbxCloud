package com.tsvhlpom.covid19.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class Emplyee {
    private String c_pk_id;//主键
    @Excel(name = "总公司/分公司")
    private String c_parent_dept;//二级机构
    @Excel(name = "总部部门/各机构")
    private String c_dept;//三级机构
    @Excel(name = "姓名")
    private String c_name;//姓名
    @Excel(name = "身份证号")
    private String c_id_no;//身份证号
    @Excel(name = "手机号")
    private String c_phone;//手机号
}
