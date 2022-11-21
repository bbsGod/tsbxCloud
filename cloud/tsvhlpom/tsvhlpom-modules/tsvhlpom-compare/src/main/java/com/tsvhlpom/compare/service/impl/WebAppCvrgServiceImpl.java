package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppCvrgMapper;
import com.tsvhlpom.compare.domain.WebAppCvrg;
import com.tsvhlpom.compare.service.IWebAppCvrgService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppCvrgServiceImpl implements IWebAppCvrgService
{
    @Autowired
    private WebAppCvrgMapper webAppCvrgMapper;


    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppCvrg 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WebAppCvrg> selectWebAppCvrgList(String[] appNos)
    {
        return webAppCvrgMapper.selectWebAppCvrgList(appNos);
    }
}
