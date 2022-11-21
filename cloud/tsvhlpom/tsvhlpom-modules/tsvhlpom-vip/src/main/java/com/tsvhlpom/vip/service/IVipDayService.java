package com.tsvhlpom.vip.service;



import com.tsvhlpom.vip.domain.VipDay;

import java.util.List;

/**
 * 节假日配置表 业务层
 *
 * @author taishanpic
 */
public interface IVipDayService {

    /**
     * 根据条件分页查询用户列表
     *
     * @param day 用户信息
     * @return 用户信息集合信息
     */
    public List<VipDay> selectDayList(VipDay day);

    /**
     * 通过节假日名称查询节日
     *
     * @param dayName 用户名
     * @return 节假日对象信息
     */
    public VipDay selectDayByDayName(String dayName);

    /**
     * 通过pkid查询对应pkid
     *
     * @param pkId 用户ID
     * @return 节假日对象信息
     */
    public VipDay selectDayById(String pkId);

    /**
     * 新增保存节假日信息
     *
     * @param day 节假日信息
     * @return 结果
     */
    public int insertDay(VipDay day);

    /**
     * 修改保存用户信息
     *
     * @param day 用户信息
     * @return 结果
     */
    public int updateDay(VipDay day);

    /**
     * 通过pkId删除节假日信息
     *
     * @param pkId 用户ID
     * @return 结果
     */
    public int deleteDayById(String pkId);

    /**
     * 批量删除节假日信息
     *
     * @param pkIds 需要删除的用户ID
     * @return 结果
     */
    public int deleteDayByIds(String[] pkIds);

    /**
     * 校验节假日日期是否唯一
     *
     * @param dayDate 节假日日期
     * @return 结果
     */
    public Boolean checkDayUnique(VipDay dayDate);

    /**
     * 导入用户数据
     *
     * @param dayList 节假日数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDay(List<VipDay> dayList, Boolean isUpdateSupport, String operName);

}
