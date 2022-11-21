package com.tsvhlpom.batchdata.vhlplatdatacheck.tool;

import com.tsvhlpom.batchdata.vhlplatdatacheck.constants.PlateConstants;
import com.tsvhlpom.batchdata.vhlplatdatacheck.mapper.VhlPlatDataCheckMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  * 描述
 * 签单数据处理类
 * @Author Xinglong Lei
 * @Date 2020/7/7
 */

@Service
@Slf4j
public class VerifyData {

    @Autowired
    private VhlPlatDataCheckMapper vhlPlatDataCheckMapper;
    @Autowired
    private CommTools commTools;

    @Value(("${VPDCPageSize}"))
    private int PAGESIZE;

    public void verifyDataToZip(Date startDate, Date endDate, String areaCode, String prod, String month, String xmlDate) throws Exception {

        log.info("一。verifyDataToZip 机构："+areaCode+",产品："+prod);
        String path = commTools.getPath(month)  + File.separator + "Verify" + File.separator  + areaCode +File.separator + prod + File.separator  ;
        String dptCde= PlateConstants.dptCdeMap.get(areaCode);
        String districtCode  = PlateConstants.districtCdeMap.get(areaCode);
        log.info("二。verifyDataToZip 机构："+areaCode+",产品："+prod+"开始查询数据");
        List<String> verifyDataList = vhlPlatDataCheckMapper.getVerifyData(startDate, endDate, prod, dptCde, districtCode);
        log.info("三。verifyDataToZip 机构："+areaCode+",产品："+prod+"数据共"+verifyDataList.size());
        //数据处理总List
        List<List<String>> list = new ArrayList<>();

        //数据分页 
        int countNum = (int) Math.ceil(verifyDataList.size() * 1.0 / PAGESIZE);
        for (int i = 1; i <= countNum; i++) {
            //按照设置的总条数进行分页，
            int startPage = (i - 1) * PAGESIZE;
            int entPage = i * PAGESIZE;
            if (entPage > verifyDataList.size()) {
                entPage = verifyDataList.size();
            }
            List<String> dataList = verifyDataList.subList(startPage, entPage);
            list.add(dataList);
        }
        log.info("四。verifyDataToZip 机构："+areaCode+",产品："+prod+"分页完成");
        for (int i = 0; i < list.size(); i++) {
            String index = String.format("%02d", (i + 1));
            //默认交强险，如果是商业险则切换到商业险
            String prodFileTitle = "_TSBX_0002_";
            if("SY".equals(prod)) {
                prodFileTitle = "_TSBX_V0002_";
            }
            String fileName = xmlDate + "_"+districtCode+ prodFileTitle + index;
            String xmlStr = getXmlStr(list.get(i), xmlDate, fileName, prod);
            commTools.writeFile(fileName, path, xmlStr);
            log.info("verifyDataToZip 机构："+areaCode+",产品："+prod+"循环进行中。。。。。");
        }
        log.info("五：verifyDataToZip 机构："+areaCode+",产品："+prod+"循环完成");

    }

    private String getXmlStr(List<String> dataList, String xmlDate, String fileName, String prodNo) {
        StringBuffer reXml = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        String requestType = "0002";
        if("SY".equals(prodNo)) {
            requestType = "V0002";
        }
        for(String s : dataList) {
            tmp.append(s).append("\n");
        }

        reXml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n")
                .append("<PACKET type=\"REQUEST\" version=\"1.0\">\n")
                .append("<HEAD>\n")
                .append("    <PACKAGE_SQUENCE_NO>").append(fileName).append("</PACKAGE_SQUENCE_NO>\n")
                .append("    <DATA_INSERT_COUNT>").append(dataList.size()).append("</DATA_INSERT_COUNT>\n")
                .append("    <DATA_DELETE_COUNT>0</DATA_DELETE_COUNT>\n")
                .append("    <REQUEST_TYPE>").append(requestType).append("</REQUEST_TYPE>\n")
                .append("    <YEARMONTH>").append((xmlDate.substring(0,6))).append("</YEARMONTH>\n")
                .append("</HEAD>\n")
                .append("<DATA>\n")
                .append("    <DATA_INSERT_LIST>\n")
                .append(tmp)
                .append("  </DATA_INSERT_LIST>\n")
                .append("   <DATA_DELETE_LIST></DATA_DELETE_LIST>\n")
                .append("  </DATA>\n")
                .append("</PACKET>\n");
        return reXml.toString();
    }


}
