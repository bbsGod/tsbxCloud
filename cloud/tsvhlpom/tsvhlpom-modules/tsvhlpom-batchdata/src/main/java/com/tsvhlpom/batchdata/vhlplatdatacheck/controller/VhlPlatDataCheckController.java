package com.tsvhlpom.batchdata.vhlplatdatacheck.controller;

import com.tsvhlpom.batchdata.vhlplatdatacheck.service.VhlPlatDataCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 * 车险平台对账数据Controller
 * @Author Xinglong Lei
 * @Date 2020/3/7
 */
@RestController
@Slf4j
@RequestMapping(value="vpdc")
public class VhlPlatDataCheckController {

    @Autowired
    private VhlPlatDataCheckService vhlPlatDataCheckService;

    @RequestMapping(value = "makeData")
    public void makeData(@RequestParam String month) throws Exception {
        vhlPlatDataCheckService.makeData(month);
    }

    @RequestMapping(value = "deleteData")
    public void deleteData(@RequestParam String month) throws Exception {
        vhlPlatDataCheckService.deleteData(month);

    }


    /*public ResponseEntity<FileSystemResource> download(@RequestParam String month) throws Exception {
        log.info("下载异常数据文件开始， month" + month);
        ResponseEntity<FileSystemResource> response = vhlPlatDataCheckService.downLoadZip(month);
        log.info("下载异常数据文件结束， month" + month);
        return response;
    }*/
    @RequestMapping(value = "download")
    public void download(@RequestParam String month, HttpServletResponse response) throws Exception {
        vhlPlatDataCheckService.downLoadZip(month,response);
    }




}
