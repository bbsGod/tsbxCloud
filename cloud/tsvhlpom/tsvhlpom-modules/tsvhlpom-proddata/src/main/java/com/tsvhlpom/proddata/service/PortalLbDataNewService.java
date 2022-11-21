package com.tsvhlpom.proddata.service;

import com.tsvhlpom.proddata.domain.PortalLbDataNew;

import java.util.List;

public interface PortalLbDataNewService {
    PortalLbDataNew getPortalLbDataNew(PortalLbDataNew portalLbDataNew);
    List<PortalLbDataNew> getPortalLbDataNewList(String c_module);
    void save(PortalLbDataNew portalLbDataNew);
    void update(PortalLbDataNew portalLbDataNew);
    int delete(PortalLbDataNew portalLbDataNew);
}
