package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.WebAppVsTax;
import com.tsvhlpom.proddata.mapper.WebAppVsTaxMapper;
import com.tsvhlpom.proddata.service.WebAppVsTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppVsTaxServiceimpl implements WebAppVsTaxService {
    @Autowired
    private WebAppVsTaxMapper webAppVsTaxMapper;
    @Override
    public List<WebAppVsTax> getWebAppVsTaxList(String c_app_no) {
        return webAppVsTaxMapper.getWebAppVsTaxList(c_app_no);
    }

    @Override
    public void update(WebAppVsTax webAppVsTax) {
        webAppVsTaxMapper.update(webAppVsTax);
    }
}
