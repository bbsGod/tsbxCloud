package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.proddata.domain.AbstractVO;
import com.tsvhlpom.proddata.domain.WebPolicyXiaoJuErrLogs;
import com.tsvhlpom.proddata.service.WebPolicyXiaoJuErrLogsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/xiaoju")
@Slf4j
public class WebPolicyXiaoJuErrLogsController {

    @Autowired
    private WebPolicyXiaoJuErrLogsService service;

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        log.info("模板下载");
        ExcelUtil<WebPolicyXiaoJuErrLogs> util = new ExcelUtil<WebPolicyXiaoJuErrLogs>(WebPolicyXiaoJuErrLogs.class);
        util.importTemplateExcel(response,"err模板");
    }
    /**
     * 更新客户回访状态，同时新插入到回访详情
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/export")
    public AjaxResult export(MultipartFile file, boolean updateSupport) throws Exception
    {
        log.info("WebPolicyXiaoJuErrLogs 文件上传 开始");
        ExcelUtil<WebPolicyXiaoJuErrLogs> util = new ExcelUtil<WebPolicyXiaoJuErrLogs>(WebPolicyXiaoJuErrLogs.class);
        String message = "";
        try{
            List<WebPolicyXiaoJuErrLogs> xiaojuList = util.importExcel(file.getInputStream());
            message = service.export(xiaojuList,updateSupport);
            log.info("updateVisitInfoByExport文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            log.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        log.info("updateVisitInfoByExport文件上传 结束");
        return AjaxResult.success(message);
    }
}
