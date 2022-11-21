package com.tsvhlpom.cargroup.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 回访表
 */
@Data
public class BaseVisit {

    private String c_pk_id;//主键
    private String c_id;//重点客户主键id
    private String c_visit_status;//回访状态
    private String c_visit_emp;//回访人员
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date c_visit_Tm;//回访时间
    private String c_remark;//备注

}

