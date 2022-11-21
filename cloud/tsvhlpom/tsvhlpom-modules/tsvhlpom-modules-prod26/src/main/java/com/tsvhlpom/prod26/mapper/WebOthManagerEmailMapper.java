package com.tsvhlpom.prod26.mapper;

import com.tsvhlpom.prod26.domain.WebOthManagerEmail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebOthManagerEmailMapper {

    void update(@Param("c_email") String c_email,@Param("c_dpt_cde") String c_dpt_cde);

    List<WebOthManagerEmail> getWebOthManagerEmailList(WebOthManagerEmail webOthManagerEmail);
}
