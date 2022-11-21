package com.tsvhlpom.proddata.service.impl;

import java.util.List;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.domain.WebPolicyThirdErrLogs;
import com.tsvhlpom.proddata.mapper.WebPolicyThirdErrLogsMapper;
import com.tsvhlpom.proddata.service.IWebPolicyThirdErrLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-29
 */
@Service
public class WebPolicyThirdErrLogsServiceImpl implements IWebPolicyThirdErrLogsService
{
    @Autowired
    private WebPolicyThirdErrLogsMapper webPolicyThirdErrLogsMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param cPkId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public WebPolicyThirdErrLogs selectWebPolicyThirdErrLogsByCPkId(String cPkId)
    {
        return webPolicyThirdErrLogsMapper.selectWebPolicyThirdErrLogsByCPkId(cPkId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<WebPolicyThirdErrLogs> selectWebPolicyThirdErrLogsList(WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        return webPolicyThirdErrLogsMapper.selectWebPolicyThirdErrLogsList(webPolicyThirdErrLogs);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertWebPolicyThirdErrLogs(WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        return webPolicyThirdErrLogsMapper.insertWebPolicyThirdErrLogs(webPolicyThirdErrLogs);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateWebPolicyThirdErrLogs(WebPolicyThirdErrLogs webPolicyThirdErrLogs)
    {
        return webPolicyThirdErrLogsMapper.updateWebPolicyThirdErrLogs(webPolicyThirdErrLogs);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cPkIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWebPolicyThirdErrLogsByCPkIds(String[] cPkIds)
    {
        return webPolicyThirdErrLogsMapper.deleteWebPolicyThirdErrLogsByCPkIds(cPkIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param cPkId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteWebPolicyThirdErrLogsByCPkId(String cPkId)
    {
        return webPolicyThirdErrLogsMapper.deleteWebPolicyThirdErrLogsByCPkId(cPkId);
    }

    @Override
    public String importData(List<WebPolicyThirdErrLogs> logsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(logsList) || logsList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WebPolicyThirdErrLogs webPolicyThirdErrLogs : logsList)
        {
            try
            {
                webPolicyThirdErrLogsMapper.insertWebPolicyThirdErrLogs(webPolicyThirdErrLogs);
                successNum++;
                successMsg.append("<br/>" + successNum + "、日志信息" + webPolicyThirdErrLogs.getCappNo() + " 导入成功");
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、日志信息" + webPolicyThirdErrLogs.getCappNo() + " 导入失败";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
