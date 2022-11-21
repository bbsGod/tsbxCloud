package com.tsvhlpom.prodapi.broker.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.prodapi.broker.VO.Broker;
import com.tsvhlpom.prodapi.broker.service.BrokerService;
import com.tsvhlpom.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/broker")
/**
 * 页面上 中介维护 controller
 */
public class BrokerController extends BaseController {


    @Autowired
    private BrokerService brokerService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getBrokerList")
    public TableDataInfo getBrokerList(Broker broker){
        logger.info("查询Broker列表");
        startPage();
        List<Broker> brokerList = null;
        try{
            brokerList = brokerService.getBrokerList(broker);
        }catch (Exception e){
            logger.error("获取Broker列表出错");
            e.printStackTrace();
        }
        return getDataTable(brokerList);
    }
    @RequestMapping("/getBroker/{c_pk_id}")
    public R getBroker(@PathVariable("c_pk_id") String c_pk_id){
        return R.ok(brokerService.getBroker(c_pk_id));
    }
    @RequestMapping("/save")
    @RequiresPermissions("prodapi:broker:save")
    @Log(title = "生产数据{Broker}",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody Broker broker){
        try{
            brokerService.save(broker);
        }catch (Exception e){
            logger.error("Broker保存出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @RequiresPermissions("prodapi:broker:update")
    @Log(title = "生产数据{Broker}",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody Broker broker){
        try{
            brokerService.update(broker);
        }catch (Exception e){
            logger.error("Broker更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{c_pk_ids}")
    @Log(title = "生产数据{Broker}",businessType = BusinessType.DELETE)
    @RequiresPermissions("prodapi:broker:delete")
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        try{
            logger.info("Broker  删除");
            brokerService.delete(c_pk_ids);
        }catch (Exception e){
            logger.error("Broker 删除出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<Broker> util = new ExcelUtil<Broker>(Broker.class);
        util.importTemplateExcel(response,"中介机构信息");
    }

    /**
     * 导入文件上传
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:upload')")
    @PostMapping("/importData")
    @RequiresPermissions("prodapi:broker:upload")
    @Log(title = "prodapi(中介机构)",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<Broker> util = new ExcelUtil<Broker>(Broker.class);
        String message = "";
        try{
            List<Broker> brokerList = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = brokerService.importData(brokerList, updateSupport, operName);
            logger.info("importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("importData文件上传 结束");
        return AjaxResult.success(message);
    }



}
