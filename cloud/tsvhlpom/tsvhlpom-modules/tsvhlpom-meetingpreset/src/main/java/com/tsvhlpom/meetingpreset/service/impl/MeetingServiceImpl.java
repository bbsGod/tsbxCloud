package com.tsvhlpom.meetingpreset.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.utils.http.HttpUtils;
import com.tsvhlpom.common.redis.service.RedisService;
import com.tsvhlpom.meetingpreset.domain.MeetingBookInfo;
import com.tsvhlpom.meetingpreset.domain.MeetingRoom;
import com.tsvhlpom.meetingpreset.domain.Person;
import com.tsvhlpom.meetingpreset.domain.StatisticsParam;
import com.tsvhlpom.meetingpreset.mapper.MeetingBookInfoMapper;
import com.tsvhlpom.meetingpreset.mapper.PersonMapper;
import com.tsvhlpom.meetingpreset.service.MeetingService;
import com.tsvhlpom.meetingpreset.util.CommSmsHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private MeetingBookInfoMapper meetingBookInfoMapper;

    @Autowired
    private CommSmsHelper commSmsHelper;

    @Autowired
    private PersonMapper personMapper;

    @Value(("${token.tokenUrl}"))
    private String tokenUrlStr;
    @Value("${token.corpid}")
    private String corpid;
    @Value("${token.corpsecret}")
    private String corpsecret;

    @Value("${meeting.url}")
    private String meetingUrl;
    @Value("${sms.adminPhone}")
    private String adminPhone;
    @Value("${sms.adminPhone_other}")
    private String adminPhone_other;
    @Value("${sms.wuyePhone}")
    private String wuyePhone;
    @Value("${sms.wuyePhone_other}")
    private String wuyePhone_other;

    @Value("${approvel.tokenUrl}")
    private String approvelTokenUrl;
    @Value("${approvel.param}")
    private String approvelpram;
    @Value("${approvel.spNoUrl}")
    private String spNoUrl;
    @Value("${approvel.spDetialUrl}")
    private String spDetialUrl;

    //获取员工信息及部门信息 token start
    @Value("${user.token}")
    private String userTokenUrl;
    @Value("${user.param}")
    private String userParam;
    @Value("${user.url}")
    private String userUrl;
    @Value("${user.deptUrl}")
    private String userDeptUrl;
    //获取员工信息及部门信息 token end
    @Value("${meeting.bookUrl}")
    private String bookUrl;

    @Override
    /**
     * 获取token
     */
    public String getMeetRoom_token() {

        log.info("getAccess_token start");
        //获取审批token，如果过期，重新获取
        if(redisService.getCacheObject("meetToken") ==null || "".equals(redisService.getCacheObject("meetToken"))){
            String param = "corpid="+corpid+"&corpsecret="+corpsecret;
            String approvelTokenStr = HttpUtils.sendGet(tokenUrlStr,param);
            JSONObject approvelTokenJson = JSONObject.parseObject(approvelTokenStr);
            if("0".equals(approvelTokenJson.getString("errcode"))){
                redisService.setCacheObject("meetToken",approvelTokenJson.getString("access_token"),approvelTokenJson.getLong("expires_in"), TimeUnit.SECONDS);
            }
        };
        return redisService.getCacheObject("meetToken");
       /*
        String param = "corpid="+corpid+"&corpsecret="+corpsecret;
        String returnStr = HttpUtils.sendGet(tokenUrlStr,param);
        JSONObject returnJson = JSONObject.parseObject(returnStr);
        return returnJson.getString("access_token");*/
    }


    /**
     * 获取会议室列表，放到redis
     * @param token
     */
    public void getMeetingList(String token){
        String returnStr = HttpUtils.sendGet(meetingUrl,"access_token="+token);
        JSONObject returnJson = JSONObject.parseObject(returnStr);
        List<MeetingRoom>  roomList = JSON.parseArray(returnJson.getString("meetingroom_list"),MeetingRoom.class);
               // JSONArray.toJavaObject(returnJson.getJSONArray("meetingroom_list"), MeetingRoom.class);
        log.info("删除缓存");
        redisService.deleteObject("meetingroom");
        log.info("redis set ");
        redisService.setCacheList("meetingroom",roomList);
        //redisService.setCacheObject("meetingroom",JSONArray.parseArray(returnJson.getString("meetingroom_list"), MeetingRoom.class));
    }

    public List<MeetingRoom> getMeetingRoomListFromRedis(){
        List<MeetingRoom> roomList =  redisService.getCacheList("meetingroom");
        return roomList;
    }

    public Map<String,Date> transTime(String meetingTime) throws ParseException {
        Map<String,Date> timeMap = new HashMap<>();
        String[] times = meetingTime.split(" ");
        String day = times[0];
        String[] hours = times[2].split("-");
        String startHour = hours[0];
        String endHour = hours[1];
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date day1 = sdf.parse(day);
        day1.setYear(new Date().getYear());
        String dayStr = sdf1.format(day1);

        Date startDate = sdf2.parse(dayStr +" "+ startHour);
        Date endDate = sdf2.parse(dayStr +" "+ endHour);
        System.out.println("startDate:"+sdf2.format(startDate));
        System.out.println("endDate:"+sdf2.format(endDate));
        timeMap.put("startDate",startDate);
        timeMap.put("endDate",endDate);
        return timeMap;
    }

    public void genMeetingBookInfo() throws Exception {

        // 1、获取审批token
        String tokrn = this.getApprovelToken();
        //2、获取 审批信息,查询当天到 后七天的审批数据
        String spStr = this.getSpNoList(tokrn);
        JSONObject spJson = JSONObject.parseObject(spStr);
        if("0".equals(spJson.getString("errcode"))){
            JSONArray spArr =  spJson.getJSONArray("sp_no_list");
            log.info("3、当前时间段的流程，共："+spArr.size());
            //已入库且审核通过的，不用再查
            for(int i=0;i<spArr.size();i++){
                String spNo = spArr.getString(i);
                if(meetingBookInfoMapper.getSpInfoBySpNoAndSpStatus(spNo) == 0){
                    log.info("4、流程号："+spNo);
                    //不是已通过，获取详细信息
                    this.getSpDetial(spNo,tokrn);
                };
            }
        }else{
            commSmsHelper.sendSms(adminPhone,"","获取审批单号出错："+spJson.toString());
            commSmsHelper.sendSms(adminPhone_other,"","获取审批单号出错："+spJson.toString());
        }


        //test
        //this.getSpDetial("202203290004",tokrn);
        //查询未通过的（去除已驳回，已撤销） 数据 ，重新查询
        List<MeetingBookInfo> meetingBookInfoUnPass_List = meetingBookInfoMapper.getUnPassList();
        for(MeetingBookInfo meetingBookInfo:meetingBookInfoUnPass_List){
            this.getSpDetial(meetingBookInfo.getSp_no(),tokrn);
        }

        //获取 会议室状态，如果预定成功后取消，更新会议室状态
        this.handleMeetRoomStatus();


    }

   /* public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //获取前5分钟到后5分钟的数据
        calendar.add(Calendar.MINUTE,-50);
        *//*calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);*//*
        String starttime = Long.toString(calendar.getTimeInMillis()/1000L);
        calendar.add(Calendar.MINUTE,100);
        String endttime = Long.toString(calendar.getTimeInMillis()/1000L);

        System.out.println(starttime);
        System.out.println(endttime);
    }*/

    public void handleMeetRoomStatus() throws Exception {
        //1、获取会议室列表，获取会议室ID
        log.info("开始处理已删除的会议室信息  start");
        String meetRoomToken = this.getMeetRoom_token();
        List<MeetingRoom> meetingRoomList =  this.getMeetingRoomListFromRedis();
        MeetingBookInfo meetingBookInfoParam =  new MeetingBookInfo();
        meetingBookInfoParam.setSp_status("2");
        //获取 已经审核通过且没过期的会议室预定信息
        List<MeetingBookInfo> meetingBookInfoList = this.showInfo(meetingBookInfoParam);
        //循环每一个 会议室审批信息 处理当前的审批状态
        for(MeetingBookInfo meetingBookInfo:meetingBookInfoList){
            log.info("获取生效的会议室预定，共："+meetingBookInfoList.size()+"条。");
            String meetRoomId = "";
            for(MeetingRoom meetingRoom: meetingRoomList){
                if(meetingRoom.getName().equals(meetingBookInfo.getMeetingRoom_name())){
                    meetRoomId = meetingRoom.getMeetingroom_id();
                    break;
                }
            }

            if(!"".equals(meetRoomId)){
                log.info("获取的meetroomId:"+meetRoomId+"，名称："+meetingBookInfo.getMeetingRoom_name());
                JSONObject param = new JSONObject();
                String start = Long.toString(meetingBookInfo.getMeeting_startTm().getTime()/1000L);
                String end = Long.toString(meetingBookInfo.getMeeting_endTm().getTime()/1000L);
                param.put("meetingroom_id" , meetRoomId);
                param.put("start_time",start);
                param.put("end_time",end);
                String meetBookInfoRes = HttpUtils.doMeetingPost(bookUrl+meetRoomToken,param.toString());
                JSONObject meetBookJS = JSONObject.parseObject(meetBookInfoRes);
                log.info("会议室预定信息："+meetBookInfoRes);
                JSONArray scheArr = meetBookJS.getJSONArray("booking_list").getJSONObject(0).getJSONArray("schedule");
                log.info("schedule数组长度："+scheArr.size());
                if(scheArr.size() >0){
                    String start_tm = scheArr.getJSONObject(0).getString("start_time");
                    String end_time = scheArr.getJSONObject(0).getString("end_time");
                    if(!start_tm.equals(start) || !end.equals(end_time)){
                        meetingBookInfo.setSp_status("7");
                        meetingBookInfoMapper.update(meetingBookInfo);
                    }else{
                        String status = scheArr.getJSONObject(0).getString("status");
                        log.info("会议室状态为："+status);
                        if("1".equals(status)){
                            meetingBookInfo.setSp_status("6");
                            meetingBookInfoMapper.update(meetingBookInfo);
                        }
                    }

                }
                if(scheArr.size() ==0){
                    meetingBookInfo.setSp_status("7");
                    meetingBookInfoMapper.update(meetingBookInfo);
                }
            }

        }




        log.info("开始处理已删除的会议室信息  end");
    }

    @Override
    public List<MeetingBookInfo> showInfo(MeetingBookInfo meetingBookInfo) {
        return meetingBookInfoMapper.showInfo(meetingBookInfo);
    }

    /**
     * 获取审批详情，并入库
     * @param spNo
     * @param token
     * @throws Exception
     */
    public void getSpDetial(String spNo,String token) throws Exception {
        log.info("5、流程号："+spNo+",获取详细信息 开始");
        MeetingBookInfo meetingBookInfo = null;
        JSONObject sendStr = new JSONObject();
        sendStr.put("sp_no",spNo);
        //"https://qyapi.weixin.qq.com/cgi-bin/oa/getapprovaldetail?access_token="
        String returnStr = HttpUtils.doMeetingPost(spDetialUrl+token,sendStr.toString());
        JSONObject returnJson = JSONObject.parseObject(returnStr);
        if("0".equals(returnJson.getString("errcode"))){
            log.info("(1)、流程号："+spNo+",获取详细信息  成功");
            JSONObject info = returnJson.getJSONObject("info");
            meetingBookInfo = meetingBookInfoMapper.getSpInfoBySpNo(info.getString("sp_no"));
            if(meetingBookInfo !=null){
                log.info("(2)、流程号："+spNo+",已存在，更新状态");
                meetingBookInfo.setSp_status(info.getString("sp_status"));
                meetingBookInfoMapper.update(meetingBookInfo);
                if("2".equals(meetingBookInfo.getSp_status())){
                    String message = "";
                    if(meetingBookInfo.getApplyer_Name() ==null || "".equals(meetingBookInfo.getApplyer_Name())){
                        message =meetingBookInfo.getApplyer_id()
                                +"预定"+meetingBookInfo.getMeetingRoom_name()+",会议时间："+meetingBookInfo.getMeet_Time()+"会议用品："+meetingBookInfo.getMeeting_use();
                    }else{
                        message =meetingBookInfo.getDept_name()+","+meetingBookInfo.getApplyer_Name()
                                +"预定"+meetingBookInfo.getMeetingRoom_name()+",会议时间："+meetingBookInfo.getMeet_Time()+"会议用品："+meetingBookInfo.getMeeting_use();
                    }
                    commSmsHelper.sendSms(wuyePhone,"",message);
                    commSmsHelper.sendSms(wuyePhone_other,"",message);
                    log.info("(4)、流程号："+spNo+",短信发送成功");
                    System.out.println("*********************************发送短信："+message);
                }

            }else{
                log.info("(2)、流程号："+spNo+",新增："+info);
                meetingBookInfo = new MeetingBookInfo();
                JSONObject apply_data = info.getJSONObject("apply_data");
                JSONArray contents = apply_data.getJSONArray("contents");
                String meetingroom_name = "";
                String meeting_date = "";
                String meeting_use = "无";
                for(int i=0;i<contents.size();i++){
                    JSONObject item = contents.getJSONObject(i);
                    //会议室名称
                    if("Selector-meetingroomid".equals(item.getString("inner_id"))){
                        JSONArray options = item.getJSONObject("value").getJSONObject("selector").getJSONArray("options");
                        for(int j=0;j<options.size();j++){
                            meetingroom_name = options.getJSONObject(j).getJSONArray("value").getJSONObject(0).getString("text");
                        }
                    }
                    //会议时间
                    if("Text-bookmeetingdate".equals(item.getString("inner_id"))){
                        meeting_date = item.getJSONObject("value").getString("text");
                    }
                    if("会议用品".equals(item.getJSONArray("title").getJSONObject(0).getString("text"))){
                        meeting_use = item.getJSONObject("value").getString("text");
                    }
                }
                String applyerId = info.getJSONObject("applyer").getString("userid");
                meetingBookInfo.setApplyer_id(applyerId);
                //修改获取员工姓名及部门 20200511 start
                Map<String,String> userMap = this.getUserInfo(applyerId);
                meetingBookInfo.setApplyer_Name(userMap.get("userName"));
                meetingBookInfo.setDept_name(userMap.get("deptName"));
                /*Person person = personMapper.getPersonByPersonId(applyerId);
                if(person == null){
                    // 发短信维护员工信息
                    String message = applyerId +"员工工号未获取到员工姓名";
                    commSmsHelper.sendSms(adminPhone,"",message);
                    commSmsHelper.sendSms(adminPhone_other,"",message);
                }else{
                    meetingBookInfo.setApplyer_Name(person.getPerson_name());
                    meetingBookInfo.setDept_name(person.getDept_name());
                }*/
                meetingBookInfo.setMeetingRoom_name(meetingroom_name);
                meetingBookInfo.setMeet_Time(meeting_date);
                //会议 开始时间及结束时间
                Map<String,Date> timeMap = this.transTime(meeting_date);
                meetingBookInfo.setMeeting_startTm(timeMap.get("startDate"));
                meetingBookInfo.setMeeting_endTm(timeMap.get("endDate"));

                meetingBookInfo.setMeeting_use(meeting_use);
                meetingBookInfo.setSp_no(info.getString("sp_no"));
                meetingBookInfo.setSp_status(info.getString("sp_status"));
                meetingBookInfoMapper.save(meetingBookInfo);
                log.info("(3)、流程号："+spNo+",新增  ，数据库存储 成功");
                // 审核通过  给物业发短信
                if("2".equals(meetingBookInfo.getSp_status())){
                    //String message =meetingBookInfo.getDept_name()+","+meetingBookInfo.getApplyer_Name() +"预定"+meetingroom_name+",会议用品为："+meeting_use;
                    String message = "";
                    if(meetingBookInfo.getApplyer_Name() ==null || "".equals(meetingBookInfo.getApplyer_Name())){
                        message =meetingBookInfo.getApplyer_id()
                                +"预定"+meetingBookInfo.getMeetingRoom_name()+",会议时间："+meetingBookInfo.getMeet_Time()+"会议用品："+meetingBookInfo.getMeeting_use();
                    }else{
                        message =meetingBookInfo.getDept_name()+","+meetingBookInfo.getApplyer_Name()
                                +"预定"+meetingBookInfo.getMeetingRoom_name()+",会议时间："+meetingBookInfo.getMeet_Time()+"会议用品："+meetingBookInfo.getMeeting_use();
                    }
                    commSmsHelper.sendSms(wuyePhone,"",message);
                    commSmsHelper.sendSms(wuyePhone_other,"",message);
                    log.info("(4)、流程号："+spNo+",短信发送成功");
                    System.out.println("*********************************发送短信："+message);
                }

            }
        }
    }

    /**
     * 获取审批流token
     */
   /* private static String approvelTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    private static String approvelpram = "corpid=ww5049b9ddc915fa48&corpsecret=joSQUTEXKLBaqP61SlNyh5SYDWwzE0cS-nCXLHn1l2g";*/
    public String getApprovelToken(){
        log.info("1、获取token");
        //获取审批token，如果过期，重新获取
        if(redisService.getCacheObject("approvelToken") ==null || "".equals(redisService.getCacheObject("approvelToken"))){
            String approvelTokenStr = HttpUtils.sendGet(approvelTokenUrl,approvelpram);
            JSONObject approvelTokenJson = JSONObject.parseObject(approvelTokenStr);
            if("0".equals(approvelTokenJson.getString("errcode"))){
                redisService.setCacheObject("approvelToken",approvelTokenJson.getString("access_token"),approvelTokenJson.getLong("expires_in"), TimeUnit.SECONDS);
            }
        };
        return redisService.getCacheObject("approvelToken");
    }

    /**
     *获取时间段内的流程信息
     */
    public String getSpNoList(String sp_token) throws Exception {
        log.info("2、获取当前时间段的流程信息");
        Calendar calendar = Calendar.getInstance();
        //获取前5分钟到后5分钟的数据
        calendar.add(Calendar.MINUTE,-5);
        /*calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);*/
        String starttime = Long.toString(calendar.getTimeInMillis()/1000L);
        calendar.add(Calendar.MINUTE,10);
        String endttime = Long.toString(calendar.getTimeInMillis()/1000L);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("starttime",starttime);
        jsonObject.put("endtime",endttime);
        jsonObject.put("cursor",0);
        jsonObject.put("size",100);
        JSONObject filters = new JSONObject();
        filters.put("key","record_type");
        filters.put("value","7");
        JSONArray filtersArray = new JSONArray();
        filtersArray.add(filters);
        jsonObject.put("filters",filtersArray);
        System.out.println("json:"+jsonObject.toString());
        String url = spNoUrl+sp_token;
        //"https://qyapi.weixin.qq.com/cgi-bin/oa/getapprovalinfo?access_token="
        String returnStr = HttpUtils.doMeetingPost(url,jsonObject.toString());

        return returnStr;
    }

    public List<Map<String,String>> statisticsTable(StatisticsParam statisticsParam){
        return meetingBookInfoMapper.statisticsTable(statisticsParam);
    }

    public Map statisticsPic(StatisticsParam statisticsParam){
        Map reMap =  new HashMap();
        List<Map<String,String>>  maplist =  meetingBookInfoMapper.statisticsTable(statisticsParam);
        List xAxis = new ArrayList();
        List yAxis = new ArrayList();
        Map pieMap =  new HashMap();
        JSONArray jsonArray = new JSONArray();
        for(Map map: maplist){
            xAxis.add(map.get("ROOMNAME"));
            yAxis.add(map.get("TIMES"));

            JSONObject json = new JSONObject();
            json.put("name",map.get("ROOMNAME"));
            json.put("value",map.get("TIMES"));
            jsonArray.add(json);
        }
        reMap.put("xAxis", xAxis);
        reMap.put("yAxis", yAxis);
        reMap.put("pieMap", jsonArray);
        return reMap;
    }
    public Map getUserInfo(String userId){
        Map<String,String> userMap = new HashMap<>();
        try{
            String token = getUserToken();
            //获取员工详细信息
            String param = "access_token="+token+"&userid="+userId;
            String userInfoReturn = HttpUtils.sendGet(userUrl,param);
            JSONObject userInfoJSON = JSON.parseObject(userInfoReturn);
            if(!"".equals(userInfoReturn) &&"0".equals(userInfoJSON.getString("errcode"))){
                userMap.put("userName",userInfoJSON.getString("name"));
                String  userDeptId = userInfoJSON.getJSONArray("department").getString(0);
                //获取部门信息
                String deptReturn = HttpUtils.sendGet(userDeptUrl,"access_token="+token+"&id="+userDeptId);
                if("0".equals(JSONObject.parseObject(deptReturn).getString("errcode"))){
                    String deptName = JSONObject.parseObject(deptReturn).getJSONObject("department").getString("name");
                    userMap.put("deptName",deptName);
                }
            }else{
                Person person = personMapper.getPersonByPersonId(userId);
                if(person == null){
                    // 发短信维护员工信息
                    String message = userId +"员工工号未获取到员工姓名";
                    commSmsHelper.sendSms(adminPhone,"",message);
                    commSmsHelper.sendSms(adminPhone_other,"",message);
                }else{
                    userMap.put("userName",person.getPerson_name());
                    userMap.put("deptName",person.getDept_name());
                }
            }
        }catch (Exception e){
            log.error("通过接口获取 员工姓名及部门名称 出错：");
            e.printStackTrace();
        }

        return userMap;
    }
    public String getUserToken(){
        log.info("1、获取user  token");
        //获取审批token，如果过期，重新获取
        if(redisService.getCacheObject("userToken") ==null || "".equals(redisService.getCacheObject("userToken"))){
            String approvelTokenStr = HttpUtils.sendGet(userTokenUrl,userParam);
            JSONObject approvelTokenJson = JSONObject.parseObject(approvelTokenStr);
            if("0".equals(approvelTokenJson.getString("errcode"))){
                redisService.setCacheObject("userToken",approvelTokenJson.getString("access_token"),approvelTokenJson.getLong("expires_in"), TimeUnit.SECONDS);
            }
        };
        return redisService.getCacheObject("userToken");
    }

    //全量同步部门及员工信息
    public void synchronousDeptAndUser(){
        personMapper.deleteAll();
        String token = getUserToken();
        String deptUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/list";
        String allDept = HttpUtils.sendGet(deptUrl,"access_token="+token);
        System.out.println(allDept);
        JSONObject allDeptJson = JSON.parseObject(allDept);
        JSONArray deptArr = allDeptJson.getJSONArray("department");
        JSONObject dept = null;
        String userUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";
        String param = "access_token="+token+"&department_id=";
        Person person = null;
        for(int i=0;i<deptArr.size();i++){
            dept = deptArr.getJSONObject(i);
            Object id = dept.get("id");
            Object name = dept.get("name");
            String userDetial = HttpUtils.sendGet(userUrl,param+id);
            JSONObject userJSON = JSON.parseObject(userDetial);
            JSONArray userArr = userJSON.getJSONArray("userlist");
            for(int j=0;j<userArr.size();j++){
                JSONObject user =  userArr.getJSONObject(j);
                person = new Person();
                person.setDept_id(id.toString());
                person.setDept_name(name.toString());
                person.setPerson_id(user.getString("userid"));
                person.setPerson_name(user.getString("name"));
                personMapper.save(person);
            }
        }
    }

}
