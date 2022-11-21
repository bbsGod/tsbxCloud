package com.tsvhlpom.compare.mapper;

import java.util.List;
import com.tsvhlpom.compare.domain.WebAppVhl;

/**
 * 申请单车险标的信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public interface WebAppVhlMapper
{
    /**
     * 查询申请单车险标的信息列表
     *
     * @return 申请单车险标的信息集合
     */
    public List<WebAppVhl> selectWebAppVhlList(String[] appNos);


}
