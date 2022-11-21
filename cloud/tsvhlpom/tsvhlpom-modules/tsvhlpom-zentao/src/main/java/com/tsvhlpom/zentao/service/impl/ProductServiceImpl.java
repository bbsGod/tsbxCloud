package com.tsvhlpom.zentao.service.impl;


import com.tsvhlpom.zentao.DO.ProductDO;
import com.tsvhlpom.zentao.mapper.ProductMapper;
import com.tsvhlpom.zentao.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDO> getProductAll() {
        return productMapper.findAll();
    }
}
