package com.tsvhlpom.covid19.service.impl;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.utils.file.BASE64DecodedMultipartFile;
import com.tsvhlpom.covid19.domain.Covid;
import com.tsvhlpom.covid19.domain.DoneList;
import com.tsvhlpom.covid19.domain.Emplyee;
import com.tsvhlpom.covid19.mapper.CovidMapper;
import com.tsvhlpom.covid19.mapper.EmplyeeMapper;
import com.tsvhlpom.covid19.service.CovidService;
import com.tsvhlpom.system.api.RemoteFileService;
import com.tsvhlpom.system.api.domain.SysFile;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CovidServiceImpl implements CovidService {

    @Autowired
    private CovidMapper covidMapper;
    @Autowired
    private RemoteFileService remoteFileService;

    @Autowired
    private EmplyeeMapper emplyeeMapper;
    @Override
    public void save(Covid covid) throws Exception {
        //校验手机号及姓名是否在系统清单内
        List<Emplyee> emplyeeList = emplyeeMapper.checkEmp(covid.getC_name(),covid.getC_phone());
        if( StringUtils.isEmpty(emplyeeList)){
            throw new Exception("手机号及姓名不在系统清单内，请联系人力部门");
        }else{
            covid.setC_parent_dept(emplyeeList.get(0).getC_parent_dept());
            covid.setC_dept(emplyeeList.get(0).getC_dept());
            covid.setC_id_no(emplyeeList.get(0).getC_id_no());
        }
        //转换健康码
        if(StringUtils.isNotEmpty(covid.getC_health_code())){
            MultipartFile healthFile = BASE64DecodedMultipartFile.base64ToMultipart(covid.getC_health_code());
            R<SysFile> healthFileResult = remoteFileService.upload(healthFile);
            if (StringUtils.isNull(healthFileResult) || StringUtils.isNull(healthFileResult.getData()))
            {
                throw new Exception("上传健康码失败，请稍后上传");
            }
            covid.setC_health_img(healthFileResult.getData().getUrl());
        }

        //转换行程码
        if(StringUtils.isNotEmpty(covid.getC_tour_code())){
            MultipartFile tourFile = BASE64DecodedMultipartFile.base64ToMultipart(covid.getC_tour_code());
            R<SysFile> tourFileResult = remoteFileService.upload(tourFile);
            if (StringUtils.isNull(tourFileResult) || StringUtils.isNull(tourFileResult.getData()))
            {
                throw new Exception("上传行程吗失败，请稍后上传");
            }
            covid.setC_tour_img(tourFileResult.getData().getUrl());
        }
        //转换核酸报告
        if(StringUtils.isNotEmpty(covid.getC_test_code())){
            MultipartFile testFile = BASE64DecodedMultipartFile.base64ToMultipart(covid.getC_test_code());
            R<SysFile> testFileResult = remoteFileService.upload(testFile);
            if (StringUtils.isNull(testFileResult) || StringUtils.isNull(testFileResult.getData()))
            {
                throw new Exception("上传核酸检查报告失败，请稍后上传");
            }
            covid.setC_test_img(testFileResult.getData().getUrl());
        }

       // String testType =  covid.getC_test_code().split(";")[0];

        covidMapper.save(covid);
    }

    @Override
    public List<Covid> getCovidList(Covid covid) {
        return covidMapper.getCovidList(covid);
    }

    public void exportInfo(Covid covidParam, HttpServletResponse response) throws Exception {
        XSSFWorkbook wb = null;
        OutputStream out = null;
        try{
            Map<String,String> colorMap = new HashMap<>();
            colorMap.put("0","绿色");
            colorMap.put("1","黄色");
            colorMap.put("2","红色");
            colorMap.put("3","不带星");
            colorMap.put("4","带星");
            out = response.getOutputStream();
            List<Covid> covidList = getCovidList(covidParam);
            log.info("获取covid信息表，共："+covidList.size()+"条");
            ClassPathResource cpr = new ClassPathResource("/template/covid.xlsx");
            wb = new XSSFWorkbook(cpr.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);
            sheet.setVerticallyCenter(true);
            sheet.setHorizontallyCenter(true);
            XSSFCellStyle setBorder = wb.createCellStyle();
            Integer startRow = 2;
            Row row = null;
            for(int i=0;i<covidList.size();i++){
                Covid covid = covidList.get(i);
                row = sheet.createRow(i+startRow);
                row.createCell(0).setCellValue(i+1);//序号
                row.createCell(1).setCellValue(covid.getC_parent_dept());//总公司/分公司
                row.createCell(2).setCellValue(covid.getC_dept());//总部部门/分支机构
                row.createCell(3).setCellValue(covid.getC_name());//姓名
                row.createCell(4).setCellValue(covid.getC_id_no());//身份证号
                row.createCell(5).setCellValue(covid.getC_phone());//手机号
                row.createCell(6).setCellValue(colorMap.get(covid.getC_health_color()));//健康码颜色
                row.createCell(7).setCellValue(colorMap.get(covid.getC_tour_color()));//行程码颜色
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
    }


    public Map statistics(String c_parent_dept, String c_dept, String day) {
        Map reMap = new HashMap();
        Map pieMap =  new HashMap();
        List<Map> sumMap = covidMapper.getSumStatistics(c_parent_dept, c_dept, day);
        List<Map> sumExceptionMap = covidMapper.getSumExceptionStatistics(c_parent_dept, c_dept, day);
        List<Map> groupMap = covidMapper.getGroupStatistics(c_parent_dept, c_dept, day);
        List<Map> groupExceptionMap = covidMapper.getGroupExceptionStatistics(c_parent_dept, c_dept, day);
        List<Map> elesMap = covidMapper.geteleCounts(c_parent_dept, c_dept);

        //饼图拼装
        int eles = ((BigDecimal)elesMap.get(0).get("COUNTS")).intValue();
        int sumCount = ((BigDecimal)sumMap.get(0).get("COUNTS")).intValue();
        int sumExceptionCount = ((BigDecimal)sumExceptionMap.get(0).get("COUNTS")).intValue();
        int  i = eles - sumCount;

        pieMap.put("已登记正常人数", sumCount - sumExceptionCount);
        pieMap.put("已登记异常人数", sumExceptionCount);
        pieMap.put("未登记人数", i);

        reMap.put("pie", pieMap);

        List xAxis = new ArrayList();
        List yAxis = new ArrayList();
        List yAxis2 = new ArrayList();
        List yAxis3 = new ArrayList();
        reMap.put("sumCount", sumMap.get(0).get("COUNTS"));
        for(Map map : groupMap) {
            xAxis.add(map.get("DPT"));
            yAxis.add(((BigDecimal)map.get("COUNTS")).intValue() - ((BigDecimal)map.get("EXCEPTIONCOUNTS")).intValue());
            yAxis2.add(map.get("UNCOUNTS"));
            yAxis3.add(map.get("EXCEPTIONCOUNTS"));
        }
        reMap.put("xAxis", xAxis);
        reMap.put("yAxis", yAxis);
        reMap.put("yAxis2", yAxis2);
        reMap.put("yAxis3", yAxis3);
        return reMap;
    }

    @Override
    public List<DoneList> getDoneResult(String c_parent_dept, String c_dept, String day) {
        return  covidMapper.getDoneResult(c_parent_dept,c_dept,day);
    }

    @Override
    public List<String> getUndoneDetial(String c_parent_dept, String c_dept, String day) {
        return covidMapper.getUndoneDetial(c_parent_dept,c_dept,day);
    }

    @Override
    public List<Emplyee> getUnDoneResult(String c_parent_dept, String c_dept, String day) {
        return  emplyeeMapper.getUnDoneResult(c_parent_dept,c_dept,day);
    }

    @Override
    public String getName(String c_phone){
        return emplyeeMapper.getName(c_phone);
    }

}
