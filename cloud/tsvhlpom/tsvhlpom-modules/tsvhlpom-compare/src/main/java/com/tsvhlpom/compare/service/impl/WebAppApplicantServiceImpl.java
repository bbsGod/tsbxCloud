package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppApplicantMapper;
import com.tsvhlpom.compare.domain.WebAppApplicant;
import com.tsvhlpom.compare.service.IWebAppApplicantService;

/**
 * 投保人APPService业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppApplicantServiceImpl implements IWebAppApplicantService
{
    @Autowired
    private WebAppApplicantMapper webAppApplicantMapper;


    /**
     * 查询投保人APP列表
     *
     * @param webAppApplicant 投保人APP
     * @return 投保人APP
     */
    @Override
    public List<WebAppApplicant> selectWebAppApplicantList(String[] appNos)
    {
        return webAppApplicantMapper.selectWebAppApplicantList(appNos);
    }
}
