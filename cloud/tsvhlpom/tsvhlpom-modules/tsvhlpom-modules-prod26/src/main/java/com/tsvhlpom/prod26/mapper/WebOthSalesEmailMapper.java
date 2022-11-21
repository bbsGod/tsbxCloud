package com.tsvhlpom.prod26.mapper;

import com.tsvhlpom.prod26.domain.WebOthSalesEmail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebOthSalesEmailMapper {

    void update(@Param("c_email") String c_email,@Param("c_sls_cde") String c_sls_cde);

    List<WebOthSalesEmail> getWebOthSalesEmailList( WebOthSalesEmail webOthSalesEmail );
}
