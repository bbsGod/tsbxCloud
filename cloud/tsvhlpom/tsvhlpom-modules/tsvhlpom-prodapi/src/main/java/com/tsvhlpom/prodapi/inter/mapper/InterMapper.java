package com.tsvhlpom.prodapi.inter.mapper;

import com.tsvhlpom.prodapi.inter.VO.InterCvrgVO;
import com.tsvhlpom.prodapi.inter.VO.InterResVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InterMapper {
    List<InterResVO> getInfo(@Param("id") String id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    String getFlatUsageCode(@Param("c_class") String c_class,@Param("code") String code);

    List<InterCvrgVO> getCvrg(@Param("appNo") String appNo);
}
