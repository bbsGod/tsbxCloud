package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebPolicyThirdErrLogs;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2022-06-29
 */
public interface IWebPolicyThirdErrLogsService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param cPkId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public WebPolicyThirdErrLogs selectWebPolicyThirdErrLogsByCPkId(String cPkId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<WebPolicyThirdErrLogs> selectWebPolicyThirdErrLogsList(WebPolicyThirdErrLogs webPolicyThirdErrLogs);

    /**
     * 新增【请填写功能名称】
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 结果
     */
    public int insertWebPolicyThirdErrLogs(WebPolicyThirdErrLogs webPolicyThirdErrLogs);

    /**
     * 修改【请填写功能名称】
     *
     * @param webPolicyThirdErrLogs 【请填写功能名称】
     * @return 结果
     */
    public int updateWebPolicyThirdErrLogs(WebPolicyThirdErrLogs webPolicyThirdErrLogs);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cPkIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteWebPolicyThirdErrLogsByCPkIds(String[] cPkIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param cPkId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWebPolicyThirdErrLogsByCPkId(String cPkId);


    String importData(List<WebPolicyThirdErrLogs> logsList, boolean updateSupport, String operName);
}
