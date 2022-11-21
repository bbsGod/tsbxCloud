package com.tsvhlpom.batchdata.vhlplatdatacheck.service.impl;


import com.tsvhlpom.batchdata.vhlplatdatacheck.service.VhlPlatDataCheckService;
import com.tsvhlpom.batchdata.vhlplatdatacheck.tool.CommTools;
import com.tsvhlpom.batchdata.vhlplatdatacheck.tool.VhlPlatDataCheckTool;
import com.tsvhlpom.common.core.utils.file.FileUtils;
import com.tsvhlpom.system.api.MysqlClientService;
import com.tsvhlpom.system.api.model.VhlplatDataCheckDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * 描述
 * 车险平台对账数据Service
 * @Author Xinglong Lei
 * @Date 2020/3/7
 */
@Service
@Slf4j
public class VhlPlatDataCheckServiceImpl implements VhlPlatDataCheckService {

    @Autowired
    private MysqlClientService mysqlToolClient;

    @Autowired
    private VhlPlatDataCheckTool vhlPlatDataCheckTool;

    @Autowired
    private CommTools commTools;

    /**
     * 根据月份处理数据生成zip打包
     * @param month
     */
    public void makeData(String month) throws Exception {
        List<VhlplatDataCheckDTO> vhlplatDataCheckDTOList = mysqlToolClient.vPDCFindAll(month);
        if(vhlplatDataCheckDTOList != null && vhlplatDataCheckDTOList.size() >0 ) {
            log.info("平台对账数据已处理！");
            throw new Exception("平台对账数据已处理！");
        }
        mysqlToolClient.vPDCInitData(month);
        try {
            vhlPlatDataCheckTool.VPDCGetData(month);
            mysqlToolClient.updateVPDCStatus(month,"2");
            mysqlToolClient.updateVPDCErrStatus(month,"2");
        }catch(Exception e) {
            log.error("平台数据处理失败,month:" + month);
            mysqlToolClient.updateVPDCStatus(month,"2");
            mysqlToolClient.updateVPDCErrStatus(month,"1");
            throw e;
        }
    }

    /**
     * 根据月份删除数据
     * @param month
     * @throws Exception
     */
    public void deleteData(String month) throws Exception {
        String path = commTools.getPath(month);
        commTools.deleteFiles(new File(path));
        commTools.deleteFiles(new File(commTools.filePath + File.separator + month + ".zip"));
        mysqlToolClient.deleteVPDC(month);
    }

    /*@Override
    public ResponseEntity<FileSystemResource> downLoadZip(String month) throws Exception {
        String filePath = commTools.filePath+ File.separator + month + ".zip" ;
        return downFile(filePath);
    }*/

    public void downLoadZip(String month, HttpServletResponse response) throws IOException {
        String filePath = commTools.filePath+ File.separator + month + ".zip" ;
        FileUtils.writeBytes(filePath,response.getOutputStream());
    }

    /**
     * 文件下载
     * @param fileName
     * @return
     * @throws Exception
     */
    private ResponseEntity<FileSystemResource> downFile(String  fileName) throws Exception {
        File file = new File(fileName);
        if(!file.exists()) {
            log.error("文件不存在，文件路径：" + file.getAbsolutePath());
            throw new Exception("文件不存在");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" +  URLEncoder.encode(file.getName(),"UTF-8"));
        headers.add("Pragma", "no-cache");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        headers.add("Content-Length",""+ file.length());
        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));

    }

}
