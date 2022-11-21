package com.tsvhlpom.batchdata.vhlplatdatacheck.tool;

import lombok.extern.slf4j.Slf4j;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.jaxen.JaxenXPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 *  * 描述
 *
 * @Author Xinglong Lei
 * @Date 2020/7/7
 */

@Service
@Slf4j
public class CommTools {

    @Value("${VPDCFilePath}")
    public String filePath;

    @Autowired
    private ZipCompressService zipCompressService;

    public String getPath(String month) {
        return filePath + File.separator + month.replace("-","");
    }


    /**
     * 检查路径，如果不存在则创建新的文件夹。
     * @param path
     */
    public void  checkFiles (String path) {
        File DFile = new File(path);
        if (!DFile.exists()) {
            DFile.mkdirs();
        }
    }

    public void deleteFiles(File rootFilePath) {
        if (rootFilePath.exists()) {
            if(rootFilePath.isDirectory()) {
                File files[] = rootFilePath.listFiles();
                int len = files.length;
                for (int i = 0; i < len; i++) {
                    if (files[i].isDirectory()) {
                        deleteFiles(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
            rootFilePath.delete();
        }
    }


    /**
     * 创建文件
     *
     * @param path    文件路径
     * @param txtname 文件名称
     */
    public void creatTxt(String path, String txtname) {
        File txt = new File(path + txtname);
        txt.delete();
        try {
            txt.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("创建文件失败：" + (path + txtname) + "失败原因：" + e.getMessage());
        }

    }
    /**
     * 修改文件内容
     *
     * @param file 文件路径
     * @param str  要修改的内容
     */
    public void editTxtContain(File file, String str) throws Exception {
        try (OutputStream txt = new FileOutputStream(file);){
            txt.write(str.getBytes("GBK"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 字符串转Document对象
     * @param packet
     * @return
     */
    public Document StringToDocument(String packet) throws Exception {
        Document doc = null;
        try(ByteArrayInputStream in = new ByteArrayInputStream(packet.getBytes("GBK"))) {
            SAXBuilder saxBuilder = new SAXBuilder();
            doc = saxBuilder.build(in);
        } catch (Exception e) {
            log.error("字符串转Document出错，报文为："+ packet);
            e.printStackTrace();
            throw e;
        }
        return doc;
    }


    public String getDoumentNode(String  notePath, Document root) {
        XPathFactory factory = JaxenXPathFactory.instance();

        XPathExpression<Object> objs = factory.compile(notePath);

        List<Object> objList = objs.diagnose(root, false).getResult();
        if(objList.size() > 0) {
            Element element = (Element) objList.get(0);
            return element.getValue();
        } else {
            return "";
        }
    }

    /**
     * 平台对账写文件类
     * @param fileName
     * @throws Exception
     */
    public void writeFile(String fileName, String path, String xmlStr) throws Exception {
        String xmlName = fileName + ".xml";
        String zipName = fileName + ".zip";
        checkFiles(path);
        creatTxt(path, xmlName);
        editTxtContain(new File(path + File.separator + xmlName), xmlStr);
        try {
            zipCompressService.compress(path + xmlName, path + zipName);
        } catch (Exception e) {
            log.error("压错出错：" + zipName);
            throw e;
        }
        log.info(zipName + "文件执行完成");
    }


}
