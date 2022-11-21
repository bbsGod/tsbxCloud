package com.tsvhlpom.batchdata.gbmonthdata.mapper;

import com.tsvhlpom.batchdata.gbmonthdata.domian.PacketTempDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MidDataMapper {

    List<Map<String, Object>> queryData(@Param(value = "type") String type, @Param(value = "startDate") Date startDate, @Param(value = "endDate") Date endDate);

    void savePacketTempDO(PacketTempDO packetTempDO);

    @Select("select b.t_insrnc_bgn_tm as bgnTm, v.c_frm_no as frmNo, v.c_eng_no as engNo " +
            "from web_ply_base b, web_ply_vhl v " +
            "where b.c_app_no = v.c_app_no and b.c_ply_no = #{plyNo}  AND b.c_latest_mrk = '1'")
    List<Map> queryOriVhlData(@Param(value = "plyNo") String plyNo);

    @Select("select b.t_insrnc_bgn_tm as bgnTm from web_app_base b, web_app_vhl v " +
            "where v.c_eng_no = #{engNo}  and v.c_frm_no = #{frmNo}    and b.c_app_no = v.c_app_no" +
            " and b.c_app_typ = 'A' and b.n_ratio_coef = 1.0 and b.c_ply_sts <> 'T' " +
            "and abs(to_date(#{bgnTm}, 'yyyymmdd') - b.t_insrnc_end_tm) <= 90 ")
    List<Map> queryOrigYeasrs(@Param(value = "engNo")String engNo, @Param(value = "frmNo")String frmNo,  @Param(value = "bgnTm")String bgnTm);

    @Select("select count(c_ply_no) from web_trd_packet_temp_new t where t.c_last_mrk = #{month}")
    Integer queryMidDataByMonth(@Param(value= "month") String month);

    @Delete("DELETE FROM WEB_TRD_PACKET_TEMP_NEW WHERE C_LAST_MRK = #{month}")
    int deleteMidDataByMonth(@Param(value= "month") String month);

    List<Map<String,Object>> getPacket(@Param("plyNo") String plyNo,@Param("tradeType") String tradeType);

}
