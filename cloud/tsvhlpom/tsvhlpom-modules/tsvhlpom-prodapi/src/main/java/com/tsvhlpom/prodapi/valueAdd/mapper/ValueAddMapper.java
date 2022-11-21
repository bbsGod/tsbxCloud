package com.tsvhlpom.prodapi.valueAdd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ValueAddMapper {
    @Select("SELECT a.c_affirm_cde FROM web_ply_vhl a WHERE a.c_ply_no = #{plyNo} and exists (SELECT * FROM web_ply_base q WHERE q.c_app_no = a.c_app_no and q.c_app_typ ='A')")
    String getAffimCode(String plyNo);
}
