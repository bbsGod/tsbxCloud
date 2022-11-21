package com.tsvhlpom.mysqlClient.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.mysqlClient.service.GbMonthDataService;
import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gbmonthdata")
public class GbMonthDataController extends BaseController {


    @Autowired
    private GbMonthDataService gbMonthDataService;

    /**
     * 获取全量光博数据 数据排序日期倒序
     * @return List<GbMonthDataDO>
     */
    @RequestMapping("findAll")
    public TableDataInfo findAll() {
        logger.info("查询光博数据 findall start");
        startPage();
        List<GbMonthDataDTO> gbMonthDataDTOList = null;
        try{
            gbMonthDataDTOList = gbMonthDataService.findAll();
            logger.info("查询光博数据 findall size:"+gbMonthDataDTOList.size());
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("查询光博数据 findall end");
        return getDataTable(gbMonthDataDTOList);
    }

    /**
     * 删除光博数据
     * @param month month
     */
    @RequestMapping("delete")
    public void delete(@RequestParam String month) {
        gbMonthDataService.delete(month);
    }

    /**
     * 修改中间表状态
     * @param month  month
     * @param middleDataStatus 中间表状态 1处理中  2 处理完毕
     */
    @RequestMapping("updateMiddleDataStatus")
    public void updateMiddleDataStatus(@RequestParam String month, @RequestParam String middleDataStatus) {
        gbMonthDataService.updateMiddleDataStatus(month, middleDataStatus);
    }

    /**
     * 修改csv 状态
     * @param month month
     * @param csvStatus csv 状态 1生成中 2 生成完毕
     */
    @RequestMapping("updateCsvStatus")
    public void updateCsvStatus(@RequestParam String month, @RequestParam String csvStatus) {
        gbMonthDataService.updateCsvStatus(month, csvStatus);
    }

    /**
     * 修改错误信息状态
     * @param month month
     * @param errStatus 错误状态 1异常  2无异常
     */
    @RequestMapping("updateErrStatus")
    public void updateErrStatus(@RequestParam String month, @RequestParam String errStatus) {
        gbMonthDataService.updateErrStatus(month, errStatus);
    }

    /**
     * 根据主键获取光博数据
     * @param month month
     * @return 光博数据
     */
    @RequestMapping("getGbMonthData")
    public R<GbMonthDataDTO> getGbMonthData(@RequestParam String month) {
        GbMonthDataDTO gbMonthDataDTO = gbMonthDataService.getGbMonthData(month);
        return  R.ok(gbMonthDataDTO);
    }

    /**
     * 初始化光博数据
     * @param month month
     */
    @RequestMapping("initGbMonthData")
    public void initGbMonthData (@RequestParam String month) {
        gbMonthDataService.initGbMonthData(month);
    }


}
