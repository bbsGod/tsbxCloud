package com.tsvhlpom.cargroup.service.impl;

import com.tsvhlpom.cargroup.domain.BaseVisit;
import com.tsvhlpom.cargroup.mapper.BaseVisitMapper;
import com.tsvhlpom.cargroup.service.BaseVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseVisitServiceimpl implements BaseVisitService {

    @Autowired
    private BaseVisitMapper baseVisitMapper;

    @Override
    public void insert(BaseVisit baseVisit) {
        baseVisitMapper.insert(baseVisit);
    }

    @Override
    public List<BaseVisit> getVisitList(String c_id) {
        return baseVisitMapper.getVisitList(c_id);
    }
}
