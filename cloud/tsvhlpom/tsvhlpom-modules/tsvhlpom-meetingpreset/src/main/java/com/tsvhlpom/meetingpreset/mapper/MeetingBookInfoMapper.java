package com.tsvhlpom.meetingpreset.mapper;

import com.tsvhlpom.meetingpreset.domain.MeetingBookInfo;
import com.tsvhlpom.meetingpreset.domain.StatisticsParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MeetingBookInfoMapper {

    /**
     * 根据审批ID查看是否审批通过
     * @param sp_no
     * @return
     */
    int getSpInfoBySpNoAndSpStatus(@Param("sp_no") String sp_no);
    void save(MeetingBookInfo meetingBookInfo);
    void update(MeetingBookInfo meetingBookInfo);
    MeetingBookInfo getSpInfoBySpNo(@Param("sp_no") String sp_no);
    List<MeetingBookInfo> showInfo(MeetingBookInfo meetingBookInfo);
    List<MeetingBookInfo> getUnPassList();

    //统计分析：表
    List<Map<String,String>> statisticsTable(StatisticsParam statisticsParam);
}
