package com.tsvhlpom.job.task;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.system.api.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = ServiceNameConstants.VIP_SERVICE,fallbackFactory = RemoteUserFallbackFactory.class)
public interface VIPTask {

    @RequestMapping(value = "/vipTask/sendMessage")
    public void sendMessage();
}
