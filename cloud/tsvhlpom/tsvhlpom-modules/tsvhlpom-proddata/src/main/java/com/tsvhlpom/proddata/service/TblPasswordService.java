package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.TblPassword;
import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;

import java.util.List;

public interface TblPasswordService {
    List<TblPassword> getTblPasswordList(String c_from_code);
    void update(TblPassword tblPassword);
}
