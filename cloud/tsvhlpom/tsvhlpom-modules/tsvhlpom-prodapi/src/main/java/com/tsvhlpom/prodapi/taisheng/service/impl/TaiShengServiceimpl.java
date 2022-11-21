package com.tsvhlpom.prodapi.taisheng.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.utils.http.HttpUtils;
import com.tsvhlpom.prodapi.taisheng.VO.EndorsementPolicy;
import com.tsvhlpom.prodapi.taisheng.VO.Policy;
import com.tsvhlpom.prodapi.taisheng.VO.WebTrdInterfLog;
import com.tsvhlpom.prodapi.taisheng.mapper.*;
import com.tsvhlpom.prodapi.taisheng.service.TaiShengService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class TaiShengServiceimpl implements TaiShengService {

    @Autowired
    private PolicyMapper policyMapper;

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private CostRatioMapper costRatioMapper;
    @Autowired
    private PolicyRiskMapper policyRiskMapper;
    @Autowired
    private EndorsementPolicyMapper endorsementPolicyMapper;

    @Autowired
    private WebTrdInterfLogMapper webTrdInterfLogMapper;
    @Value("${taisheng.url}")
    private String urlTaiSheng;
    @Value("${taisheng.client_id}")
    private String client_id;
    @Value("${taisheng.client_secret}")
    private String client_secret;

    public void pushPolicy(Date startDate,Date endDate,String appNo) throws Exception {
        log.info("。。。。。。。。。。推送保单数据开始 。。。。");
        log.info("1、获取保单数据");
        List<Policy>  policyList = this.getPolicyList(startDate,endDate,appNo);
        log.info("2、获取保单数据结束，共："+policyList.size()+"条");
        if(policyList != null && policyList.size() > 0){
            log.info("循环单条推送保单数据");
            for(Policy policy: policyList){
                this.sendHttps(JSONObject.toJSONString(policy),"policy",policy.getApplicationNo());
            }

        }else{
            log.info("3、泰盛保批单数据推送：无保单数据，不推送");
        }
        log.info("。。。。。。。。。。推送保单数据结束 。。。。");
    }
    public void pushEndor(Date startDate,Date endDate,String appNo) throws Exception {
        log.info("***************推送 批单 数据开始****************");
        log.info("一、获取批单数据");
        List<EndorsementPolicy> endorList = this.getEndorList(startDate,endDate,appNo);
        log.info("二、获取批单完成，共："+endorList.size()+"条");
        if(endorList !=null && endorList.size() > 0){
            for(EndorsementPolicy endorsementPolicy: endorList){
                log.info("循环单条推送批单数据");
                this.sendHttps(JSONObject.toJSONString(endorsementPolicy),"endor",endorsementPolicy.getApplicationNo());
            }
        }else{
            log.info("三、泰盛保批单数据推送：无批单数据，不推送");
        }
        log.info("***************推送 批单 数据结束****************");
    }
    /**
     * 推送保批单数据
     * @param startDate
     * @param endDate
     */
    public void pushPolicyAndEndor(Date startDate,Date endDate) throws Exception {
        this.pushPolicy(startDate,endDate,"");
        this.pushEndor(startDate,endDate,"");
    }
    /**
     * 获取推送数据
     */
    public List<Policy> getPolicyList(Date startDate, Date endDate,String appNo) {
       List<Policy> policyList =  policyMapper.getPolicy(startDate,endDate,appNo);
       for(Policy policy: policyList){
           Map deptMap = setTsDeptName(policy.getInsurerCode());
           policy.setInsurerCode(deptMap.get("TGTCDE").toString());
           policy.setInsurerName(deptMap.get("REMARK").toString());
           //log.info("设置投保人信息：plyNo = "+policy.getPolicyNo());
           policy.setApplicant(subjectMapper.getAppSubject(policy.getApplicationNo()));
           //log.info("设置被保人信息：plyNo = "+policy.getPolicyNo());
           policy.setInsured(subjectMapper.getInsSubject(policy.getApplicationNo()));
           //log.info("设置手续费信息：plyNo = "+policy.getPolicyNo());
           policy.setCostRatio(costRatioMapper.getCostRatio(policy.getApplicationNo()));
           log.info("设置险种明细");
           policy.setRisks(policyRiskMapper.getPolicyRiskList(policy.getApplicationNo()));
       }
        return policyList;
    }
    public Map<String,Object> setTsDeptName(String deptCode){
        Map deptMap = new HashMap();
        deptMap =  policyMapper.getDept_ts(deptCode);
        if(StringUtils.isEmpty(deptMap)){
            deptMap = this.setTsDeptName(policyMapper.getSnrDept(deptCode));
        }

        return deptMap;
    }
    /**
     * 获取批单数据
     * @param startDate
     * @param endDate
     * @return
     */
    public List<EndorsementPolicy> getEndorList(Date startDate, Date endDate,String appNo) {
        List<EndorsementPolicy> endorList = endorsementPolicyMapper.getEndorList(startDate,endDate,appNo);
        for(EndorsementPolicy endor: endorList){
            Map deptMap = setTsDeptName(endor.getInsurerCode());
            endor.setInsurerCode(deptMap.get("TGTCDE").toString());
            endor.setInsurerName(deptMap.get("REMARK").toString());
            //log.info("设置投保人信息：edrNo = "+endor.getBatchNum());
            endor.setApplicant(subjectMapper.getAppSubject(endor.getApplicationNo()));
            //log.info("设置被保人信息：edrNo = "+endor.getBatchNum());
            endor.setInsured(subjectMapper.getInsSubject(endor.getApplicationNo()));
            //log.info("设置手续费信息：edrNo = "+endor.getBatchNum());
            endor.setCostRatio(costRatioMapper.getCostRatio(endor.getApplicationNo()));
            log.info("设置险种明细");
            endor.setRisks(policyRiskMapper.getPolicyRiskList(endor.getApplicationNo()));
        }
        return endorList;
    }
    /**
     * 推送数据
     * @param
     * @throws Exception
     */
    public void sendHttps(String sendStr,String sendType,String appNo) throws Exception {
        log.info(sendType+"发送报文:"+sendStr);
        log.info("获取token");
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Long  expireIn = calendar.getTimeInMillis();
        Map<String,Object> tokenMap = policyMapper.getToken(expireIn);
        String token = "";
        if(tokenMap !=null){
            token = tokenMap.get("C_TOKEN").toString();
            expireIn = Long.valueOf(tokenMap.get("N_EXPIRE_IN").toString());
        }
        String returnStr = "";
        String access_token = "";
        String expires_in = "";
        //Calendar cal = Calendar.getInstance();
        //如果token未过期，不重新调用认证接口
        if(token ==null || "".equals(token)){
            log.info("token过期，重新认证");
            try{
                String param = "grant_type=client_credentials&scope=all&client_id="+client_id+"&client_secret="+client_secret;
                returnStr = HttpUtils.sendPost(urlTaiSheng+"/oauth/token",param);
                if(!"".equals(returnStr)){
                    JSONObject returnJson = JSONObject.parseObject(returnStr);
                    log.info("认证成功");
                    access_token = returnJson.getString("access_token");
                    expires_in = returnJson.getString("expires_in");
                    calendar.add(Calendar.SECOND,Integer.parseInt(expires_in));
                    expireIn = calendar.getTimeInMillis();
                }else{
                    log.error("泰盛中介云认证失败,返回空");
                    throw new Exception("泰盛中介云认证失败,返回空");
                }
            }catch (Exception e){
                log.error("泰盛中介云认证失败");
                e.printStackTrace();
                throw new Exception("泰盛中介云认证失败："+e.getMessage());
            }
        }else{
            access_token = token;
        }
        WebTrdInterfLog webTrdInterfLog = new WebTrdInterfLog();
        webTrdInterfLog.setC_token(access_token);
        webTrdInterfLog.setC_resquest(sendStr);
        webTrdInterfLog.setC_type("1");
        webTrdInterfLog.setC_com_id("D5FE81B37000764BE0530100007FD60B");
        webTrdInterfLog.setC_com_name("泰盛");
        webTrdInterfLog.setN_expire_in(expireIn);
        webTrdInterfLog.setC_app_no(appNo);
        try{
            if("policy".equals(sendType)){
                returnStr = HttpUtils.sendPcisPost(urlTaiSheng+"/integration/automobile/contract",sendStr,access_token);
            }else{
                returnStr = HttpUtils.sendPcisPost(urlTaiSheng+"/integration/endorsement/automobile",sendStr,access_token);
            }

            webTrdInterfLog.setC_response(returnStr);
            if(!"".equals(returnStr)){
                log.info("推送失败："+returnStr);
                if(returnStr.contains("已经存在")){
                    webTrdInterfLog.setC_status("0");
                }else{
                    webTrdInterfLog.setC_status("1");
                }
            }else{
                webTrdInterfLog.setC_status("0");
                log.info("推送成功");
            }
        }catch (Exception e){
            webTrdInterfLog.setC_status("1");
            webTrdInterfLog.setC_response(e.getMessage());
            log.error("泰盛推送数据失败");
            e.printStackTrace();
        }finally {
            log.info("日志保存");
            if(webTrdInterfLogMapper.selectLog(appNo)>0){
                webTrdInterfLogMapper.updateLog(webTrdInterfLog);
            }else {
                webTrdInterfLogMapper.saveLog(webTrdInterfLog);
            }

        }

    }
    public String rePushPolicyToTaiSheng(String startDateStr,String endDateStr,String appNo) throws Exception {
        log.info("获取推送失败数据");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        if(startDateStr !=null && !"".equals(startDateStr)){
            startDate = sdf.parse(startDateStr);
        }
        if(endDateStr !=null && !"".equals(endDateStr)){
            endDate = sdf.parse(endDateStr);
        }
        List<Map<String,Object>> failList = webTrdInterfLogMapper.getFailedList(startDate,endDate,appNo);
        log.info("获取失败数据：共"+failList.size()+"条");
        for(Map<String,Object> map:failList){
            if(map.get("C_APP_TYP").toString().equals("A")){
                this.pushPolicy(null,null,map.get("C_APP_NO").toString());
            }else {
                this.pushEndor(null,null,map.get("C_APP_NO").toString());
            }
        }
        return "失败数据重推成功";
    }
}
