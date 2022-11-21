package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebAppBase;

import java.util.List;

public interface WebAppBaseMapper {
    List<WebAppBase> getWebAppBaseList(WebAppBase webAppBase);
    void update(WebAppBase webAppBase);
    void updatePlyBase(WebAppBase webAppBase);
    //void save(WebAppBase webAppBase);
    //int delete(String[] c_pk_ids);
    WebAppBase getWebAppBase(String c_ply_no);
    // 修改出单员工号 start
    List<WebAppBase> getAppBaseWithOpeCde(WebAppBase webAppBase);
    void updateOprCde(String c_app_no);
    // 修改出单员工号 end
}
