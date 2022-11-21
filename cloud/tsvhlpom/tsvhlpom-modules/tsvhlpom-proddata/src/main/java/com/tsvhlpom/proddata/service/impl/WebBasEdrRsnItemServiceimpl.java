package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.WebBasEdrRsnItem;
import com.tsvhlpom.proddata.mapper.WebBasEdrRsnItemMapper;
import com.tsvhlpom.proddata.service.WebBasEdrRsnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebBasEdrRsnItemServiceimpl implements WebBasEdrRsnItemService {

    @Autowired
    private WebBasEdrRsnItemMapper webBasEdrRsnItemMapper;
    @Override
    public WebBasEdrRsnItem getWebBasEdrRsnItem(String c_pk_id) {
        return webBasEdrRsnItemMapper.getWebBasEdrRsnItem(c_pk_id);
    }

    @Override
    public void insert(WebBasEdrRsnItem webBasEdrRsnItem) {
        webBasEdrRsnItemMapper.insert(webBasEdrRsnItem);
    }

    @Override
    public void delete(String c_pk_id) {
        webBasEdrRsnItemMapper.delete(c_pk_id);
    }
}
