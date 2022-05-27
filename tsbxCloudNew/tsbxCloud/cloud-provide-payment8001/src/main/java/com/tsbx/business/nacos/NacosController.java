package com.tsbx.business.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 测试nacos的服务注册中心
 */
@RestController
@Slf4j
public class NacosController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();} //单位秒
        return serverPort;
    }

    @GetMapping(value = "/consumer/payment/sendMsgByCookie")
    public String sendMsgByCookie(HttpServletRequest request, @RequestParam("name") String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                log.info("name:"+name);
                log.info(serverPort+"收到cookie：name:"+cookie.getName()+";"+"value:"+cookie.getValue());
            }
        }
        return "获取token";
    }
}
