package org.example.business.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.StorageAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Service(version = "${service.dubbo.version.storage}")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageAdaptor storageAdaptor;

    @Override
    public boolean deduct(String commodityCode, int count) {
        if (StringUtils.isEmpty(commodityCode) || count < 1) return false;
        return storageAdaptor.updateCommodityBalance(commodityCode, count) == 1;
    }

    @Override
    public Integer queryCommodityMoney(String commodityCode) {
        if (StringUtils.isEmpty(commodityCode)) return null;
        return storageAdaptor.queryCommodityMoney(commodityCode);
    }
}
