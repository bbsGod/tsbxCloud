package com.tsvhlpom.batchdata.vhlplatdatacheck.mapper;


import com.tsvhlpom.batchdata.vhlplatdatacheck.domain.TrdAppSendPacketDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 描述
 * 车险平台对账数据Mapper
 * @Author Xinglong Lei
 * @Date 2020/3/7
 */
public interface VhlPlatDataCheckMapper {

    List<TrdAppSendPacketDO>  getQueryData(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("prodNo") String prodNo,
            @Param("dptCde") String dptCde);

    List<String> getVerifyData(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate,
            @Param("prodNo") String prodNo,
            @Param("dptCde") String dptCde,
            @Param("districtCode") String districtCode);
    List<TrdAppSendPacketDO> getCSendPacket(@Param("CQryCde") String CQryCde);
}
