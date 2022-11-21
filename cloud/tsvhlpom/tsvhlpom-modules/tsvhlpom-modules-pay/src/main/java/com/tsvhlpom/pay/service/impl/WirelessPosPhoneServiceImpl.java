package com.tsvhlpom.pay.service.impl;

import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.pay.service.WirelessPosPhoneService;
import org.apache.commons.codec.digest.DigestUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WirelessPosPhoneServiceImpl implements WirelessPosPhoneService {


    /**
     * 与通联约定的APPKEY名称
     */
    public static String APPKEY_KEY = "key";

    /**
     * 与通联约定的APPKEY值
     */
    public static String APPKEY_VALUE = "tscx20180326qqww";

    /**
     * 通联加签字段名
     */
    public static String SIGN_KEY = "sign";

    public String mainPay(String bizseq) throws Exception {
        String responseInfo = null;
        String responseCode = null;
        //String url = "http://10.1.70.19:8095/typt/TyptMainServlet.servlet";
		String url = "http://10.1.3.20:7003/typt/TyptMainServlet.servlet";
        String from = "TLPOS_PHONE_PAY";
        String pwd = "123123";

        System.out.println(bizseq + ":现在进行支付查询");
        String queryReqXml = getQueryXml(bizseq);
        String queryRspXml = httpRequest(url, from,"01", pwd, queryReqXml);
        System.out.println("查询接口返回报文："+queryRspXml);
        StringReader qsr = new StringReader(queryRspXml);
        InputSource qis = new InputSource(qsr);
        Document queryRspDoc = (new SAXBuilder()).build(qis);
        Element qRootEle = queryRspDoc.getRootElement();
        List headList = qRootEle.getChildren("Head");
        if(headList.iterator().hasNext()){
            Element element = (Element)headList.iterator().next();
            Element reCode1 = element.getChild("RespCode");
            if( reCode1 != null){
                responseCode = reCode1.getValue();
            }
            Element errorInfo1 = element.getChild("RespMsg");
            if(!"".equals(errorInfo1) && errorInfo1 != null){
                responseInfo = errorInfo1.getValue();
            }
            if ("0000".equals(responseCode)) {
                Element body = qRootEle.getChild("Body");
                if(body != null){
                    String qAmount = body.getChildText("PaymentAmount");
                    BigDecimal bdAmt = new BigDecimal(qAmount).divide(BigDecimal.valueOf(100), MathContext.DECIMAL128);

                    System.out.println(bizseq + ":" + responseInfo + ", 支付金额" + (new DecimalFormat("0.00").format(bdAmt.doubleValue())) + "元。");
                    System.out.println(bizseq + ":现在进行支付确认。");

                    String payReqXml = getPayXml(bizseq, qAmount);
                    String payRspXml = httpRequest(url, from,"02", pwd, payReqXml);

                    System.out.println(bizseq + ":" + payRspXml);
                }
            } else {
                System.out.println(bizseq + ":" + responseInfo);
            }
        }

        return responseInfo;
    }
    /**
     * 发送http请求
     * @param url URL地址
     * @param from 来源账户
     * @param pwd 密码
     * @param xml 报文体
     * @return 返回报文
     */
    private  String httpRequest(String url, String from,String type, String pwd, String xml) throws Exception {

        final String ENCODING = "UTF-8";

        // 拼装发送数据
        String sendData = "";
        sendData = "from=" + URLEncoder.encode(from, ENCODING);           // 参数：来源账户
        sendData = sendData + "&type=" + URLEncoder.encode(type, ENCODING); // 参数：密码
        sendData = sendData + "&pwd=" + URLEncoder.encode(pwd, ENCODING); // 参数：密码
        sendData = sendData + "&xml=" + URLEncoder.encode(xml, ENCODING); // 参数：XML报文体

        // 创建连接
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

        // 设置连接和读取的超时时间
        conn.setConnectTimeout(60000);
        conn.setReadTimeout(60000);

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        OutputStream output = null;
        try {
            output = conn.getOutputStream();
            output.write(sendData.getBytes());
            output.flush();
        } finally {
            if (output != null) {
                output.close();
            }
        }

        // 读取回应结果
        StringBuilder returnContent = new StringBuilder();
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream input = null;
            try {
                input = conn.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(input, ENCODING));
                char[] chars = new char[128];
                int readCount = 0;
                while ((readCount = reader.read(chars)) != -1) {
                    returnContent.append(chars, 0, readCount);
                }
            } finally {
                if (input != null) {
                    input.close();
                }
            }
        } else {
            throw new Exception("内部请求失败：" + conn.getResponseCode());
        }
        conn.disconnect();
        String rc = returnContent.toString();

        return rc;
    }
    private  String getQueryXml(String bizseq) throws Exception {
        String xml =
                "<Root>\n" +
                        "  <PaymentNo>" + bizseq + "</PaymentNo>\n" +
                        "</Root>";


        System.out.println("查询接口发送报文："+xml);
        return xml;
    }

    private  String getPayXml(String bizseq, String amtstr) throws Exception {

        String temestamp = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rowSet = null;
        String appNo = "";
        String payAccount = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.1.3.29:1521:ORADB", "pcisv6_tsky", "pcisv6_tsky_11");

            String sqlPay = "select c_app_no from web_pay_confirm_info where c_batch_no = ? ";
            stat = conn.prepareStatement(sqlPay);
            stat.setString(1, bizseq);
            rowSet = stat.executeQuery();

            while (rowSet.next()) {
                appNo = rowSet.getString("c_app_no");

                String sqlPacket = "select c_send_packet from web_trd_app_send_packet where c_app_no = ? and c_trade_typ = '23' " +
                        "order by T_SEND_TM asc";
                PreparedStatement statPac = conn.prepareStatement(sqlPacket);
                statPac.setString(1, appNo);
                ResultSet pacResultSet = statPac.executeQuery();
                while (pacResultSet.next()) {
                    String packet = pacResultSet.getString("c_send_packet");

                    Reader reader = new StringReader(packet);
                    SAXBuilder saxb = new SAXBuilder();
                    Document doc =  saxb.build(reader);
                    Element root = doc.getRootElement();
                    Element body = root.getChild("BODY");
                    if(body != null ) {
                        Element base = body.getChild("BASE_PART");
                        payAccount = base.getChildText("PAY_ACCOUNT");
                    } else {
                        body = root.getChild("Body");
                        Element base = body.getChild("BasePart");
                        payAccount = base.getChildText("PayAccount");
                    }


                    if (StringUtils.isNotBlank(payAccount)) {
                        break;
                    }
                }

                if (StringUtils.isNotBlank(payAccount)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(rowSet != null) {
                rowSet.close();
            }
            if(stat != null ) {
                stat.close();
            }
            if(conn != null) {
                conn.close();
            }
        }

        String xml =

                "<RequestInfo>\n" +
                        "\t<trxcode>VSP501</trxcode>\n" +
                        "\t<trxdate>20180403</trxdate>\n" +
                        "  <trxamt>" + amtstr + "</trxamt>\n" +
                        "  <acct>" + payAccount + "</acct>\n" +   // 赵岐的微信  oTPDJjg6Xvipk5YsvidYV3b-Vv74
                        "  <outtrxid>504180009755</outtrxid>\n" +
                        "  <paytime>" + temestamp + "</paytime>\n" +
                        "  <appid>00018799</appid>\n" +
                        "  <termrefnum>4200000072201804031481918239</termrefnum>\n" +
                        "  <sign></sign>\n" +
                        "  <trxstatus>0000</trxstatus>\n" +
                        "  <cusid>55045106300KVBD</cusid>\n" +
                        "  <termtraceno>0</termtraceno>\n" +
                        "  <termauthno>ABC_DEBIT</termauthno>\n" +
                        "  <cusorderid>" + bizseq + "</cusorderid>\n" +
                        "  <chnltrxid>4200000072201804031481918239</chnltrxid>\n" +
                        "  <trxid>111817340000237464</trxid>\n" +
                        "</RequestInfo>";


        // 转换为DOM对象
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        Document document = (new SAXBuilder()).build(is);
        // 根节点
        Element rootEle = document.getRootElement();

        // 将子节点组装成map键值对
        List eleList = rootEle.getChildren();
        HashMap<String, String> valueMap = new HashMap<String, String>();
        for (int i = 0; i < eleList.size(); i++) {

            Element ele = (Element) eleList.get(i);
            valueMap.put(ele.getName(), ele.getTextTrim());
        }
        String sign = getSign(valueMap);
        xml =

                "<RequestInfo>\n" +
                        "\t<trxcode>VSP501</trxcode>\n" +
                        "\t<trxdate>20180403</trxdate>\n" +
                        "  <trxamt>" + amtstr + "</trxamt>\n" +
                        "  <acct>" + payAccount + "</acct>\n" +
                        "  <outtrxid>504180009755</outtrxid>\n" +
                        "  <paytime>" + temestamp + "</paytime>\n" +
                        "  <appid>00018799</appid>\n" +
                        "  <termrefnum>4200000072201804031481918239</termrefnum>\n" +
                        "  <sign>" + sign + "</sign>\n" +
                        "  <trxstatus>0000</trxstatus>\n" +
                        "  <cusid>55045106300KVBD</cusid>\n" +
                        "  <termtraceno>0</termtraceno>\n" +
                        "  <termauthno>ABC_DEBIT</termauthno>\n" +
                        "  <cusorderid>" + bizseq + "</cusorderid>\n" +
                        "  <chnltrxid>4200000072201804031481918239</chnltrxid>\n" +
                        "  <trxid>111817340000237464</trxid>\n" +
                        "</RequestInfo>";

        System.out.println("确认接口发送报文："+xml);
        return xml;
    }
    /**
     * 获得通过MD5算法的sign值
     * @param valueMap 值MAP
     * @return 加密后的MAC值
     */
    public  String getSign(Map<String, String> valueMap) throws Exception {

        // 将appkey添加至map
        valueMap.put(APPKEY_KEY, APPKEY_VALUE);

        // 剔除加签字段
        valueMap.remove(SIGN_KEY);

        // 对map的key进行排序
        Object[] keyArr = valueMap.keySet().toArray();
        Arrays.sort(keyArr);

        // 对treeMap中的键值对组装字符串
        StringBuilder md5strb = new StringBuilder();
        for (int i = 0; i < keyArr.length; i++) {
            String key = (String) keyArr[i];
            String value = valueMap.get(key);
            if (value != null && value.length() > 0) {
                if (md5strb.length() > 0) {
                    md5strb.append("&");
                }
                md5strb.append(key).append("=").append(value);
            }
        }

        // MD5加签
        String md5 = DigestUtils.md5Hex(md5strb.toString().getBytes("utf-8")).toUpperCase();

        // 返回加签结果
        return md5;
    }
}
