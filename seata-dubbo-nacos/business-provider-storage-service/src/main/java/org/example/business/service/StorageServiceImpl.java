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

    private static final int MIN_UPDATE_PARAM_COUNT = 1;
    private static final int UPDATE_BALANCE_ROW_COUNT = 1;
    private static final Integer NO_COMMODITY_PRICE = -1;

    @Override
    public Boolean deduct(String commodityCode, Integer count) {
        if (StringUtils.isEmpty(commodityCode) || count == null || count < MIN_UPDATE_PARAM_COUNT) {
            return false;
        }

        final int resultCount = storageAdaptor.updateCommodityBalance(commodityCode, count);
        return resultCount == UPDATE_BALANCE_ROW_COUNT;
    }

    @Override
    @GlobalLock
    public Integer queryCommodityMoney(String commodityCode) {

        if (StringUtils.isEmpty(commodityCode)) {
            return NO_COMMODITY_PRICE;
        }

        return storageAdaptor.queryCommodityMoney(commodityCode);
    }
}
