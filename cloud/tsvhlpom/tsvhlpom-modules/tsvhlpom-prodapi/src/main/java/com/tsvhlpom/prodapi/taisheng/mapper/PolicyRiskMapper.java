package com.tsvhlpom.prodapi.taisheng.mapper;

import com.tsvhlpom.prodapi.taisheng.VO.PolicyRisk;

import java.util.List;

public interface PolicyRiskMapper {
    List<PolicyRisk> getPolicyRiskList(String appNo);
}
