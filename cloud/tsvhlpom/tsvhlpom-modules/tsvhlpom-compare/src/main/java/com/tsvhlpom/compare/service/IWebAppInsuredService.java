package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppInsured;

/**
 * 申请单被保人Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppInsuredService
{
    /**
     * 查询申请单被保人列表
     *
     * @param webAppInsured 申请单被保人
     * @return 申请单被保人集合
     */
    public List<WebAppInsured> selectWebAppInsuredList(String[] appNos);

}
