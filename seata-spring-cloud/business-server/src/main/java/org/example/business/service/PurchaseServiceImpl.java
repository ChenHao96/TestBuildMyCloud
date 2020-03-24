package org.example.business.service;

import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.example.business.model.Order;
import org.example.business.model.ServiceResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Reference(version = "${service.dubbo.version.storage}", check = false)
    private StorageService storageService;

    @Reference(version = "${service.dubbo.version.order}", check = false)
    private OrderService orderService;

    @Reference(version = "${service.dubbo.version.account}", check = false)
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "dubbo-gts-seata-example")
    public ServiceResult<String> purchase(String userId, String commodityCode, int orderCount) {
        ServiceResult<String> serviceResult = new ServiceResult<>(false, "购买商品失败!");
        boolean deduct = storageService.deduct(commodityCode, orderCount);
        if (deduct) {
            serviceResult.setMsg("创建订单失败!");
            Order order = orderService.create(userId, commodityCode, orderCount);
            if (order != null) {
                serviceResult.setMsg("账户余额不足!");
                if (accountService.debit(userId, order.getTotalMoney())) {
                    serviceResult.setSuccess(true);
                    serviceResult.setMsg("SUCCESS");
                }
            }
        }

        if (!serviceResult.isSuccess()) {
            try {
                GlobalTransactionContext.getCurrentOrCreate().rollback();
            } catch (TransactionException e) {
                log.warn("手动回滚失败!", e);
            }
        }
        return serviceResult;
    }
}
