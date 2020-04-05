package org.example.business.service;

public interface AccountService {

    /**
     * 服务提供者填写的应用名称 方便消费者订阅服务
     */
    String DUBBO_SERVICE_APPLICATION_NAME = "dubbo-service-application-accountService";

    /**
     * 从用户账户中借出
     */
    Boolean debit(String userId, Integer money);
}
