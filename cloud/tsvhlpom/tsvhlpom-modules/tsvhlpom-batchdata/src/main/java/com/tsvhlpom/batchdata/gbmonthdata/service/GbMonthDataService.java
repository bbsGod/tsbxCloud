package com.tsvhlpom.batchdata.gbmonthdata.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

public interface GbMonthDataService {


    /**
     * 数据删除，包括文件、中间表数据、日志表
     * @param month
     */
    void deleteData(String month);

    /**
     * 制作CSV并进行打压缩包
     * @param month
     * @throws Exception
     */
    void makeCsv(String month)  throws Exception;

    /**
     * 初始化中间表数据
     * @param month
     * @throws Exception
     */
    void initMidData(String month)  throws Exception;

    /**
     * 获取异常日志
     * @param month
     * @throws Exception
     */
    String getErrMsg(String month)  throws Exception;

    /**
     * 下载错误文件
     * @param month
     * @throws Exception
     */
    void downLoadErrMsg(String month, HttpServletResponse response) throws Exception;
    //ResponseEntity<FileSystemResource> downLoadErrMsg(String month) throws Exception;

    /**
     * 下载zip文件
     * @param month
     * @throws Exception
     */
    ResponseEntity<FileSystemResource> downLoadZip(String month) throws Exception;
}
