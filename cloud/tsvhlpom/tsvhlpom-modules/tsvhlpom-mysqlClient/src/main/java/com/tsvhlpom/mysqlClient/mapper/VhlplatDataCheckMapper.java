package com.tsvhlpom.mysqlClient.mapper;

import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VhlplatDataCheckMapper {
    /**
     * 删除数据
     * @param month
     */
    void delete (@Param("month") String month);

    /**
     * 查询全部数据
     * @return
     */
    List<VhlplatDataCheckDTO> findByOrderByMonthDesc();
    List<VhlplatDataCheckDTO> findByMonthOrderByMonthDesc(@Param("month") String month);

    /**
     * 修改err状态
     * @param month
     * @param errStatus
     */
    void updateErrStatus(@Param("month") String month,@Param("errStatus") String errStatus);

    /**
     * 修改zip状态
     * @param month
     * @param zipStatus
     */
    void updateZipStatus(@Param("month") String month,@Param("zipStatus") String zipStatus);

    /**
     * 数据初始化，数据生成状态为1处理中
     * @param month
     */
    void initVhlplatDataCheck(@Param("month") String month);
}
