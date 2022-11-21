package com.tsvhlpom.covid19.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.covid19.domain.Emplyee;
import com.tsvhlpom.covid19.mapper.EmplyeeMapper;
import com.tsvhlpom.covid19.service.EmplyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmplyeeServiceimpl implements EmplyeeService {

    @Autowired
    private EmplyeeMapper emplyeeMapper;
    @Override
    public List<Emplyee> getEmplyeeList(Emplyee emplyee) {
        return emplyeeMapper.getEmplyeeList(emplyee);
    }

    @Override
    public void saveEmplyee(Emplyee emplyee) {
        emplyeeMapper.saveEmplyee(emplyee);
    }

    @Override
    public void updateEmplyee(Emplyee emplyee) {
        emplyeeMapper.updateEmplyee(emplyee);
    }

    @Override
    public void deleteEmplyee(String[] c_pk_ids) {
        emplyeeMapper.deleteEmplyee(c_pk_ids);
    }

    @Override
    public Emplyee getEmplyee(String c_pk_id) {
        return emplyeeMapper.getEmplyee(c_pk_id);
    }

    @Override
    public String importData(List<Emplyee> emplyeeList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(emplyeeList) || emplyeeList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Emplyee emp : emplyeeList)
        {
            if(emplyeeMapper.getDeptCount(emp.getC_parent_dept()) <= 0){
                throw new ServiceException("二级机构"+emp.getC_parent_dept()+"代码不存在，请核实后导入！");
            }
            if(emplyeeMapper.getDeptCount(emp.getC_dept()) <= 0){
                throw new ServiceException("三级机构"+emp.getC_dept()+"代码不存在，请核实后导入！");
            }
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<Emplyee> empOldList = emplyeeMapper.getEmplyeeList(emp);
                if (StringUtils.isEmpty(empOldList))
                {
                    emplyeeMapper.saveEmplyee(emp);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + emp.getC_name() + " 导入成功");

                }
                else if (updateSupport)
                {
                    emp.setC_pk_id(empOldList.get(0).getC_pk_id());
                    emplyeeMapper.updateEmplyee(emp);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + emp.getC_name() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、员工信息 " + emp.getC_name() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、员工信息 " + emp.getC_name() + " 导入失败";
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
