package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.BasConfig;
import com.tsvhlpom.proddata.mapper.BasConfigMapper;
import com.tsvhlpom.proddata.service.BasConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasConfigServiceimpl implements BasConfigService {
    @Autowired
    private BasConfigMapper basConfigMapper;

    public List<BasConfig> getBasConfigList(BasConfig basConfig){
        return basConfigMapper.getBasConfigList(basConfig);
    }
    public void save(BasConfig basConfig){
        basConfigMapper.save(basConfig);
    }
    public void update(BasConfig basConfig){
        basConfigMapper.update(basConfig);
    }
    public int delete(String[] c_pk_ids){
        return  basConfigMapper.delete(c_pk_ids);
    }
    public BasConfig getBasConfig(String c_pk_id){
        return basConfigMapper.getBasConfig(c_pk_id);
    }


}
