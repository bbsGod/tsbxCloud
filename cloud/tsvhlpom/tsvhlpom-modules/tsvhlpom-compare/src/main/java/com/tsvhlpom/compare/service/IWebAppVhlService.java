package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppVhl;

/**
 * 申请单车险标的信息Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppVhlService
{
    /**
     * 查询申请单车险标的信息列表
     *
     * @param webAppVhl 申请单车险标的信息
     * @return 申请单车险标的信息集合
     */
    public List<WebAppVhl> selectWebAppVhlList(String[] appNos);

}
