package com.tsvhlpom.dailywork.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.dailywork.domain.Daily_employee;
import com.tsvhlpom.dailywork.mapper.Daily_employeeMapper;
import com.tsvhlpom.dailywork.service.Daily_employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Daily_employeeServiceimpl implements Daily_employeeService {
    @Autowired
    private  Daily_employeeMapper daily_employeeMapper;
    @Override
    public List<Daily_employee> getEmployeeList(Daily_employee daily_employee) {
        return daily_employeeMapper.getEmployeeList(daily_employee);
    }

    @Override
    public Daily_employee getEmployee(String pkid) {
        return daily_employeeMapper.getEmployee(pkid);
    }

    @Override
    public Daily_employee getEmployeeInfo(String emp_id) {
        return daily_employeeMapper.getEmployeeInfo(emp_id);
    }

    @Override
    public void updateEmployee(Daily_employee employee) {
        daily_employeeMapper.updateEmployee(employee);
    }

    @Override
    public void saveEmployee(Daily_employee employee) {
        daily_employeeMapper.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(String[] pkids) {
        daily_employeeMapper.deleteEmployee(pkids);
    }

    @Override
    public String importData(List<Daily_employee> employeeList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(employeeList) || employeeList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Daily_employee employee : employeeList)
        {
            if(employee.getEmp_id() == null || "".equals(employee.getEmp_id())){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、员工信息: 员工工号不能为空");
                continue;
            }
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<Daily_employee> oldEmployeeList = daily_employeeMapper.getEmployeeList(employee);
                if (oldEmployeeList == null || oldEmployeeList.size() ==0)
                {
                    daily_employeeMapper.saveEmployee(employee);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + employee.getEmp_id() + " 导入成功");

                }
                else if (updateSupport)
                {
                    employee.setEmp_id(oldEmployeeList.get(0).getEmp_id());
                    daily_employeeMapper.updateEmployee(employee);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + employee.getEmp_id() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、员工信息 " + employee.getEmp_id() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、员工信息 " + employee.getEmp_id() + " 导入失败";
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
