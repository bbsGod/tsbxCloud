package com.tsvhlpom.compare.service.impl;

import java.util.List;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppBaseMapper;
import com.tsvhlpom.compare.domain.WebAppBase;
import com.tsvhlpom.compare.service.IWebAppBaseService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-06
 */
@Service
public class WebAppBaseServiceImpl implements IWebAppBaseService
{
    @Autowired
    private WebAppBaseMapper webAppBaseMapper;
    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppBase 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WebAppBase> selectWebAppBaseList(String[] cAppNo)
    {
        return webAppBaseMapper.selectWebAppBaseList(cAppNo);
    }


}
