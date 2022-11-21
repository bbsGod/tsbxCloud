package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebPlyEdrErrLogs;

import java.util.List;

public interface WebPlyEdrErrLogsMapper {
    WebPlyEdrErrLogs getWebPlyEdrErrLogs(String c_pk_id);
    List<WebPlyEdrErrLogs> getWebPlyEdrErrLogsList(WebPlyEdrErrLogs webPlyEdrErrLogs);
    void update(WebPlyEdrErrLogs webPlyEdrErrLogs);
    void save(WebPlyEdrErrLogs webPlyEdrErrLogs);
    int delete(String[] c_pk_ids);
}
