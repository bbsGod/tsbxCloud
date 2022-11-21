package com.tsvhlpom.system.api;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.system.api.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(contextId = "UserCheckService", value = ServiceNameConstants.USER_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface UserCheckService {
    @RequestMapping("/userCheck/checkUser")
    public AjaxResult userCheck(@RequestBody String user);
}
