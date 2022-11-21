package com.tsvhlpom.zentao.controller;


import com.tsvhlpom.zentao.DO.ProductDO;
import com.tsvhlpom.zentao.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("getProduct")
    public List<ProductDO> getProduct() {
        return productService.getProductAll();
    }

}
