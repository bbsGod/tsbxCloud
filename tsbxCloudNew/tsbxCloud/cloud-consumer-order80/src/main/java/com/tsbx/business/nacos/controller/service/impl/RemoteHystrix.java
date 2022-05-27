package com.tsbx.business.nacos.controller.service.impl;

import com.tsbx.business.nacos.controller.service.PaymentFeignService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RemoteHystrix implements PaymentFeignService {
    @Override
    public String getPayment(Long id) {
        return null;
    }

    @Override
    public String paymentFeignTimeout() {
        return "请求超时了";
    }

    @Override
    public void sendMsgByCookie(String name) {

    }

}
