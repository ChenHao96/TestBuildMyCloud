package org.example.business.service;

import org.example.business.model.ServiceResult;

public interface PurchaseService  {

    ServiceResult<String> purchase(String userId, String commodityCode, int orderCount);
}
