package com.tsvhlpom.covid19.domain;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Covid {
    private String c_pk_id;//主键
    private String c_dept;//机构
    private String c_name;//姓名
    private String c_id_no;//身份证号
    private String c_phone;//电话
    //0=绿色 1=黄色 2=红色
    private String c_health_color;//健康码颜色
    private String c_tour_color;//行程码颜色
    private String c_health_code;//健康码base64
    private String c_tour_code;//行程码base64
    private String c_health_img;//健康码图片路径
    private String c_tour_img;//行程码图片路径
    private Date t_create_tm;//填写时间
    private String c_parent_dept;//总公司分公司
    private Map<String, Object> params;

    private String c_test_nos;//核酸检测次数
    private String c_test_result;//核酸检测结果
    private String c_test_code;//核酸检测BASE64
    private String c_test_img;//核酸检测报告图片位置
}
