package com.tsvhlpom.dailywork.service;

import com.tsvhlpom.dailywork.domain.Daily_employee;

import java.util.List;

public interface Daily_employeeService {
    List<Daily_employee> getEmployeeList(Daily_employee daily_employee);
    Daily_employee getEmployee(String pkid);
    Daily_employee getEmployeeInfo(String emp_id);
    void updateEmployee(Daily_employee employee);
    void saveEmployee(Daily_employee employee);
    void deleteEmployee(String[] pkids);
    //导入
    String importData(List<Daily_employee> employeeList, boolean updateSupport, String operName);
}
