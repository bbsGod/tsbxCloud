package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppCvrg;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppCvrgMapper
{
    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppCvrg 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WebAppCvrg> selectWebAppCvrgList(String[] appNos);


}
