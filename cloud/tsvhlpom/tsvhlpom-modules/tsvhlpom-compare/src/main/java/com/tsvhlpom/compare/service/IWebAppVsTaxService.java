package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppVsTax;

/**
 * 申请单车船税信息Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppVsTaxService
{
    /**
     * 查询申请单车船税信息列表
     *
     * @param webAppVsTax 申请单车船税信息
     * @return 申请单车船税信息集合
     */
    public List<WebAppVsTax> selectWebAppVsTaxList(String[] appNos);

}
