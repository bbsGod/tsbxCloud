package com.tsvhlpom.proddata.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 【统一对接平台日志表】对象 web_policy_third_err_logs
 *
 * @date 2022-06-29
 */
@Data
public class WebPolicyThirdErrLogs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String cpkId;

    /** 保\批单号 */
    @Excel(name = "保批单号")
    private String cappNo;

    /** 错误信息 */
    @Excel(name = "错误信息")
    private String cerrMessage;

    /** 状态标志:0-成功,1-失败 */
    @Excel(name = "状态标志:0-成功,1-失败")
    private String cstatus;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tsendTime;

    /** 请求信息 */
    @Excel(name = "请求信息")
    private String cresponseMessage;

}
