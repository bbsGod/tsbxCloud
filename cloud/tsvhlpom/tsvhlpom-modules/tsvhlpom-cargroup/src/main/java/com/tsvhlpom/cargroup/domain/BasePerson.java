package com.tsvhlpom.cargroup.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class BasePerson {
    @Excel(name = "重点客户标识")
    private String sp_id;
    @Excel(name = "重点客户")
    private String sp_name;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "部门")
    private String dept;
    @Excel(name = "服务标志")
    private String service_flag;

}
