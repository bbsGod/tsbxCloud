package com.tsvhlpom.zentao.controller;


import com.tsvhlpom.zentao.DO.DemandDO;
import com.tsvhlpom.zentao.DTO.ZenTaoDTO;
import com.tsvhlpom.zentao.service.IDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author: Leixl
 */

@RestController
@RequestMapping("demand")
public class DemandController {
    @Autowired
    private IDemandService demandService;

    @RequestMapping(value = "findList")
    public List<DemandDO> findList(@RequestBody(required = false) ZenTaoDTO zenTaoDTO) {
        return demandService.findList(zenTaoDTO);
    }

    /**
     * 导出需求单
     * @param res httprequest
     * @param productId 产品代码
     * @param startDate 导出开始日期
     * @param onlineDate 默认上线日期
     * @throws Exception
     */
    @RequestMapping(value = "exportDemand")
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public void exportDemand(HttpServletResponse res, @RequestParam String productId, @RequestParam String startDate, @RequestParam String onlineDate, @RequestParam String type) throws Exception {

        System.out.println(type);
        ZenTaoDTO zenTaoDTO = new ZenTaoDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        zenTaoDTO.setProductId(Integer.parseInt(productId));
        zenTaoDTO.setStartDate(sdf.parse(startDate));
        if(onlineDate != null && !"".equals(onlineDate)) {
            zenTaoDTO.setOnlineDate(sdf.parse(onlineDate));
        }
        demandService.exportDemand(res, zenTaoDTO, type);
        System.out.println("success");
    }

    @RequestMapping(value = "exportWeekly")
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public void exportWeekly(HttpServletResponse res, @RequestParam String productId, @RequestParam String startDate, @RequestParam String onlineDate) throws Exception {
        ZenTaoDTO zenTaoDTO = new ZenTaoDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        zenTaoDTO.setProductId(Integer.parseInt(productId));
        zenTaoDTO.setStartDate(sdf.parse(startDate));
        if(onlineDate != null && !"".equals(onlineDate)) {
            zenTaoDTO.setOnlineDate(sdf.parse(onlineDate));
        }
        demandService.exportWeekly(res, zenTaoDTO);
        System.out.println("success");
    }

    @RequestMapping(value = "findDemandById")
    public Map<String, Object> findDemandById(@RequestParam Integer zid) throws Exception {
        return demandService.findDemandById(zid);
    }

}
