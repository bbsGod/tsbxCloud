package com.tsvhlpom.covid19.service;

import com.tsvhlpom.covid19.domain.Covid;
import com.tsvhlpom.covid19.domain.DoneList;
import com.tsvhlpom.covid19.domain.Emplyee;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CovidService {
    /**
     * 保存双码信息
     * @param covid
     */
    void save(Covid covid) throws Exception;

    List<Covid> getCovidList(Covid covid);

    void exportInfo(Covid covid, HttpServletResponse response) throws Exception;

    Map statistics(String c_parent_dept, String c_dept, String day);
    List<DoneList> getDoneResult(String c_parent_dept, String c_dept, String day);
    List<String> getUndoneDetial(String c_parent_dept, String c_dept, String day);
    List<Emplyee> getUnDoneResult(String c_parent_dept, String c_dept, String day);

    String getName(String c_phone);
}
