package com.tsvhlpom.proddata.domain;

import lombok.Data;

import java.util.Date;

@Data
public class WebBasEdrRsnItem {
    private String c_pk_id;
    private String c_prod_no;
    private String c_rsn_cde;
    private String c_edr_item;
    private String c_tab_no;
    private String c_fld_id;
    private String c_oper_typ;
    private String c_crt_cde;
    private Date t_crt_tm;
    private String c_upd_cde;
    private Date t_upd_tm;
    private String c_trans_mrk;
    private Date t_trans_tm;

}
