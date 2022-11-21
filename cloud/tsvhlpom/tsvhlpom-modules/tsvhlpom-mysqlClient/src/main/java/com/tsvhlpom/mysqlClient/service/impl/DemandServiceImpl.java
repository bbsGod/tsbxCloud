package com.tsvhlpom.mysqlClient.service.impl;

import com.tsvhlpom.mysqlClient.mapper.DemandMapper;
import com.tsvhlpom.mysqlClient.service.DemandService;
import com.tsvhlpom.system.api.model.DemandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandServiceImpl implements DemandService {


    @Autowired
    private DemandMapper demandMapper;

    @Override
    public void save(DemandDTO demandDO) {
        Optional<DemandDTO> opt = demandMapper.findById(demandDO.getZid());

        if(opt.isPresent()){
            demandMapper.update(demandDO);
        }else{
            demandMapper.save(demandDO);
        }

    }

    public List<DemandDTO> findByZidIn(List<Integer> zidList) {
        return demandMapper.findByZidIn(zidList);
    }

    public DemandDTO getDemandByZid(Integer zid) {
        Optional<DemandDTO> opt = demandMapper.findById(zid);
        return opt.orElseGet(()->new DemandDTO());

    }

}
