package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.domain.AbstractVO;
import com.tsvhlpom.proddata.mapper.AbstractVOMapper;
import com.tsvhlpom.proddata.service.AbstractVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbstractVOServiceimpl implements AbstractVOService {
    @Autowired
    private AbstractVOMapper abstractVOMapper;

    @Override
    public List<AbstractVO> selectEmail(String c_app_no) {
        return abstractVOMapper.selectEmail(c_app_no);
    }

    @Override
    public void updateAppAppliantEmail(AbstractVO abstractVO) {
        abstractVOMapper.updateAppAppliantEmail(abstractVO);
    }

    @Override
    public void updateAppInsuredEmail(AbstractVO abstractVO) {
        abstractVOMapper.updateAppInsuredEmail(abstractVO);
    }

    @Override
    public void updatePlyAppliantEmail(AbstractVO abstractVO) {
        abstractVOMapper.updatePlyAppliantEmail(abstractVO);
    }

    @Override
    public void updatePlyInsuredEmail(AbstractVO abstractVO) {
        abstractVOMapper.updatePlyInsuredEmail(abstractVO);
    }

    @Override
    public List<AbstractVO> selectN_novhl_pay_amt(String c_app_no) {
        return abstractVOMapper.selectN_novhl_pay_amt(c_app_no);
    }

    @Override
    public void updatWebPayConfirmInfo() {
        abstractVOMapper.updatWebPayConfirmInfo();
    }
    @Override
    public void updatWebPayConfirmInfoByDate(String startDate,String endDate) {
        abstractVOMapper.updatWebPayConfirmInfoByDate(startDate,endDate);
    }
    @Override
    public String updateTimeByExport(List<AbstractVO> customersList, boolean updateSupport) {
        if (StringUtils.isNull(customersList) || customersList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (AbstractVO baseCustomers : customersList)
        {
            try
            {
                abstractVOMapper.updateTimeByExport(baseCustomers);
                successNum++;
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = baseCustomers.getC_pk_id()+"导入失败。";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
