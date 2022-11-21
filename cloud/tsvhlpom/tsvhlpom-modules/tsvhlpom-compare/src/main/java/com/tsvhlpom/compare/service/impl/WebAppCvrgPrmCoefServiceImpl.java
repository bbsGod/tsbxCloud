package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppCvrgPrmCoefMapper;
import com.tsvhlpom.compare.domain.WebAppCvrgPrmCoef;
import com.tsvhlpom.compare.service.IWebAppCvrgPrmCoefService;

/**
 * 申请单险别系数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppCvrgPrmCoefServiceImpl implements IWebAppCvrgPrmCoefService
{
    @Autowired
    private WebAppCvrgPrmCoefMapper webAppCvrgPrmCoefMapper;


    /**
     * 查询申请单险别系数列表
     *
     * @param webAppCvrgPrmCoef 申请单险别系数
     * @return 申请单险别系数
     */
    @Override
    public List<WebAppCvrgPrmCoef> selectWebAppCvrgPrmCoefList(String[] appNos)
    {
        return webAppCvrgPrmCoefMapper.selectWebAppCvrgPrmCoefList(appNos);
    }
}
