package com.tsvhlpom.compare.service;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppBase;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-06-06
 */
public interface IWebAppBaseService
{


    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppBase 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WebAppBase> selectWebAppBaseList(String[] cAppNos);

}
