package com.tsvhlpom.job.task;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.system.api.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = ServiceNameConstants.PRODDATA_SERVICE,fallbackFactory = RemoteUserFallbackFactory.class)
public interface ProdDataTask {

    @RequestMapping("/abstract/updatWebPayConfirmInfo")
    public String updatWebPayConfirmInfo();
}
