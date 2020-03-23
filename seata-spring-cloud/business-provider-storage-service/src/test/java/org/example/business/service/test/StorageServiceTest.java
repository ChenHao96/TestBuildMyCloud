package org.example.business.service.test;

import org.example.business.service.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StorageServiceTest {

    @Autowired
    private StorageService storageService;

    @Test
    public void testDeduct() {
        boolean success = storageService.deduct("123", 1);
        Assert.isTrue(success, "商品库存扣减失败!");
    }

    @Test
    public void testQueryCommodityMoney() {
        Integer money = storageService.queryCommodityMoney("123");
        Assert.isTrue(money != null, "商品不存在!");
        Assert.isTrue(money == 10, "商品价格不正确!");
    }
}
