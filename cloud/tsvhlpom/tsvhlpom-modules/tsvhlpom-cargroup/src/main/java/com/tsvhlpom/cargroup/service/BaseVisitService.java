package com.tsvhlpom.cargroup.service;

import com.tsvhlpom.cargroup.domain.BaseVisit;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseVisitService {
    void insert(BaseVisit baseVisit);
    List<BaseVisit> getVisitList(String c_id);
}
