package com.tsvhlpom.proddata.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

import java.util.Date;

@Data
public class WebPolicyXiaoJuErrLogs {
    @Excel(name = "主键")
    private String c_pk_id;
    @Excel(name = "保批单号")
    private String c_app_no;
    @Excel(name = "错误信息")
    private String c_err_message;
    @Excel(name = "状态标志:0-成功,1-失败")
    private String c_status;
    @Excel(name = "发送时间")
    private Date t_send_time;
}
