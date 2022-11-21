package com.tsvhlpom.proddata.mapper;

import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;

import java.util.List;

public interface WebPlyVatInvoiceMapper {

    List<WebPlyVatInvoice> getVatList(String c_ply_no);
    void updateStatus(WebPlyVatInvoice webPlyVatInvoice);
}
