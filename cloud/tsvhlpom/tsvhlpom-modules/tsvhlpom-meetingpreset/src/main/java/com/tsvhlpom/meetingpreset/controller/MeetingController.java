package com.tsvhlpom.meetingpreset.controller;

import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.meetingpreset.domain.MeetingBookInfo;
import com.tsvhlpom.meetingpreset.domain.MeetingRoom;
import com.tsvhlpom.meetingpreset.domain.StatisticsParam;
import com.tsvhlpom.meetingpreset.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meetingBook")
public class MeetingController extends BaseController {
    @Autowired
    private MeetingService meetingService;


    @RequestMapping("/initMeetRoom")
    public AjaxResult getMeetingRoom(){
       String token =  meetingService.getMeetRoom_token();
        meetingService.getMeetingList(token);
        return AjaxResult.success();
    }

    @RequestMapping("/getMeetRoomList")
    public List<String> getMeetingRoomListFromRedis(){
        List<MeetingRoom> roomList =  meetingService.getMeetingRoomListFromRedis();
        List<String> nameList = new ArrayList<>();
        roomList.stream().forEach(meetingRoom -> {nameList.add(meetingRoom.getName());});
        return nameList;
    }

    @RequestMapping("/genMeetingBookInfo")
    public AjaxResult genMeetingBookInfo(){
        logger.info("定时任务 更新任务列表 start");
        try{
            meetingService.genMeetingBookInfo();
        }catch (Exception e){
            logger.error("定时任务 更新任务列表 start");
            e.printStackTrace();
            return AjaxResult.error();
        }
        logger.info("定时任务 更新任务列表 end");
        return AjaxResult.success();
    }

    @RequestMapping("/showInfo")
    public TableDataInfo showInfo(MeetingBookInfo meetingBookInfo){
        List<MeetingBookInfo> meetingBookInfoList = null;
        startPage();
        try{
            meetingBookInfoList = meetingService.showInfo(meetingBookInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return getDataTable(meetingBookInfoList);
    }

    /**
     * 获取使用次数列表
     * @param statisticsParam
     * @return
     */
    @RequestMapping("/statisticsTable")
    public AjaxResult statisticsTable(StatisticsParam statisticsParam){
        List<Map<String,String>> map = null;
        try{
            map = meetingService.statisticsTable(statisticsParam);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success(map);
    }

    /**
     * 获取饼图及柱状图数据
     * @param statisticsParam
     * @return
     */
    @RequestMapping("/statisticsPic")
    public Map statisticsPic(StatisticsParam statisticsParam){
        Map returnMap = null;
        try{
            returnMap = meetingService.statisticsPic(statisticsParam);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("获取统计信息出错");
        }
        return returnMap;
    }

    @RequestMapping("/synchronousDeptAndUser")
    public String synchronousDeptAndUser(){
        logger.info("start");
        meetingService.synchronousDeptAndUser();
        logger.info("end");
        return "结束";

    }
}
