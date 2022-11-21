package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebBasEdrRsnItem;

public interface WebBasEdrRsnItemService {
    WebBasEdrRsnItem getWebBasEdrRsnItem(String c_pk_id);
    void insert(WebBasEdrRsnItem webBasEdrRsnItem);
    void delete(String c_pk_id);
}
