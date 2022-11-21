package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppPrmCoefMapper;
import com.tsvhlpom.compare.domain.WebAppPrmCoef;
import com.tsvhlpom.compare.service.IWebAppPrmCoefService;

/**
 * 申请单保费系数Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppPrmCoefServiceImpl implements IWebAppPrmCoefService
{
    @Autowired
    private WebAppPrmCoefMapper webAppPrmCoefMapper;


    /**
     * 查询申请单保费系数列表
     *
     * @param webAppPrmCoef 申请单保费系数
     * @return 申请单保费系数
     */
    @Override
    public List<WebAppPrmCoef> selectWebAppPrmCoefList(String[] appNos)
    {
        return webAppPrmCoefMapper.selectWebAppPrmCoefList(appNos);
    }
}
