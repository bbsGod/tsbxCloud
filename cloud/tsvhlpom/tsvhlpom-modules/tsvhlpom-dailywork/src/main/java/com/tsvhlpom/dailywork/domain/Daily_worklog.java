package com.tsvhlpom.dailywork.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 工作日志表
 */
@Data
public class Daily_worklog {
    private String pkid;//主键
    private String emp_id;//员工ID
    private String emp_name;//员工姓名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;//日志记录时间
    private String work_type;//工作类别
    private String work_progress;//进度
    private String log_info;//日志信息
    private String log_attachment_path;//日志附件路径

    private String query_time;
    private Boolean edit;
}
