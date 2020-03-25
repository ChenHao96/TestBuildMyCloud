package org.example.service.test;

import lombok.extern.slf4j.Slf4j;
import org.example.model.ServiceResult;
import org.example.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Test
    public void testPurchase() {
        ServiceResult<String> serviceResult = purchaseService.purchase("abc", "123", 2);
        log.info("result:{}", serviceResult);
        Assert.isTrue(serviceResult.isSuccess(), "购买商品失败!");
    }
}
