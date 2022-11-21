package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.WebBasNoVhlFeePropConf;
import com.tsvhlpom.proddata.mapper.WebBasNoVhlFeePropConfMapper;
import com.tsvhlpom.proddata.service.WebBasNoVhlFeePropConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebBasNoVhlFeePropConfServiceimpl implements WebBasNoVhlFeePropConfService {

    @Autowired
    private WebBasNoVhlFeePropConfMapper webBasNoVhlFeePropConfMapper;
    @Override
    public List<WebBasNoVhlFeePropConf> getList(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf) {
        return webBasNoVhlFeePropConfMapper.getList(webBasNoVhlFeePropConf);
    }

    @Override
    public WebBasNoVhlFeePropConf getNoVhlConfig(String c_pk_id) {
        return webBasNoVhlFeePropConfMapper.getNoVhlConfig(c_pk_id);
    }

    @Override
    public void update(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf) {
        webBasNoVhlFeePropConfMapper.update(webBasNoVhlFeePropConf);
    }
}
