package org.example.business.service;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.OrderAdaptor;
import org.example.business.entity.OrderEntity;
import org.example.business.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Component
@Service(version = "${service.dubbo.version.order}")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderAdaptor orderAdaptor;

    @Reference(version = "${service.dubbo.version.storage}", check = false)
    private StorageService storageService;

    @Override
    public Order create(String userId, String commodityCode, int orderCount) {

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(commodityCode) || orderCount < 1) return null;
        int money = storageService.queryCommodityMoney(commodityCode);
        if (money < 0) return null;

        OrderEntity record = new OrderEntity();
        record.setUserId(userId);
        record.setCount(orderCount);
        record.setMoney(money * orderCount);
        record.setCommodityCode(commodityCode);
        int ret = orderAdaptor.insertOrderRecord(record);

        if (ret == 1) {
            Order result = new Order();
            result.setCreateTime(new Date());
            result.setOrderCount(orderCount);
            result.setTotalMoney(record.getMoney());
            result.setOrderNumber(UUID.randomUUID().toString());
            return result;
        }
        return null;
    }
}
