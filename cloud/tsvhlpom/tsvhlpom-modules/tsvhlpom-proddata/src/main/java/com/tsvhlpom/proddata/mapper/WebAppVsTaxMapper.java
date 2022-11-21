package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.TblPassword;
import com.tsvhlpom.proddata.domain.WebAppVsTax;

import java.util.List;

public interface WebAppVsTaxMapper {
    List<WebAppVsTax> getWebAppVsTaxList(String c_app_no);
    void update(WebAppVsTax webAppVsTax);
}
