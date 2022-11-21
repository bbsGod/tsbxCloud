package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.TblPassword;
import com.tsvhlpom.proddata.domain.WebAppVsTax;
import com.tsvhlpom.proddata.service.WebAppVsTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webAppVsTax")
public class WebAppVsTaxController extends BaseController {

    @Autowired
    private WebAppVsTaxService webAppVsTaxService;

    @RequestMapping("/getWebAppVsTaxList")
    public TableDataInfo getWebAppVsTaxList(WebAppVsTax webAppVsTax){
        logger.info("查询 WebAppVsTax 列表");
        startPage();
        List<WebAppVsTax> webAppVsTaxList = null;
        try{
            webAppVsTaxList = webAppVsTaxService.getWebAppVsTaxList(webAppVsTax.getC_app_no());
        }catch (Exception e){
            logger.error("获取 WebAppVsTax 列表出错");
            e.printStackTrace();
        }
        return getDataTable(webAppVsTaxList);
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:webAppVsTax:update")
    @Log(title = "生产数据{webAppVsTax}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody WebAppVsTax webAppVsTax){
        try {
            logger.info("webAppVsTax 修改");
            webAppVsTaxService.update(webAppVsTax);
        }catch (Exception e){
            logger.error("修改webAppVsTax报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }


}
