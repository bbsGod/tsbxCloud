package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.common.security.utils.SecurityUtils;
import com.tsvhlpom.proddata.domain.BasConfig;
import com.tsvhlpom.proddata.service.BasConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/basConfig")
public class BasConfigController extends BaseController {

    @Autowired
    private BasConfigService basConfigService;

    @RequestMapping("/getBasConfigList")
    public TableDataInfo getBasConfigList(BasConfig basConfig){
        logger.info("查询basconfig列表");
        startPage();
        List<BasConfig> basConfigList = null;
        try{
            basConfigList = basConfigService.getBasConfigList(basConfig);
        }catch (Exception e){
            logger.error("获取basCOnfig列表出错");
            e.printStackTrace();
        }
        return getDataTable(basConfigList);
    }
    @RequestMapping("/getBasConfig/{c_pk_id}")
    public R getBasConfig(@PathVariable("c_pk_id") String c_pk_id){
         return R.ok(basConfigService.getBasConfig(c_pk_id));
    }
    @RequestMapping("/save")
    @RequiresPermissions("proddata:basConfig:save")
    @Log(title = "生产数据{basConfig}",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody BasConfig basConfig){
        try{
            String operName = SecurityUtils.getUsername();
            basConfig.setC_crt_cde(operName);
            basConfigService.save(basConfig);
        }catch (Exception e){
            logger.error("basConfig保存出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:basConfig:update")
    @Log(title = "生产数据{BasConfig}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody BasConfig basConfig){
        try{
            String operName = SecurityUtils.getUsername();
            basConfig.setC_crt_cde(operName);
            basConfigService.update(basConfig);
        }catch (Exception e){
            logger.error("basConfig更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{c_pk_ids}")
    @Log(title = "生产数据{basConfig}",businessType = BusinessType.DELETE)
    @RequiresPermissions("proddata:basConfig:delete")
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            log.info("basConfig  删除");
            basConfigService.delete(c_pk_ids);
        }catch (Exception e){
            log.error("basConfig 删除出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

}
