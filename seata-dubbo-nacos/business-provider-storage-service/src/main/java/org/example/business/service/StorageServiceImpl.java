package org.example.business.service;

import io.seata.spring.annotation.GlobalLock;
import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.StorageAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Service(version = "${service.dubbo.version.storage}")
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageAdaptor storageAdaptor;

    @Override
    public boolean deduct(String commodityCode, int count) {
        if (StringUtils.isEmpty(commodityCode) || count < 1) return false;
        int resultCount = storageAdaptor.updateCommodityBalance(commodityCode, count);
        return resultCount == 1;
    }

    @Override
    @GlobalLock
    public int queryCommodityMoney(String commodityCode) {
        if (StringUtils.isEmpty(commodityCode)) return -1;
        return storageAdaptor.queryCommodityMoney(commodityCode);
    }
}
