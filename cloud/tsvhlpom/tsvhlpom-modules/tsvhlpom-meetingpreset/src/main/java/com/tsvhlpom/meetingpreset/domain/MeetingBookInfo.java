package com.tsvhlpom.meetingpreset.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MeetingBookInfo {

    private String meetingRoom_id;//会议室ID
    private String meetingRoom_name;//会议室名称
    private String dept_id;
    private String dept_name;//部门名称
    private String applyer_id;//预订人
    private String applyer_Name;//预订人
    private String bookTime;//预定时间
    private String meet_Time;//会议时间
    private Date meeting_startTm;//会议开始时间
    private Date meeting_endTm;//会议结束时间
    private String meeting_use;//会议用品
    private String sp_no;//审批ID
    //1-审批中；2-已通过；3-已驳回；4-已撤销；6-通过后撤销；7-已删除；10-已支付
    private String sp_status;//会议室审批状态
}
