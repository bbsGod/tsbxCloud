package com.tsvhlpom.dailywork.controller;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.core.utils.file.FileTypeUtils;
import com.tsvhlpom.common.core.utils.file.FileUtils;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.common.log.annotation.Log;
import com.tsvhlpom.common.log.enums.BusinessType;
import com.tsvhlpom.common.security.annotation.RequiresPermissions;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.common.security.utils.SecurityUtils;
import com.tsvhlpom.dailywork.domain.Daily_employee;
import com.tsvhlpom.dailywork.domain.Daily_worklog;
import com.tsvhlpom.dailywork.domain.LogAnalysis;
import com.tsvhlpom.dailywork.service.Daily_worklogService;
import com.tsvhlpom.system.api.RemoteFileService;
import com.tsvhlpom.system.api.domain.SysFile;
import com.tsvhlpom.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/worklog")
public class Daily_worklogController extends BaseController {

    @Autowired
    private Daily_worklogService worklogService;
    @Autowired
    private RemoteFileService remoteFileService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/getWorkLogList")
    public TableDataInfo getWorkLogList(Daily_worklog worklog){
        logger.info("查询worklog列表");
        startPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        List<Daily_worklog> worklogList = null;
        try{
            worklog.setQuery_time(sdf.format(new Date()));
            worklogList = worklogService.getWorkLogList(worklog);
            worklogList.stream().forEach((worklog1 -> worklog1.setEdit(false)));
        }catch (Exception e){
            logger.error("获取worklog列表出错");
            e.printStackTrace();
        }
        return getDataTable(worklogList);
    }
    @RequestMapping("/getWorkLog/{pkid}")
    public R<Daily_worklog> getWorkLog(@PathVariable("pkid") String pkid){
        return R.ok(worklogService.getWorkLog(pkid));
    }

    @RequestMapping("/saveWorkLog")
    //@RequiresPermissions("dailywork:worklog:add")
    //@Log(title = "每日工作(worklog)",businessType = BusinessType.INSERT)
    public AjaxResult saveWorkLog(@RequestBody Daily_worklog worklog){
        log.info("保存worklog start");
        try{

            //worklog.setEmp_id(user.getSysUser().get);
            worklogService.saveWorkLog(worklog);
        }catch (Exception e){
            log.error("保存worklog错误");
            e.printStackTrace();
            return AjaxResult.error("保存失败");
        }
        log.info("保存worklog end");
        return AjaxResult.success("保存成功");
    }
    @RequestMapping("/updateWorkLog")
    //@RequiresPermissions("dailywork:worklog:edit")
    //@Log(title = "每日工作(worklog)",businessType = BusinessType.UPDATE)
    public AjaxResult updateWorkLog(@RequestBody Daily_worklog worklog){
        log.info("更新worklog  start");
        try{
            worklogService.updateWorkLog(worklog);
        }catch (Exception e){
            log.error("更新worklog错误");
            e.printStackTrace();
            return AjaxResult.error("更新失败");
        }
        log.info("更新worklog end");
        return AjaxResult.success("更新成功");
    }
    @RequestMapping("/deleteWorkLog/{pkids}")
    //@RequiresPermissions("dailywork:worklog:remove")
    //@Log(title = "每日工作(worklog)",businessType = BusinessType.DELETE)
    public AjaxResult deleteWorkLog(@PathVariable("pkids") String[] pkids){
        log.info("删除worklog  start");
        try{
            worklogService.deleteWorkLog(pkids);
        }catch (Exception e){
            log.error("删除worklog错误");
            e.printStackTrace();
            return AjaxResult.error("删除失败");
        }
        log.info("删除worklog end");
        return AjaxResult.success("删除成功");
    }

    /**
     * 日志附件上传
     */
    @RequestMapping("/uploadFile")
    //@Log(title = "每日工作(worklog)",businessType = BusinessType.IMPORT)
    public AjaxResult uploadFile(@RequestParam("pkid") String pkid, @RequestParam("file") MultipartFile file){
        System.out.println(pkid);
        if (!file.isEmpty())
        {
            R<SysFile> fileResult = remoteFileService.upload(file);
            if (StringUtils.isNull(fileResult) || StringUtils.isNull(fileResult.getData()))
            {
                return AjaxResult.error("文件服务异常，请联系管理员");
            }
            String url = fileResult.getData().getUrl();
            worklogService.updateWorkLogPath(pkid,url);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("filePath", url);
            return ajax;
        }
        return AjaxResult.error("附件上传异常，请联系管理员");
    }
    @RequestMapping(value = "/showAttchment",method = RequestMethod.GET)
    public AjaxResult showAttchment (HttpServletRequest request, HttpServletResponse response) throws Exception {

        OutputStream outputStream = null;
        InputStream inputStream = null;
        String path = "";
        String filename = "";
        File file = null;
        try{
            String pkid = request.getParameter("pkid");
            log.info("预览的附件pkid："+pkid);
            Daily_worklog worklog =  worklogService.getWorkLog(pkid);
            if(worklog !=null ){
                path = worklog.getLog_attachment_path();
            }else{
                return AjaxResult.error("附件不存在");
            }
            if(path !=null && !"".equals(path)){
                file = new File(path);
            }
            String fileType = FileTypeUtils.getFileType(file);
            response.setHeader("Content-type", fileType+";charset=UTF-8");
            //通过zip解压缩获得PDF文件路径filePath
            response.setCharacterEncoding("utf-8");
            response.setContentType(fileType);
            outputStream = response.getOutputStream();
            response.setHeader("Content-Disposition","attachment;");
            FileUtils.writeBytes(path,outputStream);

        }catch (Exception e){
            log.error("附件预览错误");
            e.printStackTrace();
            return AjaxResult.error("预览失败");
        }
        return null;
    }

    /**
     * 统计分析 日志
     * @param
     * @return
     */
    @RequestMapping("/logAnalysis")
    public AjaxResult logAnalysis(@RequestBody LogAnalysis analysis){
        List<LogAnalysis> logAnalysisList = null;
        try{
             logAnalysisList = worklogService.logAnalysis(analysis);
        }catch (Exception e){
            log.error("统计分析错误");
            e.printStackTrace();
            return AjaxResult.error("统计分析出错，请联系系统管理员");
        }
        return AjaxResult.success(logAnalysisList);
    }

    @RequestMapping("/exportWorkLog")
    public AjaxResult exportWorkLog(LogAnalysis analysis,HttpServletResponse response){
        log.info("导出工作日志excel  start");
        AjaxResult ajaxResult = new AjaxResult();
        try{
            ajaxResult =  worklogService.exportWorkLog(analysis,response);
        }catch (Exception e){
            log.error("导出工作日志excel error:"+e.getMessage());
            e.printStackTrace();
        }

        log.info("导出工作日志excel end");
        return ajaxResult;
    }
}
