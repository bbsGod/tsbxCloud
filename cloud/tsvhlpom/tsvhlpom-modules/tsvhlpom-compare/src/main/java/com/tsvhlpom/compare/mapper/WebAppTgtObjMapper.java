package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppTgtObj;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppTgtObjMapper
{
    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppTgtObj 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WebAppTgtObj> selectWebAppTgtObjList(String[] appNos);


}
