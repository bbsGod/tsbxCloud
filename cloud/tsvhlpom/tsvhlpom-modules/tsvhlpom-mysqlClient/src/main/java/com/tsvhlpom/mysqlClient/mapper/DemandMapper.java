package com.tsvhlpom.mysqlClient.mapper;

import com.tsvhlpom.system.api.model.DemandDTO;

import java.util.List;
import java.util.Optional;

public interface DemandMapper {
    void save(DemandDTO demandDO);
    void update(DemandDTO demandDO);
    List<DemandDTO> findByZidIn(List<Integer> zidList);

    DemandDTO getDemandByZid(Integer zid);
    Optional<DemandDTO> findById(Integer zid);
}
