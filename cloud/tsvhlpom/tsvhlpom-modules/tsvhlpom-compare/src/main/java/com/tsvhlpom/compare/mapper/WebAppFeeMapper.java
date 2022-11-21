package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppFee;

/**
 * 申请单费用信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppFeeMapper
{
    /**
     * 查询申请单费用信息列表
     *
     * @param webAppFee 申请单费用信息
     * @return 申请单费用信息集合
     */
    public List<WebAppFee> selectWebAppFeeList(String[] appNos);


}
