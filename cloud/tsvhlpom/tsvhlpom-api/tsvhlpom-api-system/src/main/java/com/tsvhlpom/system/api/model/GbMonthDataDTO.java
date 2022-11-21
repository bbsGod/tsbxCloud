package com.tsvhlpom.system.api.model;


public class GbMonthDataDTO {
    private String month;

    private String middleDataStatus;

    private String csvStatus;

    private String errStatus;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMiddleDataStatus() {
        return middleDataStatus;
    }

    public void setMiddleDataStatus(String middleDataStatus) {
        this.middleDataStatus = middleDataStatus;
    }

    public String getCsvStatus() {
        return csvStatus;
    }

    public void setCsvStatus(String csvStatus) {
        this.csvStatus = csvStatus;
    }

    public String getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(String errStatus) {
        this.errStatus = errStatus;
    }
}
