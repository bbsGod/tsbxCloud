package com.tsvhlpom.covid19.mapper;

import com.tsvhlpom.covid19.domain.DoneList;
import com.tsvhlpom.covid19.domain.Emplyee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmplyeeMapper {
    List<Emplyee> getEmplyeeList(Emplyee emplyee);
    void saveEmplyee(Emplyee emplyee);
    void updateEmplyee(Emplyee emplyee);
    void deleteEmplyee(String[] c_pk_ids);
    Emplyee getEmplyee(String c_pk_id);
    Integer getDeptCount(@Param("dept_id") String dept_id);
    List<Emplyee> checkEmp(@Param("c_name") String c_name,@Param("c_phone") String c_phone);
    List<Emplyee> getUnDoneResult(@Param("c_parent_dept") String c_parent_dept, @Param("c_dept") String c_dept, @Param("day") String day);
    String getName(@Param("c_phone") String c_phone);

}
