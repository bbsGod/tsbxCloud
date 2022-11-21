package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppChargingPost;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface IWebAppChargingPostService
{
    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppChargingPost 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WebAppChargingPost> selectWebAppChargingPostList(String[] appNos);

}
