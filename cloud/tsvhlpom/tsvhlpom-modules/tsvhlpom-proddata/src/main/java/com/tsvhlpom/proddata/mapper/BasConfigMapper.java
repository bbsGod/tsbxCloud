package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.BasConfig;

import java.util.List;

public interface BasConfigMapper {
    List<BasConfig> getBasConfigList(BasConfig basConfig);
    void update(BasConfig basConfig);
    void save(BasConfig basConfig);
    int delete(String[] c_pk_ids);
    BasConfig getBasConfig(String c_pk_id);
}
