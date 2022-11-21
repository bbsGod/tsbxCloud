package com.tsvhlpom.proddata.mapper;


import com.tsvhlpom.proddata.domain.BasLbUrl;

import java.util.List;

public interface BasLbUrlMapper {
    List<BasLbUrl> getBasLbUrlList(BasLbUrl basLbUrl);
    void update(BasLbUrl basLbUrl);
    void save(BasLbUrl basLbUrl);
    int delete(String[] c_pk_ids);
    BasLbUrl getBasLbUrl(String c_pk_id);
}
