package com.tsvhlpom.dailywork.service;

import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.dailywork.domain.Daily_worklog;
import com.tsvhlpom.dailywork.domain.LogAnalysis;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface Daily_worklogService {
    List<Daily_worklog> getWorkLogList(Daily_worklog worklog);
    Daily_worklog getWorkLog(String pkid);
    void updateWorkLog(Daily_worklog worklog);
    void saveWorkLog(Daily_worklog worklog);
    void deleteWorkLog(String[] pkids);
    void updateWorkLogPath(String pkid,String url);
    List<LogAnalysis> logAnalysis(LogAnalysis analysis) throws ParseException;
    AjaxResult exportWorkLog(LogAnalysis logAnalysis, HttpServletResponse response) throws Exception;
}
