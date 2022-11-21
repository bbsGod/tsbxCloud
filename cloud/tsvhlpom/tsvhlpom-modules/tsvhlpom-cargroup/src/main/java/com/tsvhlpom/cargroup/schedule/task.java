package com.tsvhlpom.cargroup.schedule;


import com.tsvhlpom.cargroup.service.BaseCustomersService;
import com.tsvhlpom.cargroup.service.BasePriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@Slf4j
public class task {

    @Autowired
    private BaseCustomersService baseCustomersService;

    @Autowired
    private BasePriceService basePriceService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void updateVisitJob() {
        try{
            log.info("开始更新半年前状态");
            baseCustomersService.updateVisitInfo();
            log.info("更新半年前状态  结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0 30 0 * * ? ")
    public void autoUpdatePriceStatusJob() {
        try{
            log.info("autoUpdatePriceStatus  start");
            basePriceService.autoUpdatePriceStatus();
            log.info("autoUpdatePriceStatus  end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
