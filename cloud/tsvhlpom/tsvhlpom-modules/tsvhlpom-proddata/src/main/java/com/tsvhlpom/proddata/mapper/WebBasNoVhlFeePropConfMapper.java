package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebBasNoVhlFeePropConf;

import java.util.List;

public interface WebBasNoVhlFeePropConfMapper {
    List<WebBasNoVhlFeePropConf> getList(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf);
    WebBasNoVhlFeePropConf getNoVhlConfig(String c_pk_id);
    void update(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf);
}
