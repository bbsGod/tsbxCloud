package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.proddata.domain.BasConfig;
import com.tsvhlpom.proddata.domain.WebBasNoVhlFeePropConf;
import com.tsvhlpom.proddata.service.WebBasNoVhlFeePropConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/webBasNoVhlFeePropConf")
@RestController
public class WebBasNoVhlFeePropConfController extends BaseController {

    @Autowired
    private WebBasNoVhlFeePropConfService webBasNoVhlFeePropConfService;


    @RequestMapping("/getList")
    public TableDataInfo getList(WebBasNoVhlFeePropConf webBasNoVhlFeePropConf){
        logger.info("查询WebBasNoVhlFeePropConf列表");
        startPage();
        List<WebBasNoVhlFeePropConf> webBasNoVhlFeePropConfList = null;
        try{
            webBasNoVhlFeePropConfList = webBasNoVhlFeePropConfService.getList(webBasNoVhlFeePropConf);
        }catch (Exception e){
            logger.error("获取WebBasNoVhlFeePropConf列表出错");
            e.printStackTrace();
        }
        return getDataTable(webBasNoVhlFeePropConfList);
    }

    @RequestMapping("/getNoVhlConfig/{c_pk_id}")
    public R getNoVhlConfig(@PathVariable("c_pk_id") String c_pk_id){
        return R.ok(webBasNoVhlFeePropConfService.getNoVhlConfig(c_pk_id));
    }
    @RequestMapping("/update")
    @Log(title = "生产数据（WebBasNoVhlFeePropConf）",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody WebBasNoVhlFeePropConf webBasNoVhlFeePropConf){
        try{
            webBasNoVhlFeePropConfService.update(webBasNoVhlFeePropConf);
        }catch (Exception e){
            logger.error("WebBasNoVhlFeePropConf  update err");
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success("更新成功");
    }
}
