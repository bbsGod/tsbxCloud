package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.TblConfig;
import com.tsvhlpom.proddata.mapper.TblConfigMapper;
import com.tsvhlpom.proddata.service.TblConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblConfigServiceimpl implements TblConfigService {
    @Autowired
    private TblConfigMapper tblConfigMapper;
    @Override
    public void save(TblConfig tblConfig) {
        tblConfigMapper.save(tblConfig);
    }

    @Override
    public void update(TblConfig tblConfig) {
        tblConfigMapper.update(tblConfig);
    }

    @Override
    public int delete(String[] c_pk_ids) {
        return tblConfigMapper.delete(c_pk_ids);
    }

    @Override
    public TblConfig getTblConfig(String c_pk_id) {
        return tblConfigMapper.getTblConfig(c_pk_id);
    }

    @Override
    public List<TblConfig> getTblConfigList(TblConfig tblConfig) {
        return tblConfigMapper.getTblConfigList(tblConfig);
    }
}
