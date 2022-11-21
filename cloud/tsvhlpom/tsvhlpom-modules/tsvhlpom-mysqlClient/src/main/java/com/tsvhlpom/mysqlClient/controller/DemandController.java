package com.tsvhlpom.mysqlClient.controller;

import com.tsvhlpom.mysqlClient.service.DemandService;
import com.tsvhlpom.system.api.model.DemandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @RequestMapping(value = "save")
    public void save(@RequestBody(required = false) DemandDTO demandDO) {
        demandService.save(demandDO);
    }

    @RequestMapping(value = "findByZidIn")
    public List<DemandDTO> findByZidIn(@RequestBody List<Integer> zidList) {
        return demandService.findByZidIn(zidList);
    }

    @RequestMapping(value="getByZid")
    public DemandDTO getDemandByZid(@RequestBody Integer zid) {
        DemandDTO demandDO = demandService.getDemandByZid(zid);
        return demandDO == null ? new DemandDTO() : demandDO;
    }



}
