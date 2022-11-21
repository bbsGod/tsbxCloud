package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppPrmCoef;

/**
 * 申请单保费系数Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppPrmCoefService
{
    /**
     * 查询申请单保费系数列表
     *
     * @param webAppPrmCoef 申请单保费系数
     * @return 申请单保费系数集合
     */
    public List<WebAppPrmCoef> selectWebAppPrmCoefList(String[] appNos);

}
