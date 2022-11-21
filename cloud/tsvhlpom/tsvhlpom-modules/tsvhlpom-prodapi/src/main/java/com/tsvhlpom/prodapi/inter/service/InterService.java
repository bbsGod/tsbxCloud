package com.tsvhlpom.prodapi.inter.service;

import com.tsvhlpom.prodapi.inter.VO.InterResVO;

import java.util.Date;
import java.util.List;

public interface InterService {
    List<InterResVO> getInfo(String id, Date startDate, Date endDate) throws Exception;
}
