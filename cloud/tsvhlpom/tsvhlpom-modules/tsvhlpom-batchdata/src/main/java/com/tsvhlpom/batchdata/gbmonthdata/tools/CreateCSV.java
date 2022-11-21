package com.tsvhlpom.batchdata.gbmonthdata.tools;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CreateCSV {



    /**
     * 导出CSC文件  一次导出一天， 第一次添加数据头，以后不再添加。每次重新调用方法都会重新删除已经生成CSV并重新生成
     * @param dataList
     * @param path
     * @param prefix
     * @param headerFlag
     */
    public void createDataGBListExcel(List<Map<String, Object>> dataList, String path, String prefix, Boolean headerFlag) throws Exception {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;// 缓冲流

        try {
            out = new FileOutputStream(path + prefix + ".csv", true);
            osw = new OutputStreamWriter(out, "GBK");
            bw = new BufferedWriter(osw);
            //第一次数据进入的时候生成列标题，并添加到缓存区
            if(headerFlag) {
                Map<String, Object> map = dataList.get(0);
                for(String key: map.keySet()) {
                    bw.append("\"" + key + "\"").append(",");
                }
            }
            //添加每列的数据以  , 隔开的形式
            for (Map<String, Object> map : dataList) {
                //首先增加上一行的换行
                bw.append("\n");
                for(Object obj : map.values()) {
                    String val = obj == null ? "" : String.valueOf(obj);
                    bw.append("\"" + val + "\"").append(",");
                }
            }
            bw.flush();

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /***
     * 异常数据生成文本
     * @param errList
     * @param path
     * @return
     */
    public void createErrorTxt(List<String> errList,String path) throws Exception {
        //如果没有异常数据直接return  不再开 输入输出流
        if(errList.size() == 0) {
            return ;
        }
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter errBuffer = null;
        try {
            //异常数据会直接写到文本中，并将Map中的该列删除,
            fileOutputStream = new FileOutputStream(path + "光博异常数据.txt", true);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            errBuffer = new BufferedWriter(outputStreamWriter);
            for (String errStr: errList) {
                errBuffer.append(errStr);
                errBuffer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw  e;
        } finally {
            try {
                if (errBuffer != null) {
                    errBuffer.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 压缩文件
     * @throws Exception
     */
    public void compressedFile(String path) throws Exception {


        File dFile = new File(path);
        ArrayList<File> files = new ArrayList(Arrays.asList(dFile.listFiles()));
        ZipFile zipFile = new ZipFile(path + "光博数据" + ".zip");
        //参数设置
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

        //压缩
        zipFile.addFiles(files, zipParameters);
    }

    /**
     * 检查路径，如果存在则删除下面所有的内容，如果不存在则创建新的文件夹。
     * @param path
     */
    public void  checkFils (String path) {
        File DFile = new File(path);
        if (!DFile.exists()) {
            DFile.mkdirs();
        } else {
            for(File file : (DFile.listFiles())) {
                //保留错误日志
                if(file.getName().indexOf("err") == -1) {
                    file.delete();
                }
            }
        }
    }


}
