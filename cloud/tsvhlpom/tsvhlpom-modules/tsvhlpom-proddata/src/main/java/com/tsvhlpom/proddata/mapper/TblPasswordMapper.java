package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.TblPassword;

import java.util.List;

public interface TblPasswordMapper {
    List<TblPassword> getTblPasswordList(String c_from_code);
    void update(TblPassword tblPassword);
}
