package com.tsvhlpom.cargroup.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsvhlpom.common.core.annotation.Excel;
import com.tsvhlpom.common.core.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class BaseCustomers extends BaseEntity {

    //主键
    private String c_pk_id;
    //重点客户ID
    //@Excel(name = "重点客户标识编码")
    private String c_sp_cust_id;
    @Excel(name = "重点客户标识名称",type = Excel.Type.IMPORT)
    private String c_sp_cust_nme;
    //姓名
    //@Excel(name = "姓名")
    private String c_nme;
    //手机号
    //@Excel(name = "手机号")
    private String c_mobile;
    //行驶证车主
    @Excel(name = "行驶证车主",type = Excel.Type.IMPORT)
    private String c_reg_owner;
    //车牌号
    @Excel(name = "车牌号",type = Excel.Type.IMPORT)
    private String c_plate_no;
    //初登日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "初登日期",dateFormat = "yyyy-MM-dd")
    private Date c_fst_reg_ym;
    //厂牌型号
    //@Excel(name = "厂牌型号")
    private String c_model_nme;
    //行驶总里程
    //@Excel(name = "行驶总里程")
    private String c_travel_mile;
    //保险起期
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "保险起期",dateFormat = "yyyy-MM-dd")
    private Date t_insrnc_bgn_tm;
    //车架号
    //@Excel(name = "车架号")
    private String c_frm_no;
    //发动机号
    //@Excel(name = "发动机号")
    private String c_eng_no;
    //创建日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    //@Excel(name = "创建日期",dateFormat = "yyyy-MM-dd")
    private Date t_create_date;
    //@Excel(name = "回访状态",readConverterExp = "0=回访成功，可微信报价,1=回访成功，可短信报价,2=回访成功，可电话报价,3=回访成功，无需报价,4=未回访成功")
    private String c_visit_status;//回访状态
    @Excel(name = "回访人员",type = Excel.Type.IMPORT)
    private String c_visit_emp;//回访人员
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回访时间",dateFormat = "yyyy-MM-dd",type = Excel.Type.IMPORT)
    private Date c_visit_Tm;//回访时间
    @Excel(name = "报价状态",type = Excel.Type.IMPORT)
    private String c_price_status;//报价状态

    private Boolean edit;//是否修改
    private String c_is_visit;//是否已回访

    private String c_start_date;//是否进入续保期
    private String c_end_date;//是否进入续保期
    private String c_is_notsuccess;//未回访成功原因
    @Excel(name = "备注",type = Excel.Type.IMPORT)
    private String c_remark;//备注
    private String[] c_visit_statusList;//接收前端数组
    private String c_person_dept;//接收前端参数--部门
    private String c_person_name;//接收前端参数--维护人姓名
    private String c_person_flag;//接收前端参数--服务标志
    private String c_dept_cde;//接收前端参数--部门代码
    private String c_visitOrPrice;//接收前端参数--是否未回访未报价
    private String c_is_renew;//判断是否续保客户
    private String c_cus_typ;//客户类型
    private String c_cus_typDesc;//客户类型描述
    private String c_is_wxfriend;//是否企微客户

}
