package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.TblConfig;

import java.util.List;

public interface TblConfigService {
    void save(TblConfig tblConfig);
    void update(TblConfig tblConfig);
    int delete(String[] c_pk_ids);
    TblConfig getTblConfig(String c_pk_id);
    List<TblConfig> getTblConfigList(TblConfig tblConfig);
}
