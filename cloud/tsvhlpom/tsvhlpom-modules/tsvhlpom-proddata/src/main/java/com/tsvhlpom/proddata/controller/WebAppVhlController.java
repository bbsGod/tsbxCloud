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
import com.tsvhlpom.proddata.domain.WebAppVhl;
import com.tsvhlpom.proddata.service.WebAppVhlService;
import com.tsvhlpom.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/webAppVhl")
@RestController
public class WebAppVhlController extends BaseController {

    @Autowired
    private WebAppVhlService webAppVhlService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getList")
    public TableDataInfo getList(WebAppVhl webAppVhl){
        logger.info("查询WebAppVhl列表");
        startPage();
        List<WebAppVhl> webAppVhlList = null;
        try{
            webAppVhlList = webAppVhlService.getList(webAppVhl);
        }catch (Exception e){
            logger.error("获取WebAppVhl列表出错");
            e.printStackTrace();
        }
        return getDataTable(webAppVhlList);
    }

    @RequestMapping("/getAppVhl/{c_app_no}")
    public R getAppVhl(@PathVariable("c_app_no") String c_app_no){
        return R.ok(webAppVhlService.getAppVhl(c_app_no));
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:webAppVhl:update")
    @Log(title = "生产数据（WebAppVhl）",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody WebAppVhl webAppVhl){
        try{
            webAppVhlService.update(webAppVhl);
        }catch (Exception e){
            logger.error("WebAppVhl  update err");
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success("更新成功");
    }
    @RequestMapping("/updatePrint")
    public AjaxResult updatePrint(@RequestBody WebAppVhl webAppVhl){
        try{
            webAppVhlService.updatePrint(webAppVhl);
        }catch (Exception e){
            logger.error("WebAppVhl  update err");
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("江苏燃料种类导入模板下载");
        ExcelUtil<WebAppVhl> util = new ExcelUtil<WebAppVhl>(WebAppVhl.class);
        util.importTemplateExcel(response,"江苏燃料种类");
    }

    /**
     *
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/importData")
    @RequiresPermissions("proddata:webAppVhl:import")
    @Log(title = "生产数据（webAppVhl）",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("江苏燃料种类信息excel文件上传 开始");
        ExcelUtil<WebAppVhl> util = new ExcelUtil<WebAppVhl>(WebAppVhl.class);
        String message = "";
        try{
            List<WebAppVhl> list = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = webAppVhlService.importData(list, updateSupport, operName);
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
