package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.WebTrdAutoPlyContact;
import com.tsvhlpom.proddata.service.WebTrdAutoPlyContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/plyContact")
public class WebTrdAutoPlyContactController extends BaseController {

    @Autowired
    private WebTrdAutoPlyContactService webTrdAutoPlyContactService;

    @RequestMapping("/getWebTrdAutoPlyContactList")
    public TableDataInfo getWebTrdAutoPlyContactList(WebTrdAutoPlyContact webTrdAutoPlyContact){
        startPage();
        List<WebTrdAutoPlyContact> webTrdAutoPlyContactList = null;
        try{
            log.info("获取保单落地失败联系人list");
            webTrdAutoPlyContactList = webTrdAutoPlyContactService.getWebTrdAutoPlyContactList(webTrdAutoPlyContact);
        }catch (Exception e){
            log.error("获取 保单落地失败联系人失败。。。");
            e.printStackTrace();
        }
        return getDataTable(webTrdAutoPlyContactList);
    }

    @RequestMapping("/save")
    @Log(title = "proddata(保单落地失败联系人)",businessType = BusinessType.INSERT)
    @RequiresPermissions("proddata:plyContact:save")
    public AjaxResult save(@RequestBody WebTrdAutoPlyContact webTrdAutoPlyContact){
        log.info("保单落地失败联系人 新增开始");
        try{
            webTrdAutoPlyContactService.save(webTrdAutoPlyContact);
        }catch (Exception e){
            log.error("保单落地失败联系人 新增失败。。");
            e.printStackTrace();
            return AjaxResult.error("保单落地失败联系人 新增失败");
        }
        return AjaxResult.success("保存成功");
    }

    @RequiresPermissions("proddata:plyContact:update")
    @RequestMapping("/update")
    @Log(title = "proddata(保单落地失败联系人)",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody WebTrdAutoPlyContact webTrdAutoPlyContact){
        log.info("保单落地失败联系人 更新开始");
        try{
            webTrdAutoPlyContactService.update(webTrdAutoPlyContact);
        }catch (Exception e){
            log.error("保单落地失败联系人 更新失败");
            e.printStackTrace();
            return  AjaxResult.error("保单落地失败联系人 更新失败");
        }
        return AjaxResult.success("更新成功");
    }

    @RequestMapping("/delete/{c_pk_ids}")
    @RequiresPermissions("proddata:plyContact:delete")
    @Log(title = "proddata(保单落地失败联系人)",businessType = BusinessType.DELETE)
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            log.info("保单落地失败联系人 删除开始");
            webTrdAutoPlyContactService.delete(c_pk_ids);
        }catch (Exception e){
            log.error("保单落地失败联系人 删除失败");
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
        return AjaxResult.success("删除成功");
    }

    @RequestMapping("/getWebTrdAutoPlyContact/{c_pk_id}")
    @RequiresPermissions("proddata:plyContact:query")
    public R<WebTrdAutoPlyContact> getWebTrdAutoPlyContact(@PathVariable("c_pk_id") String c_pk_id){
        WebTrdAutoPlyContact a =  webTrdAutoPlyContactService.getWebTrdAutoPlyContact(c_pk_id);
        return R.ok(a);
    }
}
