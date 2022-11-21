package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.domain.WebPolicyXiaoJuErrLogs;
import com.tsvhlpom.proddata.mapper.WebPolicyXiaoJuErrLogsMapper;
import com.tsvhlpom.proddata.service.WebPolicyXiaoJuErrLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPolicyXiaoJuErrLogsServiceImpl implements WebPolicyXiaoJuErrLogsService {

    @Autowired
    private WebPolicyXiaoJuErrLogsMapper mapper;
    @Override
    public String export(List<WebPolicyXiaoJuErrLogs> xiaojuList, boolean updateSupport) {
        if (StringUtils.isNull(xiaojuList) || xiaojuList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WebPolicyXiaoJuErrLogs xiaoju : xiaojuList)
        {
            try
            {
                mapper.save(xiaoju);
                successNum++;
                successMsg.append("<br/>" + successNum + "、 " +xiaoju.getC_app_no()+"导入成功");

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、"+xiaoju.getC_app_no()+" ,导入失败";
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
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条.");
        }
        return successMsg.toString();
    }

}
