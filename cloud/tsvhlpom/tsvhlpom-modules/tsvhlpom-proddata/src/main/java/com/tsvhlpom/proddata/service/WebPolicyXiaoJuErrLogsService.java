package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebPolicyXiaoJuErrLogs;

import java.util.List;

public interface WebPolicyXiaoJuErrLogsService {
    String export(List<WebPolicyXiaoJuErrLogs> xiaojuList,boolean updateSupport);
}
