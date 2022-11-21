package com.tsvhlpom.zentao.DO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 需求
 */

@Data
public class DemandDO {

    private Integer zid;
    private Integer zpid;
    private String zpname;
    private Integer zpri;
    private String ztitle;
    private String mname;
    private String zsource;
    private String urealname;
    private String u2realname;
    private String zstage;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date zopeneddate;
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
    private Integer sorted;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date deadline;

}
