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
import com.tsvhlpom.proddata.domain.WebAppBase;
import com.tsvhlpom.proddata.service.WebAppBaseService;
import com.tsvhlpom.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/webAppBase")
public class WebAppBaseController extends BaseController {

    @Autowired
    private WebAppBaseService webAppBaseService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getWebAppBaseList")
    public TableDataInfo getWebAppBaseList(WebAppBase webAppBase){
        logger.info("查询WebAppBase列表");
        startPage();
        List<WebAppBase> webAppBaseList = null;
        try{
            webAppBaseList = webAppBaseService.getWebAppBaseList(webAppBase);
        }catch (Exception e){
            logger.error("获取WebAppBase列表出错");
            e.printStackTrace();
        }
        return getDataTable(webAppBaseList);
    }
    // @RequestMapping("/getWebAppBase/{c_ply_no}")
    public R getWebAppBase(@PathVariable("c_ply_no") String c_ply_no){
         return R.ok(webAppBaseService.getWebAppBase(c_ply_no));
    }

    @RequestMapping("/update")
    @RequiresPermissions("proddata:webAppBase:update")
    @Log(title = "生产数据{webAppBase}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody WebAppBase webAppBase){
        try{
            webAppBaseService.update(webAppBase);
        }catch (Exception e){
            logger.error("webAppBase 更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

    @RequestMapping("/getAppBaseWithOpeCde/{c_app_no}")
    public TableDataInfo getAppBaseWithOpeCde(WebAppBase webAppBase){
        logger.info("查询WebAppBase列表----oprCde");
        startPage();
        List<WebAppBase> webAppBaseList = null;
        try{
            webAppBaseList = webAppBaseService.getAppBaseWithOpeCde(webAppBase);
        }catch (Exception e){
            logger.error("获取WebAppBase列表出错");
            e.printStackTrace();
        }
        return getDataTable(webAppBaseList);
    }
    @Log(title = "生产数据{oprcde}",businessType = BusinessType.UPDATE)
    @RequestMapping("/updateOprCde/{c_app_no}")
    @RequiresPermissions("proddata:webAppBase_oprCde:update")
    public AjaxResult updateOprCde(@PathVariable("c_app_no") String c_app_no){
        try {
            log.info(c_app_no+" 修改出单员工号，web_app_base.c_opr_cde");
            webAppBaseService.updateOprCde(c_app_no);
        }catch (Exception e){
            log.error("updateOprCde报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("销售中介信息导入模板下载");
        ExcelUtil<WebAppBase> util = new ExcelUtil<WebAppBase>(WebAppBase.class);
        util.importTemplateExcel(response,"销售中介信息");
    }

    /**
     *
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/importData")
    @RequiresPermissions("proddata:webAppBase:import")
    @Log(title = "proddata中介销售信息",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("中介销售信息excel文件上传 开始");
        ExcelUtil<WebAppBase> util = new ExcelUtil<WebAppBase>(WebAppBase.class);
        String message = "";
        try{
            List<WebAppBase> list = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = webAppBaseService.importData(list, updateSupport, operName);
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
