package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppAcctinfoMapper;
import com.tsvhlpom.compare.domain.WebAppAcctinfo;
import com.tsvhlpom.compare.service.IWebAppAcctinfoService;

/**
 * 申请单账户信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppAcctinfoServiceImpl implements IWebAppAcctinfoService
{
    @Autowired
    private WebAppAcctinfoMapper webAppAcctinfoMapper;


    /**
     * 查询申请单账户信息列表
     *
     * @param webAppAcctinfo 申请单账户信息
     * @return 申请单账户信息
     */
    @Override
    public List<WebAppAcctinfo> selectWebAppAcctinfoList(String[] appNos)
    {
        return webAppAcctinfoMapper.selectWebAppAcctinfoList(appNos);
    }
}
