package com.tsvhlpom.meetingpreset.service;

import com.tsvhlpom.meetingpreset.domain.MeetingBookInfo;
import com.tsvhlpom.meetingpreset.domain.MeetingRoom;
import com.tsvhlpom.meetingpreset.domain.StatisticsParam;

import java.util.List;
import java.util.Map;

public interface MeetingService {
    /**
     * 获取会议token
     * @return
     */
    String getMeetRoom_token();
    void getMeetingList(String token);
    List<MeetingRoom> getMeetingRoomListFromRedis();
    void genMeetingBookInfo() throws Exception;
    List<MeetingBookInfo> showInfo(MeetingBookInfo meetingBookInfo);
    List<Map<String,String>> statisticsTable(StatisticsParam statisticsParam);
    Map statisticsPic(StatisticsParam statisticsParam);

    //全量同步 部门和员工
    void synchronousDeptAndUser();
}
