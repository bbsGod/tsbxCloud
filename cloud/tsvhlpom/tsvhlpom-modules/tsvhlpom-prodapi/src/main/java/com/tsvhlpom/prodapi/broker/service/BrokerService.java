package com.tsvhlpom.prodapi.broker.service;

import com.tsvhlpom.prodapi.broker.VO.Broker;

import java.util.List;

public interface BrokerService {
    List<Broker> getBrokerList(Broker broker);
    Broker getBroker(String c_pk_id);
    void update(Broker broker);
    void save(Broker broker);
    int delete(String[] c_pk_ids);
    String importData(List<Broker> brokerList, boolean updateSupport, String operName) throws Exception;
}
