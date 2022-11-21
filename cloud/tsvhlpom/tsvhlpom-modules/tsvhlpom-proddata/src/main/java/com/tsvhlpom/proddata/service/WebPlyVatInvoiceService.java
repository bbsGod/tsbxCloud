package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;

import java.util.List;

public interface WebPlyVatInvoiceService {
    List<WebPlyVatInvoice> getVatList(String c_ply_no);
    void updateStatus(WebPlyVatInvoice webPlyVatInvoice);
}

