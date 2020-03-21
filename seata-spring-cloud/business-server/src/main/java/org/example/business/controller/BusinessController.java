package org.example.business.controller;

import org.example.business.model.HttpResult;
import org.example.business.model.ServiceResult;
import org.example.business.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/purchase")
    public HttpResult<String> purchase(String userId, String commodityCode, int orderCount) {
        ServiceResult<String> serviceResult = purchaseService.purchase(userId, commodityCode, orderCount);
        if (serviceResult != null && serviceResult.getCode() == 0) {
            return new HttpResult<>(200, "SUCCESS", serviceResult.getData());
        }
        return new HttpResult<>(500, "采购失败，请稍后再试");
    }
}
