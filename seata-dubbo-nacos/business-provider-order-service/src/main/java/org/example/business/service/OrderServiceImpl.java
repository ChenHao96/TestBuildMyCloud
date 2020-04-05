package org.example.business.service;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.example.business.adaptor.OrderAdaptor;
import org.example.business.entity.OrderEntity;
import org.example.business.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
@Service(version = "${service.dubbo.version.order}")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderAdaptor orderAdaptor;

    @Reference(version = "${service.dubbo.version.storage}", check = false)
    private StorageService storageService;

    private static final int MIN_UPDATE_PARAM_COUNT = 1;
    private static final int INSERT_ORDER_ROW_COUNT = 1;

    @Override
    public Order create(String userId, String commodityCode, Integer orderCount) {

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(commodityCode) || orderCount == null || orderCount < MIN_UPDATE_PARAM_COUNT) {
            return null;
        }

        int money = storageService.queryCommodityMoney(commodityCode);
        if (money < 0) {
            return null;
        }

        OrderEntity record = new OrderEntity();
        record.setUserId(userId);
        record.setCount(orderCount);
        record.setMoney(money * orderCount);
        record.setCommodityCode(commodityCode);
        final int resultCount = orderAdaptor.insertOrderRecord(record);

        if (resultCount == INSERT_ORDER_ROW_COUNT) {

            Order result = new Order();
            result.setOrderCount(orderCount);
            result.setTotalMoney(record.getMoney());
            result.setCreateTime(System.currentTimeMillis());
            result.setOrderNumber(UUID.randomUUID().toString());
            return result;
        }

        return null;
    }
}
