package com.tsvhlpom.cargroup.mapper;

import com.tsvhlpom.cargroup.domain.BasePrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BasePriceMapper {

    List<BasePrice> getBasePriceList(BasePrice basePrice);
    List<BasePrice> getBasePriceListForUpdateStatus(BasePrice basePrice);
    BasePrice getPriceById(String pk_id);
    void save(BasePrice basePrice);
    void update(BasePrice basePrice);
    void delete(String[] pk_ids);
    List<Map> selectAppStatus(@Param("plateNo") String plateNo, @Param("insuredName") String insuredName,@Param("params") Map<String, Object> params);
    List<Map> selectPlyStatus(@Param("plateNo") String plateNo,@Param("insuredName") String insuredName,@Param("params") Map<String, Object> params);
}
