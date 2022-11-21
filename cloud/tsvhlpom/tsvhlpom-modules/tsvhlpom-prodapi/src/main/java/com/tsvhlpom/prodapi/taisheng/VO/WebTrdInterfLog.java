package com.tsvhlpom.prodapi.taisheng.VO;

import lombok.Data;

import java.util.Date;

@Data
public class WebTrdInterfLog {
    private String c_pk_id;
    private String c_type;//是否泰盛 0=否 1=是
    private String c_com_id;
    private String c_com_name;
    private String c_resquest;
    private String c_response;
    private String c_token;
    private Long n_expire_in;
    private Date t_crt_tm;
    private String c_status;//交互状态 0=成功 1=失败
    private String c_app_no;
}
