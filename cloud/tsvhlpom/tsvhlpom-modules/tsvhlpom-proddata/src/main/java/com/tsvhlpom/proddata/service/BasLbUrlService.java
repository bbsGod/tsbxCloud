package com.tsvhlpom.proddata.service;


import com.tsvhlpom.proddata.domain.BasLbUrl;

import java.util.List;

public interface BasLbUrlService {
    List<BasLbUrl> getBasLbUrlList(BasLbUrl basLbUrl);
    void save(BasLbUrl basLbUrl);
    void update(BasLbUrl basLbUrl);
    int delete(String[] c_pk_ids);
    BasLbUrl getBasLbUrl(String c_pk_id);
}
