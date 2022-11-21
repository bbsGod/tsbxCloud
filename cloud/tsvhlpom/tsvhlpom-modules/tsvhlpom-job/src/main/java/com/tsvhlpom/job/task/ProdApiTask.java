package com.tsvhlpom.job.task;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.system.api.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(name = ServiceNameConstants.PRODAPI_SERVICE,fallbackFactory = RemoteUserFallbackFactory.class)
public interface ProdApiTask {

    @RequestMapping("/taisheng/sendPolicyList")
    public String pushPolicyToTaiSheng();


    @RequestMapping("/taisheng/rePushPolicyToTs")
    public String rePushPolicyToTs(@RequestParam(value = "startDateStr",required = false) String startDateStr,
                                   @RequestParam(value = "endDateStr",required = false) String endDateStr,
                                   @RequestParam(value = "appNo",required = false) String appNo);

}
