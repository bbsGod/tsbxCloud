package com.tsvhlpom.batchdata.vhlplatdatacheck.tool;

import com.tsvhlpom.batchdata.vhlplatdatacheck.constants.PlateConstants;
import com.tsvhlpom.batchdata.vhlplatdatacheck.domain.TrdAppSendPacketDO;
import com.tsvhlpom.batchdata.vhlplatdatacheck.mapper.VhlPlatDataCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.jdom2.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  * 描述
 * 查询数据处理类
 * @Author Xinglong Lei
 * @Date 2020/7/7
 */

@Service
@Slf4j
public class QueryData {

    @Autowired
    private CommTools commTools;

    @Value(("${VPDCPageSize}"))
    private int PAGESIZE;
    @Autowired
    private VhlPlatDataCheckMapper vhlPlatDataCheckMapper;

    public void queryDateToZip(Date startDate, Date endDate, String areaCode, String prod, String month, String xmlDate) throws Exception {
        log.info("1===机构："+areaCode+",产品："+prod);
        String path = commTools.getPath(month)  + File.separator + "Query" + File.separator  + areaCode +File.separator + prod + File.separator  ;
        String dptCde= PlateConstants.dptCdeMap.get(areaCode);
        String districtCode  = PlateConstants.districtCdeMap.get(areaCode);
        //数据处理总List
        List<List<TrdAppSendPacketDO>> list = new ArrayList<>();
        log.info("2===机构："+areaCode+",产品："+prod+"开始查询数据");
        List<TrdAppSendPacketDO> trdAppSendPacketDOList = vhlPlatDataCheckMapper.getQueryData(startDate, endDate,prod,dptCde);
        log.info("3===机构："+areaCode+",产品："+prod+"查询数据："+trdAppSendPacketDOList.size()+"条");
        //利用Map的key去重
        Map<String, TrdAppSendPacketDO> disMap = new HashMap<>();
        for (TrdAppSendPacketDO cPacketVo : trdAppSendPacketDOList) {
            if(cPacketVo.getCQryCde() != null && !"".equals(cPacketVo.getCQryCde())) {
                disMap.put(cPacketVo.getCQryCde(), cPacketVo);
            }
        }
        List<TrdAppSendPacketDO> reList = new ArrayList<>();
        for (TrdAppSendPacketDO t : disMap.values()) {
            reList.add(t);
        }
        trdAppSendPacketDOList = reList;
        log.info("4===机构："+areaCode+",产品："+prod+"去重完成");
        //数据分页 
        int countNum = (int) Math.ceil(trdAppSendPacketDOList.size() * 1.0 / PAGESIZE);
        for (int i = 1; i <= countNum; i++) {
            //按照设置的总条数进行分页，
            int startPage = (i - 1) * PAGESIZE;
            int entPage = i * PAGESIZE;
            if (entPage > trdAppSendPacketDOList.size()) {
                entPage = trdAppSendPacketDOList.size();
            }
            List<TrdAppSendPacketDO> packetList = trdAppSendPacketDOList.subList(startPage, entPage);
            list.add(packetList);
        }
        log.info("5===机构："+areaCode+",产品："+prod+"分页完成，list.size"+list.size());
        for (int i = 0; i < list.size(); i++) {
            String index = String.format("%02d", (i + 1));
            //默认交强险，如果是商业险则切换到商业险
            String prodFileTitle = "_TSBX_0001_";
            if("SY".equals(prod)) {
                prodFileTitle = "_TSBX_V0001_";
            }
            String fileName = xmlDate + "_"+districtCode+ prodFileTitle + index;
            String xmlStr = "";
            if("SY".equals(prod)) {
                xmlStr =getSYXmlStr(list.get(i), fileName, xmlDate, districtCode);
            } else {
                xmlStr =getJQXmlStr(list.get(i), fileName, xmlDate, districtCode);
            }
            commTools.writeFile(fileName, path, xmlStr);
        }
        log.info("6===机构："+areaCode+",产品："+prod+"queryDateToZip完成");
    }

    private String getSYXmlStr(List<TrdAppSendPacketDO> list , String fileName, String xmlDate, String districtCode) throws Exception {
        log.info("开始组装报文。。。");
        StringBuffer xmlStr = new StringBuffer();
        List<TrdAppSendPacketDO> dataList = list;
        xmlStr.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n")
                .append("<PACKET type=\"REQUEST\" version=\"1.0\">\n")
                .append("<HEAD>\n")
                .append("    <PACKAGE_SQUENCE_NO>\n")
                .append("        " + fileName + "\n")
                .append("    </PACKAGE_SQUENCE_NO>\n")
                .append("    <DATA_INSERT_COUNT>" + dataList.size() + "</DATA_INSERT_COUNT>\n")
                .append("    <DATA_DELETE_COUNT>0</DATA_DELETE_COUNT>\n")
                .append("    <REQUEST_TYPE>V0001</REQUEST_TYPE>\n")
                .append("    <YEARMONTH>" + xmlDate.substring(0,6) + "</YEARMONTH>\n")
                .append("</HEAD>\n")
                .append("<DATA>\n")
                .append("    <DATA_INSERT_LIST>\n");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (dataList.size() > 0) {
            for (TrdAppSendPacketDO dataVo : dataList) {
                Document root = commTools.StringToDocument(getCSendPacket(dataVo.getCQryCde()));
                xmlStr.append("    <RECORD>\n")
                        .append("        <DISTRICT_CODE>" + districtCode + "</DISTRICT_CODE>\n")
                        .append("        <COMPANY_CODE>TSBX</COMPANY_CODE>\n")
                        .append("        <QUERY_SEQUENCE_NO>");
                xmlStr.append(dataVo.getCQryCde() == null ? "" : dataVo.getCQryCde())
                        .append("</QUERY_SEQUENCE_NO>\n")
                        .append("        <QUERY_DATE>")
                        .append(sdf.format(dataVo.getTSendTm()))
                        .append("</QUERY_DATE>\n")
                        .append("        <BILL_DATE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Application//BillDate", root))
                        .append("</BILL_DATE>\n")
                        .append("        <START_DATE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Application//EffectiveDate", root))
                        .append("</START_DATE>\n")
                        .append("        <END_DATE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Application//ExpireDate", root))
                        .append("</END_DATE>\n")
                        .append("        <LICENSE_TYPE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Vehicle//VehicleType", root))
                        .append("</LICENSE_TYPE>\n")
                        .append("        <MOTOR_TYPE_CODE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Vehicle//MotorTypeCode", root))
                        .append("</MOTOR_TYPE_CODE>\n")
                        .append("        <USE_NATURE_CODE>")
                        .append(commTools.getDoumentNode("//Packet//Body//Vehicle//MotorUsageTypeCode", root))
                        .append("</USE_NATURE_CODE>\n")
                        .append("        <LICENSE_NO>")
                        .append(dataVo.getCPlateNo() == null ? "" : dataVo.getCPlateNo())
                        .append("</LICENSE_NO>\n")
                        .append("        <FRAME_NO>")
                        .append(commTools.getDoumentNode("//Packet//Body//Vehicle//VIN", root))
                        .append("</FRAME_NO>\n")
                        .append("        <ENGINE_NO>")
                        .append(dataVo.getCEngNo() == null ? "" : dataVo.getCEngNo())
                        .append("</ENGINE_NO>\n")
                        .append("        <PREMIUM></PREMIUM>\n")
                        .append("     </RECORD>\n");
            }
        }
        xmlStr.append("  </DATA_INSERT_LIST>\n")
                .append("   <DATA_DELETE_LIST></DATA_DELETE_LIST>\n")
                .append("  </DATA>\n")
                .append("</PACKET>\n");
        log.info("getSYXmlStr组装报文结束");
        return xmlStr.toString();
    }

    private String getJQXmlStr(List<TrdAppSendPacketDO> list , String fileName, String xmlDate, String districtCode) throws Exception {
        StringBuffer xmlStr = new StringBuffer();
        List<TrdAppSendPacketDO> dataList = list;
        xmlStr.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n")
                .append("<PACKET type=\"REQUEST\" version=\"1.0\">\n")
                .append("<HEAD>\n")
                .append("    <PACKAGE_SQUENCE_NO>\n")
                .append("        " + fileName +"\n")
                .append("    </PACKAGE_SQUENCE_NO>\n")
                .append("    <DATA_INSERT_COUNT>"+ dataList.size() + "</DATA_INSERT_COUNT>\n")
                .append("    <DATA_DELETE_COUNT>0</DATA_DELETE_COUNT>\n")
                .append("    <REQUEST_TYPE>0001</REQUEST_TYPE>\n")
                .append("    <YEARMONTH>"+ xmlDate.substring(0,6) + "</YEARMONTH>\n")
                .append("</HEAD>\n")
                .append("<DATA>\n")
                .append("    <DATA_INSERT_LIST>\n");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        if(dataList.size() > 0) {
            int kk=0;
            for(TrdAppSendPacketDO dataVo : dataList) {
                Document root = commTools.StringToDocument(getCSendPacket(dataVo.getCQryCde()));
                xmlStr.append("    <RECORD>\n")
                        .append("        <DISTRICT_CODE>" + districtCode + "</DISTRICT_CODE>\n")
                        .append("        <COMPANY_CODE>TSBX</COMPANY_CODE>\n")
                        .append("        <QUERY_SEQUENCE_NO>");
                xmlStr.append(dataVo.getCQryCde() == null ? "" : dataVo.getCQryCde())
                        .append("</QUERY_SEQUENCE_NO>\n")
                        .append("        <QUERY_DATE>")
                        .append(sdf.format(dataVo.getTSendTm()))
                        .append("</QUERY_DATE>\n")
                        .append("        <BILL_DATE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//COVERAGE_LIST//BILL_DATE", root))
                        .append("</BILL_DATE>\n")
                        .append("        <START_DATE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//COVERAGE_LIST//START_DATE", root))
                        .append("</START_DATE>\n")
                        .append("        <END_DATE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//COVERAGE_LIST//END_DATE", root))
                        .append("</END_DATE>\n")
                        .append("        <LICENSE_TYPE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//BASE_PART//VEHICLE_STYLE", root))
                        .append("</LICENSE_TYPE>\n")
                        .append("        <MOTOR_TYPE_CODE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//BASE_PART//VEHICLE_CATEGORY", root))
                        .append("</MOTOR_TYPE_CODE>\n")
                        .append("        <USE_NATURE_CODE>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//BASE_PART//USE_TYPE", root))
                        .append("</USE_NATURE_CODE>\n")
                        .append("        <LICENSE_NO>")
                        .append(dataVo.getCPlateNo() == null ? "" : dataVo.getCPlateNo())
                        .append("</LICENSE_NO>\n")
                        .append("        <FRAME_NO>")
                        .append(commTools.getDoumentNode("//PACKET//BODY//BASE_PART//RACK_NO", root))
                        .append("</FRAME_NO>\n")
                        .append("        <ENGINE_NO>")
                        .append(dataVo.getCEngNo() == null ? "" : dataVo.getCEngNo())
                        .append("</ENGINE_NO>\n")
                        .append("        <PREMIUM></PREMIUM>\n")
                        .append("     </RECORD>\n");
            }
        }
        xmlStr.append("  </DATA_INSERT_LIST>\n")
                .append("   <DATA_DELETE_LIST></DATA_DELETE_LIST>\n")
                .append("  </DATA>\n")
                .append("</PACKET>\n");

        return xmlStr.toString();
    }

    private String getCSendPacket(String CQryCde){
        return vhlPlatDataCheckMapper.getCSendPacket(CQryCde).get(0).getCSendPacket();
    }
}
