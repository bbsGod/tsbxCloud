package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.WebTrdAutoPlyContact;
import com.tsvhlpom.proddata.mapper.WebTrdAutoPlyContactMapper;
import com.tsvhlpom.proddata.service.WebTrdAutoPlyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebTrdAutoPlyContactServiceimpl implements WebTrdAutoPlyContactService {
    @Autowired
    private WebTrdAutoPlyContactMapper webTrdAutoPlyContactMapper;
    @Override
    public void save(WebTrdAutoPlyContact webTrdAutoPlyContact) {
        webTrdAutoPlyContactMapper.save(webTrdAutoPlyContact);
    }

    @Override
    public void update(WebTrdAutoPlyContact webTrdAutoPlyContact) {
        webTrdAutoPlyContactMapper.update(webTrdAutoPlyContact);
    }

    @Override
    public int delete(String[] c_pk_ids) {
        return webTrdAutoPlyContactMapper.delete(c_pk_ids);
    }

    @Override
    public List<WebTrdAutoPlyContact> getWebTrdAutoPlyContactList(WebTrdAutoPlyContact webTrdAutoPlyContact) {
        return webTrdAutoPlyContactMapper.getWebTrdAutoPlyContactList(webTrdAutoPlyContact);
    }

    @Override
    public WebTrdAutoPlyContact getWebTrdAutoPlyContact(String c_pk_id) {
        return webTrdAutoPlyContactMapper.getWebTrdAutoPlyContact(c_pk_id);
    }
}
