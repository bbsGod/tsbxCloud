package com.tsvhlpom.zentao.service;



import com.tsvhlpom.zentao.DO.DemandDO;
import com.tsvhlpom.zentao.DTO.ZenTaoDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IDemandService {

    List<DemandDO> findList(ZenTaoDTO zenTaoDTO);

    void exportDemand(HttpServletResponse res, ZenTaoDTO zenTaoDTO, String type) throws Exception;

    void exportWeekly(HttpServletResponse res, ZenTaoDTO zenTaoDTO) throws Exception;

    Map<String, Object> findDemandById(Integer zid);
}
