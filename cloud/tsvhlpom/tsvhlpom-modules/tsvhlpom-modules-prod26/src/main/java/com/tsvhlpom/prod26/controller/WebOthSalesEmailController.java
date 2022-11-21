package com.tsvhlpom.prod26.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.prod26.domain.WebOthSalesEmail;
import com.tsvhlpom.prod26.service.WebOthSalesEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/webOthSalesEmail")
@RestController
public class WebOthSalesEmailController extends BaseController {

    @Autowired
    private WebOthSalesEmailService webOthSalesEmailService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getWebOthSalesEmailList")
    public TableDataInfo getWebOthSalesEmailList(WebOthSalesEmail webOthSalesEmail){
        logger.info("WebOthSalesEmail----c_sls_cde");
        startPage();
        List<WebOthSalesEmail> webOthSalesEmaillList = null;
        try{
            webOthSalesEmaillList = webOthSalesEmailService.getWebOthSalesEmailList(webOthSalesEmail);
        }catch (Exception e){
            logger.error("获取WebOthSalesEmai列表出错");
            e.printStackTrace();
        }
        return getDataTable(webOthSalesEmaillList);
    }
    @Log(title = "生产数据{email}",businessType = BusinessType.UPDATE)
    @RequestMapping("/updateEmail")

    public AjaxResult updateEmail(WebOthSalesEmail webOthSalesEmail){
        try {
            logger.info(webOthSalesEmail.getC_sls_cde()+" 修改员工邮箱，web_oth_sales_email.c_email");
            webOthSalesEmailService.update(webOthSalesEmail.getC_email(),webOthSalesEmail.getC_sls_cde());
        }catch (Exception e){
            logger.error("updateEmail报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
}
