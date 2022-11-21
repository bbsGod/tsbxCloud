package com.tsvhlpom.batchdata.vhlplatdatacheck.tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 文档压缩service
 * @author yzwangc
 *
 */

@Service
@Slf4j
public class ZipCompressService {
	static final int BUFFER = 4*1024;
  /**
   * 压缩文件入口
   * @param srcPathName 文件路径
   * @param destPathName 文件压缩后的路径
   * @throws Exception
   */
    public void compress(String srcPathName,String destPathName) throws Exception{
        File file = new File(srcPathName);
        if (!file.exists()){
            throw new Exception("文件压缩时出错："+ srcPathName + "不存在！");
        }
        ZipOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destPathName);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,new CRC32());
            out = new ZipOutputStream(cos);
            String basedir = "";//基础目录，递归时使用
            compress(file, out, basedir);
        } catch (Exception e) {
        	throw new Exception("文件压缩时出错："+e.getMessage());
        } finally{
        	if(out != null){
        		out.close();
        	}
        }
    }
    /**
     * 根据文件类型选择压缩方法
     * @param file
     * @param out
     * @param basedir
     */
    public void compress(File file, ZipOutputStream out, String basedir) throws Exception{
        /* 判断是目录还是文件 */
        if (file.isDirectory()) {
            log.info("压缩：" + basedir + file.getName());
            compressDirectory(file, out, basedir);
        } else {
            log.info("压缩：" + basedir + file.getName());
            compressFile(file, out, basedir);
        }
    }

    /**
     * 压缩目录
     * @param dir
     * @param out
     * @param basedir
     */
    public void compressDirectory(File dir, ZipOutputStream out, String basedir) throws Exception{
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            /* 递归 */
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 压缩文件
     * @param file
     * @param out
     * @param basedir
     */
    public void compressFile(File file, ZipOutputStream out, String basedir) throws Exception{
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            int count;
            byte data[] = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                out.write(data, 0, count);
            }
        } catch (Exception e) {
        	throw new Exception("文件压缩时出错："+e.getMessage());
        } finally{
        	bis.close();
        }
    }
}
