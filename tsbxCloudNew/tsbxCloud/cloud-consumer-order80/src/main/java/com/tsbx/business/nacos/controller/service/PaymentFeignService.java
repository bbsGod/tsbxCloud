package com.tsbx.business.nacos.controller.service;

import com.tsbx.business.nacos.controller.service.impl.RemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@FeignClient(value = "cloud-payment-service",fallback = RemoteHystrix.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id) ;

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

    @GetMapping(value = "/consumer/payment/sendMsgByCookie")
    void sendMsgByCookie(@RequestParam("name") String name);
}
