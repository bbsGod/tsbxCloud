package com.tsbx.business.channel.service.impl;


import com.tsbx.business.channel.dao.ChannelDao;
import com.tsbx.business.channel.pojo.MesChannel;

import com.tsbx.business.channel.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author zhaoJs
 * @version 1.0
 * @date 2022/4/7 0:52
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelDao channelDao;
    @Override
    public List<MesChannel> getChannel() {
        return channelDao.selectPage();
    }
}
