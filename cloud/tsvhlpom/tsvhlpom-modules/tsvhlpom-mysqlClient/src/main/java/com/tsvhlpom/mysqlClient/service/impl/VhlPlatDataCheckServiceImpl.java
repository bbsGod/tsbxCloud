package com.tsvhlpom.mysqlClient.service.impl;

import com.tsvhlpom.mysqlClient.mapper.VhlplatDataCheckMapper;
import com.tsvhlpom.mysqlClient.service.VhlPlatDataCheckService;
import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VhlPlatDataCheckServiceImpl implements VhlPlatDataCheckService {

    @Autowired
    private VhlplatDataCheckMapper vhlplatDataCheckMapper;
    @Override
    public void delete(String month) {
        vhlplatDataCheckMapper.delete(month);
    }

    @Override
    public List<VhlplatDataCheckDTO> findAll(String month) {
        List<VhlplatDataCheckDTO> list = null;
        if(month == null ){
            list =  vhlplatDataCheckMapper.findByOrderByMonthDesc();
        }else{
            list = vhlplatDataCheckMapper.findByMonthOrderByMonthDesc(month);
        }
        return list;
    }

    @Override
    public void updateErrStatus(String month, String errStatus) {
        vhlplatDataCheckMapper.updateErrStatus(month, errStatus);
    }

    @Override
    public void updateZipStatus(String month, String zipStatus) {
        vhlplatDataCheckMapper.updateZipStatus(month, zipStatus);
    }

    @Override
    public void initVhlplatDataCheck(String month) {
        vhlplatDataCheckMapper.initVhlplatDataCheck(month);
    }
}
