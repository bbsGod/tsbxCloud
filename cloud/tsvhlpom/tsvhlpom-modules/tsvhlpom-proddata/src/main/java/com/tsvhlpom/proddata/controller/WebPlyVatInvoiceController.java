package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;
import com.tsvhlpom.proddata.service.WebPlyVatInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webPlyVatInvoice")
public class WebPlyVatInvoiceController extends BaseController {
    @Autowired
    private WebPlyVatInvoiceService webPlyVatInvoiceService;

    @RequestMapping("/getVatList")
    public TableDataInfo getVatList(WebPlyVatInvoice webPlyVatInvoice){
        logger.info("查询webPlyVatInvoice列表");
        startPage();
        List<WebPlyVatInvoice> webPlyVatInvoiceList = null;
        try{
            webPlyVatInvoiceList = webPlyVatInvoiceService.getVatList(webPlyVatInvoice.getC_ply_no());
        }catch (Exception e){
            logger.error("获取webPlyVatInvoice列表出错");
            e.printStackTrace();
        }
        return getDataTable(webPlyVatInvoiceList);
    }
    @RequestMapping("/updateStatus")
    @RequiresPermissions("proddata:webPlyVatInvoice:update")
    @Log(title = "生产数据{webPlyVatInvoice}",businessType = BusinessType.UPDATE)
    public AjaxResult updateStatus(@RequestBody WebPlyVatInvoice webPlyVatInvoice){
        try {
            logger.info("webPlyVatInvoice修改："+webPlyVatInvoice.getC_ply_no()+" 修改webPlyVatInvoice的状态为"+webPlyVatInvoice.getC_status());
            webPlyVatInvoiceService.updateStatus(webPlyVatInvoice);
        }catch (Exception e){
            logger.error("修改webPlyVatInvoice报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }




}
