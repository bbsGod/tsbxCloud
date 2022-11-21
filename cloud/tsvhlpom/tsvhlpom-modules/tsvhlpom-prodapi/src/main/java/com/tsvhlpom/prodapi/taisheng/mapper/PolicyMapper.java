package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.Policy;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PolicyMapper {
    List<Policy> getPolicy(@Param("startDate")Date startDate,@Param("endDate") Date endDate,@Param("appNo") String appNo);
    Map<String,Object> getToken(Long expireIn);
    Map<String,Object> getDept_ts(@Param("deptCode") String deptCode);
    String getSnrDept(@Param("deptCode") String deptCode);
}
