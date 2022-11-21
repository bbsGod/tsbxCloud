package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebAppVhl;

import java.util.List;

public interface WebAppVhlMapper {
    List<WebAppVhl> getList(WebAppVhl webAppVhl);
    WebAppVhl getAppVhl(String c_app_no);
    void update(WebAppVhl webAppVhl);

    void updateply(WebAppVhl webAppVhl);

    void updatePrint(WebAppVhl webAppVhl);
    void updatePlyPrint(WebAppVhl webAppVhl);
}
