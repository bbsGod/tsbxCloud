package com.tsvhlpom.meetingpreset.domain;

import lombok.Data;

@Data
public class MeetingRoom {
    private String meetingroom_id;
    private String name;
    private String capacity;//会议室容纳人数
    private String equipment;//会议室支持的设备列表
    private String need_approval;//是否需要审批 0-无需审批 1-需要审批

}
