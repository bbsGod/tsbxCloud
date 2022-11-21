package com.tsvhlpom.vip.mapper;


import com.tsvhlpom.vip.domain.SendMsg;

import java.util.List;

public interface SendMsgMapper {
    List<SendMsg> getSpCustList();
    List<SendMsg> getVIPPlyInfoList();
}
