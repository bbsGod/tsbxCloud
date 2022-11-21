package com.tsvhlpom.proddata.service.impl;

import com.tsvhlpom.proddata.domain.PortalLbDataNew;
import com.tsvhlpom.proddata.mapper.PortalLbDataNewMapper;
import com.tsvhlpom.proddata.service.PortalLbDataNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortalLbDataNewServiceimpl implements PortalLbDataNewService {
    @Autowired
    private PortalLbDataNewMapper portalLbDataNewMapper;
    @Override
    public PortalLbDataNew getPortalLbDataNew(PortalLbDataNew portalLbDataNew) {
        return portalLbDataNewMapper.getPortalLbDataNew(portalLbDataNew);
    }

    @Override
    public List<PortalLbDataNew> getPortalLbDataNewList(String c_module) {
        return portalLbDataNewMapper.getPortalLbDataNewList(c_module);
    }

    @Override
    public void save(PortalLbDataNew portalLbDataNew) {
        portalLbDataNewMapper.save(portalLbDataNew);
    }

    @Override
    public void update(PortalLbDataNew portalLbDataNew) {
        portalLbDataNewMapper.update(portalLbDataNew);
    }

    @Override
    public int delete(PortalLbDataNew portalLbDataNew) {
        return portalLbDataNewMapper.delete(portalLbDataNew);
    }
}
