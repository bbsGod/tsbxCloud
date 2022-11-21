package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.BasLbUrl;
import com.tsvhlpom.proddata.mapper.BasLbUrlMapper;
import com.tsvhlpom.proddata.service.BasLbUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasLbUrlServiceimpl implements BasLbUrlService {
    @Autowired
    private BasLbUrlMapper basLbUrlMapper;

    public List<BasLbUrl> getBasLbUrlList(BasLbUrl basLbUrl){
        return basLbUrlMapper.getBasLbUrlList(basLbUrl);
    }
    public void save(BasLbUrl basLbUrl){
        basLbUrlMapper.save(basLbUrl);
    }
    public void update(BasLbUrl basLbUrl){
        basLbUrlMapper.update(basLbUrl);
    }
    public int delete(String[] c_pk_ids){
        return  basLbUrlMapper.delete(c_pk_ids);
    }
    public BasLbUrl getBasLbUrl(String c_pk_id){
        return basLbUrlMapper.getBasLbUrl(c_pk_id);
    }


}
