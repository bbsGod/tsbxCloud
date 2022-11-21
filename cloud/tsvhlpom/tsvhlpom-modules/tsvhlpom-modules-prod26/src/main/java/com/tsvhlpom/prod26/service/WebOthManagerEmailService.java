package com.tsvhlpom.prod26.service;

import com.tsvhlpom.prod26.domain.WebOthManagerEmail;

import java.util.List;

public interface WebOthManagerEmailService {

    void update(String c_email,String c_dpt_cde);

    List<WebOthManagerEmail> getWebOthManagerEmailList(WebOthManagerEmail webOthManagerEmail);
}
