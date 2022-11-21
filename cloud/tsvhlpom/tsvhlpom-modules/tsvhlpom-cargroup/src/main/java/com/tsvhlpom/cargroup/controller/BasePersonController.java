package com.tsvhlpom.cargroup.controller;


import com.tsvhlpom.cargroup.domain.BasePerson;
import com.tsvhlpom.cargroup.service.BasePersonService;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/basePerson")
public class BasePersonController extends BaseController {

    @Autowired
    private BasePersonService basePersonService;

    @RequestMapping("/getPersonList")
    public TableDataInfo getPersonList(BasePerson basePerson){
        log.info("cargroup getPersonList start");
        List<BasePerson> basePersonList = null;
        startPage();
        try{
            basePersonList =   basePersonService.getPersonList(basePerson);
        }catch (Exception e){
            log.error("cargroup  getPersonList err ");
            e.printStackTrace();
        }
        log.info("cargroup getPersonList end");
        return getDataTable(basePersonList);
    }

    @RequestMapping("/getPersonById/{sp_id}")
    public R getPersonById(@PathVariable("sp_id") String sp_id){
        return R.ok(basePersonService.getPersonById(sp_id));
    }
    @RequestMapping("/save")
    public AjaxResult save(@RequestBody BasePerson basePerson){
        log.info("cargroup  baseperson save  start");
        try{
            basePersonService.insert(basePerson);
        }catch (Exception e){
            log.error("cargroup  baseperson save error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  baseperson save  end");
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    public AjaxResult update(@RequestBody BasePerson basePerson){
        log.info("cargroup  baseperson save  start");
        try{
            basePersonService.update(basePerson);
        }catch (Exception e){
            log.error("cargroup  baseperson update error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  baseperson update  end");
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{sp_ids}")
    public AjaxResult delete(@PathVariable("sp_ids") String[] sp_ids){
        log.info("cargroup  baseperson delete  start");
        try{
            basePersonService.delete(sp_ids);
        }catch (Exception e){
            log.error("cargroup  baseperson delete error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  baseperson delete  end");
        return AjaxResult.success();
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<BasePerson> util = new ExcelUtil<BasePerson>(BasePerson.class);
        util.importTemplateExcel(response,"客户信息");
    }

    /**
     * 导入文件上传
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<BasePerson> util = new ExcelUtil<BasePerson>(BasePerson.class);
        String message = "";
        try{
            List<BasePerson> vipList = util.importExcel(file.getInputStream());
            message = basePersonService.importData(vipList, updateSupport, "");
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
