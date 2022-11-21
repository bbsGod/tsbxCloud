package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppVhlownerMapper;
import com.tsvhlpom.compare.domain.WebAppVhlowner;
import com.tsvhlpom.compare.service.IWebAppVhlownerService;

/**
 * 申请单车主Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppVhlownerServiceImpl implements IWebAppVhlownerService
{
    @Autowired
    private WebAppVhlownerMapper webAppVhlownerMapper;


    /**
     * 查询申请单车主列表
     *
     * @param webAppVhlowner 申请单车主
     * @return 申请单车主
     */
    @Override
    public List<WebAppVhlowner> selectWebAppVhlownerList(String[] appNos)
    {
        return webAppVhlownerMapper.selectWebAppVhlownerList(appNos);
    }
}
