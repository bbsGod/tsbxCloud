package com.tsvhlpom.dailywork.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.security.utils.DictUtils;
import com.tsvhlpom.dailywork.domain.Daily_worklog;
import com.tsvhlpom.dailywork.domain.LogAnalysis;
import com.tsvhlpom.dailywork.mapper.Daily_worklogMapper;
import com.tsvhlpom.dailywork.service.Daily_worklogService;
import com.tsvhlpom.system.api.domain.SysDictData;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Service
@Slf4j
public class Daily_worklogServiceimpl implements Daily_worklogService {
    @Autowired
    private Daily_worklogMapper worklogMapper;


    @Override
    public List<Daily_worklog> getWorkLogList(Daily_worklog worklog) {
        return worklogMapper.getWorkLogList(worklog);
    }

    @Override
    public Daily_worklog getWorkLog(String pkid) {
        return worklogMapper.getWorkLog(pkid);
    }

    @Override
    public void updateWorkLog(Daily_worklog worklog) {
        worklogMapper.updateWorkLog(worklog);
    }

    @Override
    public void saveWorkLog(Daily_worklog worklog) {
        worklogMapper.saveWorkLog(worklog);
    }

    @Override
    public void deleteWorkLog(String[] pkids) {
        worklogMapper.deleteWorkLog(pkids);
    }

    @Override
    public void updateWorkLogPath(String pkid, String url) {
        worklogMapper.updateWorkLogPath(pkid,url);
    }

    @Override
    public List<LogAnalysis> logAnalysis(LogAnalysis logAnalysis) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "";
        String endDate = "";
        if(logAnalysis.getStartDate() !=null ){
            startDate = sdf.format(logAnalysis.getStartDate());
            endDate = sdf.format(logAnalysis.getEndDate());
        }
        List<LogAnalysis> logAnalysisList
                = worklogMapper.getLogAnalysisList(logAnalysis.getEmp_team(),startDate,endDate);
        return logAnalysisList;
    }

    public AjaxResult exportWorkLog(LogAnalysis logAnalysis, HttpServletResponse response) throws Exception {
        List<LogAnalysis> workLogList =  this.logAnalysis(logAnalysis);
        log.info("获取导出数据，共："+workLogList.size()+"条");
        log.info("组装excel  start");
        String fileName = "";

        //处理码表 start
        List<SysDictData> teamList = DictUtils.getDictCache("sys_dailywork_empteam");
        Map<String,String> teamMap = new HashMap<>();
        for(SysDictData dictData:teamList){
            teamMap.put(dictData.getDictValue(),dictData.getDictLabel());
        }
        Map<String,String> workTypeMap_1 = new HashMap<>();
        List<SysDictData> workTypeList_1 = DictUtils.getDictCache("sys_dailywork_worktype_1");
        for(SysDictData dictData:workTypeList_1){
            workTypeMap_1.put(dictData.getDictValue(),dictData.getDictLabel());
        }
        Map<String,String> workTypeMap_2 = new HashMap<>();
        List<SysDictData> workTypeList_2 = DictUtils.getDictCache("sys_dailywork_worktype_2");
        for(SysDictData dictData:workTypeList_2){
            workTypeMap_2.put(dictData.getDictValue(),dictData.getDictLabel());
        }
        //处理码表 end


        ClassPathResource cpr = new ClassPathResource("/template/template.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(cpr.getInputStream());
        log.info("获取wb。。success");

        OutputStream out = response.getOutputStream();
        try{
            Sheet sheet = wb.getSheetAt(0);
            sheet.setVerticallyCenter(true);
            sheet.setHorizontallyCenter(true);
            int startRow = 2;
            int teamCount = 2;
            int timeCount = 2;
            int nameCount = 2;
            for(int i=0;i<workLogList.size();i++){
                LogAnalysis log = workLogList.get(i);
                Row row = sheet.createRow(startRow+i);
                //项目组
                Cell cell0 = row.createCell(0);
                cell0.setCellValue(teamMap.get(log.getEmp_team()));
                //时间
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(log.getCreate_time());
                //员工姓名
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(log.getEmp_name());
                //类型
                Cell cell3 = row.createCell(3);
                if("0".equals(log.getTeam_type())){
                    cell3.setCellValue(workTypeMap_1.get(log.getWork_type()));
                }else{
                    cell3.setCellValue(workTypeMap_2.get(log.getWork_type()));
                }
                //进度
                Cell cell4  = row.createCell(4);
                cell4.setCellValue(log.getWork_progress());
                //日志
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(log.getLog_info());


                //合并单元格
                if(i>0){
                    //第一列
                    if(!workLogList.get(i).getEmp_team().equals(workLogList.get(i-1).getEmp_team())){
                        if(teamCount == startRow+i-1){}
                        else{
                            sheet.addMergedRegion(new CellRangeAddress(teamCount,startRow+i-1,0,0));
                        }
                        teamCount = startRow+i;
                    }else if(i==workLogList.size()-1){
                        if(teamCount != startRow+i){
                            sheet.addMergedRegion(new CellRangeAddress(teamCount,startRow+i,0,0));
                        }
                    }
                    //第二例
                    if(!workLogList.get(i).getCreate_time().equals(workLogList.get(i-1).getCreate_time())){
                        if(timeCount == startRow+i-1){}
                        else{
                            sheet.addMergedRegion(new CellRangeAddress(timeCount,startRow+i-1,1,1));
                        }
                        timeCount = startRow+i;
                    }else {
                        if(!workLogList.get(i).getEmp_team().equals(workLogList.get(i-1).getEmp_team())){
                            if(timeCount == startRow+i-1){}
                            else{
                                sheet.addMergedRegion(new CellRangeAddress(timeCount,startRow+i-1,1,1));
                            }
                            timeCount = startRow+i;
                        }
                    }
                    if(i==workLogList.size()-1){
                        if(timeCount !=startRow+i){
                            sheet.addMergedRegion(new CellRangeAddress(timeCount,startRow+i,1,1));
                        }
                    }
                    //第三列
                    if(!workLogList.get(i).getEmp_name().equals(workLogList.get(i-1).getEmp_name())){
                        if(nameCount == startRow+i-1){}
                        else{
                            sheet.addMergedRegion(new CellRangeAddress(nameCount,startRow+i-1,2,2));
                        }
                        nameCount = startRow+i;
                    }
                    //如果姓名与上一行一致，但是时间不一致，应该和时间一样，合并姓名
                    else {
                        if(!workLogList.get(i).getCreate_time().equals(workLogList.get(i-1).getCreate_time())){
                            if(nameCount == startRow+i-1){}
                            else{
                                sheet.addMergedRegion(new CellRangeAddress(nameCount,startRow+i-1,2,2));
                            }
                            nameCount = startRow+i;
                        }
                    }
                    if(i==workLogList.size()-1){//如果是最后一行
                        if(nameCount != startRow+i){
                            sheet.addMergedRegion(new CellRangeAddress(nameCount,startRow+i,2,2));
                        }
                    }

                }
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");

            wb.write(out);

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("导出错误");
        }finally {
            if (wb != null)
            {
                try
                {
                    wb.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }

        log.info("组装excel  end");
        return null;
    }

}
