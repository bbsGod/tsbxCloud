package com.tsvhlpom.zentao.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class DemandDTO {

    private Integer zid;
    private String ztitle;
    private String mname;
    private String zsource;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date proonlinedate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date taskrealst;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date taskrealed;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date checkdate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date onlinedate;
    private String remarks;
}
