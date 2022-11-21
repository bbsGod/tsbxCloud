package com.tsvhlpom.dailywork.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

/**
 * 员工信息表
 */
@Data
public class Daily_employee {
    private String pkid;//主键
    @Excel(name = "员工工号")
    private String emp_id;//员工ID
    @Excel(name = "员工姓名")
    private String emp_name;//员工姓名
    @Excel(name = "所属项目组")
    private String emp_team;//所属项目组
    @Excel(name = "项目组类别")
    private String team_type;//项目组 类别
}
