package com.tsvhlpom.proddata.controller;

import java.io.IOException;
import java.util.List;

import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.WebPolicyThirdErrLogs;
import com.tsvhlpom.proddata.service.IWebPolicyThirdErrLogsService;
import com.tsvhlpom.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 统一对接平台Controller
 *
 * @author ruoyi
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/webPolicyThirdErrLogs")
public class WebPolicyThirdErrLogsController extends BaseController
{
    @Autowired
    private IWebPolicyThirdErrLogsService webPolicyThirdErrLogsService;

    /**
     * 查询统一对接平台列表
     */
    @GetMapping("/list")
    public TableDataInfo list(WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        startPage();
        List<WebPolicyThirdErrLogs> list = webPolicyThirdErrLogsService.selectWebPolicyThirdErrLogsList(webPolicyThirdErrLogs);
        return getDataTable(list);
    }

    /**
     * 获取统一对接平台详细信息
     */
    @GetMapping(value = "/{cpkId}")
    public AjaxResult getInfo(@PathVariable("cpkId") String cpkId)
    {
        return AjaxResult.success(webPolicyThirdErrLogsService.selectWebPolicyThirdErrLogsByCPkId(cpkId));
    }

    /**
     * 新增统一对接平台
     */
    @Log(title = "统一对接平台-新增", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        return toAjax(webPolicyThirdErrLogsService.insertWebPolicyThirdErrLogs(webPolicyThirdErrLogs));
    }

    /**
     * 修改统一对接平台
     */
    @Log(title = "统一对接平台-修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        return toAjax(webPolicyThirdErrLogsService.updateWebPolicyThirdErrLogs(webPolicyThirdErrLogs));
    }

    /**
     * 删除统一对接平台
     */
    @Log(title = "统一对接平台-删除", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cpkIds}")
    public AjaxResult remove(@PathVariable String[] cpkIds)
    {
        return toAjax(webPolicyThirdErrLogsService.deleteWebPolicyThirdErrLogsByCPkIds(cpkIds));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<WebPolicyThirdErrLogs> util = new ExcelUtil<WebPolicyThirdErrLogs>(WebPolicyThirdErrLogs.class);
        util.importTemplateExcel(response,"模板");
    }


    @PostMapping("/importData")
    @Log(title = "统一对接平台-导入",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<WebPolicyThirdErrLogs> util = new ExcelUtil<WebPolicyThirdErrLogs>(WebPolicyThirdErrLogs.class);
        String message = "";
        try{
            List<WebPolicyThirdErrLogs> logsList = util.importExcel(file.getInputStream());
            message = webPolicyThirdErrLogsService.importData(logsList, updateSupport, "");
            logger.info("importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("importData文件上传 结束");
        return AjaxResult.success(message);
    }



}
