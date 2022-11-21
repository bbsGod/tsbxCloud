package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.EndorsementPolicy;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EndorsementPolicyMapper {
    List<EndorsementPolicy> getEndorList(@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("appNo") String appNo);
}
