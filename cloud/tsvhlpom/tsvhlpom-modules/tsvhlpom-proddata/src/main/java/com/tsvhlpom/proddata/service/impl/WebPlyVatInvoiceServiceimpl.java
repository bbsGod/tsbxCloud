package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.WebPlyVatInvoice;
import com.tsvhlpom.proddata.mapper.WebPlyVatInvoiceMapper;
import com.tsvhlpom.proddata.service.WebPlyVatInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPlyVatInvoiceServiceimpl implements WebPlyVatInvoiceService {

    @Autowired
    private WebPlyVatInvoiceMapper webPlyVatInvoiceMapper;
    @Override
    public List<WebPlyVatInvoice> getVatList(String c_ply_no) {
        return webPlyVatInvoiceMapper.getVatList(c_ply_no);
    }

    @Override
    public void updateStatus(WebPlyVatInvoice webPlyVatInvoice) {
        webPlyVatInvoiceMapper.updateStatus(webPlyVatInvoice);
    }
}
