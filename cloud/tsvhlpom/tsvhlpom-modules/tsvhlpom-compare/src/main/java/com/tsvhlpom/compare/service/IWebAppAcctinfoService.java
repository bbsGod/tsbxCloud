package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppAcctinfo;

/**
 * 申请单账户信息Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppAcctinfoService
{
    /**
     * 查询申请单账户信息列表
     *
     * @param webAppAcctinfo 申请单账户信息
     * @return 申请单账户信息集合
     */
    public List<WebAppAcctinfo> selectWebAppAcctinfoList(String[] appNos);

}
