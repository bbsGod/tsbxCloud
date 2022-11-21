package com.tsvhlpom.meetingpreset.controller;


import com.tsvhlpom.meetingpreset.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messagSend")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/autoSendMessage")
    public void autoSendMessage(@RequestBody String sendMsg) throws Exception {
        messageService.autoSendMessage(sendMsg);
    }

}
