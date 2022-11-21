package com.tsvhlpom.meetingpreset.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class Person {
    private String pk_id;
    @Excel(name = "部门名称")
    private String dept_name;
    private String dept_id;//部门ID
    @Excel(name = "员工工号")
    private String person_id;
    @Excel(name = "员工姓名")
    private String person_name;
}
