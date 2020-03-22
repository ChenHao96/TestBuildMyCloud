package org.example.business.test;

import org.example.business.model.ServiceResult;
import org.example.business.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Test
    public void purchase() {
        ServiceResult<String> serviceResult = purchaseService.purchase("abc", "123", 10);
        Assert.isTrue(serviceResult.isSuccess(), "购买商品失败!");
    }
}
