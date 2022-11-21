package com.tsvhlpom.compare.mapper;

import com.tsvhlpom.compare.domain.WebAppAcctinfo;
import java.util.List;


/**
 * 申请单账户信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppAcctinfoMapper
{
    /**
     * 查询申请单账户信息列表
     *
     * @param webAppAcctinfo 申请单账户信息
     * @return 申请单账户信息集合
     */
    public List<WebAppAcctinfo> selectWebAppAcctinfoList(String[] appNos);


}
