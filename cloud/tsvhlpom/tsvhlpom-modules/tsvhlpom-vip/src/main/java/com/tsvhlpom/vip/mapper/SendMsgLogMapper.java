package com.tsvhlpom.vip.mapper;

import com.tsvhlpom.vip.domain.SendMsgLog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SendMsgLogMapper {
    List<SendMsgLog> getSendMsgLog(SendMsgLog sendMsgLog);
    @Transactional
    void saveSendMsgLog(SendMsgLog sendMsgLog);
}
