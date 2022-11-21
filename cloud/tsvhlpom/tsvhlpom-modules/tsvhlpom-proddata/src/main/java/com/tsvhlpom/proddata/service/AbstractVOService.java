package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.AbstractVO;
import java.util.List;

public interface AbstractVOService {
    List<AbstractVO> selectEmail(String c_app_no);
    void updateAppAppliantEmail(AbstractVO abstractVO);
    void updateAppInsuredEmail(AbstractVO abstractVO);
    void updatePlyAppliantEmail(AbstractVO abstractVO);
    void updatePlyInsuredEmail(AbstractVO abstractVO);

    List<AbstractVO> selectN_novhl_pay_amt(String c_app_no);
    void updatWebPayConfirmInfo();
    void updatWebPayConfirmInfoByDate(String startDate,String endDate);
    String updateTimeByExport(List<AbstractVO> abstractVOList,boolean updateSupport);
}
