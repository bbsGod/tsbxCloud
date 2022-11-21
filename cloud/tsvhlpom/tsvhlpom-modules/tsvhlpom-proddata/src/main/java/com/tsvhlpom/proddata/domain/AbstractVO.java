package com.tsvhlpom.proddata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class AbstractVO {
    private String c_type;
    private String c_app_no;
    private String c_email;
    private Double n_novhl_pay_amt;
    private String c_charge_cde;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date t_charge_tm;

    @Excel(name = "c_pk_id")
    private String c_pk_id;
    @Excel(name = "t_create_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date t_create_date;
}
