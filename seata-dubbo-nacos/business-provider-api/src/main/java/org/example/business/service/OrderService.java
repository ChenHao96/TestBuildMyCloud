package org.example.business.service;

import org.example.business.model.Order;

public interface OrderService {

    /**
     * 服务提供者填写的应用名称 方便消费者订阅服务
     */
    String DUBBO_SERVICE_APPLICATION_NAME = "dubbo-service-application-orderService";

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, Integer orderCount);
}
