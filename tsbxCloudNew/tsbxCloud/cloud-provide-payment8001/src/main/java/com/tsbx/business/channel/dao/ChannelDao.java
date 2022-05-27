package com.tsbx.business.channel.dao;

import com.tsbx.business.channel.pojo.MesChannel;

import java.util.List;

//@Mapper
public interface ChannelDao {
    /**
     * 查询所有的数据
     * @return {{@link List<  MesChannel >}}
     * @author zhaoJs
     * @date 2022/4/7 0:23
     **/
    List<MesChannel> selectPage();

}
