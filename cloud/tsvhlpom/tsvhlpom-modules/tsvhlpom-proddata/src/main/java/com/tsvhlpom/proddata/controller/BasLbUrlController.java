package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.BasLbUrl;
import com.tsvhlpom.proddata.service.BasLbUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/basLbUrl")
public class BasLbUrlController extends BaseController {

    @Autowired
    private BasLbUrlService BasLbUrlService;

    @RequestMapping("/getBasLbUrlList")
    public TableDataInfo getBasLbUrlList(BasLbUrl basLbUrl){
        logger.info("查询BasLbUrl列表");
        startPage();
        List<BasLbUrl> BasLbUrlList = null;
        try{
            BasLbUrlList = BasLbUrlService.getBasLbUrlList(basLbUrl);
        }catch (Exception e){
            logger.error("获取BasLbUrl列表出错");
            e.printStackTrace();
        }
        return getDataTable(BasLbUrlList);
    }
    @RequestMapping("/getBasLbUrl/{c_pk_id}")
    public R getBasLbUrl(@PathVariable("c_pk_id") String c_pk_id){
         return R.ok(BasLbUrlService.getBasLbUrl(c_pk_id));
    }
    @RequestMapping("/save")
    @RequiresPermissions("proddata:BasLbUrl:save")
    @Log(title = "生产数据{BasLbUrl}",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody BasLbUrl basLbUrl){
        try{
            BasLbUrlService.save(basLbUrl);
        }catch (Exception e){
            logger.error("BasLbUrl保存出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @RequiresPermissions("proddata:BasLbUrl:update")
    @Log(title = "生产数据{BasLbUrl}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody BasLbUrl basLbUrl){
        try{
            BasLbUrlService.update(basLbUrl);
        }catch (Exception e){
            logger.error("BasLbUrl更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{c_pk_ids}")
    @Log(title = "生产数据{BasLbUrl}",businessType = BusinessType.DELETE)
    @RequiresPermissions("proddata:BasLbUrl:delete")
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            log.info("BasLbUrl  删除");
            BasLbUrlService.delete(c_pk_ids);
        }catch (Exception e){
            log.error("BasLbUrl 删除出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

}
