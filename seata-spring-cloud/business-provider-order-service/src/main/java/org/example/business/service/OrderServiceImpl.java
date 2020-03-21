package org.example.business.service;

import org.apache.dubbo.config.annotation.Service;
import org.example.business.model.Order;

@Service(version = "${service.dubbo.version.order}")
public class OrderServiceImpl implements OrderService {

    @Override
    public Order create(String userId, String commodityCode, int orderCount) {
        //TODO:
        return null;
    }
}
