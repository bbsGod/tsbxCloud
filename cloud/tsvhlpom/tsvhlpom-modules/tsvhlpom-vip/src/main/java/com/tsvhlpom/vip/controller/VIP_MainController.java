package com.tsvhlpom.vip.controller;

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
import com.tsvhlpom.system.api.model.LoginUser;
import com.tsvhlpom.vip.domain.VIP_Main;
import com.tsvhlpom.vip.service.VIP_MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/vip_main")
@Slf4j
public class VIP_MainController extends BaseController {

    @Autowired
    private VIP_MainService vipService;
    @Autowired
    private TokenService tokenService;


    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:query')")
    @GetMapping("/getVIPList")
    //@Log(title = "VIP客户/getVIPList")
    @RequiresPermissions("taishanpic:vip:list")
    public TableDataInfo getVIPList(VIP_Main vip)
    {
        log.info("VIPController.getVIPList start");
        startPage();
        List<VIP_Main> list = null;
        try{
            list = vipService.getVIPList(vip);
            log.info("VIPController.getVIPList success");
        }catch (Exception e){
            log.error("VIPController.getVIPList error!!!!!!!!!!");
            e.printStackTrace();
        }
        log.info("VIPController.........getVIPList end");
        return getDataTable(list);
    }
    @RequestMapping(value = "/{pkId}")
    @RequiresPermissions("taishanpic:vip:query")
    //@Log(title = "VIP客户/getVIPByPKID")
    public R getVIP(@PathVariable("pkId") String pkId){
        return R.ok(vipService.getVIPByPkID(pkId));
    }
    /**
     * vip信息新增接口
     */
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:add')")
    @RequiresPermissions("taishanpic:vip:add")
    @RequestMapping("/save")
    @Log(title = "VIP客户",businessType = BusinessType.INSERT)
    public AjaxResult save(@RequestBody VIP_Main vip){
        log.info("vip Controller save start");
        try{
            List<VIP_Main> vipList =  vipService.getVIPList(vip);
            if(vipList !=null && vipList.size() > 0){
                return AjaxResult.error("VIP客户信息已存在");
            }
            vipService.save(vip);
            log.info("vip Controller save success");
        }catch (Exception e){
            log.error("vip信息保存报错");
            e.printStackTrace();
            return AjaxResult.error("vip信息保存报错");
        }
        log.info("vip Controller save end");
        return  AjaxResult.success("保存成功");
    }
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:update')")
    @RequestMapping("/update")
    @Log(title = "VIP客户",businessType = BusinessType.UPDATE)
    @RequiresPermissions("taishanpic:vip:edit")
    public AjaxResult update(@RequestBody VIP_Main vip){
        log.info("vip Controller update start");
        try{
            vipService.update(vip);
            log.info("vip Controller update success");
        }catch (Exception e){
            log.error("vip信息update报错");
            e.printStackTrace();
            return AjaxResult.error("vip信息update报错");
        }
        log.info("vip Controller update end");
        return  AjaxResult.success("更新成功");
    }
    //@PreAuthorize("@ss.hasPermi('taishanpic:vip:delete')")
    @Log(title = "VIP客户",businessType = BusinessType.DELETE)
    @GetMapping(value = "/delete/{pkIds}")
    @RequiresPermissions("taishanpic:vip:delete")
    public AjaxResult delete(@PathVariable("pkIds") String[] pkIds){
        try{
            log.info("vip Controller delete start");
            vipService.delete(pkIds);
            log.info("vip Controller delete success  end");
        }catch (Exception e){
            log.error("vip Controller delete  error!!!");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<VIP_Main> util = new ExcelUtil<VIP_Main>(VIP_Main.class);
        util.importTemplateExcel(response,"vip客户信息");
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
    @RequiresPermissions("taishanpic:vip:upload")
    @Log(title = "VIP客户",businessType = BusinessType.IMPORT)
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<VIP_Main> util = new ExcelUtil<VIP_Main>(VIP_Main.class);
        String message = "";
        try{
            List<VIP_Main> vipList = util.importExcel(file.getInputStream());
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            String operName = loginUser.getUsername();
            message = vipService.importData(vipList, updateSupport, operName);
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
    @PostMapping("/exportVip")
    @RequiresPermissions("taishanpic:vip:export")
    @Log(title = "VIP客户",businessType = BusinessType.EXPORT)
    public void export(VIP_Main vip, HttpServletResponse response)
    {
        logger.info(" vipController.export start");
        try{
            List<VIP_Main> list = vipService.getVIPList(vip);
            ExcelUtil<VIP_Main> util = new ExcelUtil<VIP_Main>(VIP_Main.class);
            util.exportExcel(response,list,"VIP客户信息数据导出");
            //result =  util.exportExcel(list, "VIP客户信息数据导出");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("vipController.export error");
        }
        logger.info("vipController.export end ");
    }

}
