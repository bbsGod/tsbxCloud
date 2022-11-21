package com.tsvhlpom.batchdata.gbmonthdata.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface GbCheckDataMapper {

    /**
     * 查询批改起期是否为空 policy用
     * @param appNo
     * @return
     */
    @Select("select t_edr_bgn_tm from web_ply_base  where c_app_no = #{appNo}")
    Date queryBaeEdrBgnTm(@Param("appNo") String appNo);

    /**
     * 查光博报文  policy 用
     * @param appNo
     * @return
     */
    @Select("select c_packet from web_trd_ap_log l where l.c_ap_id in (select b.c_ap_id from web_app_base b where b.c_app_no = #{appNo}) and l.c_typ_cde = 'AP'")
    String queryApPacket(@Param("appNo") String appNo);

    /**
     * 查 保单批单类型  保险起期、 批改止期  policy_duty 听
     * @param plyNo
     * @return
     */
    @Select("select c_app_typ,t_insrnc_bgn_tm,t_edr_bgn_tm from web_app_base where c_ply_no = #{plyNo} order by n_edr_prj_no")
    List<Map<String, Object>> queryPlyBaseInsrnsDate(@Param("plyNo") String plyNo);

    /**
     * 校验光博险别数据使用的SQL  policy_duty 用
     * @Param plyNo
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> checkPolicyDuty(@Param(value = "plyNo") String PlyNo, @Param(value = "startDate")Date startDate, @Param(value = "endDate") Date endDate);

}
