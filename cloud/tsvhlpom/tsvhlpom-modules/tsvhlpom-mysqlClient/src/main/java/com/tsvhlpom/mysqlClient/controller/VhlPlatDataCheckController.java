package com.tsvhlpom.mysqlClient.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.mysqlClient.service.VhlPlatDataCheckService;
import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "vpdc")
public class VhlPlatDataCheckController extends BaseController {


    @Autowired
    private VhlPlatDataCheckService vhlPlatDataCheckService;

    /**
     * 获取全量平台对账数据 数据排序日期倒序
     * @return List<VhlplatDataCheckDO>
     */
    @RequestMapping("getCheckList")
    public TableDataInfo getCheckList(@RequestParam(value="month",required = false) String month) {
        logger.info("查询对账数据 findall start");
        startPage();
        List<VhlplatDataCheckDTO> vhlplatDataCheckDTOList = null;
        try{
            vhlplatDataCheckDTOList = vhlPlatDataCheckService.findAll(month);
            logger.info("查询对账数据 findall size:"+vhlplatDataCheckDTOList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("查询光博数据 findall end");
        return getDataTable(vhlplatDataCheckDTOList);
    }
    @RequestMapping("findAll")
    public List<VhlplatDataCheckDTO> findAll(@RequestParam(value="month",required = false) String month){
        return vhlPlatDataCheckService.findAll(month);
    }
    /**
     * 删除平台对账数据
     * @param month month
     */
    @RequestMapping("delete")
    public void delete(@RequestParam String month) {
        vhlPlatDataCheckService.delete(month);
    }

    /**
     * 修改zip 状态
     * @param month month
     * @param zipStatus zip 状态 1生成中 2 生成完毕
     */
    @RequestMapping("updateVPDCStatus")
    public void updateVPDCStatus(@RequestParam String month, @RequestParam String zipStatus) {
        vhlPlatDataCheckService.updateZipStatus(month, zipStatus);
    }

    /**
     * 修改错误信息状态
     * @param month month
     * @param errStatus 错误状态 1异常  2无异常
     */
    @RequestMapping("updateVPDCErrStatus")
    public void updateVPDCErrStatus(@RequestParam String month, @RequestParam String errStatus) {
        vhlPlatDataCheckService.updateErrStatus(month, errStatus);
    }

    /**
     * 初始化平台对账数据
     * @param month month
     */
    @RequestMapping("initData")
    public void initData (@RequestParam String month) {
        vhlPlatDataCheckService.initVhlplatDataCheck(month);
    }

}
