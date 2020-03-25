package org.example.business.adaptor;

import org.example.business.dao.OrderMapper;
import org.example.business.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderAdaptorImpl implements OrderAdaptor {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrderRecord(OrderEntity record) {
        return orderMapper.insert(record);
    }
}
