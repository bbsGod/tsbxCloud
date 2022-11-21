package com.tsvhlpom.meetingpreset.service.impl;

import com.tsvhlpom.common.core.exception.ServiceException;
import com.tsvhlpom.common.core.utils.StringUtils;
import com.tsvhlpom.meetingpreset.domain.Person;
import com.tsvhlpom.meetingpreset.mapper.PersonMapper;
import com.tsvhlpom.meetingpreset.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public void save(Person person) {
        personMapper.save(person);
    }

    @Override
    public void update(Person person) {
        personMapper.update(person);
    }

    @Override
    public void delete(String[] pkids) {
        personMapper.delete(pkids);
    }

    @Override
    public Person getPersonById(String pkid) {
        return personMapper.getPersonById(pkid);
    }

    @Override
    public List<Person> getPersonList(Person person) {
        return personMapper.getPersonList(person);
    }

    @Override
    public String importData(List<Person> personList, boolean updateSupport, String operName) throws Exception {
        if (StringUtils.isNull(personList) || personList.size() == 0)
        {
            throw  new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Person person : personList)
        {
            try
            {
                // 根据身份证号验证是否已存在信息'
                List<Person> oldPersonList = personMapper.getPersonList(person);
                if (oldPersonList == null || oldPersonList.size() == 0)
                {
                    personMapper.save(person);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + person.getPerson_name() + " 导入成功");

                }
                else if (updateSupport)
                {
                    person.setPk_id(oldPersonList.get(0).getPk_id());
                    personMapper.update(person);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、员工信息" + person.getPerson_name() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、员工信息 " + person.getPerson_name() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、员工信息 " + person.getPerson_name() + " 导入失败";
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
