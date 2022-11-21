package com.tsvhlpom.mysqlClient.service;

import com.tsvhlpom.system.api.model.GbMonthDataDTO;

import java.util.List;

public interface GbMonthDataService {
    /**
     * 删除数据
     * @param month
     */
    void delete (String month);

    /**
     * 查询全部数据
     * @return
     */
    List<GbMonthDataDTO> findAll();

    /**
     * 修改中间表数据状态
     * @param month
     * @param middleDataStatus
     */
    void updateMiddleDataStatus(String month, String middleDataStatus);

    /**
     * 根据月份获取光博月份数据表表数据
     * @param month
     * @return
     */
    GbMonthDataDTO getGbMonthData(String month);

    /**
     * 修改CSV状态
     * @param month
     * @param csvStatus
     */
    void updateCsvStatus(String month, String csvStatus);

    /**
     * 修改err状态
     * @param month
     * @param errStatus
     */
    void updateErrStatus(String month, String errStatus);

    void initGbMonthData(String month);
}
