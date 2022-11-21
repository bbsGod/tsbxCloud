package com.tsvhlpom.batchdata.gbmonthdata.tools;

import com.tsvhlpom.batchdata.gbmonthdata.domian.PacketTempDO;
import com.tsvhlpom.batchdata.gbmonthdata.mapper.MidDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述 处理光博中间表数据
 *
 * @Author Xinglong Lei
 * @Date 2020/2/11
 */

@Service
@Slf4j
public class MidDataService {

    @Autowired
    private MidDataMapper midDataMapper;

    @Value("${GBFilePath}")
    private String filePath;

    static String[] type = new String[]{"JQ","SY"};

    private String errPath;

    private SimpleDateFormat oracleSdf = new SimpleDateFormat("yyyyMMdd");

    public void execute(String month) throws Exception{
        log.info("1、开始处理数据。。。"+month);
        errPath = getDPath(month);
        //根据month 获取 起始日期， 终止日期为下个月1日。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date startDate = sdf.parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.MONTH, 1);
        Date endDate = calendar.getTime();
        // 记录插入日志的数据量
        int insertcount = 0;
        // 大循环，循环的是 交强和商业
        for(int i = 0; i< type.length; i ++) {
            List<PacketTempDO> list = parsePacket(type[i], startDate, endDate);
            insertcount = insertcount + insertData(list, type[i], startDate, endDate,month);
        }
        log.info("累计插入"+insertcount+"条记录");


    }

    /**
     * 解析报文
     */

    private List parsePacket(String type, Date startDate, Date endDate) {
        List<PacketTempDO> list = new ArrayList();
        log.info("开始查询"+type+"数据");
        Map<String, Map<String,String>> resultMap = queryData(type, startDate, endDate);   //查询数据
        log.info("查询"+type+"数据，完成");
        String cDptCde = "";
        String plyNo = "";
        String packet = "";
        String tradeType = "";
        for(Map.Entry<String, Map<String,String>> m : resultMap.entrySet()) {
            plyNo = m.getKey();
            Map<String,String> map = m.getValue();
            for(Map.Entry<String, String> resMap : map.entrySet()) {
                cDptCde = resMap.getKey();
                tradeType = resMap.getValue();
                //获取packet
                packet = getPacket(plyNo,tradeType);
            }
            PacketTempDO packetTempDO  = parseXml(type, packet,plyNo,cDptCde);
            packetTempDO.setPlyNo(plyNo);
            int origYears = 0;
            try {
                origYears = this.getOrigYears(plyNo);
            } catch (Exception e) {
                this.errorToTxt("获取续存年出错,保单号:"+plyNo);
                e.printStackTrace();
            }
            packetTempDO.setOrigYears(origYears);
            list.add(packetTempDO);

        }
        return list;
    }
    private String getPacket(String plyNo,String tradeType){
        List<Map<String,Object>> list =  midDataMapper.getPacket(plyNo,tradeType);
        return list.get(0).get("packBody").toString();
    }
    /**
     * 向数据库中插入数据
     */
    private int insertData(List<PacketTempDO> packetTempDOList, String type, Date startDate, Date endDate, String month) {
        int insertcount = 0;
        try {
            for(int i = 0;i < packetTempDOList.size();i++) {
                try
                {
                    PacketTempDO  packetTempDO =  packetTempDOList.get(i);
                    packetTempDO.setType(type);
                    packetTempDO.setBgnTm(startDate);
                    packetTempDO.setEndTm(endDate);
                    packetTempDO.setCrtTm(new Date());
                    packetTempDO.setLastMrk(month);
                    midDataMapper.savePacketTempDO(packetTempDO);
                    insertcount++;
                }catch(Exception e)
                {
                    e.printStackTrace();
                    this.errorToTxt("保单号："+packetTempDOList.get(i).getPlyNo() +"插入数据异常");
                }
            }
            System.out.println("插入数据完成"+type+packetTempDOList.size());
        } catch (Exception e) {
            this.errorToTxt("插入数据异常~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        return insertcount;
    }

    /**
     * @param type:类型 较强/商业:SY/JQ
     * @param startDate:保险起期开始日期
     * @param endDate:保险起期终结日期
     *
     */
    private Map<String,Map<String,String>>  queryData(String type, Date startDate, Date endDate) {
        Map<String, Map<String,String>> map = new HashMap<String, Map<String,String>>();
        try {
            List<Map<String, Object>> dataList = midDataMapper.queryData(type, startDate, endDate);
            log.info("size:" + dataList.size());
            for (Map<String, Object> dataMap : dataList) {
                Map<String, String> m = new HashMap<>();
                String plyNo = (String)dataMap.get("plyNo");
                //String packBody = (String) dataMap.get("packBody");
                String tradeType = (String)dataMap.get("tradeType");
                String dptCde = (String)dataMap.get("dptCde");
                if (map.get(plyNo) == null) {
                    //m.put(dptCde, packBody);
                    m.put(dptCde, tradeType);
                    map.put(plyNo, m);
                } else {
                    if ("21_return".equals(tradeType)) {
                        //m.put(dptCde, packBody);
                        m.put(dptCde, tradeType);
                        map.put(plyNo, m);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.errorToTxt("数据获取异常" +e.getMessage() );
        }
        log.info("Map处理完毕");
        return map;
    }

    /**
     * 解析报文
     * @param type:类型 JQ/SY
     * @param packet:xml报文
     */
    private PacketTempDO parseXml(String type, String packet, String plyNo, String cDptCde) {
        PacketTempDO  packetTempDO ;
        if("08".equals(cDptCde.subSequence(0, 2))){
            packetTempDO = getBJDoumentNode(packet, plyNo, type);
        } else {
            packetTempDO = getDoumentNode(packet, plyNo, type);
        }
        return packetTempDO;
    }

    /**
     *    map  key value 的形式  解析报文  存储 部分分信息
     */
    public PacketTempDO getDoumentNode(String packet, String plyNo, String type) {
        PacketTempDO packetTempDO = new PacketTempDO();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new ByteArrayInputStream(packet.getBytes("GBK")));
            Element root =  doc.getRootElement();
            //往年出险 记录，非一年  是从有平台记录开始
            //理赔节点
            String claimPath = "";
            //历史赔款节点
            String claimAmount = "";
            //历史赔款总金额
            Double claimAmountSum = 0.00;
            //出险条数
            int i = 0 ;
            //无赔忧节点
            String riskItemPath = "";
            //无赔忧系数
            String claimAdjustValuePath="";
            //无赔忧浮动原因
            String claimAdjustReasonPath ="";
            //无赔忧不浮动原因
            String noClaimAdjustReasonPath = "";
            if("JQ".equals(type.toUpperCase())) {
                claimPath = "//PACKET//BODY//CLAIM_LIST//CLAIM_DATA";
                claimAmount ="//PACKET//BODY//CLAIM_LIST//CLAIM_COVER_LIST//CLAIM_COVER_DATA//CLAIM_AMOUNT";
                riskItemPath = "//PACKET//BODY//COVERAGE_LIST//COVERAGE";
                claimAdjustValuePath = "CLAIM_ADJUST_VALUE";
                claimAdjustReasonPath="CLAIM_ADJUST_REASON";
                noClaimAdjustReasonPath="RATE_FLOAT_FLAG";
            } else if("SY".equals(type.toUpperCase())) {
                claimPath = "//Packet//Body//BusinessPolicyAccident";
                claimAmount ="ClaimAmount";
                riskItemPath = "//Packet//Body//RiskItem";
                claimAdjustValuePath ="ClaimAdjustValue";
                claimAdjustReasonPath = "ClaimAdjustReason";
                noClaimAdjustReasonPath = "NoClaimAdjustReason";

            }
            //理赔节点处理
            XPathExpression<Element> claimXPath = XPathFactory.instance().compile(claimPath, Filters.element());
            List<Element> claimList = claimXPath.evaluate(root);
            for(Element element : claimList){
                if(element != null) {
                    if(!"".equals(element.getValue())) {
                        if("SY".equals(type.toUpperCase())) {
                            claimAmountSum = claimAmountSum + Double.parseDouble(element.getChild(claimAmount).getValue());
                        } else {
                            Element claimCoverList =  element.getChild("CLAIM_COVER_LIST");
                            if(claimCoverList == null) {
                                claimAmountSum = claimAmountSum + Double.parseDouble(element.getChild("CLAIM_AMOUNT").getValue());
                            } else {
                                List<Element> claminCoverDataList = claimCoverList.getChildren("CLAIM_COVER_DATA");
                                for(Element coverData : claminCoverDataList) {
                                    claimAmountSum = claimAmountSum + Double.parseDouble(coverData.getChild("CLAIM_AMOUNT").getValue());
                                }
                            }
                        }
                        i++;
                    }
                }
            }
            packetTempDO.setClaim(i);
            packetTempDO.setClaimAmountSum(claimAmountSum);
            //无赔忧节点处理
            XPathExpression<Element> riskXPath = XPathFactory.instance().compile(riskItemPath, Filters.element());
            List<Element> riskList = riskXPath.evaluate(root);
            Double claimAdjustValue = 0.00;
            String claimAdjustReason = "";
            String noClaimAdjustReason = "";
            if(riskList.size()>0) {
                Element riskElement = riskList.get(0);
                claimAdjustValue = this.stringToDouble(riskElement.getChild(claimAdjustValuePath).getValue());
                if(riskElement.getChild(claimAdjustReasonPath) != null ) {
                    claimAdjustReason = riskElement.getChild(claimAdjustReasonPath).getValue();
                }
                if(riskElement.getChild(noClaimAdjustReasonPath)!= null ) {
                    noClaimAdjustReason = riskElement.getChild(noClaimAdjustReasonPath).getValue();
                }
            }
            packetTempDO.setClaimAdjustValue(claimAdjustValue);
            packetTempDO.setClaimAdjustReason(claimAdjustReason);
            packetTempDO.setNoClaimAdjustReason(noClaimAdjustReason);
        } catch (Exception e) {
            e.printStackTrace();
            this.errorToTxt("解析报文错误，保单号："+plyNo);
        }
        return packetTempDO;
    }
    /**
     *    map  key value 的形式  解析报文  存储 部分分信息  北京专用
     */
    private PacketTempDO getBJDoumentNode(String packet, String plyNo, String type) {
        PacketTempDO packetTempDO = new PacketTempDO();
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new ByteArrayInputStream(packet.getBytes("GBK")));
            Element root =  doc.getRootElement();
            //往年出险 记录，非一年  是从有平台记录开始
            //理赔节点
            String claimPath = "";
            //历史赔款节点
            String claimAmount = "";
            //历史赔款总金额
            Double claimAmountSum = 0.00;
            //出险条数
            int i = 0 ;
            //无赔忧节点
            String riskItemPath = "";
            //无赔忧系数
            String claimAdjustValuePath="";
            //无赔忧浮动原因
            String claimAdjustReasonPath ="";
            //无赔忧不浮动原因
            String noClaimAdjustReasonPath = "";
            if("JQ".equals(type.toUpperCase())) {
                claimPath = "//PACKET//BODY//CLAIM_LIST//CLAIM_DATA";
                claimAmount ="TOTAL_AMOUNT";
                riskItemPath = "//PACKET//BODY//COVERAGE_LIST//COVERAGE";
                claimAdjustValuePath = "CLAIM_ADJUST_VALUE";
                claimAdjustReasonPath="ClaimAdjustReason";
                noClaimAdjustReasonPath="NoClaimAdjustReason";
            } else if("SY".equals(type.toUpperCase())) {
                claimPath = "//PACKET//BODY//BUSI_CLAIM_LIST//BUSI_CLAIM_DATA";
                claimAmount ="TOTAL_AMOUNT";
                riskItemPath = "//PACKET//BODY//BASE_PART";
                claimAdjustValuePath ="//PACKET//BODY//AdjustList//AdjustData";
                claimAdjustReasonPath = "ClaimAdjustReason";
                noClaimAdjustReasonPath = "NoClaimAdjustReason";
            }
            //理赔节点处理
            XPathExpression<Element> claimXPath = XPathFactory.instance().compile(claimPath, Filters.element());
            List<Element> claimList = claimXPath.evaluate(root);
            for(Element element : claimList){
                if(element != null){
                    if(!"".equals(element.getValue())) {
                        claimAmountSum = claimAmountSum + Double.parseDouble(element.getChild(claimAmount).getValue());
                        i++;
                    }
                }
            }
            packetTempDO.setClaim(i);
            packetTempDO.setClaimAmountSum(claimAmountSum);
            //无赔忧节点处理
            XPathExpression<Element> riskXPath = XPathFactory.instance().compile(riskItemPath, Filters.element());
            List<Element> riskList = riskXPath.evaluate(root);
            Double claimAdjustValue = 0.00;
            String claimAdjustReason = "";
            String noClaimAdjustReason = "";
            if(riskList.size()>0){
                if("SY".equals(type.toUpperCase())){
                    Element riskElement = riskList.get(0);
                    XPathExpression<Element> claimAdjustPath = XPathFactory.instance().compile(claimAdjustValuePath, Filters.element());
                    List<Element> claimAdjustPathList = claimAdjustPath.evaluate(root);
                    for(Element claimAdjustValueElement : claimAdjustPathList){//商业险系数列表
                        String adjustCode = claimAdjustValueElement.getChildText("AdjustCode");
                        if("01".equals(adjustCode)){//01为无赔优系数
                            claimAdjustValue = this.stringToDouble(claimAdjustValueElement.getChild("AdjustValue").getValue());
                        }
                    }
                    claimAdjustReason = riskElement.getChild(claimAdjustReasonPath).getValue();
                    noClaimAdjustReason = riskElement.getChild(noClaimAdjustReasonPath).getValue();
                } else {
                    Element riskElement = riskList.get(0);
                    claimAdjustValue = this.stringToDouble(riskElement.getChild(claimAdjustValuePath).getValue());
                    if(riskElement.getChild(claimAdjustReasonPath) != null) {
                        claimAdjustReason = riskElement.getChild(claimAdjustReasonPath).getValue();
                    }
                    if(riskElement.getChild(noClaimAdjustReasonPath) != null) {
                        noClaimAdjustReason = riskElement.getChild(noClaimAdjustReasonPath).getValue();
                    }
                }
            }
            packetTempDO.setClaimAdjustValue(claimAdjustValue);
            packetTempDO.setClaimAdjustReason(claimAdjustReason);
            packetTempDO.setNoClaimAdjustReason(noClaimAdjustReason);
        } catch (Exception e) {
            e.printStackTrace();
            this.errorToTxt("解析报文错误，保单号："+plyNo);
        }

        return packetTempDO;
    }

    private void errorToTxt(String s) {
        try {
            String path =  errPath + "MidDataErr.txt";
            File file = new File(path);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter out = new BufferedWriter(fw);
            out.write(s);
            out.newLine();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Double stringToDouble(String s)
    {
        Double red = 0.00;
        if(s == null || s.equals(""))
        {
            return red;
        } else {
            try
            {
                red  = Double.parseDouble(s);
            }catch (Exception e)
            {
                red = 0.00;
            }
        }
        return red;
    }


    private int getOrigYears(String plyNo) {
        int nOrigYears = 0;
        List<Map> vhlList = midDataMapper.queryOriVhlData(plyNo);
        if(vhlList != null && vhlList.size() > 0) {
            Map vhlMap = vhlList.get(0);
            Date bgnTm = (Date) vhlMap.get("BGNTM");
            String engNo = (String) vhlMap.get("ENGNO");
            String frmNo = (String) vhlMap.get("FRMNO");
            Boolean flag = true;
            while(flag) {
                List<Map> dateList = midDataMapper.queryOrigYeasrs(engNo, frmNo, oracleSdf.format(bgnTm));
                if(dateList != null && dateList.size() > 0) {
                    nOrigYears++;
                    Map dateMap = dateList.get(0);
                    bgnTm = (Date) dateMap.get("BGNTM");
                } else {
                    flag = false;
                }
            }

        }
        return nOrigYears ;
    }

    /**
     * 获取文件夹的目录  目录 ：  配置的path+年+月
     * @param month
     * @return
     */
    private String getDPath(String month) {
        String[] strArr = month.split("-");
        return filePath + File.separator + strArr[0] + File.separator + strArr[1] + File.separator;
    }
}
