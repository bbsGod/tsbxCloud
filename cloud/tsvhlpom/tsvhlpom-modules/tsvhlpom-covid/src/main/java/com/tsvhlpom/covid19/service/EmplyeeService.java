package com.tsvhlpom.covid19.service;

import com.tsvhlpom.covid19.domain.Emplyee;

import java.util.List;

public interface EmplyeeService {
    List<Emplyee> getEmplyeeList(Emplyee emplyee);
    void saveEmplyee(Emplyee emplyee);
    void updateEmplyee(Emplyee emplyee);
    void deleteEmplyee(String[] c_pk_ids);
    Emplyee getEmplyee(String c_pk_id);
    //导入
    String importData(List<Emplyee> emplyeeList, boolean updateSupport, String operName);
}
