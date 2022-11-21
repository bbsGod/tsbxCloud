package com.tsvhlpom.cargroup.controller;

import com.tsvhlpom.cargroup.domain.BaseCustomers;
import com.tsvhlpom.cargroup.domain.BasePrice;
import com.tsvhlpom.cargroup.service.BasePriceService;
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
import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/basePrice")
public class BasePriceController extends BaseController {

    @Autowired
    private BasePriceService basePriceService;

    @RequestMapping("/getBasePriceList")
    public TableDataInfo getBasePriceList(BasePrice basePrice){
        log.info("cargroup getBasePriceList start");
        List<BasePrice> basePriceList = null;
        startPage();
        try{
            basePriceList =   basePriceService.getBasePriceList(basePrice);
        }catch (Exception e){
            log.error("cargroup  getBasePriceList err ");
            e.printStackTrace();
        }
        log.info("cargroup getBasePriceList end");
        return getDataTable(basePriceList);
    }

    @RequestMapping("/getPriceById/{pk_id}")
    public R getPriceById(@PathVariable("pk_id") String pk_id){
        return R.ok(basePriceService.getPriceById(pk_id));
    }
    @RequestMapping("/save")
    public AjaxResult save(@RequestBody BasePrice basePrice){
        log.info("cargroup  BasePrice save  start");
        try{
            basePriceService.save(basePrice);
        }catch (Exception e){
            log.error("cargroup  BasePrice save error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  BasePrice save  end");
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    public AjaxResult update(@RequestBody BasePrice basePrice){
        log.info("cargroup  BasePrice save  start");
        try{
            basePriceService.update(basePrice);
        }catch (Exception e){
            log.error("cargroup  BasePrice update error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  BasePrice update  end");
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{pk_ids}")
    public AjaxResult delete(@PathVariable("pk_ids") String[] pk_ids){
        log.info("cargroup  BasePrice delete  start");
        try{
            basePriceService.delete(pk_ids);
        }catch (Exception e){
            log.error("cargroup  BasePrice delete error");
            e.printStackTrace();
            return AjaxResult.error();
        }
        log.info("cargroup  BasePrice delete  end");
        return AjaxResult.success();
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<BasePrice> util = new ExcelUtil<BasePrice>(BasePrice.class);
        util.importTemplateExcel(response,"报表");
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
        ExcelUtil<BasePrice> util = new ExcelUtil<BasePrice>(BasePrice.class);
        String message = "";
        try{
            List<BasePrice> vipList = util.importExcel(file.getInputStream());
            message = basePriceService.importData(vipList, updateSupport, "");
            logger.info("importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("importData文件上传 结束");
        return AjaxResult.success(message);
    }

    @RequestMapping("/price")
    public AjaxResult price(@RequestBody BaseCustomers baseCustomers){
        log.info("price start...");
        BasePrice price = null;
        try{
            price = basePriceService.price(baseCustomers);
        }catch (Exception e){
            log.error("price error...");
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        log.info("price end...");
        return AjaxResult.success(price);
    }


    @RequestMapping("/exportPrice")
    public void exportPrice(BasePrice basePrice,HttpServletResponse response) throws Exception {
        basePriceService.exportPrice(basePrice,response);
    }

    @RequestMapping("/updatePriceStatus")
    public void updatePriceStatus(@RequestBody BasePrice basePrice) throws ParseException {
        basePriceService.updatePriceStatus(basePrice,"");
    }
}
