package com.tsvhlpom.proddata.service;


import com.tsvhlpom.proddata.domain.WebAppBase;

import java.util.List;

public interface WebAppBaseService {
    //修改中介信息 part start
    List<WebAppBase> getWebAppBaseList(WebAppBase webAppBase);
    void update(WebAppBase webAppBase);
    WebAppBase getWebAppBase(String c_ply_no);
    //修改中介信息 part end
    // 修改出单员工号 part start
    List<WebAppBase> getAppBaseWithOpeCde(WebAppBase webAppBase);
    void updateOprCde(String c_app_no);
    // 修改出单员工号 part end

    //导入
    String importData(List<WebAppBase> list, boolean updateSupport, String operName);
}
