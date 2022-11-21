package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.CostRatio;

import java.util.List;

public interface CostRatioMapper {
    List<CostRatio> getCostRatio(String appNo);
}
