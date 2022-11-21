package com.tsvhlpom.meetingpreset.mapper;

import com.tsvhlpom.meetingpreset.domain.Person;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface PersonMapper {
    void save(Person person);
    void update(Person person);
    void delete(String[] pkids);
    Person getPersonById(@Param("pk_id") String pk_id);
    List<Person> getPersonList(Person person);
    Person getPersonByPersonId(@Param("person_id") String person_id);

    void deleteAll();
}
