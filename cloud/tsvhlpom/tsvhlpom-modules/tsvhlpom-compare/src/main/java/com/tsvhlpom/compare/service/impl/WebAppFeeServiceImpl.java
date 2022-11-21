package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppFeeMapper;
import com.tsvhlpom.compare.domain.WebAppFee;
import com.tsvhlpom.compare.service.IWebAppFeeService;

/**
 * 申请单费用信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppFeeServiceImpl implements IWebAppFeeService
{
    @Autowired
    private WebAppFeeMapper webAppFeeMapper;


    /**
     * 查询申请单费用信息列表
     *
     * @param webAppFee 申请单费用信息
     * @return 申请单费用信息
     */
    @Override
    public List<WebAppFee> selectWebAppFeeList(String[] appNos)
    {
        return webAppFeeMapper.selectWebAppFeeList(appNos);
    }
}
