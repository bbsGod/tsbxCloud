package com.tsvhlpom.system.api;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.system.api.factory.RemoteFileFallbackFactory;
import com.tsvhlpom.system.api.model.DemandDTO;
import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(contextId = "mysqlClientService", value = ServiceNameConstants.MYSQLCLIENT_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface MysqlClientService {



    /**
     * 删除光博数据
     * @param month month
     */
    @GetMapping("/gbmonthdata/delete")
    void delete(@RequestParam("month") String month);

    /**
     * 修改中间表状态
     * @param month  month
     * @param middleDataStatus 中间表状态 1处理中  2 处理完毕
     */
    @GetMapping("/gbmonthdata/updateMiddleDataStatus")
    void updateMiddleDataStatus(@RequestParam("month") String month, @RequestParam("middleDataStatus") String middleDataStatus);

    /**
     * 修改csv 状态
     * @param month month
     * @param csvStatus csv 状态 1生成中 2 生成完毕
     */
    @GetMapping("/gbmonthdata/updateCsvStatus")
    void updateCsvStatus(@RequestParam("month") String month, @RequestParam("csvStatus") String csvStatus);

    /**
     * 修改错误信息状态
     * @param month month
     * @param errStatus 错误状态 1异常  2无异常
     */
    @GetMapping("/gbmonthdata/updateErrStatus")
    void updateErrStatus(@RequestParam("month") String month, @RequestParam("errStatus") String errStatus);

    /**
     * 根据主键获取光博数据
     * @param month month
     * @return 光博数据
     */
    @RequestMapping("/gbmonthdata/getGbMonthData")
    R<GbMonthDataDTO> getGbMonthData(@RequestParam("month") String month) ;

    /**
     * 初始化光博数据
     * @param month month
     */
    @RequestMapping("/gbmonthdata/initGbMonthData")
    void initGbMonthData (@RequestParam("month") String month);



    /**
     * 获取全量平台对账数据 数据排序日期倒序
     * @return List<VhlplatDataCheckDO>
     */
    @RequestMapping("/vpdc/findAll")
    List<VhlplatDataCheckDTO> findAll();

    /**
     * 初始化平台对账数据
     * @param month month
     */
    @RequestMapping("/vpdc/initData")
    void vPDCInitData (@RequestParam("month") String month);

    @RequestMapping("/vpdc/findAll")
    List<VhlplatDataCheckDTO> vPDCFindAll(@RequestParam(value="month",required = false) String month);

    @RequestMapping("/vpdc/updateVPDCStatus")
    void updateVPDCStatus(@RequestParam("month") String month, @RequestParam("zipStatus") String zipStatus);

    @RequestMapping("/vpdc/updateVPDCErrStatus")
    void updateVPDCErrStatus(@RequestParam("month") String month, @RequestParam("errStatus") String errStatus);
    @RequestMapping("/vpdc/delete")
    void deleteVPDC(@RequestParam("month") String month);


    @PostMapping("/demand/findByZidIn")
    List<DemandDTO> findDemandByZidIn(@RequestBody List<Integer> zidList);

    @PostMapping("/demand/getByZid")
    DemandDTO getDemandByZid(@RequestBody Integer zid);

}
