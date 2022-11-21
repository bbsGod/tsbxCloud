package com.tsvhlpom.zentao.mapper;

import com.tsvhlpom.zentao.DO.ProductDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select id, name from zt_product")
    List<ProductDO> findAll();
}
