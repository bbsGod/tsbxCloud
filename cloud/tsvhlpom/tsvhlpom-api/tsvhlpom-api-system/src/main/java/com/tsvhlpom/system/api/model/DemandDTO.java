package com.tsvhlpom.system.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


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

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getZtitle() {
        return ztitle;
    }

    public void setZtitle(String ztitle) {
        this.ztitle = ztitle;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getZsource() {
        return zsource;
    }

    public void setZsource(String zsource) {
        this.zsource = zsource;
    }

    public Date getProonlinedate() {
        return proonlinedate;
    }

    public void setProonlinedate(Date proonlinedate) {
        this.proonlinedate = proonlinedate;
    }

    public Date getTaskrealst() {
        return taskrealst;
    }

    public void setTaskrealst(Date taskrealst) {
        this.taskrealst = taskrealst;
    }

    public Date getTaskrealed() {
        return taskrealed;
    }

    public void setTaskrealed(Date taskrealed) {
        this.taskrealed = taskrealed;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public Date getOnlinedate() {
        return onlinedate;
    }

    public void setOnlinedate(Date onlinedate) {
        this.onlinedate = onlinedate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
