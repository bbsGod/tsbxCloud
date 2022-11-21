package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebTrdAutoPlyContact;

import java.util.List;

public interface WebTrdAutoPlyContactService {
    void save(WebTrdAutoPlyContact webTrdAutoPlyContact);
    void update(WebTrdAutoPlyContact webTrdAutoPlyContact);
    int delete(String[]  c_pk_ids);
    List<WebTrdAutoPlyContact> getWebTrdAutoPlyContactList(WebTrdAutoPlyContact webTrdAutoPlyContact);
    WebTrdAutoPlyContact getWebTrdAutoPlyContact(String c_pk_id);
}
