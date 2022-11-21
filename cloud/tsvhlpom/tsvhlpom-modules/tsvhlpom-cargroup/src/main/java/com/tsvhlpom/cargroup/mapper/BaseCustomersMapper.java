package com.tsvhlpom.cargroup.mapper;

import com.tsvhlpom.cargroup.domain.BaseCustomers;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BaseCustomersMapper {
    /**
     * 新增
     * @param baseCustomers
     */
    void insert(BaseCustomers baseCustomers);

    /**
     * 更新
     * @param baseCustomers
     */
    void update(BaseCustomers baseCustomers);
    void updateVisit(BaseCustomers baseCustomers);

    /**
     * 删除
     * @param c_pk_ids
     */
    void delete(String[] c_pk_ids);
    BaseCustomers getBaseCustomers(String c_pk_id);
    List<BaseCustomers> getBaseCustomersList(BaseCustomers baseCustomers);
    List<BaseCustomers> getListForUpdate(BaseCustomers baseCustomers);
    List<BaseCustomers> checkCustomerisExists(@Param("c_sp_cust_id") String c_sp_cust_id,@Param("c_frm_no") String c_frm_no,@Param("c_plate_no") String c_plate_no);
    BaseCustomers getBaseCustomersByPkId(@Param("c_pk_id") String c_pk_id);
    void updateTinsrncBgnTm(@Param("insBgnTm") Date insBgnTm, @Param("pk_id") String pk_id);
    void updateVisitInfo();
    List getSpCust(@Param("query") String query);
    Integer selectValidPolicy(@Param("c_plate_no") String c_plate_no);
}
