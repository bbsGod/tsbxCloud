package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.TblConfig;
import com.tsvhlpom.proddata.service.TblConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/tblConfig")
public class TblConfigController extends BaseController {

    @Autowired
    private TblConfigService tblConfigService;

    @RequestMapping("/getTblConfigList")
    public TableDataInfo gettblConfigList(TblConfig tblConfig){
        logger.info("查询tblConfig列表");
        startPage();
        List<TblConfig> tblConfigList = null;
        try{
            tblConfigList = tblConfigService.getTblConfigList(tblConfig);
        }catch (Exception e){
            logger.error("获取tblConfig列表出错");
            e.printStackTrace();
        }
        return getDataTable(tblConfigList);
    }
    @RequestMapping("/getTblConfig/{c_pk_id}")
    public R gettblConfig(@PathVariable("c_pk_id") String c_pk_id){
         return R.ok(tblConfigService.getTblConfig(c_pk_id));
    }
    @RequestMapping("/save")
    @RequiresPermissions("proddata:tblConfig:save")
    @Log(title = "生产数据{tblConfig}",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody TblConfig tblConfig){
        try{
            tblConfigService.save(tblConfig);
        }catch (Exception e){
            logger.error("tblConfig保存出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:tblConfig:update")
    @Log(title = "生产数据{tblConfig}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody TblConfig tblConfig){
        try{
            tblConfigService.update(tblConfig);
        }catch (Exception e){
            logger.error("tblConfig更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{c_pk_ids}")
    @Log(title = "生产数据{tblConfig}",businessType = BusinessType.DELETE)
    @RequiresPermissions("proddata:tblConfig:delete")
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            log.info("tblConfig  删除");
            tblConfigService.delete(c_pk_ids);
        }catch (Exception e){
            log.error("tblConfig 删除出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

}
