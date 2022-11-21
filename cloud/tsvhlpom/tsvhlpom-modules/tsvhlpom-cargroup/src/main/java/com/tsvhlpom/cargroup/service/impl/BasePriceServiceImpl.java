package com.tsvhlpom.cargroup.service.impl;

import com.tsvhlpom.cargroup.constans.AreaConstans;
import com.tsvhlpom.cargroup.domain.BaseCustomers;
import com.tsvhlpom.cargroup.domain.BasePerson;
import com.tsvhlpom.cargroup.domain.BasePrice;
import com.tsvhlpom.cargroup.mapper.BaseCustomersMapper;
import com.tsvhlpom.cargroup.mapper.BasePersonMapper;
import com.tsvhlpom.cargroup.mapper.BasePriceMapper;
import com.tsvhlpom.cargroup.service.BasePriceService;
import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BasePriceServiceImpl implements BasePriceService {

    @Autowired
    private BasePriceMapper basePriceMapper;
    @Autowired
    private BasePersonMapper basePersonMapper;
    @Autowired
    private BaseCustomersMapper baseCustomersMapper;
    @Override
    public List<BasePrice> getBasePriceList(BasePrice basePrice) {
        return basePriceMapper.getBasePriceList(basePrice);
    }

    @Override
    public BasePrice getPriceById(String pk_id) {
        return basePriceMapper.getPriceById(pk_id);
    }

    @Override
    public void save(BasePrice basePrice) {
        basePriceMapper.save(basePrice);
        this.setPriceStatus(basePrice);
    }

    @Override
    public void update(BasePrice basePrice) {
        basePriceMapper.update(basePrice);
        this.setPriceStatus(basePrice);
    }

    @Override
    public void delete(String[] pk_ids) {
        basePriceMapper.delete(pk_ids);
    }

    //回填customers的报价状态
    public void setPriceStatus(BasePrice basePrice){
        BaseCustomers baseCustomers =  baseCustomersMapper.getBaseCustomersByPkId(basePrice.getCustomer_id());
        if(baseCustomers ==null){
            BaseCustomers param = new BaseCustomers();
            param.setC_reg_owner(basePrice.getInsured_name());
            param.setC_sp_cust_nme(basePrice.getSp_cust_name());
            param.setC_plate_no(basePrice.getPlate_no());
            List<BaseCustomers> customersList = baseCustomersMapper.getListForUpdate(param);
            if(customersList.size() == 0){
                param.setC_plate_no(null);
                customersList = baseCustomersMapper.getListForUpdate(param);
            }
            if(customersList.size() > 0){
                baseCustomers =customersList.get(0);
                basePrice.setCustomer_id(baseCustomers.getC_pk_id());
                basePriceMapper.update(basePrice);
            }

        }
        if(baseCustomers != null){
            //同步更新车牌号和报价状态
            baseCustomers.setC_plate_no(basePrice.getPlate_no());
            baseCustomers.setC_price_status(basePrice.getC_price_status());
            baseCustomersMapper.update(baseCustomers);
        }
    }
    @Override
    public String importData(List<BasePrice> basePriceList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(basePriceList) || basePriceList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BasePrice basePrice : basePriceList)
        {
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<BasePrice> basePriceList_old =  basePriceMapper.getBasePriceList(basePrice);
                if (basePriceList_old == null || basePriceList_old.size() == 0)
                {

                   basePriceMapper.save(basePrice);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、报表信息" + basePrice.getPlate_no() + " 导入成功");

                }
                else if (updateSupport)
                {
                    basePrice.setPk_id(basePriceList_old.get(0).getPk_id());
                    basePriceMapper.update(basePrice);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、报表信息" + basePrice.getPlate_no() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、报表信息 " + basePrice.getPlate_no()+ " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、报表信息 " + basePrice.getPlate_no() + " 导入失败";
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


    public BasePrice price(BaseCustomers baseCustomers) throws Exception {

        BasePerson basePerson =  basePersonMapper.getPersonById(baseCustomers.getC_sp_cust_id());
        if(basePerson == null){
          throw new Exception("请先维护总公司清单");
        }
        BasePrice basePrice = new BasePrice();
        basePrice.setDept_name(basePerson.getDept());
        basePrice.setName(basePerson.getName());
        basePrice.setSp_cust_name(basePerson.getSp_name());
        basePrice.setPlate_no(baseCustomers.getC_plate_no());
        basePrice.setInsured_name(baseCustomers.getC_reg_owner());
        basePrice.setPhone_no(baseCustomers.getC_mobile());
        basePrice.setMake_dept(AreaConstans.areaMap.get(baseCustomers.getC_plate_no().substring(0,2)));
        basePrice.setIsNewEnery("N");
        basePrice.setIsChange("N");
        basePrice.setIsCli("Y");
        basePrice.setIsVi("Y");
        basePrice.setIsCarLoss("Y");
        basePrice.setJq_rate(setJQRate(basePrice));
        basePrice.setSy_fee_rate(setSYRate(basePrice));
        basePrice.setCustomer_id(baseCustomers.getC_pk_id());
        return basePrice;
    }

    public Double setJQRate(BasePrice basePrice){
        double jqrate = 0.00;
        String dept = basePrice.getMake_dept();
        if("Y".equals(basePrice.getIsChange())  && "Y".equals(basePrice.getIsCli()) && "Y".equals(basePrice.getIsVi())){
            if("济南".equals(dept) || "济宁".equals(dept) || "淄博".equals(dept)|| "泰安".equals(dept) || "滨州".equals(dept) || "日照".equals(dept)
                || "莱芜".equals(dept) || "德州".equals(dept) || "临沂".equals(dept) || "潍坊".equals(dept)){
                jqrate = 0.12;
            }
            if("聊城".equals(dept) || "烟台".equals(dept) || "东营".equals(dept) || "枣庄".equals(dept)){
                jqrate = 0.1;
            }
            if("菏泽".equals(dept)){
                jqrate = 0.13;
            }
            if("威海".equals(dept)){
                jqrate = 0.08;
            }
        } else if("N".equals(basePrice.getIsChange())  && "Y".equals(basePrice.getIsCli()) && "Y".equals(basePrice.getIsVi())){
            if("济南".equals(dept) || "济宁".equals(dept) || "淄博".equals(dept)|| "泰安".equals(dept) || "滨州".equals(dept) || "日照".equals(dept)
                    || "莱芜".equals(dept) || "临沂".equals(dept)){
                jqrate = 0.22;
            }
            if("聊城".equals(dept) || "烟台".equals(dept) || "东营".equals(dept) || "枣庄".equals(dept)){
                jqrate = 0.2;
            }
            if("威海".equals(dept)){
                jqrate = 0.18;
            }
            if("菏泽".equals(dept)){
                jqrate = 0.23;
            }
            if("德州".equals(dept)){
                jqrate = 0.28;
            }
            if("潍坊".equals(dept)){
                jqrate = 0.24;
            }
        }else if("Y".equals(basePrice.getIsCli())){
            if("济南".equals(dept) || "聊城".equals(dept) || "东营".equals(dept)|| "枣庄".equals(dept) || "莱芜".equals(dept) ){
                jqrate = 0.2;
            }
            if("济宁".equals(dept) || "淄博".equals(dept)){
                jqrate = 0.22;
            }
            if("烟台".equals(dept) || "威海".equals(dept) || "日照".equals(dept)){
                jqrate = 0.0377;
            }
            if("泰安".equals(dept)){
                jqrate = 0.0677;
            }
            if("滨州".equals(dept)){
                jqrate = 0.1;
            }
            if("菏泽".equals(dept)){
                jqrate = 0.23;
            }
            if("德州".equals(dept)){
                jqrate = 0.28;
            }
            if("临沂".equals(dept)){
                jqrate = 0.25;
            }
            if("潍坊".equals(dept)){
                jqrate = 0.24;
            }
        }else {
            jqrate = 0.00;
        }

        return jqrate;
    }
    public Double setSYRate(BasePrice basePrice){
        double rate = 0.00;
        String dept = basePrice.getMake_dept();
        if("Y".equals(basePrice.getIsNewEnery()) && "Y".equals(basePrice.getIsVi())){
            rate = 0.0283;
        } else if("Y".equals(basePrice.getIsChange())  && "Y".equals(basePrice.getIsCli()) && "Y".equals(basePrice.getIsVi())){
            if("济南".equals(dept) || "济宁".equals(dept) || "淄博".equals(dept)|| "泰安".equals(dept) || "滨州".equals(dept)
                 || "日照".equals(dept) || "莱芜".equals(dept) || "德州".equals(dept) || "临沂".equals(dept) || "潍坊".equals(dept)){
                rate = 0.12;
            }
            if("聊城".equals(dept) || "烟台".equals(dept) || "东营".equals(dept) || "枣庄".equals(dept)){
                rate = 0.1;
            }
            if("威海".equals(dept)){
                rate = 0.08;
            }
            if("菏泽".equals(dept)){
                rate = 0.13;
            }
        } else if("N".equals(basePrice.getIsChange())  && "Y".equals(basePrice.getIsCli()) && "Y".equals(basePrice.getIsVi())
                    && "Y".equals(basePrice.getIsCarLoss())){
            if("威海".equals(dept) || "德州".equals(dept)){
                rate = 0.132;
            }else if("泰安".equals(dept)){
                rate = 0.2;
            }else{
                rate = 0.15;
            }
        } else if("N".equals(basePrice.getIsChange())  && "Y".equals(basePrice.getIsCli()) && "Y".equals(basePrice.getIsVi())){
            if("聊城".equals(dept) || "烟台".equals(dept) || "东营".equals(dept) || "枣庄".equals(dept)){
                rate = 0.2;
            } else if("威海".equals(dept)){
                rate = 0.18;
            }else if("菏泽".equals(dept)){
                rate = 0.23;
            }else if("潍坊".equals(dept)){
                rate = 0.24;
            }else{
                rate = 0.22;
            }
        }else if("Y".equals(basePrice.getIsVi())){
            if("聊城".equals(dept) || "烟台".equals(dept) || "东营".equals(dept) || "枣庄".equals(dept)){
                rate = 0.1;
            }else if("威海".equals(dept)){
                rate = 0.08;
            }else if("菏泽".equals(dept)){
                rate = 0.13;
            }else{
                rate = 0.12;
            }
        }else {
            rate = 0.00;
        }
    return rate;
    }

    public void exportPrice(BasePrice basePriceParam,HttpServletResponse response) throws Exception {
        XSSFWorkbook wb = null;
        OutputStream out = null;
        try{
            Map<String,String> yesMap = new HashMap<>();
            yesMap.put("Y","是");
            yesMap.put("N","否");
            out = response.getOutputStream();
            List<BasePrice> basePriceList =  basePriceMapper.getBasePriceList(basePriceParam);
            ClassPathResource cpr = new ClassPathResource("/template/price.xlsx");
            wb = new XSSFWorkbook(cpr.getInputStream());
            XSSFSheet sheet = wb.getSheetAt(0);
            sheet.setVerticallyCenter(true);
            sheet.setHorizontallyCenter(true);
            XSSFCellStyle setBorder = wb.createCellStyle();
            Integer startRow = 3;
            Row row = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(int i=0;i<basePriceList.size();i++){
                row = sheet.createRow(startRow+i);
                BasePrice basePrice = basePriceList.get(i);
                row.createCell(0).setCellValue(i+1);//序号


                row.createCell(1).setCellValue((basePrice.getPrice_date() == null?"/":sdf.format(basePrice.getPrice_date())));//算价日期
                row.createCell(2).setCellValue((basePrice.getDept_name()));
                row.createCell(3).setCellValue((basePrice.getName()));
                row.createCell(4).setCellValue((basePrice.getSp_cust_name()));
                row.createCell(5).setCellValue((basePrice.getPlate_no()));
                row.createCell(6).setCellValue((basePrice.getInsured_name()));
                row.createCell(7).setCellValue((basePrice.getPhone_no()));
                row.createCell(8).setCellValue((basePrice.getMake_dept()));
                row.createCell(9).setCellValue((yesMap.get(basePrice.getIsNewEnery())));
                row.createCell(10).setCellValue((yesMap.get(basePrice.getIsChange())));
                row.createCell(11).setCellValue((yesMap.get(basePrice.getIsCli())));
                row.createCell(12).setCellValue((yesMap.get(basePrice.getIsVi())));
                row.createCell(13).setCellValue((yesMap.get(basePrice.getIsCarLoss())));
                row.createCell(14).setCellValue((basePrice.getPrice_first_rate() == null?"/":basePrice.getPrice_first_rate().toString()));
                row.createCell(15).setCellValue((basePrice.getPrice_fee_rate()== null?"/":basePrice.getPrice_fee_rate().toString()));
                row.createCell(16).setCellValue((basePrice.getPrice_charge_rate()== null?"/":basePrice.getPrice_charge_rate().toString()));
                row.createCell(17).setCellValue((basePrice.getPrice_final_rate()== null?"/":basePrice.getPrice_final_rate().toString()));
                row.createCell(18).setCellValue((basePrice.getJq_fee()== null?"/":basePrice.getJq_fee().toString()));
                row.createCell(19).setCellValue((basePrice.getJq_rate()== null?"/":basePrice.getJq_rate().toString()));
                row.createCell(20).setCellValue((basePrice.getJq_amount()== null?"/":basePrice.getJq_amount().toString()));
                row.createCell(21).setCellValue((basePrice.getSy_first_fee()== null?"/":basePrice.getSy_first_fee().toString()));
                row.createCell(22).setCellValue((basePrice.getSy_fee_rate()== null?"/":basePrice.getSy_fee_rate().toString()));
                row.createCell(23).setCellValue((basePrice.getSy_amount()== null?"/":basePrice.getSy_amount().toString()));
                row.createCell(24).setCellValue((basePrice.getSy_after_fee()== null?"/":basePrice.getSy_after_fee().toString()));
                row.createCell(25).setCellValue((basePrice.getSy_charge_fee()== null?"/":basePrice.getSy_charge_fee().toString()));
                row.createCell(26).setCellValue((basePrice.getSy_final_fee()== null?"/":basePrice.getSy_final_fee().toString()));
                row.createCell(27).setCellValue((basePrice.getAvalid_amount()== null?"/":basePrice.getAvalid_amount().toString()));
                row.createCell(28).setCellValue((basePrice.getLast_fee_NoTax()== null?"/":basePrice.getLast_fee_NoTax().toString()));
                row.createCell(29).setCellValue((basePrice.getLast_fee_Tax()== null?"/":basePrice.getLast_fee_Tax().toString()));
                row.createCell(30).setCellValue((basePrice.getTotal_fee()== null?"/":basePrice.getTotal_fee().toString()));
                row.createCell(31).setCellValue((basePrice.getMake_name()== null?"/":basePrice.getMake_name().toString()));
                row.createCell(32).setCellValue((basePrice.getC_price_status()));
                row.createCell(33).setCellValue((basePrice.getC_remark()));//备注
            }
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");

            wb.write(out);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("导出错误");
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

    public void updatePriceStatus(BasePrice basePrice,String type) throws ParseException {
        //1、获取 报价日期当天的basepriceLis
        List<BasePrice> basePriceList = null;
        if("auto".equals(type)){
            basePriceList = basePriceMapper.getBasePriceListForUpdateStatus(basePrice);
        }else {
            basePriceList = basePriceMapper.getBasePriceList(basePrice);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //2、获取app表，如果有，为已报价
        for(BasePrice basePrice1:basePriceList){
            Date insrncBgnTm = null;
            List<Map> statusAppList = basePriceMapper.selectAppStatus(basePrice1.getPlate_no(),basePrice1.getInsured_name(),basePrice.getParams());
            if(statusAppList.size() > 0){
                insrncBgnTm = sdf.parse(statusAppList.get(0).get("insDate").toString());
                basePrice1.setC_price_status("已报价");
            };
            List<Map> statusList = basePriceMapper.selectPlyStatus(basePrice1.getPlate_no(),basePrice1.getInsured_name(),basePrice.getParams());
            if(statusList.size() > 0){
                basePrice1.setC_price_status(statusList.get(0).get("makeDate").toString() + "已出保单");
                insrncBgnTm = sdf.parse(statusList.get(0).get("insDate").toString());
            };
            //如果已出保单，修改客户的起保日期为 保险终保日期
            if(insrncBgnTm !=null){
                baseCustomersMapper.updateTinsrncBgnTm(insrncBgnTm,basePrice1.getCustomer_id());
            }
            basePriceMapper.update(basePrice1);
            this.setPriceStatus(basePrice1);

        }
    }

    public void autoUpdatePriceStatus() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String dateStr = sdf.format(calendar.getTime());
        System.out.println("自动更新报价状态，时间："+dateStr);
        BasePrice basePrice = new BasePrice();
        Map params = new HashMap();
        params.put("beginprice",dateStr);
        params.put("endprice",dateStr);
        basePrice.setParams(params);
        this.updatePriceStatus(basePrice,"auto");
    }
}
