package com.tsvhlpom.prodapi.broker.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.system.api.domain.SysDictData;
import lombok.Data;

import java.util.Date;

@Data
public class Broker {

    private String c_pk_id;
    @Excel(name = "上级归属机构代码",prompt = "",handler = SysDictData.class)
    private String c_id;
    @Excel(name = "中介机构代码",cellType = Excel.ColumnType.STRING)
    private String c_brkr_cde;
    @Excel(name = "中介机构名称",cellType = Excel.ColumnType.STRING)
    private String c_brkr_nme;
    private String c_create_by;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date t_create_tm;
    private String c_update_by;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date t_update_tm;
}
