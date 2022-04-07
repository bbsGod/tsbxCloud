package com.tsbx.channel.dao;

import com.tsbx.channel.pojo.MesChannel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface ChannelDao {
    /**
     * 查询所有的数据
     * @return {{@link List< MesChannel>}}
     * @author zhaoJs
     * @date 2022/4/7 0:23
     **/
    List<MesChannel> selectPage();

}
