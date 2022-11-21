package com.tsvhlpom.prod26.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class WebOthManagerEmail {
    /** 机构编码 */
    @Excel(name = "机构编码")
    private String c_dpt_cde;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String c_email;
}
