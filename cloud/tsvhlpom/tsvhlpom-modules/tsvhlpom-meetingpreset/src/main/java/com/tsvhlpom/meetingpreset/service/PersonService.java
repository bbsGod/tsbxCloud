package com.tsvhlpom.meetingpreset.service;

import com.tsvhlpom.meetingpreset.domain.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    void update(Person person);
    void delete(String[] pkids);
    Person getPersonById(String pkid);
    List<Person> getPersonList(Person person);
    String importData(List<Person> personList, boolean updateSupport, String operName) throws Exception;
}
