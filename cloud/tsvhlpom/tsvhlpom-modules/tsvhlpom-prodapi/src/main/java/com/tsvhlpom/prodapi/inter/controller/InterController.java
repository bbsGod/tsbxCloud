package com.tsvhlpom.prodapi.inter.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.security.utils.DictUtils;
import com.tsvhlpom.prodapi.inter.VO.InterResVO;
import com.tsvhlpom.prodapi.inter.service.InterService;
import com.tsvhlpom.system.api.domain.SysDictData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inter")
@Slf4j
/**
 * 除泰盛外，其他中介公司获取中介信息controller
 */
public class InterController {

    @Autowired
    private InterService interService;
    @RequestMapping("/getInfo")
    public AjaxResult getInfo(@RequestBody String param){
        log.info("中介信息 查询 start");
        AjaxResult ajaxResult = AjaxResult.success("请求成功");
        Date startDate = null;
        Date endDate = null;
        try{
            log.info("请求参数转json:::==="+param);
            JSONObject paramJson = JSONObject.parseObject(param);
            if(paramJson.containsKey("id") && !"".equals(paramJson.getString("id"))){
                if(paramJson.containsKey("startDate") && !"".equals(paramJson.getString("startDate"))
                    && paramJson.containsKey("endDate") && !"".equals(paramJson.getString("endDate"))){
                    startDate = paramJson.getDate("startDate");
                    endDate = paramJson.getDate("endDate");
                    if(Math.floor(endDate.getTime() -startDate.getTime())/(24*60*60*1000) > 1){
                        ajaxResult.put("data","时间间隔不能大于1天");
                        return ajaxResult;
                    }
                }else{
                    Calendar cal = Calendar.getInstance();
                    endDate = cal.getTime();
                    cal.add(Calendar.DAY_OF_MONTH,-1);
                    startDate = cal.getTime();
                    log.info("请求参数，日期为空，查询时间段为，start:"+startDate+",endDate:"+endDate);
                }
                List<SysDictData> dataList =  DictUtils.getDictCache("sys_broker_id");
                Boolean isHas = false;
                for(SysDictData data : dataList){
                    if(paramJson.getString("id").equals(data.getDictValue())){
                        isHas = true;
                    }
                }
                if(!isHas){
                    ajaxResult.put("data","请求中介ID不正确，请检查");
                    return ajaxResult;
                }
                List<InterResVO> resList = interService.getInfo(paramJson.getString("id"),startDate,endDate);
                ajaxResult.put("total",resList.size());
                ajaxResult.put("data", resList);
            }else{
                ajaxResult.put("data","请求中介ID不能为空");
                return ajaxResult;
            }

        }catch (Exception e){
            log.error("系统内部错误：：：");
            e.printStackTrace();
            return AjaxResult.error("系统内部错误，请联系系统管理人员"+e.getMessage());
        }
        log.info("中介信息 查询 end");
        return ajaxResult;
    }
}
