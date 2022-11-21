package com.tsvhlpom.proddata.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class WebPlyEdrErrLogs {
    private String c_pk_id;
    @Excel(name = "请求类型")
    private String c_req_type;
    @Excel(name = "申请单号")
    private String c_app_no;
    @Excel(name = "错误信息")
    private String c_err_message;
    @Excel(name = "状态",readConverterExp = "1=成功,0=失败")
    private String c_status;
    @Excel(name = "发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date t_send_time;
    @Excel(name = "重新发送次数")
    private Integer n_err_tms;
    @Excel(name = "发送报文")
    private String c_sendmessage;
}
