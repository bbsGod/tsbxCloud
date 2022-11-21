package com.tsvhlpom.vip.mapper;



import com.tsvhlpom.vip.domain.VipDay;

import java.util.Date;
import java.util.List;

/**
 * 节假日配置表 数据层
 *
 * @author taishanpic
 */
public interface VipDayMapper {
    /**
     * 根据条件分页查询用户列表
     *
     * @param day 用户信息
     * @return 用户信息集合信息
     */
    public List<VipDay> selectDayList(VipDay day);

    /**
     * 通过节假日查询节日
     *
     * @param dayName 用户名
     * @return 用户对象信息
     */
    public VipDay selectDayByDayName(String dayName);

    /**
     * 通过pkid查询对应pkid
     *
     * @param pkId pkid
     * @return 用户对象信息
     */
    public VipDay selectDayById(String pkId);

    /**
     * 新增节假日信息
     *
     * @param day 节假日信息
     * @return 结果
     */
    public int insertDay(VipDay day);

    /**
     * 校验用节假日名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public int checkDayNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param dayDate 手机号码
     * @return 结果
     */
    public VipDay checkDayDateUnique(Date dayDate);

    /**
     * 修改节假日信息
     *
     * @param day 节假日信息
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


}
