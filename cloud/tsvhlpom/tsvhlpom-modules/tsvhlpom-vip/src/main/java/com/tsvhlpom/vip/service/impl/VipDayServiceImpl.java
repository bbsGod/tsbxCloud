package com.tsvhlpom.vip.service.impl;


import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.vip.domain.VipDay;
import com.tsvhlpom.vip.mapper.VipDayMapper;
import com.tsvhlpom.vip.service.IVipDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 节假日配置表 业务层处理
 *
 * @author taishanpic
 */
@Service
public class VipDayServiceImpl implements IVipDayService
{
    private static final Logger log = LoggerFactory.getLogger(VipDayServiceImpl.class);

    @Autowired
    private VipDayMapper dayMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @param day 用户信息
     * @return 用户信息集合信息
     */
    @Override
    public List<VipDay> selectDayList(VipDay day)
    {
        return dayMapper.selectDayList(day);
    }

    /**
     * 通过节假日名称查询节日
     *
     * @param dayName 用户名
     * @return 节假日对象信息
     */
    @Override
    public VipDay selectDayByDayName(String dayName)
    {
        return dayMapper.selectDayByDayName(dayName);
    }

    /**
     * 通过pkid查询对应pkid
     *
     * @param pkId 用户ID
     * @return 节假日对象信息
     */
    @Override
    public VipDay selectDayById(String pkId)
    {
        return dayMapper.selectDayById(pkId);
    }

    /**
     * 新增保存节假日信息
     *
     * @param day 节假日信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertDay(VipDay day)
    {
        // 新增节假日信息
        int rows = dayMapper.insertDay(day);
        return rows;
    }

    /**
     * 修改保存用户信息
     *
     * @param day 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDay(VipDay day)
    {
        String userId = day.getPkId();
        return dayMapper.updateDay(day);
    }

    /**
     * 通过pkId删除节假日信息
     *
     * @param pkId 用户ID
     * @return 结果
     */
    @Override
    public int deleteDayById(String pkId)
    {
        return dayMapper.deleteDayById(pkId);
    }

    /**
     * 批量删除节假日信息
     *
     * @param pkIds 需要删除的用户ID
     * @return 结果
     */
    public int deleteDayByIds(String[] pkIds)
    {
        return dayMapper.deleteDayByIds(pkIds);
    }


    /**
     * 校验节假日日期是否唯一
     *
     * @param day 用户信息
     * @return
     */
    @Override
    public Boolean checkDayUnique(VipDay day)
    {
        boolean flag = false;
        List<VipDay> dayList =  dayMapper.selectDayList(day);
        if(dayList != null && dayList.size() > 0){
            flag = true;
        }
        return flag;
    }

    /**
     * 导入节假日数据
     *
     * @param dayList 节假日数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDay(List<VipDay> dayList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dayList) || dayList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (VipDay day : dayList)
        {
            try
            {
                // 验证是否存在这个用户
                VipDay u = dayMapper.selectDayByDayName(day.getDayName());
                if (StringUtils.isNull(u))
                {
                    day.setCreateBy(operName);
                    this.insertDay(day);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、节假日名称 " + day.getDayName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    day.setUpdateBy(operName);
                    this.updateDay(day);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、节假日名称 " + day.getDayName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、节假日名称 " + day.getDayName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、节假日名称 " + day.getDayName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
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
