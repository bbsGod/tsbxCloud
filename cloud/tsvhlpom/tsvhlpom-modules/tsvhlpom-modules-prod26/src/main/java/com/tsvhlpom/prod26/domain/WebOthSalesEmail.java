package com.tsvhlpom.prod26.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class WebOthSalesEmail {
    /** 员工编码 */
    @Excel(name = "员工编码")
    private String c_sls_cde;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String c_email;

    /** 邮箱 */
    @Excel(name = "员工名称")
    private String c_sls_nme;
}
