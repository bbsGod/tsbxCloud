package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.TblPassword;
import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;
import com.tsvhlpom.proddata.service.TblPasswordService;
import com.tsvhlpom.proddata.service.WebPlyVatInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tblPassword")
public class TblPasswordController extends BaseController {
    @Autowired
    private TblPasswordService tblPasswordService;

    @RequestMapping("/getTblPasswordList")
    public TableDataInfo getTblPasswordList(TblPassword tblPassword){
        logger.info("查询 typt.tbl_password 列表");
        startPage();
        List<TblPassword> tblPasswordList = null;
        try{
            tblPasswordList = tblPasswordService.getTblPasswordList(tblPassword.getC_from_code());
        }catch (Exception e){
            logger.error("获取tbl_password列表出错");
            e.printStackTrace();
        }
        return getDataTable(tblPasswordList);
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:tblPassword:update")
    @Log(title = "生产数据{typt.tbl_Password}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody TblPassword tblPassword){
        try {
            logger.info("tbl_Password修改："+tblPassword.getC_from_code()+":c_password:"+tblPassword.getC_password());
            tblPasswordService.update(tblPassword);
        }catch (Exception e){
            logger.error("修改tbl_Password报错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }




}
