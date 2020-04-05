package org.example.business.adaptor;

import org.example.business.dao.OrderMapper;
import org.example.business.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OrderAdaptorImpl implements OrderAdaptor {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public int insertOrderRecord(OrderEntity record) {
        return orderMapper.insert(record);
    }
}
