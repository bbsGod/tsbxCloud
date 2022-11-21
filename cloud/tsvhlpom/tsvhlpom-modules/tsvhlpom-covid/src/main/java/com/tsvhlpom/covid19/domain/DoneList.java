package com.tsvhlpom.covid19.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class DoneList {
    @Excel(name = "总公司/分公司")
    private String c_parent_dept;
    @Excel(name = "总部部门/各机构")
    private String c_dept;
    @Excel(name = "已填写")
    private String c_done;
    @Excel(name = "未填写")
    private String c_undone;
    private String day;
}
