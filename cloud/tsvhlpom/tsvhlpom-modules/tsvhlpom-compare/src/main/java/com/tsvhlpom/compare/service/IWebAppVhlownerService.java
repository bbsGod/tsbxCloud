package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppVhlowner;

/**
 * 申请单车主Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppVhlownerService
{
    /**
     * 查询申请单车主列表
     *
     * @param webAppVhlowner 申请单车主
     * @return 申请单车主集合
     */
    public List<WebAppVhlowner> selectWebAppVhlownerList(String[] appNos);

}
