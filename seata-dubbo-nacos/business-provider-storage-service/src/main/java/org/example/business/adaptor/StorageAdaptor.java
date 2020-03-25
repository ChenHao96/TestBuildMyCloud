package org.example.business.adaptor;

public interface StorageAdaptor {

    int updateCommodityBalance(String commodityCode, int count);

    Integer queryCommodityMoney(String commodityCode);
}
