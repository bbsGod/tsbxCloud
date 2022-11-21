package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.proddata.domain.WebPlyEdrErrLogs;
import com.tsvhlpom.proddata.mapper.WebPlyEdrErrLogsMapper;
import com.tsvhlpom.proddata.service.WebPlyEdrErrLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPlyEdrErrLogsServiceimpl implements WebPlyEdrErrLogsService {

    @Autowired
    private WebPlyEdrErrLogsMapper webPlyEdrErrLogsMapper;
    @Override
    public WebPlyEdrErrLogs getWebPlyEdrErrLogs(String c_pk_id) {
        return webPlyEdrErrLogsMapper.getWebPlyEdrErrLogs(c_pk_id);
    }

    @Override
    public List<WebPlyEdrErrLogs> getWebPlyEdrErrLogsList(WebPlyEdrErrLogs webPlyEdrErrLogs) {
        return webPlyEdrErrLogsMapper.getWebPlyEdrErrLogsList(webPlyEdrErrLogs);
    }

    @Override
    public void update(WebPlyEdrErrLogs webPlyEdrErrLogs) {
        webPlyEdrErrLogsMapper.update(webPlyEdrErrLogs);
    }

    @Override
    public void save(WebPlyEdrErrLogs webPlyEdrErrLogs) {
        webPlyEdrErrLogsMapper.save(webPlyEdrErrLogs);
    }

    @Override
    public int delete(String[] c_pk_ids) {
        return webPlyEdrErrLogsMapper.delete(c_pk_ids);
    }
    @Override
    public String importData(List<WebPlyEdrErrLogs> webPlyEdrErrLogsList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(webPlyEdrErrLogsList) || webPlyEdrErrLogsList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (WebPlyEdrErrLogs webPlyEdrErrLogs : webPlyEdrErrLogsList)
        {
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<WebPlyEdrErrLogs> oldList = webPlyEdrErrLogsMapper.getWebPlyEdrErrLogsList(webPlyEdrErrLogs);
                if (oldList == null || oldList.size() == 0)
                {
                    webPlyEdrErrLogsMapper.save(webPlyEdrErrLogs);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、销管推送失败数据" + webPlyEdrErrLogs.getC_app_no() + " 导入成功");

                }
                else if (updateSupport)
                {
                    webPlyEdrErrLogs.setC_pk_id(oldList.get(0).getC_pk_id());
                    webPlyEdrErrLogsMapper.update(webPlyEdrErrLogs);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、销管推送失败数据" + webPlyEdrErrLogs.getC_app_no() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、销管推送失败数据 " + webPlyEdrErrLogs.getC_app_no() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、销管推送失败数据 " + webPlyEdrErrLogs.getC_app_no() + " 导入失败";
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
