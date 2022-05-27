package com.tsbx.business.nacos.controller;

import com.tsbx.business.nacos.controller.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * nacos 的消费方的 服务
 */
@RestController
@Slf4j
public class NacosController {

    @Autowired
    //调用远程的微服接口
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return paymentFeignService.getPayment(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {

            return paymentFeignService.paymentFeignTimeout();
    }
    @GetMapping(value = "/consumer/payment/getCookie")
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("token","ip234xzclfsdf324");
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "设置cookie";
    }

    @GetMapping(value = "/consumer/payment/sendMsgByCookie")
    public String sendMsgByCookie(HttpServletRequest request, HttpServletResponse response) {
     /*   Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                log.info("name:"+cookie.getName()+";"+"value:"+cookie.getValue());
            }
        }*/
        paymentFeignService.sendMsgByCookie("张三");
        return "token";
    }

}
