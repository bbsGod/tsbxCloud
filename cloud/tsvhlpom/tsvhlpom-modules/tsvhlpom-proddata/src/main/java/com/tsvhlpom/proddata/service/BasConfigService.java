package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.BasConfig;

import java.util.List;

public interface BasConfigService {
    List<BasConfig> getBasConfigList(BasConfig basConfig);
    void save(BasConfig basConfig);
    void update(BasConfig basConfig);
    int delete(String[] c_pk_ids);
    BasConfig getBasConfig(String c_pk_id);
}
