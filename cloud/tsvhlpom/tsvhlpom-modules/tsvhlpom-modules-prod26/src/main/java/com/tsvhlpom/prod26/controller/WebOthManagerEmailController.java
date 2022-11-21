package com.tsvhlpom.prod26.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.prod26.domain.WebOthManagerEmail;
import com.tsvhlpom.prod26.service.WebOthManagerEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/webOthManagerEmail")
@RestController
public class WebOthManagerEmailController extends BaseController {

    @Autowired
    private WebOthManagerEmailService webOthManagerEmailService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getWebOthManagerEmailList")
    public TableDataInfo getWebOthManagerEmailList(WebOthManagerEmail webOthManagerEmail){
        logger.info("WebOthManagerEmail----c_dpt_cde");
        startPage();
        List<WebOthManagerEmail> webOthManagerEmailList = null;
        try{
            webOthManagerEmailList = webOthManagerEmailService.getWebOthManagerEmailList(webOthManagerEmail);
        }catch (Exception e){
            logger.error("获取WebOthManagerEmai列表出错");
            e.printStackTrace();
        }
        return getDataTable(webOthManagerEmailList);
    }
    @Log(title = "生产数据{email}",businessType = BusinessType.UPDATE)
    @RequestMapping("/updateEmail")

    public AjaxResult updateEmail(WebOthManagerEmail webOthManagerEmail){
        try {
            logger.info(webOthManagerEmail.getC_dpt_cde()+" 修改业管邮箱，web_oth_manager_email.c_email");
            webOthManagerEmailService.update(webOthManagerEmail.getC_email(),webOthManagerEmail.getC_dpt_cde());
        }catch (Exception e){
            logger.error("updateEmail报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
}
