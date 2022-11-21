package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebAppVhl;

import java.util.List;

public interface WebAppVhlService {
    List<WebAppVhl> getList(WebAppVhl webAppVhl);
    WebAppVhl getAppVhl(String c_app_no);
    void update(WebAppVhl webAppVhl);
    void updatePrint(WebAppVhl webAppVhl);

    //导入
    String importData(List<WebAppVhl> list, boolean updateSupport, String operName);
}
