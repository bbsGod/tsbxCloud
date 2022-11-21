package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppBase;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-06
 */
public interface WebAppBaseMapper
{


    public List<WebAppBase> selectWebAppBaseList(String[] cAppNo);
}
