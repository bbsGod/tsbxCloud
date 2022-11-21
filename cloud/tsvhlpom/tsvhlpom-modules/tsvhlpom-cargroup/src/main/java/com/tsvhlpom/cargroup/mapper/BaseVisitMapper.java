package com.tsvhlpom.cargroup.mapper;

import com.tsvhlpom.cargroup.domain.BaseVisit;

import java.util.List;

public interface BaseVisitMapper {
    void insert(BaseVisit baseVisit);
    List<BaseVisit> getVisitList(String c_id);
}
