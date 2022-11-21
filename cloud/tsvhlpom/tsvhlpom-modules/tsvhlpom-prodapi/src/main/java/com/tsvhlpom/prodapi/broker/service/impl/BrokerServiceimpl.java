package com.tsvhlpom.prodapi.broker.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.common.security.utils.DictUtils;
import com.tsvhlpom.prodapi.broker.VO.Broker;
import com.tsvhlpom.prodapi.broker.mapper.BrokerMapper;
import com.tsvhlpom.prodapi.broker.service.BrokerService;
import com.tsvhlpom.system.api.domain.SysDictData;
import com.tsvhlpom.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerServiceimpl implements BrokerService {

    @Autowired
    private BrokerMapper brokerMapper;
    @Autowired
    private TokenService tokenService;
    @Override
    public List<Broker> getBrokerList(Broker broker) {
        return brokerMapper.getBrokerList(broker);
    }

    @Override
    public Broker getBroker(String c_pk_id) {
        return brokerMapper.getBroker(c_pk_id);
    }

    @Override
    public void update(Broker broker) {
        LoginUser user =  tokenService.getLoginUser();
        broker.setC_update_by(user.getUsername());
        brokerMapper.update(broker);
    }

    @Override
    public void save(Broker broker) {
        LoginUser user =  tokenService.getLoginUser();
        broker.setC_create_by(user.getUsername());
        brokerMapper.save(broker);
    }

    @Override
    public int delete(String[] c_pk_ids) {
        return brokerMapper.delete(c_pk_ids);
    }
    @Override
    public String importData(List<Broker> brokerList, boolean updateSupport, String operName) throws Exception {
        if (StringUtils.isNull(brokerList) || brokerList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Broker broker : brokerList)
        {
            List<SysDictData> dataList =  DictUtils.getDictCache("sys_broker_id");
            Boolean isHas = false;
            for(SysDictData data : dataList){
                if(broker.getC_id().equals(data.getDictValue())){
                    isHas = true;
                }
            }
            if(!isHas){
                failureNum++;
                failureMsg.append("<br/>" + failureNum +"、上级机构归属代码:"+broker.getC_id()+"不存在，请检查或联系管理员获取代码值");
                continue;
            }
            if(broker.getC_id() == null || "".equals(broker.getC_id())){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、中介机构信息上级归属机构不能为空");
                continue;
            }
            if( (broker.getC_brkr_cde() == null || "".equals(broker.getC_brkr_cde()))){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、中介机构代码不能为空");
                continue;
            }
            String userName = tokenService.getLoginUser().getUsername();
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<Broker> oldBrokerList = brokerMapper.getBrokerList(broker);
                if (oldBrokerList == null || oldBrokerList.size() == 0)
                {
                    broker.setC_create_by(userName);
                    brokerMapper.save(broker);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、中介机构信息" + broker.getC_brkr_nme() + " 导入成功");

                }
                else if (updateSupport)
                {
                    broker.setC_pk_id(oldBrokerList.get(0).getC_pk_id());
                    broker.setC_update_by(userName);
                    brokerMapper.update(broker);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、中介机构信息" + broker.getC_brkr_nme() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、中介机构信息 " + broker.getC_brkr_nme() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、中介机构信息 " + broker.getC_brkr_nme() + " 导入失败";
                failureMsg.append(msg + e.getMessage());
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
