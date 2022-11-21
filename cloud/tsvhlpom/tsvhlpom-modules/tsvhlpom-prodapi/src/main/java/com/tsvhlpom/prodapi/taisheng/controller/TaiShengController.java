package com.tsvhlpom.prodapi.taisheng.controller;


import com.tsvhlpom.prodapi.taisheng.service.TaiShengService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RestController
@RequestMapping("/taisheng")
@Slf4j
/**
 * 泰盛中介数据推送controller
 */
public class TaiShengController {

    @Autowired
    private TaiShengService taiShengService;

    @RequestMapping("/sendPolicyList")
    public String getPolicyList(String endDateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date endDate = null;
        if(endDateStr == null || "".equals(endDateStr)){
            endDate = new Date();
        } else{
            endDate = sdf.parse(endDateStr);
        }
        log.info(sdf.format(endDate)+"泰盛保批单推送数据开始 ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        //每五分钟推送一次数据，推送前10分钟到前5分钟的数据
        calendar.add(Calendar.MINUTE,-5);
        endDate = calendar.getTime();
        calendar.add(Calendar.MINUTE,-5);
        Date startDate = calendar.getTime();
        try{
            log.info("推送时间段，startDate:"+sdf.format(startDate)+",endDate:"+sdf.format(endDate));
            taiShengService.pushPolicyAndEndor(startDate,endDate);
        }catch (Exception e){
            log.error("startDate="+sdf.format(startDate)+"推送数据失败， "+e.getMessage());
            e.printStackTrace();
            return e.getMessage();
        }
        log.info("startDate="+sdf.format(startDate)+"推送数据结束 ");
        return "推送成功";
    }

    @RequestMapping("/rePushPolicyToTs")
    public String rePushPolicyToTs(@RequestParam(value = "startDateStr",required = false) String startDateStr,
                                   @RequestParam(value = "endDateStr",required = false) String endDateStr,
                                   @RequestParam(value = "appNo",required = false) String appNo){
        String msg = "推送失败数据成功";
        log.info("推送泰盛失败数据。。。。。。start");
        try{
            msg = taiShengService.rePushPolicyToTaiSheng(startDateStr,endDateStr,appNo);
        }catch (Exception e){
            log.error("泰盛失败数据重新推送失败。。。。。");
            e.printStackTrace();
            msg = e.getMessage();
        }
        log.info("推送泰盛失败数据。。。。。。end");
        return msg ;
    }

}

