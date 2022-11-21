package com.tsvhlpom.covid19.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.covid19.domain.Emplyee;
import com.tsvhlpom.covid19.service.EmplyeeService;
import com.tsvhlpom.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/covid_emp")
@RestController
@Slf4j
public class EmplyeeController extends BaseController {
    @Autowired
    private EmplyeeService emplyeeService;

    @RequestMapping("/getEmplyeeList")
    public TableDataInfo getEmplyeeList(Emplyee emplyee){
        logger.info("查询covid_emp列表");
        startPage();
        List<Emplyee> emplyeeList = null;
        try{
            emplyeeList = emplyeeService.getEmplyeeList(emplyee);
        }catch (Exception e){
            logger.error("获取covid_emp列表出错");
            e.printStackTrace();
        }
        return getDataTable(emplyeeList);
    }
    @RequestMapping("/getEmplyee/{c_pk_id}")
    public R<Emplyee> getEmplyee(@PathVariable("c_pk_id") String c_pk_id){
        return R.ok(emplyeeService.getEmplyee(c_pk_id));
    }
    @RequestMapping("/saveEmplyee")
    public AjaxResult saveEmplyee(@RequestBody Emplyee emplyee){
        log.info("保存 covid_emp  start");
        try{
            emplyeeService.saveEmplyee(emplyee);
        }catch (Exception e){
            log.error("保存错误："+e.getMessage());
        }
        log.info("保存 covid_emp  end");
        return AjaxResult.success("保存成功");
    }

    @RequestMapping("/updateEmplyee")
    public AjaxResult updateEmplyee(@RequestBody Emplyee emplyee){
        log.info("更新 covid_emp  start");
        try{
            emplyeeService.updateEmplyee(emplyee);
        }catch (Exception e){
            log.error("更新错误："+e.getMessage());
        }
        log.info("更新 covid_emp  end");
        return AjaxResult.success("更新成功");
    }
    @RequestMapping("/deleteEmplyee/{c_pk_ids}")
    public AjaxResult deleteEmplyee(@PathVariable("c_pk_ids") String[] c_pk_ids){
        log.info("删除 covid_emp  start");
        try{
            emplyeeService.deleteEmplyee(c_pk_ids);
        }catch (Exception e){
            log.error("删除错误："+e.getMessage());
        }
        log.info("删除 covid_emp  end");
        return AjaxResult.success("删除成功");

    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<Emplyee> util = new ExcelUtil<Emplyee>(Emplyee.class);
        util.importTemplateExcel(response,"员工信息");
    }

    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<Emplyee> util = new ExcelUtil<Emplyee>(Emplyee.class);
        String message = "";
        try{
            List<Emplyee> emplyeeList = util.importExcel(file.getInputStream());
            message = emplyeeService.importData(emplyeeList, updateSupport, "admin");
            logger.info("importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("importData文件上传 结束");
        return AjaxResult.success(message);
    }
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:export')")
    @PostMapping("/exportEmp")
    public void export(Emplyee emplyee, HttpServletResponse response)
    {
        logger.info(" EmplyeeController.export start");
        try{
            List<Emplyee> list = emplyeeService.getEmplyeeList(emplyee);
            ExcelUtil<Emplyee> util = new ExcelUtil<Emplyee>(Emplyee.class);
            util.exportExcel(response,list,"员工信息数据导出");
        }catch (Exception e){
            logger.error("EmplyeeController.export error");
            e.printStackTrace();
        }
        logger.info("EmplyeeController.export end ");
    }
}
