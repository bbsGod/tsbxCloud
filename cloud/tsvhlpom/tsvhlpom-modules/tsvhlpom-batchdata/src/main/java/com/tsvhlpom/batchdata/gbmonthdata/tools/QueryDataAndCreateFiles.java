package com.tsvhlpom.batchdata.gbmonthdata.tools;
import com.tsvhlpom.batchdata.gbmonthdata.mapper.GbMonthDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 查询数据并且生成csv 错误日志，压缩包
 */
@Service
@Slf4j
public class QueryDataAndCreateFiles {

    @Autowired
    private GbMonthDataMapper gbMonthDataMapper;
    @Autowired
    private CheckGbMonthData checkGbMonthData;

    @Autowired
    private CreateCSV createCSV;

    @Value("${GBFilePath}")
    private String filePath;

    private SimpleDateFormat logSDF = new SimpleDateFormat("yyyy-MM-dd");



    /**
     * 导出csv文件主方法，因为牵扯文件读写， 且调用频率不会特别高 所以直接 加上了同步锁。  最合理的解决方案是 month相同不允许执行 month 不同可以执行
     * @param month  要处理的数据月份年-月
     * @throws Exception 异常
     */
    public Boolean execute(String month) throws Exception {


        Boolean errFlag =false;

        //判断你是否要写csv的 header
        Boolean policyHeaderFlag =  true;
        Boolean policyDutyHeaderFlag =  true;
        Boolean jqPayCostHeaderFlag =  true;
        Boolean pureRiskPremiumCHeaderFlag =  true;
        Boolean addServiceFlag = true;
        Boolean chdTruckVhlFlag = true;
        Boolean chdPrivateVhlFlag = true;
        Boolean chdGjDivisorFlag = true;
        Boolean chdGsDivisorFlag = true;
        Boolean chdBuggyVhlFlag = true;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date startDate = simpleDateFormat.parse(month);
        //获取止期， 也就是下个月的第一天。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, 1);
        Date endDate = calendar.getTime();
        String path = getDPath(month);
        calendar.setTime(startDate);
        createCSV.checkFils(path);
        while(calendar.getTime().before(endDate)) {

            Date startDataDate = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            Date endDataDate = calendar.getTime();
            createPolicyCsv(startDataDate, endDataDate,path, policyHeaderFlag, errFlag);
            createPolicyDutyCsv(startDataDate, endDataDate, path, policyDutyHeaderFlag, errFlag);
            createJqPayCostCsv(startDataDate, endDataDate, path, jqPayCostHeaderFlag, errFlag);
            createPureRiskPremiumCsv(startDataDate, endDataDate, path, pureRiskPremiumCHeaderFlag, errFlag);
            creatAddServiceCsv(startDataDate, endDataDate, path, addServiceFlag);
            creatChdTruckVhlCsv(startDataDate, endDataDate, path, chdTruckVhlFlag);
            creatChdPrivateVhlCsv(startDataDate, endDataDate, path, chdPrivateVhlFlag);
            creatChdGjDivisorCsv(startDataDate, endDataDate, path, chdGjDivisorFlag);
            creatChdGsDivisorCsv(startDataDate, endDataDate, path, chdGsDivisorFlag);
            creatChdBuggyVhlCsv(startDataDate, endDataDate, path, chdBuggyVhlFlag);
            //TODO  事务结束
        }

        //生成ZIP包
        createCSV.compressedFile(path);
        return errFlag;
    }



    /**
     * 处理policyCSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void createPolicyCsv(Date startDate, Date endDate, String path, Boolean policyHeaderFlag, Boolean errFlag) throws Exception {
        log.info( logSDF.format(startDate) + "policy光博数据处理中");
        List<Map<String, Object>> dataArray = gbMonthDataMapper.queryPolicy(startDate, endDate) ;
        List<Map<String, Object>> dataList = new LinkedList<>(dataArray);
        List errList = checkGbMonthData.checkPolicyData(dataList);
        checkErrList(errList, errFlag);
        String policyFileName = "policy";
        if(dataList!=null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, policyFileName, policyHeaderFlag);
            policyHeaderFlag = false;
        }
        createCSV.createErrorTxt(errList, path);
        log.info( logSDF.format(startDate) + "policy光博数据处理完毕");
    }
    /**
     * 处理policyCSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void createPolicyDutyCsv(Date startDate, Date endDate, String path, Boolean policyDutyHeaderFlag, Boolean errFlag) throws Exception {
        log.info( logSDF.format(startDate) + "PolicyDuty光博数据处理中");
        List<Map<String, Object>> dataArray = gbMonthDataMapper.queryPolicyDuty(startDate, endDate) ;
        List<Map<String, Object>> dataList = new LinkedList<>(dataArray);
        List errList = checkGbMonthData.checkPolicyDutyData(dataList, startDate, endDate);
        checkErrList(errList, errFlag);
        String policyDutyFileName = "policy_duty";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, policyDutyFileName, policyDutyHeaderFlag);
            policyDutyHeaderFlag = false;
        }
        createCSV.createErrorTxt(errList, path);
        log.info( logSDF.format(startDate) + "PolicyDuty光博数据处理完毕");
    }
    /**
     * 处理交强险赔付成本CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void createJqPayCostCsv(Date startDate, Date endDate, String path, Boolean jqPayCostHeaderFlag, Boolean errFlag) throws Exception {
        log.info( logSDF.format(startDate) + "交强险赔付成本光博数据处理中");
        List<Map<String, Object>> dataArray = gbMonthDataMapper.queryJqPayCost(startDate, endDate) ;
        List<Map<String, Object>> dataList = new LinkedList<>(dataArray);
        List errList = checkGbMonthData.checkJqPayCostData(dataList);
        checkErrList(errList, errFlag);
        String jqPayCostFileName = "交强险赔付成本";
        if(dataList != null && dataList.size() > 0 ) {
            createCSV.createDataGBListExcel(dataList, path, jqPayCostFileName, jqPayCostHeaderFlag);
            jqPayCostHeaderFlag = false;
        }
        createCSV.createErrorTxt(errList, path);
        log.info( logSDF.format(startDate) + "交强险赔付成本光博数据处理完毕");
    }
    /**
     * 处理车损险纯风险保费CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void createPureRiskPremiumCsv(Date startDate, Date endDate, String path, Boolean pureRiskPremiumCHeaderFlag, Boolean errFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车损险纯风险保费光博数据处理中");
        List<Map<String, Object>> dataArray = gbMonthDataMapper.queryPureRiskPremium(startDate, endDate) ;
        List<Map<String, Object>> dataList = new LinkedList<>(dataArray);
        List errList = checkGbMonthData.checkPureRiskPremiumData(dataList);
        checkErrList(errList, errFlag);
        String pureRiskPremiumFileName = "车损险纯风险保费";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, pureRiskPremiumCHeaderFlag);
            pureRiskPremiumCHeaderFlag = false;
        }
        createCSV.createErrorTxt(errList, path);
        log.info( logSDF.format(startDate) + "车损险纯风险保费光博数据处理完毕");
    }

    /**
     * 处理增值服务CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatAddServiceCsv(Date startDate, Date endDate, String path, Boolean addServiceFlag) throws Exception {
        log.info( logSDF.format(startDate) + "增值服务光博数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryAddService(startDate, endDate) ;
        String pureRiskPremiumFileName = "增值服务";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, addServiceFlag);
            addServiceFlag = false;
        }
        log.info( logSDF.format(startDate) + "增值服务光博数据处理完毕");
    }

    /**
     * 处理车慧达货车数据CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatChdTruckVhlCsv(Date startDate, Date endDate, String path, Boolean chdTruckVhlFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车慧达货车数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryChdTruckVhl(startDate, endDate) ;
        String pureRiskPremiumFileName = "车慧达货车数据";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, chdTruckVhlFlag);
            chdTruckVhlFlag = false;
        }
        log.info( logSDF.format(startDate) + "车慧达货车数据处理完毕");
    }

    /**
     * 处理车慧达私家车数据CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatChdPrivateVhlCsv(Date startDate, Date endDate, String path, Boolean chdPrivateVhlFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车慧达私家车数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryChdPrivateVhl(startDate, endDate) ;
        String pureRiskPremiumFileName = "车慧达私家车数据";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, chdPrivateVhlFlag);
            chdPrivateVhlFlag = false;
        }
        log.info( logSDF.format(startDate) + "车慧达私家车数据处理完毕");
    }

    /**
     * 处理车慧达轨迹因子数据CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatChdGjDivisorCsv(Date startDate, Date endDate, String path, Boolean chdGjDivisorFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车慧达轨迹因子数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryChdGjDivisor(startDate, endDate) ;
        String pureRiskPremiumFileName = "车慧达轨迹因子";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, chdGjDivisorFlag);
            chdGjDivisorFlag = false;
        }
        log.info( logSDF.format(startDate) + "车慧达轨迹因子数据处理完毕");
    }

    /**
     * 处理车慧达高速因子数据CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatChdGsDivisorCsv(Date startDate, Date endDate, String path, Boolean chdGsDivisorFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车慧达高速因子数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryChdGsDivisor(startDate, endDate) ;
        String pureRiskPremiumFileName = "车慧达高速因子";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, chdGsDivisorFlag);
            chdGsDivisorFlag = false;
        }
        log.info( logSDF.format(startDate) + "车慧达高速因子数据处理完毕");
    }

    /**
     * 处理车慧达小货车数据CSV
     * @param startDate
     * @param endDate
     * @throws Exception
     */
    private void creatChdBuggyVhlCsv(Date startDate, Date endDate, String path, Boolean chdBuggyVhlFlag) throws Exception {
        log.info( logSDF.format(startDate) + "车慧达小货车数据处理中");
        List<Map<String, Object>> dataList = gbMonthDataMapper.queryChdBuggyVhl(startDate, endDate) ;
        String pureRiskPremiumFileName = "车慧达小货车数据";
        if(dataList != null && dataList.size() > 0) {
            createCSV.createDataGBListExcel(dataList, path, pureRiskPremiumFileName, chdBuggyVhlFlag);
            chdBuggyVhlFlag = false;
        }
        log.info( logSDF.format(startDate) + "车慧达小货车数据处理完毕");
    }



    /**
     * 如果有错误数据则进行标记
     * @param list 错误数据List
     */
    private void checkErrList(List list, Boolean errFlag) {
        if(list.size() > 0) {
            errFlag = true;
        }
    }


    /**
     * 获取文件夹的目录  目录 ：  配置的path+年+月
     * @param month
     * @return
     */
    public String getDPath(String month) {
        String[] strArr = month.split("-");
        return filePath + File.separator + strArr[0] + File.separator + strArr[1] + File.separator;
    }

}
