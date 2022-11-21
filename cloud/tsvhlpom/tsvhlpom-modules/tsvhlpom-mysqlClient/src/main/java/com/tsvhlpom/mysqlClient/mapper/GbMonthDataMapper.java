package com.tsvhlpom.mysqlClient.mapper;

import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GbMonthDataMapper {
    /**
     * 删除数据
     * @param month
     */
    void delete (@Param("month") String month);

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
    void updateMiddleDataStatus(@Param("month") String month, @Param("middleDataStatus") String middleDataStatus);

    /**
     * 根据月份获取光博月份数据表表数据
     * @param month
     * @return
     */
    GbMonthDataDTO getGbMonthData(@Param("month") String month);

    /**
     * 修改CSV状态
     * @param month
     * @param csvStatus
     */
    void updateCsvStatus(@Param("month") String month, @Param("csvStatus") String csvStatus);

    /**
     * 修改err状态
     * @param month
     * @param errStatus
     */
    void updateErrStatus(@Param("month") String month, @Param("errStatus") String errStatus);

    void initGbMonthData(@Param("month") String month);
}
