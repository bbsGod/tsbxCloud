package com.tsvhlpom.vip.controller;


import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.common.security.utils.SecurityUtils;
import com.tsvhlpom.system.api.model.LoginUser;
import com.tsvhlpom.vip.domain.VipDay;
import com.tsvhlpom.vip.service.IVipDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 节假日信息
 *
 * @author taishanpic
 */
@RestController
@RequestMapping("/vip_day")
public class VipDayController extends BaseController
{
    @Autowired
    private IVipDayService dayService;
    @Autowired
    private TokenService tokenService;

    /**
     * 获取用户列表
     */
    //@PreAuthorize("@ss.hasPermi('vip:day:list')")
    //@Log(title = "VIP节日list")
    @RequiresPermissions("taishanpic:day:list")
    @GetMapping("/list")
    public TableDataInfo list(VipDay day)
    {
        startPage();
        List<VipDay> list = dayService.selectDayList(day);
        return getDataTable(list);
    }

    /**
     * 根据pkid获取详细信息
     */
    //@PreAuthorize("@ss.hasPermi('vip:day:query')")
    @RequiresPermissions("taishanpic:day:query")
    @RequestMapping(value = "/getDay/{pkId}" )
    public AjaxResult getInfo(@PathVariable(value = "pkId") String pkId)
    {
        return AjaxResult.success(dayService.selectDayById(pkId));
    }

    /**
     * 新增节假日信息
     */
    //@PreAuthorize("@ss.hasPermi('vip:day:add')")
    @PostMapping(value = "/add")
    @Log(title = "VIP节日",businessType = BusinessType.INSERT)
    @RequiresPermissions("taishanpic:day:add")
    public AjaxResult add(@RequestBody VipDay day)
    {
        if (dayService.checkDayUnique(day))
        {
            return AjaxResult.error("新增节假日'" + day.getDayName() + "'失败，节假日已存在");
        }
        day.setCreateBy(SecurityUtils.getUsername());
        day.setCreateDate(new Date());
        return toAjax(dayService.insertDay(day));
    }

    /**
     * 修改节假日信息
     */
    //@PreAuthorize("@ss.hasPermi('vip:day:edit')")
    //@Log(title = "节假日管理", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    @Log(title = "VIP节日",businessType = BusinessType.UPDATE)
    @RequiresPermissions("taishanpic:day:edit")
    public AjaxResult edit(@Validated @RequestBody VipDay day)
    {
        day.setUpdateBy(SecurityUtils.getUsername());
        day.setUpdateDate(new Date());
        return toAjax(dayService.updateDay(day));
    }
    @DeleteMapping("/{pkIds}")
    @Log(title = "VIP节日",businessType = BusinessType.DELETE)
    @RequiresPermissions("taishanpic:day:remove")
    public AjaxResult remove(@PathVariable String[] pkIds)
    {
        return toAjax(dayService.deleteDayByIds(pkIds));
    }

    /**
     * excel导入表格下载
     */
    @PostMapping("/importTemplate")
    public AjaxResult importTemplate(HttpServletResponse response) throws IOException {
        ExcelUtil<VipDay> util = new ExcelUtil<VipDay>(VipDay.class);
        util.importTemplateExcel(response,"vip节日");
        return AjaxResult.success();
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
    @Log(title = "VIP节日",businessType = BusinessType.IMPORT)
    @RequiresPermissions("taishanpic:day:upload")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<VipDay> util = new ExcelUtil<VipDay>(VipDay.class);
        String message = "";
        try{
            List<VipDay> vipDayList = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = dayService.importDay(vipDayList,updateSupport,operName);
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
    @PostMapping("/exportVipDay")
    @Log(title = "VIP节日",businessType = BusinessType.EXPORT)
    @RequiresPermissions("taishanpic:day:export")
    public AjaxResult export(VipDay day,HttpServletResponse response)
    {
        logger.info(" vipController.export start");
        AjaxResult result = null;
        try{
            List<VipDay> list = dayService.selectDayList(day);
            ExcelUtil<VipDay> util = new ExcelUtil<VipDay>(VipDay.class);
            util.exportExcel(response,list,"节日");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("vipController.export error");
        }
        logger.info("vipController.export end ");
        return  result;
    }
}
