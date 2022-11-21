package com.tsvhlpom.covid19.mapper;

import com.tsvhlpom.covid19.domain.Covid;
import com.tsvhlpom.covid19.domain.DoneList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CovidMapper {


    /**
     * 保存双码信息
     * @param covid
     */
    void save(Covid covid);

    List<Covid> getCovidList(Covid covid);

    List<Map> getSumStatistics(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);

    /**
     * 获取异常人数
     * @param c_parent_dept
     * @param c_dept
     * @param day
     * @return
     */
    List<Map> getSumExceptionStatistics(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);

    List<Map> getGroupStatistics(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);

    /**
     * 获取异常数据
     * @param c_parent_dept
     * @param c_dept
     * @param day
     * @return
     */
    List<Map> getGroupExceptionStatistics(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);

    List<Map> geteleCounts(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept);

    List<DoneList> getDoneResult(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);
    List<String> getUndoneDetial(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);


}
