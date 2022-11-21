package com.tsvhlpom.mysqlClient.service.impl;

import com.tsvhlpom.mysqlClient.mapper.GbMonthDataMapper;
import com.tsvhlpom.mysqlClient.service.GbMonthDataService;
import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GbMonthDataServiceImpl implements GbMonthDataService {
    @Autowired
    private GbMonthDataMapper gbMonthDataMapper;
    @Override
    public void delete(String month) {
        gbMonthDataMapper.delete(month);
    }

    @Override
    public List<GbMonthDataDTO> findAll() {
        return gbMonthDataMapper.findAll();
    }

    @Override
    public void updateMiddleDataStatus(String month, String middleDataStatus) {
        gbMonthDataMapper.updateMiddleDataStatus(month,middleDataStatus);
    }

    @Override
    public GbMonthDataDTO getGbMonthData(String month) {
        return gbMonthDataMapper.getGbMonthData(month);
    }

    @Override
    public void updateCsvStatus(String month, String csvStatus) {
        gbMonthDataMapper.updateCsvStatus(month,csvStatus);
    }

    @Override
    public void updateErrStatus(String month, String errStatus) {
        gbMonthDataMapper.updateErrStatus(month, errStatus);
    }

    @Override
    public void initGbMonthData(String month) {
        gbMonthDataMapper.initGbMonthData(month);
    }
}
