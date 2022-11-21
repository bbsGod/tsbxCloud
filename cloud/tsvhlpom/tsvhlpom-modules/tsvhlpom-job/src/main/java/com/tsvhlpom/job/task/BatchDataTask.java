package com.tsvhlpom.job.task;

import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 添加运维跑数定时任务
 */
@FeignClient(name = ServiceNameConstants.BATCHDATA_SERVICE)
public interface BatchDataTask {

    @RequestMapping("/gbMonthData/initMiddleData")
    public void initMiddleData(@RequestParam("month") String month) throws Exception;

    @RequestMapping(value = "/vpdc/makeData")
    public void makeData(@RequestParam("month") String month) throws Exception;
}
