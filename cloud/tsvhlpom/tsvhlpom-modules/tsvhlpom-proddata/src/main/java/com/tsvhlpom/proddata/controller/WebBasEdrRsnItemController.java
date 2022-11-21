package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.WebBasEdrRsnItem;
import com.tsvhlpom.proddata.service.WebBasEdrRsnItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webBasEdrRsnItem")
@Slf4j
public class WebBasEdrRsnItemController extends BaseController {

    @Autowired
    private WebBasEdrRsnItemService webBasEdrRsnItemService;

    @RequestMapping("/getWebBasEdrRsnItem/{c_pk_id}")
    public R getWebBasEdrRsnItem(@PathVariable("c_pk_id") String c_pk_id){
        WebBasEdrRsnItem webBasEdrRsnItem = null;
        log.info("getWebBasEdrRsnItem start  query: c_pk_id="+ c_pk_id);
        try{
            webBasEdrRsnItem = webBasEdrRsnItemService.getWebBasEdrRsnItem(c_pk_id);
        }catch (Exception e){
            log.error("getWebBasEdrRsnItem query error");
            e.printStackTrace();
            return R.fail("webBasEdrRsnItem 查询失败 ");
        }
        return R.ok(webBasEdrRsnItem);
    }
    @RequestMapping("/save")
    @Log(title = "生产数据(webBasEdrRsnItem)",businessType = BusinessType.INSERT)
    @RequiresPermissions("proddata:webBasEdrRsnItem:insert")
    public AjaxResult save(@RequestBody WebBasEdrRsnItem webBasEdrRsnItem){
        try{
            webBasEdrRsnItemService.insert(webBasEdrRsnItem);
        }catch (Exception e){
            log.error("webBasEdrRsnItemService save error!!!");
            e.printStackTrace();
            return AjaxResult.error("保存失败");
        }
        return AjaxResult.success("保存成功");
    }

    @RequestMapping("/delete/{c_pk_id}")
    @RequiresPermissions("proddata:webBasEdrRsnItem:delete")
    @Log(title = "生产数据(webBasEdrRsnItem)",businessType = BusinessType.DELETE)
    public AjaxResult delete(@PathVariable("c_pk_id") String c_pk_id){
        try{
            webBasEdrRsnItemService.delete(c_pk_id);
        }catch (Exception e){
            log.error("webBasEdrRsnItemService delete error !!!");
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
        return AjaxResult.success("删除成功");
    }


}
