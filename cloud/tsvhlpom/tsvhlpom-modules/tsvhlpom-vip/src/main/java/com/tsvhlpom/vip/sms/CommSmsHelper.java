package com.tsvhlpom.vip.sms;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 短信功能帮助类
 * @author jitao
 */
@Component
public class CommSmsHelper {
    /**
     * 回应代码
     */
    public static String RESPONSE_CODE = "ResponseCode";

    /**
     * 回应信息
     */
    public static String RESPONSE_MESSAGE = "ResponseMessage";

    /**
     * 编码
     */
    private static String ENCODING = "UTF-8";

    /**
     * 实例
     */
    private static CommSmsHelper instance;
    /**
     *
     */
    @Value("${sms.url}")
    private String url;

    @Value("${sms.from}")
    private String from;

    @Value("${sms.pwd}")
    private String pwd;

    @Value("${sms.type}")
    private String type;
    /**
     * 默认构造方法
     */
    public CommSmsHelper() {
        // do noting.
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获得实例
     * @return 实例
     */
    public static CommSmsHelper getInstance() {
        if (instance == null) {
            instance = new CommSmsHelper();
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        CommSmsHelper s =new CommSmsHelper();
        s.sendSms("17600409148","","ereirueirtrt");
    }


    /**
     * 发送短信
     * @param phoneNo 电话号码
     * @param smsTypeConfGroup  短信通道类型分组
     * @param content 短信内容
     * @return 返回结果MAP
     */
    public Map<String, String> sendSms(String phoneNo, String smsTypeConfGroup, String content) throws Exception {
        return this.sendSms(phoneNo, smsTypeConfGroup, content, null);
    }

    /**
     * 发送短信
     * @param phoneNo 电话号码
     * @param smsTypeConfGroup  短信通道类型分组
     * @param content 短信内容
     * @param linkId 关联ID[选填]
     * @return 返回结果MAP   Map的ResponseCode的值为02时，说明配置开关关闭。如果需要发短信请配置数据库开关。
     */
    public Map<String, String> sendSms(String phoneNo, String smsTypeConfGroup, String content, String linkId) throws Exception {

        Map<String, String> resultMap = new HashMap<String, String>();

        // 若lindId为空，则默认生成一个
        if (linkId == null) {
            linkId = "CB" + (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
        }

        // 转换发送报文
        String sendXml = this.transSendXml(phoneNo, smsTypeConfGroup, content, linkId);

        // 发送
        String responseXml = this.httpReuqest(sendXml);

        // 转换回应报文
        resultMap = this.transResponseXml(responseXml);

        // 返回结果

        return resultMap;
    }

    /**
     * 转换回应报文
     * @param responseXml 回应报文XML
     * @return 结果MAP
     */
    private Map<String, String> transResponseXml(String responseXml) throws Exception {

        // 转换为DOM对象
        StringReader sr = new StringReader(responseXml);
        InputSource is = new InputSource(sr);
        Document document = (new SAXBuilder()).build(is);

        // 根节点
        Element rootEle = document.getRootElement();

        // 回应代码
        String responseCode = rootEle.getChildTextTrim("ResponseCode");

        // 回应信息
        String responseMessage = rootEle.getChildTextTrim("ResponseMessage");

        // 生成结果MAP
        HashMap<String, String> resultMap = new HashMap<String, String>();
        resultMap.put(RESPONSE_CODE, responseCode);
        resultMap.put(RESPONSE_MESSAGE, responseMessage);

        return resultMap;
    }

    /**
     * 转换发送报文
     * @param phoneNo 电话号码
     * @param smsTypeConfGroup  短信通道类型分组
     * @param content 短信内容
     * @param linkId 关联ID
     * @return 发送报文字符串
     */
    private String transSendXml(String phoneNo, String smsTypeConfGroup, String content, String linkId) throws Exception {

        // 电话号码
        Element phoneEle = new Element("Phone");
        phoneEle.setText(phoneNo);

        // 短信通道类型
        String smsType = "01";
        Element smsTypeEle = new Element("SmsType");
        smsTypeEle.setText(smsType);

        // 短信内容
        Element messageEle = new Element("Message");
        messageEle.setText(content);

        // 关联ID
        Element linkidEle = new Element("Linkid");
        linkidEle.setText(linkId);

        // 根节点
        Element rootEle = new Element("Root");
        rootEle.addContent(phoneEle);
        rootEle.addContent(smsTypeEle);
        rootEle.addContent(messageEle);
        rootEle.addContent(linkidEle);

        // 文档对象
        Document document = new Document(rootEle);

        // 格式化输出
        Format format = Format.getRawFormat();
        format.setEncoding(ENCODING);
        XMLOutputter xmlout = new XMLOutputter(format);
        StringWriter strWriter = new StringWriter();
        xmlout.output(document, strWriter);

        return strWriter.toString();
    }

    /**
     * 请求核保规则
     * @param sendStr 输入参数对象
     * @return 返回报文
     */
    private String httpReuqest(String sendStr) throws Exception {

        // 拼装发送数据
        String sendData = "";
        sendData = "from=" + URLEncoder.encode(from, ENCODING);               // 参数：来源账户
        sendData = sendData + "&pwd=" + URLEncoder.encode(pwd, ENCODING);     // 参数：密码
        sendData = sendData + "&type=" + URLEncoder.encode(type, ENCODING);   // 参数：类型
        sendData = sendData + "&xml=" + URLEncoder.encode(sendStr, ENCODING); // 参数：XML报文体

        // 创建连接
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

        // 设置连接和读取的超时时间
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);

        // 设置连接属性
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");

        // 发送数据
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
                conn.disconnect();
            }
        } else {
            conn.disconnect();
            throw new Exception("请求短信平台失败：" + conn.getResponseCode());
        }

        return returnContent.toString();
    }
}


