package com.tsvhlpom.vip.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;


import java.util.Date;

/**
 * 节假日配置表表 sys_role
 *
 * @author taishanpic
 */
@Data
public class VipDay {
    /** 主键PKID */
    private String pkId;

    /** 节假日名称 */
    @Excel(name = "节假日名称")
    private String dayName;

    /** 节假日日期 */
    @Excel(name = "节假日日期",dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dayDate;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 创建人 */
    private String createBy;

    /** 修改日期 */
    private Date updateDate;

    /** 修改人 */
    private String updateBy;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    @Excel(name = "短信祝福标题")
    private String preFixMessage;//短信前缀
    @Excel(name = "短信后缀")
    private String surFixMessage;//短信后缀

}
