package com.tsvhlpom.cargroup.service;

import com.tsvhlpom.cargroup.domain.BasePerson;

import java.util.List;

public interface BasePersonService {
    void update(BasePerson basePerson);
    void insert(BasePerson basePerson);
    void delete(String[] sp_ids);
    List<BasePerson> getPersonList(BasePerson basePerson);
    BasePerson getPersonById(String sp_id);
    String importData(List<BasePerson> basePersonList, boolean updateSupport, String operName);
}
