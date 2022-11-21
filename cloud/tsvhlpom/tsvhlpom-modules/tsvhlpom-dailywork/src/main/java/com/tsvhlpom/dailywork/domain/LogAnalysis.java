package com.tsvhlpom.dailywork.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LogAnalysis{
    private String emp_team;//项目组
    private String emp_id;//员工id
    private String emp_name;//员工姓名
    private String create_time;//日志时间
    private String work_type;
    private String work_progress;
    private String log_info;
    private String team_type;
    private Date startDate;
    private Date endDate;
    private String log_attachment_path;//日报附件
}
