package com.tsvhlpom.cargroup.service.impl;

import com.tsvhlpom.cargroup.domain.BasePerson;
import com.tsvhlpom.cargroup.mapper.BasePersonMapper;
import com.tsvhlpom.cargroup.service.BasePersonService;
import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasePersonServiceimpl implements BasePersonService {

    @Autowired
    private BasePersonMapper basePersonMapper;
    @Override
    public void update(BasePerson basePerson) {
        basePersonMapper.update(basePerson);
    }

    @Override
    public void insert(BasePerson basePerson) {
        basePersonMapper.insert(basePerson);
    }

    @Override
    public void delete(String[] sp_ids) {
        basePersonMapper.delete(sp_ids);
    }

    @Override
    public List<BasePerson> getPersonList(BasePerson basePerson) {
        return basePersonMapper.getPersonList(basePerson);
    }

    @Override
    public BasePerson getPersonById(String sp_id) {
        return basePersonMapper.getPersonById(sp_id);
    }
    @Override
    public String importData(List<BasePerson> basePersonList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(basePersonList) || basePersonList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (BasePerson basePerson : basePersonList)
        {
            try
            {
                // 根据身份证号验证是否已存在信息'
                BasePerson basePersonOld = basePersonMapper.getPersonById(basePerson.getSp_id());
                if (basePersonOld == null)
                {

                    basePersonMapper.insert(basePerson);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + basePerson.getSp_name() + " 导入成功");

                }
                else if (updateSupport)
                {
                    basePersonMapper.update(basePerson);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + basePerson.getSp_name() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、员工信息 " + basePerson.getSp_name() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、员工信息 " + basePerson.getSp_name() + " 导入失败";
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
