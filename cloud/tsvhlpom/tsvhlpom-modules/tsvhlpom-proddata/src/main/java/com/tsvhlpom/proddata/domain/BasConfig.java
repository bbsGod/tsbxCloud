package com.tsvhlpom.proddata.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BasConfig {
    private String c_pk_id;
    private String c_conf_group;
    private String c_conf_id;
    private String c_conf_nme;
    private String c_conf_value;
    private String c_crt_cde;
    private Date t_crt_tm;
    private String c_upd_cde;
    private Date t_upd_tm;
}
