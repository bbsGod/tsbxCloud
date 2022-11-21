package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.domain.WebAppBase;
import com.tsvhlpom.proddata.mapper.WebAppBaseMapper;
import com.tsvhlpom.proddata.service.WebAppBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppBaseServiceimpl implements WebAppBaseService {
    @Autowired
    private WebAppBaseMapper webAppBaseMapper;

    public List<WebAppBase> getWebAppBaseList(WebAppBase webAppBase){
       return webAppBaseMapper.getWebAppBaseList(webAppBase);
    }
    public void update(WebAppBase webAppBase){
        webAppBaseMapper.update(webAppBase);
        System.out.println("webAppBase更新，plyNo= " +webAppBase.getC_ply_no());
        webAppBaseMapper.updatePlyBase(webAppBase);
    }
    public WebAppBase getWebAppBase(String c_ply_no){
        return webAppBaseMapper.getWebAppBase(c_ply_no);
    }

    @Override
    public List<WebAppBase> getAppBaseWithOpeCde(WebAppBase webAppBase) {
        return webAppBaseMapper.getAppBaseWithOpeCde(webAppBase);
    }

    @Override
    public void updateOprCde(String c_app_no) {
        webAppBaseMapper.updateOprCde(c_app_no);
    }
    public String importData(List<WebAppBase> list, boolean updateSupport, String operName) {
        if (StringUtils.isNull(list) || list.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WebAppBase webAppBase : list)
        {
            if(webAppBase.getC_ply_no() == null || "".equals(webAppBase.getC_ply_no())
            || webAppBase.getC_salesman_name() == null || "".equals(webAppBase.getC_salesman_name())
            || webAppBase.getC_cert_salesman_num() == null || "".equals(webAppBase.getC_cert_salesman_num())
            || webAppBase.getC_certificate_name() == null || "".equals(webAppBase.getC_certificate_name())
            || webAppBase.getC_certificate_phone() == null || "".equals(webAppBase.getC_certificate_phone())
            ){
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、中介信息导入，导入的信息不全，请检查");
                continue;
            }
            try
            {
                // 根据身份证号验证是否已存在信息'
                WebAppBase oldWebAppBase = webAppBaseMapper.getWebAppBase(webAppBase.getC_ply_no());
                if (oldWebAppBase == null)
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、中介信息导入 ，保单号‘"+webAppBase.getC_ply_no()+"’不存在，请检查");
                    continue;

                }
                else
                {
                    webAppBaseMapper.update(webAppBase);
                    webAppBaseMapper.updatePlyBase(webAppBase);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、中介信息导入 ，保单号" + webAppBase.getC_ply_no() + " 更新成功");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、中介信息导入，保单号 " + webAppBase.getC_ply_no() + " 导入失败";
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
