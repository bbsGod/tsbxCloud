package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.TblPassword;
import com.tsvhlpom.proddata.mapper.TblPasswordMapper;
import com.tsvhlpom.proddata.service.TblPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblPasswordServiceimpl implements TblPasswordService {

    @Autowired
    private TblPasswordMapper tblPasswordMapper;
    @Override
    public List<TblPassword> getTblPasswordList(String c_from_code) {
        return tblPasswordMapper.getTblPasswordList(c_from_code);
    }

    @Override
    public void update(TblPassword tblPassword) {
        tblPasswordMapper.update(tblPassword);
    }
}
