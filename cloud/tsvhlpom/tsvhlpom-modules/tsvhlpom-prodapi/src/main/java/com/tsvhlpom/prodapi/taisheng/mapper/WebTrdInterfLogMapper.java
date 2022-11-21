package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.WebTrdInterfLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WebTrdInterfLogMapper {
    Integer selectLog(@Param("appNo") String appNo);
    void saveLog(WebTrdInterfLog webTrdInterfLog);
    List<Map<String,Object>> getFailedList(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("appNo") String appNo);
    void updateLog(WebTrdInterfLog webTrdInterfLog);
}
