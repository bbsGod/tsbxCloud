package com.tsvhlpom.batchdata.gbmonthdata.tools;

import com.tsvhlpom.batchdata.gbmonthdata.mapper.GbCheckDataMapper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CheckGbMonthData {

    @Autowired
    private GbCheckDataMapper gbCheckDataMapper;



    /***
     * 校验光博 policy数据  如果有异常则记录到errList中，同时 从dataList中删除
     * @return list 异常数据
     */
    public List<String> checkPolicyData(List<Map<String, Object>> dataList) throws Exception {
        List<String> errList = new ArrayList<>();
        boolean errFlag;
        for ( int i = 0; i< dataList.size(); i++ ) {
            Map<String, Object> map = dataList.get(i);
            //如果有异常数据 则 为true；
            errFlag = false;
            // 校验批单时批改有效起期是否为空，如果为空，查询数据库是否有数据，如果同样为空直接抛出异常，给出提示； 申请单据类型此列数据不做数据导出
            String cAppNo = (String) map.get("投保单号");
            String cAppTyp = (String) map.get("申请单据类型");
            String tEdrBgnTm = (String) map.get("批单有效起期");
            if (cAppTyp.equals("E") && ("".equals(tEdrBgnTm) || null == tEdrBgnTm)) {
                Date d = this.gbCheckDataMapper.queryBaeEdrBgnTm(cAppNo);
                if (d == null) {
                    errFlag = true;
                    errList.add("批改有效起期为空" + cAppNo);
                }else{
                    map.put("批单有效起期",d);
                }
            }
            //因为此列不做数据导出，只校验使用，所以校验完直接删除；
            map.remove("申请单据类型");
            // 产品
            String cProdNo = (String) map.get("险种代码");
            // 承保二级机构
            String cTwoDptCde = (String) map.get("承保二级机构代码");
            // 无赔款优待记录
            String cClaimAdjustReason = (String) map.get("无赔款优待记录");
            // 不浮动原因
            String cNoClaimAdjustReason = (String) map.get("不浮动原因");
            // 车辆使用性质代码
            String cUsageCde = (String) map.get("车辆使用性质代码");
            // 当产品不为0335或0337
            // 且不是北京交强险
            // 且 不是0320的364005002 和364005003 使用性质时
            // 时判断无赔优系数和不浮动原因，若都为空则取光博发送报文中节点，进行对比，如果报文中节点不为空则回填
            if (!("0335".equals(cProdNo) || "0337".equals(cProdNo)
                    || ("0320".equals(cProdNo) && "08".equals(cTwoDptCde))
                    || ("0320".equals(cProdNo) && ("364005002".equals(cUsageCde) || "364005003".equals(cUsageCde))) )) {

                if (("".equals(cClaimAdjustReason) || cClaimAdjustReason == null) && ("".equals(cNoClaimAdjustReason) || cNoClaimAdjustReason == null)) {
                    String packet = this.gbCheckDataMapper.queryApPacket(cAppNo);
                    if ("".equals(packet) || packet == null) {
                        errFlag = true;
                        errList.add("没有发送光博报文" + cAppNo);
                    } else {
                        SAXBuilder builder = new SAXBuilder();
                        Document doc = builder.build(new ByteArrayInputStream(packet.getBytes(StandardCharsets.UTF_8)));
                        // 读取根元素
                        Element rootElement = doc.getRootElement();
                        // 读取所有riskInfoList节点
                        List<Element> riskInfoList = rootElement.getChildren("riskInfoList");
                        for (Element riskInfo : riskInfoList) {
                            String riskCode = riskInfo.getChildText("riskCode");
                            //TODO  车险还有其他产品么？ 为什么要分开判断这两个？ 或者说节点下有其他东西？
                            if ("R".equals(riskCode) || "B".equals(riskCode)) { // R代表交强险  B代表商业险
                                String ncdClass = riskInfo.getChildText("ncdClass"); // 无赔款优待记录
                                if ("".equals(ncdClass) || ncdClass == null) {
                                    ncdClass = riskInfo.getChildText("NCDclass"); // 无赔款优待记录
                                }
                                String noAdjust = riskInfo.getChildText("noAdjust"); // 不浮动原因
                                if ((ncdClass != null  && !"".equals(ncdClass)) && ( noAdjust != null &&  !"".equals(noAdjust))) {
                                    map.put("无赔款优待记录", ncdClass);
                                    map.put("不浮动原因", noAdjust);
                                }
                            }
                        }
                    }
                }
            }
            if(errFlag) {
                dataList.remove(i);
                i--;
            }
        }

        return errList;
    }

    /***
     * 校验光博 policy_duty数据
     * @param startDataDate  数据开始时间
     * @param endDataDate  数据结束时间
     * @return list
     */
    public List<String> checkPolicyDutyData(List<Map<String, Object>> dataList, Date startDataDate, Date endDataDate) {
        List<String> errList = new ArrayList<>();
        boolean errFlag;
        for (int i =0; i<dataList.size(); i ++ ) {
            Map<String, Object> map = dataList.get(i);
            errFlag = false;
            // 校验险别看保险起期是否有超出日期的数据；如果有超出日期的数据，
            // 则查看是否有过批改，如果有批改则查看下批改的起期能不能对得上;
            String cPlyNo = (String) map.get("保单号");
            Date tBgnTm = (Date) map.get("保险起期");
            //System.out.println("此保单号:" + cPlyNo + " 开始校验");
            //校验有没有比起期早的数据 或 比止期晚的数据查询出来；
            if (startDataDate.getTime() - tBgnTm.getTime() > 0 || endDataDate.getTime() - tBgnTm.getTime() < 0) {
                List<Map<String, Object>> dateList = gbCheckDataMapper.queryPlyBaseInsrnsDate(cPlyNo);
                String cAppTyp;
                //先校验投投保单日期是否在正常范围内，如果有批单再校验批单的每次批改起期是否在正常范围内；
                if (dateList != null && dateList.size() > 0) {
                    for (Map<String, Object> dateMap : dateList) {
                        cAppTyp = (String) dateMap.get("c_app_typ");
                        Date tInsrncBgnTm = (Date) dateMap.get("t_insrnc_bgn_tm");
                        if ("A".equals(cAppTyp)) {
                            if (startDataDate.getTime() - tInsrncBgnTm.getTime() > 0 || endDataDate.getTime() - tInsrncBgnTm.getTime() < 0) {
                                errList.add("投保单保险起期异常" + cPlyNo);
                                errFlag = true;
                            }
                        } else if ("E".equals(cAppTyp)) {
                            Date tEdrBgnTm = (Date) dateMap.get("t_edr_bgn_tm");
                            if (tEdrBgnTm.getTime() != tBgnTm.getTime()) {
                                errList.add("批单保险起期异常" + cPlyNo);
                                errFlag = true;
                            }
                        }
                    }
                }
            }
            //校验分险别赔付成本和分险别成本折扣是否同时为空，如果同时为空查看数据库中是否有数据，数据库没有数据则不用再管。
            String nCostPrem = String.valueOf(map.get("分险别赔付成本"));
            String nCostDiscount = String.valueOf(map.get("分险别成本折扣"));
            String prondNo = cPlyNo.substring(7, 11); //产品
            if (!"0320".equals(prondNo) && ("".equals(nCostPrem) || "null".equals(nCostPrem)) && ("".equals(nCostDiscount) || "null".equals(nCostDiscount))) {
                List<Map<String, Object>> checkDataList = gbCheckDataMapper.checkPolicyDuty(cPlyNo, startDataDate, endDataDate);
                if (checkDataList != null && checkDataList.size() > 0) {
                    int checkCount = 0;
                    for(Map<String, Object> dataMap : checkDataList) {
                        if(checkPayCostMap(dataMap)) {
                            checkCount++;
                        }
                    }


                    //查询光博数据中保单分险别赔付成本和分险别成本折扣同时为空的有几单
                    int accessNumber = AccessNumber(dataList, cPlyNo);
                    if (checkCount != accessNumber) {
                        errList.add("分险别赔付成本和分险别成本折扣有异常" + cPlyNo);
                        errFlag = true;
                    }
                }
            }
            if(errFlag) {
                dataList.remove(i);
                i--;
            }
        }

        return errList;
    }

    public List<String>  checkJqPayCostData(List<Map<String, Object>> dataList) {
        List<String> errList = new ArrayList<>();
        boolean errFlag;
        for (int i =0; i<dataList.size(); i ++ ) {
            Map<String, Object> map = dataList.get(i);
            errFlag = false;
            //校验交强险赔付成本， 校验每个字段是否为空即可，如果为空报出错误，提示出保单号
            String cPlyNo = (String) map.get("C_PLY_NO");
            String Jq0320 = (String) map.get("'0320'");
            String nCtpCostPrem = String.valueOf(map.get("N_CTP_COST_PREM"));
            if (("".equals(cPlyNo) || null == cPlyNo) || ("".equals(Jq0320) || null == Jq0320) || ("".equals(nCtpCostPrem) || "null".equals(nCtpCostPrem))) {
                errList.add("交强险赔付成本有为空数据" + cPlyNo);
                errFlag = true;
            }
            if(errFlag) {
                dataList.remove(i);
                i--;
            }
        }
        return  errList;
    }

    /***
     * 校验光博 车损险纯风险保费
     * @return list
     */
    public List<String> checkPureRiskPremiumData(List<Map<String, Object>> dataList) {
        List<String> errList = new ArrayList<>();
        boolean errFlag;
        for (int i =0; i<dataList.size(); i ++ ) {
            Map<String, Object> map = dataList.get(i);
            errFlag = false;
            //校验车损险纯风险保费， 校验每个字段是否为空即可，如果为空报出错误，提示出保单号
            String cPlyNo = (String) map.get("C_PLY_NO");
            String nPureriskPremium = String.valueOf(map.get("N_PURERISK_PREMIUM"));
            String cModelCode = (String) map.get("C_MODEL_CODE");
            String cCvrgNo = (String) map.get("C_CVRG_NO");
            if (("".equals(cPlyNo) || null == cPlyNo) || ("".equals(nPureriskPremium) || "null".equals(nPureriskPremium)) || ("".equals(cModelCode) || "null".equals(cModelCode))
                    || ("".equals(cCvrgNo) || null == cCvrgNo)) {
                errList.add("车损险纯风险保费有为空数据" + cPlyNo);
                errFlag = true;
            }
            if(errFlag) {
                dataList.remove(i);
                i--;
            }
        }
        return errList;

    }


    /***
     * 查询保单分险别赔付成本和分险别成本折扣同时为空的有几单
     * @return count
     */
    private int AccessNumber(List<Map<String, Object>> policyDataList, String cPlyNoPro) {
        int count =0;
        for (Map<String, Object> map : policyDataList) {
            String cPlyNo = (String) map.get("保单号");
            if (cPlyNoPro.equals(cPlyNo)) {
                if (checkPayCostMap(map)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkPayCostMap (Map<String, Object> map) {
        if(map == null) {
            return false;
        }
        String nCostPremPro = String.valueOf(map.get("分险别赔付成本"));
        String nCostDiscountPro = String.valueOf(map.get("分险别成本折扣"));
         if(("".equals(nCostPremPro) || "null".equals(nCostPremPro)) && ("".equals(nCostDiscountPro) || "null".equals(nCostDiscountPro))) {
             return false;
        }
         return true;

    }


}
