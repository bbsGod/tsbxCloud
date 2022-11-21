package com.tsvhlpom.compare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsvhlpom.compare.mapper.WebAppTgtObjMapper;
import com.tsvhlpom.compare.domain.WebAppTgtObj;
import com.tsvhlpom.compare.service.IWebAppTgtObjService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Service
public class WebAppTgtObjServiceImpl implements IWebAppTgtObjService
{
    @Autowired
    private WebAppTgtObjMapper webAppTgtObjMapper;


    /**
     * 查询【请填写功能名称】列表
     *
     * @param webAppTgtObj 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WebAppTgtObj> selectWebAppTgtObjList(String[] appNos)
    {
        return webAppTgtObjMapper.selectWebAppTgtObjList(appNos);
    }
}
