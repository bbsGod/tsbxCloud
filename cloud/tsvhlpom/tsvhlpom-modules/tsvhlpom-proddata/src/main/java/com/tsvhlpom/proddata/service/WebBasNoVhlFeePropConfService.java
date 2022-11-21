package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebBasNoVhlFeePropConf;

import java.util.List;

public interface WebBasNoVhlFeePropConfService {
    List<WebBasNoVhlFeePropConf> getList(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf);
    WebBasNoVhlFeePropConf getNoVhlConfig(String c_pk_id);
    void update(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf);
}
