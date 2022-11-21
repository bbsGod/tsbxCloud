package com.tsvhlpom.dailywork.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.dailywork.domain.Daily_employee;
import com.tsvhlpom.dailywork.service.Daily_employeeService;
import com.tsvhlpom.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class Daily_employeeController extends BaseController {

    @Autowired
    private Daily_employeeService service;

    /**
     * 获取员工信息列表
     * @param employee
     * @return
     */
    @RequestMapping("/getEmployeeList")
    public TableDataInfo getEmployeeList(Daily_employee employee){
        logger.info("查询employee列表");
        startPage();
        List<Daily_employee> employeeList = null;
        try{
            employeeList = service.getEmployeeList(employee);
        }catch (Exception e){
            logger.error("获取employee列表出错");
            e.printStackTrace();
        }
        return getDataTable(employeeList);
    }
    @RequestMapping("/getEmployee/{pkid}")
    public R<Daily_employee> getEmployee(@PathVariable("pkid") String pkid){
        return R.ok(service.getEmployee(pkid));
    }
    @RequestMapping("/getEmployeeInfo/{emp_id}")
    public R<Daily_employee> getEmployeeInfo(@PathVariable("emp_id") String emp_id){
        return R.ok(service.getEmployeeInfo(emp_id));
    }

    @RequestMapping("/saveEmployee")
    //@RequiresPermissions("dailywork:employee:saveOrUpdate")
    //@Log(title = "每日工作(Employee)",businessType = BusinessType.INSERT)
    public AjaxResult saveEmployee(@RequestBody Daily_employee employee){
        log.info("保存employee start");
        try{
            service.saveEmployee(employee);
        }catch (Exception e){
            log.error("保存employee错误");
            e.printStackTrace();
            return AjaxResult.error("保存失败");
        }
        log.info("保存employee end");
        return AjaxResult.success("保存成功");
    }
    @RequestMapping("/updateEmployee")
    //@RequiresPermissions("dailywork:employee:saveOrUpdate")
    //@Log(title = "每日工作(Employee)",businessType = BusinessType.UPDATE)
    public AjaxResult updateEmployee(@RequestBody Daily_employee employee){
        log.info("更新employee  start");
        try{
            service.updateEmployee(employee);
        }catch (Exception e){
            log.error("更新employee错误");
            e.printStackTrace();
            return AjaxResult.error("更新失败");
        }
        log.info("更新employee end");
        return AjaxResult.success("更新成功");
    }
    @RequestMapping("/deleteEmployee/{pkids}")
    //@RequiresPermissions("dailywork:employee:remove")
    //@Log(title = "每日工作(Employee)",businessType = BusinessType.DELETE)
    public AjaxResult deleteEmployee(@PathVariable("pkids") String[] pkids){
        log.info("删除employee  start");
        try{
            service.deleteEmployee(pkids);
        }catch (Exception e){
            log.error("删除employee错误");
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
        log.info("删除employee end");
        return AjaxResult.success("删除成功");
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("employee模板下载");
        ExcelUtil<Daily_employee> util = new ExcelUtil<Daily_employee>(Daily_employee.class);
        util.importTemplateExcel(response,"员工信息");
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
    //@RequiresPermissions("dailywork:employee:upload")
    @Log(title = "每日工作(Employee)",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<Daily_employee> util = new ExcelUtil<Daily_employee>(Daily_employee.class);
        String message = "";
        try{
            List<Daily_employee> employeeList = util.importExcel(file.getInputStream());

            message = service.importData(employeeList, updateSupport, "admin");
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
