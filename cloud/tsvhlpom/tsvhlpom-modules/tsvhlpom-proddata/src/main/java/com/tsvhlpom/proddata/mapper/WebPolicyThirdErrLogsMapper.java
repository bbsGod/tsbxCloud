package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebPolicyThirdErrLogs;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-29
 */
public interface WebPolicyThirdErrLogsMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param cpkId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public WebPolicyThirdErrLogs selectWebPolicyThirdErrLogsByCPkId(String cpkId);

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
     * 删除【请填写功能名称】
     *
     * @param cpkId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteWebPolicyThirdErrLogsByCPkId(String cpkId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cPkIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWebPolicyThirdErrLogsByCPkIds(String[] cpkIds);
}
