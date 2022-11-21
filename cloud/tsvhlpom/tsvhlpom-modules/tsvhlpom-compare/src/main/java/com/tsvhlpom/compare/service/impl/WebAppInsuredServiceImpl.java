package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppInsuredMapper;
import com.tsvhlpom.compare.domain.WebAppInsured;
import com.tsvhlpom.compare.service.IWebAppInsuredService;

/**
 * 申请单被保人Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppInsuredServiceImpl implements IWebAppInsuredService
{
    @Autowired
    private WebAppInsuredMapper webAppInsuredMapper;


    /**
     * 查询申请单被保人列表
     *
     * @param webAppInsured 申请单被保人
     * @return 申请单被保人
     */
    @Override
    public List<WebAppInsured> selectWebAppInsuredList(String[] appNos)
    {
        return webAppInsuredMapper.selectWebAppInsuredList(appNos);
    }
}
