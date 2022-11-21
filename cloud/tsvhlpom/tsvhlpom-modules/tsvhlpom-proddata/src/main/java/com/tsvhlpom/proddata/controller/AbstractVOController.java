package com.tsvhlpom.proddata.controller;

import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.proddata.domain.AbstractVO;
import com.tsvhlpom.proddata.mapper.AbstractVOMapper;
import com.tsvhlpom.proddata.service.AbstractVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/abstract")
public class AbstractVOController extends BaseController {

    @Autowired
    private AbstractVOService abstractVOService;

    @Autowired
    private AbstractVOMapper abstractVOMapper;
    @RequestMapping("/getAppEmailList")
    public TableDataInfo getAppEmailList(AbstractVO abstractVO){
        logger.info("查询email信息列表");
        startPage();
        List<AbstractVO> abstractVOList = null;
        try{
            abstractVOList = abstractVOService.selectEmail(abstractVO.getC_app_no());
        }catch (Exception e){
            logger.error("获取email信息列表出错");
            e.printStackTrace();
        }
        return getDataTable(abstractVOList);
    }
    @RequestMapping("/updateEmail")
    @RequiresPermissions("proddata:abstract:update")
    @Log(title = "生产数据{投被保险人邮箱}",businessType = BusinessType.UPDATE)
    public AjaxResult updateEmail(@RequestBody AbstractVO abstractVO){
        try{
            logger.info("开始更新邮箱：appNo = "+abstractVO.getC_app_no());
            logger.info("开始更新appAppliant");
            abstractVOService.updateAppAppliantEmail(abstractVO);
            logger.info("开始更新AppInsured");
            abstractVOService.updateAppInsuredEmail(abstractVO);
            logger.info("开始更新PlyAppliant");
            abstractVOService.updatePlyAppliantEmail(abstractVO);
            logger.info("开始更新PlyInsured");
            abstractVOService.updatePlyInsuredEmail(abstractVO);
            logger.info("更新邮箱结束！！！！：appNo = "+abstractVO.getC_app_no());
        }catch (Exception e){
            logger.error("abstractVO更新出错");
            e.printStackTrace();
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

    /*修改非车险金额 start*/

    @RequestMapping("/getn_novhl_pay_amt")
    public TableDataInfo getn_novhl_pay_amt(AbstractVO abstractVO){
        logger.info("getn_novhl_pay_amt start");
        startPage();
        List<AbstractVO> abstractVOList = null;
        try{
            abstractVOList = abstractVOService.selectN_novhl_pay_amt(abstractVO.getC_app_no());
        }catch (Exception e){
            logger.error("getn_novhl_pay_amt error");
            e.printStackTrace();
        }
        logger.info("getn_novhl_pay_amt end");
        return getDataTable(abstractVOList);
    }

    @RequestMapping("/updatWebPayConfirmInfo")
    @Log(title = "生产数据(WebPayConfirmInfo)",businessType = BusinessType.UPDATE)
    public AjaxResult updatWebPayConfirmInfo(String date){
        logger.info("updatWebPayConfirmInfo  start");
        try{
            abstractVOService.updatWebPayConfirmInfo();
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("updatWebPayConfirmInfo  end");
        return AjaxResult.success();
    }
    @RequestMapping("/updatWebPayConfirmInfoByDate")
    public AjaxResult updatWebPayConfirmInfoByDate(String startDate,String endDate){
        logger.info("updatWebPayConfirmInfoByDate  start");
        try{
            abstractVOService.updatWebPayConfirmInfoByDate(startDate,endDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("updatWebPayConfirmInfoByDate  end");
        return AjaxResult.success();
    }

    /*修改非车险金额 end*/


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<AbstractVO> util = new ExcelUtil<AbstractVO>(AbstractVO.class);
        util.importTemplateExcel(response,"模板");
    }
    /**
     * 更新客户回访状态，同时新插入到回访详情
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/updateCreateTimeByExport")
    public AjaxResult updateCreateTimeByExport(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("updateVisitInfoByExport 文件上传 开始");
        ExcelUtil<AbstractVO> util = new ExcelUtil<AbstractVO>(AbstractVO.class);
        String message = "";
        try{
            List<AbstractVO> customersList = util.importExcel(file.getInputStream());
            message = abstractVOService.updateTimeByExport(customersList,updateSupport);
            logger.info("updateVisitInfoByExport文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("updateVisitInfoByExport文件上传 结束");
        return AjaxResult.success(message);
    }

    @RequestMapping("/updateJQ")
    public AjaxResult updateJQ(){
        logger.info("updateJQ start");
        try{
            int a = abstractVOMapper.updateAppCvrg();
            logger.info("app:"+a+"条");
            int b = abstractVOMapper.updatePlyCvrg();
            logger.info("ply:"+b+"条");
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("updateJQ end");
        return AjaxResult.success();
    }
}
