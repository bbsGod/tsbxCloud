package com.tsvhlpom.vip.mapper;


import com.tsvhlpom.vip.domain.VIP_Main;

import java.util.List;

public interface VIP_MainMapper {
    void save(VIP_Main vip);
    List<VIP_Main> getVIPList(VIP_Main vip);

    VIP_Main getVIPByPkID(String pkId);
    
    VIP_Main getVIPByCertifCode(String certifCode);

    void update(VIP_Main vip);

    void delete(String[] pkIds);

    int checkStatus(VIP_Main vip);
}
