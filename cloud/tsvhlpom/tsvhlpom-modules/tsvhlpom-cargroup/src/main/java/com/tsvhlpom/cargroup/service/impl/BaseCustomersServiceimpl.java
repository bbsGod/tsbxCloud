package com.tsvhlpom.cargroup.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tsvhlpom.cargroup.domain.BaseCustomers;
import com.tsvhlpom.cargroup.domain.BasePerson;
import com.tsvhlpom.cargroup.domain.BasePrice;
import com.tsvhlpom.cargroup.domain.BaseVisit;
import com.tsvhlpom.cargroup.mapper.BaseCustomersMapper;
import com.tsvhlpom.cargroup.mapper.BasePersonMapper;
import com.tsvhlpom.cargroup.mapper.BaseVisitMapper;
import com.tsvhlpom.cargroup.service.BaseCustomersService;
import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.redis.service.RedisService;
import com.tsvhlpom.common.security.utils.DictUtils;
import com.tsvhlpom.system.api.domain.SysDictData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BaseCustomersServiceimpl implements BaseCustomersService {
    @Autowired
    private BaseCustomersMapper baseCustomersMapper;
    @Autowired
    private BaseVisitMapper baseVisitMapper;

    @Autowired
    private BasePersonMapper basePersonMapper;
    @Override
    public void insert(BaseCustomers baseCustomers) throws Exception {
        if(checkCustomerisExists(baseCustomers,"ADD")){
            throw new Exception("您的车辆已在我司VIP客户清单内，无需重复录入。");
        }
        this.setIsVisit(baseCustomers);
        /*if(baseCustomers.getC_visit_status() !=null && !"".equals(baseCustomers.getC_visit_status())){
            baseCustomers.setC_is_visit("Y");
        }*/
        baseCustomersMapper.insert(baseCustomers);
        this.addBaseVisit(baseCustomers);
    }

    /**
     * 校验是否存在客户
     * @return
     * @throws
     */
    public boolean checkCustomerisExists(BaseCustomers newCustomersVO,String operType) throws Exception{
        boolean isExists = false;
        List<BaseCustomers> basCustomersList = null;
        try{
            if(null != newCustomersVO.getC_plate_no() && !"".equals(newCustomersVO.getC_plate_no())){
                basCustomersList= baseCustomersMapper.checkCustomerisExists(newCustomersVO.getC_sp_cust_id(),"",newCustomersVO.getC_plate_no());
                if("UPDATE".equals(operType) && basCustomersList.size() >0) {
                    if(!basCustomersList.get(0).getC_pk_id().equals(newCustomersVO.getC_pk_id())) {
                        isExists = true;
                    }
                }
                if("ADD".equals(operType) && basCustomersList.size() > 0 ){
                    isExists = true;
                }
            }
            if(null != newCustomersVO.getC_frm_no() && !"".equals(newCustomersVO.getC_frm_no())){
                basCustomersList= baseCustomersMapper.checkCustomerisExists(newCustomersVO.getC_sp_cust_id(),newCustomersVO.getC_frm_no(),"");
                if("UPDATE".equals(operType) && basCustomersList.size() > 0) {
                    if(!basCustomersList.get(0).getC_pk_id().equals(newCustomersVO.getC_pk_id())) {
                        isExists = true;
                    }
                }
                if("ADD".equals(operType) && basCustomersList.size() > 0 ){
                    isExists = true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExists;
    }
    @Override
    public void update(BaseCustomers baseCustomers) throws Exception {

        if(checkCustomerisExists(baseCustomers,"UPDATE")){
            throw new Exception("您的车辆已在我司VIP客户清单内，无需重复录入。");
        }
        this.setIsVisit(baseCustomers);
        /*if(baseCustomers.getC_visit_status() !=null && !"".equals(baseCustomers.getC_visit_status())){
            baseCustomers.setC_is_visit("Y");
        }*/
        baseCustomersMapper.update(baseCustomers);
        this.addBaseVisit(baseCustomers);
    }

    public void addBaseVisit(BaseCustomers baseCustomers){
        BaseVisit baseVisit = new BaseVisit();
        baseVisit.setC_id(baseCustomers.getC_pk_id());
        baseVisit.setC_visit_emp(baseCustomers.getC_visit_emp());
        baseVisit.setC_visit_status(baseCustomers.getC_visit_status());
        baseVisit.setC_visit_Tm(new Date());
        baseVisit.setC_remark(baseCustomers.getC_remark());
        baseVisitMapper.insert(baseVisit);
    }
    @Override
    public void updateVisit(BaseCustomers baseCustomers) {
        baseCustomersMapper.updateVisit(baseCustomers);
        this.addBaseVisit(baseCustomers);
    }

    @Override
    public void delete(String[] c_pk_ids) {
        baseCustomersMapper.delete(c_pk_ids);
    }

    @Override
    public BaseCustomers getBaseCustomers(String c_pk_id) {
        return baseCustomersMapper.getBaseCustomers(c_pk_id);
    }

    @Override
    public List<BaseCustomers> getBaseCustomersList(BaseCustomers baseCustomers) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        if(baseCustomers.getC_start_date() !=null && baseCustomers.getC_end_date() !=null
            && !"".equals(baseCustomers.getC_start_date()) && !"".equals(baseCustomers.getC_end_date())){
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,Integer.valueOf(baseCustomers.getC_start_date()));
            String startDate =sdf.format(calendar.getTime());
            Calendar calendar1 = Calendar.getInstance();
            calendar1.add(Calendar.DATE,Integer.valueOf(baseCustomers.getC_end_date()));
            String endDate = sdf.format(calendar1.getTime());
            baseCustomers.getParams().put("startDate",startDate);
            baseCustomers.getParams().put("endDate",endDate);
            /*for(BaseCustomers baseCustomers1:baseCustomersList){
                Calendar calendar2 = Calendar.getInstance();
                Date insBgnTm = baseCustomers1.getT_insrnc_bgn_tm();
                calendar2.set(Calendar.MONTH,insBgnTm.getMonth());
                calendar2.set(Calendar.DATE,insBgnTm.getDate());
                System.out.println("start:"+sdf.format(startDate));
                System.out.println("end:"+sdf.format(endDate));
                System.out.println("保险到期日:"+sdf.format(calendar2.getTime()));
                if(calendar2.getTime().after(startDate) && calendar2.getTime().before(endDate)){
                    baseCustomersList_new.add(baseCustomers1);
                }
            }*/

            /*baseCustomersList.stream().filter( baseCustomers1 -> {
                Calendar calendar2 = Calendar.getInstance();
               Date insBgnTm = baseCustomers1.getT_insrnc_bgn_tm();
                calendar2.set(Calendar.MONTH,insBgnTm.getMonth());
                calendar2.set(Calendar.DATE,insBgnTm.getDate());
                if(calendar2.getTime().after(startDate) && calendar2.getTime().before(endDate)){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());*/
        }
        List<BaseCustomers> baseCustomersList =  baseCustomersMapper.getBaseCustomersList(baseCustomers);
        //判断是否回访成功
      /*  List<SysDictData> dictDataList =  DictUtils.getDictCache("cargroup_visit_succ");
        String succStr = dictDataList.get(0).getDictValue();*/
        baseCustomersList.stream().forEach((baseCustomers1 -> {
            //判断是否企业微信好友
            if (baseCustomers1.getC_is_wxfriend() == null || "".equals(baseCustomers1.getC_is_wxfriend())) {
                baseCustomers1.setC_is_wxfriend("N");
            }
            if(baseCustomers1.getC_plate_no() !=null && !"".equals(baseCustomers1.getC_plate_no())){
                //获取最新的止保时间
                int policyCnt   = baseCustomersMapper.selectValidPolicy(baseCustomers1.getC_plate_no());
                if(policyCnt > 0){
                    baseCustomers1.setC_is_renew("Y");
                } else {
                    baseCustomers1.setC_is_renew("N");
                }
            }
            /*if((baseCustomers1.getC_visit_status() !=null && !"".equals(baseCustomers1.getC_visit_status()))){
                if(succStr.indexOf(baseCustomers1.getC_visit_status()) > -1){
                    baseCustomers1.setC_is_visit("Y");
                }else {
                    baseCustomers1.setC_is_visit("N");
                }
            }*/
        }));
        return baseCustomersList;
    }

    public void setIsVisit(BaseCustomers baseCustomers1){
        List<SysDictData> dictDataList =  DictUtils.getDictCache("cargroup_visit_succ");
        String succStr = dictDataList.get(0).getDictValue();
        if((baseCustomers1.getC_visit_status() !=null && !"".equals(baseCustomers1.getC_visit_status()))){
            if(succStr.indexOf(baseCustomers1.getC_visit_status()) > -1){
                baseCustomers1.setC_is_visit("Y");
            }else {
                baseCustomers1.setC_is_visit("N");
            }
        }
    }

    public void export(List<BaseCustomers> list, HttpServletResponse response) throws Exception {
        XSSFWorkbook wb = null;
        OutputStream out = null;
        try{
            out = response.getOutputStream();
            ClassPathResource cpr = new ClassPathResource("/template/spcust.xlsx");
            wb = new XSSFWorkbook(cpr.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);
            sheet.setVerticallyCenter(true);
            sheet.setHorizontallyCenter(true);
            XSSFCellStyle setBorder = wb.createCellStyle();
            Integer startRow = 3;
            Row row = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            List<SysDictData> dictList = DictUtils.getDictCache("sys_cargroup_custTpyList");




            for(int i=0;i<list.size();i++){
                row = sheet.createRow(startRow+i);
                BaseCustomers baseCustomers = list.get(i);
                BasePerson basePerson =  basePersonMapper.getPersonById(baseCustomers.getC_sp_cust_id());
                if(basePerson ==null){
                    throw new Exception(baseCustomers.getC_sp_cust_nme()+"在总公司清单中不存在，请先维护清单");
                }else{
                    row.createCell(0).setCellValue(i+1);//序号
                    row.createCell(1).setCellValue(basePerson.getName());//维护人姓名
                    row.createCell(2).setCellValue(basePerson.getDept());//部门名称
                    row.createCell(3).setCellValue(basePerson.getSp_name());//重点客户标识
                    row.createCell(4).setCellValue(baseCustomers.getC_nme());
                    row.createCell(5).setCellValue(baseCustomers.getC_mobile());
                    row.createCell(6).setCellValue(baseCustomers.getC_reg_owner());
                    row.createCell(7).setCellValue(baseCustomers.getC_plate_no());
                    row.createCell(8).setCellValue(baseCustomers.getC_fst_reg_ym());
                    row.createCell(9).setCellValue(baseCustomers.getC_model_nme());
                    //到期日
                    if(baseCustomers.getT_insrnc_bgn_tm() !=null){
                        row.createCell(10).setCellValue(sdf.format(baseCustomers.getT_insrnc_bgn_tm()));
                        //是否进入续保期间
                        calendar.set(Calendar.MONTH,baseCustomers.getT_insrnc_bgn_tm().getMonth());
                        calendar.set(Calendar.DATE,baseCustomers.getT_insrnc_bgn_tm().getDate());
                        Date diff = calendar.getTime();
                        row.createCell(11).setCellValue( Math.floor((diff.getTime() - now.getTime())/(1000*60*60*24)));
                    }
                    if(baseCustomers.getC_visit_Tm() !=null){
                        row.createCell(12).setCellValue(sdf.format(baseCustomers.getC_visit_Tm()));
                    }
                    row.createCell(13).setCellValue(baseCustomers.getC_visit_emp());
                    row.createCell(14).setCellValue(baseCustomers.getC_remark());//回访情况
                    row.createCell(15).setCellValue(baseCustomers.getC_price_status());
                    if(baseCustomers.getC_is_wxfriend() !=null && "Y".equals(baseCustomers.getC_is_wxfriend())){
                        row.createCell(16).setCellValue("是");
                    }else{
                        row.createCell(16).setCellValue("否");
                    }
                    SysDictData  a = dictList.stream().filter(sysDictData -> sysDictData.getDictValue().equals(baseCustomers.getC_cus_typ())).findAny().orElse(null);
                    if(a !=null){
                        row.createCell(17).setCellValue(a.getDictLabel());
                    }else{
                        row.createCell(17).setCellValue("/");
                    }


                }
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");

            wb.write(out);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
            if (wb != null)
            {
                try
                {
                    wb.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
            if (out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }
    public void updateVisitInfo(){
        baseCustomersMapper.updateVisitInfo();
    }

    @Override
    public List getSpCust(String query) {
        List<BaseCustomers> list = baseCustomersMapper.getSpCust(query);
        JSONArray jaonArray = new JSONArray();
        list.stream().forEach( cust ->{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",cust.getC_sp_cust_id());
            jsonObject.put("value",cust.getC_sp_cust_nme());
            jaonArray.add(jsonObject);
        });
        return jaonArray;
    }

    @Override
    public String updateVisitInfoByExport(List<BaseCustomers> customersList, boolean updateSupport) {
        if (StringUtils.isNull(customersList) || customersList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BaseCustomers baseCustomers : customersList)
        {
            try
            {
                // 根据重点客户标识名称及行驶证车主及车牌号获取 历史数据

                List<BaseCustomers> baseCustomers_oldList =  baseCustomersMapper.getListForUpdate(baseCustomers);
                if (baseCustomers_oldList == null || baseCustomers_oldList.size() == 0)
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、回访表，行驶证车主： " + baseCustomers.getC_reg_owner()+ ",车牌号："+baseCustomers.getC_plate_no()+" ,不存在，请核实");
                }
                else
                {
                    BaseCustomers baseCustomers_old = baseCustomers_oldList.get(0);
                    baseCustomers_old.setC_visit_emp(baseCustomers.getC_visit_emp());
                    baseCustomers_old.setC_visit_Tm(baseCustomers.getC_visit_Tm());
                    baseCustomers_old.setC_remark(baseCustomers.getC_remark());
                    baseCustomers_old.setC_price_status(baseCustomers.getC_price_status());
                    baseCustomers_old.setC_is_visit("Y");
                    baseCustomersMapper.update(baseCustomers_old);
                    //同步新增回访详情
                    this.addBaseVisit(baseCustomers_old);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、回访表，行驶证车主： " + baseCustomers.getC_reg_owner()+ ",车牌号："+baseCustomers.getC_plate_no()+" ,更新成功");
                }

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、回访表，行驶证车主： " + baseCustomers.getC_reg_owner()+ ",车牌号："+baseCustomers.getC_plate_no()+" ,导入失败";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
