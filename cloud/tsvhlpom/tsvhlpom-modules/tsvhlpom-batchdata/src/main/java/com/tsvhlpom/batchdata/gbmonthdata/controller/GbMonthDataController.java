package com.tsvhlpom.batchdata.gbmonthdata.controller;

import com.tsvhlpom.batchdata.gbmonthdata.domian.GbMonthDataDTO;
import com.tsvhlpom.batchdata.gbmonthdata.service.GbMonthDataService;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("gbMonthData")
public class GbMonthDataController extends BaseController {


    @Autowired
    private GbMonthDataService gbMonthDataService;

    /**
     * 初始化当月中间表数据
     */
    @RequestMapping("initMiddleData")
    public void initMiddleData(@RequestParam("month") String month) throws Exception {
        logger.info("光博基础数据：initMiddleData start@@@@" + month);
        gbMonthDataService.initMidData(month);
        logger.info("光博基础数据：initMiddleData end@@@" + month);
    }

    /**
     * 删除当月数据包括中间表和CSV和压缩包
     * @param month 前端传递的年-月
     */
    @RequestMapping(value = "deleteData")
    @RequiresPermissions(value = "batchdata:gbMonthData:delete")
    @Log(title = "光博数据",businessType = BusinessType.DELETE)
    public void deleteData(@RequestParam String month) {
        gbMonthDataService.deleteData(month);

        log.info("删除数据，month：" + month);

    }

    /**
     * 重新生成csv文件并且进行打包
     * @param month 前端传递的年-月
     */
    @RequestMapping(value = "makeCsv")
    public void makeCsv(@RequestParam String month) throws Exception {
        log.info("生成光博文件开始, month:" + month);
        gbMonthDataService.makeCsv(month);
        log.info("生成光博文件结束, month:" + month);
    }

    /**
     * 显示错误信息
     * @param month 前端传递的年-月
     */
    @RequestMapping(value = "getErrMsg")
    public String getErrMsg(@RequestParam String month) throws Exception {
        log.info("获取光博异常数据开始, month:" + month);
        String reStr = gbMonthDataService.getErrMsg(month);
        log.info("获取光博异常数据开始, month:" + month);
        return  reStr;
    }

    /**
     * 下载错误文件
     * @param month
     * @throws Exception
     */
    @RequestMapping(value = "downLoadErrMsg")
    public void downLoadErrMsg(@RequestParam String month, HttpServletResponse response) throws Exception {
        gbMonthDataService.downLoadErrMsg(month,response);
    }
    /*public ResponseEntity<FileSystemResource> downLoadErrMsg(@RequestParam String month) throws Exception {
        log.info("下载异常数据文件开始， month" + month);
        ResponseEntity<FileSystemResource> response = gbMonthDataService.downLoadErrMsg(month);
        log.info("下载异常数据文件结束， month" + month);
        return response;
    }*/
    /**
     * 下载CSV文件
     * @param month
     * @throws Exception
     */
    @RequestMapping(value = "downLoadZip")
    public ResponseEntity<FileSystemResource> downLoadZip(@RequestParam String month) throws Exception {
        log.info("下载异常数据文件开始， month" + month);
        ResponseEntity<FileSystemResource> response = gbMonthDataService.downLoadZip(month);
        log.info("下载异常数据文件结束， month" + month);
        return response;
    }
}
