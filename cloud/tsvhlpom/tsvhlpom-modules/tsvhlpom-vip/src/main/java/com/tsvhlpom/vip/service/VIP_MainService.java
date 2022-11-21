package com.tsvhlpom.vip.service;


import com.tsvhlpom.vip.domain.VIP_Main;

import java.util.List;

public interface VIP_MainService {
    //保存
    void save(VIP_Main vip);
    //获取vip信息
    List<VIP_Main> getVIPList(VIP_Main vip);
    //根据主键获取vip
    VIP_Main getVIPByPkID(String pkId);
    //更新
    void update(VIP_Main vip);
    //删除
    void delete(String[] pkIds);
    //导入
    String importData(List<VIP_Main> vipList, boolean updateSupport, String operName);
    //查看是否已承保
    int checkStatus(VIP_Main vip);
}
