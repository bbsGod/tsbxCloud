package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebBasEdrRsnItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebBasEdrRsnItemMapper {
    WebBasEdrRsnItem getWebBasEdrRsnItem(String c_pk_id);
    void insert(WebBasEdrRsnItem webBasEdrRsnItem);
    void delete(String c_pk_id);
}
