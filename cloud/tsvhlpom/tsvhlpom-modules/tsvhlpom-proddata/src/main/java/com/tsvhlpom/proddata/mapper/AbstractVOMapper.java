package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.AbstractVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AbstractVOMapper {
    List<AbstractVO> selectEmail(String c_app_no);
    @Update("update web_app_applicant set c_email = #{c_email} where c_app_no = #{c_app_no}")
    void updateAppAppliantEmail(AbstractVO abstractVO);
    @Update("update web_app_insured set c_email = #{c_email} where c_app_no = #{c_app_no}")
    void updateAppInsuredEmail(AbstractVO abstractVO);
    @Update("update web_ply_applicant set c_email = #{c_email} where c_app_no = #{c_app_no}")
    void updatePlyAppliantEmail(AbstractVO abstractVO);
    @Update("update web_ply_insured set c_email = #{c_email} where c_app_no = #{c_app_no}")
    void updatePlyInsuredEmail(AbstractVO abstractVO);


    List<AbstractVO> selectN_novhl_pay_amt(String c_app_no);
    void updatWebPayConfirmInfo();
    void updatWebPayConfirmInfoByDate(@Param("startDate") String startDate,@Param("endDate") String endDate);

    void updateTimeByExport(AbstractVO abstractVO);

    Integer updateAppCvrg();
    Integer updatePlyCvrg();
}
