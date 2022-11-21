package com.tsvhlpom.batchdata.gbmonthdata.service.impl;


import com.tsvhlpom.batchdata.gbmonthdata.mapper.MidDataMapper;
import com.tsvhlpom.batchdata.gbmonthdata.service.GbMonthDataService;
import com.tsvhlpom.batchdata.gbmonthdata.tools.MidDataService;
import com.tsvhlpom.batchdata.gbmonthdata.tools.QueryDataAndCreateFiles;
import com.tsvhlpom.common.core.utils.file.FileUtils;
import com.tsvhlpom.system.api.MysqlClientService;
import com.tsvhlpom.system.api.model.GbMonthDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

@Slf4j
@Service
public class GbMonthDataServiceImpl implements GbMonthDataService {

    @Autowired
    private MysqlClientService mysqlToolClient;

    @Autowired
    private QueryDataAndCreateFiles queryDataAndCreateFiles;

    @Autowired
    private MidDataService midDataService;

    @Autowired
    private MidDataMapper midDataMapper;

    @Override
    public void deleteData(String month) {
        mysqlToolClient.delete(month);
        String path = queryDataAndCreateFiles.getDPath(month);
        File DFile = new File(path);
        if (DFile.exists()) {
            for(File file : (DFile.listFiles())) {
                file.delete();
            }
        }
        midDataMapper.deleteMidDataByMonth(month);


    }

    @Override
    public void makeCsv(String month) throws Exception {
        //过滤重复请求   通过数据表 状态
        GbMonthDataDTO gbMonthDataDTO = mysqlToolClient.getGbMonthData(month).getData();
        if(gbMonthDataDTO.getCsvStatus() !=null && gbMonthDataDTO.getCsvStatus().equals("1")) {
            throw new Exception("数据正在处理中 month:" + month);
        }
        try {
            //记录数据状态
            mysqlToolClient.updateCsvStatus(month, "1");
            //数据处理 并且返回是否有异常
            Boolean flag = queryDataAndCreateFiles.execute(month);
            //更新状态
            mysqlToolClient.updateCsvStatus(month, "2");
            if (flag) {
                mysqlToolClient.updateErrStatus(month, "1");
            } else {
                mysqlToolClient.updateErrStatus(month, "2");
            }
        } catch (Exception e) {
            mysqlToolClient.updateErrStatus(month, "1");
            throw e;
        }
    }

    @Override
    public void initMidData(String month) throws Exception {
        //检查26库数据是否存在，如果存在停止流程
        int i = midDataMapper.queryMidDataByMonth(month);
        if(i > 0 ) {
            throw new Exception("数据正在处理中，或者已经处理完毕。 month：" + month);
        }
        //过滤重复请求   通过数据表 状态
        GbMonthDataDTO gbMonthDataDTO = mysqlToolClient.getGbMonthData(month).getData();
        if(gbMonthDataDTO == null) {
            mysqlToolClient.initGbMonthData(month);
        } else {
            if ("1".equals(gbMonthDataDTO.getMiddleDataStatus())) {
                throw new Exception("中间表数据正在处理中。 month：" + month);
            }
        }
        mysqlToolClient.updateMiddleDataStatus(month, "1");
        midDataService.execute(month);
        mysqlToolClient.updateMiddleDataStatus(month,"2");
    }

    @Override
    public String getErrMsg(String month) throws Exception {
        String filePath = queryDataAndCreateFiles.getDPath(month) +"光博异常数据.txt";
        StringBuffer buffer = new StringBuffer();
        try (
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bf = new BufferedReader(fileReader);
        ) {
            String s = null;
            //使用readLine方法，一次读一行
            while ((s = bf.readLine()) != null) {
                buffer.append(s.trim() + "\n");
            }
        } catch (Exception e) {
            throw  e;
        }
        return buffer.toString();
    }

    @Override
    public void downLoadErrMsg(String month, HttpServletResponse response) throws Exception {
        String filePath = queryDataAndCreateFiles.getDPath(month) + "光博异常数据.txt" ;
        FileUtils.writeBytes(filePath,response.getOutputStream());
    }
    /*public ResponseEntity<FileSystemResource> downLoadErrMsg(String month) throws Exception {
        String filePath = queryDataAndCreateFiles.getDPath(month) + "光博异常数据.txt" ;
        return downFile(filePath);
    }*/

    @Override
    public ResponseEntity<FileSystemResource> downLoadZip(String month) throws Exception {
        String filePath = queryDataAndCreateFiles.getDPath(month)+ "光博数据.zip" ;
        return downFile(filePath);
    }


    /**
     * 文件下载
     * @param fileName
     * @return FileSystemResource
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
