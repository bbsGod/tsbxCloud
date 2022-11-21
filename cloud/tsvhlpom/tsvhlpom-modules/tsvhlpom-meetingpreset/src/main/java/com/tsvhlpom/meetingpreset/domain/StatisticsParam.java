package com.tsvhlpom.meetingpreset.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StatisticsParam {
    public Date beginmeeting_starttm;
    public Date endmeeting_starttm;
    public Date beginmeeting_endtm;
    public Date endmeeting_endtm;

    public Date getBeginmeeting_starttm() {
        return beginmeeting_starttm;
    }

    public void setBeginmeeting_starttm(Date beginmeeting_starttm) {
        this.beginmeeting_starttm = beginmeeting_starttm;
    }

    public Date getEndmeeting_starttm() {
        return endmeeting_starttm;
    }

    public void setEndmeeting_starttm(Date endmeeting_starttm) {
        this.endmeeting_starttm = endmeeting_starttm;
    }

    public Date getBeginmeeting_endtm() {
        return beginmeeting_endtm;
    }

    public void setBeginmeeting_endtm(Date beginmeeting_endtm) {
        this.beginmeeting_endtm = beginmeeting_endtm;
    }

    public Date getEndmeeting_endtm() {
        return endmeeting_endtm;
    }

    public void setEndmeeting_endtm(Date endmeeting_endtm) {
        this.endmeeting_endtm = endmeeting_endtm;
    }
}
