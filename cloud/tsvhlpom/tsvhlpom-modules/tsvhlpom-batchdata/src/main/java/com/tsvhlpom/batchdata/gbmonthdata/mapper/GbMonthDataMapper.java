package com.tsvhlpom.batchdata.gbmonthdata.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface GbMonthDataMapper {

    /**
     * 查询policy数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryPolicy(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

    /**
     *  查询光博 policy_duty(险别)数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryPolicyDuty(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

    /**
     * 查询光博 交强险赔付成本数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryJqPayCost(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

    /**
     * 查询光博车损险纯风险保费数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryPureRiskPremium(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

    /**
     * 查询光博增值服务数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryAddService(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);


    /**
     * 查询车慧达货车数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryChdTruckVhl(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);


    /**
     * 查询车慧达私家车数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryChdPrivateVhl(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);


    /**
     * 查询车慧达轨迹因子
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryChdGjDivisor(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

    /**
     * 查询车慧达小货车数据
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryChdBuggyVhl(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);


    /**
     * 查询车慧达高速因子
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> queryChdGsDivisor(@Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);



}
