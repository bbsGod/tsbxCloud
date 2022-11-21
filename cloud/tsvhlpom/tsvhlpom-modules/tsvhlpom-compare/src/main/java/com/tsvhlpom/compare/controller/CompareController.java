package com.tsvhlpom.compare.controller;


import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.compare.domain.*;
import com.tsvhlpom.compare.service.*;
import com.tsvhlpom.compare.utils.CompareUtils;
import com.tsvhlpom.compare.utils.ComparisonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/pcis")
@RestController
@Slf4j
public class CompareController {

    @Autowired
    private IWebAppBaseService appBaseService;

    @Autowired
    private IWebAppVhlService appVhlService;

    @Autowired
    private IWebAppApplicantService appApplicantService;

    @Autowired
    private IWebAppInsuredService webAppInsuredService;

    @Autowired
    private IWebAppVhlownerService appVhlownerService;

    @Autowired
    private IWebAppFeeService appFeeService;

    @Autowired
    private IWebAppCvrgService webAppCvrgService;

    @Autowired
    private IWebAppCvrgPrmCoefService appCvrgPrmCoefService;

    @Autowired
    private IWebAppTgtObjService appTgtObjService;

    @Autowired
    private IWebAppVsTaxService appVsTaxService;

    @Autowired
    private IWebAppAcctinfoService appAcctinfoService;

    @Autowired
    private IWebAppChargingPostService appChargingPostService;

    @RequestMapping("/compare")
    public AjaxResult compareCloumn(String appnos){
        Map map = new HashMap<>();
        try{
            String[] appNo_list = appnos.split(",");
            //比对 web_app_base
            List<WebAppBase> webAppBaseList =  appBaseService.selectWebAppBaseList(appNo_list);
            List<ComparisonResult> results =  CompareUtils.compareFields(webAppBaseList.get(0),webAppBaseList.get(1),WebAppBase.class);
            if(results.size()>0){
                map.put("webAppBase",results);
            }
            /*WebAppBase pcis = webAppBaseList.stream().filter(webAppBase -> webAppBase.getcIssueSrc() ==null).collect(Collectors.toList()).get(0);
            for(WebAppBase webAppBase : webAppBaseList){
                if(!pcis.getcAppNo().equals(webAppBase.getcAppNo())){
                    List<ComparisonResult> results =  CompareUtils.compareFields(pcis,webAppBase,WebAppBase.class);
                    if(results.size()>0){
                        map.put("webAppBase",results);
                    }
                }
            }*/


            //比对web_app_vhl
            List<WebAppVhl> webAppVhlList =  appVhlService.selectWebAppVhlList(appNo_list);
            List<ComparisonResult> vhlResults =  CompareUtils.compareFields(webAppVhlList.get(0),webAppVhlList.get(1),WebAppVhl.class);
            if(vhlResults.size()>0){
                map.put("webAppVhl",vhlResults);
            }

            //比对webAppApplicant
            List<WebAppApplicant> webAppApplicantList =  appApplicantService.selectWebAppApplicantList(appNo_list);
            List<ComparisonResult> applicantResults =  CompareUtils.compareFields(webAppApplicantList.get(0),webAppApplicantList.get(1),WebAppApplicant.class);
            if(applicantResults.size()>0){
                map.put("webAppApplicant",applicantResults);
            }


            //比对webAppApplicant
            List<WebAppInsured> webAppInsuredList =  webAppInsuredService.selectWebAppInsuredList(appNo_list);
            List<ComparisonResult> insuredResults =  CompareUtils.compareFields(webAppInsuredList.get(0),webAppInsuredList.get(1),WebAppInsured.class);
            if(insuredResults.size()>0){
                map.put("webAppInsured",insuredResults);
            }

            //比对webAppVhlOwner
            List<WebAppVhlowner> webAppVhlownerList =  appVhlownerService.selectWebAppVhlownerList(appNo_list);
            List<ComparisonResult> vhlOwnerResults =  CompareUtils.compareFields(webAppVhlownerList.get(0),webAppVhlownerList.get(1),WebAppVhlowner.class);
            if(vhlOwnerResults.size()>0){
                map.put("webAppVhlowner",vhlOwnerResults);
            }


            //比对webAppFee
            List<WebAppFee> webAppFeeList =  appFeeService.selectWebAppFeeList(appNo_list);
            Map<String,List<WebAppFee>> appFeeMap= webAppFeeList.stream().collect(Collectors.groupingBy(WebAppFee::getcAppNo));
            List<WebAppFee> firstFeeList = appFeeMap.get(appNo_list[0]);
            List<WebAppFee> nextFeeList = appFeeMap.get(appNo_list[1]);
            for(WebAppFee firstFee:firstFeeList){
                for(WebAppFee nextFee:nextFeeList){
                    if(firstFee.getcFeetypCde().equals(nextFee.getcFeetypCde())){
                        List<ComparisonResult> appFeeResults =  CompareUtils.compareFields(firstFee,nextFee,WebAppFee.class);
                        if(appFeeResults.size()>0){
                            map .put("webAppFee"+firstFee.getcFeetypCde(),appFeeResults);
                        }

                    }
                }
            }
            //对比web_app_cvrg
            List<WebAppCvrg> webAppCvrgList = webAppCvrgService.selectWebAppCvrgList(appNo_list);
            Map<String,List<WebAppCvrg>> cvrgMap = webAppCvrgList.stream().collect(Collectors.groupingBy(WebAppCvrg::getcAppNo));
            List<WebAppCvrg> firstCvrgList = cvrgMap.get(appNo_list[0]);
            List<WebAppCvrg> nextCvrgList = cvrgMap.get(appNo_list[1]);
            for(WebAppCvrg firstCvrg:firstCvrgList){
                for(WebAppCvrg nextCvrg:nextCvrgList){
                    if(firstCvrg.getcCvrgNo().equals(nextCvrg.getcCvrgNo())){
                        List<ComparisonResult> appCvrgResults =  CompareUtils.compareFields(firstCvrg,nextCvrg,WebAppCvrg.class);
                        if(appCvrgResults.size()>0){
                            map .put("WebAppCvrg:"+firstCvrg.getcCvrgNo(),appCvrgResults);
                        }

                    }
                }
            }
            //比对 cvrgprmcoef
            List<WebAppCvrgPrmCoef> prmCoefList = appCvrgPrmCoefService.selectWebAppCvrgPrmCoefList(appNo_list);
            if(prmCoefList.size()>0){
                Map<String,List<WebAppCvrgPrmCoef>> prmMap =  prmCoefList.stream().collect(Collectors.groupingBy(WebAppCvrgPrmCoef::getcAppNo));
                List<WebAppCvrgPrmCoef> firstCvrgPrmList = prmMap.get(appNo_list[0]);
                List<WebAppCvrgPrmCoef> nextCvrgPrmList = prmMap.get(appNo_list[1]);
                for(WebAppCvrgPrmCoef firstCvrgPrm:firstCvrgPrmList){
                    for(WebAppCvrgPrmCoef nextCvrgPrm:nextCvrgPrmList){
                        if(firstCvrgPrm.getcCvrgNo().equals(nextCvrgPrm.getcCvrgNo())){
                            List<ComparisonResult> appCvrgPrmResults =  CompareUtils.compareFields(firstCvrgPrm,nextCvrgPrm,WebAppCvrgPrmCoef.class);
                            if(appCvrgPrmResults.size()>0){
                                map .put("WebAppCvrgPrmCoef:"+firstCvrgPrm.getcCvrgNo(),appCvrgPrmResults);
                            }

                        }
                    }
                }
            }

            //比对 新增设备
            List<WebAppTgtObj> webAppTgtObjList = appTgtObjService.selectWebAppTgtObjList(appNo_list);
            if(webAppTgtObjList.size()>0){
                Map<String,List<WebAppTgtObj>> tgtObjMap =  webAppTgtObjList.stream().collect(Collectors.groupingBy(WebAppTgtObj::getcAppNo));
                List<WebAppTgtObj> firstTgtList = tgtObjMap.get(appNo_list[0]);
                List<WebAppTgtObj> nextTgtList = tgtObjMap.get(appNo_list[1]);
                for(WebAppTgtObj firstTgt:firstTgtList){
                    for(WebAppTgtObj nextTgt:nextTgtList){
                        if(firstTgt.getcTgtObjTxtFld1().equals(nextTgt.getcTgtObjTxtFld1())){
                            List<ComparisonResult> appTgtResults =  CompareUtils.compareFields(firstTgt,nextTgt,WebAppTgtObj.class);
                            if(appTgtResults.size()>0){
                                map .put("WebAppTgtObj:"+firstTgt.getcTgtObjTxtFld1(),appTgtResults);
                            }

                        }
                    }
                }
            }

            //比对车船税
            List<WebAppVsTax> appVsTaxList = appVsTaxService.selectWebAppVsTaxList(appNo_list);
            if(appVsTaxList.size()>0){
                List<ComparisonResult> appVsTaxResults =  CompareUtils.compareFields(appVsTaxList.get(0),appVsTaxList.get(1),WebAppVsTax.class);
                if(appVsTaxResults.size()>0){
                    map.put("WebAppVsTax",appVsTaxResults);
                }
            }
            //比对账户信息
            List<WebAppAcctinfo> webAppAcctinfoList = appAcctinfoService.selectWebAppAcctinfoList(appNo_list);
            if(webAppAcctinfoList.size()>0){
                if(webAppAcctinfoList.size() == 1){
                    map.put("WebAppAcctinfo","账户信息一条，appNo："+webAppAcctinfoList.get(0).getcAppNo());
                }else if(webAppAcctinfoList.size() == 1){
                    List<ComparisonResult> appAcctResults =  CompareUtils.compareFields(webAppAcctinfoList.get(0),webAppAcctinfoList.get(1),WebAppAcctinfo.class);
                    if(appAcctResults.size()>0){
                        map.put("WebAppAcctinfo",appAcctResults);
                    }
                }else{
                    map.put("WebAppAcctinfo","账户信息多条");
                }

            }
            //比对充电桩
            List<WebAppChargingPost> webAppChargingPostList =  appChargingPostService.selectWebAppChargingPostList(appNo_list);
            if(webAppChargingPostList.size()>0){
                Map<String,List<WebAppChargingPost>> ChargingMap =  webAppChargingPostList.stream().collect(Collectors.groupingBy(WebAppChargingPost::getcAppNo));
                List<WebAppChargingPost> firstChargList = ChargingMap.get(appNo_list[0]);
                List<WebAppChargingPost> nextChargList = ChargingMap.get(appNo_list[1]);
                for(WebAppChargingPost firstCharg:firstChargList){
                    for(WebAppChargingPost nextCharg:nextChargList){
                        if(firstCharg.getcChargingPostCod().equals(nextCharg.getcChargingPostCod())){
                            List<ComparisonResult> appChargeResults =  CompareUtils.compareFields(firstCharg,nextCharg,WebAppChargingPost.class);
                            if(appChargeResults.size()>0){
                                map .put("WebAppChargingPost:"+firstCharg.getcChargingPostCod(),appChargeResults);
                            }

                        }
                    }
                }

            }



        }catch (Exception e){
            e.printStackTrace();
           return AjaxResult.error();
        }
        return AjaxResult.success(map);
    }

    public static void main(String[] args) {

    }
}
