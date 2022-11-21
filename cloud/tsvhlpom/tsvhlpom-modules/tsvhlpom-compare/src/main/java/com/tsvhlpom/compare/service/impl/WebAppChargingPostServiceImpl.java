package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppChargingPostMapper;
import com.tsvhlpom.compare.domain.WebAppChargingPost;
import com.tsvhlpom.compare.service.IWebAppChargingPostService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppChargingPostServiceImpl implements IWebAppChargingPostService
{
    @Autowired
    private WebAppChargingPostMapper webAppChargingPostMapper;


    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppChargingPost 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WebAppChargingPost> selectWebAppChargingPostList(String[] appNos)
    {
        return webAppChargingPostMapper.selectWebAppChargingPostList(appNos);
    }
}
