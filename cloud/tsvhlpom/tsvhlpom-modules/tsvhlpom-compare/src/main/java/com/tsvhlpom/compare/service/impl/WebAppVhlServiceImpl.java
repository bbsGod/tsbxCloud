package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppVhlMapper;
import com.tsvhlpom.compare.domain.WebAppVhl;
import com.tsvhlpom.compare.service.IWebAppVhlService;

/**
 * 申请单车险标的信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppVhlServiceImpl implements IWebAppVhlService
{
    @Autowired
    private WebAppVhlMapper webAppVhlMapper;


    /**
     * 查询申请单车险标的信息列表
     *
     * @param webAppVhl 申请单车险标的信息
     * @return 申请单车险标的信息
     */
    @Override
    public List<WebAppVhl> selectWebAppVhlList(String[] appNos)
    {
        return webAppVhlMapper.selectWebAppVhlList(appNos);
    }
}
