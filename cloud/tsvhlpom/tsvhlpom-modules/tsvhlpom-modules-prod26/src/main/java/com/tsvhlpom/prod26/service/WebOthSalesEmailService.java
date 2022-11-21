package com.tsvhlpom.prod26.service;



import com.tsvhlpom.prod26.domain.WebOthSalesEmail;

import java.util.List;

public interface WebOthSalesEmailService {
    void update(String c_email,String c_sls_cde);

    List<WebOthSalesEmail> getWebOthSalesEmailList(WebOthSalesEmail webOthSalesEmail);
}
