package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppVsTaxMapper;
import com.tsvhlpom.compare.domain.WebAppVsTax;
import com.tsvhlpom.compare.service.IWebAppVsTaxService;

/**
 * 申请单车船税信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppVsTaxServiceImpl implements IWebAppVsTaxService
{
    @Autowired
    private WebAppVsTaxMapper webAppVsTaxMapper;


    /**
     * 查询申请单车船税信息列表
     *
     * @param webAppVsTax 申请单车船税信息
     * @return 申请单车船税信息
     */
    @Override
    public List<WebAppVsTax> selectWebAppVsTaxList(String[] appNos)
    {
        return webAppVsTaxMapper.selectWebAppVsTaxList(appNos);
    }
}
