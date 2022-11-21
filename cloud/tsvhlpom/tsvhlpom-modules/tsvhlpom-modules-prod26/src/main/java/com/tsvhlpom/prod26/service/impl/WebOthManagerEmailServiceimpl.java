package com.tsvhlpom.prod26.service.impl;

import com.tsvhlpom.prod26.domain.WebOthManagerEmail;
import com.tsvhlpom.prod26.mapper.WebOthManagerEmailMapper;
import com.tsvhlpom.prod26.service.WebOthManagerEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WebOthManagerEmailServiceimpl implements WebOthManagerEmailService {
    @Autowired
    private WebOthManagerEmailMapper webOthManagerEmailMapper;


    @Override
    public void update(String c_email,String c_dpt_cde) {
        webOthManagerEmailMapper.update(c_email,c_dpt_cde);
    }


    @Override
    public List<WebOthManagerEmail> getWebOthManagerEmailList(WebOthManagerEmail webOthManagerEmail) {
        return webOthManagerEmailMapper.getWebOthManagerEmailList(webOthManagerEmail);
    }

}
