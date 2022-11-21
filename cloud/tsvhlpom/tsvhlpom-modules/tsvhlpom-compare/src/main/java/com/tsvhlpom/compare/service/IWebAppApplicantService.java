package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppApplicant;

/**
 * 投保人APPService接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppApplicantService
{
    /**
     * 查询投保人APP列表
     *
     * @param webAppApplicant 投保人APP
     * @return 投保人APP集合
     */
    public List<WebAppApplicant> selectWebAppApplicantList(String[] appNos);

}
