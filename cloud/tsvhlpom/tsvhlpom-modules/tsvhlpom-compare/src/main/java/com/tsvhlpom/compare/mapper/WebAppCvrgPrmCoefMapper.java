package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppCvrgPrmCoef;

/**
 * 申请单险别系数Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppCvrgPrmCoefMapper
{
    /**
     * 查询申请单险别系数列表
     *
     * @param webAppCvrgPrmCoef 申请单险别系数
     * @return 申请单险别系数集合
     */
    public List<WebAppCvrgPrmCoef> selectWebAppCvrgPrmCoefList(String[] appNos);


}
