package com.tsvhlpom.meetingpreset.controller;

import com.tsvhlpom.common.core.domain.R;
import com.tsvhlpom.common.core.utils.poi.ExcelUtil;
import com.tsvhlpom.common.core.web.controller.BaseController;
import com.tsvhlpom.common.core.web.domain.AjaxResult;
import com.tsvhlpom.common.core.web.page.TableDataInfo;
import com.tsvhlpom.meetingpreset.domain.Person;
import com.tsvhlpom.meetingpreset.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/getPersonList")
    TableDataInfo getPersonList(Person person){
        List<Person> personList = null;
        startPage();
        try{
            personList =  personService.getPersonList(person);
        }catch (Exception e){
            e.printStackTrace();
        }
        return getDataTable(personList);
    }

    @RequestMapping("/getPersonById/{pk_id}")
    public R getPersonById(@PathVariable("pk_id") String pk_id){
        return R.ok(personService.getPersonById(pk_id));
    }
    @RequestMapping("/save")
    public AjaxResult save(@RequestBody Person person){
        try{
            personService.save(person);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/update")
    public AjaxResult update(@RequestBody Person person){
        try{
            personService.update(person);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
    @RequestMapping("/delete/{pk_ids}")
    public AjaxResult delete(@PathVariable("pk_ids") String[] pk_ids){
        try{
            personService.delete(pk_ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) throws IOException {
        logger.info("模板下载");
        ExcelUtil<Person> util = new ExcelUtil<Person>(Person.class);
        util.importTemplateExcel(response,"员工信息");
    }
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        logger.info("importData文件上传 开始");
        ExcelUtil<Person> util = new ExcelUtil<Person>(Person.class);
        String message = "";
        try{
            List<Person> personList = util.importExcel(file.getInputStream());
            message = personService.importData(personList, updateSupport, "");
            logger.info("importData文件上传 完成");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件上传失败，失败原因："+e.getMessage());
            return AjaxResult.error(e.getMessage());
        }
        logger.info("importData文件上传 结束");
        return AjaxResult.success(message);
    }



}
