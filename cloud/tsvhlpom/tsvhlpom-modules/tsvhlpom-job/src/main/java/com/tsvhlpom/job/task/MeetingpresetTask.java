package com.tsvhlpom.job.task;


import com.tsvhlpom.common.core.constant.ServiceNameConstants;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.system.api.factory.RemoteUserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = ServiceNameConstants.MEETING_SERVICE,fallbackFactory = RemoteUserFallbackFactory.class)
public interface MeetingpresetTask {
    @RequestMapping("/meetingBook/genMeetingBookInfo")
    public AjaxResult genMeetingBookInfo();

    @RequestMapping("/messagSend/autoSendMessage")
    public void autoSendMessage(String sendMsg);
}
