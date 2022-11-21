package com.tsvhlpom.cargroup.service;

import com.tsvhlpom.cargroup.domain.BaseCustomers;
import com.tsvhlpom.cargroup.domain.BasePrice;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

public interface BasePriceService {
    List<BasePrice> getBasePriceList(BasePrice basePrice);
    BasePrice getPriceById(String pk_id);
    void save(BasePrice basePrice);
    void update(BasePrice basePrice);
    void delete(String[] pk_ids);
    String importData(List<BasePrice> basePriceList, boolean updateSupport, String operName);

    /**
     * 组装报价
     * @param baseCustomers
     * @return
     */
    BasePrice price(BaseCustomers baseCustomers) throws Exception;
    void exportPrice(BasePrice basePrice,HttpServletResponse response) throws Exception;

    /**
     * 更新报价状态
     * @param basePrice
     */
    void updatePriceStatus(BasePrice basePrice,String type) throws ParseException;
    void autoUpdatePriceStatus() throws ParseException;
}
