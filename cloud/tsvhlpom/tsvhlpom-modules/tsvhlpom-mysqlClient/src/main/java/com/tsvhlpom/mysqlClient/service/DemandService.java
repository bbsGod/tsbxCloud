package com.tsvhlpom.mysqlClient.service;


import com.tsvhlpom.system.api.model.DemandDTO;

import java.util.List;

public interface DemandService {

    void save(DemandDTO demandDO);
    List<DemandDTO> findByZidIn(List<Integer> zidList);

    DemandDTO getDemandByZid(Integer zid);
}
