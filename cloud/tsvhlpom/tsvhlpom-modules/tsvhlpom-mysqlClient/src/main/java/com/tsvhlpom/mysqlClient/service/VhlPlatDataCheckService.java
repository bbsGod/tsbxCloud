package com.tsvhlpom.mysqlClient.service;

import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;

import java.util.List;

public interface VhlPlatDataCheckService {


    /**
     * 删除数据
     * @param month
     */
    void delete (String month);

    /**
     * 查询全部数据
     * @return
     */
    List<VhlplatDataCheckDTO> findAll(String month);

    /**
     * 修改err状态
     * @param month
     * @param errStatus
     */
    void updateErrStatus(String month, String errStatus);

    /**
     * 修改zip状态
     * @param month
     * @param zipStatus
     */
    void updateZipStatus(String month, String zipStatus);

    /**
     * 数据初始化，数据生成状态为1处理中
     * @param month
     */
    void initVhlplatDataCheck(String month);
}
