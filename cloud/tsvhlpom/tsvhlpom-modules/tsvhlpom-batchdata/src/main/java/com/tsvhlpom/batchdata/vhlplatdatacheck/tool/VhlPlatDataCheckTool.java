package com.tsvhlpom.batchdata.vhlplatdatacheck.tool;

import com.tsvhlpom.batchdata.vhlplatdatacheck.constants.PlateConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 平台对账相关方法
 *
 * @Author Xinglong Lei
 * @Date 2020/7/6
 */

@Slf4j
@Service
public class VhlPlatDataCheckTool {

    @Autowired
    private QueryData queryData;

    @Autowired
    private VerifyData verifyData;

    @Autowired
    private ZipCompressService zipCompressService;

    @Autowired
    private CommTools commTools;

    public void VPDCGetData(String month) throws Exception {
        Calendar cal = DateToCalendar(month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date endDate = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 0);
        Date xmlDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String xmlDateStr = sdf.format(xmlDate);
        // 循环机构
        for(String areaCode : PlateConstants.AREACODE) {
            //循环产品
            for(String prodNo: PlateConstants.PRODARR){
                queryData.queryDateToZip(startDate, endDate, areaCode, prodNo, month, xmlDateStr);
                verifyData.verifyDataToZip(startDate, endDate, areaCode, prodNo, month, xmlDateStr);
            }
        }
        log.info("文件生成完毕");
        zipCompressService.compress(commTools.getPath(month), commTools.filePath + File.separator + month+".zip");
        log.info("文件压缩完毕");
    }

    /**
     * 日期字符串转日历
     * @param month  yyyy-MM
     * @return
     * @throws Exception
     */
    private Calendar DateToCalendar(String month) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
