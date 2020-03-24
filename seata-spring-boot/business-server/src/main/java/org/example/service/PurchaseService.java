package org.example.service;

import org.example.model.ServiceResult;

public interface PurchaseService {

    ServiceResult<String> purchase(String userId, String commodityCode, int orderCount);
}
