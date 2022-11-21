package com.tsvhlpom.dailywork.mapper;

import com.tsvhlpom.dailywork.domain.Daily_worklog;
import com.tsvhlpom.dailywork.domain.LogAnalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Daily_worklogMapper {

    List<Daily_worklog> getWorkLogList(Daily_worklog worklog);
    Daily_worklog getWorkLog(String pkid);
    void updateWorkLog(Daily_worklog worklog);
    void saveWorkLog(Daily_worklog worklog);
    void deleteWorkLog(String[] pkids);
    void updateWorkLogPath(@Param("pkid") String pkid, @Param("url") String url);
    List<LogAnalysis> getLogAnalysisList(@Param("emp_team") String emp_team,@Param("startDate")String startDate,@Param("endDate")String endDate);
}
