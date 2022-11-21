package com.tsvhlpom.dailywork.mapper;

import com.tsvhlpom.dailywork.domain.Daily_employee;

import java.util.List;

public interface Daily_employeeMapper {
    List<Daily_employee> getEmployeeList(Daily_employee daily_employee);
    Daily_employee getEmployee(String pkid);
    void updateEmployee(Daily_employee employee);
    void saveEmployee(Daily_employee employee);
    void deleteEmployee(String[] pkids);
    Daily_employee getEmployeeInfo(String emp_id);
}
