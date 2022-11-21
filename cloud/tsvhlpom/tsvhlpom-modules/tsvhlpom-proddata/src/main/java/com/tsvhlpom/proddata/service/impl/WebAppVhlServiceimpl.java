package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.proddata.domain.WebAppVhl;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.mapper.WebAppVhlMapper;
import com.tsvhlpom.proddata.service.WebAppVhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppVhlServiceimpl implements WebAppVhlService {

    @Autowired
    private WebAppVhlMapper webAppVhlMapper;
    @Override
    public List<WebAppVhl> getList(WebAppVhl webAppVhl) {
        return webAppVhlMapper.getList(webAppVhl);
    }

    @Override
    public WebAppVhl getAppVhl(String c_app_no) {
        return webAppVhlMapper.getAppVhl(c_app_no);
    }

    @Override
    public void update(WebAppVhl webAppVhl) {
        webAppVhlMapper.update(webAppVhl);
        webAppVhlMapper.updateply(webAppVhl);
    }

    public void updatePrint(WebAppVhl webAppVhl) {
        webAppVhlMapper.updatePrint(webAppVhl);
        webAppVhlMapper.updatePlyPrint(webAppVhl);
    }

    public String importData(List<WebAppVhl> list, boolean updateSupport, String operName) {
        if (StringUtils.isNull(list) || list.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WebAppVhl webAppVhl : list)
        {
            WebAppVhl oldAppVhl =  webAppVhlMapper.getAppVhl(webAppVhl.getC_app_no());
            if(oldAppVhl == null){
                failureNum++;
                String msg = "<br/>" + failureNum + "、江苏燃料种类导入，投保单号 " + webAppVhl.getC_app_no() + " 不存在，请检查";
                failureMsg.append(msg);
                continue;
            }
            try
            {
                webAppVhlMapper.update(webAppVhl);
                webAppVhlMapper.updateply(webAppVhl);
                successNum++;
                successMsg.append("<br/>" + successNum + "、江苏燃料种类导入 ，投保单号" + webAppVhl.getC_app_no() + " 更新成功");
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、江苏燃料种类导入，投保单号 " + webAppVhl.getC_app_no() + " 导入失败";
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
