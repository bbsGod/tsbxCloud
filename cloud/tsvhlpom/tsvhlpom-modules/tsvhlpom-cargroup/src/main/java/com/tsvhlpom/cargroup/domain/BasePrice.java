package com.tsvhlpom.cargroup.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class BasePrice extends BaseEntity {

    private String pk_id;//主键
    @Excel(name = "算价日期",dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date price_date;//算价日期
    @Excel(name = "部门")
    private String dept_name;//部门
    @Excel(name = "姓名")
    private String name;//姓名
    @Excel(name = "重点客户标识")
    private String sp_cust_name;//重点客户表示
    @Excel(name = "车牌号")
    private String plate_no;//车牌号
    @Excel(name = "被保险人")
    private String insured_name;//被保险人
    @Excel(name = "联系电话")
    private String phone_no;//联系电话
    @Excel(name = "出单机构")
    private String make_dept;//出单机构
    @Excel(name = "是否新能源",readConverterExp = "Y=是,N=否")
    private String isNewEnery;//是否新能源
    @Excel(name = "是否过户",readConverterExp = "Y=是,N=否")
    private String isChange;//是否过户
    @Excel(name = "是否投保交强",readConverterExp = "Y=是,N=否")
    private String isCli;//是否投保交强
    @Excel(name = "是否投保商业",readConverterExp = "Y=是,N=否")
    private String isVi;//是否投保商业
    @Excel(name = "是否投保车损",readConverterExp = "Y=是,N=否")
    private String isCarLoss;//是否投保车损
    @Excel(name = "初始定价系数")
    private Double price_first_rate;//初始定价系数
    @Excel(name = "费折定价系数")
    private Double price_fee_rate;//费折定价系数
    @Excel(name = "人工系数调节")
    private Double price_charge_rate;//人工系数调节
    @Excel(name = "出单定价系数")
    private Double price_final_rate;//出单定价系数
    @Excel(name = "JQ保费")
    private Double jq_fee;//保费
    @Excel(name = "JQ费用率")
    private Double jq_rate;//费用率
    @Excel(name = "JQ费用额")
    private Double jq_amount;//费用额
    @Excel(name = "SY初始保费")
    private Double sy_first_fee;//初始保费
    @Excel(name = "SY费用率")
    private Double sy_fee_rate;//费用率
    @Excel(name = "SY费用额")
    private Double sy_amount;//费用额
    @Excel(name = "SY费折后保费")
    private Double sy_after_fee;//费折后保费
    @Excel(name = "SY人工系数调节保费")
    private Double sy_charge_fee;//人工系数调节保费
    @Excel(name = "SY出单保费")
    private Double sy_final_fee;//出单保费
    @Excel(name = "可用最大费用额")
    private Double avalid_amount;//可用最大费用额
    @Excel(name = "剩余费用额（不扣税）")
    private Double last_fee_NoTax;//剩余费用额（不扣税）
    @Excel(name = "剩余费用额（扣税）")
    private Double last_fee_Tax;//剩余费用额（扣税）
    @Excel(name = "合计保费")
    private Double total_fee;//合计保费
    @Excel(name = "出单员")
    private String make_name;//出单员
    @Excel(name = "报价状态")
    private String c_price_status;//报价状态
    private Date t_create_date;
    private String isUpdatePriceStatus;//是否自动更新报价状态 0=否 1=是 2==页面手动修改
    private String customer_id;//客户表主键pkid
    private String c_remark;//备注
    private Double nocar_price;//非车险保费

}
