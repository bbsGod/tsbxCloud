package com.tsvhlpom.batchdata.vhlplatdatacheck.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

/**
 * 描述
 * 车险平台对账数据Service
 * @Author Xinglong Lei
 * @Date 2020/3/7
 */
public interface VhlPlatDataCheckService {

    /**
     * 根据月份处理数据生成zip打包
     * @param month
     */
    void makeData(String month) throws Exception;

    /**
     * 根据月份删除数据
     * @param month
     * @throws Exception
     */
    void deleteData(String month) throws Exception;

    /**
     * 下载zip文件
     * @param month
     * @throws Exception
     */
    //ResponseEntity<FileSystemResource> downLoadZip(String month) throws Exception;
    void downLoadZip(String month, HttpServletResponse response) throws Exception;
}
