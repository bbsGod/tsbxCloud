package com.tsvhlpom.proddata.domain;


import lombok.Data;

import java.util.Date;

@Data
public class TblConfig {
    private String c_pk_id;
    private String c_conf_group;
    private String c_conf_id;
    private String c_conf_value;
    private Date c_crt_tm;
    private Date c_upd_tm;
    private String c_conf_state;
}
