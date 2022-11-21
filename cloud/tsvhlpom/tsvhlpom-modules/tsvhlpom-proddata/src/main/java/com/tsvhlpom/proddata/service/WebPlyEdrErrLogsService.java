package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebPlyEdrErrLogs;

import java.util.List;

public interface WebPlyEdrErrLogsService {
    WebPlyEdrErrLogs getWebPlyEdrErrLogs(String c_pk_id);
    List<WebPlyEdrErrLogs> getWebPlyEdrErrLogsList(WebPlyEdrErrLogs webPlyEdrErrLogs);
    void update(WebPlyEdrErrLogs webPlyEdrErrLogs);
    void save(WebPlyEdrErrLogs webPlyEdrErrLogs);
    int delete(String[] c_pk_ids);
    //导入
    String importData(List<WebPlyEdrErrLogs> webPlyEdrErrLogsList, boolean updateSupport, String operName);
}
