package com.tsvhlpom.prodapi.taisheng.VO;

import lombok.Data;

import java.util.Date;

@Data
public class EndorsementPolicy extends Policy{
    private String correctType;//批改类型
    private String batchNum;//批单号
    private Date acceptDate;//批改日期
    private Date effectTime;//生效日期
}
