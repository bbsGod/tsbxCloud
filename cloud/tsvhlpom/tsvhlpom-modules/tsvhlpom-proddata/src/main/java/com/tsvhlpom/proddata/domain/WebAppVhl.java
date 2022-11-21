package com.tsvhlpom.proddata.domain;

import com.tsvhlpom.common.core.annotation.Excel;
import lombok.Data;

@Data
public class WebAppVhl {

    @Excel(name = "投保单号")
    private String c_app_no;
    @Excel(name = "燃料能源种类代码")
    private String c_model_enery_type;

    private String c_print_usagecde;
    private String c_print_usagecde_flag;
}
