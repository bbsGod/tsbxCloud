package com.tsvhlpom.vip.task;

import com.tsvhlpom.vip.domain.SendMsg;
import com.tsvhlpom.vip.domain.SendMsgLog;
import com.tsvhlpom.vip.domain.VipDay;
import com.tsvhlpom.vip.mapper.SendMsgLogMapper;
import com.tsvhlpom.vip.mapper.SendMsgMapper;
import com.tsvhlpom.vip.service.IVipDayService;
import com.tsvhlpom.vip.sms.CommSmsHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/vipTask")
@Slf4j
public class VIPTask {

    private IVipDayService vipDayService;
    private SendMsgMapper sendMsgMapper;
    private SendMsgLogMapper sendMsgLogMapper;
    private CommSmsHelper commSmsHelper;

    @Autowired
    public VIPTask(SendMsgLogMapper sendMsgLogMapper,
                   SendMsgMapper sendMsgMapper,
                   IVipDayService vipDayService,
                   CommSmsHelper commSmsHelper) {
        this.commSmsHelper = commSmsHelper;
        this.sendMsgLogMapper = sendMsgLogMapper;
        this.sendMsgMapper = sendMsgMapper;
        this.vipDayService = vipDayService;
    }

    @Value("${smsContent.demo1}")
    private String demo1;
    @Value("${smsContent.demo1_1}")
    private String demo1_1;
    @Value("${smsContent.demo1_2}")
    private String demo1_2;
    @Value("${smsContent.demo1_3}")
    private String demo1_3;
    @Value("${smsContent.demo2}")
    private String demo2;
    @Value("${smsContent.demo3}")
    private String demo3;
    /*@Value("${smsContent.demo4}")
    private String demo4;*/

    @RequestMapping("/sendMessage")
    public void sendMessage(){
        String vip_dateStr = "";
        String vip_dayStr = "";
        String preFixMessage = "";// 短信祝福标题
        String surFixMessage = "";// 短信后缀
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            //log.info("日期："+sdf.format(cal.getTime()) + "开始发送短信");
            cal.add(Calendar.DAY_OF_MONTH,1);
            VipDay day = new VipDay();
            day.setDayDate(sdf.parse(sdf.format(cal.getTime())));
            List<VipDay> dayList = vipDayService.selectDayList(day);
            if(dayList ==null || dayList.size() <=0){
                log.info("今天不是节日前一天，不发短息");
                return;
            }else{
                vip_dayStr = dayList.get(0).getDayName();
                vip_dateStr = sdf.format(dayList.get(0).getDayDate());
                preFixMessage = dayList.get(0).getPreFixMessage();
                surFixMessage = dayList.get(0).getSurFixMessage();
            }

            log.info("日期"+sdf.format(new Date())+"是节日前一天，，，发短信");
            //select dayName from vip_day where dayDate =
            //1、获取重点客户标识为总公司的客户
            List<SendMsg> spCustList = sendMsgMapper.getSpCustList();
            log.info("获取重点标识为总公司信息："+spCustList.size() +"条");
            //2、获取VIP客户清单 维护的客户
            List<SendMsg> vipMsgList = sendMsgMapper.getVIPPlyInfoList();
            log.info("获取VIP维护的客户信息："+vipMsgList.size() +"条");
            //3、去重
            Map<String,SendMsg> sendMsgMap = new LinkedHashMap<>();
            for(SendMsg spCust: spCustList){
                if (spCust.getPhoneNo() != null && !"".equals(spCust.getPhoneNo())) {
                    if(!sendMsgMap.containsKey(spCust.getPhoneNo()) && !"".equals(spCust.getPhoneNo())){
                        sendMsgMap.put(spCust.getPhoneNo(),spCust);
                    }else{
                        SendMsg oldMsg = sendMsgMap.get(spCust.getPhoneNo());
                        if(!spCust.getPlyNo().equals(oldMsg.getPlyNo())){
                            oldMsg.setPlyNo(oldMsg.getPlyNo()+","+spCust.getPlyNo());
                        }
                    }
                }
            }
            for(SendMsg vipMsg: vipMsgList){
                if(vipMsg.getPhoneNo() !=null && !"".equals(vipMsg.getPhoneNo())){
                    if(!sendMsgMap.containsKey(vipMsg.getPhoneNo())){
                        sendMsgMap.put(vipMsg.getPhoneNo(),vipMsg);
                    }else{
                        SendMsg oldvipMsg = sendMsgMap.get(vipMsg.getPhoneNo());
                        if (vipMsg.getPlyNo() !=null && !"".equals(vipMsg.getPlyNo())) {
                            if(!vipMsg.getPlyNo().equals(oldvipMsg.getPlyNo())){
                                oldvipMsg.setPlyNo(oldvipMsg.getPlyNo()+","+vipMsg.getPlyNo());
                            }
                        }
                    }
                }
            }
            //4、短信发送
            log.info("sendMsgMap:" + sendMsgMap.size() + "条");
            if(sendMsgMap.size() == 0){
                log.info("未查询到需要发送短信的数据，撤回");
                return;
            }
            log.info("节日："+vip_dayStr+"循环发送开始");
            String finalVip_dateStr = vip_dateStr;
            String finalVip_dayStr = vip_dayStr;
            String finalPreFixMessage = preFixMessage;
            String finalSurFixMessage = surFixMessage;
            sendMsgMap.forEach((key, value) ->{
                boolean sendFalg = true;
                String content = demo1;
                content = content.replace("preFixMessage", finalPreFixMessage);
                content = content + "\r\n" + demo1_1 + "\r\n" + demo1_2 + "\r\n" + demo1_3;
                //组装发送报文
                Calendar now = Calendar.getInstance();
                Date start = now.getTime();
                now.add(Calendar.DAY_OF_MONTH,10);
                Date end = now.getTime();
                int i = 3;
                if(value.getInsuredEndDate() != null && !"".equals(value.getInsuredEndDate())) {
                    if(end.after(value.getInsuredEndDate()) && start.before(value.getInsuredEndDate())){
                        i++;
                        demo2 = demo2.replace("x",i+"").replace("plyNo",value.getPlyNo()).replace("date",sdf.format(value.getInsuredEndDate()));
                        content = content +"\r\n" + demo2;
                    }
                }
                if("1".equals(value.getStatus())){
                    i++;
                    demo3 = demo3.replace("y",i+"");
                    content = content +"\r\n"+ demo3;
                }
                content = content +"\r\n"+ finalSurFixMessage ;
                SendMsgLog sendMsgLog = new SendMsgLog();
                try {

                    sendMsgLog.setPhoneNo(key);
                    sendMsgLog.setVip_date(finalVip_dateStr);
                    sendMsgLog.setVip_day(finalVip_dayStr);
                    sendMsgLog.setStatus("0");
                    List<SendMsgLog> sendMsgLogList =  sendMsgLogMapper.getSendMsgLog(sendMsgLog);
                    if(sendMsgLogList !=null && sendMsgLogList.size() > 0){
                        sendFalg = false;
                        log.info("phoneNo:"+key+",节假日："+ finalVip_dayStr +",已发短信，不重复发送");
                    }else{
                        // 测试环境 暂时注掉，不发送短信
                        /*log.info("现在是测试环境代码，不发送短信");
                        Map<String, String> returnMap = new HashMap<>();
                        returnMap.put("ResponseCode","00");*/
                        log.info("现在是正式环境代码，正常发送短信");
                        Map<String, String> returnMap = commSmsHelper.sendSms(key,"",content);

                        log.info("VIP短信："+key+"@@@@"+content);
                        sendMsgLog.setSendDate(new Date());
                        sendMsgLog.setSendMsg(content);
                        if("00".equals(returnMap.get("ResponseCode"))){
                            sendMsgLog.setStatus("0");
                        }else{
                            sendMsgLog.setStatus("1");
                            sendMsgLog.setErrMsg(returnMap.get("ResponseMessage"));
                        }

                    }

                } catch (Exception e) {
                    log.error("commSmsHelpr error...." + "");
                    e.printStackTrace();
                }finally {
                    if(sendFalg){
                        sendMsgLogMapper.saveSendMsgLog(sendMsgLog);
                    }
                }
            });
            log.info("节日："+vip_dayStr+"循环发送 结束");
        }catch (Exception e){
            log.error("task  sendMessage 节日短信发送出错 error....");
            e.printStackTrace();
        }
    };
}
