package com.tsvhlpom.covid19.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.covid19.domain.Covid;
import com.tsvhlpom.covid19.domain.DoneList;
import com.tsvhlpom.covid19.domain.Emplyee;
import com.tsvhlpom.covid19.service.CovidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/covid")
@RestController
public class CovidController extends BaseController {
    @Autowired
    private CovidService covidService;


    @RequestMapping("/saveInfo")
    public AjaxResult saveInfo(@RequestBody Covid covid){
        log.info("保存双码信息 start,时间：" + new SimpleDateFormat("YYYY-mm-dd").format(new Date())+",姓名："+covid.getC_name());
        try{
            covidService.save(covid);
        }catch (Exception e){
            log.error("双码信息保存出错");
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        log.info("保存双码信息 成功");
        return AjaxResult.success("保存成功");
    }

    @RequestMapping("/getCovidList")
    public TableDataInfo getCovidList(Covid covid){
        logger.info("查询双码列表 start");
        startPage();
        List<Covid> covidList = null;
        try{
            covidList = covidService.getCovidList(covid);
        }catch (Exception e){
            logger.error("获取双码列表出错");
            e.printStackTrace();
        }
        logger.info("查询双码列表  end");
        return getDataTable(covidList);
    }

    @RequestMapping("/exportInfo")
    public void exportInfo(Covid covid, HttpServletResponse response){
        try{
            covidService.exportInfo(covid,response);
        }catch (Exception e){
            log.error("导出错误：");
            e.printStackTrace();
        }
    }
    @RequestMapping("/statistics")
    public Map statistics(@RequestBody String param){
        logger.info("双码登记，首页统计信息查询开始");
        JSONObject jsonObject = JSON.parseObject(param);
        Map resultMap = covidService.statistics(jsonObject.getString("c_parent_dept"),
                jsonObject.getString("c_dept"),jsonObject.getString("day"));
        logger.info("双码登记，首页统计信息查询结束");
        return resultMap;
    }

    @RequestMapping("/getDoneResult")
    public TableDataInfo getDoneResult(DoneList doneList){
        logger.info("查询打卡信息 start");
        startPage();
        List<DoneList> resultMap = null;
        try{
            //JSONObject jsonObject = JSON.parseObject(param);
            resultMap = covidService.getDoneResult(doneList.getC_parent_dept(),
                    doneList.getC_dept(),doneList.getDay());
        }catch (Exception e){
            logger.error("获取打卡信息出错");
            e.printStackTrace();
        }
        logger.info("查询打卡信息  end");
        return getDataTable(resultMap);
    }

    @RequestMapping("/exportDoneList")
    public void exportDoneList(HttpServletResponse response,DoneList doneList)
    {
        logger.info(" exportDoneList.export start");
        try{
            List<DoneList> list = covidService.getDoneResult(doneList.getC_parent_dept(),doneList.getC_dept(),doneList.getDay());
            ExcelUtil<DoneList> util = new ExcelUtil<DoneList>(DoneList.class);
            util.exportExcel(response,list,"打卡信息");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("exportDoneList.export error");
        }
        logger.info("exportDoneList.export end ");
    }
    @RequestMapping("/exportUnDoneList")
    public void exportUnDoneList(HttpServletResponse response,DoneList doneList)
    {
        logger.info(" exportUnDoneList.export start");
        try{
            List<Emplyee> list = covidService.getUnDoneResult(doneList.getC_parent_dept(),doneList.getC_dept(),doneList.getDay());
            ExcelUtil<Emplyee> util = new ExcelUtil<Emplyee>(Emplyee.class);
            util.exportExcel(response,list,"未登记员工信息");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("exportUnDoneList.export error");
        }
        logger.info("exportUnDoneList.export end ");
    }

    @RequestMapping("/getName")
    public String getName(@RequestParam String c_phone) throws Exception {
        String name = "";
        try{
            name = covidService.getName(c_phone);
            if(StringUtils.isEmpty(name)){
                throw new Exception("未查询到姓名");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return name;
    }

    @RequestMapping("/getUndoneDetial")
    public AjaxResult getUndoneDetial(DoneList doneList){
        logger.info("查询未打卡人员详情信息 start");
        //startPage();
        List<String> resultMap = null;
        try{
            //JSONObject jsonObject = JSON.parseObject(param);
            resultMap = covidService.getUndoneDetial(doneList.getC_parent_dept(),
                    doneList.getC_dept(),doneList.getDay());
        }catch (Exception e){
            logger.error("查询未打卡人员详情信息  出错");
            e.printStackTrace();
        }
        logger.info("查询未打卡人员详情信息  end");
        return AjaxResult.success(resultMap);
    }
}
