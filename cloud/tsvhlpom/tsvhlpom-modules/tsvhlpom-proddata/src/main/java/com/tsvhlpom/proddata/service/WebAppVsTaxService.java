package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebAppVsTax;

import java.util.List;

public interface WebAppVsTaxService {
    List<WebAppVsTax> getWebAppVsTaxList(String c_app_no);
    void update(WebAppVsTax webAppVsTax);
}
