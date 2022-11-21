package com.tsvhlpom.cargroup.controller;

import com.tsvhlpom.cargroup.domain.BaseCustomers;
import com.tsvhlpom.cargroup.domain.BasePrice;
import com.tsvhlpom.cargroup.domain.BaseVisit;
import com.tsvhlpom.cargroup.service.BaseCustomersService;
import com.tsvhlpom.cargroup.service.BaseVisitService;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customers")
public class BaseCustomersController  extends BaseController {

    @Autowired
    private BaseCustomersService baseCustomersService;

    @Autowired
    private BaseVisitService baseVisitService;

    @RequestMapping("/getBaseCustomersList")
    public TableDataInfo getBaseCustomersList(BaseCustomers baseCustomers){
        log.info("客户列表查询 start");
        startPage();
        List<BaseCustomers> baseCustomersList = null;
        try{
            baseCustomersList = baseCustomersService.getBaseCustomersList(baseCustomers);
        }catch (Exception e){
            log.error("客户列表查询 error");
            e.printStackTrace();
        }
        log.info("客户列表查询 end");
        return getDataTable(baseCustomersList);
    }

    @RequestMapping("/getBaseCustomers/{c_pk_id}")
    public R getBaseCustomers(@PathVariable("c_pk_id") String c_pk_id){
        return R.ok(baseCustomersService.getBaseCustomers(c_pk_id));
    }
    @RequestMapping("/insert")
    @Log(title = "私车团做(新增)",businessType = BusinessType.INSERT)
    public AjaxResult insert(@RequestBody BaseCustomers baseCustomers){
        log.info("私车团做 客户保存  end");
        try{
            baseCustomersService.insert(baseCustomers);
        }catch (Exception e){
            e.printStackTrace();
            log.error("客户信息保存 error"+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        log.info("私车团做 客户保存  end");
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    @Log(title = "私车团做(更新客户)",businessType = BusinessType.UPDATE)
    public AjaxResult update(@RequestBody BaseCustomers baseCustomers){
        log.info("私车团做 客户更新  start");
        try{
            //baseCustomers.setC_visit_emp(SecurityUtils.getLoginUser().getSysUser().getNickName());
            baseCustomersService.update(baseCustomers);
        }catch (Exception e){
            e.printStackTrace();
            log.error("客户信息更新 error"+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        log.info("私车团做 客户更新  end");
        return AjaxResult.success();
    }
    @RequestMapping("/updateVisit")
    @Log(title = "私车团做(回访)",businessType = BusinessType.UPDATE)
    public AjaxResult updateVisit(@RequestBody BaseCustomers baseCustomers){
        log.info("私车团做 回访更新  start");
        try{
            baseCustomers.setC_visit_emp(SecurityUtils.getLoginUser().getSysUser().getNickName());
            baseCustomersService.updateVisit(baseCustomers);
        }catch (Exception e){
            e.printStackTrace();
            log.error("私车团做 回访更新 error"+e.getMessage());
        }
        log.info("私车团做 回访更新  end");
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{c_pk_ids}")
    @Log(title = "私车团做(删除)",businessType = BusinessType.DELETE)
    public AjaxResult delete(@PathVariable("c_pk_ids") String[] c_pk_ids){
        log.info("私车团做 客户删除  start");
        try{
            baseCustomersService.delete(c_pk_ids);
        }catch (Exception e){
            e.printStackTrace();
            log.error("客户信息删除 error"+e.getMessage());
        }
        log.info("私车团做 客户删除  end");
        return AjaxResult.success();
    }
    @RequestMapping("/getVisitList/{c_id}")
    public List<BaseVisit> getVisitList(@PathVariable("c_id") String c_id){
        log.info("获取visitList,c_id= "+c_id);
        return baseVisitService.getVisitList(c_id);
    }
    @PostMapping("/exportCustomers")
    @Log(title = "私车团做(客户)",businessType = BusinessType.EXPORT)
    public void exportCustomers(BaseCustomers baseCustomers, HttpServletResponse response)
    {
        logger.info(" 重点客户信息导出 start");
        try{
            List<BaseCustomers> list = baseCustomersService.getBaseCustomersList(baseCustomers);
            /*ExcelUtil<BaseCustomers> util = new ExcelUtil<BaseCustomers>(BaseCustomers.class);
            util.exportExcel(response,list,"重点客户信息数据导出");*/
            baseCustomersService.export(list,response);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("重点客户信息导出 error");
        }
        logger.info("重点客户信息导出 end ");
    }

    @RequestMapping("/getSpCust")
    public AjaxResult getSpCust(@RequestParam String query){
        log.info("getSpcust start");
        List<BaseCustomers> baseCustomersList = null;
        try{
            baseCustomersList = baseCustomersService.getSpCust(query);
            System.out.println(baseCustomersList);
        }catch (Exception e){
            log.error("getSpcust error");
            e.printStackTrace();

            return AjaxResult.error("none");

        }
        log.info("getSpcust end");
        return AjaxResult.success(baseCustomersList);
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<BaseCustomers> util = new ExcelUtil<BaseCustomers>(BaseCustomers.class);
        util.importTemplateExcel(response,"模板");
    }
    /**
     * 更新客户回访状态，同时新插入到回访详情
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/updateVisitInfoByExport")
    public AjaxResult updateVisitInfoByExport(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("updateVisitInfoByExport 文件上传 开始");
        ExcelUtil<BaseCustomers> util = new ExcelUtil<BaseCustomers>(BaseCustomers.class);
        String message = "";
        try{
            List<BaseCustomers> customersList = util.importExcel(file.getInputStream());
            message = baseCustomersService.updateVisitInfoByExport(customersList,updateSupport);
            logger.info("updateVisitInfoByExport文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("updateVisitInfoByExport文件上传 结束");
        return AjaxResult.success(message);
    }
}
