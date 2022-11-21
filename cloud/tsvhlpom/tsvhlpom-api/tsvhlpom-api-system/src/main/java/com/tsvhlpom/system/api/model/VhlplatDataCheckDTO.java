package com.tsvhlpom.system.api.model;


import java.io.Serializable;

public class VhlplatDataCheckDTO {

    private String month;

    private String zipStatus;

    private String errStatus;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getZipStatus() {
        return zipStatus;
    }

    public void setZipStatus(String zipStatus) {
        this.zipStatus = zipStatus;
    }

    public String getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(String errStatus) {
        this.errStatus = errStatus;
    }
}
