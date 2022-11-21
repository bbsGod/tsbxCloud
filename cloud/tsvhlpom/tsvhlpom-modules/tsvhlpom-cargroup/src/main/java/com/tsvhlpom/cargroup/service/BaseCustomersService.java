package com.tsvhlpom.cargroup.service;

import com.tsvhlpom.cargroup.domain.BaseCustomers;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public interface BaseCustomersService {
    /**
     * 新增
     * @param baseCustomers
     */
    void insert(BaseCustomers baseCustomers) throws Exception;

    /**
     * 更新
     * @param baseCustomers
     */
    void update(BaseCustomers baseCustomers) throws Exception;
    void updateVisit(BaseCustomers baseCustomers);

    /**
     * 删除
     * @param c_pk_ids
     */
    void delete(String[] c_pk_ids);
    BaseCustomers getBaseCustomers(String c_pk_id);
    List<BaseCustomers> getBaseCustomersList(BaseCustomers baseCustomers);
    void export(List<BaseCustomers> list, HttpServletResponse response) throws Exception;

    void updateVisitInfo();
    List getSpCust(String query);
    String updateVisitInfoByExport(List<BaseCustomers> customersList,boolean updateSupport);
}
