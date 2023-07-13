package com.tsbx.business.nacos.controller.service.impl;

import com.tsbx.business.channel.pojo.MesChannel;
import com.tsbx.business.nacos.controller.service.PaymentFeignService;
import com.tsbx.entities.ApiResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Override
    public ApiResponse<List<MesChannel>> getChannel() {
        return null;
    }

}
