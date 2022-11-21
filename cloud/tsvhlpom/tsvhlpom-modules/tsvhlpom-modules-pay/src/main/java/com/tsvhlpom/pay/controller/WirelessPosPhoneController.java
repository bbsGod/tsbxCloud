package com.tsvhlpom.pay.controller;

import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.pay.service.WirelessPosPhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay_service")
@Slf4j
public class WirelessPosPhoneController {
    @Autowired
    private WirelessPosPhoneService wirelessPosPhoneService;

    @RequestMapping("/pay")
    public AjaxResult pay(String bizseq){
        String resMsg = "";
        try{
            log.info("支付 start");
            resMsg = wirelessPosPhoneService.mainPay(bizseq);
        }catch (Exception e){
            log.error("支付 error");
            e.printStackTrace();
            return AjaxResult.error(resMsg);
        }
        log.info("支付 end");
        return AjaxResult.success(resMsg);
    }
}
