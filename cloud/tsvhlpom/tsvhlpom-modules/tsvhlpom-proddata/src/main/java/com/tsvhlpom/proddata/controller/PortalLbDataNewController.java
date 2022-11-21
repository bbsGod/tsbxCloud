package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.PortalLbDataNew;
import com.tsvhlpom.proddata.service.PortalLbDataNewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/portalLbDataNew")
public class PortalLbDataNewController extends BaseController {

    @Autowired
    private PortalLbDataNewService portalLbDataNewService;

    @RequestMapping("/getPortalLbDataNewList")
    public TableDataInfo getPortalLbDataNewList(PortalLbDataNew portalLbDataNew){
        logger.info("查询PortalLbDataNew列表");
        startPage();
        List<PortalLbDataNew> portalLbDataNewList = null;
        try{
            portalLbDataNewList = portalLbDataNewService.getPortalLbDataNewList(portalLbDataNew.getC_module());
        }catch (Exception e){
            logger.error("获取PortalLbDataNew列表出错");
            e.printStackTrace();
        }
        return getDataTable(portalLbDataNewList);
    }
    @RequestMapping("/getPortalLbDataNew")
    public R getPortalLbDataNew(@RequestBody PortalLbDataNew portalLbDataNew){
         return R.ok(portalLbDataNewService.getPortalLbDataNew(portalLbDataNew));
    }
    @RequestMapping("/save")
    @RequiresPermissions("proddata:portalLbDataNew:save")
    @Log(title = "生产数据{PortalLbDataNew}",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody PortalLbDataNew portalLbDataNew){
        try{
            portalLbDataNewService.save(portalLbDataNew);
        }catch (Exception e){
            logger.error("PortalLbDataNew保存出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:portalLbDataNew:update")
    @Log(title = "生产数据{PortalLbDataNew}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody PortalLbDataNew portalLbDataNew){
        try{
            portalLbDataNewService.update(portalLbDataNew);
        }catch (Exception e){
            logger.error("PortalLbDataNew更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete")
    @Log(title = "生产数据{PortalLbDataNew}",businessType = BusinessType.DELETE)
    @RequiresPermissions("proddata:portalLbDataNew:delete")
    public AjaxResult delete(@RequestBody PortalLbDataNew portalLbDataNew){
        try{
            log.info("PortalLbDataNew  删除");
            portalLbDataNewService.delete(portalLbDataNew);
        }catch (Exception e){
            log.error("PortalLbDataNew 删除出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

}
