package com.tsvhlpom.prod26.service.impl;

import com.tsvhlpom.prod26.domain.WebOthManagerEmail;
import com.tsvhlpom.prod26.domain.WebOthSalesEmail;
import com.tsvhlpom.prod26.mapper.WebOthSalesEmailMapper;
import com.tsvhlpom.prod26.service.WebOthSalesEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WebOthSalesEmailServiceimpl implements WebOthSalesEmailService{
    @Autowired
    private WebOthSalesEmailMapper webOthSalesEmailMapper;


    @Override
    public void update(String c_email,String c_sls_cde) {
        webOthSalesEmailMapper.update(c_email,c_sls_cde);
    }

    @Override
    public List<WebOthSalesEmail> getWebOthSalesEmailList(WebOthSalesEmail webOthSalesEmail) {
        return webOthSalesEmailMapper.getWebOthSalesEmailList(webOthSalesEmail);
    }

}
