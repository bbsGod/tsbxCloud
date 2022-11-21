package com.tsvhlpom.job.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tsvhlpom.common.core.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 定时任务调度测试
 *
 * @author taishanpic
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    private VIPTask vipTask;

    @Autowired
    private ProdApiTask prodApiTask;

    @Autowired
    private BatchDataTask batchDataTask;

    @Autowired
    private MeetingpresetTask meetingpresetTask;

    @Autowired
    private ProdDataTask prodDataTask;

    /*@Value("${sendElec.url}")
    private String sendElecUrl;*/

    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    public void sendMessage(){
        vipTask.sendMessage();
    }

    public void handleBatchData_gb(){
        System.out.println("*****运维跑数定时任务  start");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String month = sdf.format(calendar.getTime());
        try{
            System.out.println(month+":光博  start");
            batchDataTask.initMiddleData(month);
            System.out.println(month+":光博  end");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("*****运维跑数定时任务  end");
    }
    public void handleBatchData_dz(){
        System.out.println("*****运维跑数定时任务  start");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String month = sdf.format(calendar.getTime());
        try{
            System.out.println(month+":对账  start");
            batchDataTask.makeData(month);
            System.out.println(month+":对账  end");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("*****运维跑数定时任务  end");
    }
    /**
     * 泰盛数据推送
     * @param
     */
    public String pushPolicyToTaiSheng(){
        System.out.println("泰盛中介信息推送开始");
        String msg =  prodApiTask.pushPolicyToTaiSheng();
        System.out.println("泰盛中介信息推送结束，msg="+msg);
        return msg;
    }

    public void rePushPolicyToTs(String startDateStr, String endDateStr, String appNo){
        System.out.println("泰盛中介ERROR信息推送开始");
        prodApiTask.rePushPolicyToTs(startDateStr,endDateStr,appNo);
        System.out.println("泰盛中介ERROR信息推送开始");
    }

    /**
     * 电子保单定时发送，每隔1分钟查询前三分钟到前两分钟的数据
     * @throws Exception
     */
   /* public void sendElecPolicy() throws Exception {
        System.out.println("sendElecPolicy  开始");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        calendar.add(Calendar.MINUTE, -3);
        String startDate = sdf.format(calendar.getTime());
        calendar.add(Calendar.MINUTE, 1);
        String endDate = sdf.format(calendar.getTime());

        startDate = URLEncoder.encode(startDate,"UTF-8") ;
        endDate = URLEncoder.encode(endDate,"UTF-8") ;

        //http://127.0.0.1:8088/pcis
        String url = sendElecUrl +"/sendElecPolicyService.iws?m=sendElecPolicy";
        url = url + "&xml=<root><StartDate>"+startDate+"</StartDate><EndDate>"+endDate+"</EndDate></root>&userCode=000090";
        HttpUtils.sendPcisPost(url,"");
        System.out.println("sendElecPolicy  结束");
    }

    *//**
     * 电子保单失败推送  每天早8点执行
     * @throws Exception
     *//*
    public void sendElecPolicyFailer() throws Exception {
        System.out.println("sendElecPolicyFailer  开始");
        String url = sendElecUrl + "/sendElecPolicyService.iws?m=sendElecPolicyForFailure";
        HttpUtils.sendPcisPost(url,"");
        System.out.println("sendElecPolicyFailer  结束");
    }*/

    public void meetingBookTask(){
        System.out.println("定时获取会议预定信息   开始");
        meetingpresetTask.genMeetingBookInfo();
        System.out.println("定时获取会议预定信息   结束");
    }

    public void updatWebPayConfirmInfo(){
        System.out.println("proddata 非车险数据更新 start");
        prodDataTask.updatWebPayConfirmInfo();
        System.out.println("proddata 非车险数据更新 end");
    }

    public void autoSendMessage(String sendMsg){
        System.out.println("meeting autoSendMessage start");
        meetingpresetTask.autoSendMessage(sendMsg);
        System.out.println("meeting autoSendMessage end");
    }
}
