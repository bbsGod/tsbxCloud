package com.tsvhlpom.prodapi.taisheng.service;

import com.tsvhlpom.prodapi.taisheng.VO.Policy;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TaiShengService {
    String rePushPolicyToTaiSheng(String startDateStr,String endDateStr,String appNo) throws Exception;
    void pushPolicyAndEndor(Date startDate,Date endDate) throws Exception;
}
