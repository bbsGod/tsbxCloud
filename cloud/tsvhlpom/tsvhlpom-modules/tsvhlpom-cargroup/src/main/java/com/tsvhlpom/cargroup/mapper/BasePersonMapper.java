package com.tsvhlpom.cargroup.mapper;

import com.tsvhlpom.cargroup.domain.BasePerson;

import java.util.List;

public interface BasePersonMapper {
    void update(BasePerson basePerson);
    void insert(BasePerson basePerson);
    void delete(String[] sp_ids);
    List<BasePerson> getPersonList(BasePerson basePerson);
    BasePerson getPersonById(String sp_id);
}
