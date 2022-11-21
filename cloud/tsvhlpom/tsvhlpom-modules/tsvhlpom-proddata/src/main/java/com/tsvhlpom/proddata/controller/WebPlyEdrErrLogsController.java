package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.proddata.domain.WebPlyEdrErrLogs;
import com.tsvhlpom.proddata.service.WebPlyEdrErrLogsService;
import com.tsvhlpom.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/webPlyEdrErrLogs")
public class WebPlyEdrErrLogsController extends BaseController {

    @Autowired
    private WebPlyEdrErrLogsService service;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getWebPlyEdrErrLogsList")
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:list")
    public TableDataInfo getWebPlyEdrErrLogsList(WebPlyEdrErrLogs webPlyEdrErrLogs)
    {
        logger.info("获取销管推送失败数据 start");
        startPage();
        List<WebPlyEdrErrLogs> list = null;
        try{
            list = service.getWebPlyEdrErrLogsList(webPlyEdrErrLogs);
            logger.info("获取销管推送失败数据 success");
        }catch (Exception e){
            logger.error("获取销管推送失败数据 error!!!!!!!!!!");
            e.printStackTrace();
        }
        logger.info("获取销管推送失败数据 end");
        return getDataTable(list);
    }
    @RequestMapping(value = "/{c_pk_id}")
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:query")
    public R getWebPlyEdrErrLogs(@PathVariable("c_pk_id") String c_pk_id){
        return R.ok(service.getWebPlyEdrErrLogs(c_pk_id));
    }
    /**
     * 销管推送失败数据 新增
     */
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:add")
    @RequestMapping("/save")
    @Log(title = "销管推送失败表",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody WebPlyEdrErrLogs webPlyEdrErrLogs){
        logger.info("WebPlyEdrErrLogs save start");
        try{
            service.save(webPlyEdrErrLogs);
            logger.info("WebPlyEdrErrLogs save success");
        }catch (Exception e){
            logger.error("WebPlyEdrErrLogs 保存报错");
            e.printStackTrace();
            return AjaxResult.error("保存失败");
        }
        logger.info("WebPlyEdrErrLogs save end");
        return  AjaxResult.success("保存成功");
    }
    @RequestMapping("/update")
    @Log(title = "销管推送失败表",businessType = BusinessType.UPDATE)
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:edit")
    public AjaxResult update(@RequestBody WebPlyEdrErrLogs webPlyEdrErrLogs){
        logger.info("WebPlyEdrErrLogs update start");
        try{
            service.update(webPlyEdrErrLogs);
            logger.info("WebPlyEdrErrLogs update success");
        }catch (Exception e){
            logger.error("WebPlyEdrErrLogs update error");
            e.printStackTrace();
            return AjaxResult.error("更新失败");
        }
        logger.info("WebPlyEdrErrLogs update end");
        return  AjaxResult.success("更新成功");
    }
    @Log(title = "销管推送失败表",businessType = BusinessType.DELETE)
    @GetMapping(value = "/delete/{c_pk_ids}")
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:delete")
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            logger.info("WebPlyEdrErrLogs delete start");
            service.delete(c_pk_ids);
            logger.info("WebPlyEdrErrLogs delete success  end");
        }catch (Exception e){
            logger.error("WebPlyEdrErrLogs delete  error!!!");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("销管推送失败表 模板下载");
        ExcelUtil<WebPlyEdrErrLogs> util = new ExcelUtil<WebPlyEdrErrLogs>(WebPlyEdrErrLogs.class);
        util.importTemplateExcel(response,"销管推送失败表");
    }

    /**
     * 导入文件上传
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:upload')")
    @PostMapping("/importData")
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:upload")
    @Log(title = "销管推送失败表",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("webPlyEdrErrLogs importData文件上传 开始");
        ExcelUtil<WebPlyEdrErrLogs> util = new ExcelUtil<WebPlyEdrErrLogs>(WebPlyEdrErrLogs.class);
        String message = "";
        try{
            List<WebPlyEdrErrLogs> webPlyEdrErrLogsList = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = service.importData(webPlyEdrErrLogsList, updateSupport, operName);
            logger.info(" webPlyEdrErrLogs  importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(" webPlyEdrErrLogs 文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("webPlyEdrErrLogs importData文件上传 结束");
        return AjaxResult.success(message);
    }
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:export')")
    @PostMapping("/exportWebPlyEdrErrLogs")
    @RequiresPermissions("taishanpic:webPlyEdrErrLogs:export")
    @Log(title = "销管推送失败表",businessType = BusinessType.EXPORT)
    public void export(WebPlyEdrErrLogs webPlyEdrErrLogs, HttpServletResponse response)
    {
        logger.info(" webPlyEdrErrLogs.export start");
        try{
            List<WebPlyEdrErrLogs> list = service.getWebPlyEdrErrLogsList(webPlyEdrErrLogs);
            ExcelUtil<WebPlyEdrErrLogs> util = new ExcelUtil<WebPlyEdrErrLogs>(WebPlyEdrErrLogs.class);
            util.exportExcel(response,list,"销管失败数据导出");
            //result =  util.exportExcel(list, "VIP客户信息数据导出");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("webPlyEdrErrLogs.export error");
        }
        logger.info("webPlyEdrErrLogs.export end ");
    }

}
