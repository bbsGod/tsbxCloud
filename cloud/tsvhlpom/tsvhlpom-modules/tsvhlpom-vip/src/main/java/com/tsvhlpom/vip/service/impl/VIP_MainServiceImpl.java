package com.tsvhlpom.vip.service.impl;


import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.ServletUtils;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.common.security.service.TokenService;
import com.tsvhlpom.system.api.model.LoginUser;
import com.tsvhlpom.vip.domain.VIP_Main;
import com.tsvhlpom.vip.mapper.VIP_MainMapper;
import com.tsvhlpom.vip.service.VIP_MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VIP_MainServiceImpl implements VIP_MainService {

    @Autowired
    private VIP_MainMapper vipMapper;
    @Autowired
    private TokenService tokenService;
    public String getOperName(){
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        return loginUser.getUsername();
    }
    @Override
    public void save(VIP_Main vip) {
        vip.setCreateBy(getOperName());
        vipMapper.save(vip);
    }

    @Override
    public List<VIP_Main> getVIPList(VIP_Main vip) {
        List<VIP_Main>  vipList = vipMapper.getVIPList(vip);
        for(VIP_Main vip_: vipList){
            if(checkStatus(vip_) > 0){
                vip_.setStatus("已承保");
            }else{
                vip_.setStatus("未承保");
            }
        }
        return vipList;
    }

    /**
     * 根据车牌或者车架 判断是否已承保
     * @param vip
     * @return
     */
    public int checkStatus(VIP_Main vip){
        return vipMapper.checkStatus(vip);
    }


    @Override
    public VIP_Main getVIPByPkID(String pkId) {
        return vipMapper.getVIPByPkID(pkId);
    }

    @Override
    public void update(VIP_Main vip) {
        vip.setUpdateBy(getOperName());
        vipMapper.update(vip);
    }

    @Override
    public void delete(String[] pkIds) {
        vipMapper.delete(pkIds);
    }

    @Override
    public String importData(List<VIP_Main> vipList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(vipList) || vipList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (VIP_Main vip : vipList)
        {
            if(vip.getPhoneNo() == null || "".equals(vip.getPhoneNo())){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、VIP客户信息: "+vip.getCertifCode()+",手机号不能为空");
                continue;
            }
            if( (vip.getPlateNo() == null || "".equals(vip.getPlateNo())) &&
                    (vip.getFrmNo() == null || "".equals(vip.getFrmNo()))){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、VIP客户信息: "+vip.getCertifCode()+",车牌号或车架号不能同时为空");
                continue;
            }
            try
            {
                // 根据身份证号验证是否已存在信息'
                VIP_Main oldVip = vipMapper.getVIPByCertifCode(vip.getCertifCode());
                if (oldVip == null)
                {
                    vip.setCreateBy(getOperName());
                    vipMapper.save(vip);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、VIP客户信息" + vip.getInsuredName() + " 导入成功");

                }
                else if (updateSupport)
                {
                    vip.setPkId(oldVip.getPkId());
                    vip.setUpdateBy(getOperName());
                    vipMapper.update(vip);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、VIP客户信息" + vip.getInsuredName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、VIP客户信息 " + vip.getInsuredName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、VIP客户信息 " + vip.getInsuredName() + " 导入失败";
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
